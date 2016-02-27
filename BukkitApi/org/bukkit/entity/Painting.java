package org.bukkit.entity;

import org.bukkit.Art;
import org.bukkit.event.painting.PaintingBreakEvent;

/**
 * 代表画.
 * <p>
 * 中文Wiki:<a href="http://minecraft-zh.gamepedia.com/%E7%94%BB" />，前往了解更多
 */
public interface Painting extends Hanging {

    /**
     * 获取这幅画上的画面.
     * <p>
     * 原文：Get the art on this painting
     *
     * @return 画面
     */
    public Art getArt();

    /**
     * 设置这幅画上的画面.
     * <p>
     * 原文：Set the art on this painting
     *
     * @param art 新的画面
     * @return 如果新的画面不适合这幅画的位置、尺寸等将会返回false
     */
    public boolean setArt(Art art);

    /**
     * 设置这幅画的画面.
     * <p>
     * 原文：Set the art on this painting
     *
     * @param art 新的画面
     * @param force 如果这个设为true，无论当前的位置、尺寸是否适合这幅画面.注意，强制执行这可能会使这幅画掉落成物品，除非你用{@link PaintingBreakEvent}重写
     * @return 如果force参数是false或新的画面不适合这幅画的位置、尺寸等将会返回false
     */
    public boolean setArt(Art art, boolean force);
}