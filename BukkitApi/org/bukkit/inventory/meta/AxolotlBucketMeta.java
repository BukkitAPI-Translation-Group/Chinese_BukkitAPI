package org.bukkit.inventory.meta;

import org.bukkit.entity.Axolotl;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一桶美西螈.
 */
public interface AxolotlBucketMeta extends ItemMeta {

    /**
     * 获取桶中美西螈的变种.
     * <p>
     * 插件应该在调用此方法之前检查 hasVariant() 是否返回 <code>true</code>.
     * <p>
     * 原文：Get the variant of the axolotl in the bucket. Plugins should check that hasVariant() returns <code>true</code> before calling this method.
     *
     * @return 美西螈变种
     */
    @NotNull
    Axolotl.Variant getVariant();

    /**
     * 设置此桶中美西螈的变种.
     * <p>
     * 原文：Set the variant of this axolotl in the bucket.
     *
     * @param variant 美西螈变种
     */
    void setVariant(@NotNull Axolotl.Variant variant);

    /**
     * 检查是否存在变种标签，该标签表示将生成特定的美西螈.
     * <p>
     * 原文：Checks for existence of a variant tag indicating a specific axolotl will be spawned.
     *
     * @return 是否存在变种
     */
    boolean hasVariant();

    @Override
    @NotNull
    AxolotlBucketMeta clone();
}
