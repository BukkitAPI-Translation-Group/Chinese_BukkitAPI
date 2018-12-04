package org.bukkit.inventory.meta;

import org.bukkit.Color;

/**
 * 代表可被伸缩的地图.
 */
public interface MapMeta extends ItemMeta {

    /**
     * Checks for existence of a map ID number.
     *
     * @return true if this has a map ID number.
     */
    boolean hasMapId();

    /**
     * Gets the map ID that is set. This is used to determine what map is
     * displayed.
     * <p>
     * Plugins should check that hasMapId() returns <code>true</code> before
     * calling this method.
     *
     * @return the map ID that is set
     */
    int getMapId();

    /**
     * Sets the map ID. This is used to determine what map is displayed.
     *
     * @param id the map id to set
     */
    void setMapId(int id);

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

    /**
     * Checks for existence of a location name.
     *
     * @return true if this has a location name
     */
    boolean hasLocationName();

    /**
     * Gets the location name that is set.
     * <p>
     * Plugins should check that hasLocationName() returns <code>true</code>
     * before calling this method.
     *
     * @return the location name that is set
     */
    String getLocationName();

    /**
     * Sets the location name. A custom map color will alter the display of the
     * map in an inventory slot.
     *
     * @param name the name to set
     */
    void setLocationName(String name);

    /**
     * Checks for existence of a map color.
     *
     * @return true if this has a custom map color
     */
    boolean hasColor();

    /**
     * Gets the map color that is set. A custom map color will alter the display
     * of the map in an inventory slot.
     * <p>
     * Plugins should check that hasColor() returns <code>true</code> before
     * calling this method.
     *
     * @return the map color that is set
     */
    Color getColor();

    /**
     * Sets the map color. A custom map color will alter the display of the map
     * in an inventory slot.
     *
     * @param color the color to set
     */
    void setColor(Color color);

    MapMeta clone();
}