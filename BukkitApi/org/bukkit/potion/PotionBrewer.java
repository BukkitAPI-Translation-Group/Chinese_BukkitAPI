package org.bukkit.potion;

import java.util.Collection;

/**
 * 表示一个可以创建{@link PotionEffect}的创建者.
 */
public interface PotionBrewer {

    /**
     * Creates a {@link PotionEffect} from the given {@link PotionEffectType},
     * applying duration modifiers and checks.
     *
     * @param potion 药水的类型
     * @param duration 持续多久tick
     * @param amplifier 效果的等级
     * @return 产生的药水效果
     */
    public PotionEffect createEffect(PotionEffectType potion, int duration, int amplifier);

    /**
     * Returns a collection of {@link PotionEffect} that would be applied from
     * a potion with the given data value.
     *
     * @param damage 药水的数据值
     * @return 效果列表
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Collection<PotionEffect> getEffectsFromDamage(int damage);
}