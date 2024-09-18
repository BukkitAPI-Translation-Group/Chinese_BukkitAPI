package org.bukkit.inventory.meta;

import org.bukkit.inventory.meta.trim.ArmorTrim;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 表示实体可以装备的盔甲。
 * <p>
 * <strong>注意：盔甲纹饰是 Minecraft 的实验性功能的一部分，因此可能会有所变动。</strong>
 */
public interface ArmorMeta extends ItemMeta {

    /**
     * 检查该物品是否有盔甲纹饰。
     * <p>
     * 原文: Check whether or not this item has an armor trim.
     *
     * @return 如果有纹饰则返回 true，否则返回 false
     */
    boolean hasTrim();

    /**
     * 设置 {@link ArmorTrim}.
     * <p>
     * 原文: Set the {@link ArmorTrim}.
     *
     * @param trim 要设置的纹饰，传入 null 则移除纹饰
     */
    void setTrim(@Nullable ArmorTrim trim);

    /**
     * 获取 {@link ArmorTrim}。
     * <p>
     * 原文: Get the {@link ArmorTrim}.
     *
     * @return 盔甲纹饰，如果没有则返回 null
     */
    @Nullable
    ArmorTrim getTrim();

    @Override
    @NotNull
    ArmorMeta clone();
}
