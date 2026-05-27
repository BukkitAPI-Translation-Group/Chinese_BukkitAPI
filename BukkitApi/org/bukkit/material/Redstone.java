package org.bukkit.material;

/**
 * 表示一种可以携带或产生红石信号的材料.
 */
public interface Redstone {

    /**
     * 获取此材料的当前状态, 表示其是否被充能.
     * <p>
     * 原文：
     * Gets the current state of this Material, indicating if it's powered or
     * unpowered
     *
     * @return 如果被充能则返回true, 否则返回false
     */
    public boolean isPowered();
}
