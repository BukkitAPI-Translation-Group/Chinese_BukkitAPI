package org.bukkit.projectiles;

import org.bukkit.block.Block;

public interface BlockProjectileSource extends ProjectileSource {

    /**
     * 获取这个抛射物所属的方块。
     * <p>
     * 原文：Gets the block this projectile source belongs to.
     *
     * @return 抛射物所属方块
     */
    public Block getBlock();
}