package org.bukkit.entity;

import org.bukkit.Art;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.jetbrains.annotations.NotNull;

/**
 * 代表画.
 * <p>
 * 前往<a href="http://zh.minecraft.wiki/w/%E7%94%BB">wiki</a>了解更多
 */
public interface Painting extends Hanging {

    /**
     * 获取这幅画上的画面/图案.
     * <p>
     * 原文：Get the art on this painting
     *
     * @return 画面/图案
     */
    @NotNull
    public Art getArt();

    /**
     * 设置这幅画上的画面/图案.
     * <p>
     * 原文：Set the art on this painting
     *
     * @param art 新的画面/图案
     * @return 如果新的画面/图案不适合这幅画的位置、尺寸等将会返回false
     */
    public boolean setArt(@NotNull Art art);

    /**
     * 设置这幅画的画面/图案.
     * <p>
     * 原文：Set the art on this painting
     *
     * @param art 新的画面/图案
     * @param force 如果这个设为true，无论当前的位置、尺寸是否适合这幅画面/图案.注意，强制执行这可能会使这幅画掉落成物品，除非你用{@link HangingBreakEvent}重写
     * @return 如果force参数是false或新的画面/图案不适合这幅画的位置、尺寸等将会返回false
     */
    public boolean setArt(@NotNull Art art, boolean force);
}
