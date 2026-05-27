package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.TreeSpecies;

/**
 * 代表不同类型的朝向特定方向的树苗方块。
 *
 * @see Material#LEGACY_SAPLING
 *
 * @deprecated 所有 MaterialData 的用法都已弃用并可能被移除。
 * 请使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class Sapling extends Wood {

    /**
     * 构造一个树苗。
     * <p>原文：Constructs a sapling.
     */
    public Sapling() {
        this(DEFAULT_SPECIES);
    }

    /**
     * 构造一个给定树种的树苗。
     *
     * @param species 树苗的树种
     * <p>原文：Constructs a sapling of the given tree species.
     */
    public Sapling(TreeSpecies species) {
        this(species, false);
    }

    /**
     * 构造一个给定树种的树苗，并指定其是否可以立即生长。
     *
     * @param species 树苗方块的树种
     * @param isInstantGrowable 如果树苗应在下次被骨粉催熟时生长则为 true
     * <p>原文：Constructs a sapling of the given tree species and if is it instant
     * growable
     */
    public Sapling(TreeSpecies species, boolean isInstantGrowable) {
        this(Material.LEGACY_SAPLING, species, isInstantGrowable);
    }

    /**
     * 构造一个给定类型的树苗。
     *
     * @param type 树苗方块的类型
     * <p>原文：Constructs a sapling of the given type.
     */
    public Sapling(final Material type) {
        this(type, DEFAULT_SPECIES, false);
    }

    /**
     * 构造一个给定类型和树种的树苗。
     *
     * @param type 树苗的类型
     * @param species 树苗的树种
     * <p>原文：Constructs a sapling of the given type and tree species.
     */
    public Sapling(final Material type, TreeSpecies species) {
        this(type, species, false);
    }

    /**
     * 构造一个给定类型和树种的树苗，并指定其是否可以立即生长。
     *
     * @param type 树苗的类型
     * @param species 树苗的树种
     * @param isInstantGrowable 如果树苗应在下次被骨粉催熟时生长则为 true
     * <p>原文：Constructs a sapling of the given type and tree species and if is it
     * instant growable
     */
    public Sapling(final Material type, TreeSpecies species, boolean isInstantGrowable) {
        super(type, species);
        setIsInstantGrowable(isInstantGrowable);
    }

    /**
     * @param type 物品类型
     * @param data 原始数据值
     * @deprecated 魔法值
     * <p>原文：Magic value
     */
    @Deprecated(since = "1.9")
    public Sapling(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 检查树苗是否会在下次被骨粉催熟时生长。
     *
     * @return 如果树苗会在下次被骨粉催熟时生长则返回 true
     * <p>原文：Checks if the Sapling would grow when next ticked with bonemeal
     */
    public boolean isInstantGrowable() {
        return (getData() & 0x8) == 0x8;
    }

    /**
     * 设置此树苗是否会在下次被骨粉催熟时生长。
     *
     * @param isInstantGrowable 如果树苗应在下次被骨粉催熟时生长则为 true
     * <p>原文：Set whether this sapling will grow when next ticked with bonemeal
     */
    public void setIsInstantGrowable(boolean isInstantGrowable) {
        setData(isInstantGrowable ? (byte) ((getData() & 0x7) | 0x8) : (byte) (getData() & 0x7));
    }

    @Override
    public String toString() {
        return getSpecies() + " " + (isInstantGrowable() ? " IS_INSTANT_GROWABLE " : "") + " " + super.toString();
    }

    @Override
    public Sapling clone() {
        return (Sapling) super.clone();
    }
}