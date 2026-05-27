package org.bukkit.packs;

/**
 * 代表一个数据包格式版本.
 */
public interface DataPackFormat extends Comparable<DataPackFormat> {

    /**
     * 获取主版本号.
     *
     * @return 主版本号
     */
    int getMajor();

    /**
     * 获取次版本号.
     *
     * @return 次版本号
     */
    int getMinor();
}
