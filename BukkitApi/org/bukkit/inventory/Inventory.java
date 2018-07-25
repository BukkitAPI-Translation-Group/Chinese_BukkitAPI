package org.bukkit.inventory;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;

/**
 * 各种物品栏的接口。有关{@link
 * Material#AIR}的行为时是未指定的.
 */
public interface Inventory extends Iterable<ItemStack> {

    /**
     * 返回此物品栏的大小.
     * <p>
     * 原文:Returns the size of the inventory
     *
     * @return 此物品栏的大小
     */
    public int getSize();

    /**
     * 返回这个物品栏的最大物品堆叠数量.
     * <p>
     * 原文:Returns the maximum stack size for an ItemStack in this inventory.
     *
     * @return 最大物品堆叠数量
     */
    public int getMaxStackSize();

    /**
     * 此方法可以让你改变一个物品栏的最大物品堆叠数量.
     * <p>
     * <b>警告:</b>
     * <ul>
     * <li>不是所有种类的的物品栏都遵循本值。
     * <li>若本值大于127，当世界保存时可能会被缩减。
     * <li>本值不保证被保存；一定要在设置一个格子的最大堆叠数之前修改本值
     * <li>若本值大于这种物品栏默认的大小，可能不会正确地在客户端上显示
     * </ul>
     * <p>
     * 原文:
     * This method allows you to change the maximum stack size for an
     * inventory.
     * <p>
     * <b>Caveats:</b>
     * <ul>
     * <li>Not all inventories respect this value.
     * <li>Stacks larger than 127 may be clipped when the world is saved.
     * <li>This value is not guaranteed to be preserved; be sure to set it
     *     before every time you want to set a slot over the max stack size.
     * <li>Stacks larger than the default max size for this type of inventory
     *     may not display correctly in the client.
     * </ul>
     *
     * @param size 最大物品堆叠数量
     */
    public void setMaxStackSize(int size);

    /**
     * 返回此物品栏的名字.
     * <p>
     * 原文:Returns the name of the inventory
     *
     * @return 物品栏名
     */
    public String getName();

    /**
     * 返回在指定索引的物品堆.
     * <p>
     * 原文:Returns the ItemStack found in the slot at the given index
     *
     * @param index 要查找的格子
     * @return 在此格子的物品堆
     */
    public ItemStack getItem(int index);

    /**
     * 在物品栏指定索引存放物品堆.
     * <p>
     * 原文:Stores the ItemStack at the given index of the inventory.
     *
     * @param index 在哪里存放这个物品堆
     * @param item 要设置的物品堆
     */
    public void setItem(int index, ItemStack item);

    /**
     * 在物品栏存放所给的物品堆.本方法将尽可能完美地尝试填充已有的但还未达到堆叠上限的物品堆
     * 和空格子.
     * <p>
     * 返回的HashMap包含不能存放的物品堆，键是你所给的参数的索引值，
     * 值是你所给的参数指定索引处的物品堆.如果所有物品都被存放，将返回一个空HashMap.
     * <p>
     * (以下翻译不保证准确性，自己试试呗)如果你传递的物品堆超过了物品的最大堆叠量,首先它们将被按
     * 最大堆叠量[Material.getMaxStackSize()]添加一部分.如果当没有部分的物品堆剩余时，
     * 物品堆将被以Inventory.getMaxStackSize()的数量分割，允许你超过那个物品的最大堆叠量.
     * <p>
     * 已知在一些实现里本方法也将会设置输入的argument amount to the number of that item not placed in
     * slots.
     * <p>
     * 原文:Stores the given ItemStacks in the inventory. This will try to fill
     * existing stacks and empty slots as well as it can.
     * <p>
     * The returned HashMap contains what it couldn't store, where the key is
     * the index of the parameter, and the value is the ItemStack at that
     * index of the varargs parameter. If all items are stored, it will return
     * an empty HashMap.
     * <p>
     * If you pass in ItemStacks which exceed the maximum stack size for the
     * Material, first they will be added to partial stacks where
     * Material.getMaxStackSize() is not exceeded, up to
     * Material.getMaxStackSize(). When there are no partial stacks left
     * stacks will be split on Inventory.getMaxStackSize() allowing you to
     * exceed the maximum stack size for that material.
     * <p>
     * It is known that in some implementations this method will also set
     * the inputted argument amount to the number of that item not placed in
     * slots.
     *
     * @param items 要存放的物品
     * @return 包含不能被存放的物品的HashMap
     * @throws IllegalArgumentException 如果items或在内的任何元素为null
     */
    public HashMap<Integer, ItemStack> addItem(ItemStack... items) throws IllegalArgumentException;

    /**
     * 移除在物品栏内的指定物品堆.
     * <p>
     * 本方法将按照你所给的物品堆的数量和种类作为参数尽可能多地移除物品堆.
     * <p>
     * 返回的HashMap包含不能移除的物品堆，map的键
     * 是你所给的参数的索引值，值是在你所给的参数指定索引处的物品堆.如果
     * 所给的物品堆全部被移除，将返回一个空HashMap.
     * <p>
     * 原文:Removes the given ItemStacks from the inventory.
     * <p>
     * It will try to remove 'as much as possible' from the types and amounts
     * you give as arguments.
     * <p>
     * The returned HashMap contains what it couldn't remove, where the key is
     * the index of the parameter, and the value is the ItemStack at that
     * index of the varargs parameter. If all the given ItemStacks are
     * removed, it will return an empty HashMap.
     * <p>
     * It is known that in some implementations this method will also set the
     * inputted argument amount to the number of that item not removed from
     * slots.
     *
     * @param items 要移除的物品堆
     * @return 包含不能被移除的物品堆的HashMap
     * @throws IllegalArgumentException 如果items为null
     */
    public HashMap<Integer, ItemStack> removeItem(ItemStack... items) throws IllegalArgumentException;

    /**
     * 返回这个物品栏内的所有物品堆.
     * <p>
     * 原文:Returns all ItemStacks from the inventory
     *
     * @return 存储了此物品栏所有物品的数组
     */
    public ItemStack[] getContents();

    /**
     * 完全地覆盖物品栏的内容.移除所有存在的内容并替换为指定的物品堆.
     * <p>
     * 原文:Completely replaces the inventory's contents. Removes all existing
     * contents and replaces it with the ItemStacks given in the array.
     *
     * @param items 内容的完全替换;数组长度必须小于或等于{@link #getSize()}.
     * @throws IllegalArgumentException 如果数组容量超越了物品栏的容量
     */
    public void setContents(ItemStack[] items) throws IllegalArgumentException;

    /**
     * 返回.大部分情况下本方法返回的内容代表整个物品栏，
     * 但某些情况下返回的内容可能不包括盔甲或格子.
     * <br>
     * 这些内容会被用于add/contains/remove方法查找指定的物品堆.
     * <p>
     * 原文:Return the contents from the section of the inventory where items can
     * reasonably be expected to be stored. In most cases this will represent
     * the entire inventory, but in some cases it may exclude armor or result
     * slots.
     * <br>
     * It is these contents which will be used for add / contains / remove
     * methods which look for a specific stack.
     *
     * @return 物品栏存放的物品堆
     */
    public ItemStack[] getStorageContents();

    /**
     * 放置所给的物品堆至物品栏.
     * <p>
     * 原文:Put the given ItemStacks into the storage slots
     *
     * @param items 作为物品栏内容的物品堆
     * @throws IllegalArgumentException 如果数组容量超越了物品栏的容量
     */
    public void setStorageContents(ItemStack[] items) throws IllegalArgumentException;

    /**
     * 检测这个物品栏是否含有指定的物品.
     * <p>
     * 原文:Checks if the inventory contains any ItemStacks with the given
     * material.
     *
     * @param material 要检测的物品
     * @return 是否含有此物品
     * @throws IllegalArgumentException 如果material为null
     */
    public boolean contains(Material material) throws IllegalArgumentException;

    /**
     * 检测这个物品栏是否含有与给定的物品堆匹配的物品堆.
     * <p>
     * 当物品堆的种类和数量都匹配时才返回true.
     * <p>
     * 原文:Checks if the inventory contains any ItemStacks matching the given
     * ItemStack.
     * <p>
     * This will only return true if both the type and the amount of the stack
     * match.
     *
     * @param item 要匹配的物品堆
     * @return 如果item为null返回false，如果有完全匹配的物品堆找到返回true
     */
    public boolean contains(ItemStack item);

    /**
     * 检查物品栏内是否包含指定的物品，并检查物品堆的数量是否足够(译者自述).
     * <p>
     * 原文:Checks if the inventory contains any ItemStacks with the given
     * material, adding to at least the minimum amount specified.
     *
     * @param material 要检测的物品
     * @param amount 物品堆数量最小值
     * @return 如果参数amount小于1返回true;如果物品堆的数量小于等于参数amount返回true(自述)
     * @throws IllegalArgumentException 如果material为null
     */
    public boolean contains(Material material, int amount) throws IllegalArgumentException;

    /**
     * 检测物品栏是否含有一定数量的完全匹配的物品堆.
     * <p>
     * 如果物品堆的种类和数量都匹配时才会计数.
     * <p>
     * 原文:Checks if the inventory contains at least the minimum amount specified
     * of exactly matching ItemStacks.
     * <p>
     * An ItemStack only counts if both the type and the amount of the stack
     * match.
     *
     * @param item 要匹配的物品
     * @param amount 要检查多少相同的物品堆
     * @return item为null返回false;amount小于1返回true;如果完全匹配物品堆指定次数返回true
     * @see #containsAtLeast(ItemStack, int)
     */
    public boolean contains(ItemStack item, int amount);

    /**
     * 检测物品栏是否含有与所给物品堆匹配的并数量足够的物品堆.
     * <p>
     * 原文:Checks if the inventory contains ItemStacks matching the given
     * ItemStack whose amounts sum to at least the minimum amount specified.
     *
     * @param item 要匹配的物品堆
     * @param amount 物品堆数量最小值
     * @return item为null返回false;amount小于1返回true;如果物品堆的数量小于等于参数amount返回true
     */
    public boolean containsAtLeast(ItemStack item, int amount);

    /**
     * 查找在物品栏内的包含指定物品的所有格子与物品堆.
     * <p>
     * 返回的HashMap的键是格子的索引，值是在那个格子的物品堆.如果
     * 没有找到指定的物品，将返回一个空map.
     * <p>
     * 原文:Returns a HashMap with all slots and ItemStacks in the inventory with
     * the given Material.
     * <p>
     * The HashMap contains entries where, the key is the slot index, and the
     * value is the ItemStack in that slot. If no matching ItemStack with the
     * given Material is found, an empty map is returned.
     *
     * @param material 要查找的物品
     * @return 包含格子索引和对应物品堆的map
     * @throws IllegalArgumentException 如果material为null
     */
    public HashMap<Integer, ? extends ItemStack> all(Material material) throws IllegalArgumentException;

    /**
     * 查找在物品栏内的包含指定物品堆的所有格子与物品堆.只有
     * 物品堆的数目和种类都相同时才会匹配.
     * <p>
     * 返回的HashMap的键是格子的索引，值是在那个格子的物品堆.如果
     * 没有找到指定的物品堆，将返回一个空map.
     * <p>
     * 原文:Finds all slots in the inventory containing any ItemStacks with the
     * given ItemStack. This will only match slots if both the type and the
     * amount of the stack match
     * <p>
     * The HashMap contains entries where, the key is the slot index, and the
     * value is the ItemStack in that slot. If no matching ItemStack with the
     * given Material is found, an empty map is returned.
     *
     * @param item 要查找的物品堆
     * @return 包含格子索引和对应物品堆的map
     */
    public HashMap<Integer, ? extends ItemStack> all(ItemStack item);

    /**
     * 查找包含此物品的第一个格子.
     * <p>
     * 原文:Finds the first slot in the inventory containing an ItemStack with the
     * given material
     *
     * @param material 要查找的物品
     * @return 包含此物品的格子序号
     * @throws IllegalArgumentException 如果material为null
     */
    public int first(Material material) throws IllegalArgumentException;

    /**
     * 查找包含此物品堆的第一个格子。若物品堆的种类和数量都匹配才会匹配对应格子.
     * <p>
     * 原文:Returns the first slot in the inventory containing an ItemStack with
     * the given stack. This will only match a slot if both the type and the
     * amount of the stack match
     *
     * @param item 要匹配的物品堆
     * @return 给定物品堆所在的格子序号，如果未找到返回-1
     */
    public int first(ItemStack item);

    /**
     * 返回第一个空格子的格子数.
     * <p>
     * 原文:
     * Returns the first empty Slot.
     *
     * @return 第一个空格子的格子数，-1就没有空格子
     */
    public int firstEmpty();

    /**
     * 移除在物品栏内与给定物品匹配的所有物品堆.
     * <p>
     * 原文:Removes all stacks in the inventory matching the given material.
     *
     * @param material 要移除的物品
     * @throws IllegalArgumentException 若material为null
     */
    public void remove(Material material) throws IllegalArgumentException;

    /**
     * 移除在此物品栏内与给定物品堆匹配的所有物品堆.
     * <p>
     * 只有物品堆的种类和数目相应匹配时对应的格子才会被匹配.
     * <p>
     * 原文:Removes all stacks in the inventory matching the given stack.
     * <p>
     * This will only match a slot if both the type and the amount of the
     * stack match
     *
     * @param item 想要移除的物品堆
     */
    public void remove(ItemStack item);

    /**
     * 清除单个格子.
     * <p>
     * 原文:Clears out a particular slot in the index.
     *
     * @param index 格子索引
     */
    public void clear(int index);

    /**
     * 清除整个物品栏.
     * <p>
     * 原文:Clears out the whole Inventory.
     */
    public void clear();

    /**
     * 获得正在查看此物品栏的玩家. (以下翻译仅供参考，不保证准确性)注意:玩家被认为是在查看他们自己的物品栏
     * 和合成屏幕甚至当所说的物品栏没有打开.他们将通常被考虑为查看他们
     * 的物品栏甚至当他们打开了不同的物品栏，但对自定义物品栏来说有可能排除查看者
     * 的物品栏，所以返回的内容应该从不被呈现为非空(？？？).
     * <p>
     * 原文:Gets a list of players viewing the inventory. Note that a player is
     * considered to be viewing their own inventory and internal crafting
     * screen even when said inventory is not open. They will normally be
     * considered to be viewing their inventory even when they have a
     * different inventory screen open, but it's possible for customized
     * inventory screens to exclude the viewer's inventory, so this should
     * never be assumed to be non-empty.
     *
     * @return 正在查看此物品栏的HumanEntities列表
     */
    public List<HumanEntity> getViewers();

    /**
     * 返回此物品栏的标题.
     * <p>
     * 原文:Returns the title of this inventory.
     *
     * @return 物品栏的标题
     */
    public String getTitle();

    /**
     * 返回这个物品栏的种类.
     * <p>
     * 原文:Returns what type of inventory this is.
     *
     * @return 物品栏的种类
     */
    public InventoryType getType();

    /**
     * 获得此物品栏的持有者(方块或实体).
     * <p>
     * 原文:Gets the block or entity belonging to the open inventory
     *
     * @return 物品栏的持有者;null表示没有归属者
     */
    public InventoryHolder getHolder();

    @Override
    public ListIterator<ItemStack> iterator();

    /**
     * 返回一个从指定索引开始的迭代器. 如果此索引是正数,
     * 那么第一次对next()的调用将返回处在那个索引的物品;
     * 如果索引值为负的,那么第一次对next()的调用将返回
     * 处在索引值(getSize() + index)的物品.
     * <p>
     * 原文:Returns an iterator starting at the given index. If the index is
     * positive, then the first call to next() will return the item at that
     * index; if it is negative, the first call to previous will return the
     * item at index (getSize() + index).
     *
     * @param index 索引值
     * @return 迭代器
     */
    public ListIterator<ItemStack> iterator(int index);

    /**
     * 获得对应于此物品栏的方块或实体的位置. 若此容器是被定制创建的或是一个虚拟的容器/子容器时可能返回null.
     * <p>
     * 原文:Get the location of the block or entity which corresponds to this inventory. May return null if this container
     * was custom created or is a virtual / subcontainer.
     *
     * @return 对应位置，若返回null表示此属性不适用
     */
    public Location getLocation();
}
