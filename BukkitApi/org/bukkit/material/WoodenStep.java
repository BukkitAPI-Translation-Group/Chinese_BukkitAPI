package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.TreeSpecies;

/**
 * 代表不同种类的木台阶
 *
 * @see Material#WOOD_STEP
 */
public class WoodenStep extends Wood {
    protected static final Material DEFAULT_TYPE = Material.WOOD_STEP;
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
     * 以给定的树木种类构造本类.
     * <p>
     * 原文:Constructs a wooden step of the given tree species.
     *
     * @param species 这个台阶的树木种类
     */
    public WoodenStep(TreeSpecies species) {
        this(species, DEFAULT_INVERTED);
    }

    /**
     * 以给定的树木种类和台阶类型(上半台阶和普通台阶)构造本类.
     * <p>
     * 原文:Constructs a wooden step of the given type and tree species, either
     * inverted or not.
     *
     * @param species 这个台阶的树木种类
     * @param inv 如果这是上半台阶则为true
     */
    public WoodenStep(final TreeSpecies species, boolean inv) {
        super(DEFAULT_TYPE, species);
        setInverted(inv);
    }

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public WoodenStep(final int type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public WoodenStep(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public WoodenStep(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 这个台阶是否被反转的。
     * <p>
     * 原文:Test if step is inverted
     *
     * @return true为反转的(上半), false为正常形态(下半)
     */
    @SuppressWarnings("deprecation")
    public boolean isInverted() {
        return ((getData() & 0x8) != 0);
    }

    /**
     * 设置这个台阶是否被反转。
     * <p>
     * 原文:Set step inverted state
     *
     * @param inv true为反转的(上半), false为正常形态(下半)
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
