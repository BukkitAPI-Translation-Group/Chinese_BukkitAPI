package org.bukkit.inventory;

import org.bukkit.entity.AbstractHorse;
import org.jetbrains.annotations.Nullable;

/**
 * 马(抽象概念的)({@link AbstractHorse})的物品栏界面接口.
 */
public interface AbstractHorseInventory extends Inventory {

    /**
     * 获取马所装备的马鞍.
     * <p>
     * 原文:Gets the item in the horse's saddle slot.
     *
     * @return 马鞍
     * @deprecated 不能给羊驼装配鞍
     */
    @Nullable
    @Deprecated(since = "1.21.5")
    ItemStack getSaddle();

    /**
     * 为这匹马装备一个马鞍.
     * <p>
     * 原文:Sets the item in the horse's saddle slot.
     *
     * @param stack 马鞍
     * @deprecated 不能给羊驼装配鞍
     */
    @Deprecated(since = "1.21.5")
    void setSaddle(@Nullable ItemStack stack);
}
