package org.bukkit.entity;

import org.jetbrains.annotations.NotNull;

/**
 * 代表末影龙的组成部分
 */
public interface EnderDragonPart extends ComplexEntityPart, Damageable {
    @Override
    @NotNull
    public EnderDragon getParent();
}
