package org.bukkit.block;

import org.bukkit.entity.Entity;
import org.bukkit.event.block.BellRingEvent;
import org.jetbrains.annotations.Nullable;

/**
 * 代表钟.
 */
public interface Bell extends TileState {

    /**
     * 敲响此钟. 这将调用一个 {@link BellRingEvent}.
     * <p>
     * 原文:
     * Ring this bell. This will call a {@link BellRingEvent}.
     *
     * @param entity 敲响钟的实体
     * @param direction 钟被敲响的方向, 或null表示按钟面对的方向敲响
     * @return 如果成功敲响返回true, 如果事件被取消返回false
     */
    public boolean ring(@Nullable Entity entity, @Nullable BlockFace direction);

    /**
     * 按钟面对的方向敲响此钟. 这将调用一个 {@link BellRingEvent}.
     * <p>
     * 原文:
     * Ring this bell in the direction that the bell is facing. This will call a
     * {@link BellRingEvent}.
     *
     * @param entity 敲响钟的实体
     * @return 如果成功敲响返回true, 如果事件被取消返回false
     */
    public boolean ring(@Nullable Entity entity);

    /**
     * 敲响此钟. 这将调用一个 {@link BellRingEvent}.
     * <p>
     * 原文:
     * Ring this bell. This will call a {@link BellRingEvent}.
     *
     * @param direction 钟被敲响的方向, 或null表示按钟面对的方向敲响
     * @return 如果成功敲响返回true, 如果事件被取消返回false
     */
    public boolean ring(@Nullable BlockFace direction);

    /**
     * 按钟面对的方向敲响此钟. 这将调用一个 {@link BellRingEvent}.
     * <p>
     * 原文:
     * Ring this bell in the direction that the bell is facing. This will call a
     * {@link BellRingEvent}.
     *
     * @return 如果成功敲响返回true, 如果事件被取消返回false
     */
    public boolean ring();

    /**
     * 检查此钟是否正在摇晃. 如果钟最近被敲响, 则认为它正在摇晃.
     * <p>
     * 原文:
     * Check whether or not this bell is shaking. A bell is considered to be
     * shaking if it was recently rung.
     * <p>
     * A bell will typically shake for 50 ticks.
     *
     * 钟通常会摇晃50个游戏刻.
     *
     * @return 如果正在摇晃返回true, 否则返回false
     */
    public boolean isShaking();

    /**
     * 获取此钟开始摇晃以来的游戏刻数, 如果钟当前未摇晃则返回0.
     * <p>
     * 原文:
     * Get the amount of ticks since this bell has been shaking, or 0 if the
     * bell is not currently shaking.
     * <p>
     * A bell will typically shake for 50 ticks.
     *
     * 钟通常会摇晃50个游戏刻.
     *
     * @return 自钟被敲响以来的时间(以游戏刻计), 如果未摇晃则返回0
     */
    public int getShakingTicks();

    /**
     * 检查此钟是否正在共鸣. 如果在 {@link #isShaking() 摇晃时}, 在区域内检测到袭击者并准备向附近玩家高亮显示, 则认为钟正在共鸣.
     * <p>
     * 原文:
     * Check whether or not this bell is resonating. A bell is considered to be
     * resonating if {@link #isShaking() while shaking}, raiders were detected
     * in the area and are ready to be highlighted to nearby players.
     * <p>
     * A bell will typically resonate for 40 ticks.
     *
     * 钟通常会共鸣40个游戏刻.
     *
     * @return 如果正在共鸣返回true, 否则返回false
     */
    public boolean isResonating();

    /**
     * 获取此钟开始共鸣以来的游戏刻数, 如果钟当前未共鸣则返回0.
     * <p>
     * 原文:
     * Get the amount of ticks since this bell has been resonating, or 0 if the
     * bell is not currently resonating.
     * <p>
     * A bell will typically resonate for 40 ticks.
     *
     * 钟通常会共鸣40个游戏刻.
     *
     * @return 自钟开始共鸣以来的时间(以游戏刻计), 如果未共鸣则返回0
     */
    public int getResonatingTicks();
}
