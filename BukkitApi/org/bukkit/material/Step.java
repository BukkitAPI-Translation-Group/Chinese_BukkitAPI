package org.bukkit.material;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

/**
 * 代表不同种类的台阶。
 */
public class Step extends TexturedMaterial {
    private static final List<Material> textures = new ArrayList<Material>();
    static {
        textures.add(Material.STONE);
        textures.add(Material.SANDSTONE);
        textures.add(Material.WOOD);
        textures.add(Material.COBBLESTONE);
        textures.add(Material.BRICK);
        textures.add(Material.SMOOTH_BRICK);
        textures.add(Material.NETHER_BRICK);
        textures.add(Material.QUARTZ_BLOCK);
    }

    public Step() {
        super(Material.STEP);
    }

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Step(final int type) {
        super(type);
    }

    public Step(final Material type) {
        super((textures.contains(type)) ? Material.STEP : type);
        if (textures.contains(type)) {
            setMaterial(type);
        }
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Step(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Step(final Material type, final byte data) {
        super(type, data);
    }

    @Override
    public List<Material> getTextures() {
        return textures;
    }

    /**
     * 看看一个台阶是否被反转了。
     * 原文:Test if step is inverted
     *
     * @return true 如果台阶被反转(上半块)，false 一般状态(下半块)
     * 原文：if inverted (top half), false if normal (bottom half)
     */
    public boolean isInverted() {
        return ((getData() & 0x8) != 0);
    }

    /**
     * 设置反转状态.
     * <p>
     * 原文:Set step inverted state
     *
     * @param inv true 如果台阶是被反转的 (上半块), false 如果台阶一般状态 (下半块)
     */
    public void setInverted(boolean inv) {
        int dat = getData() & 0x7;
        if (inv) {
            dat |= 0x8;
        }
        setData((byte) dat);
    }

    /**
     *
     * @deprecated 不安全的参数
     */
    @Deprecated
    @Override
    protected int getTextureIndex() {
        return getData() & 0x7;
    }

    /**
     *
     * @deprecated 不安全的参数
     */
    @Deprecated
    @Override
    protected void setTextureIndex(int idx) {
        setData((byte) ((getData() & 0x8) | idx));
    }

    @Override
    public Step clone() {
        return (Step) super.clone();
    }

    @Override
    public String toString() {
        return super.toString() + (isInverted() ? "inverted" : "");
    }
}
