package org.bukkit.block.data.type;

import org.bukkit.block.data.Directional;
import org.bukkit.block.data.Powerable;
import org.jetbrains.annotations.NotNull;

/**
 * 'mode' 值表示该 (红石) 比较器将会以什么模式运算.
 */
public interface Comparator extends Directional, Powerable {

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
     * 比较器运算的方式.
     */
    public enum Mode {

        /**
         * 默认 (比较器) 模式, 与晶体管类似. 比较器将在后部输入信号强度大于侧部输入信号强度时停止输出信号
         */
        COMPARE,
        /**
         * 减法器模式. 输出信号强度为 max(后部输入信号强度 - max(左侧, 右侧输入信号强度), 0)
         */
        SUBTRACT;
    }
}
