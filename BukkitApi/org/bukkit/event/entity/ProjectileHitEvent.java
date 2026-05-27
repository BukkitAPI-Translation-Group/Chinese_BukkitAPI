package org.bukkit.event.entity;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Projectile;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当弹射物命中物体时调用。
 */
public class ProjectileHitEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Entity hitEntity;
    private final Block hitBlock;
    private final BlockFace hitFace;
    private boolean cancel = false;

    public ProjectileHitEvent(@NotNull final Projectile projectile) {
        this(projectile, null, null);
    }

    public ProjectileHitEvent(@NotNull final Projectile projectile, @Nullable Entity hitEntity) {
        this(projectile, hitEntity, null);
    }

    public ProjectileHitEvent(@NotNull final Projectile projectile, @Nullable Block hitBlock) {
        this(projectile, null, hitBlock);
    }

    public ProjectileHitEvent(@NotNull final Projectile projectile, @Nullable Entity hitEntity, @Nullable Block hitBlock) {
        this(projectile, hitEntity, hitBlock, null);
    }

    public ProjectileHitEvent(@NotNull final Projectile projectile, @Nullable Entity hitEntity, @Nullable Block hitBlock, @Nullable BlockFace hitFace) {
        super(projectile);
        this.hitEntity = hitEntity;
        this.hitBlock = hitBlock;
        this.hitFace = hitFace;
    }

    @NotNull
    @Override
    public Projectile getEntity() {
        return (Projectile) entity;
    }

    /**
     * 获取被命中的方块（如果命中方块）。
     * <p>
     * 原文：
     * Gets the block that was hit, if it was a block that was hit.
     *
     * @return 被命中的方块，否则返回 null
     */
    @Nullable
    public Block getHitBlock() {
        return hitBlock;
    }

    /**
     * 获取被命中的方块面（如果命中方块且事件中提供了该面）。
     * <p>
     * 原文：
     * Gets the block face that was hit, if it was a block that was hit and the
     * face was provided in the event.
     *
     * @return 被命中的面，否则返回 null
     */
    @Nullable
    public BlockFace getHitBlockFace() {
        return hitFace;
    }

    /**
     * 获取被命中的实体（如果命中实体）。
     * <p>
     * 原文：
     * Gets the entity that was hit, if it was an entity that was hit.
     *
     * @return 被命中的实体，否则返回 null
     */
    @Nullable
    public Entity getHitEntity() {
        return hitEntity;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    /**
     * 是否取消弹射物命中时发生的动作。
     * <p>
     * 对于实体，它将不会碰撞（除非是烟花火箭，然后使用 {@link FireworkExplodeEvent}）。
     * <br>
     * 对于方块，某些方块（例如标靶、钟）将不会执行相关动作。
     * <br>
     * 这不会阻止方块碰撞，除非它们各自的事件被取消，否则爆炸仍会发生。
     * <p>
     * 原文：
     * Whether to cancel the action that occurs when the projectile hits.
     *
     * In the case of an entity, it will not collide (unless it's a firework,
     * then use {@link FireworkExplodeEvent}).
     * <br>
     * In the case of a block, some blocks (eg target block, bell) will not
     * perform the action associated.
     * <br>
     * This does NOT prevent block collisions, and explosions will still occur
     * unless their respective events are cancelled.
     *
     * @param cancel 如果你希望取消此事件则设置为 true
     */
    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
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
