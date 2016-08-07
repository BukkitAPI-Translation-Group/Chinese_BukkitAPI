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

    @Deprecated
    public InventoryClickEvent(InventoryView view, SlotType type, int slot, boolean right, boolean shift) {
        this(view, type, slot, right ? (shift ? ClickType.SHIFT_RIGHT : ClickType.RIGHT) : (shift ? ClickType.SHIFT_LEFT : ClickType.LEFT), InventoryAction.SWAP_WITH_CURSOR);
    }

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
     * Gets the type of slot that was clicked.
     *
     * @return the slot type
     */
    public SlotType getSlotType() {
        return slot_type;
    }

    /**
     * Gets the current ItemStack on the cursor.
     *
     * @return the cursor ItemStack
     */
    public ItemStack getCursor() {
        return getView().getCursor();
    }

    /**
     * Gets the ItemStack currently in the clicked slot.
     *
     * @return the item in the clicked
     */
    public ItemStack getCurrentItem() {
        if (slot_type == SlotType.OUTSIDE) {
            return current;
        }
        return getView().getItem(rawSlot);
    }

    /**
     * Gets whether or not the ClickType for this event represents a right
     * click.
     *
     * @return true if the ClickType uses the right mouse button.
     * @see ClickType#isRightClick()
     */
    public boolean isRightClick() {
        return click.isRightClick();
    }

    /**
     * Gets whether or not the ClickType for this event represents a left click.
     *
     * @return true if the ClickType uses the left mouse button.
     * @see ClickType#isLeftClick()
     */
    public boolean isLeftClick() {
        return click.isLeftClick();
    }

    /**
     * Gets whether the ClickType for this event indicates that the key was
     * pressed down when the click was made.
     *
     * @return true if the ClickType uses Shift or Ctrl.
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
     * The slot number that was clicked, ready for passing to
     * {@link Inventory#getItem(int)}. Note that there may be two slots with the
     * same slot number, since a view links two different inventories.
     *
     * @return The slot number.
     */
    public int getSlot() {
        return whichSlot;
    }

    /**
     * The raw slot number clicked, ready for passing to
     * {@link InventoryView #getItem(int)} This slot number is unique for the
     * view.
     *
     * @return the slot number
     */
    public int getRawSlot() {
        return rawSlot;
    }

    /**
     * If the ClickType is NUMBER_KEY, this method will return the index of the
     * pressed key (0-8).
     *
     * @return the number on the key minus 1 (range 0-8); or -1 if not a
     *         NUMBER_KEY action
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
     * Gets the ClickType for this event.
     * <p>
     * This is insulated against changes to the inventory by other plugins.
     *
     * @return the type of inventory click
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
