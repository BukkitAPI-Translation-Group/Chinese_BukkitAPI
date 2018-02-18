package org.bukkit;

/**
 * 指定旋转方向的枚举。
 */
public enum Rotation {

    /**
     * 无旋转。
     */
    NONE,
    /**
     * 按顺时针方向旋转45度。
     */
    CLOCKWISE_45,
    /**
     * 按顺时针方向旋转90度。
     */
    CLOCKWISE,
    /**
     * 按顺时针方向旋转135度。
     */
    CLOCKWISE_135,
    /**
     * 倒置翻转180度。
     */
    FLIPPED,
    /**
     * 倒置翻转180+45度。
     */
    FLIPPED_45,
    /**
     * 按逆时针方向旋转90度。
     */
    COUNTER_CLOCKWISE,
    /**
     * 按逆时针方向旋转45度。
     */
    COUNTER_CLOCKWISE_45
    ;

    private static final Rotation[] rotations = values();

    /**
     * 按顺时针方向旋转90度。
     * <p>
     * 原文：Rotate clockwise by 90 degrees.
     *
     * @return 旋转
     */
    public Rotation rotateClockwise() {
        return rotations[(this.ordinal() + 1) & 0x7];
    }

    /**
     * 按逆时针方向旋转90度。
     * <p>
     * 原文：Rotate counter-clockwise by 90 degrees.
     *
     * @return 旋转
     */
    public Rotation rotateCounterClockwise() {
        return rotations[(this.ordinal() - 1) & 0x7];
    }
}