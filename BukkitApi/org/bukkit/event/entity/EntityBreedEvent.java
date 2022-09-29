package org.bukkit.event.entity;

import com.google.common.base.Preconditions;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当一个实体与另一个实体交配繁殖时触发本事件.
 */
public class EntityBreedEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    //
    private final LivingEntity mother;
    private final LivingEntity father;
    private final LivingEntity breeder;
    private final ItemStack bredWith;
    private int experience;
    //
    private boolean cancel;

    public EntityBreedEvent(@NotNull LivingEntity child, @NotNull LivingEntity mother, @NotNull LivingEntity father, @Nullable LivingEntity breeder, @Nullable ItemStack bredWith, int experience) {
        super(child);

        Preconditions.checkArgument(child != null, "Cannot have null child");
        Preconditions.checkArgument(mother != null, "Cannot have null mother");
        Preconditions.checkArgument(father != null, "Cannot have null father");

        // Breeder can be null in the case of spontaneous conception
        this.mother = mother;
        this.father = father;
        this.breeder = breeder;
        this.bredWith = bredWith;

        setExperience(experience);
    }

    @NotNull
    @Override
    public LivingEntity getEntity() {
        return (LivingEntity) entity;
    }

    /**
     * 获取繁殖此实体的母实体.
     * <p>
     * 原文:Gets the parent creating this entity.
     *
     * @return 母实体
     */
    @NotNull
    public LivingEntity getMother() {
        return mother;
    }

    /**
     * 获取此新生实体的父实体.
     * <p>
     * 原文:Gets the other parent of the newly born entity.
     *
     * @return 父实体
     */
    @NotNull
    public LivingEntity getFather() {
        return father;
    }

    /**
     * 获取引起此次繁殖事件的实体. 如果繁殖是因自然或自发受精而起则为 null.
     * <p>
     * 原文:Gets the Entity responsible for breeding. Breeder is null for spontaneous
     * conception.
     *
     * @return 引起此次繁殖的实体
     */
    @Nullable
    public LivingEntity getBreeder() {
        return breeder;
    }

    /**
     * 获取用于引起此次繁殖的物品 (若存在).
     * <p>
     * 原文:The ItemStack that was used to initiate breeding, if present.
     *
     * @return 用于引起此次繁殖的物品
     */
    @Nullable
    public ItemStack getBredWith() {
        return bredWith;
    }

    /**
     * 获取此次繁殖授予玩家的经验数量.
     * <p>
     * 原文:Get the amount of experience granted by breeding.
     *
     * @return 经验
     */
    public int getExperience() {
        return experience;
    }

    /**
     * 设置此次繁殖授予玩家的经验数量.
     * <p>
     * 原文:Set the amount of experience granted by breeding.
     *
     * @param experience 经验
     */
    public void setExperience(int experience) {
        Preconditions.checkArgument(experience >= 0, "Experience cannot be negative");
        this.experience = experience;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

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
