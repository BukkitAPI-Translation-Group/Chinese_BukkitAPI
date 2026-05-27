package org.bukkit.entity;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表物品展示实体。
 */
public interface ItemDisplay extends Display {

    /**
     * 获取显示的物品堆。
     * <p>原文：Gets the displayed item stack.
     *
     * @return the displayed item stack
     */
    @Nullable
    ItemStack getItemStack();

    /**
     * 设置显示的物品堆。
     * <p>原文：Sets the displayed item stack.
     *
     * @param item the new item stack
     */
    void setItemStack(@Nullable ItemStack item);

    /**
     * 获取此实体的物品显示变换。
     * <p>原文：Gets the item display transform for this entity.
     *
     * Defaults to {@link ItemDisplayTransform#FIXED}.
     *
     * @return item display transform
     */
    @NotNull
    ItemDisplayTransform getItemDisplayTransform();

    /**
     * 设置此实体的物品显示变换。
     * <p>原文：Sets the item display transform for this entity.
     *
     * Defaults to {@link ItemDisplayTransform#FIXED}.
     *
     * @param display new display
     */
    void setItemDisplayTransform(@NotNull ItemDisplayTransform display);

    /**
     * 代表要应用于显示物品的物品模型变换。
     */
    public enum ItemDisplayTransform {

        NONE,
        THIRDPERSON_LEFTHAND,
        THIRDPERSON_RIGHTHAND,
        FIRSTPERSON_LEFTHAND,
        FIRSTPERSON_RIGHTHAND,
        HEAD,
        GUI,
        GROUND,
        FIXED;
    }
}
