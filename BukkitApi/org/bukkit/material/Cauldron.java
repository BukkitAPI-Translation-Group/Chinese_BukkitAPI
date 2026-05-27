package org.bukkit.material;

import org.bukkit.Material;

/**
 * 代表一个炼药锅。
 *
 * @deprecated 所有 MaterialData 的用法均已弃用并可能被移除。
 * 请使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class Cauldron extends MaterialData {
    private static final int CAULDRON_FULL = 3;
    private static final int CAULDRON_EMPTY = 0;

    public Cauldron() {
        super(Material.LEGACY_CAULDRON);
    }

    /**
     * @param type 类型
     * @param data 原始数据值
     * @deprecated 魔法值
     */
    @Deprecated(since = "1.6.2")
    public Cauldron(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * @param data 原始数据值
     * @deprecated 魔法值
     */
    @Deprecated(since = "1.6.2")
    public Cauldron(byte data) {
        super(Material.LEGACY_CAULDRON, data);
    }

    /**
     * 检查炼药锅是否已满。
     *
     * @return 如果已满则返回 true。
     * <p>
     * 原文：Check if the cauldron is full.
     */
    public boolean isFull() {
        return getData() >= CAULDRON_FULL;
    }

    /**
     * 检查炼药锅是否为空。
     *
     * @return 如果为空则返回 true。
     * <p>
     * 原文：Check if the cauldron is empty.
     */
    public boolean isEmpty() {
        return getData() <= CAULDRON_EMPTY;
    }

    @Override
    public String toString() {
        return (isEmpty() ? "EMPTY" : (isFull() ? "FULL" : getData() + "/3 FULL")) + " CAULDRON";
    }

    @Override
    public Cauldron clone() {
        return (Cauldron) super.clone();
    }
}