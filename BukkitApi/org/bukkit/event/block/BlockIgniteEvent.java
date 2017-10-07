package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当一个方块被点燃时触发.
 * <p>
 * 若要判断玩家是否放了个火方块,请看{@link BlockPlaceEvent}.
 * <p>
 * 若本事件被取消，方块将不会被点燃
 */
public class BlockIgniteEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final IgniteCause cause;
    private final Entity ignitingEntity;
    private final Block ignitingBlock;
    private boolean cancel;

    public BlockIgniteEvent(final Block theBlock, final IgniteCause cause, final Entity ignitingEntity) {
        this(theBlock, cause, ignitingEntity, null);
    }

    public BlockIgniteEvent(final Block theBlock, final IgniteCause cause, final Block ignitingBlock) {
        this(theBlock, cause, null, ignitingBlock);
    }

    public BlockIgniteEvent(final Block theBlock, final IgniteCause cause, final Entity ignitingEntity, final Block ignitingBlock) {
        super(theBlock);
        this.cause = cause;
        this.ignitingEntity = ignitingEntity;
        this.ignitingBlock = ignitingBlock;
        this.cancel = false;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * 获取点燃方块的原因.
     * <p>
     * 原文：Gets the cause of block ignite.
     *
     * @return 点燃方块的原因
     */
    public IgniteCause getCause() {
        return cause;
    }

    /**
     * 获取点燃方块的玩家,如果不是玩家点燃的就返回null.
     * <p>
     * 原文：Gets the player who ignited this block
     *
     * @return 点燃方块/放置火方块的玩家，如果不是玩家点燃的返回null
     */
    public Player getPlayer() {
        if (ignitingEntity instanceof Player) {
            return (Player) ignitingEntity;
        }

        return null;
    }

    /**
     * 获取点燃方块的实体.
     * <p>
     * 原文：Gets the entity which ignited this block
     *
     * @return 点燃方块的实体，如果不是实体点燃的返回null
     */
    public Entity getIgnitingEntity() {
        return ignitingEntity;
    }

    /**
     * 获取点燃方块的方块.
     * <p>
     * 原文：Gets the block who ignited this block.
     *
     * @return 点燃方块的方块,如果不是方块点燃的返回null
     */
    public Block getIgnitingBlock() {
        return ignitingBlock;
    }

    /**
     * 枚举：方块被点燃的原因
     */
    public enum IgniteCause {

        /**
         * 方块被岩浆点燃
         */
        LAVA,
        /**
         * 方块被发射器/玩家使用打火石点燃
         */
        FLINT_AND_STEEL,
        /**
         * 方块被蔓延的点燃
         */
        SPREAD,
        /**
         * 方块被闪电点燃
         */
        LIGHTNING,
        /**
         * 方块被火球点燃
         */
        FIREBALL,
        /**
         * 方块被末影水晶点燃
         */
        ENDER_CRYSTAL,
        /**
         * 方块被爆炸点燃
         */
        EXPLOSION,
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}