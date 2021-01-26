package org.bukkit.block.data.type;

/**
 * 'short' 值表示该活塞臂是否由于正在回缩的原因比平时短.
 */
public interface PistonHead extends TechnicalPiston {

    /**
     * 获取 'short' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'short' property.
     *
     * @return 属性 'short' 的值
     */
    boolean isShort();

    /**
     * 设置 'short' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'short' property.
     *
     * @param _short 新的 'short' 属性值
     */
    void setShort(boolean _short);
}
