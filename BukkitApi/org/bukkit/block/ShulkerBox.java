package org.bukkit.block;

import org.bukkit.DyeColor;
import org.bukkit.loot.Lootable;
import org.jetbrains.annotations.Nullable;

/**
 * 代表潜影盒方块状态.
 */
public interface ShulkerBox extends Container, Lootable, Lidded {

    /**
     * 获取该潜影盒对应的{@link DyeColor 颜色}.
     * <p>
     * 原文:Get the {@link DyeColor} corresponding to this ShulkerBox
     *
     * @return 潜影盒的{@link DyeColor 颜色}, 如为默认则返回 null
     */
    @Nullable
    public DyeColor getColor();
}
