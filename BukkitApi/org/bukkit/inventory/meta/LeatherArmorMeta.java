package org.bukkit.inventory.meta;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFactory;

/**
 * 代表{@link Material#LEATHER_BOOTS 皮革靴子}，{@link Material#LEATHER_CHESTPLATE 皮革外套}，{@link Material#LEATHER_HELMET 皮革帽子}，{@link Material#LEATHER_LEGGINGS 皮革裤子}，可以被染色.
 * <p>
 * 译注：下文中的“盔甲”可以是皮革靴子、外套、帽子、裤子任意一种，因为这个类代表了四种嘛.
 */
public interface LeatherArmorMeta extends ItemMeta {

    /**
     * 获取这个盔甲的颜色.如果它还没有被设置，就会返回{@link ItemFactory#getDefaultLeatherColor()}.
     * <p>
     * 原文：Gets the color of the armor. If it has not been set otherwise, it will
     * be {@link ItemFactory#getDefaultLeatherColor()}.
     *
     * @return 这个盔甲的颜色，注意这永远都不会是null
     */
    Color getColor();

    /**
     * 设置这个盔甲的颜色.
     * <p>
     * 原文：Sets the color of the armor.
     *
     * @param color 要设置的颜色.设置此为null等于设置成{@link ItemFactory#getDefaultLeatherColor()}.
     */
    void setColor(Color color);

    LeatherArmorMeta clone();
}