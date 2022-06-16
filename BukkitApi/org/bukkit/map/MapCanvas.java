package org.bukkit.map;

import java.awt.Image;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一个画地图的画布，每个画布都关联着一个特定的
 * {@link MapRenderer 地图渲染器}并表现为地图上渲染器的一层.
 */
public interface MapCanvas {

    /**
     * 获取画布依附的地图.
     * <p>
     * 原文:Get the map this canvas is attached to.
     *
     * @return 画布依附的地图控件
     */
    @NotNull
    public MapView getMapView();

    /**
     * 获取与该画布相关联的游标集合.
     * <p>
     * 原文:Get the cursor collection associated with this canvas.
     *
     * @return 与该画布相关联的游标集合
     */
    @NotNull
    public MapCursorCollection getCursors();

    /**
     * 设置与该画布相关联的游标集合,自从地图游标集合(MapCursorCollection)提供后这个方法通常不需要被调用.
     * <p>
     * 原文:Set the cursor collection associated with this canvas. This does not
     * usually need to be called since a MapCursorCollection is already
     * provided.
     *
     * @param cursors 与画布相关联的游标集合
     */
    public void setCursors(@NotNull MapCursorCollection cursors);

    /**
     * 画一个像素到画布上.
     * <p>
     * 原文:Draw a pixel to the canvas.
     *
     * @param x x坐标值,从0到127
     * @param y y坐标值,从0到127
     * @param color 颜色,参考{@link MapPalette}
     */
    public void setPixel(int x, int y, byte color);

    /**
     * 获取画布上的一个像素.
     * <p>
     * 原文:Get a pixel from the canvas.
     *
     * @param x x坐标值,从0到127
     * @param y y坐标值,从0到127
     * @return 颜色. 参阅 {@link MapPalette}.
     */
    public byte getPixel(int x, int y);

    /**
     * 获取画布下层的一个像素.
     * <p>
     * 原文:Get a pixel from the layers below this canvas.
     *
     * @param x x坐标值,从0到127
     * @param y y坐标值,从0到127
     * @return 颜色. 参阅 {@link MapPalette}.
     */
    public byte getBasePixel(int x, int y);

    /**
     * 画一张图片到地图上,如果必要的话,图像将被裁剪.
     * <p>
     * 原文:Draw an image to the map. The image will be clipped if necessary.
     *
     * @param x 图片的x坐标
     * @param y 图片的y坐标
     * @param image 要画的图片
     */
    public void drawImage(int x, int y, @NotNull Image image);

    /**
     * 使用你想要的格式渲染文字到地图上.换行符(\n)会移动到下一行并返回原来的列,
     * 字体颜色可以使用带字符的数字来改变如"§12;",这会把字体颜色换为颜色表中
     * 第12个颜色(参考 {@link MapPalette}).
     * <p>
     * 原文:Render text to the map using fancy formatting. Newline (\n) characters
     * will move down one line and return to the original column, and the text
     * color can be changed using sequences such as "§12;", replacing 12 with
     * the palette index of the color (see {@link MapPalette}).
     *
     * @param x 开始渲染的列
     * @param y 开始渲染的行
     * @param font 使用的字体
     * @param text 要渲染的格式化文字
     */
    public void drawText(int x, int y, @NotNull MapFont font, @NotNull String text);

}
