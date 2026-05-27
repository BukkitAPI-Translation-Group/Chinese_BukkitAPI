package org.bukkit.block.data.type;

import org.bukkit.block.data.BlockData;
import org.jetbrains.annotations.NotNull;

/**
 * 'mode' 表示此测试方块所处的模式.
 */
public interface TestBlock extends BlockData {

    /**
     * 获取 'mode' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'mode' property.
     *
     * @return 'mode' 的值
     */
    @NotNull
    Mode getMode();

    /**
     * 设置 'mode' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'mode' property.
     *
     * @param mode 新的 'mode' 值
     */
    void setMode(@NotNull Mode mode);

    /**
     * 比较器将运行的模式.
     */
    public enum Mode {

        /**
         * 测试开始时触发红石脉冲.
         */
        START,
        /**
         * 被红石充能时将消息记录到日志文件.
         */
        LOG,
        /**
         * 被红石充能时使测试失败.
         */
        FAIL,
        /**
         * 被红石充能时完成测试.
         */
        ACCEPT;
    }
}
