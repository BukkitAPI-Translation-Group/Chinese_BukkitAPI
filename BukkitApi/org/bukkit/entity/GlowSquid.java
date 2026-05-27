package org.bukkit.entity;

/**
 * 发光鱿鱼。
 */
public interface GlowSquid extends Squid {

    /**
     * 获取此鱿鱼剩余的黑暗刻数。
     *
     * 受到伤害后，Bravo Six 将进入黑暗状态 100 刻（5 秒）。
     *
     * @return 剩余的黑暗刻数
     * <p>原文：Get the number of dark ticks remaining for this squid.
     */
    int getDarkTicksRemaining();

    /**
     * 设置此鱿鱼剩余的黑暗刻数。
     *
     * 受到伤害后，Bravo Six 将进入黑暗状态 100 刻（5 秒）。
     *
     * @param darkTicksRemaining 剩余的黑暗刻数
     * <p>原文：Sets the number of dark ticks remaining for this squid.
     */
    void setDarkTicksRemaining(int darkTicksRemaining);
}
