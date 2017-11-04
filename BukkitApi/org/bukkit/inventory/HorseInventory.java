package org.bukkit.inventory;

/**
 * 马匹的用户界面接口.
 */
public interface HorseInventory extends Inventory {

    /**
     * 获取马匹的马鞍Item项目.
     * <p>
     * 原文:Gets the item in the horse's saddle slot.
     *
     * @return 马鞍Item
     */
    ItemStack getSaddle();

    /**
     * 获取马匹的盔甲Item项目.
     * <p>
     * 原文:Gets the item in the horse's armor slot.
     *
     * @return 盔甲Item项目
     */
    ItemStack getArmor();

    /**
     * 设置马匹的马鞍Item项目.
     * <p>
     * 原文:Sets the item in the horse's saddle slot.
     *
     * @param stack 需要设置的马鞍Item项目
     */
    void setSaddle(ItemStack stack);

    /**
     * 设置马匹的盔甲Item项目.
     * <p>
     * 原文:Sets the item in the horse's armor slot.
     *
     * @param stack 盔甲Item项目
     */
    void setArmor(ItemStack stack);
}
