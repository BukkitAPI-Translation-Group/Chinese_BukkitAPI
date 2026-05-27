package org.bukkit.material;

public interface Openable {

    /**
     * 检查门是否已打开.
     * <p>
     * 原文：
     * Check to see if the door is open.
     *
     * @return 如果门已逆时针旋转打开则返回true
     */
    boolean isOpen();

    /**
     * 设置此门为打开或关闭状态.
     * <p>
     * 原文：
     * Configure this door to be either open or closed;
     *
     * @param isOpen 设为true以打开门.
     */
    void setOpen(boolean isOpen);
}
