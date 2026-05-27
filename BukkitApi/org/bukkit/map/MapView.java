package org.bukkit.map;

import java.util.List;
import org.bukkit.World;
import org.bukkit.inventory.meta.MapMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 表示地图物品。
 */
public interface MapView {

    /**
     * 表示地图可设置的所有可能比例的枚举。
     */
    public static enum Scale {
        CLOSEST(0),
        CLOSE(1),
        NORMAL(2),
        FAR(3),
        FARTHEST(4);

        private byte value;

        private Scale(int value) {
            this.value = (byte) value;
        }

        /**
         * 根据原始值获取比例。
         * <p>
         * 原文：
         * Get the scale given the raw value.
         *
         * @param value 原始比例值。
         * @return 枚举比例，如果输入无效则返回null。
         * @deprecated 魔法值
         */
        @Deprecated(since = "1.6.2")
        @Nullable
        public static Scale valueOf(byte value) {
            switch (value) {
            case 0: return CLOSEST;
            case 1: return CLOSE;
            case 2: return NORMAL;
            case 3: return FAR;
            case 4: return FARTHEST;
            default: return null;
            }
        }

        /**
         * 获取此比例级别的原始值。
         * <p>
         * 原文：
         * Get the raw value of this scale level.
         *
         * @return 比例值。
         * @deprecated 魔法值
         */
        @Deprecated(since = "1.6.2")
        public byte getValue() {
            return value;
        }
    }

    /**
     * 获取此地图物品的ID，用于{@link MapMeta}。
     * <p>
     * 原文：
     * Get the ID of this map item for use with {@link MapMeta}.
     *
     * @return 地图的ID。
     */
    public int getId();

    /**
     * 检查此地图是否是虚拟的。如果地图最底层的MapRenderer是由插件提供的，则该地图是虚拟的。
     * <p>
     * 原文：
     * Check whether this map is virtual. A map is virtual if its lowermost
     * MapRenderer is plugin-provided.
     *
     * @return 地图是否是虚拟的。
     */
    public boolean isVirtual();

    /**
     * 获取此地图的比例。
     * <p>
     * 原文：
     * Get the scale of this map.
     *
     * @return 地图的比例。
     */
    @NotNull
    public Scale getScale();

    /**
     * 设置此地图的比例。
     * <p>
     * 原文：
     * Set the scale of this map.
     *
     * @param scale 要设置的比例。
     */
    public void setScale(@NotNull Scale scale);

    /**
     * 获取此地图的中心X位置。
     * <p>
     * 原文：
     * Get the center X position of this map.
     *
     * @return 中心X位置。
     */
    public int getCenterX();

    /**
     * 获取此地图的中心Z位置。
     * <p>
     * 原文：
     * Get the center Z position of this map.
     *
     * @return 中心Z位置。
     */
    public int getCenterZ();

    /**
     * 设置此地图的中心X位置。
     * <p>
     * 原文：
     * Set the center X position of this map.
     *
     * @param x 中心X位置。
     */
    public void setCenterX(int x);

    /**
     * 设置此地图的中心Z位置。
     * <p>
     * 原文：
     * Set the center Z position of this map.
     *
     * @param z 中心Z位置。
     */
    public void setCenterZ(int z);

    /**
     * 获取此地图关联的世界。主要由内部渲染器使用，但也可供外部渲染器使用。如果地图关联的世界未加载，则可能返回null。
     * <p>
     * 原文：
     * Get the world that this map is associated with. Primarily used by the
     * internal renderer, but may be used by external renderers. May return
     * null if the world the map is associated with is not loaded.
     *
     * @return 此地图关联的World对象。
     */
    @Nullable
    public World getWorld();

    /**
     * 设置此地图关联的世界。该世界由内部渲染器使用，也可供外部渲染器使用。
     * <p>
     * 原文：
     * Set the world that this map is associated with. The world is used by
     * the internal renderer, and may also be used by external renderers.
     *
     * @param world 要与此地图关联的World对象。
     */
    public void setWorld(@NotNull World world);

    /**
     * 获取当前生效的MapRenderers列表。
     * <p>
     * 原文：
     * Get a list of MapRenderers currently in effect.
     *
     * @return 包含每个地图渲染器的{@code List<MapRenderer>}。
     */
    @NotNull
    public List<MapRenderer> getRenderers();

    /**
     * 向此地图添加渲染器。
     * <p>
     * 原文：
     * Add a renderer to this map.
     *
     * @param renderer 要添加的MapRenderer。
     */
    public void addRenderer(@NotNull MapRenderer renderer);

    /**
     * 从此地图移除渲染器。
     * <p>
     * 原文：
     * Remove a renderer from this map.
     *
     * @param renderer 要移除的MapRenderer。
     * @return 如果渲染器被成功移除则返回true。
     */
    public boolean removeRenderer(@Nullable MapRenderer renderer);

    /**
     * 获取当地图接近其中心时是否应显示位置光标。
     * <p>
     * 原文：
     * Gets whether a position cursor should be shown when the map is near its
     * center.
     *
     * @return 跟踪状态。
     */
    boolean isTrackingPosition();

    /**
     * 设置当地图接近其中心时是否应显示位置光标。
     * <p>
     * 原文：
     * Sets whether a position cursor should be shown when the map is near its
     * center.
     *
     * @param trackingPosition 跟踪状态。
     */
    void setTrackingPosition(boolean trackingPosition);

    /**
     * 当光标超出地图范围时，地图是否显示较小的位置光标（true），或不显示位置光标（false）。
     * <p>
     * 原文：
     * Whether the map will show a smaller position cursor (true), or no
     * position cursor (false) when cursor is outside of map's range.
     *
     * @return 无限制跟踪状态。
     */
    boolean isUnlimitedTracking();

    /**
     * 当光标超出地图范围时，地图是否显示较小的位置光标（true），或不显示位置光标（false）。
     * <p>
     * 原文：
     * Whether the map will show a smaller position cursor (true), or no
     * position cursor (false) when cursor is outside of map's range.
     *
     * @param unlimited 无限制跟踪状态。
     */
    void setUnlimitedTracking(boolean unlimited);

    /**
     * 获取地图是否被锁定。
     *
     * 被锁定的地图无法进一步探索。
     * <p>
     * 原文：
     * Gets whether the map is locked or not.
     *
     * A locked map may not be explored further.
     *
     * @return 锁定状态。
     */
    boolean isLocked();

    /**
     * 设置地图是否被锁定。
     *
     * 被锁定的地图无法进一步探索。
     * <p>
     * 原文：
     * Gets whether the map is locked or not.
     *
     * A locked map may not be explored further.
     *
     * @param locked 锁定状态。
     */
    void setLocked(boolean locked);
}