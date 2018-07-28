package org.bukkit.block.data;

/**
 * 'open'表示门类方块是否开着.
 */
public interface Openable extends BlockData {

    /**
     * 获取'open'属性值.
     * <p>
     * 原文:Gets the value of the 'open' property.
     *
     * @return 门是否开着
     */
    boolean isOpen();

    /**
     * 设置'open'属性值.
     * <p>
     * 原文:Sets the value of the 'open' property.
     *
     * @param open 门是否开着
     */
    void setOpen(boolean open);
}
