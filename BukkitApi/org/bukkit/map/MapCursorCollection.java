package org.bukkit.map;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 表示{@link MapCanvas}上的所有地图光标。与MapCanvas类似，MapCursorCollection与特定的{@link MapRenderer}相关联。
 */
public final class MapCursorCollection {
    private List<MapCursor> cursors = new ArrayList<MapCursor>();

    /**
     * 获取此集合中的光标数量。
     * <p>
     * 原文：
     * Get the amount of cursors in this collection.
     *
     * @return 此集合的大小。
     */
    public int size() {
        return cursors.size();
    }

    /**
     * 从此集合中获取一个光标。
     * <p>
     * 原文：
     * Get a cursor from this collection.
     *
     * @param index 光标的索引。
     * @return 该MapCursor对象。
     */
    @NotNull
    public MapCursor getCursor(int index) {
        return cursors.get(index);
    }

    /**
     * 从集合中移除一个光标。
     * <p>
     * 原文：
     * Remove a cursor from the collection.
     *
     * @param cursor 要移除的MapCursor。
     * @return 光标是否被成功移除。
     */
    public boolean removeCursor(@NotNull MapCursor cursor) {
        return cursors.remove(cursor);
    }

    /**
     * 向集合中添加一个光标。
     * <p>
     * 原文：
     * Add a cursor to the collection.
     *
     * @param cursor 要添加的MapCursor。
     * @return 传入的MapCursor对象。
     */
    @NotNull
    public MapCursor addCursor(@NotNull MapCursor cursor) {
        cursors.add(cursor);
        return cursor;
    }

    /**
     * 向集合中添加一个光标。
     * <p>
     * 原文：
     * Add a cursor to the collection.
     *
     * @param x x坐标，范围从-128到127。
     * @param y y坐标，范围从-128到127。
     * @param direction 光标的朝向，范围从0到15。
     * @return 新添加的MapCursor对象。
     */
    @NotNull
    public MapCursor addCursor(int x, int y, byte direction) {
        return addCursor(x, y, direction, (byte) 0, true);
    }

    /**
     * 向集合中添加一个光标。
     * <p>
     * 原文：
     * Add a cursor to the collection.
     *
     * @param x x坐标，范围从-128到127。
     * @param y y坐标，范围从-128到127。
     * @param direction 光标的朝向，范围从0到15。
     * @param type 地图光标的类型（颜色/样式）。
     * @return 新添加的MapCursor对象。
     * @deprecated 魔法值
     */
    @Deprecated(since = "1.6.2")
    @NotNull
    public MapCursor addCursor(int x, int y, byte direction, byte type) {
        return addCursor(x, y, direction, type, true);
    }

    /**
     * 向集合中添加一个光标。
     * <p>
     * 原文：
     * Add a cursor to the collection.
     *
     * @param x x坐标，范围从-128到127。
     * @param y y坐标，范围从-128到127。
     * @param direction 光标的朝向，范围从0到15。
     * @param type 地图光标的类型（颜色/样式）。
     * @param visible 光标是否可见。
     * @return 新添加的MapCursor对象。
     * @deprecated 魔法值
     */
    @Deprecated(since = "1.6.2")
    @NotNull
    public MapCursor addCursor(int x, int y, byte direction, byte type, boolean visible) {
        return addCursor(new MapCursor((byte) x, (byte) y, direction, type, visible));
    }

    /**
     * 向集合中添加一个光标。
     * <p>
     * 原文：
     * Add a cursor to the collection.
     *
     * @param x x坐标，范围从-128到127。
     * @param y y坐标，范围从-128到127。
     * @param direction 光标的朝向，范围从0到15。
     * @param type 地图光标的类型（颜色/样式）。
     * @param visible 光标是否可见。
     * @param caption 横幅标题
     * @return 新添加的MapCursor对象。
     * @deprecated 魔法值
     */
    @Deprecated(since = "1.13")
    @NotNull
    public MapCursor addCursor(int x, int y, byte direction, byte type, boolean visible, @Nullable String caption) {
        return addCursor(new MapCursor((byte) x, (byte) y, direction, type, visible, caption));
    }
}