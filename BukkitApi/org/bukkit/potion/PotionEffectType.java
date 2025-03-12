package org.bukkit.potion;

import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;
import java.util.Locale;
import org.bukkit.Color;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.Translatable;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表应用于实体上的药水和效果类型.
 */
public abstract class PotionEffectType implements Keyed, Translatable {
    private static final BiMap<Integer, PotionEffectType> ID_MAP = HashBiMap.create();

    /**
     * 速度.
     */
    public static final PotionEffectType SPEED = getPotionEffectType(1, "speed");

    /**
     * 缓慢.
     */
    public static final PotionEffectType SLOWNESS = getPotionEffectType(2, "slowness");

    /**
     * 急迫.
     */
    public static final PotionEffectType HASTE = getPotionEffectType(3, "haste");

    /**
     * 挖掘疲劳.
     */
    public static final PotionEffectType MINING_FATIGUE = getPotionEffectType(4, "mining_fatigue");

    /**
     * 力量.
     */
    public static final PotionEffectType STRENGTH = getPotionEffectType(5, "strength");

    /**
     * 瞬间治疗.
     */
    public static final PotionEffectType INSTANT_HEALTH = getPotionEffectType(6, "instant_health");

    /**
     * 瞬间伤害.
     */
    public static final PotionEffectType INSTANT_DAMAGE = getPotionEffectType(7, "instant_damage");

    /**
     * 跳跃提升.
     */
    public static final PotionEffectType JUMP_BOOST = getPotionEffectType(8, "jump_boost");

    /**
     * 反胃.
     */
    public static final PotionEffectType NAUSEA = getPotionEffectType(9, "nausea");

    /**
     * 生命恢复.
     */
    public static final PotionEffectType REGENERATION = getPotionEffectType(10, "regeneration");

    /**
     * 抗性提升.
     */
    public static final PotionEffectType RESISTANCE = getPotionEffectType(11, "resistance");

    /**
     * 防火.
     */
    public static final PotionEffectType FIRE_RESISTANCE = getPotionEffectType(12, "fire_resistance");

    /**
     * 水下呼吸.
     */
    public static final PotionEffectType WATER_BREATHING = getPotionEffectType(13, "water_breathing");

    /**
     * 隐身.
     */
    public static final PotionEffectType INVISIBILITY = getPotionEffectType(14, "invisibility");

    /**
     * 失明.
     */
    public static final PotionEffectType BLINDNESS = getPotionEffectType(15, "blindness");

    /**
     * 夜视.
     */
    public static final PotionEffectType NIGHT_VISION = getPotionEffectType(16, "night_vision");

    /**
     * 饥饿.
     */
    public static final PotionEffectType HUNGER = getPotionEffectType(17, "hunger");

    /**
     * 虚弱.
     */
    public static final PotionEffectType WEAKNESS = getPotionEffectType(18, "weakness");

    /**
     * 中毒.
     */
    public static final PotionEffectType POISON = getPotionEffectType(19, "poison");

    /**
     * 凋零.
     */
    public static final PotionEffectType WITHER = getPotionEffectType(20, "wither");

    /**
     * 生命提升.
     */
    public static final PotionEffectType HEALTH_BOOST = getPotionEffectType(21, "health_boost");

    /**
     * 伤害吸收.
     */
    public static final PotionEffectType ABSORPTION = getPotionEffectType(22, "absorption");

    /**
     * 饱和.
     */
    public static final PotionEffectType SATURATION = getPotionEffectType(23, "saturation");

    /**
     * 发光.
     */
    public static final PotionEffectType GLOWING = getPotionEffectType(24, "glowing");

    /**
     * 漂浮.
     */
    public static final PotionEffectType LEVITATION = getPotionEffectType(25, "levitation");

    /**
     * 幸运.
     */
    public static final PotionEffectType LUCK = getPotionEffectType(26, "luck");

    /**
     * 霉运.
     */
    public static final PotionEffectType UNLUCK = getPotionEffectType(27, "unluck");

    /**
     * 缓降.
     */
    public static final PotionEffectType SLOW_FALLING = getPotionEffectType(28, "slow_falling");

    /**
     * 潮涌能量.
     */
    public static final PotionEffectType CONDUIT_POWER = getPotionEffectType(29, "conduit_power");

    /**
     * 海豚的恩惠.
     */
    public static final PotionEffectType DOLPHINS_GRACE = getPotionEffectType(30, "dolphins_grace");

    /**
     * 不祥之兆.
     */
    public static final PotionEffectType BAD_OMEN = getPotionEffectType(31, "bad_omen");

    /**
     * 村庄英雄.
     */
    public static final PotionEffectType HERO_OF_THE_VILLAGE = getPotionEffectType(32, "hero_of_the_village");

    /**
     *
     * 黑暗
     */
    public static final PotionEffectType DARKNESS = getPotionEffectType(33, "darkness");

    /**
     * 试炼之兆
     */
    public static final PotionEffectType TRIAL_OMEN = getPotionEffectType(34, "trial_omen");

    /**
     * 袭击之兆
     */
    public static final PotionEffectType RAID_OMEN = getPotionEffectType(35, "raid_omen");

    /**
     * 蓄风
     */
    public static final PotionEffectType WIND_CHARGED = getPotionEffectType(36, "wind_charged");

    /**
     * 盘丝
     */
    public static final PotionEffectType WEAVING = getPotionEffectType(37, "weaving");

    /**
     * 渗浆
     */
    public static final PotionEffectType OOZING = getPotionEffectType(38, "oozing");

    /**
     * 寄生
     */
    public static final PotionEffectType INFESTED = getPotionEffectType(39, "infested");

    @NotNull
    private static PotionEffectType getPotionEffectType(int typeId, @NotNull String key) {
        NamespacedKey namespacedKey = NamespacedKey.minecraft(key);
        PotionEffectType potionEffectType = Registry.EFFECT.get(namespacedKey);
        Preconditions.checkNotNull(potionEffectType, "No PotionEffectType found for %s. This is a bug.", namespacedKey);
        if (typeId > 0) {
            ID_MAP.put(typeId, potionEffectType);
        }
        return potionEffectType;
    }

    /**
     * 以本效果类型创建一个药水效果, 并应用持续时间与倍率.
     * <p>
     * 原文:Creates a PotionEffect from this PotionEffectType, applying duration
     * modifiers and checks.
     *
     * @param duration 效果持续时间, 以 tick 为单位
     * @param amplifier 效果的倍率
     * @return 创建的药水效果
     * @see PotionBrewer#createEffect(PotionEffectType, int, int)
     */
    @NotNull
    public abstract PotionEffect createEffect(int duration, int amplifier);

    /**
     * 返回本效果是否为瞬时型效果.
     * <p>
     * 原文:Returns whether the effect of this type happens once, immediately.
     *
     * @return 是否为瞬时型效果
     */
    public abstract boolean isInstant();

    /**
     * 返回本效果所属的{@link PotionEffectTypeCategory 分类}.
     * <p>
     * 原文:Returns the {@link PotionEffectTypeCategory category} of this effect type.
     *
     * @return 分类
     */
    @NotNull
    public abstract PotionEffectTypeCategory getCategory();

    /**
     * 返回本效果的颜色.
     * <p>
     * 原文:Returns the color of this effect type.
     *
     * @return 颜色
     */
    @NotNull
    public abstract Color getColor();

    /**
     * 返回应用于此效果类型的持续时间.
     * <p>
     * 原文:Returns the duration modifier applied to effects of this type.
     *
     * @return 持续时间
     * @deprecated 未被使用, 总是 1.0
     */
    @Deprecated
    public abstract double getDurationModifier();

    /**
     * 返回本状态效果类型的唯一 ID.
     * <p>
     * 原文:Returns the unique ID of this type.
     *
     * @return 唯一 ID
     * @deprecated 魔法值
     */
    @Deprecated
    public abstract int getId();


    /**
     * 返回本状态效果类型的名称.
     * <p>
     * 原文:Returns the name of this effect type.
     *
     * @return 状态效果名
     * @deprecated 仅为保障向后兼容性, 请使用 {@link #getKey()}
     */
    @NotNull
    @Deprecated
    public abstract String getName();

    /**
     * 根据指定 key 获取效果.
     * <p>
     * 原文:Gets the PotionEffectType at the specified key
     *
     * @param key 效果键名
     * @return 对应的效果类型, 如果找不到返回 null
     * @deprecated 仅为保障向后兼容性, 请使用 {@link Registry#get(NamespacedKey)}
     */
    @Contract("null -> null")
    @Nullable
    @Deprecated
    public static PotionEffectType getByKey(@Nullable NamespacedKey key) {
        if (key == null) {
            return null;
        }

        return Registry.EFFECT.get(key);
    }

    /**
     * 根据唯一 ID 获取效果.
     * <p>
     * 原文:Gets the effect type specified by the unique id.
     *
     * @param id 唯一 ID
     * @return 对应的效果类型, 如果找不到返回 null
     * @deprecated 魔法值
     */
    @Deprecated
    @Nullable
    public static PotionEffectType getById(int id) {
        PotionEffectType type = ID_MAP.get(id);

        if (type != null) {
            return type;
        }

        for (PotionEffectType other : Registry.EFFECT) {
            if (other.getId() == id) {
                ID_MAP.put(id, other);
                return other;
            }
        }

        return null;
    }

    /**
     * 根据指定名称获取效果.
     * <p>
     * 原文:Gets the effect type specified by the given name.
     *
     * @param name 状态效果名
     * @return 对应的效果类型, 如果找不到返回 null
     * @deprecated 仅为保障向后兼容性, 请使用 {@link Registry#get(NamespacedKey)}
     */
    @Nullable
    @Deprecated
    public static PotionEffectType getByName(@NotNull String name) {
        Preconditions.checkArgument(name != null, "name cannot be null");
        return Registry.EFFECT.get(NamespacedKey.fromString(name.toLowerCase(Locale.ROOT)));
    }

    /**
     * @return 所有已知效果类型的数组
     * @deprecated 请使用 {@link Registry#iterator()}.
     */
    @NotNull
    @Deprecated
    public static PotionEffectType[] values() {
        return Lists.newArrayList(Registry.EFFECT).toArray(new PotionEffectType[0]);
    }
}
