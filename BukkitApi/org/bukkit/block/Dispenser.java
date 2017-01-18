package org.bukkit.block;

import org.bukkit.Nameable;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.projectiles.BlockProjectileSource;

/**
 * 代表一个发射器.
 */
public interface Dispenser extends BlockState, InventoryHolder, Lockable, Nameable {

    /**
     * 获取此发射器的BlockProjectileSource对象.
     * <p>
     * 如果这个方块不是发射器,将返回null.
     * <p>
     * 原文:
     * Gets the BlockProjectileSource object for this dispenser.
     * <p>
     * If the block is no longer a dispenser, this will return null.
     *
     * @return 如果一个BlockProjectileSource对象有效将返回,否则返回null
     */
    public BlockProjectileSource getBlockProjectileSource();

    /**
     * 尝试发射这个方块的物品.
     * <p>
     * 如果这个方块不是发射器,将返回null.
     * <p>
     * 原文:
     * Attempts to dispense the contents of this block.
     * <p>
     * If the block is no longer a dispenser, this will return false.
     *
     * @return 返回true即表示成功,否则返回false
     */
    public boolean dispense();
}