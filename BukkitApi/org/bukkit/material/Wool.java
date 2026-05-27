package org.bukkit.material;

import org.bukkit.DyeColor;
import org.bukkit.Material;

/**
 * 代表羊毛/地毯方块.
 * @deprecated 所有 MaterialData 的用法均已弃用并将在未来移用.
 * 请使用 {@link org.bukkit.block.data.BlockData}.
 */
@Deprecated(since = "1.14.1")
public class Wool extends MaterialData implements Colorable {
    public Wool() {
        super(Material.LEGACY_WOOL);
    }

    public Wool(DyeColor color) {
        this();
        setColor(color);
    }

    public Wool(final Material type) {
        super(type);
    }

    /**
     * @param type 物品/方块类型
     * @param data 原始数据值
     * @deprecated 不安全的参数
     */
    @Deprecated(since = "1.6.2")
    public Wool(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 获取染料(羊毛)的颜色.
     * <p>
     * 原文:Gets the current color of this dye
     *
     * @return DyeColor枚举颜色表示
     */
    @Override
    public DyeColor getColor() {
        return DyeColor.getByWoolData(getData());
    }

    /**
     * 设置染料(羊毛)的颜色.
     * <p>
     * 原文:Sets the color of this dye
     *
     * @param color 颜色
     */
    @Override
    public void setColor(DyeColor color) {
        setData(color.getWoolData());
    }

    @Override
    public String toString() {
        return getColor() + " " + super.toString();
    }

    @Override
    public Wool clone() {
        return (Wool) super.clone();
    }
}