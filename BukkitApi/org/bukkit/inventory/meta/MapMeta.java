package org.bukkit.inventory.meta;

import org.bukkit.Color;
import org.bukkit.UndefinedNullability;
import org.bukkit.map.MapView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表可被伸缩的地图.
 */
public interface MapMeta extends ItemMeta {

    /**
     * 检测此地图是否有编号.
     * <p>
     * 原文:
     * Checks for existence of a map ID number.
     *
     * @return 地图是否有编号
     * @see #hasMapView()
     * @deprecated 这些方法是设计糟糕的API:它们依赖调用者, 仅传递一个整数属性值,
     * 并且曾经有着糟糕的实现 - 未判断地图 id 是否合法(是否存在).
     * 现代的实现 - 例如, 服务器会生成一个不同 id 的新地图.
     * 开发者应使用 xxxMapView 家族的方法.
     */
    @Deprecated
    boolean hasMapId();

    /**
     * 获取关联地图的编号. 这用来决定地图是否显示出来.
     * <p>
     * 插件应该在调用这个方法之前检测 hasMapId() 是否返回 <code>true</code>.
     * <p>
     * 原文:
     * Gets the map ID that is set. This is used to determine what map is
     * displayed.
     * <p>
     * Plugins should check that hasMapId() returns <code>true</code> before
     * calling this method.
     *
     * @return 地图编号
     * @see #getMapView()
     * @deprecated 这些方法是设计糟糕的API:它们依赖调用者, 仅传递一个整数属性值,
     * 并且曾经有着糟糕的实现 - 未判断地图 id 是否合法(是否存在).
     * 现代的实现 - 例如, 服务器会生成一个不同 id 的新地图.
     * 开发者应使用 xxxMapView 家族的方法.
     */
    @Deprecated
    int getMapId();

    /**
     * 设置相关地图的 ID. 这用来决定地图是否显示出来.
     * <p>
     * 原文:
     * Sets the map ID. This is used to determine what map is displayed.
     *
     * @param id 地图编号
     * @see #setMapView(org.bukkit.map.MapView)
     * @deprecated 这些方法是设计糟糕的API:它们依赖调用者, 仅传递一个整数属性值,
     * 并且曾经有着糟糕的实现 - 未判断地图 id 是否合法(是否存在).
     * 现代的实现 - 例如, 服务器会生成一个不同 id 的新地图.
     * 开发者应使用 xxxMapView 家族的方法.
     */
    @Deprecated
    void setMapId(int id);

    /**
     * 检查此物品是否设置了相关的地图.
     * <p>
     * 原文:
     * Checks for existence of an associated map.
     *
     * @return 如果设置了相关的地图则返回 true
     */
    boolean hasMapView();

    /**
     * 获取与此地图物品相关的地图.
     *
     * <p>
     * 插件应该在调用这个方法之前检测 hasMapView() 是否返回 <code>true</code>.
     * <p>
     * 原文:
     * Gets the map view that is associated with this map item.
     *
     * <p>
     * Plugins should check that hasMapView() returns <code>true</code> before
     * calling this method.
     *
     * @return 地图视图, 如果 hasMapView() 为 true, 但这个地图不存在于服务器上则返回 null
     */
    @Nullable
    MapView getMapView();

    /**
     * 设置相关的地图. 这用来决定地图是否显示出来.
     *
     * <p>
     * 底层实现<b>可能</b>允许 null 值以清空地图, 但这并不是必须的,
     * 当玩家首次使用地图物品时, 有可能会生成一个新的(未定义的)地图.
     * <p>
     * 原文:
     * Sets the associated map. This is used to determine what map is displayed.
     *
     * <p>
     * The implementation <b>may</b> allow null to clear the associated map, but
     * this is not required and is liable to generate a new (undefined) map when
     * the item is first used.
     *
     * @param map 要设置的地图
     */
    void setMapView(@UndefinedNullability("implementation defined") MapView map);

    /**
     * 检测这个地图是否有缩放比例.
     * <p>
     * 原文：Checks to see if this map is scaling.
     *
     * @return true表示地图有缩放比例
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
     * 检查是否有位置名.
     * <p>
     * 原文:
     * Checks for existence of a location name.
     *
     * @return 是否有位置名
     */
    boolean hasLocationName();

    /**
     * 获取位置名.
     * <p>
     * 插件应该在调用这个方法之前检测 hasLocationName() 是否返回 <code>true</code>.
     * <p>
     * 原文:
     * Gets the location name that is set.
     * <p>
     * Plugins should check that hasLocationName() returns <code>true</code>
     * before calling this method.
     *
     * @return 位置名
     */
    @Nullable
    String getLocationName();

    /**
     * 设置位置名.
     * <p>
     * 原文:
     * Sets the location name. A custom map color will alter the display of the
     * map in an inventory slot.
     *
     * @param name 位置名
     */
    void setLocationName(@Nullable String name);

    /**
     * 检查是否为地图物品设置了自定义的颜色.
     * <p>
     * 原文:
     * Checks for existence of a map color.
     *
     * @return 是否有自定义的颜色
     */
    boolean hasColor();

    /**
     * 获取地图材质的颜色. 此颜色可在物品栏中地图物品的格子内观察到.
     * <p>
     * 插件应该在调用这个方法之前检测 hasColor() 是否返回 <code>true</code>.
     * <p>
     * 原文:
     * Gets the map color that is set. A custom map color will alter the display
     * of the map in an inventory slot.
     * <p>
     * Plugins should check that hasColor() returns <code>true</code> before
     * calling this method.
     *
     * @return 颜色
     */
    @Nullable
    Color getColor();

    /**
     * 设置地图材质的颜色. 此颜色可在物品栏中地图物品的格子内观察到.
     * <p>
     * 原文:
     * Sets the map color. A custom map color will alter the display of the map
     * in an inventory slot.
     *
     * @param color 颜色
     */
    void setColor(@Nullable Color color);

    @Override
    @NotNull
    MapMeta clone();
}