package org.bukkit;

import com.google.common.collect.Maps;
import java.util.Map;

/**
 * 代表世界的种类.
 */
public enum WorldType {
    NORMAL("DEFAULT"),
    FLAT("FLAT"),
    VERSION_1_1("DEFAULT_1_1"),
    LARGE_BIOMES("LARGEBIOMES"),
    AMPLIFIED("AMPLIFIED"),
    CUSTOMIZED("CUSTOMIZED"),
    BUFFET("BUFFET");

    private final static Map<String, WorldType> BY_NAME = Maps.newHashMap();
    private final String name;

    private WorldType(String name) {
        this.name = name;
    }

    /**
     * 获取世界种类名称.
     * <p>
     * 原文:
     * Gets the name of this WorldType
     *
     * @return 世界种类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 用世界种类名获取世界种类.
     * <p>
     * 原文:
     * Gets a Worldtype by its name
     *
     * @param name 世界种类名
     * @return 世界种类，不存在就为null
     */
    public static WorldType getByName(String name) {
        return BY_NAME.get(name.toUpperCase(java.util.Locale.ENGLISH));
    }

    static {
        for (WorldType type : values()) {
            BY_NAME.put(type.name, type);
        }
    }
}