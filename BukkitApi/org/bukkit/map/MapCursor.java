package org.bukkit.map;

/**
 * 表示一个地图上的光标.
 * <p>
 * 原文：
 * Represents a cursor on a map.
 */
public final class MapCursor {
    private byte x, y;
    private byte direction, type;
    private boolean visible;
    private String caption;

    /**
     * 初始化地图光标.
     * <p>
     * 原文:Initialize the map cursor.
     *
     * @param x The x coordinate, from -128 to 127.
     * @param y The y coordinate, from -128 to 127.
     * @param direction The facing of the cursor, from 0 to 15.
     * @param type The type (color/style) of the map cursor.
     * @param visible Whether the cursor is visible by default.
     * @deprecated 不安全的参数
     */
    @Deprecated
    public MapCursor(byte x, byte y, byte direction, byte type, boolean visible) {
        this(x, y, direction, type, visible, null);
    }

    /**
     * 初始化地图光标.
     * <p>
     * 原文：
     * Initialize the map cursor.
     *
     * @param x x坐标，范围为-128到127
     * @param y y坐标，范围为-128到127
     * @param direction 光标的朝向，范围为0到15
     * @param type 地图光标的类型（颜色、风格）
     * @param visible 光标在默认情况下是否可见
     * @param caption 光标标题
     * @deprecated 不安全的参数
     */
    @Deprecated
    public MapCursor(byte x, byte y, byte direction, byte type, boolean visible, String caption) {
        this.x = x;
        this.y = y;
        setDirection(direction);
        setRawType(type);
        this.visible = visible;
        this.caption = caption;
    }

    /**
     * 初始化地图光标.
     * <p>
     * 原文：
     * Initialize the map cursor.
     *
     * @param x The x coordinate, from -128 to 127.
     * @param y The y coordinate, from -128 to 127.
     * @param direction The facing of the cursor, from 0 to 15.
     * @param type The type (color/style) of the map cursor.
     * @param visible Whether the cursor is visible by default.
     * @param caption cursor caption
     */
    public MapCursor(byte x, byte y, byte direction, Type type, boolean visible, String caption) {
        this.x = x;
        this.y = y;
        setDirection(direction);
        setType(type);
        this.visible = visible;
        this.caption = caption;
    }

    /**
     * 获取这个光标的X坐标.
     * <p>
     * 原文：
     * Get the X position of this cursor.
     *
     * @return X坐标
     */
    public byte getX() {
        return x;
    }

    /**
     * 获取这个光标的Y坐标.
     * <p>
     * 原文：
     * Get the Y position of this cursor.
     *
     * @return Y坐标
     */
    public byte getY() {
        return y;
    }

    /**
     * 获取这个光标的朝向.
     * <p>
     * 原文：
     * Get the direction of this cursor.
     *
     * @return 光标的朝向，范围为0到15
     */
    public byte getDirection() {
        return direction;
    }

    /**
     * 获取这个光标的类型.
     * <p>
     * 原文：
     * Get the type of this cursor.
     *
     * @return 地图光标的类型（颜色、风格）
     */
    public Type getType() {
        return Type.byValue(type);
    }

    /**
     * 获取这个光标的类型.
     * <p>
     * 原文：
     * Get the type of this cursor.
     *
     * @return 地图光标的类型（颜色、风格）
     * @deprecated 不安全的参数
     */
    @Deprecated
    public byte getRawType() {
        return type;
    }

    /**
     * 获取这个光标的可见情况.
     * <p>
     * 原文：
     * Get the visibility status of this cursor.
     *
     * @return 可见则返回true，否则返回false
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * 设置这个光标的X坐标.
     * <p>
     * 原文：
     * Set the X position of this cursor.
     *
     * @param x X坐标
     */
    public void setX(byte x) {
        this.x = x;
    }

    /**
     * 设置这个光标的Y坐标.
     * <p>
     * 原文：
     * Set the Y position of this cursor.
     *
     * @param y Y坐标
     */
    public void setY(byte y) {
        this.y = y;
    }

    /**
     * 设置这个光标的方向.
     * <p>
     * 原文：
     * Set the direction of this cursor.
     *
     * @param direction 这个光标的朝向，范围为0到15
     */
    public void setDirection(byte direction) {
        if (direction < 0 || direction > 15) {
            throw new IllegalArgumentException("Direction must be in the range 0-15");
        }
        this.direction = direction;
    }

    /**
     * 设置这个光标的类型.
     * <p>
     * 原文：
     * Set the type of this cursor.
     *
     * @param type 地图光标的类型（颜色、风格）
     */
    public void setType(Type type) {
        setRawType(type.value);
    }

    /**
     * 设置这个光标的类型.
     * <p>
     * 原文：
     * Set the type of this cursor.
     *
     * @param type 地图光标的类型（颜色、风格）
     * @deprecated 不安全的参数
     */
    @Deprecated
    public void setRawType(byte type) {
        if (type < 0 || type > 26) {
            throw new IllegalArgumentException("Type must be in the range 0-26");
        }
        this.type = type;
    }

    /**
     * 设置这个光标的可见情况.
     * <p>
     * 原文：
     * Set the visibility status of this cursor.
     *
     * @param visible 可见则为true
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * Gets the caption on this cursor.
     *
     * @return caption
     */
    public String getCaption() {
        return caption;
    }

    /**
     * Sets the caption on this cursor.
     *
     * @param caption new caption
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     * 表示地图光标的标准类型。可能有更多被资源包(原材质包)提供的类型，这个数值被客户端当做minecraft.jar里的'./misc/mapicons.png'文件的索引或一个材质包中的索引使用.
     * <p>
     * 原文：
     * Represents the standard types of map cursors. More may be made
     * available by resource packs - the value is used by the client as an
     * index in the file './misc/mapicons.png' from minecraft.jar or from a
     * resource pack.
     */
    public enum Type {
        WHITE_POINTER(0),
        GREEN_POINTER(1),
        RED_POINTER(2),
        BLUE_POINTER(3),
        WHITE_CROSS(4),
        RED_MARKER(5),
        WHITE_CIRCLE(6),
        SMALL_WHITE_CIRCLE(7),
        MANSION(8),
        TEMPLE(9),
        BANNER_WHITE(10),
        BANNER_ORANGE(11),
        BANNER_MAGENTA(12),
        BANNER_LIGHT_BLUE(13),
        BANNER_YELLOW(14),
        BANNER_LIME(15),
        BANNER_PINK(16),
        BANNER_GRAY(17),
        BANNER_LIGHT_GRAY(18),
        BANNER_CYAN(19),
        BANNER_PURPLE(20),
        BANNER_BLUE(21),
        BANNER_BROWN(22),
        BANNER_GREEN(23),
        BANNER_RED(24),
        BANNER_BLACK(25),
        RED_X(26);

        private byte value;

        private Type(int value) {
            this.value = (byte) value;
        }

        /**
         *
         * @return 数值
         * @deprecated 不安全的参数
         */
        @Deprecated
        public byte getValue() {
            return value;
        }

        /**
         *
         * @param value 数值
         * @return 匹配类型
         * @deprecated 不安全的参数
         */
        @Deprecated
        public static Type byValue(byte value) {
            for (Type t : values()) {
                if (t.value == value) return t;
            }
            return null;
        }
    }

}