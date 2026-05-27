package org.bukkit.event.inventory;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.bukkit.Location;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当玩家在物品栏中拖拽光标中的物品时调用此事件。ItemStack 将分布在 HumanEntity 拖拽过的槽位上。分布方式由 {@link #getType()} 返回的 DragType 描述。
 * <p>
 * 取消此事件将导致 {@link #getNewItems()} 中描述的更改都不会应用到物品栏。
 * <p>
 * 由于 InventoryDragEvent 发生在物品栏修改期间，并非所有与物品栏相关的方法都可以安全使用。
 * <p>
 * 以下方法绝不应该由 InventoryDragEvent 的事件处理器使用与此事件关联的 HumanEntity 或 InventoryView 来调用。
 * <ul>
 * <li>{@link HumanEntity#closeInventory()}
 * <li>{@link HumanEntity#openInventory(Inventory)}
 * <li>{@link HumanEntity#openWorkbench(Location, boolean)}
 * <li>{@link HumanEntity#openEnchanting(Location, boolean)}
 * <li>{@link InventoryView#close()}
 * </ul>
 * 要调用这些方法之一，请使用 {@link BukkitScheduler#runTask(Plugin, Runnable)} 安排任务，该任务将在下一个游戏刻运行。另请注意，此列表并非详尽无遗，其他方法也可能导致问题。
 * <p>
 * 假设与此事件关联的 EntityHuman 是 Player 的实例，则操作物品栏的最大堆叠大小或内容将需要调用 {@link Player#updateInventory()}。
 * <p>
 * 对由此 InventoryDragEvent 结果修改的槽位的任何更改都将被覆盖。要更改这些槽位，应取消此事件并应用更改。或者，使用 {@link BukkitScheduler#runTask(Plugin, Runnable)} 安排任务，该任务将在下一个游戏刻执行，也可以实现。
 */
public class InventoryDragEvent extends InventoryInteractEvent {
    private static final HandlerList handlers = new HandlerList();
    private final DragType type;
    private final Map<Integer, ItemStack> addedItems;
    private final Set<Integer> containerSlots;
    private final ItemStack oldCursor;
    private ItemStack newCursor;

    public InventoryDragEvent(@NotNull InventoryView what, @Nullable ItemStack newCursor, @NotNull ItemStack oldCursor, boolean right, @NotNull Map<Integer, ItemStack> slots) {
        super(what);

        Preconditions.checkArgument(oldCursor != null);
        Preconditions.checkArgument(slots != null);

        type = right ? DragType.SINGLE : DragType.EVEN;
        this.newCursor = newCursor;
        this.oldCursor = oldCursor;
        this.addedItems = slots;
        ImmutableSet.Builder<Integer> b = ImmutableSet.builder();
        for (Integer slot : slots.keySet()) {
            b.add(what.convertSlot(slot));
        }
        this.containerSlots = b.build();
    }

    /**
     * 获取此次拖拽中将添加到物品栏的所有物品。
     *
     * @return 从原始槽位 ID 到新 ItemStack 的映射
     * <p>原文：Gets all items to be added to the inventory in this drag.
     */
    @NotNull
    public Map<Integer, ItemStack> getNewItems() {
        return Collections.unmodifiableMap(addedItems);
    }

    /**
     * 获取此次拖拽中将被更改的原始槽位 ID。
     *
     * @return 原始槽位 ID 列表，适用于 getView().getItem(int)
     * <p>原文：Gets the raw slot ids to be changed in this drag.
     */
    @NotNull
    public Set<Integer> getRawSlots() {
        return addedItems.keySet();
    }

    /**
     * 获取此次拖拽中将被更改的槽位。
     *
     * @return 转换后的槽位 ID 列表，适用于 {@link
     *     org.bukkit.inventory.Inventory#getItem(int)}。
     * <p>原文：Gets the slots to be changed in this drag.
     */
    @NotNull
    public Set<Integer> getInventorySlots() {
        return containerSlots;
    }

    /**
     * 获取拖拽完成后的结果光标。返回值是可变的。
     *
     * @return 结果光标
     * <p>原文：Gets the result cursor after the drag is done. The returned value is
     * mutable.
     */
    @Nullable
    public ItemStack getCursor() {
        return newCursor;
    }

    /**
     * 设置拖拽完成后的结果光标。
     * <p>
     * 更改此物品堆栈会更改光标物品。请注意，更改受影响的"拖拽"槽位不会更改此 ItemStack，更改此 ItemStack 也不会影响"拖拽"槽位。
     *
     * @param newCursor 新的光标 ItemStack
     * <p>原文：Sets the result cursor after the drag is done.
     * <p>
     * Changing this item stack changes the cursor item. Note that changing
     * the affected "dragged" slots does not change this ItemStack, nor does
     * changing this ItemStack affect the "dragged" slots.
     */
    public void setCursor(@Nullable ItemStack newCursor) {
        this.newCursor = newCursor;
    }

    /**
     * 获取一个 ItemStack，表示在此拖拽导致任何修改之前的光标。
     *
     * @return 原始光标
     * <p>原文：Gets an ItemStack representing the cursor prior to any modifications
     * as a result of this drag.
     */
    @NotNull
    public ItemStack getOldCursor() {
        return oldCursor.clone();
    }

    /**
     * 获取描述此 InventoryDragEvent 之后放置的 ItemStack 行为的 DragType。
     * <p>
     * 可以使用 {@link #getNewItems()} 找到 ItemStack 及其应用的原始槽位。
     *
     * @return 此 InventoryDragEvent 的 DragType
     * <p>原文：Gets the DragType that describes the behavior of ItemStacks placed
     * after this InventoryDragEvent.
     * <p>
     * The ItemStacks and the raw slots that they're being applied to can be
     * found using {@link #getNewItems()}.
     */
    @NotNull
    public DragType getType() {
        return type;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
