package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.TreeSpecies;

/**
 * 代表不同类型的树叶方块，这些方块可能是永久存在的，或者在距离原木太远时会腐烂。
 *
 * @see Material#LEGACY_LEAVES
 * @see Material#LEGACY_LEAVES_2
 *
 * @deprecated 所有 MaterialData 的使用都已弃用并可能被移除。
 * 使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class Leaves extends Wood {
    protected static final Material DEFAULT_TYPE = Material.LEGACY_LEAVES;
    protected static final boolean DEFAULT_DECAYABLE = true;

    /**
     * 构造一个树叶方块。
     * <p>
     * 原文：Constructs a leaf block.
     */
    public Leaves() {
        this(DEFAULT_TYPE, DEFAULT_SPECIES, DEFAULT_DECAYABLE);
    }

    /**
     * 构造指定树种的树叶方块。
     *
     * @param species 木方块的树种
     * <p>
     * 原文：Constructs a leaf block of the given tree species.
     */
    public Leaves(TreeSpecies species) {
        this(DEFAULT_TYPE, species, DEFAULT_DECAYABLE);
    }

    /**
     * 构造指定树种的树叶方块，并标记该树叶方块在距离原木太远时是否会消失。
     *
     * @param species 木方块的树种
     * @param isDecayable 方块是永久存在还是可以消失
     * <p>
     * 原文：Constructs a leaf block of the given tree species and flag for whether this leaf block will disappear when too far from a log.
     */
    public Leaves(TreeSpecies species, boolean isDecayable) {
        this(DEFAULT_TYPE, species, isDecayable);
    }

    /**
     * 构造指定类型的树叶方块。
     *
     * @param type 树叶方块的类型
     * <p>
     * 原文：Constructs a leaf block of the given type.
     */
    public Leaves(final Material type) {
        this(type, DEFAULT_SPECIES, DEFAULT_DECAYABLE);
    }

    /**
     * 构造指定类型和树种的树叶方块。
     *
     * @param type 树叶方块的类型
     * @param species 木方块的树种
     * <p>
     * 原文：Constructs a leaf block of the given type and tree species.
     */
    public Leaves(final Material type, TreeSpecies species) {
        this(type, species, DEFAULT_DECAYABLE);
    }

    /**
     * 构造指定类型和树种的树叶方块，并标记该树叶方块在距离原木太远时是否会消失。
     *
     * @param type 树叶方块的类型
     * @param species 木方块的树种
     * @param isDecayable 方块是永久存在还是可以消失
     * <p>
     * 原文：Constructs a leaf block of the given type and tree species and flag for whether this leaf block will disappear when too far from a log.
     */
    public Leaves(final Material type, TreeSpecies species, boolean isDecayable) {
        super(type, species);
        setDecayable(isDecayable);
    }

    /**
     * @param type 类型
     * @param data 原始数据值
     * @deprecated 魔法值
     */
    @Deprecated(since = "1.6.2")
    public Leaves(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 检查此树叶方块是否正在腐烂
     *
     * @return 如果树叶方块正在腐烂则返回true
     * <p>
     * 原文：Checks if this leaf block is in the process of decaying
     */
    public boolean isDecaying() {
        return (getData() & 0x8) != 0;
    }

    /**
     * 设置此树叶方块是否正在腐烂
     *
     * @param isDecaying 方块是否正在腐烂
     * <p>
     * 原文：Set whether this leaf block is in the process of decaying
     */
    public void setDecaying(boolean isDecaying) {
        setData((byte) ((getData() & 0x3) | (isDecaying
                ? 0x8 // Clear the permanent flag to make this a decayable flag and set the decaying flag
                : (getData() & 0x4)))); // Only persist the decayable flag if this is not a decaying block
    }

    /**
     * 检查此树叶方块是永久存在的还是在距离原木太远时会腐烂
     *
     * @return 如果树叶方块是永久存在的或在距离原木太远时会腐烂则返回true
     * <p>
     * 原文：Checks if this leaf block is permanent or can decay when too far from a log
     */
    public boolean isDecayable() {
        return (getData() & 0x4) == 0;
    }

    /**
     * 设置此树叶方块在距离原木太远时是否会消失
     *
     * @param isDecayable 方块是永久存在还是可以消失
     * <p>
     * 原文：Set whether this leaf block will disappear when too far from a log
     */
    public void setDecayable(boolean isDecayable) {
        setData((byte) ((getData() & 0x3) | (isDecayable
                ? (getData() & 0x8) // Only persist the decaying flag if this is a decayable block
                : 0x4)));
    }

    @Override
    public String toString() {
        return getSpecies() + (isDecayable() ? " DECAYABLE " : " PERMANENT ") + (isDecaying() ? " DECAYING " : " ") + super.toString();
    }

    @Override
    public Leaves clone() {
        return (Leaves) super.clone();
    }
}