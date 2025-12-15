package org.bukkit.inventory.meta.components;

import java.util.Collection;
import java.util.List;
import org.bukkit.Sound;
import org.bukkit.Tag;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.damage.DamageType;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一个可以将任何物品变成类似盾牌的物品以格挡攻击伤害的组件.
 * <p>
 * 原文:
 * Represents a component which can turn any item into a shield-like item which
 * blocks attack damage.
 */
@ApiStatus.Experimental
public interface BlocksAttacksComponent extends ConfigurationSerializable {

    /**
     * 获取装备此物品后, 在开始格挡攻击前的延迟时间.
     * <p>
     * 原文:
     * Gets the delay on equip before this item will block attacks.
     *
     * @return 延迟时间 (单位: 秒)
     */
    float getBlockDelaySeconds();

    /**
     * 设置装备此物品后, 在开始格挡攻击前的延迟时间.
     * <p>
     * 原文:
     * Sets the delay on equip before this item will block attacks.
     *
     * @param seconds 要设置的延迟时间 (单位: 秒)
     */
    void setBlockDelaySeconds(float seconds);

    /**
     * 获取当被一个能造成"缴械"效果的攻击击中时, 应用于物品冷却时间的倍增系数.
     * <p>
     * 原文:
     * Gets the multiplier applied to the item cooldown when attacked by a
     * disabling attack.
     *
     * @return 倍增系数
     */
    float getDisableCooldownScale();

    /**
     * 设置当被一个能造成"缴械"效果的攻击击中时, 应用于物品冷却时间的倍增系数.
     * <p>
     * 原文:
     * Sets the multiplier applied to the item cooldown when attacked by a
     * disabling attack.
     *
     * @param scale 要设置的倍增系数. 必须为0或正整数
     */
    void setDisableCooldownScale(float scale);

    /**
     * 获取适用于此物品的 {@link DamageReduction 伤害减免} 列表.
     * <p>
     * 原文:
     * Get the list of {@link DamageReduction DamageReductions} that apply to
     * this item.
     *
     * @return 所有伤害减免. 返回列表的可变性无法保证, 但其内容是可变的, 可以更改它们的值
     */
    @NotNull
    List<DamageReduction> getDamageReductions();

    /**
     * 设置要应用于此物品的 {@link DamageReduction 伤害减免} 列表. 这将移除任何现有的伤害减免.
     * <p>
     * 原文:
     * Set the list of {@link DamageReduction DamageReductions} to apply to this
     * item. This will remove any existing damage reductions.
     *
     * @param reductions 要设置的伤害减免列表
     */
    void setDamageReductions(@NotNull List<DamageReduction> reductions);

    /**
     * 向此组件添加一个新的伤害减免, 该减免针对特定类型的攻击.
     * <p>
     * 原文:
     * Add a new damage reduction to this component, which blocks specific types
     * of attacks.
     *
     * @param type 攻击类型
     * @param base 要格挡的固定伤害值
     * @param factor 要格挡的伤害比例
     * @param horizontalBlockingAngle 攻击将被格挡的最大角度
     * @return 已添加到此物品的 {@link DamageReduction 伤害减免} 实例
     */
    @NotNull
    DamageReduction addDamageReduction(@NotNull DamageType type, float base, float factor, float horizontalBlockingAngle);

    /**
     * 向此组件添加一个新的伤害减免, 该减免针对特定类型的攻击.
     * <p>
     * 原文:
     * Add a new damage reduction to this component, which blocks specific types
     * of attacks.
     *
     * @param types 攻击类型集合
     * @param base 要格挡的固定伤害值
     * @param factor 要格挡的伤害比例
     * @param horizontalBlockingAngle 攻击将被格挡的最大角度
     * @return 已添加到此物品的 {@link DamageReduction 伤害减免} 实例
     */
    @NotNull
    DamageReduction addDamageReduction(@NotNull Collection<DamageType> types, float base, float factor, float horizontalBlockingAngle);

    /**
     * 向此组件添加一个新的伤害减免, 该减免针对特定类型的攻击.
     * <p>
     * 原文:
     * Add a new damage reduction to this component, which blocks specific types
     * of attacks.
     *
     * @param tag 攻击类型标签
     * @param base 要格挡的固定伤害值
     * @param factor 要格挡的伤害比例
     * @param horizontalBlockingAngle 攻击将被格挡的最大角度
     * @return 已添加到此物品的 {@link DamageReduction 伤害减免} 实例
     */
    @NotNull
    DamageReduction addDamageReduction(@NotNull Tag<DamageType> tag, float base, float factor, float horizontalBlockingAngle);

    /**
     * 从此物品中移除给定的 {@link DamageReduction 伤害减免}.
     * <p>
     * 原文:
     * Remove the given {@link DamageReduction} from this item.
     *
     * @param reduction 要移除的伤害减免
     * @return 如果成功移除了减免则返回 true, 如果此组件不包含匹配的减免则返回 false
     */
    boolean removeDamageReduction(@NotNull DamageReduction reduction);

    /**
     * 获取在物品也开始承受伤害之前, 需要被格挡的伤害量阈值.
     * <p>
     * 原文:
     * Gets the amount of damage required to be dealt before damage is also
     * applied to the item.
     *
     * @return 阈值伤害量
     */
    float getItemDamageThreshold();

    /**
     * 设置在物品也开始承受伤害之前, 需要被格挡的伤害量阈值.
     * <p>
     * 原文:
     * Sets the amount of damage required to be dealt before damage is also
     * applied to the item.
     *
     * @param threshold 新的阈值伤害量
     */
    void setItemDamageThreshold(float threshold);

    /**
     * 获取如果达到伤害阈值, 将应用于物品的固定伤害值.
     * <p>
     * 原文:
     * Gets the constant amount of damage applied to the item if the threshold
     * is reached.
     *
     * @return 物品基础伤害值
     */
    float getItemDamageBase();

    /**
     * 设置如果达到伤害阈值, 将应用于物品的固定伤害值.
     * <p>
     * 原文:
     * Sets the constant amount of damage applied to the item if the threshold
     * is reached.
     *
     * @param base 新的物品基础伤害值
     */
    void setItemDamageBase(float base);

    /**
     * 获取如果达到伤害阈值, 将应用于物品的伤害比例.
     * <p>
     * 原文:
     * Gets the proportion of damage applied to the item if the threshold is
     * reached.
     *
     * @return 物品伤害系数
     */
    float getItemDamageFactor();

    /**
     * 设置如果达到伤害阈值, 将应用于物品的伤害比例.
     * <p>
     * 原文:
     * Sets the proportion of damage applied to the item if the threshold is
     * reached.
     *
     * @param factor 新的物品伤害系数
     */
    void setItemDamageFactor(float factor);

    /**
     * 获取物品格挡攻击时播放的音效.
     * <p>
     * 原文:
     * Gets the sound to play when the item blocks an attack.
     *
     * @return 音效
     */
    @Nullable
    Sound getBlockSound();

    /**
     * 设置物品格挡攻击时播放的音效.
     * <p>
     * 原文:
     * Sets the sound to play when the item blocks an attack.
     *
     * @param sound 音效, 或设置为 null 以使用当前默认值
     */
    void setBlockSound(@Nullable Sound sound);

    /**
     * 获取物品被"缴械"时播放的音效.
     * <p>
     * 原文:
     * Gets the sound to play when the item is disabled.
     *
     * @return 音效
     */
    @Nullable
    Sound getDisableSound();

    /**
     * 设置物品被"缴械"时播放的音效.
     * <p>
     * 原文:
     * Sets the sound to play when the item is disabled.
     *
     * @param sound 音效, 或设置为 null 以使用当前默认值
     */
    void setDisableSound(@Nullable Sound sound);

    /**
     * 获取将会绕过此物品格挡的伤害类型.
     * <p>
     * 原文:
     * Gets the type of damage that will bypass blocking by this item.
     *
     * @return 伤害类型标签
     */
    @Nullable
    Tag<DamageType> getBypassedBy();

    /**
     * 设置将会绕过此物品格挡的伤害类型.
     * <p>
     * 原文:
     * Sets the type of damage that will bypass blocking by this item.
     *
     * @param tag 伤害类型标签, 或设置为 null 以清除
     */
    void setBypassedBy(@Nullable Tag<DamageType> tag);

    /**
     * 针对一组特定伤害类型的伤害减免.
     * <p>
     * 原文:
     * A damage reduction for a specific set of damage types.
     */
    public interface DamageReduction extends ConfigurationSerializable {

        /**
         * 获取此减免规则适用的伤害类型.
         * <p>
         * 原文:
         * Gets the types to which this reduction applies.
         *
         * @return 伤害类型集合
         */
        @Nullable
        Collection<DamageType> getTypes();

        /**
         * 设置此减免规则适用的伤害类型.
         * <p>
         * 原文:
         * Sets the types to which this reduction applies.
         *
         * @param type 伤害类型
         */
        void setTypes(@Nullable DamageType type);

        /**
         * 设置此减免规则适用的伤害类型.
         * <p>
         * 原文:
         * Sets the types to which this reduction applies.
         *
         * @param types 伤害类型集合
         */
        void setTypes(@Nullable Collection<DamageType> types);

        /**
         * 设置此减免规则适用的伤害类型.
         * <p>
         * 原文:
         * Sets the types to which this reduction applies.
         *
         * @param tag 伤害类型标签
         */
        void setTypes(@Nullable Tag<DamageType> tag);

        /**
         * 获取将要格挡的固定伤害值.
         * <p>
         * 原文:
         * Gets the constant amount of damage to be blocked.
         *
         * @return 基础格挡值
         */
        float getBase();

        /**
         * 设置将要格挡的固定伤害值.
         * <p>
         * 原文:
         * Sets the constant amount of damage to be blocked.
         *
         * @param base 新的基础格挡值
         */
        void setBase(float base);

        /**
         * 获取将要格挡的伤害比例.
         * <p>
         * 原文:
         * Gets the proportion of damage to be blocked.
         *
         * @return 基础格挡系数
         */
        float getFactor();

        /**
         * 设置将要格挡的伤害比例.
         * <p>
         * 原文:
         * Sets the proportion of damage to be blocked.
         *
         * @param factor 新的格挡系数
         */
        void setFactor(float factor);

        /**
         * 获取攻击将被格挡的最大角度 (默认为 90 度).
         * <p>
         * 原文:
         * Gets the maximum angle at which attacks will be blocked (defaults to
         * 90).
         *
         * @return 最大格挡角度
         */
        float getHorizontalBlockingAngle();

        /**
         * 设置攻击将被格挡的最大角度 (默认为 90 度).
         * <p>
         * 原文:
         * Sets the maximum angle at which attacks will be blocked (defaults to
         * 90).
         *
         * @param horizontalBlockingAngle 新的格挡角度
         */
        void setHorizontalBlockingAngle(float horizontalBlockingAngle);
    }
}
