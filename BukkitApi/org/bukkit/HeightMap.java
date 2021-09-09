package org.bukkit;

/**
 * 与高度图有关的信息.
 *
 * @see <a href="https://minecraft-zh.gamepedia.com/区块格式">Minecraft Wiki - 区块格式</a>
 */
public enum HeightMap {

    /**
     * 最高的阻碍移动/含有流体的方块.
     */
    MOTION_BLOCKING,
    /**
     * 最高的阻碍移动、含有液体或在 {@link Tag#LEAVES} 标签内的方块.
     */
    MOTION_BLOCKING_NO_LEAVES,
    /**
     * 最高的非空气固体方块.
     */
    OCEAN_FLOOR,
    /**
     * 最高的既不是空气也不含流体的方块, 用于世界生成.
     */
    OCEAN_FLOOR_WG,
    /**
     * 最高的非空气方块.
     */
    WORLD_SURFACE,
    /**
     * 最高的非空气方块, 用于世界生成.
     */
    WORLD_SURFACE_WG,
}
