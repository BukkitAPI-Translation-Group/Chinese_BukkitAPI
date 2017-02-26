package org.bukkit.event.inventory;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.plugin.Plugin;

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
 * Assuming the EntityHuman associated with this event is an instance of a
 * Player, manipulating the MaxStackSize or contents of an Inventory will
 * require an Invocation of {@link Player#updateInventory()}.
 * <p>
 * Modifications to slots that are modified by the results of this
 * InventoryClickEvent can be overwritten. To change these slots, this event
 * should be cancelled and all desired changes to the inventory applied.
 * Alternatively, scheduling a task using
 * {@link BukkitScheduler#runTask( Plugin, Runnable)}, which would execute the
 * task on the next tick, would work as well.
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

    public InventoryClickEvent(InventoryView view, SlotType type, int slot, ClickType click, InventoryAction action) {
        super(view);
        this.slot_type = type;
        this.rawSlot = slot;
        this.whichSlot = view.convertSlot(slot);
        this.click = click;
        this.action = action;
    }

    public InventoryClickEvent(InventoryView view, SlotType type, int slot, ClickType click, InventoryAction action, int key) {
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
    public SlotType getSlotType() {
        return slot_type;
    }

    /**
     * 获取当前光标所指的物品
     * <p>
     * 原文:Gets the current ItemStack on the cursor.
     *
     * @return 光标上的物品
     */
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
     * Sets the item on the cursor.
     *
     * @param stack
     *            the new cursor item
     * @deprecated This changes the ItemStack in their hand before any
     *             calculations are applied to the Inventory, which has a
     *             tendency to create inconsistencies between the Player and the
     *             server, and to make unexpected changes in the behavior of the
     *             clicked Inventory.
     */
    @Deprecated
    public void setCursor(ItemStack stack) {
        getView().setCursor(stack);
    }

    /**
     * Sets the ItemStack currently in the clicked slot.
     *
     * @param stack
     *            the item to be placed in the current slot
     */
    public void setCurrentItem(ItemStack stack) {
        if (slot_type == SlotType.OUTSIDE) {
            current = stack;
        } else {
            getView().setItem(rawSlot, stack);
        }
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
     * Gets the InventoryAction that triggered this event.
     * <p>
     * This action cannot be changed, and represents what the normal outcome of
     * the event will be. To change the behavior of this InventoryClickEvent,
     * changes must be manually applied.
     *
     * @return the InventoryAction that triggered this event.
     */
    public InventoryAction getAction() {
        return action;
    }

    /**
     * 获取本事件的ClickType.
     * <p>
     * ???????????????
     * <p>
     * 原文:Gets the ClickType for this event.
     * <p>
     * This is insulated against changes to the inventory by other plugins.
     *
     * @return 背包点击类型
     */
    public ClickType getClick() {
        return click;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}