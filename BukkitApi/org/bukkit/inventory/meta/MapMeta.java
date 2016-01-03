package org.bukkit.inventory.meta;

/**
 * 代表可被伸缩的地图.
 */
public interface MapMeta extends ItemMeta {

    /**
     * 检测这个地图是否有缩放比例.
     * <p>
     * 原文：Checks to see if this map is scaling.
     *
     * @return true表地图有缩放比例
     */
    boolean isScaling();

    /**
     * 设置这个地图是否有缩放比例.
     * <p>
     * 原文：Sets if this map is scaling or not.
     *
     * @param value true表示可缩放
     */
    void setScaling(boolean value);

    MapMeta clone();
}