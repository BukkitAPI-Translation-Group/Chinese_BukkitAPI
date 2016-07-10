package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.TreeSpecies;

/**
 * 代表不同种类的树苗.
 *
 * @see Material#SAPLING
 */
public class Sapling extends Wood {

    /**
     * 构造本类.
     * <p>
     * 原文:Constructs a sapling.
     */
    public Sapling() {
        this(DEFAULT_SPECIES);
    }

    /**
     * 以给定的树木种类构造本类.
     * <p>
     * 原文:Constructs a sapling of the given tree species.
     *
     * @param species 树苗的树木种类
     */
    public Sapling(TreeSpecies species) {
        this(species, false);
    }

    /**
     * 以给定的树木种类和是否顷刻间长成构造本类.
     * <p>
     * 原文:Constructs a sapling of the given tree species and if is it instant
     * growable
     *
     * @param species 木头的树木种类
     * @param isInstantGrowable true 如果树苗应该在用使用骨粉时瞬间长大
     */
    public Sapling(TreeSpecies species, boolean isInstantGrowable) {
        this(Material.SAPLING, species, isInstantGrowable);
    }

    /**
     * 以给定的物品种类构造本类.
     * <p>
     * 原文:Constructs a sapling of the given type.
     *
     * @param type 木头的树木种类
     */
    public Sapling(final Material type) {
        this(type, DEFAULT_SPECIES, false);
    }

    /**
     * 以给定的物品种类和树木种类构造本类.
     * <p>
     * 原文:Constructs a sapling of the given type and tree species.
     *
     * @param type 树苗的物品种类
     * @param species 树苗的树木种类
     */
    public Sapling(final Material type, TreeSpecies species) {
        this(type, species, false);
    }

    /**
     * 以给定的物品种类和树木种类和是否瞬间长大构造本类.
     * <p>
     * 原文:Constructs a sapling of the given type and tree species and if is it
     * instant growable
     *
     * @param type 树苗的物品种类
     * @param species 树苗的树木种类
     * @param isInstantGrowable true 如果树苗应该在用使用骨粉时瞬间长大
     */
    public Sapling(final Material type, TreeSpecies species, boolean isInstantGrowable) {
        super(type, species);
        setIsInstantGrowable(isInstantGrowable);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Sapling(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Sapling(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 检测这个树苗是否应该在用使用骨粉时瞬间长大(可以长成树).
     * <p>
     * 原文:Checks if the Sapling would grow when next ticked with bonemeal
     *
     * @return 这个树苗是否应该在用使用骨粉时瞬间长大
     */
    public boolean isInstantGrowable() {
        return (getData() & 0x8) == 0x8;
    }

    /**
     * 设置这个树苗是否应该在用使用骨粉时瞬间长大(可以长成树).
     * <p>
     * 原文：Set whether this sapling will grow when next ticked with bonemeal
     *
     * @param isInstantGrowable 这个树苗是否应该在用使用骨粉时瞬间长大
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
