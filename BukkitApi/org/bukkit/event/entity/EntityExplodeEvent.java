package org.bukkit.event.entity;

import java.util.List;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当一个实体爆炸的时候触发本事件
 */
public class EntityExplodeEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel;
    private final Location location;
    private final List<Block> blocks;
    private float yield;

    public EntityExplodeEvent(@NotNull final Entity what, @NotNull final Location location, @NotNull final List<Block> blocks, final float yield) {
        super(what);
        this.location = location;
        this.blocks = blocks;
        this.yield = yield;
        this.cancel = false;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * 返回被将移除或已被这次爆炸移除的方块列表.
     * <p>
     * 原文:
     * Returns the list of blocks that would have been removed or were removed
     * from the explosion event.
     *
     * @return 被炸毁的所有方块
     */
    @NotNull
    public List<Block> blockList() {
        return blocks;
    }

    /**
     * 返回爆炸发生的位置.
     * <p>
     * 从此值获取一个实体是不可能的，因为实体不存在于此世界上.
     * <p>
     * 原文:Returns the location where the explosion happened.
     * <p>
     * It is not possible to get this value from the Entity as the Entity no
     * longer exists in the world.
     *
     * @return 爆炸发生位置
     */
    @NotNull
    public Location getLocation() {
        return location;
    }

    /**
     * 返回这次爆炸掉落方块占所有影响到的方块的百分比.
     * <p>
     * 原文:Returns the percentage of blocks to drop from this explosion
     *
     * @return 掉落物占有率
     */
    public float getYield() {
        return yield;
    }

    /**
     * 设置这次爆炸掉落的方块的百分比.
     * <p>
     * 原文:Sets the percentage of blocks to drop from this explosion
     *
     * @param yield 掉落物占有率
     */
    public void setYield(float yield) {
        this.yield = yield;
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