package org.bukkit.block.data.type;

import org.bukkit.block.data.BlockData;
import org.jetbrains.annotations.NotNull;

/**
 * 'mode' 值代表结构方块可执行的不同行为模式.
 */
public interface StructureBlock extends BlockData {

    /**
     * 获取 'mode' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'mode' property.
     *
     * @return 属性 'mode' 的值
     */
    @NotNull
    Mode getMode();

    /**
     * 设置 'mode' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'mode' property.
     *
     * @param mode 新的 'mode' 属性值
     */
    void setMode(@NotNull Mode mode);

    /**
     * 结构方块的执行模式.
     */
    public enum Mode {
        /**
         * 将选区保存为一个结构
         */
        SAVE,
        /**
         * 加载一个结构
         */
        LOAD,
        /**
         * 用于检测结构中两个相对的顶点
         */
        CORNER,
        /**
         * 在世界生成中, 自身被移除之前运行一个 (指定相关结构的) 自定义函数.
         */
        DATA;
    }
}
