package org.bukkit.potion;

import com.google.common.base.Preconditions;
import com.google.common.base.Suppliers;
import java.util.List;
import java.util.function.Supplier;
import org.bukkit.Bukkit;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.registry.RegistryAware;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 药水种类枚举, 反应并匹配创造模式物品栏中可获取的每种药水的状态.
 */
public enum PotionType implements Keyed, RegistryAware {
    WATER("water"),
    MUNDANE("mundane"),
    THICK("thick"),
    AWKWARD("awkward"),
    NIGHT_VISION("night_vision"),
    LONG_NIGHT_VISION("long_night_vision"),
    INVISIBILITY("invisibility"),
    LONG_INVISIBILITY("long_invisibility"),
    LEAPING("leaping"),
    LONG_LEAPING("long_leaping"),
    STRONG_LEAPING("strong_leaping"),
    FIRE_RESISTANCE("fire_resistance"),
    LONG_FIRE_RESISTANCE("long_fire_resistance"),
    SWIFTNESS("swiftness"),
    LONG_SWIFTNESS("long_swiftness"),
    STRONG_SWIFTNESS("strong_swiftness"),
    SLOWNESS("slowness"),
    LONG_SLOWNESS("long_slowness"),
    STRONG_SLOWNESS("strong_slowness"),
    WATER_BREATHING("water_breathing"),
    LONG_WATER_BREATHING("long_water_breathing"),
    HEALING("healing"),
    STRONG_HEALING("strong_healing"),
    HARMING("harming"),
    STRONG_HARMING("strong_harming"),
    POISON("poison"),
    LONG_POISON("long_poison"),
    STRONG_POISON("strong_poison"),
    REGENERATION("regeneration"),
    LONG_REGENERATION("long_regeneration"),
    STRONG_REGENERATION("strong_regeneration"),
    STRENGTH("strength"),
    LONG_STRENGTH("long_strength"),
    STRONG_STRENGTH("strong_strength"),
    WEAKNESS("weakness"),
    LONG_WEAKNESS("long_weakness"),
    LUCK("luck"),
    TURTLE_MASTER("turtle_master"),
    LONG_TURTLE_MASTER("long_turtle_master"),
    STRONG_TURTLE_MASTER("strong_turtle_master"),
    SLOW_FALLING("slow_falling"),
    LONG_SLOW_FALLING("long_slow_falling"),
    WIND_CHARGED("wind_charged"),
    WEAVING("weaving"),
    OOZING("oozing"),
    INFESTED("infested"),
    ;

    private final NamespacedKey key;
    private final Supplier<InternalPotionData> internalPotionDataSupplier;

    PotionType(String key) {
        this.key = NamespacedKey.minecraft(key);
        this.internalPotionDataSupplier = Suppliers.memoize(() -> Bukkit.getUnsafe().getInternalPotionData(this.key));
    }

    /**
     * @return the potion effect type of this potion type
     * @deprecated Potions can have multiple effects use {@link #getPotionEffects()}
     */
    @Nullable
    @Deprecated(since = "1.20.2")
    public PotionEffectType getEffectType() {
        return internalPotionDataSupplier.get().getEffectType();
    }

    /**
     * @return a list of all effects this potion type has
     */
    @NotNull
    public List<PotionEffect> getPotionEffects() {
        return internalPotionDataSupplier.get().getPotionEffects();
    }

    /**
     * @return if this potion type is instant
     * @deprecated PotionType can have multiple effects, some of which can be instant and others not.
     * Use {@link PotionEffectType#isInstant()} in combination with {@link #getPotionEffects()} and {@link PotionEffect#getType()}
     */
    @Deprecated(since = "1.20.2")
    public boolean isInstant() {
        return internalPotionDataSupplier.get().isInstant();
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
        return internalPotionDataSupplier.get().isUpgradeable();
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
        return internalPotionDataSupplier.get().isExtendable();
    }

    public int getMaxLevel() {
        return internalPotionDataSupplier.get().getMaxLevel();
    }

    @NotNull
    @Override
    public NamespacedKey getKeyOrThrow() {
        Preconditions.checkState(isRegistered(), "Cannot get key of this registry item, because it is not registered. Use #isRegistered() before calling this method.");
        return this.key;
    }

    @Nullable
    @Override
    public NamespacedKey getKeyOrNull() {
        return this.key;
    }

    @Override
    public boolean isRegistered() {
        return this.key != null;
    }

    /**
     * @param effectType 根据何种状态效果获取对应药水类型
     * @return 匹配的药水类型
     * @deprecated 有误导性
     */
    @Deprecated(since = "1.9")
    @Nullable
    public static PotionType getByEffect(@Nullable PotionEffectType effectType) {
        if (effectType == null)
            return WATER;
        for (PotionType type : PotionType.values()) {
            if (effectType.equals(type.getEffectType()))
                return type;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see #getKeyOrThrow()
     * @see #isRegistered()
     * @deprecated A key might not always be present, use {@link #getKeyOrThrow()} instead.
     */
    @NotNull
    @Override
    @Deprecated(since = "1.21.4")
    public NamespacedKey getKey() {
        return getKeyOrThrow();
    }

    /**
     * @deprecated 请勿使用, 该接口将被移除, 插件将无法运作
     */
    @Deprecated(since = "1.20.2")
    @ApiStatus.Internal
    public interface InternalPotionData {

        PotionEffectType getEffectType();

        List<PotionEffect> getPotionEffects();

        boolean isInstant();

        boolean isUpgradeable();

        boolean isExtendable();

        int getMaxLevel();
    }
}
