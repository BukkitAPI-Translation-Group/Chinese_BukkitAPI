package org.bukkit.material;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

/**
 * 代表不同的台阶.
 */
public class Step extends TexturedMaterial {
    private static final List<Material> textures = new ArrayList<Material>();
    static {
        textures.add(Material.LEGACY_STONE);
        textures.add(Material.LEGACY_SANDSTONE);
        textures.add(Material.LEGACY_WOOD);
        textures.add(Material.LEGACY_COBBLESTONE);
        textures.add(Material.LEGACY_BRICK);
        textures.add(Material.LEGACY_SMOOTH_BRICK);
        textures.add(Material.LEGACY_NETHER_BRICK);
        textures.add(Material.LEGACY_QUARTZ_BLOCK);
    }

    public Step() {
        super(Material.LEGACY_STEP);
    }

    public Step(final Material type) {
        super((textures.contains(type)) ? Material.LEGACY_STEP : type);
        if (textures.contains(type)) {
            setMaterial(type);
        }
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
     * 检查此台阶是否被反转.
     * <p>
     * 原文:Test if step is inverted
     *
     * @return 上半台阶(反转的台阶)为true，普通台阶(底部台阶)为false
     */
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
