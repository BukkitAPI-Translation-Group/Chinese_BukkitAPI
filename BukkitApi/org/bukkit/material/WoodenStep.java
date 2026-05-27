package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.TreeSpecies;

/**
 * 代表不同的木台阶.
 *
 * @see Material#LEGACY_WOOD_STEP
 *
 * @deprecated 所有MaterialData的用法都已弃用并将被移除。请使用{@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class WoodenStep extends Wood {
    protected static final Material DEFAULT_TYPE = Material.LEGACY_WOOD_STEP;
    protected static final boolean DEFAULT_INVERTED = false;

    /**
     * 构造本类.
     * <p>
     * 原文:Constructs a wooden step.
     */
    public WoodenStep() {
        this(DEFAULT_SPECIES, DEFAULT_INVERTED);
    }

    /**
     * 以指定的树种构造本类.
     * <p>
     * 原文:Constructs a wooden step of the given tree species.
     *
     * @param species 木台阶的树种
     */
    public WoodenStep(TreeSpecies species) {
        this(species, DEFAULT_INVERTED);
    }

    /**
     * 以指定的树种和台阶类型(上半台阶和普通台阶)构造本类.
     * <p>
     * 原文:Constructs a wooden step of the given type and tree species, either
     * inverted or not.
     *
     * @param species 木台阶的树种
     * @param inv 为true时表示上半台阶（方块顶部），为false时表示普通台阶（底部台阶）
     */
    public WoodenStep(final TreeSpecies species, boolean inv) {
        super(DEFAULT_TYPE, species);
        setInverted(inv);
    }

    /**
     * @param type 材质类型
     * @param data 原始数据值
     * @deprecated 不安全的参数
     */
    @Deprecated(since = "1.6.2")
    public WoodenStep(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 检查此台阶是否被反转.
     * <p>
     * 原文:Test if step is inverted
     *
     * @return 上半台阶(反转的台阶)为true，普通台阶(底部台阶)为false
     */
    @SuppressWarnings("deprecation")
    public boolean isInverted() {
        return ((getData() & 0x8) != 0);
    }

    /**
     * 设置台阶是否被反转.
     * <p>
     * 原文:Set step inverted state
     *
     * @param inv - 上半台阶(反转的台阶)为true，普通台阶(底部台阶)为false
     */
    @SuppressWarnings("deprecation")
    public void setInverted(boolean inv) {
        int dat = getData() & 0x7;
        if (inv) {
            dat |= 0x8;
        }
        setData((byte) dat);
    }

    @Override
    public WoodenStep clone() {
        return (WoodenStep) super.clone();
    }

    @Override
    public String toString() {
        return super.toString() + " " + getSpecies() + (isInverted() ? " inverted" : "");
    }
}
