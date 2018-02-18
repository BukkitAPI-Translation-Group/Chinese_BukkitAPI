package org.bukkit.inventory;

import org.bukkit.entity.Entity;

/**
 * 生物的背包界面接口
 */
public interface EntityEquipment {

    /**
     * 获取实体当前主手中手持的物品的拷贝
     * <p>
     * 原文: Gets a copy of the item the entity is currently holding
     * in their main hand.
     *
     * @return 当前主手手持的物品
     */
    ItemStack getItemInMainHand();

    /**
     * 设置实体在主手中手持的物品
     * <p>
     * 原文: Sets the item the entity is holding in their main hand.
     *
     * @param item 需要设置的物品
     */
    void setItemInMainHand(ItemStack item);

    /**
     * 获取实体当前副手中手持的物品的拷贝
     * <p>
     * 原文: Gets a copy of the item the entity is currently holding
     * in their off hand.
     *
     * @return 当前副手手持的物品
     */
    ItemStack getItemInOffHand();

    /**
     * 设置实体在副手中手持的物品
     * <p>
     * 原文: Sets the item the entity is holding in their off hand.
     *
     * @param item 需要设置的物品
     */
    void setItemInOffHand(ItemStack item);

    /**
     * 获取实体当前所持物品的拷贝
     * <p>
     * 译注: 反编译其实现, 发现其也是获取主手的物品
     * <p>
     * 原文: Gets a copy of the item the entity is currently holding
     *
     * @return the currently held item
     * @see #getItemInMainHand()
     * @see #getItemInOffHand()
     * @deprecated 现在实体可以双持, 所以需要特定的方法来获取指定的手
     */
    @Deprecated
    ItemStack getItemInHand();

    /**
     * 设置实体当前所持的物品
     * <p>
     * 译注: 反编译其实现, 发现其也是设置主手的物品
     * <p>
     * 原文: Sets the item the entity is holding
     *
     * @param stack 需要设置的物品
     * @see #setItemInMainHand(ItemStack)
     * @see #setItemInOffHand(ItemStack)
     * @deprecated 现在实体可以双持, 所以需要特定的方法来获取指定的手
     */
    @Deprecated
    void setItemInHand(ItemStack stack);

    /**
     * 获取该实体当前正在佩戴的头盔的拷贝
     * <p>
     * 原文: Gets a copy of the helmet currently being worn by the entity
     *
     * @return 所佩戴的头盔
     */
    ItemStack getHelmet();

    /**
     * 设置该实体当前正在佩戴的头盔
     * <p>
     * 原文: Sets the helmet worn by the entity
     *
     * @param helmet 给定的头盔
     */
    void setHelmet(ItemStack helmet);

    /**
     * 获取该实体当前正在穿戴的胸甲的拷贝
     * <p>
     * 原文: Gets a copy of the chest plate currently being worn by the entity
     *
     * @return 实体所穿戴的胸甲
     */
    ItemStack getChestplate();

    /**
     * 设置该实体当前正在穿戴的胸甲
     * <p>
     * 原文: Sets the chest plate worn by the entity
     *
     * @param chestplate 给定的胸甲
     */
    void setChestplate(ItemStack chestplate);

    /**
     * 获取该实体当前正在穿戴的护腿的拷贝
     * <p>
     * 原文: Gets a copy of the leggings currently being worn by the entity
     *
     * @return 实体所穿戴的护腿
     */
    ItemStack getLeggings();

    /**
     * 设置该实体当前正在穿戴的护腿
     * <p>
     * 原文: Sets the leggings worn by the entity
     *
     * @param leggings 给定的护腿
     */
    void setLeggings(ItemStack leggings);

    /**
     * 获取该实体当前正在穿戴的鞋子的拷贝
     * <p>
     * 原文: Gets a copy of the boots currently being worn by the entity
     *
     * @return 实体所穿戴的鞋子
     */
    ItemStack getBoots();

    /**
     * 设置该实体当前正在穿戴的鞋子
     * <p>
     * 原文: Sets the boots worn by the entity
     *
     * @param boots 给定的鞋子
     */
    void setBoots(ItemStack boots);

    /**
     * 获得实体当前所有穿着盔甲的拷贝
     * <p>
     * 译注: 其顺序为  鞋子、护腿、胸甲、头盔
     * <p>
     * 原文: Gets a copy of all worn armor
     *
     * @return 一个关于实体当前所有穿着的盔甲的数组
     */
    ItemStack[] getArmorContents();

    /**
     * 将实体所穿戴的盔甲设置为提供的ItemStacks数组
     * <p>
     * 译注:
     * <ul>
     * <li>该ItemStack数组的顺序应为  鞋子、护腿、胸甲、头盔
     * <li>当数组长度不够4个时, 将会把剩下的设置为null, 如为2时,胸甲和头盔将会自动设置为null
     * </ul>
     * <p>
     * 原文: Sets the entities armor to the provided array of ItemStacks
     *
     * @param items 给定的盔甲数组
     */
    void setArmorContents(ItemStack[] items);

    /**
     * 清除实体所有的盔甲和手持的物品
     * <p>
     * 原文: Clears the entity of all armor and held items
     */
    void clear();

    /**
     * @return 掉落的几率
     * @see #getItemInMainHandDropChance()
     * @see #getItemInOffHandDropChance()
     * @deprecated 现在实体可以双持, 所以需要特定的方法来设置指定的手
     */
    @Deprecated
    float getItemInHandDropChance();

    /**
     * @param chance 给定的掉落几率
     * @see #setItemInMainHandDropChance(float)
     * @see #setItemInOffHandDropChance(float)
     * @deprecated 现在实体可以双持, 所以需要特定的方法来设置指定的手
     */
    @Deprecated
    void setItemInHandDropChance(float chance);

    /**
     * 获得该生物在死亡时掉落其主手的物品的几率
     * <p>
     * 原文: Gets the chance of the main hand item being dropped upon this creature's
     * death.
     * <p>
     * <ul>
     * <li>当掉落几率为0.0F时, 则永远不会掉落
     * <li>当掉落几率为1.0F时, 则总是会掉落
     * </ul>
     *
     * @return 当前生物在死亡时掉落主手物品的几率(在原版里, 对于玩家来说是1.0F)
     */
    float getItemInMainHandDropChance();

    /**
     * 设置该生物在死亡时掉落其主手的物品的几率
     * <p>
     * 原文: Sets the chance of the item this creature is currently holding in their
     * main hand being dropped upon this creature's death.
     * <p>
     * <ul>
     * <li>当掉落几率为0.0F时, 则永远不会掉落
     * <li>当掉落几率为1.0F时, 则总是会掉落
     * </ul>
     *
     * @param chance 主手掉落物品的几率
     * @throws UnsupportedOperationException 当这一操作作用在玩家时抛出此异常
     */
    void setItemInMainHandDropChance(float chance);

    /**
     * 获得该生物在死亡时掉落其副手的物品的几率
     * <p>
     * 原文: Gets the chance of the off hand item being dropped upon this creature's
     * death.
     * <p>
     * <ul>
     * <li>当掉落几率为0.0F时, 则永远不会掉落
     * <li>当掉落几率为1.0F时, 则总是会掉落
     * </ul>
     *
     * @return 当前生物在死亡时掉落副手物品的几率(在原版里, 对于玩家来说是1.0F)
     */
    float getItemInOffHandDropChance();

    /**
     * 设置该生物在死亡时掉落其副手的物品的几率
     * <p>
     * 原文: Sets the chance of the off hand item being dropped upon this creature's
     * death.
     * <p>
     * <ul>
     * <li>当掉落几率为0.0F时, 则永远不会掉落
     * <li>当掉落几率为1.0F时, 则总是会掉落
     * </ul>
     *
     * @param chance 副手掉落物品的几率
     * @throws UnsupportedOperationException 当这一操作作用在玩家时抛出此异常
     */
    void setItemInOffHandDropChance(float chance);

    /**
     * 获得该生物在死亡时掉落其头盔的几率
     * <p>
     * 原文: Gets the chance of the helmet being dropped upon this creature's death.
     * <p>
     * <ul>
     * <li>当掉落几率为0.0F时, 则永远不会掉落
     * <li>当掉落几率为1.0F时, 则总是会掉落
     * </ul>
     *
     * @return 当前生物在死亡时掉落头盔的几率(在原版里, 对于玩家来说是1.0F)
     */
    float getHelmetDropChance();

    /**
     * 设置该生物在死亡时掉落其头盔的几率
     * <p>
     * 原文: Sets the chance of the helmet being dropped upon this creature's death.
     * <p>
     * <ul>
     * <li>当掉落几率为0.0F时, 则永远不会掉落
     * <li>当掉落几率为1.0F时, 则总是会掉落
     * </ul>
     *
     * @param chance 掉落头盔的几率
     * @throws UnsupportedOperationException 当这一操作作用在玩家时抛出此异常
     */
    void setHelmetDropChance(float chance);

    /**
     * 获得该生物在死亡时掉落其胸甲的几率
     * <p>
     * 原文: Gets the chance of the chest plate being dropped upon this creature's
     * death.
     * <p>
     * <ul>
     * <li>当掉落几率为0.0F时, 则永远不会掉落
     * <li>当掉落几率为1.0F时, 则总是会掉落
     * </ul>
     *
     * @return 当前生物在死亡时掉落胸甲的几率(在原版里, 对于玩家来说是1.0F)
     */
    float getChestplateDropChance();

    /**
     * 设置该生物在死亡时掉落其胸甲的几率
     * <p>
     * 原文: Sets the chance of the chest plate being dropped upon this creature's
     * death.
     * <p>
     * <ul>
     * <li>当掉落几率为0.0F时, 则永远不会掉落
     * <li>当掉落几率为1.0F时, 则总是会掉落
     * </ul>
     *
     * @param chance 掉落胸甲的几率
     * @throws UnsupportedOperationException 当这一操作作用在玩家时抛出此异常
     */
    void setChestplateDropChance(float chance);

    /**
     * 获得该生物在死亡时掉落其护腿的几率
     * <p>
     * 原文: Gets the chance of the leggings being dropped upon this creature's
     * death.
     * <p>
     * <ul>
     * <li>当掉落几率为0.0F时, 则永远不会掉落
     * <li>当掉落几率为1.0F时, 则总是会掉落
     * </ul>
     *
     * @return 当前生物在死亡时掉落护腿的几率(在原版里, 对于玩家来说是1.0F)
     */
    float getLeggingsDropChance();

    /**
     * 设置该生物在死亡时掉落其护腿的几率
     * <p>
     * 原文: Sets the chance of the leggings being dropped upon this creature's
     * death.
     * <p>
     * <ul>
     * <li>当掉落几率为0.0F时, 则永远不会掉落
     * <li>当掉落几率为1.0F时, 则总是会掉落
     * </ul>
     *
     * @param chance 掉落护腿的几率
     * @throws UnsupportedOperationException 当这一操作作用在玩家时抛出此异常
     */
    void setLeggingsDropChance(float chance);

    /**
     * 获得该生物在死亡时掉落其鞋子的几率
     * <p>
     * 原文: Gets the chance of the boots being dropped upon this creature's death.
     * <p>
     * <ul>
     * <li>当掉落几率为0.0F时, 则永远不会掉落
     * <li>当掉落几率为1.0F时, 则总是会掉落
     * </ul>
     *
     * @return 当前生物在死亡时掉落鞋子的几率(在原版里, 对于玩家来说是1.0F)
     */
    float getBootsDropChance();

    /**
     * 设置该生物在死亡时掉落其鞋子的几率
     * <p>
     * 原文: Sets the chance of the boots being dropped upon this creature's death.
     * <p>
     * <ul>
     * <li>当掉落几率为0.0F时, 则永远不会掉落
     * <li>当掉落几率为1.0F时, 则总是会掉落
     * </ul>
     *
     * @param chance 掉落鞋子的几率
     * @throws UnsupportedOperationException 当这一操作作用在玩家时抛出此异常
     */
    void setBootsDropChance(float chance);

    /**
     * 获取此EntityEquipment所属的实体
     * <p>
     * 原文: Get the entity this EntityEquipment belongs to
     *
     * @return 这个EntityEquipment所属的实体
     */
    Entity getHolder();
}
