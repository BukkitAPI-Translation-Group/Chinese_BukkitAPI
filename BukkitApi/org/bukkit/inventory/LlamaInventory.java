package org.bukkit.inventory;

import org.bukkit.entity.Llama;

/**
 * {@linkplain Llama 羊驼}的用户界面接口
 */
public interface LlamaInventory extends AbstractHorseInventory {

    /**
	 * 得到羊驼背包中装饰槽的物品, 通常是毛毯. 
	 * <p>
     * 原文:Gets the item in the llama's decor slot.
     *
     * @return 身上的装饰的ItemStack对象
     */
    ItemStack getDecor();

    /**
	 * 设置羊驼背包中装饰槽的物品.
	 * <p>
     * 原文:Sets the item in the llama's decor slot.
     *
     * @param stack 给定的物品
     */
    void setDecor(ItemStack stack);
}
