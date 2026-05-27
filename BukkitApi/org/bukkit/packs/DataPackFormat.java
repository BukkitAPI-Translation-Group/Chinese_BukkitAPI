package org.bukkit.packs;

/**
 * 代表一个数据包格式版本.
 */
public interface DataPackFormat extends Comparable<DataPackFormat> {

    /**
     * 获取主版本号.
     * <p>
     * 原文：
     * Gets the major version component.
     *
     * @return 主版本号
     */
    int getMajor();

    /**
     * 获取次版本号.
     * <p>
     * 原文：
     * Gets the minor version component.
     *
     * @return 次版本号
     */
    int getMinor();
}
