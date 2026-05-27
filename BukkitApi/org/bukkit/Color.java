package org.bukkit;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 这是一个调色板的容器。该类是不可更改的; 使用set方法可以返回一个新的自定义颜色。
 * 这里颜色名字的列表为 HTML4 标准色,
 * 但是随时可能更改
 */
@SerializableAs("Color")
public final class Color implements ConfigurationSerializable {
    private static final int BIT_MASK = 0xff;
    private static final int DEFAULT_ALPHA = 255;

    /**
     * 白色,或(R,G,B) 表示为 0xFF,0xFF,0xFF)
     */
    public static final Color WHITE = fromRGB(0xFFFFFF);

    /**
     * 银色,或(R,G,B) 表示为 0xC0,0xC0,0xC0)
     */
    public static final Color SILVER = fromRGB(0xC0C0C0);

    /**
     * 灰色,或(R,G,B) 表示为 0x80,0x80,0x80)
     */
    public static final Color GRAY = fromRGB(0x808080);

    /**
     * 黑色,或(R,G,B) 表示为 0x00,0x00,0x00)
     */
    public static final Color BLACK = fromRGB(0x000000);

    /**
     * 红色,或(R,G,B) 表示为 0xFF,0x00,0x00)
     */
    public static final Color RED = fromRGB(0xFF0000);

    /**
     * 栗色,或(R,G,B) 表示为 0x80,0x00,0x00)
     */
    public static final Color MAROON = fromRGB(0x800000);

    /**
     * 黄色,或(R,G,B) 表示为 0xFF,0xFF,0x00)
     */
    public static final Color YELLOW = fromRGB(0xFFFF00);

    /**
     * 橄榄色,或(R,G,B) 表示为 0x80,0x80,0x00)
     */
    public static final Color OLIVE = fromRGB(0x808000);

    /**
     * 黄绿色,或(R,G,B) 表示为 0x00,0xFF,0x00)
     */
    public static final Color LIME = fromRGB(0x00FF00);

    /**
     * 绿色,或(R,G,B) 表示为 0x00,0x80,0x00)
     */
    public static final Color GREEN = fromRGB(0x008000);

    /**
     * 浅绿,或(R,G,B) 表示为 0x00,0xFF,0xFF)
     */
    public static final Color AQUA = fromRGB(0x00FFFF);

    /**
     * 蓝绿色,或(R,G,B) 表示为 0x00,0x80,0x80)
     */
    public static final Color TEAL = fromRGB(0x008080);

    /**
     * 蓝色,或(R,G,B) 表示为 0x00,0x00,0xFF)
     */
    public static final Color BLUE = fromRGB(0x0000FF);

    /**
     * 海军色,或(R,G,B) 表示为 0x00,0x00,0x80)
     */
    public static final Color NAVY = fromRGB(0x000080);

    /**
     * 樱红色,或(R,G,B) 表示为 0xFF,0x00,0xFF)
     */
    public static final Color FUCHSIA = fromRGB(0xFF00FF);

    /**
     * 紫色,或(R,G,B) 表示为 0x80,0x00,0x80)
     */
    public static final Color PURPLE = fromRGB(0x800080);

    /**
     * 橙色,或(R,G,B) 表示为 0xFF,0xA5,0x00)
     */
    public static final Color ORANGE = fromRGB(0xFFA500);

    private final byte alpha;
    private final byte red;
    private final byte green;
    private final byte blue;

    /**
     * 用透明度、红、绿、蓝创建一个新的颜色对象.
     * <p>
     * 原文：Creates a new Color object from an alpha, red, green, and blue
     *
     * @param alpha 0-255的整数
     * @param red 0-255的整数
     * @param green 0-255的整数
     * @param blue 0-255的整数
     * @return 一个包含指定透明度、红、绿、蓝值的新颜色对象
     * @throws IllegalArgumentException 如果任何值严格 {@literal >255 或 <0}
     */
    @NotNull
    public static Color fromARGB(int alpha, int red, int green, int blue) throws IllegalArgumentException {
        return new Color(alpha, red, green, blue);
    }

    /**
     * 用红、绿、蓝创建一个新的颜色对象.
     * <p>
     * 原文：Creates a new Color object from an alpha, red, green, and blue
     *
     * @param red 0-255的整数
     * @param green 0-255的整数
     * @param blue 0-255的整数
     * @return 一个RGB颜色对象
     * @throws IllegalArgumentException 如果任何值严格 {@literal >255 或 <0}
     */
    @NotNull
    public static Color fromRGB(int red, int green, int blue) throws IllegalArgumentException {
        return new Color(DEFAULT_ALPHA, red, green, blue);
    }

    /**
     * 用蓝、绿、红创建一个新的颜色对象.
     * <p>
     * 原文：Creates a new Color object from an alpha, red, green, and blue
     *
     * @param blue 0-255的整数
     * @param green 0-255的整数
     * @param red 0-255的整数
     * @return 一个包含指定红、绿、蓝值的新颜色对象
     * @throws IllegalArgumentException 任何一个参数超出 {@literal >255 或 <0} 范围
     */
    @NotNull
    public static Color fromBGR(int blue, int green, int red) throws IllegalArgumentException {
        return new Color(DEFAULT_ALPHA, red, green, blue);
    }

    /**
     * 从一个RGB整数中创建一个新的颜色对象，该对象包含最低24位.
     * <p>
     * 原文：Creates a new Color object from an integer that contains the alpha, red,
     * green, and blue bytes.
     *
     * @param rgb 存储红、绿、蓝值的整数
     * @return 一个包含指定值的新颜色对象
     * @throws IllegalArgumentException 如果最高8位有任何数据
     */
    @NotNull
    public static Color fromRGB(int rgb) throws IllegalArgumentException {
        Preconditions.checkArgument((rgb >> 24) == 0, "Extraneous data in: %s", rgb);
        return fromRGB(rgb >> 16 & BIT_MASK, rgb >> 8 & BIT_MASK, rgb & BIT_MASK);
    }

    /**
     * 从一个包含透明度、红、绿、蓝字节的整数中创建一个新的颜色对象.
     * <p>
     * 原文：Creates a new color object from an integer that contains the alpha, red,
     * green, and blue bytes.
     *
     * @param argb 存储透明度、红、绿、蓝值的整数
     * @return 一个包含指定值的新颜色对象
     */
    @NotNull
    public static Color fromARGB(int argb) {
        return fromARGB(argb >> 24 & BIT_MASK, argb >> 16 & BIT_MASK, argb >> 8 & BIT_MASK, argb & BIT_MASK);
    }

    /**
     * 从一个包含蓝、绿、红字节的整数中创建一个新的颜色对象，该整数在最低24位中存储.
     * <p>
     * 原文：Creates a new color object from an integer that contains the blue,
     * green, and red bytes in the lowest order 24 bits.
     *
     * @param bgr 存储蓝、绿、红值的整数
     * @return 一个包含指定值的新颜色对象
     * @throws IllegalArgumentException 如果最高8位有任何数据
     */
    @NotNull
    public static Color fromBGR(int bgr) throws IllegalArgumentException {
        Preconditions.checkArgument((bgr >> 24) == 0, "Extrenuous data in: %s", bgr);
        return fromBGR(bgr >> 16 & BIT_MASK, bgr >> 8 & BIT_MASK, bgr & BIT_MASK);
    }

    private Color(int red, int green, int blue) {
        this(DEFAULT_ALPHA, red, green, blue);
    }

    private Color(int alpha, int red, int green, int blue) {
        Preconditions.checkArgument(alpha >= 0 && alpha <= BIT_MASK, "Alpha[%s] is not between 0-255", alpha);
        Preconditions.checkArgument(red >= 0 && red <= BIT_MASK, "Red[%s] is not between 0-255", red);
        Preconditions.checkArgument(green >= 0 && green <= BIT_MASK, "Green[%s] is not between 0-255", green);
        Preconditions.checkArgument(blue >= 0 && blue <= BIT_MASK, "Blue[%s] is not between 0-255", blue);

        this.alpha = (byte) alpha;
        this.red = (byte) red;
        this.green = (byte) green;
        this.blue = (byte) blue;
    }

    /**
     * 获取透明度分量.
     * <p>
     * 原文：Gets the alpha component
     *
     * @return 透明度分量，范围0-255
     */
    public int getAlpha() {
        return BIT_MASK & alpha;
    }

    /**
     * 用指定的透明度分量创建一个新的颜色对象.
     * <p>
     * 原文：Creates a new Color object with specified component
     *
     * @param alpha 透明度分量，范围0-255
     * @return 一个包含指定透明度分量的新颜色对象
     */
    @NotNull
    public Color setAlpha(int alpha) {
        return fromARGB(alpha, getRed(), getGreen(), getBlue());
    }

    /**
     * 获取红色分量.
     * <p>
     * 原文：Gets the red component
     *
     * @return 红色分量，范围0-255
     */
    public int getRed() {
        return BIT_MASK & red;
    }

    /**
     * 用指定的红色分量创建一个新的颜色对象.
     * <p>
     * 原文：Creates a new Color object with specified component
     *
     * @param red 红色分量，范围0-255
     * @return 一个包含指定红色分量的新颜色对象
     */
    @NotNull
    public Color setRed(int red) {
        return fromARGB(getAlpha(), red, getGreen(), getBlue());
    }

    /**
     * 获取绿色分量.
     * <p>
     * 原文：Gets the green component
     *
     * @return 绿色分量，范围0-255
     */
    public int getGreen() {
        return BIT_MASK & green;
    }

    /**
     * 用指定的绿色分量创建一个新的颜色对象.
     * <p>
     * 原文：Creates a new Color object with specified component
     *
     * @param green 绿色分量，范围0-255
     * @return 一个包含指定绿色分量的新颜色对象
     */
    @NotNull
    public Color setGreen(int green) {
        return fromARGB(getAlpha(), getRed(), green, getBlue());
    }

    /**
     * 获取蓝色分量.
     * <p>
     * 原文：Gets the blue component
     *
     * @return 蓝色分量，范围0-255
     */
    public int getBlue() {
        return BIT_MASK & blue;
    }

    /**
     * 用指定的蓝色分量创建一个新的颜色对象.
     * <p>
     * 原文：Creates a new Color object with specified component
     *
     * @param blue 蓝色分量，范围0-255
     * @return 一个包含指定蓝色分量的新颜色对象
     */
    @NotNull
    public Color setBlue(int blue) {
        return fromARGB(getAlpha(), getRed(), getGreen(), blue);
    }

    /**
     * 获取此颜色的RGB整数表示.
     * <p>
     * 原文：Gets the color as an RGB integer.
     *
     * @return 此颜色的整数表示，格式为0xRRGGBB
     */
    public int asRGB() {
        return getRed() << 16 | getGreen() << 8 | getBlue();
    }

    /**
     * 获取此颜色的ARGB整数表示.
     * <p>
     * 原文：Gets the color as an ARGB integer.
     *
     * @return 此颜色的整数表示，格式为0xAARRGGBB
     */
    public int asARGB() {
        return getAlpha() << 24 | getRed() << 16 | getGreen() << 8 | getBlue();
    }

    /**
     * 获取此颜色的BGR整数表示.
     * <p>
     * 原文：Gets the color as an BGR integer.
     *
     * @return 此颜色的整数表示，格式为0xBBGGRR
     */
    public int asBGR() {
        return getBlue() << 16 | getGreen() << 8 | getRed();
    }

    /**
     * 使用传入的染料颜色对当前颜色的RGB分量进行染色，创建一个新的颜色，模拟原版工作台染色.
     * <p>
     * 原文：Creates a new color with its RGB components changed as if it was dyed
     * with the colors passed in, replicating vanilla workbench dyeing
     *
     * @param colors 用于染色的染料颜色
     * @return 一个RGB分量改变后的新颜色
     */
    // TODO: Javadoc what this method does, not what it mimics. API != Implementation
    @NotNull
    public Color mixDyes(@NotNull DyeColor... colors) {
        Preconditions.checkArgument(colors != null && Arrays.stream(colors).allMatch(Objects::nonNull), "DyeColor cannot be null or contain null values");

        Color[] toPass = new Color[colors.length];
        for (int i = 0; i < colors.length; i++) {
            toPass[i] = colors[i].getColor();
        }

        return mixColors(toPass);
    }

    /**
     * 使用传入的颜色对当前颜色的RGB分量进行染色，创建一个新的颜色，模拟原版工作台染色.
     * <p>
     * 原文：Creates a new color with its RGB components changed as if it was dyed
     * with the colors passed in, replicating vanilla workbench dyeing.
     *
     * <b>注意：此方法当前不考虑透明度分量.</b>
     * <p>
     * 原文：<b>Note that this method does not currently take into account alpha
     * components.</b>
     *
     * @param colors 用于染色的颜色
     * @return 一个RGB分量改变后的新颜色
     */
    // TODO: Javadoc what this method does, not what it mimics. API != Implementation
    @NotNull
    public Color mixColors(@NotNull Color... colors) {
        Preconditions.checkArgument(colors != null && Arrays.stream(colors).allMatch(Objects::nonNull), "Colors cannot be null");

        int totalRed = this.getRed();
        int totalGreen = this.getGreen();
        int totalBlue = this.getBlue();
        int totalMax = Math.max(Math.max(totalRed, totalGreen), totalBlue);
        for (Color color : colors) {
            totalRed += color.getRed();
            totalGreen += color.getGreen();
            totalBlue += color.getBlue();
            totalMax += Math.max(Math.max(color.getRed(), color.getGreen()), color.getBlue());
        }

        float averageRed = totalRed / (colors.length + 1);
        float averageGreen = totalGreen / (colors.length + 1);
        float averageBlue = totalBlue / (colors.length + 1);
        float averageMax = totalMax / (colors.length + 1);

        float maximumOfAverages = Math.max(Math.max(averageRed, averageGreen), averageBlue);
        float gainFactor = averageMax / maximumOfAverages;

        return Color.fromRGB((int) (averageRed * gainFactor), (int) (averageGreen * gainFactor), (int) (averageBlue * gainFactor));
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Color)) {
            return false;
        }
        final Color that = (Color) o;
        return this.alpha == that.alpha && this.blue == that.blue && this.green == that.green && this.red == that.red;
    }

    @Override
    public int hashCode() {
        return asARGB() ^ Color.class.hashCode();
    }

    @Override
    @NotNull
    public Map<String, Object> serialize() {
        return ImmutableMap.of(
                "ALPHA", getAlpha(),
                "RED", getRed(),
                "BLUE", getBlue(),
                "GREEN", getGreen()
        );
    }

    @SuppressWarnings("javadoc")
    @NotNull
    public static Color deserialize(@NotNull Map<String, Object> map) {
        return fromARGB(
                asInt("ALPHA", map, DEFAULT_ALPHA),
                asInt("RED", map),
                asInt("GREEN", map),
                asInt("BLUE", map)
        );
    }

    private static int asInt(@NotNull String string, @NotNull Map<String, Object> map) {
        return asInt(string, map, null);
    }

    private static int asInt(@NotNull String string, @NotNull Map<String, Object> map, @Nullable Object defaultValue) {
        Object value = map.getOrDefault(string, defaultValue);
        if (value == null) {
            throw new IllegalArgumentException(string + " not in map " + map);
        }
        if (!(value instanceof Number)) {
            throw new IllegalArgumentException(string + '(' + value + ") is not a number");
        }
        return ((Number) value).intValue();
    }

    @Override
    public String toString() {
        return "Color:[argb0x" + Integer.toHexString(asARGB()).toUpperCase(Locale.ROOT) + "]";
    }
}
