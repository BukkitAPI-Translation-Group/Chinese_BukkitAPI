package org.bukkit.inventory.meta.components;

import org.bukkit.Sound;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/**
 * 表示一个可以将任何物品转变为动能武器的组件，该武器根据目标和攻击者的相对速度造成伤害。
 */
@ApiStatus.Experimental
public interface KineticWeaponComponent extends ConfigurationSerializable {

    /**
     * 获取武器击中实体后可以再次使用前的延迟。
     * <p>原文：Gets the delay before the weapon can be used after hitting an entity.
     *
     * @return 冷却时间（以刻为单位）
     */
    int getContactCooldownTicks();

    /**
     * 设置武器击中实体后可以再次使用前的延迟。
     * <p>原文：Sets the delay before the weapon can be used after hitting an entity.
     *
     * @param ticks 新的冷却时间（以刻为单位）
     */
    void setContactCooldownTicks(int ticks);

    /**
     * 获取武器可以使用前的延迟。
     * <p>原文：Gets the delay before the weapon can be used.
     *
     * @return 延迟时间（以刻为单位）
     */
    int getDelayTicks();

    /**
     * 设置武器可以使用前的延迟。
     * <p>原文：Sets the delay before the weapon can be used.
     *
     * @param ticks 新的延迟时间（以刻为单位）
     */
    void setDelayTicks(int ticks);

    /**
     * 获取武器使目标下马所需的条件。
     * <p>原文：Gets the conditions required for the weapon to dismount the target.
     *
     * @return 下马条件
     */
    @Nullable
    Condition getDismountConditions();

    /**
     * 设置武器使目标下马所需的条件。
     * <p>原文：Sets the conditions required for the weapon to dismount the target.
     *
     * @param condition 下马条件
     */
    void setDismountConditions(@Nullable Condition condition);

    /**
     * 获取武器击退目标所需的条件。
     * <p>原文：Gets the conditions required for the weapon to knockback the target.
     *
     * @return 击退条件
     */
    @Nullable
    Condition getKnockbackConditions();

    /**
     * 设置武器击退目标所需的条件。
     * <p>原文：Sets the conditions required for the weapon to knockback the target.
     *
     * @param condition 击退条件
     */
    void setKnockbackConditions(@Nullable Condition condition);

    /**
     * 获取武器对目标造成伤害所需的条件。
     * <p>原文：Gets the conditions required for the weapon to damage the target.
     *
     * @return 伤害条件
     */
    @Nullable
    Condition getDamageConditions();

    /**
     * 设置武器对目标造成伤害所需的条件。
     * <p>原文：Sets the conditions required for the weapon to damage the target.
     *
     * @param condition 伤害条件
     */
    void setDamageConditions(@Nullable Condition condition);

    /**
     * 获取物品的前移动画。
     * <p>原文：Gets the forward movement animation of the item.
     *
     * @return 前移距离
     */
    float getForwardMovement();

    /**
     * 设置物品的前移动画。
     * <p>原文：Sets the forward movement animation of the item.
     *
     * @param movement 新的前移距离
     */
    void setForwardMovement(float movement);

    /**
     * 获取基于目标和攻击者相对速度的最终伤害倍率。
     * <p>原文：Gets the final damage multiplier based on target and attacker relative speed.
     *
     * @return 伤害倍率
     */
    float getDamageMultiplier();

    /**
     * 设置基于目标和攻击者相对速度的最终伤害倍率。
     * <p>原文：Sets the final damage multiplier based on target and attacker relative speed.
     *
     * @param multiplier 新的倍率
     */
    void setDamageMultipler(float multiplier);

    /**
     * 获取使用物品时播放的音效。
     * <p>原文：Gets the sound to play when the item is used.
     *
     * @return 音效
     */
    @Nullable
    Sound getSound();

    /**
     * 设置使用物品时播放的音效。
     * <p>原文：Sets the sound to play when the item is used.
     *
     * @param sound 音效或null表示使用当前默认值
     */
    void setSound(@Nullable Sound sound);

    /**
     * 获取物品成功击中目标时播放的音效。
     * <p>原文：Gets the sound to play when the item successfully hits a target.
     *
     * @return 音效
     */
    @Nullable
    Sound getHitSound();

    /**
     * 设置物品成功击中目标时播放的音效。
     * <p>原文：Sets the sound to play when the item successfully hits a target.
     *
     * @param sound 音效或null表示使用当前默认值
     */
    void setHitSound(@Nullable Sound sound);

    /**
     * 表示攻击效果的条件。
     */
    public interface Condition extends ConfigurationSerializable {

        /**
         * 获取条件不再适用的刻数。
         * <p>原文：Gets the ticks after which the condition can no longer apply.
         *
         * @return 最大持续时间（以刻为单位）
         */
        int getMaxDurationTicks();

        /**
         * 设置条件不再适用的刻数。
         * <p>原文：Sets the ticks after which the condition can no longer apply.
         *
         * @param ticks 新的最大持续时间（以刻为单位）
         */
        void setMaxDurationTicks(int ticks);

        /**
         * 获取效果生效所需的攻击者最低速度。
         * <p>原文：Gets the minimum speed of the attacker for the effect to apply.
         *
         * @return 最低速度
         */
        float getMinSpeed();

        /**
         * 设置效果生效所需的攻击者最低速度。
         * <p>原文：Sets the minimum speed of the attacker for the effect to apply.
         *
         * @param speed 新的最低速度
         */
        void setMinSpeed(float speed);

        /**
         * 获取效果生效所需的攻击者与目标之间的最低相对速度。
         * <p>原文：Gets the minimum speed between the attacker and target for the effect to apply.
         *
         * @return 最低速度
         */
        float getMinRelativeSpeed();

        /**
         * 设置效果生效所需的攻击者与目标之间的最低相对速度。
         * <p>原文：Sets the minimum speed between the attacker and target for the effect to apply.
         *
         * @param speed 新的最低速度
         */
        void setMinRelativeSpeed(float speed);
    }
}
