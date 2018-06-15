package org.bukkit.material;

import org.bukkit.Material;

/**
 * 代表炼药锅
 */
public class Cauldron extends MaterialData {
    private static final int CAULDRON_FULL = 3;
    private static final int CAULDRON_EMPTY = 0;

    public Cauldron() {
        super(Material.CAULDRON);
    }

    /**
     *
     * @param type the raw type id
     * @param data the raw data
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Cauldron(int type, byte data) {
        super(type, data);
    }

    /**
     *
     * @param data the raw data
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Cauldron(byte data) {
        super(Material.CAULDRON, data);
    }

    /**
     * 检测这个炼药锅是不是满的
     * <p>
     * 原文：Check if the cauldron is full.
     *
     * @return 这个炼药锅是不是满的
     */
    public boolean isFull() {
        return getData() >= CAULDRON_FULL;
    }

    /**
     * 检测这个炼药锅是不是空的
     * <p>
     * 原文：Check if the cauldron is empty.
     *
     * @return 这个炼药锅是不是空的
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
