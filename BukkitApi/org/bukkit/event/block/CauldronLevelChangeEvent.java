package org.bukkit.event.block;

import com.google.common.base.Preconditions;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class CauldronLevelChangeEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    //
    private final Entity entity;
    private final ChangeReason reason;
    private final int oldLevel;
    private int newLevel;

    public CauldronLevelChangeEvent(Block block, Entity entity, ChangeReason reason, int oldLevel, int newLevel) {
        super(block);
        this.entity = entity;
        this.reason = reason;
        this.oldLevel = oldLevel;
        this.newLevel = newLevel;
    }

    /**
     * 获取哪个实体触发该事件,值有可能为Null.
     * <p>
     * 原文:Get entity which did this. May be null.
     *
     * @return acting entity
     */
    public Entity getEntity() {
        return entity;
    }

    public ChangeReason getReason() {
        return reason;
    }

    public int getOldLevel() {
        return oldLevel;
    }

    public int getNewLevel() {
        return newLevel;
    }

    public void setNewLevel(int newLevel) {
        Preconditions.checkArgument(0 <= newLevel && newLevel <= 3, "Cauldron level out of bounds 0 <= %s <= 3", newLevel);
        this.newLevel = newLevel;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public enum ChangeReason {
        /**
         * 玩家将坩埚内的水装入水桶.
         */
        BUCKET_FILL,
        /**
         * 玩家用水桶装满坩埚.
         */
        BUCKET_EMPTY,
        /**
         * 玩家用水瓶将坩埚内的水用完.
         */
        BOTTLE_FILL,
        /**
         * 玩家将瓶子内的水装入坩埚.
         */
        BOTTLE_EMPTY,
        /**
         * 玩家用坩埚内的水清洗旗帜.
         */
        BANNER_WASH,
        /**
         * 玩家用坩埚内的水清洗护甲装备.
         */
        ARMOR_WASH,
        /**
         * 玩家跳进坩埚灭火.
         */
        EXTINGUISH,
        /**
         * 天气过于炎热导致坩埚内的水自然蒸发.
         */
        EVAPORATE,
        /**
         * 未知情况.
         */
        UNKNOWN
    }
}