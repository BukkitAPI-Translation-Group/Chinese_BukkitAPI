package org.bukkit.entity;

import org.bukkit.Sound;
import org.bukkit.loot.Lootable;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一个生物。生物是具有简单AI的活体实体。
 */
public interface Mob extends LivingEntity, Lootable {

    /**
     * 指示此生物将指定的活体实体设为其目标。
     * <p>原文：Instructs this Mob to set the specified LivingEntity as its target.
     * <p>
     * 敌对生物可能会攻击其目标，友好生物可能会跟随其目标。
     *
     * @param target 新的目标活体实体，或 null 以清除目标
     */
    public void setTarget(@Nullable LivingEntity target);

    /**
     * 获取此生物的当前目标。
     * <p>原文：Gets the current target of this Mob
     *
     * @return 此生物的当前目标，如果不存在则为 null
     */
    @Nullable
    public LivingEntity getTarget();

    /**
     * 设置此生物是否意识到周围环境。
     * <p>原文：Sets whether this mob is aware of its surroundings.
     * <p>
     * 未意识到周围环境的生物在被推、被攻击等情况下仍会移动，但不会自行移动或执行任何操作。
     * 未意识到周围环境的生物可能还会禁用其他未明确指定的行为，例如溺水。
     *
     * @param aware 生物是否意识到周围环境
     */
    public void setAware(boolean aware);

    /**
     * 获取此生物是否意识到周围环境。
     * <p>原文：Gets whether this mob is aware of its surroundings.
     * <p>
     * 未意识到周围环境的生物在被推、被攻击等情况下仍会移动，但不会自行移动或执行任何操作。
     * 未意识到周围环境的生物可能还会禁用其他未明确指定的行为，例如溺水。
     *
     * @return 生物是否意识到周围环境
     */
    public boolean isAware();

    /**
     * 获取此生物在环境存在时发出的{@link Sound}声音。此声音可能因实体当前状态而异，也可能在特定条件下返回null。此声音不是恒定的。
     * <p>原文：Get the {@link Sound} this mob makes while ambiently existing. This sound
     * may change depending on the current state of the entity, and may also
     * return null under specific conditions. This sound is not constant.
     * For instance, villagers will make different passive noises depending
     * on whether or not they are actively trading with a player, or make no
     * ambient noise while sleeping.
     *
     * @return 环境声音，如果此实体在环境中静默则为 null
     */
    @Nullable
    public Sound getAmbientSound();
}
