package org.bukkit.entity;

import java.util.List;
import org.bukkit.Color;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 表示一只箭矢.
 */
public interface Arrow extends AbstractArrow {

    /**
     * 设置底层药水数据.
     * <p>
     * 原文：Sets the underlying potion data
     *
     * @param data 要设置的基础药水状态的 PotionData
     * @deprecated 升级/延长的药水现在是独立的 {@link PotionType}，请使用 {@link #setBasePotionType} 替代.
     */
    @Deprecated(since = "1.20.6")
    void setBasePotionData(@Nullable PotionData data);

    /**
     * 返回关于基础药水的药水数据.
     * <p>
     * 原文：Returns the potion data about the base potion
     *
     * @return PotionData 对象
     * @deprecated 升级/延长的药水现在是独立的 {@link PotionType}，请使用 {@link #getBasePotionType()} 替代.
     */
    @Nullable
    @Deprecated(since = "1.20.6")
    PotionData getBasePotionData();

    /**
     * 设置底层药水类型.
     * <p>
     * 原文：Sets the underlying potion type
     *
     * @param type 要设置的基础药水状态的 PotionType
     */
    void setBasePotionType(@Nullable PotionType type);

    /**
     * 返回关于基础药水的药水类型.
     * <p>
     * 原文：Returns the potion type about the base potion
     *
     * @return PotionType 对象
     */
    @Nullable
    PotionType getBasePotionType();

    /**
     * 获取此箭矢的颜色.
     * <p>
     * 原文：Gets the color of this arrow.
     *
     * @return 箭矢的 {@link Color}，如果未设置颜色则为 null
     */
    @Nullable
    Color getColor();

    /**
     * 设置此箭矢的颜色. 将作为其粒子的着色应用.
     * <p>
     * 原文：Sets the color of this arrow. Will be applied as a tint to its particles.
     *
     * @param color 箭矢颜色，null 表示清除颜色
     */
    void setColor(@Nullable Color color);
    /**
     * 检查是否存在自定义药水效果.
     * <p>
     * 原文：Checks for the presence of custom potion effects.
     *
     * @return 如果应用了自定义药水效果则为 true
     */
    boolean hasCustomEffects();

    /**
     * 获取应用于此箭矢的所有自定义药水效果的不可变列表.
     * <p>
     * 插件应在调用此方法前检查 hasCustomEffects() 是否返回 true.
     * <p>
     * 原文：Gets an immutable list containing all custom potion effects applied to
     * this arrow.
     * <p>
     * Plugins should check that hasCustomEffects() returns true before calling
     * this method.
     *
     * @return 自定义药水效果的不可变列表
     */
    @NotNull
    List<PotionEffect> getCustomEffects();

    /**
     * 添加自定义药水效果到此箭矢.
     * <p>
     * 原文：Adds a custom potion effect to this arrow.
     *
     * @param effect 要添加的药水效果
     * @param overwrite 如果为 true，则覆盖同类型的现有效果
     * @return 如果因此次调用添加了效果则为 true
     */
    boolean addCustomEffect(@NotNull PotionEffect effect, boolean overwrite);

    /**
     * 从此箭矢移除自定义药水效果.
     * <p>
     * 原文：Removes a custom potion effect from this arrow.
     *
     * @param type 要移除的药水效果类型
     * @return 如果因此次调用移除了效果则为 true
     * @throws IllegalArgumentException 如果此操作会使箭矢处于无自定义效果且药水类型为 UNCRAFTABLE 的状态
     */
    boolean removeCustomEffect(@NotNull PotionEffectType type);

    /**
     * 检查此箭矢上是否存在特定的自定义药水效果类型.
     * <p>
     * 原文：Checks for a specific custom potion effect type on this arrow.
     *
     * @param type 要检查的药水效果类型
     * @return 如果药水有此效果则为 true
     */
    boolean hasCustomEffect(@Nullable PotionEffectType type);

    /**
     * 移除此箭矢的所有自定义药水效果.
     * <p>
     * 原文：Removes all custom potion effects from this arrow.
     *
     * @throws IllegalArgumentException 如果此操作会使箭矢处于无自定义效果且药水类型为 UNCRAFTABLE 的状态
     */
    void clearCustomEffects();
}
