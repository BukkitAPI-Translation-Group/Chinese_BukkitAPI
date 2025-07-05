package org.bukkit;

import com.google.common.collect.Maps;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

/**
 * 代表三种不同的沙石.
 */
public enum SandstoneType {
    CRACKED(0x0),
    GLYPHED(0x1),
    SMOOTH(0x2);

    private final byte data;
    private static final Map<Byte, SandstoneType> BY_DATA = Maps.newHashMap();

    private SandstoneType(final int data) {
        this.data = (byte) data;
    }

    /**
     * 获取沙石的数据值.
     * <p>
     * 原文:
     * Gets the associated data value representing this type of sandstone
     *
     * @return 沙石的数据值
     * @deprecated 魔法值
     */
    @Deprecated(since = "1.6.2")
    public byte getData() {
        return data;
    }

    /**
     * 用数据值获取沙石种类.
     * <p>
     * 原文:
     * Gets the type of sandstone with the given data value
     *
     * @param data 数据值
     * @return 用给定的值获取到的{@link SandstoneType},如不存在就为null, 
     * @deprecated 魔法值
     */
    @Deprecated(since = "1.6.2")
    @Nullable
    public static SandstoneType getByData(final byte data) {
        return BY_DATA.get(data);
    }

    static {
        for (SandstoneType type : values()) {
            BY_DATA.put(type.data, type);
        }
    }
}