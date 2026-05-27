package org.bukkit.map;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 表示地图的渲染器。
 */
public abstract class MapRenderer {

    private boolean contextual;

    /**
     * 初始化地图渲染器基础为非上下文相关。参见{@link #isContextual()}。
     * <p>
     * 原文：
     * Initialize the map renderer base to be non-contextual. See {@link
     * #isContextual()}.
     */
    public MapRenderer() {
        this(false);
    }

    /**
     * 使用给定的上下文状态初始化地图渲染器基础。
     * <p>
     * 原文：
     * Initialize the map renderer base with the given contextual status.
     *
     * @param contextual 渲染器是否是上下文相关的。参见{@link #isContextual()}。
     */
    public MapRenderer(boolean contextual) {
        this.contextual = contextual;
    }

    /**
     * 获取渲染器是否是上下文相关的，即是否为不同玩家提供不同的画布。
     * <p>
     * 原文：
     * Get whether the renderer is contextual, i.e. has different canvases for
     * different players.
     *
     * @return 如果是上下文相关的则返回true，否则返回false。
     */
    public final boolean isContextual() {
        return contextual;
    }

    /**
     * 为给定地图初始化此MapRenderer。
     * <p>
     * 原文：
     * Initialize this MapRenderer for the given map.
     *
     * @param map 正在初始化的MapView。
     */
    public void initialize(@NotNull MapView map) {}

    /**
     * 渲染到给定地图。
     * <p>
     * 原文：
     * Render to the given map.
     *
     * @param map 正在渲染的MapView。
     * @param canvas 用于渲染的画布。
     * @param player 触发渲染的玩家。
     */
    public abstract void render(@NotNull MapView map, @NotNull MapCanvas canvas, @NotNull Player player);

}
