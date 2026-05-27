package org.bukkit.block;

/**
 * 表示一个方块在其某个面上可以提供的支持等级。
 * <p>
 * 一个方块的任意给定面可能支持从无到全部三种枚举值。例如，草方块的顶面可以支持需要完整面、中心面或刚性面的方块。相反，营火除底面外的所有面都不能支持任何方块，而底面可以支持需要完整面或中心面的方块（如天花板按钮）。
 */
public enum BlockSupport {

    /**
     * 该面被视为完整方块。例如，楼梯的侧面<strong>不是</strong>完整面，不能支持墙上的火把，而楼梯的背面和底面则被视为完整面。
     */
    FULL,
    /**
     * 该面能够支持朝向中心的方块。例如，墙或栅栏柱可以支持站立的火把，因为方块中间有一个实心组件。
     */
    CENTER,
    /**
     * 该面能够支持脆弱的方块，如铁轨。大多数可完整支持的顶面都是刚性的， unlike walls and posts, or the side of a stone block, none of which are rigid.
     */
    RIGID;

}
