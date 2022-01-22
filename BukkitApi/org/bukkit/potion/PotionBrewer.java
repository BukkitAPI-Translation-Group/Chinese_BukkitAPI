package org.bukkit.potion;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;

/**
 * 代表构建 {@link PotionEffect} 对象的酿造台.
 * (译注:此“酿造台”与游戏中的酿造台无任何关系, 只是对PotionEffect类的包装,
 * 且一般只在1.9版本前的API中使用).
 */
public interface PotionBrewer {

    /**
     * 创建指定类型的{@link PotionEffect 药水效果}, 应用指定的时长.
     * <p>
     * 原文:Creates a {@link PotionEffect} from the given {@link PotionEffectType},
     * applying duration modifiers and checks.
     *
     * @param potion 药水效果类型
     * @param duration 持续时长 (单位为tick)
     * @param amplifier 效果倍率
     * @return 药水效果对象
     */
    @NotNull
    public PotionEffect createEffect(@NotNull PotionEffectType potion, int duration, int amplifier);

    /**
     * 返回根据指定数据值可应用的效果列表.
     * <p>
     * 原文:Returns a collection of {@link PotionEffect} that would be applied from
     * a potion with the given data value.
     *
     * @param damage 药水数据值
     * @return 效果列表
     * @deprecated 无任何作用
     */
    @Deprecated
    @NotNull
    public Collection<PotionEffect> getEffectsFromDamage(int damage);

    /**
     * 返回从指定药水种类中可应用的效果的列表.
     * <p>
     * 原文:Returns a collection of {@link PotionEffect} that would be applied from
     * a potion with the given type.
     *
     * @param type 药水种类
     * @param upgraded 是否为时长延长的药水
     * @param extended 是否为升阶的药水
     * @return 效果列表
     */
    @NotNull
    public Collection<PotionEffect> getEffects(@NotNull PotionType type, boolean upgraded, boolean extended);
}
