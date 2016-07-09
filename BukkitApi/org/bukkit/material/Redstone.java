package org.bukkit.material;

/**
 * 代表可以带有或产生红石电能的物品.
 */
public interface Redstone {

    /**
     * 这个物品有没有充能.
     * <p>
     * 原文:Gets the current state of this Material, indicating if it's powered or
     * unpowered
     *
     * @return true代表充能
     */
    public boolean isPowered();
}
