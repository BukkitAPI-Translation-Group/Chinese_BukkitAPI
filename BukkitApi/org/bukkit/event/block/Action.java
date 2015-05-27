package org.bukkit.event.block;

public enum Action {

    /**
     * 左击一个方块
     */
    LEFT_CLICK_BLOCK,
    /**
     * 右击一个方块
     */
    RIGHT_CLICK_BLOCK,
    /**
     * 左击空气
     */
    LEFT_CLICK_AIR,
    /**
     * 右击空气
     */
    RIGHT_CLICK_AIR,
    /**
     * 踩上一个方块 (Ass-pressure/物理事件)
     *
     * 举几个例子:
     * <ul>
     * <li>在耕地跳跃
     * <li>站在压力板上
     * <li>点击红石矿石使之发光
     * <li>触发绊线钩
     * </ul>
     */
    PHYSICAL,
}
