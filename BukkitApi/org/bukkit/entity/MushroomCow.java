package org.bukkit.entity;

import java.util.List;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

/**
 * 代表哞菇( {@link AbstractCow} ).
 */
public interface MushroomCow extends AbstractCow {

    /**
     * 检查是否设置了自定义药水效果，这些效果将应用于下次从此 {@link MushroomCow} 挤奶获得的可疑炖菜。
     * <p>
     * 原文：Checks for the presence of custom potion effects to be applied to the next suspicious stew received from milking this {@link MushroomCow}.
     *
     * @return 如果自定义药水效果应用于炖菜则返回 true
     */
    boolean hasEffectsForNextStew();

    /**
     * 获取包含所有自定义药水效果的不可变列表，这些效果将应用于下次从此 {@link MushroomCow} 挤奶获得的可疑炖菜。
     * <p>
     * 插件在调用此方法前应检查 hasCustomEffects() 是否返回 true。
     * <p>
     * 原文：Gets an immutable list containing all custom potion effects applied to the next suspicious stew received from milking this {@link MushroomCow}. Plugins should check that hasCustomEffects() returns true before calling this method.
     *
     * @return 包含自定义药水效果的不可变列表
     */
    @NotNull
    List<PotionEffect> getEffectsForNextStew();

    /**
     * 添加一个自定义药水效果，该效果将应用于下次从此 {@link MushroomCow} 挤奶获得的可疑炖菜。
     * <p>
     * 原文：Adds a custom potion effect to be applied to the next suspicious stew received from milking this {@link MushroomCow}.
     *
     * @param effect 要添加的药水效果
     * @param overwrite 如果为 true，则覆盖任何已存在的相同类型效果
     * @return 如果应用于可疑炖菜的效果因此次调用而改变则返回 true
     */
    boolean addEffectToNextStew(@NotNull PotionEffect effect, boolean overwrite);

    /**
     * 移除一个自定义药水效果，使其不再应用于下次从此 {@link MushroomCow} 挤奶获得的可疑炖菜。
     * <p>
     * 原文：Removes a custom potion effect from being applied to the next suspicious stew received from milking this {@link MushroomCow}.
     *
     * @param type 要移除的药水效果类型
     * @return 如果应用于可疑炖菜的效果因此次调用而改变则返回 true
     */
    boolean removeEffectFromNextStew(@NotNull PotionEffectType type);

    /**
     * 检查是否有特定的自定义药水效果类型将应用于下次从此 {@link MushroomCow} 挤奶获得的可疑炖菜。
     * <p>
     * 原文：Checks for a specific custom potion effect type to be applied to the next suspicious stew received from milking this {@link MushroomCow}.
     *
     * @param type 要检查的药水效果类型
     * @return 如果要生成的可疑炖菜包含此效果则返回 true
     */
    boolean hasEffectForNextStew(@NotNull PotionEffectType type);

    /**
     * 移除所有将应用于下次从此 {@link MushroomCow} 挤奶获得的可疑炖菜的自定义药水效果。
     * <p>
     * 原文：Removes all custom potion effects to be applied to the next suspicious stew received from milking this {@link MushroomCow}.
     */
    void clearEffectsForNextStew();

    /**
     * 获取此牛的变种。
     * <p>
     * 原文：Get the variant of this cow.
     *
     * @return 牛的变种
     */
    @NotNull
    public Variant getVariant();

    /**
     * 设置此牛的变种。
     * <p>
     * 原文：Set the variant of this cow.
     *
     * @param variant 牛的变种
     */
    public void setVariant(@NotNull Variant variant);

    /**
     * 代表牛的变种，即其颜色。
     */
    public enum Variant {
        /**
         * 红色哞菇。
         */
        RED,
        /**
         * 棕色哞菇。
         */
        BROWN;
    }
}
