package org.bukkit.entity;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.potion.PotionEffectType;

/**
 * 实体分类, 不同类别的实体可能行为不同, 或受附魔和药水效果的独特影响.
 */
public enum EntityCategory {

    /**
     * 未分类的实体. 这些实体没有与分类相关的额外效果.
     */
    NONE,
    /**
     * 亡灵生物. 这些生物:
     * <ul>
     *   <li>受到治疗药水的伤害.
     *   <li>受到伤害药水的治疗.
     *   <li>免疫溺水和中毒.
     *   <li>在白天会燃烧 (但不是全部).
     *   <li>在水中会下沉 (除了 {@link Drowned}、{@link Phantom 幻翼}
     *   和 {@link Wither 凋灵}).
     *   <li>受到 {@link Enchantment#SMITE} 的额外伤害.
     *   <li>被 {@link Wither 凋灵} 忽视.
     * </ul>
     */
    UNDEAD,
    /**
     * 节肢动物家族的实体. 这些生物:
     * <ul>
     *   <li>受到 {@link Enchantment#BANE_OF_ARTHROPODS} 的额外伤害并获得
     *   {@link PotionEffectType#SLOWNESS} 效果.
     *   <li>蜘蛛免疫 {@link PotionEffectType#POISON}.
     * </ul>
     */
    ARTHROPOD,
    /**
     * 参与袭击的实体. 这些生物:
     * <ul>
     *   <li>免疫 {@link EvokerFangs} 的伤害.
     *   <li>被名为 "Johnny" 的 {@link Vindicator 卫道士} 忽视.
     *   <li>对 {@link Villager 村民}、{@link WanderingTrader 流浪商人}、
     *   {@link IronGolem 铁傀儡} 和 {@link Player 玩家} 敌对.
     * </ul>
     */
    ILLAGER,
    /**
     * 主要生活在水下的实体 (不包括 {@link Drowned}). 这些生物:
     * <ul>
     *   <li>受到 {@link Enchantment#IMPALING} 的额外伤害.
     *   <li>免疫溺水 (不包括 {@link Dolphin 海豚}).
     *   <li>长时间离开水会受到窒息伤害 (不包括 {@link Guardian 守卫者}
     *   和 {@link Turtle 海龟}).
     *   <li>能够在水中游泳而不是漂浮或下沉.
     * </ul>
     */
    WATER;
}
