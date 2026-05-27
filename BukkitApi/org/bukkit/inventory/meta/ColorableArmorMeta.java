package org.bukkit.inventory.meta;

import org.jetbrains.annotations.NotNull;

/**
 * 代表一种实体可以穿戴且可以染色的盔甲.
 */
public interface ColorableArmorMeta extends ArmorMeta, LeatherArmorMeta {

    @Override
    @NotNull
    ColorableArmorMeta clone();
}
