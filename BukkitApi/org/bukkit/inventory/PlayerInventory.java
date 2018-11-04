package org.bukkit.inventory;

import org.bukkit.entity.HumanEntity;

/**
 * 玩家背包. 包括装备栏,背包和其他额外的格子. 
 */
public interface PlayerInventory extends Inventory {

    /**
     * 获取装备槽内的全部物品. 
     * <p>原文: 
     * Get all ItemStacks from the armor slots
     *
     * @return 装备槽的全部物品
     */
    public ItemStack[] getArmorContents();

    /**
     * 获取存储在此背包的所有额外物品.
     * <p>
     * 注意:额外的物品槽是由实现来定义的,但这些额外的物品不会在{@link #getStorageContents()}或{@link #getArmorContents()}之内.
     * <p>
     * 原文:Get all additional ItemStacks stored in this inventory.
     * <br>
     * NB: What defines an extra slot is up to the implementation, however it will not be contained within {@link #getStorageContents()} or {@link #getArmorContents()}
     *
     * @return 所有的附加物品
     */
    public ItemStack[] getExtraContents();

    /**
     * 返回头盔槽内的物品. 
     * <p>原文: 
     * Return the ItemStack from the helmet slot
     *
     * @return 头盔槽内的物品
     */
    public ItemStack getHelmet();

    /**
     * 返回胸甲槽内的物品. 
     * <p>原文: 
     * Return the ItemStack from the chestplate slot
     *
     * @return 胸甲槽内的物品
     */
    public ItemStack getChestplate();

    /**
     * 返回护腿槽内的物品. 
     * <p>原文: 
     * Return the ItemStack from the leg slot
     *
     * @return 护腿槽内的物品
     */
    public ItemStack getLeggings();

    /**
     * 返回靴子槽内的物品. 
     * <p>原文: 
     * Return the ItemStack from the boots slot
     *
     * @return 靴子槽内的物品
     */
    public ItemStack getBoots();

    /**
     * 把物品放在背包的指定位置.
     * <p>
     * 索引值0~8指向平视显示器(HUD)上的工具栏. 9~35指向主物品栏(中间的27个物品槽),
     * 从主物品栏的左上角往上数(索引值9指向主物品栏左上角的物品槽),向右移动,
     * 到行末时再从下一行的最左的物品槽继续往上数.
     * <p>
     * 索引值36~39指向玩家的盔甲槽. 即使你可以使用本方法设置盔甲槽内的物品,
     * 我们还是建议你使用我们提供的相关的设置盔甲槽内物品的方法来设置.
     * <p>
     * 索引值40指向副手(盾牌)物品槽. 即使你可以使用40索引值设置副手上的物品,
     * 但仍建议您使用已有方法来设置此物品槽 (该方法指{@link #setItemInOffHand(ItemStack)}).
     * <p>
     * 如果你试图传递错误的index值(取值范围为0&le;index&le;40)给本方法,
     * 将抛出ArrayIndexOutOfBounds异常.
     * <p>
     * 原文:Stores the ItemStack at the given index of the inventory.
     * <p>
     * Indexes 0 through 8 refer to the hotbar. 9 through 35 refer to the main inventory, counting up from 9 at the top
     * left corner of the inventory, moving to the right, and moving to the row below it back on the left side when it
     * reaches the end of the row. It follows the same path in the inventory like you would read a book.
     * <p>
     * Indexes 36 through 39 refer to the armor slots. Though you can set armor with this method using these indexes,
     * you are encouraged to use the provided methods for those slots.
     * <p>
     * Index 40 refers to the off hand (shield) item slot. Though you can set off hand with this method using this index,
     * you are encouraged to use the provided method for this slot.
     * <p>
     * If you attempt to use this method with an index less than 0 or greater than 40, an ArrayIndexOutOfBounds
     * exception will be thrown.
     *
     * @param index 将物品放在哪
     * @param item 要放置的物品
     * @throws ArrayIndexOutOfBoundsException 当 index 值 &lt; 0 || index &gt; 40
     * @see #setBoots(ItemStack)
     * @see #setChestplate(ItemStack)
     * @see #setHelmet(ItemStack)
     * @see #setLeggings(ItemStack)
     * @see #setItemInOffHand(ItemStack)
     */
    @Override
    public void setItem(int index, ItemStack item);

    /**
     * 设置装备槽的全部物品. 
     * <p>原文: 
     * Put the given ItemStacks into the armor slots
     *
     * @param items 用作装备的物品(任意)
     */
    public void setArmorContents(ItemStack[] items);

    /**
     * 将给定的物品放在额外物品槽内.
     * <p>
     * 请到 {@link #getExtraContents()} 去了解额外物品槽是什么.
     * <p>
     * 原文:Put the given ItemStacks into the extra slots
     * <br>
     * See {@link #getExtraContents()} for an explanation of extra slots.
     *
     * @param items 额外物品
     */
    public void setExtraContents(ItemStack[] items);

    /**
     * 设置头盔物品栏内的物品. 不检查它是不是一个头盔.
     * <p>原文: 
     * Put the given ItemStack into the helmet slot. This does not check if
     * the ItemStack is a helmet
     *
     * @param helmet 作为头盔的物品
     */
    public void setHelmet(ItemStack helmet);

    /**
     * 设置胸甲物品栏内的物品. 不检查它是不是一个胸甲.
     * <p>原文: 
     * Put the given ItemStack into the chestplate slot. This does not check
     * if the ItemStack is a chestplate
     *
     * @param chestplate 作为胸甲的物品
     */
    public void setChestplate(ItemStack chestplate);

    /**
     * 设置护腿物品栏内的物品. 不检查它是不是一个护腿.
     * <p>原文: 
     * Put the given ItemStack into the leg slot. This does not check if the
     * ItemStack is a pair of leggings
     *
     * @param leggings 作为护腿的物品
     */
    public void setLeggings(ItemStack leggings);

    /**
     * 设置靴子物品栏内的物品. 不检查它是不是一个靴子.
     * <p>原文: 
     * Put the given ItemStack into the boots slot. This does not check if the
     * ItemStack is a boots
     *
     * @param boots 作为靴子的物品
     */
    public void setBoots(ItemStack boots);

    /**
     * 获得玩家握在主手的物品(的副本).
     * <p>
     * 原文:Gets a copy of the item the player is currently holding in their main hand.
     *
     * @return 握着的物品
     */
    ItemStack getItemInMainHand();

    /**
     * 设置玩家握在主手的物品.
     * <p>
     * 原文:Sets the item the player is holding in their main hand.
     *
     * @param item 要放在玩家手上的物品
     */
    void setItemInMainHand(ItemStack item);

    /**
     * 获取玩家握在副手的物品(的副本).
     * <p>
     * 原文:Gets a copy of the item the player is currently holding
     * in their off hand.
     *
     * @return 握着的物品
     */
    ItemStack getItemInOffHand();

    /**
     * 设置玩家握在副手的物品.
     * <p>
     * 原文:Sets the item the player is holding in their off hand.
     *
     * @param item 要放在玩家副手上的物品
     */
    void setItemInOffHand(ItemStack item);

    /**
     * 玩家可以双持了，不再详细介绍.Gets a copy of the item the player is currently holding
     *
     * @deprecated players can duel wield now use the methods for the
     *      specific hand instead
     * @see #getItemInMainHand()
     * @see #getItemInOffHand()
     * @return the currently held item
     */
    @Deprecated
    public ItemStack getItemInHand();

    /**
     * 玩家可以双持了,不再详细介绍.Sets the item the player is holding
     *
     * @deprecated players can duel wield now use the methods for the
     *      specific hand instead
     * @see #setItemInMainHand(ItemStack)
     * @see #setItemInOffHand(ItemStack)
     * @param stack The item to put into the player's hand
     */
    @Deprecated
    public void setItemInHand(ItemStack stack);

    /**
     * 获取玩家握着的物品所在的物品槽位.
     * <p>
     * 原文:Get the slot number of the currently held item
     *
     * @return 槽位
     */
    public int getHeldItemSlot();

    /**
     * 设置玩家握着哪一个槽位的物品.
     * <p>
     * 本方法会验证“slot”的取值是否符合该不等式:0≤slot≤8.
     * <p>
     * 原文:Set the slot number of the currently held item.
     * <p>
     * This validates whether the slot is between 0 and 8 inclusive.
     *
     * @param slot 槽位
     * @throws IllegalArgumentException 如果slot的取值有误
     */
    public void setHeldItemSlot(int slot);

    public HumanEntity getHolder();
}
