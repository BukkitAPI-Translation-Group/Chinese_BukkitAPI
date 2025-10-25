package org.bukkit.block.data;

/**
 * 'hanging' 表示灯笼是否悬挂在方块上.
 * 
 * 原文:'hanging' denotes whether the lantern is hanging from a block.
 */
public interface Hangable extends BlockData {

    /**
     * 获取 'hanging' 属性的值.
     * 
     * 原文:Gets the value of the 'hanging' property.
     *
     * @return 'hanging' 属性的值
     * 原文:the 'hanging' value
     */
    boolean isHanging();

    /**
     * 设置 'hanging' 属性的值.
     * 
     * 原文:Sets the value of the 'hanging' property.
     *
     * @param hanging 新的 'hanging' 属性值
     * 原文:the new 'hanging' value
     */
    void setHanging(boolean hanging);
}
