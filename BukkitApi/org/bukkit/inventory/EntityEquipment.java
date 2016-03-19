package org.bukkit.inventory;

import org.bukkit.entity.Entity;

/**
 * 生物实体的用户界面接口.
 * <p>
 * 原文:An interface to a creatures inventory
 */
public interface EntityEquipment {

    /**
     * Gets a copy of the item the entity is currently holding
     * in their main hand.
     *
     * @return the currently held item
     */
    ItemStack getItemInMainHand();

    /**
     * Sets the item the entity is holding in their main hand.
     *
     * @param item The item to put into the entities hand
     */
    void setItemInMainHand(ItemStack item);

    /**
     * Gets a copy of the item the entity is currently holding
     * in their off hand.
     *
     * @return the currently held item
     */
    ItemStack getItemInOffHand();

    /**
     * Sets the item the entity is holding in their off hand.
     *
     * @param item The item to put into the entities hand
     */
    void setItemInOffHand(ItemStack item);

    /**
     * 获取该生物实体手持的Item项目.
     * <p>
     * 原文:Gets a copy of the item the entity is currently holding
     *
     * @deprecated entities can duel wield now use the methods for the
     *      specific hand instead
     * @see #getItemInMainHand()
     * @see #getItemInOffHand()
     * @return 手持Item项目
     */
    @Deprecated
    ItemStack getItemInHand();

    /**
     * 设置该生物实体的手持的Item项目.
     * <p>
     * 原文:Sets the item the entity is holding
     *
     * @deprecated entities can duel wield now use the methods for the
     *      specific hand instead
     * @see #setItemInMainHand(ItemStack)
     * @see #setItemInOffHand(ItemStack)
     * @param stack 需要设置的Item项目
     */
    @Deprecated
    void setItemInHand(ItemStack stack);

    /**
     * 获取该生物实体的头盔Item项目.
     * <p>
     * 原文:Gets a copy of the helmet currently being worn by the entity
     *
     * @return 头盔Item
     */
    ItemStack getHelmet();

    /**
     * 设置该生物实体的头盔Item项目.
     * <p>
     * 原文:Sets the helmet worn by the entity
     *
     * @param helmet 需要设置的头盔Item项目
     */
    void setHelmet(ItemStack helmet);

    /**
     * 获取该生物实体的胸甲Item项目.
     * <p>
     * 原文:Gets a copy of the chest plate currently being worn by the entity
     *
     * @return 胸甲Item项目
     */
    ItemStack getChestplate();

    /**
     * 设置该生物实体的胸甲Item项目.
     *
     * @param chestplate 需要设置的胸甲Item项目
     */
    void setChestplate(ItemStack chestplate);

    /**
     * 获取该生物实体的护腿Item项目.
     * <p>
     * 原文:Gets a copy of the leggings currently being worn by the entity
     *
     * @return 护腿Item项目
     */
    ItemStack getLeggings();

    /**
     * 设置该生物实体的护腿Item项目.
     *
     * @param leggings 需要设置的护腿Item项目
     */
    void setLeggings(ItemStack leggings);

    /**
     * 获取该生物实体的靴子Item项目.
     *
     * @return 靴子Item项目
     */
    ItemStack getBoots();

    /**
     * 设置该生物实体的靴子Item项目.
     *
     * @param boots 需要设置的靴子Item项目
     */
    void setBoots(ItemStack boots);

    /**
     * 获取该生物实体所穿戴的所有盔甲Item项目.
     *
     * @return 所穿戴的所有盔甲Item项目
     */
    ItemStack[] getArmorContents();

    /**
     * 设置该生物实体所穿戴的所有盔甲Item项目.
     * <p>
     * 原文:Sets the entities armor to the provided array of ItemStacks
     *
     * @param items 需要设置的Item项目
     */
    void setArmorContents(ItemStack[] items);

    /**
     * 清空该生物实体所穿戴的所有盔甲Item项目.
     * <p>
     * 原文:Clears the entity of all armor and held items
     */
    void clear();

    /**
     * 获取当该生物实体死亡后,手持Item项目掉落概率.
     * <p>
     * 原文:Gets the chance of the currently held item being dropped upon this
     * creature's death.
     * 
     * <ul>
     * <li>掉落概率为0F表示永不掉落.
     * <li>掉落概率为1F表示总是掉落.
     * </ul>
     *
     * @return 掉落概率(1F表示该生物实体为玩家)
     */
    float getItemInHandDropChance();

    /**
     * 设置当该生物实体死亡后,手持Item项目掉落概率.
     * <p>
     * 原文:Sets the chance of the item this creature is currently holding being
     * dropped upon this creature's death.
     * 
     * <ul>
     * <li>掉落概率为0F表示永不掉落.
     * <li>掉落概率为1F表示总是掉落.
     * </ul>
     *
     * @param chance 设置掉落概率
     * @throws UnsupportedOperationException 当该生物实体为玩家时候抛出该报错
     */
    void setItemInHandDropChance(float chance);

    /**
     * @deprecated entities can duel wield now use the methods for the specific
     * hand instead
     * @see #getItemInMainHandDropChance()
     * @see #getItemInOffHandDropChance()
     * @return drop chance
     */
    @Deprecated
    float getItemInHandDropChance();

    /**
     * @deprecated entities can duel wield now use the methods for the specific
     * hand instead
     * @see #setItemInMainHandDropChance(float)
     * @see #setItemInOffHandDropChance(float)
     * @param chance drop chance
     */
    @Deprecated
    void setItemInHandDropChance(float chance);

    /**
     * Gets the chance of the main hand item being dropped upon this creature's
     * death.
     *
     * <ul>
     * <li>A drop chance of 0F will never drop
     * <li>A drop chance of 1F will always drop
     * </ul>
     *
     * @return chance of the currently held item being dropped (1 for players)
     */
    float getItemInMainHandDropChance();

    /**
     * Sets the chance of the item this creature is currently holding in their
     * main hand being dropped upon this creature's death.
     *
     * <ul>
     * <li>A drop chance of 0F will never drop
     * <li>A drop chance of 1F will always drop
     * </ul>
     *
     * @param chance the chance of the main hand item being dropped
     * @throws UnsupportedOperationException when called on players
     */
    void setItemInMainHandDropChance(float chance);

    /**
     * Gets the chance of the off hand item being dropped upon this creature's
     * death.
     *
     * <ul>
     * <li>A drop chance of 0F will never drop
     * <li>A drop chance of 1F will always drop
     * </ul>
     *
     * @return chance of the off hand item being dropped (1 for players)
     */
    float getItemInOffHandDropChance();

    /**
     * Sets the chance of the off hand item being dropped upon this creature's
     * death.
     *
     * <ul>
     * <li>A drop chance of 0F will never drop
     * <li>A drop chance of 1F will always drop
     * </ul>
     *
     * @param chance the chance of off hand item being dropped
     * @throws UnsupportedOperationException when called on players
     */
    void setItemInOffHandDropChance(float chance);

    /**
     * 获取该生物实体死亡时头盔项目的掉落概率.
     * <p>
     * 原文:Gets the chance of the helmet being dropped upon this creature's death.
     * 
     * <ul>
     * <li>掉落概率为0F表示永不掉落.
     * <li>掉落概率为1F表示总是掉落.
     * </ul>
     *
     * @return 掉落概率(1F表示该生物实体为玩家)
     */
    float getHelmetDropChance();

    /**
     * 设置该生物实体死亡时头盔项目的掉落概率.
     * <p>
     * 原文:Sets the chance of the helmet being dropped upon this creature's death.
     * 
     * <ul>
     * <li>掉落概率为0F表示永不掉落.
     * <li>掉落概率为1F表示总是掉落.
     * </ul>
     *
     * @param chance 设置头盔掉落概率
     * @throws UnsupportedOperationException 当该生物实体为玩家时候抛出该报错
     */
    void setHelmetDropChance(float chance);

    /**
     * 获取该生物实体死亡时胸甲项目的掉落概率.
     * <p>
     * 原文:Gets the chance of the chest plate being dropped upon this creature's
     * death.
     * 
     * <ul>
     * <li>掉落概率为0F表示永不掉落.
     * <li>掉落概率为1F表示总是掉落.
     * </ul>
     *
     * @return 掉落概率(1F表示该生物实体为玩家)
     */
    float getChestplateDropChance();

    /**
     * 设置该生物实体死亡时胸甲项目的掉落概率.
     * <p>
     * 原文:Sets the chance of the chest plate being dropped upon this creature's
     * death.
     * 
     * <ul>
     * <li>掉落概率为0F表示永不掉落.
     * <li>掉落概率为1F表示总是掉落.
     * </ul>
     *
     * @param chance 设置胸甲掉落概率
     * @throws UnsupportedOperationException 当该生物实体为玩家时候抛出该报错
     */
    void setChestplateDropChance(float chance);

    /**
     * 获取该生物实体死亡时护腿项目的掉落概率.
     * <p>
     * 原文:Gets the chance of the leggings being dropped upon this creature's
     * death.
     * 
     * <ul>
     * <li>掉落概率为0F表示永不掉落.
     * <li>掉落概率为1F表示总是掉落.
     * </ul>
     *
     * @return 掉落概率(1F表示该生物实体为玩家)
     */
    float getLeggingsDropChance();

    /**
     * 设置该生物实体死亡时护腿项目的掉落概率.
     * <p>
     * 原文:Sets the chance of the leggings being dropped upon this creature's
     * death.
     * 
     * <ul>
     * <li>掉落概率为0F表示永不掉落.
     * <li>掉落概率为1F表示总是掉落.
     * </ul>
     *
     * @param chance 设置护腿掉落概率
     * @throws UnsupportedOperationException 当该生物实体为玩家时候抛出该报错
     */
    void setLeggingsDropChance(float chance);

    /**
     * 获取该生物实体死亡时靴子项目的掉落概率.
     * <p>
     * 原文:Gets the chance of the boots being dropped upon this creature's death.
     * 
     * <ul>
     * <li>掉落概率为0F表示永不掉落.
     * <li>掉落概率为1F表示总是掉落.
     * </ul>
     *
     * @return 掉落概率(1F表示该生物实体为玩家)
     */
    float getBootsDropChance();

    /**
     * 设置该生物实体死亡时靴子项目的掉落概率.
     * <p>
     * 原文:Sets the chance of the boots being dropped upon this creature's death.
     * 
     * <ul>
     * <li>掉落概率为0F表示永不掉落.
     * <li>掉落概率为1F表示总是掉落.
     * </ul>
     *
     * @param chance 设置靴子掉落概率
     * @throws UnsupportedOperationException 当该生物实体为玩家时候抛出该报错
     */
    void setBootsDropChance(float chance);

    /**
     * 获取该盔甲项目属于哪个实体.
     * <p>
     * 原文:Get the entity this EntityEquipment belongs to
     *
     * @return 实体项目
     */
    Entity getHolder();
}