package org.bukkit.event.entity;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当喷溅药水命中区域时调用。
 */
public class PotionSplashEvent extends ProjectileHitEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final Map<LivingEntity, Double> affectedEntities;

    @Deprecated(since = "1.20.2")
    public PotionSplashEvent(@NotNull final ThrownPotion potion, @NotNull final Map<LivingEntity, Double> affectedEntities) {
        this(potion, null, null, null, affectedEntities);
    }

    public PotionSplashEvent(@NotNull final ThrownPotion potion, @Nullable Entity hitEntity, @Nullable Block hitBlock, @Nullable BlockFace hitFace, @NotNull final Map<LivingEntity, Double> affectedEntities) {
        super(potion, hitEntity, hitBlock, hitFace);
        this.affectedEntities = affectedEntities;
    }

    @NotNull
    @Override
    public ThrownPotion getEntity() {
        return (ThrownPotion) entity;
    }

    /**
     * 获取导致此事件的药水。
     * <p>
     * 原文：
     * Gets the potion which caused this event
     *
     * @return 投掷的药水实体
     */
    @NotNull
    public ThrownPotion getPotion() {
        return (ThrownPotion) getEntity();
    }

    /**
     * 获取所有受影响实体的列表。
     * <p>
     * 原文：
     * Retrieves a list of all effected entities
     *
     * @return 受影响实体列表的新副本
     */
    @NotNull
    public Collection<LivingEntity> getAffectedEntities() {
        return new ArrayList<LivingEntity>(affectedEntities.keySet());
    }

    /**
     * 获取给定实体的药水效果强度；这取决于到冲击中心的距离。
     * <p>
     * 原文：
     * Gets the intensity of the potion's effects for given entity; This
     * depends on the distance to the impact center
     *
     * @param entity 要获取强度的实体
     * @return 相对于最大效果的强度；0.0：未受影响；1.0：完全被药水效果命中
     */
    public double getIntensity(@NotNull LivingEntity entity) {
        Double intensity = affectedEntities.get(entity);
        return intensity != null ? intensity : 0.0;
    }

    /**
     * 覆盖给定实体的强度。
     * <p>
     * 原文：
     * Overwrites the intensity for a given entity
     *
     * @param entity 要定义新强度的实体
     * @param intensity 相对于最大效果
     */
    public void setIntensity(@NotNull LivingEntity entity, double intensity) {
        Preconditions.checkArgument(entity != null, "You must specify a valid entity.");
        if (intensity <= 0.0) {
            affectedEntities.remove(entity);
        } else {
            affectedEntities.put(entity, Math.min(intensity, 1.0));
        }
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
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