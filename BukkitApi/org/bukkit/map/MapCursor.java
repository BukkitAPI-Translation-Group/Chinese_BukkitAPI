package org.bukkit.map;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
     * @param x x坐标，范围为-128到127
     * @param y y坐标，范围为-128到127
     * @param direction 光标的朝向，范围为0到15
     * @param type 地图光标的类型（颜色、风格）
     * @param visible 光标在默认情况下是否可见
     * @deprecated 不安全的参数
     */
    @Deprecated
    public MapCursor(byte x, byte y, byte direction, byte type, boolean visible) {
        this(x, y, direction, type, visible, null);
    }

    /**
     * 初始化地图光标.
     * <p>
     * 原文:Initialize the map cursor.
     *
     * @param x x坐标，范围为-128到127
     * @param y y坐标，范围为-128到127
     * @param direction 光标的朝向，范围为0到15
     * @param type 地图光标的类型（颜色、风格）
     * @param visible 光标在默认情况下是否可见
     */
    public MapCursor(byte x, byte y, byte direction, @NotNull Type type, boolean visible) {
        this(x, y, direction, type, visible, null);
    }

    /**
     * 初始化地图光标.
     * <p>
     * 原文:Initialize the map cursor.
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
    public MapCursor(byte x, byte y, byte direction, byte type, boolean visible, @Nullable String caption) {
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
     * 原文:Initialize the map cursor.
     *
     * @param x x坐标，范围为-128到127
     * @param y y坐标，范围为-128到127
     * @param direction 光标的朝向，范围为0到15
     * @param type 地图光标的类型（颜色、风格）
     * @param visible 光标在默认情况下是否可见
     * @param caption 光标标题
     */
    public MapCursor(byte x, byte y, byte direction, @NotNull Type type, boolean visible, @Nullable String caption) {
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
    @NotNull
    public Type getType() {
        // It should be impossible to set type to something without appropriate Type, so this shouldn't return null
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
    public void setType(@NotNull Type type) {
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
    @Nullable
    public String getCaption() {
        return caption;
    }

    /**
     * Sets the caption on this cursor.
     *
     * @param caption new caption
     */
    public void setCaption(@Nullable String caption) {
        this.caption = caption;
    }

    /**
     * 表示地图光标的标准类型。可能有更多被资源包(原材质包)提供的类型，这个数值被客户端当做minecraft.jar里的'./assets/minecraft/textures/map/map_icons.png'文件的索引或一个材质包中的索引使用.
     * <p>
     * 原文：
     * Represents the standard types of map cursors. More may be made
     * available by resource packs - the value is used by the client as an
     * index in the file './assets/minecraft/textures/map/map_icons.png' from minecraft.jar or from a
     * resource pack.
     */
    public enum Type implements Keyed {
        PLAYER(0, "player"),
        FRAME(1, "frame"),
        RED_MARKER(2, "red_marker"),
        BLUE_MARKER(3, "blue_marker"),
        TARGET_X(4, "target_x"),
        TARGET_POINT(5, "target_point"),
        PLAYER_OFF_MAP(6, "player_off_map"),
        PLAYER_OFF_LIMITS(7, "player_off_limits"),
        MANSION(8, "mansion"),
        MONUMENT(9, "monument"),
        BANNER_WHITE(10, "banner_white"),
        BANNER_ORANGE(11, "banner_orange"),
        BANNER_MAGENTA(12, "banner_magenta"),
        BANNER_LIGHT_BLUE(13, "banner_light_blue"),
        BANNER_YELLOW(14, "banner_yellow"),
        BANNER_LIME(15, "banner_lime"),
        BANNER_PINK(16, "banner_pink"),
        BANNER_GRAY(17, "banner_gray"),
        BANNER_LIGHT_GRAY(18, "banner_light_gray"),
        BANNER_CYAN(19, "banner_cyan"),
        BANNER_PURPLE(20, "banner_purple"),
        BANNER_BLUE(21, "banner_blue"),
        BANNER_BROWN(22, "banner_brown"),
        BANNER_GREEN(23, "banner_green"),
        BANNER_RED(24, "banner_red"),
        BANNER_BLACK(25, "banner_black"),
        RED_X(26, "red_x"),
        VILLAGE_DESERT(27, "village_desert"),
        VILLAGE_PLAINS(28, "village_plains"),
        VILLAGE_SAVANNA(29, "village_savanna"),
        VILLAGE_SNOWY(30, "village_snowy"),
        VILLAGE_TAIGA(31, "village_taiga"),
        JUNGLE_TEMPLE(32, "jungle_temple"),
        SWAMP_HUT(33, "swamp_hut"),
        TRIAL_CHAMBERS(34, "trial_chambers")
        ;

        private byte value;
        private final NamespacedKey key;

        private Type(int value, String key) {
            this.value = (byte) value;
            this.key = NamespacedKey.minecraft(key);
        }

        @NotNull
        @Override
        public NamespacedKey getKey() {
            return key;
        }

        /**
         * Gets the internal value of the cursor.
         *
         * @return the value
         * @deprecated Magic value
         */
        @Deprecated
        public byte getValue() {
            return value;
        }

        /**
         * Get a cursor by its internal value.
         *
         * @param value the value
         * @return the matching type
         * @deprecated Magic value
         */
        @Deprecated
        @Nullable
        public static Type byValue(byte value) {
            for (Type t : values()) {
                if (t.value == value) return t;
            }
            return null;
        }
    }

}