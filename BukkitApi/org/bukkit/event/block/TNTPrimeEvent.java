package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当世界中的 TNT 方块被激活时触发.
 * <p>
 * 如果 TNT 激活事件被取消，TNT 方块将不会被激活.
 */
public class TNTPrimeEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final PrimeCause igniteCause;
    private final Entity primingEntity;
    private final Block primingBlock;

    public TNTPrimeEvent(@NotNull final Block block, @NotNull final PrimeCause igniteCause, @Nullable final Entity primingEntity, @Nullable final Block primingBlock) {
        super(block);
        this.igniteCause = igniteCause;
        this.primingEntity = primingEntity;
        this.primingBlock = primingBlock;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    /**
     * 获取 TNT 被激活的原因.
     *
     * 原文：
     * Get the cause of the TNT becoming primed.
     *
     * @return 原因
     */
    @NotNull
    public PrimeCause getCause() {
        return igniteCause;
    }

    /**
     * 获取导致 TNT 被激活的实体.
     *
     * 原文：
     * Get the entity that caused the TNT to be primed.
     *
     * @return 导致 TNT 被激活的实体，如果不是由实体导致的则返回 null
     */
    @Nullable
    public Entity getPrimingEntity() {
        return primingEntity;
    }

    /**
     * 获取导致 TNT 被激活的方块.
     *
     * 原文：
     * Get the block that caused the TNT to be primed.
     *
     * @return 导致 TNT 被激活的方块，如果不是由方块导致的则返回 null
     */
    @Nullable
    public Block getPrimingBlock() {
        return primingBlock;
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

    /**
     * 表示 TNT 方块被激活原因的枚举.
     */
    public enum PrimeCause {

        /**
         * 当 TNT 因火势蔓延而被激活时.
         */
        FIRE,
        /**
         * 当 TNT 因红石信号而被激活时.
         */
        REDSTONE,
        /**
         * 当 TNT 被玩家直接交互而激活时.
         */
        PLAYER,
        /**
         * 当 TNT 因附近爆炸而被激活时.
         */
        EXPLOSION,
        /**
         * 当 TNT 被燃烧的投射物击中而激活时.
         */
        PROJECTILE,
        /**
         * 当不稳定方块状态设置为 true 的 TNT 被破坏时.
         * <p>
         * 注意：取消此原因导致的激活事件将阻止激活的 TNT 生成，但不会阻止方块被破坏.
         */
        BLOCK_BREAK,
        /**
         * 当 TNT 被持有打火石的发射器激活时.
         * <p>
         * 注意：发射器直接发射 TNT 时不会触发此事件.
         */
        DISPENSER;
    }
}
