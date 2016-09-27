package org.bukkit;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

/**
 * 染料和布料所有支持的颜色值.
 */
public enum DyeColor {

    /**
     * 代表白色染料.
     */
    WHITE(0x0, 0xF, Color.WHITE, Color.fromRGB(0xF0F0F0)),
    /**
     * 代表橙色染料.
     */
    ORANGE(0x1, 0xE, Color.fromRGB(0xD87F33), Color.fromRGB(0xEB8844)),
    /**
     * 代表品红色染料.
     */
    MAGENTA(0x2, 0xD, Color.fromRGB(0xB24CD8), Color.fromRGB(0xC354CD)),
    /**
     * 代表淡蓝色染料.
     */
    LIGHT_BLUE(0x3, 0xC, Color.fromRGB(0x6699D8), Color.fromRGB(0x6689D3)),
    /**
     * 代表黄色染料.
     */
    YELLOW(0x4, 0xB, Color.fromRGB(0xE5E533), Color.fromRGB(0xDECF2A)),
    /**
     * 代表黄绿色染料.
     */
    LIME(0x5, 0xA, Color.fromRGB(0x7FCC19), Color.fromRGB(0x41CD34)),
    /**
     * 代表粉色染料.
     */
    PINK(0x6, 0x9, Color.fromRGB(0xF27FA5), Color.fromRGB(0xD88198)),
    /**
     * 代表灰色染料.
     */
    GRAY(0x7, 0x8, Color.fromRGB(0x4C4C4C), Color.fromRGB(0x434343)),
    /**
     * 代表银色染料.
     * <p>
     * 译注:Minecraft Wiki中没有“银色染料”的说法，估计是淡灰色染料.
     */
    SILVER(0x8, 0x7, Color.fromRGB(0x999999), Color.fromRGB(0xABABAB)),
    /**
     * 代表青色染料.
     */
    CYAN(0x9, 0x6, Color.fromRGB(0x4C7F99), Color.fromRGB(0x287697)),
    /**
     * 代表紫色染料.
     */
    PURPLE(0xA, 0x5, Color.fromRGB(0x7F3FB2), Color.fromRGB(0x7B2FBE)),
    /**
     * 代表蓝色染料.
     */
    BLUE(0xB, 0x4, Color.fromRGB(0x334CB2), Color.fromRGB(0x253192)),
    /**
     * 代表棕色染料.
     */
    BROWN(0xC, 0x3, Color.fromRGB(0x664C33), Color.fromRGB(0x51301A)),
    /**
     * 代表绿色染料.
     */
    GREEN(0xD, 0x2, Color.fromRGB(0x667F33), Color.fromRGB(0x3B511A)),
    /**
     * 代表红色染料.
     */
    RED(0xE, 0x1, Color.fromRGB(0x993333), Color.fromRGB(0xB3312C)),
    /**
     * 代表黑色染料.
     */
    BLACK(0xF, 0x0, Color.fromRGB(0x191919), Color.fromRGB(0x1E1B1B));

    private final byte woolData;
    private final byte dyeData;
    private final Color color;
    private final Color firework;
    private final static DyeColor[] BY_WOOL_DATA;
    private final static DyeColor[] BY_DYE_DATA;
    private final static Map<Color, DyeColor> BY_COLOR;
    private final static Map<Color, DyeColor> BY_FIREWORK;

    private DyeColor(final int woolData, final int dyeData, Color color, Color firework) {
        this.woolData = (byte) woolData;
        this.dyeData = (byte) dyeData;
        this.color = color;
        this.firework = firework;
    }

    /**
     * 获取相关值(羊毛)的数据表示的颜色.
     * <p>
     * 原文:
     * Gets the associated (wool) data value representing this color.
     *
     * @return 包含这种颜色(羊毛)的数据值字节
     * @deprecated 这个名称具有误导性.但这将意味着{@link Material#INK_SACK}使用{@link Material#WOOL}.
     * @see #getWoolData()
     * @see #getDyeData()
     */
    @Deprecated
    public byte getData() {
        return getWoolData();
    }

    /**
     * 获取这个颜色代表的相关羊毛的数据值.
     * <p>
     * 原文:
     * Gets the associated wool data value representing this color.
     *
     * @return 包含这种颜色的羊毛的数据值字节
     * @see #getDyeData()
     * @deprecated 不安全的参数
     */
    @Deprecated
    public byte getWoolData() {
        return woolData;
    }

    /**
     * 获取代表这种颜色的染料数据值.
     * <p>
     * 原文:
     * Gets the associated dye data value representing this color.
     *
     * @return 包含这种颜色的染料数据值字节
     * @see #getWoolData()
     * @deprecated 魔法值
     */
    @Deprecated
    public byte getDyeData() {
        return dyeData;
    }

    /**
     * 获取这个染料代表的颜色.
     * <p>
     * 原文:
     * Gets the color that this dye represents.
     *
     * @return 染料代表的颜色({@link Color})
     */
    public Color getColor() {
        return color;
    }

    /**
     * 获取这个染料代表的烟花颜色.
     * <p>
     * 原文:
     * Gets the firework color that this dye represents.
     *
     * @return 染料代表的颜色({@link Color})
     */
    public Color getFireworkColor() {
        return firework;
    }

    /**
     * 获取给定的(羊毛)数据值的染料颜色.
     * <p>
     * 原文:
     * Gets the DyeColor with the given (wool) data value.
     *
     * @param data 要获取的(羊毛)数据值
     * @return The {@link DyeColor} representing the given value, or null if
     *     it doesn't exist
     * @deprecated 这个名称具有误导性.但这将意味着{@link Material#INK_SACK}使用{@link Material#WOOL}.
     * @see #getByDyeData(byte)
     * @see #getByWoolData(byte)
     */
    @Deprecated
    public static DyeColor getByData(final byte data) {
        return getByWoolData(data);
    }

    /**
     * 获取给定的羊毛数据值的染料颜色.
     * <p>
     * 原文:
     * Gets the DyeColor with the given wool data value.
     *
     * @param data 将要获取的羊毛数据值
     * @return 给定值代表的染料颜色({@link DyeColor})，如果不存在则为null
     * @see #getByDyeData(byte)
     * @deprecated 魔法值
     */
    @Deprecated
    public static DyeColor getByWoolData(final byte data) {
        int i = 0xff & data;
        if (i >= BY_WOOL_DATA.length) {
            return null;
        }
        return BY_WOOL_DATA[i];
    }

    /**
     * 用给定的数据值获取DyeColor.
     * <p>
     * 原文:
     * Gets the DyeColor with the given dye data value.
     *
     * @param data 要获取的染料数据值
     * @return 给定值代表的染料颜色({@link DyeColor})，如果不存在则为null
     * @see #getByWoolData(byte)
     * @deprecated 不安全的参数
     */
    @Deprecated
    public static DyeColor getByDyeData(final byte data) {
        int i = 0xff & data;
        if (i >= BY_DYE_DATA.length) {
            return null;
        }
        return BY_DYE_DATA[i];
    }

    /**
     * 获取给定的颜色值的染料颜色.
     * <p>
     * 原文:
     * Gets the DyeColor with the given color value.
     *
     * @param color 要获取的染料的颜色值
     * @return 给定值代表的染料颜色({@link DyeColor})，如果不存在则为null
     */
    public static DyeColor getByColor(final Color color) {
        return BY_COLOR.get(color);
    }

    /**
     * 获取给定的颜色颜色值的染料颜色.
     * <p>
     * 原文:
     * Gets the DyeColor with the given firework color value.
     *
     * @param color 要获取的染料的颜色值
     * @return 给定值代表的染料颜色({@link DyeColor})，如果不存在则为null
     */
    public static DyeColor getByFireworkColor(final Color color) {
        return BY_FIREWORK.get(color);
    }

    static {
        BY_WOOL_DATA = values();
        BY_DYE_DATA = values();
        ImmutableMap.Builder<Color, DyeColor> byColor = ImmutableMap.builder();
        ImmutableMap.Builder<Color, DyeColor> byFirework = ImmutableMap.builder();

        for (DyeColor color : values()) {
            BY_WOOL_DATA[color.woolData & 0xff] = color;
            BY_DYE_DATA[color.dyeData & 0xff] = color;
            byColor.put(color.getColor(), color);
            byFirework.put(color.getFireworkColor(), color);
        }

        BY_COLOR = byColor.build();
        BY_FIREWORK = byFirework.build();
    }
}
