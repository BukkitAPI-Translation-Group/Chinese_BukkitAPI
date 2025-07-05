package org.bukkit.map;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.Locale;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.registry.RegistryAware;
import org.bukkit.util.OldEnum;
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
    private byte direction;
    private boolean visible;
    private String caption;
    private Type type;

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
    @Deprecated(since = "1.6.2")
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
     * @deprecated 不安全的参数，请使用 {@link #MapCursor(byte, byte, byte, Type, boolean, String)}
     */
    @Deprecated(since = "1.13")
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
        this.type = type;
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
        return type;
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
    @Deprecated(since = "1.6.2")
    public byte getRawType() {
        return type.getValue();
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
        Preconditions.checkArgument(direction >= 0 && direction <= 15, "direction must be between 0 and 15 but is %s", direction);
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
        this.type = type;
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
    @Deprecated(since = "1.6.2")
    public void setRawType(byte type) {
        Type enumType = Type.byValue(type);
        Preconditions.checkArgument(enumType != null, "Unknown type by id %s", type);
        this.type = enumType;
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
    public interface Type extends OldEnum<Type>, Keyed, RegistryAware {

        Type PLAYER = getType("player");
        Type FRAME = getType("frame");
        Type RED_MARKER = getType("red_marker");
        Type BLUE_MARKER = getType("blue_marker");
        Type TARGET_X = getType("target_x");
        Type TARGET_POINT = getType("target_point");
        Type PLAYER_OFF_MAP = getType("player_off_map");
        Type PLAYER_OFF_LIMITS = getType("player_off_limits");
        Type MANSION = getType("mansion");
        Type MONUMENT = getType("monument");
        Type BANNER_WHITE = getType("banner_white");
        Type BANNER_ORANGE = getType("banner_orange");
        Type BANNER_MAGENTA = getType("banner_magenta");
        Type BANNER_LIGHT_BLUE = getType("banner_light_blue");
        Type BANNER_YELLOW = getType("banner_yellow");
        Type BANNER_LIME = getType("banner_lime");
        Type BANNER_PINK = getType("banner_pink");
        Type BANNER_GRAY = getType("banner_gray");
        Type BANNER_LIGHT_GRAY = getType("banner_light_gray");
        Type BANNER_CYAN = getType("banner_cyan");
        Type BANNER_PURPLE = getType("banner_purple");
        Type BANNER_BLUE = getType("banner_blue");
        Type BANNER_BROWN = getType("banner_brown");
        Type BANNER_GREEN = getType("banner_green");
        Type BANNER_RED = getType("banner_red");
        Type BANNER_BLACK = getType("banner_black");
        Type RED_X = getType("red_x");
        Type VILLAGE_DESERT = getType("village_desert");
        Type VILLAGE_PLAINS = getType("village_plains");
        Type VILLAGE_SAVANNA = getType("village_savanna");
        Type VILLAGE_SNOWY = getType("village_snowy");
        Type VILLAGE_TAIGA = getType("village_taiga");
        Type JUNGLE_TEMPLE = getType("jungle_temple");
        Type SWAMP_HUT = getType("swamp_hut");
        Type TRIAL_CHAMBERS = getType("trial_chambers");

        @NotNull
        private static Type getType(@NotNull String key) {
            return Registry.MAP_DECORATION_TYPE.getOrThrow(NamespacedKey.minecraft(key));
        }

        /**
         * {@inheritDoc}
         *
         * @see #getKeyOrThrow()
         * @see #isRegistered()
         * @deprecated A key might not always be present, use {@link #getKeyOrThrow()} instead.
         */
        @NotNull
        @Override
        @Deprecated(since = "1.21.4")
        NamespacedKey getKey();

        /**
         * Gets the internal value of the cursor.
         *
         * @return the value
         * @deprecated Magic value
         */
        @Deprecated(since = "1.6.2")
        byte getValue();

        /**
         * Get a cursor by its internal value.
         *
         * @param value the value
         * @return the matching type
         * @deprecated Magic value
         */
        @Deprecated(since = "1.6.2")
        @Nullable
        static Type byValue(byte value) {
            for (Type t : values()) {
                if (t.getValue() == value) return t;
            }
            return null;
        }

        /**
         * @param name of the type.
         * @return the type with the given name.
         * @deprecated only for backwards compatibility, use {@link Registry#get(NamespacedKey)} instead.
         */
        @NotNull
        @Deprecated(since = "1.21")
        static Type valueOf(@NotNull String name) {
            Type type = Registry.MAP_DECORATION_TYPE.get(NamespacedKey.fromString(name.toLowerCase(Locale.ROOT)));
            Preconditions.checkArgument(type != null, "No Type found with the name %s", name);
            return type;
        }

        /**
         * @return an array of all known map cursor types.
         * @deprecated use {@link Registry#iterator()}.
         */
        @NotNull
        @Deprecated(since = "1.21")
        static Type[] values() {
            return Lists.newArrayList(Registry.MAP_DECORATION_TYPE).toArray(new Type[0]);
        }
    }

}