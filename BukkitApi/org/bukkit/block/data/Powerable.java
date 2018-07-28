package org.bukkit.block.data;

/**
 * 'powered'数据值表示该方块是否被充能.也就是说，方块正接受大于0的红石信号.
 */
public interface Powerable extends BlockData {

    /**
     * 获取'powered'数据值.
     * <p>
     * 原文:Gets the value of the 'powered' property.
     *
     * @return 方块是否被充能
     */
    boolean isPowered();

    /**
     * 设置'powered'数据值.
     * <p>
     * 原文:Sets the value of the 'powered' property.
     *
     * @param powered 方块是否被充能
     */
    void setPowered(boolean powered);
}
