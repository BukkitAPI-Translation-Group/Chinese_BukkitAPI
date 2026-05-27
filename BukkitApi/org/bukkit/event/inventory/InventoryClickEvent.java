package org.bukkit.event.inventory;

import org.bukkit.Location;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当玩家点击物品栏中的格子时触发事件事件.<br>
 * 译注：事实上打开任意容器的物品栏(包括玩家的背包)后点击任何一个地方都会触发这个事件。
 * <p>
 * 由于{@link InventoryClickEvent}是通过修改{@link org.bukkit.inventory.Inventory 物品栏}
 * 的实现类来触发的，所以并非所有与{@link org.bukkit.inventory.Inventory 物品栏}相关的方法都是安全的。
 * <p>
 * 下面这些属于{@link HumanEntity}和 {@link InventoryView}的方法不应该被处理
 * {@link InventoryClickEvent}事件的 {@link org.bukkit.event.EventHandler 事件处理器}调用
 * <ul>
 * <li>{@link HumanEntity#closeInventory()}
 * <li>{@link HumanEntity#openInventory(Inventory)}
 * <li>{@link HumanEntity#openWorkbench(Location, boolean)}
 * <li>{@link HumanEntity#openEnchanting(Location, boolean)}
 * <li>{@link InventoryView#close()}
 * </ul>
 * 如果一定要调用这些方法，请使用 {@link BukkitScheduler#runTask(Plugin, Runnable)}来执行
 * ，这个方法将在下一个tick执行你的任务。<br>
 * 注意：上面列出来的这些方法并不全，可能还有其它的方法也存在问题。
 * <p>
 * 假设与此事件关联的 EntityHuman 是一个 Player 实例，那么操作物品栏的最大堆叠数量或内容
 * 将需要调用 {@link Player#updateInventory()}。
 * <p>
 * 对此 InventoryClickEvent 结果所修改的格子的更改可能会被覆盖。要更改这些格子，
 * 应取消此事件并应用所有对物品栏的期望更改。
 * 或者，使用 {@link BukkitScheduler#runTask(Plugin, Runnable)} 调度一个任务
 * 也可以实现，该方法将在下一个 tick 执行你的任务。
 */
public class InventoryClickEvent extends InventoryInteractEvent {

    private static final HandlerList handlers  = new HandlerList();
    private final ClickType          click;
    private final InventoryAction    action;
    private SlotType                 slot_type;
    private int                      whichSlot;
    private int                      rawSlot;
    private ItemStack                current   = null;
    private int                      hotbarKey = -1;

    public InventoryClickEvent(@NotNull InventoryView view, @NotNull SlotType type, int slot, @NotNull ClickType click, @NotNull InventoryAction action) {
        super(view);
        this.slot_type = type;
        this.rawSlot = slot;
        this.whichSlot = view.convertSlot(slot);
        this.click = click;
        this.action = action;
    }

    public InventoryClickEvent(@NotNull InventoryView view, @NotNull SlotType type, int slot, @NotNull ClickType click, @NotNull InventoryAction action, int key) {
        this(view, type, slot, click, action);
        this.hotbarKey = key;
    }

    /**
     * 获取被点击的格子的类型.
     * <p>
     * 原文:Gets the type of slot that was clicked.
     *
     * @return 格子类型
     */
    @NotNull
    public SlotType getSlotType() {
        return slot_type;
    }

    /**
     * 获取被光标所拿起来的物品
     * <p>
     * 原文:Gets the current ItemStack on the cursor.
     *
     * @return 被光标所拿起来的物品
     */
    @Nullable
    public ItemStack getCursor() {
        return getView().getCursor();
    }

    /**
     * 获取被点击的格子的物品
     * <p>
     * 原文:Gets the ItemStack currently in the clicked slot.
     *
     * @return 被点击的物品
     */
    @Nullable
    public ItemStack getCurrentItem() {
        if (slot_type == SlotType.OUTSIDE) {
            return current;
        }
        return getView().getItem(rawSlot);
    }

    /**
     * 获取是否右击背包
     * <p>
     * 原文:
     * Gets whether or not the ClickType for this event represents a right
     * click.
     *
     * @return 是否右击背包
     * @see ClickType#isRightClick()
     */
    public boolean isRightClick() {
        return click.isRightClick();
    }

    /**
     * 获取是否左击背包
     * <p>
     * 原文:Gets whether or not the ClickType for this event represents a left click.
     *
     * @return 是否左击背包
     * @see ClickType#isLeftClick()
     */
    public boolean isLeftClick() {
        return click.isLeftClick();
    }

    /**
     * 获取是否按住shift点击背包
     * <p>
     * 原文:Gets whether the ClickType for this event indicates that the key was
     * pressed down when the click was made.
     *
     * @return 是否使用Shift或Ctrl按键
     * @see ClickType#isShiftClick()
     */
    public boolean isShiftClick() {
        return click.isShiftClick();
    }

    /**
     * 设置光标上的物品.
     * <p>
     * 原文：Sets the item on the cursor.
     *
     * @param stack 新的光标物品
     * @deprecated 这会在对物品栏应用任何计算之前更改他们手中的 ItemStack，
     *             这往往会导致玩家与服务器之间的不一致，
     *             并对被点击的物品栏的行为产生意外更改。
     */
    @Deprecated(since = "1.5.2")
    public void setCursor(@Nullable ItemStack stack) {
        getView().setCursor(stack);
    }

    /**
     * 设置被点击格子中的物品.
     * <p>
     * 原文：Sets the ItemStack currently in the clicked slot.
     *
     * @param stack 要放入当前格子的物品
     */
    public void setCurrentItem(@Nullable ItemStack stack) {
        if (slot_type == SlotType.OUTSIDE) {
            current = stack;
        } else {
            getView().setItem(rawSlot, stack);
        }
    }

    /**
     * 获取被点击格子对应的物品栏.
     * <p>
     * 原文：Gets the inventory corresponding to the clicked slot.
     *
     * @return 物品栏，如果点击了外部则为 null
     * @see InventoryView#getInventory(int)
     */
    @Nullable
    public Inventory getClickedInventory() {
        return getView().getInventory(rawSlot);
    }

    /**
     * 返回点击的格子序号，可传递给{@link Inventory#getItem(int)}。注意由于连接两个不同背包的视图，可能两个格子都是同一个格子序号
     * <p>
     * 原文:The slot number that was clicked, ready for passing to
     * {@link Inventory#getItem(int)}. Note that there may be two slots with the
     * same slot number, since a view links two different inventories.
     *
     * @return 格子序号
     */
    public int getSlot() {
        return whichSlot;
    }

    /**
     * 返回点击的原始格子序号，可传递给{@link InventoryView #getItem(int)}。这个序号对每个视图是唯一的。
     * <p>
     * 原文:The raw slot number clicked, ready for passing to
     * {@link InventoryView #getItem(int)} This slot number is unique for the
     * view.
     *
     * @return 格子序号
     */
    public int getRawSlot() {
        return rawSlot;
    }

    /**
     * 如果ClickType是NUMVER_KEY（按下数字切换物品），这个方法将返回按下的键的索引（0-8）
     * <p>
     * 原文:If the ClickType is NUMBER_KEY, this method will return the index of the
     * pressed key (0-8).
     *
     * @return 按下的数字减1（范围0-8），如果不是NUMBER_KEY动作为-1
     */
    public int getHotbarButton() {
        return hotbarKey;
    }

    /**
     * 获取触发此事件的 InventoryAction.
     * <p>
     * 此操作无法更改，它代表此事件的正常结果。
     * 要更改此 InventoryClickEvent 的行为，必须手动应用更改。
     * <p>
     * 原文：Gets the InventoryAction that triggered this event.
     * <p>
     * This action cannot be changed, and represents what the normal outcome of
     * the event will be. To change the behavior of this InventoryClickEvent,
     * changes must be manually applied.
     *
     * @return 触发此事件的 InventoryAction
     */
    @NotNull
    public InventoryAction getAction() {
        return action;
    }

    /**
     * 获取本事件的ClickType.
     * <p>
     * 获取到的结果与其它插件对其的改动相隔离.
     * <p>
     * 原文:Gets the ClickType for this event.
     * <p>
     * This is insulated against changes to the inventory by other plugins.
     *
     * @return 背包点击类型
     */
    @NotNull
    public ClickType getClick() {
        return click;
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
