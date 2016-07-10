package org.bukkit.material;

import org.bukkit.DyeColor;
import org.bukkit.Material;

/**
 * 代表染料
 */
public class Dye extends MaterialData implements Colorable {
    public Dye() {
        super(Material.INK_SACK);
    }

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Dye(final int type) {
        super(type);
    }

    public Dye(final Material type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Dye(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Dye(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * @param color 染料的颜色
     */
    public Dye(final DyeColor color) {
        super(Material.INK_SACK, color.getDyeData());
    }

    /**
     * 获取这个染料的颜色.
     * <p>
     * 原文:Gets the current color of this dye
     *
     * @return 这个染料的 DyeColor
     */
    public DyeColor getColor() {
        return DyeColor.getByDyeData(getData());
    }

    /**
     * 设置这个染料的颜色
     * <p>
     * 原文:
     * Sets the color of this dye
     *
     * @param color 新颜色
     */
    public void setColor(DyeColor color) {
        setData(color.getDyeData());
    }

    @Override
    public String toString() {
        return getColor() + " DYE(" + getData() + ")";
    }

    @Override
    public Dye clone() {
        return (Dye) super.clone();
    }
}
