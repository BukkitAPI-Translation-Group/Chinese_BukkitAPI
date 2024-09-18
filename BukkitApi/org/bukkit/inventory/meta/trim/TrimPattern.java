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
     * 哨兵盔甲纹饰制作模板
     * {@link Material#SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern SENTRY = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("sentry"));
    /**
     * 沙丘盔甲纹饰制作模板
     * {@link Material#DUNE_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern DUNE = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("dune"));
    /**
     * 海岸盔甲纹饰制作模板
     * {@link Material#COAST_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern COAST = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("coast"));
    /**
     * 野性盔甲纹饰制作模板
     * {@link Material#WILD_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern WILD = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("wild"));
    /**
     * 守卫盔甲纹饰制作模板
     * {@link Material#WARD_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern WARD = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("ward"));
    /**
     * 眼睛盔甲纹饰制作模板
     * {@link Material#EYE_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern EYE = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("eye"));
    /**
     * 恶魔盔甲纹饰制作模板
     * {@link Material#VEX_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern VEX = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("vex"));
    /**
     * 潮汐盔甲纹饰制作模板
     * {@link Material#TIDE_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern TIDE = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("tide"));
    /**
     * 鼻子盔甲纹饰制作模板
     * {@link Material#SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern SNOUT = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("snout"));
    /**
     * 肋骨盔甲纹饰制作模板
     * {@link Material#RIB_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern RIB = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("rib"));
    /**
     * 尖塔盔甲纹饰制作模板
     * {@link Material#SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern SPIRE = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("spire"));
    /**
     * 探路者盔甲纹饰制作模板
     * {@link Material#WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern WAYFINDER = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("wayfinder"));
    /**
     * 造型师盔甲纹饰制作模板
     * {@link Material#SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern SHAPER = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("shaper"));
    /**
     * 沉默盔甲纹饰制作模板
     * {@link Material#SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern SILENCE = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("silence"));
    /**
     * 提升者盔甲纹饰制作模板
     * {@link Material#RAISER_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern RAISER = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("raiser"));
    /**
     * 宿主盔甲纹饰制作模板
     * {@link Material#HOST_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern HOST = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("host"));
    /**
     * 流动盔甲纹饰制作模板
     * {@link Material#FLOW_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern FLOW = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("flow"));
    /**
     * 闪电盔甲纹饰制作模板
     * {@link Material#BOLT_ARMOR_TRIM_SMITHING_TEMPLATE}.
     */
    public static final TrimPattern BOLT = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("bolt"));
}
