package org.bukkit.block.structure;

/**
 * 代表{@link org.bukkit.block.Structure 结构方块}的使用模式.
 */
public enum UsageMode {

    /**
     * 储存模式.
     */
    SAVE,
    /**
     * 加载模式.
     */
    LOAD,
    /**
     * 角落模式, 用于保存结构时简单计算结构尺寸. 当使用此模式时,
     * 此结构名必须与处于{@link UsageMode#SAVE 储存模式}下的第二个结构方块的结构名相匹配.
     */
    CORNER,
    /**
     * 数据模式, 用于运行特定的自定义的函数, 这些函数仅可用于某些结构.
     * 当这个函数执行完毕后, 此结构方块将被删除.
     * 所有的数据标签(函数)可在
     * <a href="https://minecraft-zh.gamepedia.com/%E7%BB%93%E6%9E%84%E6%96%B9%E5%9D%97#.E6.95.B0.E6.8D.AE.E5.80.BC">wiki</a>
     * 中找到.
     */
    DATA;
}
