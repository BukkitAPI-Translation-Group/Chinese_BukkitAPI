package org.bukkit.potion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.Validate;
import org.bukkit.Color;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表应用于实体上的药水和效果类型.
 */
public abstract class PotionEffectType implements Keyed {
    /**
     * 速度.
     */
    public static final PotionEffectType SPEED = new PotionEffectTypeWrapper(1, "speed");

    /**
     * 缓慢.
     */
    public static final PotionEffectType SLOW = new PotionEffectTypeWrapper(2, "slowness");

    /**
     * 急迫.
     */
    public static final PotionEffectType FAST_DIGGING = new PotionEffectTypeWrapper(3, "haste");

    /**
     * 挖掘疲劳.
     */
    public static final PotionEffectType SLOW_DIGGING = new PotionEffectTypeWrapper(4, "mining_fatigue");

    /**
     * 力量.
     */
    public static final PotionEffectType INCREASE_DAMAGE = new PotionEffectTypeWrapper(5, "strength");

    /**
     * 瞬间治疗.
     */
    public static final PotionEffectType HEAL = new PotionEffectTypeWrapper(6, "instant_health");

    /**
     * 瞬间伤害.
     */
    public static final PotionEffectType HARM = new PotionEffectTypeWrapper(7, "instant_damage");

    /**
     * 跳跃提升.
     */
    public static final PotionEffectType JUMP = new PotionEffectTypeWrapper(8, "jump_boost");

    /**
     * 反胃.
     */
    public static final PotionEffectType CONFUSION = new PotionEffectTypeWrapper(9, "nausea");

    /**
     * 生命恢复.
     */
    public static final PotionEffectType REGENERATION = new PotionEffectTypeWrapper(10, "regeneration");

    /**
     * 抗性提升.
     */
    public static final PotionEffectType DAMAGE_RESISTANCE = new PotionEffectTypeWrapper(11, "resistance");

    /**
     * 防火.
     */
    public static final PotionEffectType FIRE_RESISTANCE = new PotionEffectTypeWrapper(12, "fire_resistance");

    /**
     * 水下呼吸.
     */
    public static final PotionEffectType WATER_BREATHING = new PotionEffectTypeWrapper(13, "water_breathing");

    /**
     * 隐身.
     */
    public static final PotionEffectType INVISIBILITY = new PotionEffectTypeWrapper(14, "invisibility");

    /**
     * 失明.
     */
    public static final PotionEffectType BLINDNESS = new PotionEffectTypeWrapper(15, "blindness");

    /**
     * 夜视.
     */
    public static final PotionEffectType NIGHT_VISION = new PotionEffectTypeWrapper(16, "night_vision");

    /**
     * 饥饿.
     */
    public static final PotionEffectType HUNGER = new PotionEffectTypeWrapper(17, "hunger");

    /**
     * 虚弱.
     */
    public static final PotionEffectType WEAKNESS = new PotionEffectTypeWrapper(18, "weakness");

    /**
     * 中毒.
     */
    public static final PotionEffectType POISON = new PotionEffectTypeWrapper(19, "poison");

    /**
     * 凋零.
     */
    public static final PotionEffectType WITHER = new PotionEffectTypeWrapper(20, "wither");

    /**
     * 生命提升.
     */
    public static final PotionEffectType HEALTH_BOOST = new PotionEffectTypeWrapper(21, "health_boost");

    /**
     * 伤害吸收.
     */
    public static final PotionEffectType ABSORPTION = new PotionEffectTypeWrapper(22, "absorption");

    /**
     * 饱和.
     */
    public static final PotionEffectType SATURATION = new PotionEffectTypeWrapper(23, "saturation");

    /**
     * 发光.
     */
    public static final PotionEffectType GLOWING = new PotionEffectTypeWrapper(24, "glowing");

    /**
     * 漂浮.
     */
    public static final PotionEffectType LEVITATION = new PotionEffectTypeWrapper(25, "levitation");

    /**
     * 幸运.
     */
    public static final PotionEffectType LUCK = new PotionEffectTypeWrapper(26, "luck");

    /**
     * 霉运.
     */
    public static final PotionEffectType UNLUCK = new PotionEffectTypeWrapper(27, "unluck");

    /**
     * 缓降.
     */
    public static final PotionEffectType SLOW_FALLING = new PotionEffectTypeWrapper(28, "slow_falling");

    /**
     * 潮涌能量.
     */
    public static final PotionEffectType CONDUIT_POWER = new PotionEffectTypeWrapper(29, "conduit_power");

    /**
     * 海豚的恩惠.
     */
    public static final PotionEffectType DOLPHINS_GRACE = new PotionEffectTypeWrapper(30, "dolphins_grace");

    /**
     * 不祥之兆.
     */
    public static final PotionEffectType BAD_OMEN = new PotionEffectTypeWrapper(31, "bad_omen");

    /**
     * 村庄英雄.
     */
    public static final PotionEffectType HERO_OF_THE_VILLAGE = new PotionEffectTypeWrapper(32, "hero_of_the_village");

    private final int id;
    private final NamespacedKey key;

    protected PotionEffectType(int id, @NotNull NamespacedKey key) {
        this.id = id;
        this.key = key;
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
    public PotionEffect createEffect(int duration, int amplifier) {
        return new PotionEffect(this, isInstant() ? 1 : (int) (duration * getDurationModifier()), amplifier);
    }

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
    public int getId() {
        return id;
    }

    @NotNull
    @Override
    public NamespacedKey getKey() {
       return key;
    }

    /**
     * 返回本状态效果类型的名称.
     * <p>
     * 原文:Returns the name of this effect type.
     *
     * @return 状态效果名
     */
    @NotNull
    public abstract String getName();

    /**
     * 返回本效果是否为瞬时型效果.
     * <p>
     * 原文:Returns whether the effect of this type happens once, immediately.
     *
     * @return 是否为瞬时型效果
     */
    public abstract boolean isInstant();

    /**
     * 返回本效果的颜色.
     * <p>
     * 原文:Returns the color of this effect type.
     *
     * @return 颜色
     */
    @NotNull
    public abstract Color getColor();

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof PotionEffectType)) {
            return false;
        }
        final PotionEffectType other = (PotionEffectType) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "PotionEffectType[" + id + ", " + getName() + "]";
    }

    private static final PotionEffectType[] byId = new PotionEffectType[33];
    private static final Map<String, PotionEffectType> byName = new HashMap<String, PotionEffectType>();
    private static final Map<NamespacedKey, PotionEffectType> byKey = new HashMap<NamespacedKey, PotionEffectType>();
    // will break on updates.
    private static boolean acceptingNew = true;

    /**
     * 根据指定 key 获取效果.
     * <p>
     * 原文:Gets the PotionEffectType at the specified key
     *
     * @param key 效果键名
     * @return 对应的效果类型, 如果找不到返回 null
     */
    @Contract("null -> null")
    @Nullable
    public static PotionEffectType getByKey(@Nullable NamespacedKey key) {
        return byKey.get(key);
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
        if (id >= byId.length || id < 0)
            return null;
        return byId[id];
    }

    /**
     * 根据指定名称获取效果.
     * <p>
     * 原文:Gets the effect type specified by the given name.
     *
     * @param name 状态效果名
     * @return 对应的效果类型, 如果找不到返回 null
     */
    @Nullable
    public static PotionEffectType getByName(@NotNull String name) {
        Validate.notNull(name, "name cannot be null");
        return byName.get(name.toLowerCase(java.util.Locale.ENGLISH));
    }

    /**
     * 注册给定的状态效果类型对象.
     * <p>
     * 通常不由插件使用.
     * <p>
     * 原文:Registers an effect type with the given object.
     * <p>
     * Generally not to be used from within a plugin.
     *
     * @param type 要注册的类型
     */
    public static void registerPotionEffectType(@NotNull PotionEffectType type) {
        if (byId[type.id] != null || byName.containsKey(type.getName().toLowerCase(java.util.Locale.ENGLISH)) || byKey.containsKey(type.key)) {
            throw new IllegalArgumentException("Cannot set already-set type");
        } else if (!acceptingNew) {
            throw new IllegalStateException(
                    "No longer accepting new potion effect types (can only be done by the server implementation)");
        }

        byId[type.id] = type;
        byName.put(type.getName().toLowerCase(java.util.Locale.ENGLISH), type);
        byKey.put(type.key, type);
    }

    /**
     * 停止接受任何新效果的注册.
     * <p>
     * 原文:Stops accepting any effect type registrations.
     */
    public static void stopAcceptingRegistrations() {
        acceptingNew = false;
    }

    /**
     * 返回一个所有已注册效果类型的数组. 此数组不一定按特定顺序编排.
     * <p>
     * 原文:Returns an array of all the registered {@link PotionEffectType}s.
     * This array is not necessarily in any particular order.
     *
     * @return 所有已注册效果类型的数组
     */
    @NotNull
    public static PotionEffectType[] values() {
        return Arrays.copyOfRange(byId, 1, byId.length);
    }
}
