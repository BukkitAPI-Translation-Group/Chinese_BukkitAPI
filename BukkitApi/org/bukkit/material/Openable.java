package org.bukkit.material;

public interface Openable {

    /**
     * 检测这个门是否开着.
     * <p>
     * 原文：Check to see if the door is open.
     *
     * @return 门是否开着
     */
    boolean isOpen();

    /**
     * 设置这个门是否开着.
     * <p>
     * 原文：Configure this door to be either open or closed;
     *
     * @param isOpen 门是否开着
     */
    void setOpen(boolean isOpen);
}