package org.bukkit.entity;

/**
 * 表示一只蝙蝠. 
 */
public interface Bat extends Ambient {

    /**
     * 检查这个蝙蝠的当前清醒状态.</br> 
     * 这并不意味着通过调用方法可以保持某状态. 
     * <p>
     * 原文:Checks the current waking state of this bat.</br>
     * This does not imply any persistence of state past the method call.
     *
     * @return 如果蝙蝠当前是悬挂在方块上的,则返回true
     */
    boolean isAwake();

    /**
     * 通过此方法修改蝙蝠的清醒状态.</br>
     * 这不意味着蝙蝠不会自发的清醒或重新悬挂在方块上.
     * <p>
     * 原文:This method modifies the current waking state of this bat.</br>
     * This does not prevent a bat from spontaneously awaking itself, or from
     * reattaching itself to a block.
     *
     * @param state 新状态
     */
    void setAwake(boolean state);
}
