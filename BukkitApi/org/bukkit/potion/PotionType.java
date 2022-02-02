package org.bukkit.potion;

import org.jetbrains.annotations.Nullable;

/**
 * 药水种类枚举, 反应并匹配创造模式物品栏中可获取的每种药水的状态.
 */
public enum PotionType {
    UNCRAFTABLE(null, false, false),
    WATER(null, false, false),
    MUNDANE(null, false, false),
    THICK(null, false, false),
    AWKWARD(null, false, false),
    NIGHT_VISION(PotionEffectType.NIGHT_VISION, false, true),
    INVISIBILITY(PotionEffectType.INVISIBILITY, false, true),
    JUMP(PotionEffectType.JUMP, true, true),
    FIRE_RESISTANCE(PotionEffectType.FIRE_RESISTANCE, false, true),
    SPEED(PotionEffectType.SPEED, true, true),
    SLOWNESS(PotionEffectType.SLOW, true, true),
    WATER_BREATHING(PotionEffectType.WATER_BREATHING, false, true),
    INSTANT_HEAL(PotionEffectType.HEAL, true, false),
    INSTANT_DAMAGE(PotionEffectType.HARM, true, false),
    POISON(PotionEffectType.POISON, true, true),
    REGEN(PotionEffectType.REGENERATION, true, true),
    STRENGTH(PotionEffectType.INCREASE_DAMAGE, true, true),
    WEAKNESS(PotionEffectType.WEAKNESS, false, true),
    LUCK(PotionEffectType.LUCK, false, false),
    TURTLE_MASTER(PotionEffectType.SLOW, true, true), // TODO: multiple effects
    SLOW_FALLING(PotionEffectType.SLOW_FALLING, false, true),
    ;

    private final PotionEffectType effect;
    private final boolean upgradeable;
    private final boolean extendable;

    PotionType(/*@Nullable*/ PotionEffectType effect, boolean upgradeable, boolean extendable) {
        this.effect = effect;
        this.upgradeable = upgradeable;
        this.extendable = extendable;
    }

    @Nullable
    public PotionEffectType getEffectType() {
        return effect;
    }

    public boolean isInstant() {
        return effect != null && effect.isInstant();
    }

    /**
     * 检测此类药水是否可升级.
     * 意思是药水是否有二阶增强版本, 比如再生药水 II.
     * <p>
     * 原文:Checks if the potion type has an upgraded state.
     * This refers to whether or not the potion type can be Tier 2,
     * such as Potion of Fire Resistance II.
     *
     * @return 此类药水是否可升级
     */
    public boolean isUpgradeable() {
        return upgradeable;
    }

    /**
     * 检测此类药水是否有时长延长状态 (指时长延长版药水).
     * <p>
     * 原文:Checks if the potion type has an extended state.
     * This refers to the extended duration potions
     *
     * @return 是否有时长延长版
     */
    public boolean isExtendable() {
        return extendable;
    }

    public int getMaxLevel() {
        return upgradeable ? 2 : 1;
    }

    /**
     * @param effectType 根据何种状态效果获取对应药水类型
     * @return 匹配的药水类型
     * @deprecated 有误导性
     */
    @Deprecated
    @Nullable
    public static PotionType getByEffect(@Nullable PotionEffectType effectType) {
        if (effectType == null)
            return WATER;
        for (PotionType type : PotionType.values()) {
            if (effectType.equals(type.effect))
                return type;
        }
        return null;
    }
}
