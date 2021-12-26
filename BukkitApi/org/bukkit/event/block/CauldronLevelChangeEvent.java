package org.bukkit.event.block;

import com.google.common.base.Preconditions;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 炼药锅水位发生变化时触发本事件.
 */
public class CauldronLevelChangeEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    //
    private final Entity entity;
    private final ChangeReason reason;
    private final BlockState newState;

    public CauldronLevelChangeEvent(@NotNull Block block, @Nullable Entity entity, @NotNull ChangeReason reason, @NotNull BlockState newBlock) {
        super(block);
        this.entity = entity;
        this.reason = reason;
        this.newState = newBlock;
    }

    /**
     * 获取触发本事件的实体,值有可能为null.
     * <p>
     * 原文:Get entity which did this. May be null.
     *
     * @return 触发本事件的实体
     */
    @Nullable
    public Entity getEntity() {
        return entity;
    }

    @NotNull
    public ChangeReason getReason() {
        return reason;
    }

    /**
     * Gets the new state of the cauldron.
     *
     * @return The block state of the block that will be changed
     */
    @NotNull
    public BlockState getNewState() {
        return newState;
    }

    /**
     * Gets the old level of the cauldron.
     *
     * @return old level
     * @see #getBlock()
     * @deprecated not all cauldron contents are Levelled
     */
    @Deprecated
    public int getOldLevel() {
        BlockData oldBlock = getBlock().getBlockData();
        return (oldBlock instanceof Levelled) ? ((Levelled) oldBlock).getLevel() : ((oldBlock.getMaterial() == Material.CAULDRON) ? 0 : 3);
    }

    /**
     * Gets the new level of the cauldron.
     *
     * @return new level
     * @see #getNewState()
     * @deprecated not all cauldron contents are Levelled
     */
    @Deprecated
    public int getNewLevel() {
        BlockData newBlock = newState.getBlockData();
        return (newBlock instanceof Levelled) ? ((Levelled) newBlock).getLevel() : ((newBlock.getMaterial() == Material.CAULDRON) ? 0 : 3);
    }

    /**
     * Sets the new level of the cauldron.
     *
     * @param newLevel new level
     * @see #getNewState()
     * @deprecated not all cauldron contents are Levelled
     */
    @Deprecated
    public void setNewLevel(int newLevel) {
        Preconditions.checkArgument(0 <= newLevel && newLevel <= 3, "Cauldron level out of bounds 0 <= %s <= 3", newLevel);
        if (newLevel == 0) {
            newState.setType(Material.CAULDRON);
        } else if (newState.getBlockData() instanceof Levelled) {
            ((Levelled) newState.getBlockData()).setLevel(newLevel);
        } else {
            // Error, non-levellable block
        }
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
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

    public enum ChangeReason {
        /**
         * 玩家将炼药锅内的水装入水桶.
         */
        BUCKET_FILL,
        /**
         * 玩家用水桶装满炼药锅.
         */
        BUCKET_EMPTY,
        /**
         * 玩家用水瓶将炼药锅内的水用完.
         */
        BOTTLE_FILL,
        /**
         * 玩家将瓶子内的水装入炼药锅.
         */
        BOTTLE_EMPTY,
        /**
         * 玩家用炼药锅内的水清洗旗帜.
         */
        BANNER_WASH,
        /**
         * 玩家用炼药锅内的水清洗护甲装备.
         */
        ARMOR_WASH,
        /**
         * Player cleaning a shulker box.
         */
        SHULKER_WASH,
        /**
         * 玩家跳进炼药锅灭火.
         */
        EXTINGUISH,
        /**
         * 天气过于炎热导致炼药锅内的水自然蒸发.
         */
        EVAPORATE,
        /**
         * Filling due to natural fluid sources, eg rain or dripstone.
         */
        NATURAL_FILL,
        /**
         * 未知情况.
         */
        UNKNOWN
    }
}