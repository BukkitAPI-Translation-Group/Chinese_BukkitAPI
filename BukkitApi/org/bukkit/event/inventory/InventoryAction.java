package org.bukkit.event.inventory;

/**
 * 用于判断点击物品栏的动作结果. 
 */
public enum InventoryAction {
    
    /**
     * 这一次点击什么都不会发生. 
     * <p>
     * There may be cases where nothing will happen and this is value is not
     * provided, but it is guaranteed that this value is accurate when given.
     */
    NOTHING,
    /**
     * 所单击的格子的物品(<b>所有</b>)被移到光标上. 
     */
    PICKUP_ALL,
    /**
     * 所单击的格子的物品(<b>部分</b>)被移到光标上. 
     */
    PICKUP_SOME,
    /**
     * 所单击的格子的物品(<b>一半</b>)被移到光标上. 
     */
    PICKUP_HALF,
    /**
     * 所单击的格子的物品(<b>一个</b>)被移到光标上. 
     */
    PICKUP_ONE,
    /**
     * 光标上的物品(<b>所有</b>)被移到所单击的格子中. 
     */
    PLACE_ALL,
    /**
     * 光标上的物品(<b>部分</b>)被移到所单击的格子中(通常会提高到该物品的最大堆叠数量). 
     */
    PLACE_SOME,
    /**
     * 光标上的物品(<b>一个</b>)被移到所单击的格子中. 
     */
    PLACE_ONE,
    /**
     * 光标上的物品与所单击的格子中的物品相互交换. 
     */
    SWAP_WITH_CURSOR,
    /**
     * 丢弃光标上的物品(<b>所有</b>). 
     */
    DROP_ALL_CURSOR,
    /**
     * 丢弃光标上的物品(<b>一个</b>). 
     */
    DROP_ONE_CURSOR,
    /**
     * 丢弃所单击的格子中的物品(<b>所有</b>). 
     */
    DROP_ALL_SLOT,
    /**
     * 丢弃所单击的格子中的物品(<b>一个</b>). 
     */
    DROP_ONE_SLOT,
    /**
     * 将所单击的格子中的物品移动到对面的物品栏中去(如果有空位). 
     */
    MOVE_TO_OTHER_INVENTORY,
    /**
     * The clicked item is moved to the hotbar, and the item currently there is
     * re-added to the player's inventory. 
     */
    HOTBAR_MOVE_AND_READD,
    /**
     * The clicked slot and the picked hotbar slot are swapped. 
     */
    HOTBAR_SWAP,
    /**
     * 将所单击的物品按最大堆叠数量复制到光标上. 
     */
    CLONE_STACK,
    /**
     * 在物品栏中寻找完全相同的物品，并添加到光标上，直到达到{@link org.bukkit.Material#getMaxStackSize() 物品的最大堆叠数量}. 
     */
    COLLECT_TO_CURSOR,
    /**
     * 无法识别的{@link ClickType 点击类型}. 
     */
    UNKNOWN,
    ;
}
