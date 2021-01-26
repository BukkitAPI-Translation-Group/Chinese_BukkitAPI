package org.bukkit.block.data.type;

import java.util.Set;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.AnaloguePowerable;
import org.jetbrains.annotations.NotNull;

/**
 * 'north', 'east', 'south', 'west' 代表该红石线与临近方块连接的方式.
 */
public interface RedstoneWire extends AnaloguePowerable {

    /**
     * 查看指定方块朝向上的连接类型.
     * <p>
     * 原文:
     * Checks the type of connection on the specified face.
     *
     * @param face 目标方块朝向
     * @return 连接类型
     */
    @NotNull
    Connection getFace(@NotNull BlockFace face);

    /**
     * 设置指定方块朝向上的连接类型.
     * <p>
     * 原文:
     * Sets the type of connection on the specified face.
     *
     * @param face 目标方块朝向
     * @param connection 目标连接类型
     */
    void setFace(@NotNull BlockFace face, @NotNull Connection connection);

    /**
     * 获取该方块所有可以连接的方块朝向.
     * <p>
     * 原文:
     * Gets all of this faces which may be set on this block.
     *
     * @return 所有允许的方块朝向
     */
    @NotNull
    Set<BlockFace> getAllowedFaces();

    /**
     * 红石线可连接到临近方块面的类型.
     */
    public enum Connection {
        /**
         * 红石线沿着与该面相邻的方块向上移动
         */
        UP,
        /**
         * 红石线沿着平面移动并进入 (强充能) 方块.
         */
        SIDE,
        /**
         * 红石线还没有与任何方块连接.
         */
        NONE;
    }
}
