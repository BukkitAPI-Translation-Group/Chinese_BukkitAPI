package org.bukkit.material;

import org.bukkit.DyeColor;
import org.bukkit.Material;

/**
 * 代表染料。
 *
 * @deprecated all usage of MaterialData is deprecated and subject to removal.
 * Use {@link org.bukkit.block.data.BlockData}.
 */
@Deprecated(since = "1.14.1")
public class Dye extends MaterialData implements Colorable {
    public Dye() {
        super(Material.LEGACY_INK_SACK);
    }

    public Dye(final Material type) {
        super(type);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated Magic value
     */
    @Deprecated(since = "1.6.2")
    public Dye(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * @param color color of the dye
     */
    public Dye(final DyeColor color) {
        super(Material.LEGACY_INK_SACK, color.getDyeData());
    }

    /**
     * 获取此染料的当前颜色。
     * <p>原文：Gets the current color of this dye
     *
     * @return DyeColor of this dye
     */
    @Override
    public DyeColor getColor() {
        return DyeColor.getByDyeData(getData());
    }

    /**
     * 设置此染料的颜色。
     * <p>原文：Sets the color of this dye
     *
     * @param color New color of this dye
     */
    @Override
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