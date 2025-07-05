package org.bukkit.inventory.meta.trim;

import org.bukkit.Keyed;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.Translatable;
import org.bukkit.registry.RegistryAware;
import org.jetbrains.annotations.NotNull;

/**
 * 表示可以在 {@link ArmorTrim} 中使用的图案。
 * <p>
 * 原文: Represents a pattern that may be used in an {@link ArmorTrim}.
 */
public interface TrimPattern extends Keyed, Translatable, RegistryAware {

    /**
     * 哨兵盔甲纹饰
     * {@link Material#SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern SENTRY = getTrimPattern("sentry");
    /**
     * 沙丘盔甲纹饰
     * {@link Material#DUNE_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern DUNE = getTrimPattern("dune");
    /**
     * 海岸盔甲纹饰
     * {@link Material#COAST_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern COAST = getTrimPattern("coast");
    /**
     * 荒野盔甲纹饰
     * {@link Material#WILD_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern WILD = getTrimPattern("wild");
    /**
     * 监守盔甲纹饰
     * {@link Material#WARD_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern WARD = getTrimPattern("ward");
    /**
     * 眼眸盔甲纹饰
     * {@link Material#EYE_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern EYE = getTrimPattern("eye");
    /**
     * 恼鬼盔甲纹饰
     * {@link Material#VEX_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern VEX = getTrimPattern("vex");
    /**
     * 潮汐盔甲纹饰
     * {@link Material#TIDE_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern TIDE = getTrimPattern("tide");
    /**
     * 猪鼻盔甲纹饰
     * {@link Material#SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern SNOUT = getTrimPattern("snout");
    /**
     * 肋骨盔甲纹饰
     * {@link Material#RIB_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern RIB = getTrimPattern("rib");
    /**
     * 尖塔盔甲纹饰
     * {@link Material#SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern SPIRE = getTrimPattern("spire");
    /**
     * 向导盔甲纹饰
     * {@link Material#WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern WAYFINDER = getTrimPattern("wayfinder");
    /**
     * 塑形盔甲纹饰
     * {@link Material#SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern SHAPER = getTrimPattern("shaper");
    /**
     * 幽静盔甲纹饰
     * {@link Material#SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern SILENCE = getTrimPattern("silence");
    /**
     * 牧民盔甲纹饰
     * {@link Material#RAISER_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern RAISER = getTrimPattern("raiser");
    /**
     * 雇主盔甲纹饰
     * {@link Material#HOST_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern HOST = getTrimPattern("host");
    /**
     * 涡流盔甲纹饰
     * {@link Material#FLOW_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern FLOW = getTrimPattern("flow");
    /**
     * 镶铆盔甲纹饰
     * {@link Material#BOLT_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern BOLT = getTrimPattern("bolt");

    @NotNull
    private static TrimPattern getTrimPattern(@NotNull String key) {
        return Registry.TRIM_PATTERN.getOrThrow(NamespacedKey.minecraft(key));
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
    NamespacedKey getKey();
}