package org.bukkit.inventory.meta.trim;

import org.bukkit.Keyed;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.Translatable;

/**
 * 表示可以在 {@link ArmorTrim} 中使用的图案。
 * <p>
 * 原文: Represents a pattern that may be used in an {@link ArmorTrim}.
 */
public interface TrimPattern extends Keyed, Translatable {

    /**
     * 哨兵盔甲纹饰
     * {@link Material#SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern SENTRY = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("sentry"));
    /**
     * 沙丘盔甲纹饰
     * {@link Material#DUNE_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern DUNE = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("dune"));
    /**
     * 海岸盔甲纹饰
     * {@link Material#COAST_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern COAST = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("coast"));
    /**
     * 荒野盔甲纹饰
     * {@link Material#WILD_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern WILD = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("wild"));
    /**
     * 监守盔甲纹饰
     * {@link Material#WARD_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern WARD = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("ward"));
    /**
     * 眼眸盔甲纹饰
     * {@link Material#EYE_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern EYE = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("eye"));
    /**
     * 恼鬼盔甲纹饰
     * {@link Material#VEX_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern VEX = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("vex"));
    /**
     * 潮汐盔甲纹饰
     * {@link Material#TIDE_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern TIDE = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("tide"));
    /**
     * 猪鼻盔甲纹饰
     * {@link Material#SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern SNOUT = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("snout"));
    /**
     * 肋骨盔甲纹饰
     * {@link Material#RIB_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern RIB = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("rib"));
    /**
     * 尖塔盔甲纹饰
     * {@link Material#SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern SPIRE = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("spire"));
    /**
     * 向导盔甲纹饰
     * {@link Material#WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern WAYFINDER = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("wayfinder"));
    /**
     * 塑形盔甲纹饰
     * {@link Material#SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern SHAPER = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("shaper"));
    /**
     * 幽静盔甲纹饰
     * {@link Material#SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern SILENCE = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("silence"));
    /**
     * 牧民盔甲纹饰
     * {@link Material#RAISER_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern RAISER = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("raiser"));
    /**
     * 雇主盔甲纹饰
     * {@link Material#HOST_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern HOST = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("host"));
    /**
     * 涡流盔甲纹饰
     * {@link Material#FLOW_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern FLOW = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("flow"));
    /**
     * 镶铆盔甲纹饰
     * {@link Material#BOLT_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern BOLT = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("bolt"));
}
