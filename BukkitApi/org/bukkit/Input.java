package org.bukkit;

import org.jetbrains.annotations.ApiStatus;

/**
 * 表示应用于实体的移动输入。
 */
@ApiStatus.Experimental
public interface Input {

    /**
     * 获取是否应用了前进输入。
     *
     * @return 前进输入。
     *
     * 原文：
     * Gets whether a forward input is applied.
     *
     * @return forward input
     */
    boolean isForward();

    /**
     * 获取是否应用了后退输入。
     *
     * @return 后退输入。
     *
     * 原文：
     * Gets whether a backward input is applied.
     *
     * @return backward input
     */
    boolean isBackward();

    /**
     * 获取是否应用了向左输入。
     *
     * @return 向左输入。
     *
     * 原文：
     * Gets whether a left input is applied.
     *
     * @return left input
     */
    boolean isLeft();

    /**
     * 获取是否应用了向右输入。
     *
     * @return 向右输入。
     *
     * 原文：
     * Gets whether a right input is applied.
     *
     * @return right input
     */
    boolean isRight();

    /**
     * 获取是否应用了跳跃输入。
     *
     * @return 跳跃输入。
     *
     * 原文：
     * Gets whether a jump input is applied.
     *
     * @return jump input
     */
    boolean isJump();

    /**
     * 获取是否应用了潜行输入。
     *
     * @return 潜行输入。
     *
     * 原文：
     * Gets whether a sneak input is applied.
     *
     * @return sneak input
     */
    boolean isSneak();

    /**
     * 获取是否应用了冲刺输入。
     *
     * @return 冲刺输入。
     *
     * 原文：
     * Gets whether a sprint input is applied.
     *
     * @return sprint input
     */
    boolean isSprint();
}
