package org.bukkit.potion;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.apache.commons.lang.Validate;
import org.bukkit.Color;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一个药水效果, 可应用于 {@link LivingEntity}.
 * 药水效果有持续时长、倍率、作用于实体上的{@link PotionEffectType 效果类型}属性.
 */
@SerializableAs("PotionEffect")
public class PotionEffect implements ConfigurationSerializable {
    private static final String AMPLIFIER = "amplifier";
    private static final String DURATION = "duration";
    private static final String TYPE = "effect";
    private static final String AMBIENT = "ambient";
    private static final String PARTICLES = "has-particles";
    private static final String ICON = "has-icon";
    private final int amplifier;
    private final int duration;
    private final PotionEffectType type;
    private final boolean ambient;
    private final boolean particles;
    private final boolean icon;

    /**
     * 创建一个药水效果.
     * <p>
     * 原文:Creates a potion effect.
     * @param type 效果类型
     * @param duration 持续时长 (单位为tick), 见 {@link
     *     PotionEffect#getDuration()}
     * @param amplifier 效果倍率, 见 {@link PotionEffect#getAmplifier()}
     * @param ambient ambient 状态, 见 {@link PotionEffect#isAmbient()}
     * @param particles 粒子可见性, 见 {@link PotionEffect#hasParticles()}
     * @param icon 图标可见性, 见 {@link PotionEffect#hasIcon()}
     */
    public PotionEffect(@NotNull PotionEffectType type, int duration, int amplifier, boolean ambient, boolean particles, boolean icon) {
        Validate.notNull(type, "effect type cannot be null");
        this.type = type;
        this.duration = duration;
        this.amplifier = amplifier;
        this.ambient = ambient;
        this.particles = particles;
        this.icon = icon;
    }

    /**
     * 创建一个药水效果, 不定义粒子颜色.
     * <p>
     * 原文:Creates a potion effect with no defined color.
     *
     * @param type 效果类型
     * @param duration 持续时长 (单位为tick), 见 {@link
     *     PotionEffect#getDuration()}
     * @param amplifier 效果倍率, 见 {@link PotionEffect#getAmplifier()}
     * @param ambient ambient 状态, 见 {@link PotionEffect#isAmbient()}
     * @param particles 粒子可见性, 见 {@link PotionEffect#hasParticles()}
     */
    public PotionEffect(@NotNull PotionEffectType type, int duration, int amplifier, boolean ambient, boolean particles) {
        this(type, duration, amplifier, ambient, particles, particles);
    }

    /**
     * 创建一个药水效果, 使粒子效果可见.
     * <p>
     * 原文:Creates a potion effect. Assumes that particles are visible
     *
     * @param type 效果类型
     * @param duration 持续时长 (单位为tick), 见 {@link
     *     PotionEffect#getDuration()}
     * @param amplifier 效果倍率, 见 {@link PotionEffect#getAmplifier()}
     * @param ambient ambient 状态, 见 {@link PotionEffect#isAmbient()}
     */
    public PotionEffect(@NotNull PotionEffectType type, int duration, int amplifier, boolean ambient) {
        this(type, duration, amplifier, ambient, true);
    }

    /**
     * 创建一个药水效果, 使 ambient 为 true.
     * <p>
     * 原文:Creates a potion effect. Assumes ambient is true.
     *
     * @param type 效果类型
     * @param duration 持续时长 (单位为tick)
     * @param amplifier 效果倍率
     * @see PotionEffect#PotionEffect(PotionEffectType, int, int, boolean)
     */
    public PotionEffect(@NotNull PotionEffectType type, int duration, int amplifier) {
        this(type, duration, amplifier, true);
    }

    /**
     * 用于反序列化的构造器.
     * <p>
     * 原文:Constructor for deserialization.
     *
     * @param map 反序列化使用的map
     */
    public PotionEffect(@NotNull Map<String, Object> map) {
        this(getEffectType(map), getInt(map, DURATION), getInt(map, AMPLIFIER), getBool(map, AMBIENT, false), getBool(map, PARTICLES, true), getBool(map, ICON, getBool(map, PARTICLES, true)));
    }

    @NotNull
    private static PotionEffectType getEffectType(@NotNull Map<?, ?> map) {
        int type = getInt(map, TYPE);
        PotionEffectType effect = PotionEffectType.getById(type);
        if (effect != null) {
            return effect;
        }
        throw new NoSuchElementException(map + " does not contain " + TYPE);
    }

    private static int getInt(@NotNull Map<?, ?> map, @NotNull Object key) {
        Object num = map.get(key);
        if (num instanceof Integer) {
            return (Integer) num;
        }
        throw new NoSuchElementException(map + " does not contain " + key);
    }

    private static boolean getBool(@NotNull Map<?, ?> map, @NotNull Object key, boolean def) {
        Object bool = map.get(key);
        if (bool instanceof Boolean) {
            return (Boolean) bool;
        }
        return def;
    }

    @Override
    @NotNull
    public Map<String, Object> serialize() {
        return ImmutableMap.<String, Object>builder()
            .put(TYPE, type.getId())
            .put(DURATION, duration)
            .put(AMPLIFIER, amplifier)
            .put(AMBIENT, ambient)
            .put(PARTICLES, particles)
            .put(ICON, icon)
            .build();
    }

    /**
     * 尝试添加此效果到指定的{@link LivingEntity 生物}上.
     * <p>
     * 原文:Attempts to add the effect represented by this object to the given
     * {@link LivingEntity}.
     *
     * @param entity 效果施加实体对象
     * @return 效果是否可添加/添加成功
     * @see LivingEntity#addPotionEffect(PotionEffect)
     */
    public boolean apply(@NotNull LivingEntity entity) {
        return entity.addPotionEffect(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PotionEffect)) {
            return false;
        }
        PotionEffect that = (PotionEffect) obj;
        return this.type.equals(that.type) && this.ambient == that.ambient && this.amplifier == that.amplifier && this.duration == that.duration && this.particles == that.particles && this.icon == that.icon;
    }

    /**
     * 返回此效果的倍率. 更高的倍率意味着此药水效果在其作用时间内作用更频繁,
     * 或者对目标有更多(更强)的效果.
     * <p>
     * 原文:Returns the amplifier of this effect. A higher amplifier means the
     * potion effect happens more often over its duration and in some cases
     * has more effect on its target.
     *
     * @return 效果倍率
     */
    public int getAmplifier() {
        return amplifier;
    }

    /**
     * 返回此效果的持续时间 (单位为tick).
     * <p>
     * 原文:Returns the duration (in ticks) that this effect will run for when
     * applied to a {@link LivingEntity}.
     *
     * @return 效果持续时间
     */
    public int getDuration() {
        return duration;
    }

    /**
     * 返回此效果的类型.
     * <p>
     * 原文:Returns the {@link PotionEffectType} of this effect.
     *
     * @return 药水效果的类型
     */
    @NotNull
    public PotionEffectType getType() {
        return type;
    }

    /**
     * 此状态使药水效果产生更多的、半透明的粒子.
     * <p>
     * 原文:Makes potion effect produce more, translucent, particles.
     *
     * @return 此药水效果是否为环境型效果 (译注:比如信标产生的效果)
     */
    public boolean isAmbient() {
        return ambient;
    }

    /**
     * @return 此效果是否有粒子效果
     */
    public boolean hasParticles() {
        return particles;
    }

    /**
     * @return 药水效果粒子的颜色. 如果无粒子效果/未定义颜色, 将可能为null
     * @deprecated 现在粒子效果颜色不属于药水效果的一部分
     */
     @Deprecated
     @Nullable
     @Contract("-> null")
    public Color getColor() {
        return null;
    }

    /**
     * @return 此效果是否有图标
     */
    public boolean hasIcon() {
        return icon;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 31 + type.hashCode();
        hash = hash * 31 + amplifier;
        hash = hash * 31 + duration;
        hash ^= 0x22222222 >> (ambient ? 1 : -1);
        hash ^= 0x22222222 >> (particles ? 1 : -1);
        hash ^= 0x22222222 >> (icon ? 1 : -1);
        return hash;
    }

    @Override
    public String toString() {
        return type.getName() + (ambient ? ":(" : ":") + duration + "t-x" + amplifier + (ambient ? ")" : "");
    }
}
