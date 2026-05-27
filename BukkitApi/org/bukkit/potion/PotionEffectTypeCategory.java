package org.bukkit.potion;

/**
 * 表示 {@link PotionEffectType} 的类别及其对实体的影响。
 */
public enum PotionEffectTypeCategory {

    /**
     * 对实体产生积极影响的有益效果，例如生命恢复、伤害吸收或抗火。
     */
    BENEFICIAL,
    /**
     * 对实体产生负面影响的有害效果，例如失明、凋零或漂浮。
     */
    HARMFUL,
    /**
     * 对实体既无积极也无负面影响的中性效果，例如发光或不祥之兆。
     */
    NEUTRAL;

}
