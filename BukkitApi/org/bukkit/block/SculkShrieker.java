package org.bukkit.block;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

/**
 * 代表幽匿尖啸体的捕获状态.
 */
public interface SculkShrieker extends TileState {

    /**
     * 获取此方块的最新警告等级.
     * <p>
     * 当警告等级达到4时, 尖啸体将尝试生成一个
     * 监守者.
     * <p>
     * 原文:Gets the most recent warning level of this block.
     *
     * When the warning level reaches 4, the shrieker will attempt to spawn a
     * Warden.
     *
     * @return 当前警告等级
     */
    int getWarningLevel();

    /**
     * 设置此方块的最新警告等级.
     * <p>
     * 当警告等级达到4时, 尖啸体将尝试生成一个
     * 监守者.
     * <p>
     * 原文:Sets the most recent warning level of this block.
     *
     * When the warning level reaches 4, the shrieker will attempt to spawn a
     * Warden.
     *
     * @param level 新警告等级
     */
    void setWarningLevel(int level);

    /**
     * 模拟玩家引起振动.
     * <p>
     * 原文:Simulates a player causing a vibration.
     *
     * @param player "引起"尖啸的玩家
     */
    void tryShriek(@Nullable Player player);
}
