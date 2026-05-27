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
     * Hostile creatures may attack their target, and friendly creatures may
     * follow their target.
     *
     * @param target New LivingEntity to target, or null to clear the target
     */
    public void setTarget(@Nullable LivingEntity target);

    /**
     * 获取此生物的当前目标。
     * <p>原文：Gets the current target of this Mob
     *
     * @return Current target of this creature, or null if none exists
     */
    @Nullable
    public LivingEntity getTarget();

    /**
     * 设置此生物是否意识到周围环境。
     * <p>原文：Sets whether this mob is aware of its surroundings.
     *
     * Unaware mobs will still move if pushed, attacked, etc. but will not move
     * or perform any actions on their own. Unaware mobs may also have other
     * unspecified behaviours disabled, such as drowning.
     *
     * @param aware whether the mob is aware
     */
    public void setAware(boolean aware);

    /**
     * 获取此生物是否意识到周围环境。
     * <p>原文：Gets whether this mob is aware of its surroundings.
     *
     * Unaware mobs will still move if pushed, attacked, etc. but will not move
     * or perform any actions on their own. Unaware mobs may also have other
     * unspecified behaviours disabled, such as drowning.
     *
     * @return whether the mob is aware
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
     * @return the ambient sound, or null if this entity is ambiently quiet
     */
    @Nullable
    public Sound getAmbientSound();
}
