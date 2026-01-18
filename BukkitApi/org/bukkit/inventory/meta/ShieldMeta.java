package org.bukkit.inventory.meta;

import org.bukkit.DyeColor;
import org.jetbrains.annotations.Nullable;

public interface ShieldMeta extends BannerMeta {

    /**
     * 获取此盾牌的基础颜色.
     *
     * @return 基础颜色, 如果未设置则返回 null
     */
    @Nullable
    DyeColor getBaseColor();

    /**
     * 设置此盾牌的基础颜色.
     * <p>
     * <b>注意:</b> 如果盾牌包含 {@link org.bukkit.block.banner.Pattern} (旗帜图案),
     * 那么将基础颜色设置为 null 会保留图案, 但会将基础颜色默认设为 {@link DyeColor#WHITE} (白色).
     *
     * @param color 基础颜色, 或 null
     */
    void setBaseColor(@Nullable DyeColor color);

}