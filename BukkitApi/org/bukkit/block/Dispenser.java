package org.bukkit.block;

import org.bukkit.Nameable;
import org.bukkit.loot.Lootable;
import org.bukkit.projectiles.BlockProjectileSource;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一个发射器(快照).
 */
public interface Dispenser extends Container, Nameable, Lootable {

    /**
     * 获取此发射器的BlockProjectileSource对象.
     * <p>
     * 如果这个方块不是发射器,将返回null.
     * <p>
     * 原文:
     * Gets the BlockProjectileSource object for the dispenser.
     * <p>
     * If the block represented by this state is no longer a dispenser, this
     * will return null.
     *
     * @return 如果一个BlockProjectileSource对象有效将返回,否则返回null
     * @throws IllegalStateException 如果方块状态未应用(译注:仅仅是一种表示而未应用到实际的方块上)
     */
    @Nullable
    public BlockProjectileSource getBlockProjectileSource();

    /**
     * 尝试发射发射器内的物品.
     * <p>
     * 如果这个方块不是发射器,将返回false.
     * <p>
     * 原文:
     * Attempts to dispense the contents of the dispenser.
     * <p>
     * If the block represented by this state is no longer a dispenser, this
     * will return false.
     *
     * @return 返回true即表示成功,否则返回false
     * @throws IllegalStateException 如果方块状态未应用(译注:仅仅是一种表示而未应用到实际的方块上)
     */
    public boolean dispense();
}