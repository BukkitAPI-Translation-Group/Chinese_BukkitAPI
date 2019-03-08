package org.bukkit.event.player;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

/**
 * 当玩家对一个对象或空气进行交互时触发本事件.
 * <p>
 * 无论玩家使用的是左手还是右手, 都有可能分别触发本事件. 你可以使用 {@link #getHand()} 方法来确定玩家使用的是哪只手.
 * <p>
 * 如果是原版行为触发了本事件, 则本事件将会被取消(例如与空气进行交互).
 * For the purpose of avoiding doubt, this means
 * that the event will only be in the cancelled state if it is fired as a result
 * of some prediction made by the server where no subsequent code will run,
 * rather than when the subsequent interaction activity (e.g. placing a block in
 * an illegal position ({@link BlockCanBuildEvent}) will fail.
 * <p>
 * 原文:Represents an event that is called when a player interacts with an object or
 * air, potentially fired once for each hand. The hand can be determined using
 * {@link #getHand()}.
 * <p>
 * This event will fire as cancelled if the vanilla behavior is to do nothing
 * (e.g interacting with air). For the purpose of avoiding doubt, this means
 * that the event will only be in the cancelled state if it is fired as a result
 * of some prediction made by the server where no subsequent code will run,
 * rather than when the subsequent interaction activity (e.g. placing a block in
 * an illegal position ({@link BlockCanBuildEvent}) will fail.
 */
public class PlayerInteractEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    protected ItemStack item;
    protected Action action;
    protected Block blockClicked;
    protected BlockFace blockFace;
    private Result useClickedBlock;
    private Result useItemInHand;
    private EquipmentSlot hand;

    public PlayerInteractEvent(final Player who, final Action action, final ItemStack item, final Block clickedBlock, final BlockFace clickedFace) {
        this(who, action, item, clickedBlock, clickedFace, EquipmentSlot.HAND);
    }

    public PlayerInteractEvent(final Player who, final Action action, final ItemStack item, final Block clickedBlock, final BlockFace clickedFace, final EquipmentSlot hand) {
        super(who);
        this.action = action;
        this.item = item;
        this.blockClicked = clickedBlock;
        this.blockFace = clickedFace;
        this.hand = hand;

        useItemInHand = Result.DEFAULT;
        useClickedBlock = clickedBlock == null ? Result.DENY : Result.ALLOW;
    }

    /**
     * 获取本次交互的动作类型.
     * <p>
     * 原文:Returns the action type
     *
     * @return Action 返回交互的动作类型
     */
    public Action getAction() {
        return action;
    }

    /**
     * 获取这个事件是否被取消.
     * 如果你想防止通过水桶放水等操作, 则可以取消这个事件.
     * <p>
     * 原文:Gets the cancellation state of this event. Set to true if you want to
     * prevent buckets from placing water and so forth
     *
     * @return boolean 取消状态
     */
    public boolean isCancelled() {
        return useInteractedBlock() == Result.DENY;
    }

    /**
     * 取消这个事件. 一个被取消的事件不会在
     * 服务器里被执行，但是仍然会传递事件到其他插件.
     * <p>
     * 取消本事件将阻止玩家食用食物(玩家不会失去食物), 阻止弓箭/雪球/蛋的发射等(玩家不会失去弹药).
     * <p>
     * 原文:Sets the cancellation state of this event. A canceled event will not be
     * executed in the server, but will still pass to other plugins
     * <p>
     * Canceling this event will prevent use of food (player won't lose the
     * food item), prevent bows/snowballs/eggs from firing, etc. (player won't
     * lose the ammo)
     *
     * @param cancel 设置为 true 时将会阻止本事件触发
     */
    public void setCancelled(boolean cancel) {
        setUseInteractedBlock(cancel ? Result.DENY : useInteractedBlock() == Result.DENY ? Result.DEFAULT : useInteractedBlock());
        setUseItemInHand(cancel ? Result.DENY : useItemInHand() == Result.DENY ? Result.DEFAULT : useItemInHand());
    }

    /**
     * 获取玩家手中的物品, 手中未拿物品时会返回null.
     * <p>
     * 原文:Returns the item in hand represented by this event
     *
     * @return ItemStack 使用的物品
     */
    public ItemStack getItem() {
        return this.item;
    }

    /**
     * 返回玩家所用物品的材质 (相当于getItem()后再getMateria(),但更简便一些).
     * <p>
     * 原文:Convenience method. Returns the material of the item represented by
     * this event
     *
     * @return Material 所用物品的材质
     */
    public Material getMaterial() {
        if (!hasItem()) {
            return Material.AIR;
        }

        return item.getType();
    }

    /**
     * 检查交互事件是否涉及方块(与方块交互、放置方块等).
     * <p>
     * 原文:Check if this event involved a block
     *
     * @return boolean 如果涉及到则返回true
     */
    public boolean hasBlock() {
        return this.blockClicked != null;
    }

    /**
     * 检查玩家交互时是否手拿物品或与物品交互/交互是否涉及到物品.
     * <p>
     * 猜测(译注):只要不是与空气交互一般都会返回一个物品?等待验证.
     * <p>
     * 原文:Check if this event involved an item
     *
     * @return boolean 如果涉及到则返回true
     */
    public boolean hasItem() {
        return this.item != null;
    }

    /**
     * 判断本次交互事件是否为方块放置事件 (由玩家放置方块引起的交互事件).
     * <p>
     * 原文:Convenience method to inform the user whether this was a block
     * placement event.
     *
     * @return boolean 如果玩家交互时手拿方块,返回true
     */
    public boolean isBlockInHand() {
        if (!hasItem()) {
            return false;
        }

        return item.getType().isBlock();
    }

    /**
     * 返回被点击的方块.
     * <p>
     * 原文:Returns the clicked block
     *
     * @return Block 被点击的方块
     */
    public Block getClickedBlock() {
        return blockClicked;
    }

    /**
     * 返回被点击的方块的朝向.
     * <p>
     * Returns the face of the block that was clicked
     *
     * @return BlockFace 被点击的方块的朝向
     */
    public BlockFace getBlockFace() {
        return blockFace;
    }

    /**
     * 获取(控制见对应set方法)对被交互的方块采取的动作(如果有).
     * 任意方块都能触发本事件, 不过大部分情况下都没有默认动作.
     * <p>
     * 原文:This controls the action to take with the block (if any) that was
     * clicked on. This event gets processed for all blocks, but most don't
     * have a default action
     *
     * @return 对被交互的方块采取的动作
     */
    public Result useInteractedBlock() {
        return useClickedBlock;
    }

    /**
     * @param useInteractedBlock 对被交互的方块采取的动作
     */
    public void setUseInteractedBlock(Result useInteractedBlock) {
        this.useClickedBlock = useInteractedBlock;
    }

    /**
     * 获取(控制见下一个方法)对玩家手持的物品采取的动作/行动.
     * 同时包含方块和物品(如打火石、铁锭或唱片).
     * 当其动作被设为默认值, 如果未对玩家所交互的方块采取行动, 此交互动作将被允许.
     * <p>
     * 原文:This controls the action to take with the item the player is holding.
     * This includes both blocks and items (such as flint and steel or
     * records). When this is set to default, it will be allowed if no action
     * is taken on the interacted block.
     *
     * @return 对玩家手持的物品采取的动作(the action to take with the item in hand)
     */
    public Result useItemInHand() {
        return useItemInHand;
    }

    /**
     * @param useItemInHand 对玩家手持的物品采取的动作(the action to take with the item in hand)
     */
    public void setUseItemInHand(Result useItemInHand) {
        this.useItemInHand = useItemInHand;
    }

    /**
     * 获取用来进行本次交互的手, 但当玩家的交互动作类型为 {@link Action#PHYSICAL} 时可能为空.
     * <p>
     * 原文:The hand used to perform this interaction. May be null in the case of
     * {@link Action#PHYSICAL}.
     *
     * @return 用来交互的手, 可能为null
     */
    public EquipmentSlot getHand() {
        return hand;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
