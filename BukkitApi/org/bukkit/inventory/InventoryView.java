package org.bukkit.inventory;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;

/**
 * 代表连接两个物品栏(从UI上理解即为上下各一个)与单个玩家
 * (其物品栏可能也可能不是视图代表的两个物品栏之一)的背包视图.
 * <p>
 * 注意: 如果你实现了这个接口却未能满足方法的约定 (未能完全实现既定的功能), 将不保证游戏能正常工作.
 * <p>
 * 原文:Represents a view linking two inventories and a single player (whose
 * inventory may or may not be one of the two).
 * <p>
 * Note: If you implement this interface but fail to satisfy the expected
 * contracts of certain methods, there's no guarantee that the game will work
 * as it should.
 */
public abstract class InventoryView {
    public final static int OUTSIDE = -999;
    /**
     * 代表物品栏窗口视图的一些额外属性.
     */
    public enum Property {
        /**
         * 酿造台燃烧进度.
         */
        BREW_TIME(0, InventoryType.BREWING),
        /**
         * 熔炉燃料已燃烧多久 (仅计算单个燃料).
         */
        BURN_TIME(0, InventoryType.FURNACE),
        /**
         * 当前正燃烧的燃料还可以燃烧多久 (时间以tick为单位, 仅计算单个燃料).
         */
        TICKS_FOR_CURRENT_FUEL(1, InventoryType.FURNACE),
        /**
         * 熔炉成品(通常是食物)的烧炼进度.
         */
        COOK_TIME(2, InventoryType.FURNACE),
        /**
         * 熔炉剩余燃料还可以燃烧多久.
         */
        TICKS_FOR_CURRENT_SMELTING(3, InventoryType.FURNACE),
        /**
         * In an enchanting inventory, the top button's experience level
         * value.
         */
        ENCHANT_BUTTON1(0, InventoryType.ENCHANTING),
        /**
         * In an enchanting inventory, the middle button's experience level
         * value.
         */
        ENCHANT_BUTTON2(1, InventoryType.ENCHANTING),
        /**
         * In an enchanting inventory, the bottom button's experience level
         * value.
         */
        ENCHANT_BUTTON3(2, InventoryType.ENCHANTING),
        /**
         * In an enchanting inventory, the first four bits of the player's xpSeed.
         */
        ENCHANT_XP_SEED(3, InventoryType.ENCHANTING),
        /**
         * In an enchanting inventory, the top button's enchantment's id
         */
        ENCHANT_ID1(4, InventoryType.ENCHANTING),
        /**
         * In an enchanting inventory, the middle button's enchantment's id
         */
        ENCHANT_ID2(5, InventoryType.ENCHANTING),
        /**
         * In an enchanting inventory, the bottom button's enchantment's id
         */
        ENCHANT_ID3(6, InventoryType.ENCHANTING),
        /**
         * In an enchanting inventory, the top button's level value.
         */
        ENCHANT_LEVEL1(7, InventoryType.ENCHANTING),
        /**
         * In an enchanting inventory, the middle button's level value.
         */
        ENCHANT_LEVEL2(8, InventoryType.ENCHANTING),
        /**
         * In an enchanting inventory, the bottom button's level value.
         */
        ENCHANT_LEVEL3(9, InventoryType.ENCHANTING),
        /**
         * 信标等级(信标总共有 4 个等级).
         */
        LEVELS(0, InventoryType.BEACON),
        /**
         * 信标第一增益效果(药水效果).
         */
        PRIMARY_EFFECT(1, InventoryType.BEACON),
        /**
         * 信标第二增益效果(药水效果).
         */
        SECONDARY_EFFECT(2, InventoryType.BEACON),
        /**
         * 修理装备需花费的经验.
         */
        REPAIR_COST(0, InventoryType.ANVIL);
        int id;
        InventoryType style;
        private Property(int id, InventoryType appliesTo) {
            this.id = id;
            style = appliesTo;
        }

        public InventoryType getType() {
            return style;
        }

        /**
         *
         * @return 此窗口视图的id
         * @deprecated 不安全的参数
         */
        @Deprecated
        public int getId() {
            return id;
        }
    }
    /**
     * 获取此窗口视图上方的物品栏.
     * <p>
     * 原文:Get the upper inventory involved in this transaction.
     *
     * @return 物品栏
     */
    public abstract Inventory getTopInventory();

    /**
     * 获取此窗口视图下方的物品栏 (通常是玩家背包).
     * <p>
     * 原文:Get the lower inventory involved in this transaction.
     *
     * @return 物品栏
     */
    public abstract Inventory getBottomInventory();

    /**
     * 获取正查看此窗口的玩家.
     * <p>
     * 原文:Get the player viewing.
     *
     * @return 玩家
     */
    public abstract HumanEntity getPlayer();

    /**
     * 判断该事件中物品栏的类型.
     * 这表示将被展示的窗口样式. 该方法永不会返回PLAYER值.
     * <p>
     * 原文:Determine the type of inventory involved in the transaction. This
     * indicates the window style being shown. It will never return PLAYER,
     * since that is common to all windows.
     *
     * @return 物品栏类型
     */
    public abstract InventoryType getType();

    /**
     * 设置该物品栏指定槽位的物品.
     * <p>
     * 注意: 如果id是 -999, 那么该物品将被扔在地面上. 然而, 这不是必须的行为.
     * (所以你还是通过常规方法扔物品, 毕竟写个-999不看文档的人谁看得懂呢...233).
     * <p>
     * 原文:Sets one item in this inventory view by its raw slot ID.
     * <p>
     * Note: If slot ID -999 is chosen, it may be expected that the item is
     * dropped on the ground. This is not required behaviour, however.
     *
     * @param slot 槽位id (可以通过InventoryClickEvent.getRawSlot()获取)
     * @param item 要放置的物品, null则清除
     */
    public void setItem(int slot, ItemStack item) {
        if (slot != OUTSIDE) {
            if (slot < getTopInventory().getSize()) {
                getTopInventory().setItem(convertSlot(slot), item);
            } else {
                getBottomInventory().setItem(convertSlot(slot), item);
            }
        } else {
            getPlayer().getWorld().dropItemNaturally(getPlayer().getLocation(), item);
        }
    }

    /**
     * 获取该物品栏指定槽位的物品.
     * <p>
     * 原文:Gets one item in this inventory view by its raw slot ID.
     *
     * @param slot 槽位id (可以通过InventoryClickEvent.getRawSlot()获取)
     * @return 该槽位内的物品
     */
    public ItemStack getItem(int slot) {
        if (slot == OUTSIDE) {
            return null;
        }
        if (slot < getTopInventory().getSize()) {
            return getTopInventory().getItem(convertSlot(slot));
        } else {
            return getBottomInventory().getItem(convertSlot(slot));
        }
    }

    /**
     * 设置玩家客户端鼠标光标所指位置上的物品.
     * <p>
     * 原文:Sets the item on the cursor of one of the viewing players.
     *
     * @param item 要放置的物品, null则清除
     */
    public final void setCursor(ItemStack item) {
        getPlayer().setItemOnCursor(item);
    }

    /**
     * 获取玩家客户端鼠标光标所指位置上的物品.
     * <p>
     * 原文:Get the item on the cursor of one of the viewing players.
     *
     * @return 光标所指物品, 如果所指槽位为空返回null
     */
    public final ItemStack getCursor() {
        return getPlayer().getItemOnCursor();
    }

    /**
     * 将原始槽位id转换为本地槽位id (本地槽位id适用于当前正在查看的两个物品栏).
     * <p>
     * 若原始槽位id指向窗口的上半部分的物品栏, 那么返回的值不变, 此时返回值适用于getTopInventory().getItem();
     * 若该id指向底部物品栏, 返回的值将与原始槽位id不同, 此时返回值适用于getBottomInventory().getItem().
     * <p>
     * 这是玩家背包的一个实例(来自代码注释):
     
     * <p>
     * 原文:Converts a raw slot ID into its local slot ID into whichever of the two
     * inventories the slot points to.
     * <p>
     * <pre>Raw Slots(原始槽位id):
     *
     * 5             1  2     0
     * 6             3  4
     * 7
     * 8           45
     * 9  10 11 12 13 14 15 16 17
     * 18 19 20 21 22 23 24 25 26
     * 27 28 29 30 31 32 33 34 35
     * 36 37 38 39 40 41 42 43 44
     *
     * 转换后:
     *
     * 39             1  2     0
     * 38             3  4
     * 37
     * 36          40
     * 9  10 11 12 13 14 15 16 17
     * 18 19 20 21 22 23 24 25 26
     * 27 28 29 30 31 32 33 34 35
     * 0  1  2  3  4  5  6  7  8</pre>
     * <p>
     * 原文:If the raw slot refers to the upper inventory, it will be returned
     * unchanged and thus be suitable for getTopInventory().getItem(); if it
     * refers to the lower inventory, the output will differ from the input
     * and be suitable for getBottomInventory().getItem().
     *
     * @param rawSlot 原始槽位id
     * @return 转换后的槽位id
     */
    public final int convertSlot(int rawSlot) {
        int numInTop = getTopInventory().getSize();
        // Index from the top inventory as having slots from [0,size]
        if (rawSlot < numInTop) {
            return rawSlot;
        }

        // Move down the slot index by the top size
        int slot = rawSlot - numInTop;

        // Player crafting slots are indexed differently. The matrix is caught by the first return.
        // Creative mode is the same, except that you can't see the crafting slots (but the IDs are still used)
        if (getType() == InventoryType.CRAFTING || getType() == InventoryType.CREATIVE) {
            /**
             * Raw Slots:
             *
             * 5             1  2     0
             * 6             3  4
             * 7
             * 8           45
             * 9  10 11 12 13 14 15 16 17
             * 18 19 20 21 22 23 24 25 26
             * 27 28 29 30 31 32 33 34 35
             * 36 37 38 39 40 41 42 43 44
             */

            /**
             * Converted Slots:
             *
             * 39             1  2     0
             * 38             3  4
             * 37
             * 36          40
             * 9  10 11 12 13 14 15 16 17
             * 18 19 20 21 22 23 24 25 26
             * 27 28 29 30 31 32 33 34 35
             * 0  1  2  3  4  5  6  7  8
             */

            if (slot < 4) {
                // Send [5,8] to [39,36]
                return 39 - slot;
            } else if (slot > 39) {
                // Slot lives in the extra slot section
                return slot;
            } else {
                // Reset index so 9 -> 0
                slot -= 4;
            }
        }

        // 27 = 36 - 9
        if (slot >= 27) {
            // Put into hotbar section
            slot -= 27;
        } else {
            // Take out of hotbar section
            // 9 = 36 - 27
            slot += 9;
        }

        return slot;
    }

    /**
     * 关闭该窗口视图.
     * <p>
     * 原文:Closes the inventory view.
     */
    public final void close() {
        getPlayer().closeInventory();
    }

    /**
     * Check the total number of slots in this view, combining the upper and
     * lower inventories.
     * <p>
     * Note though that it's possible for this to be greater than the sum of
     * the two inventories if for example some slots are not being used.
     *
     * @return The total size
     */
    public final int countSlots() {
        return getTopInventory().getSize() + getBottomInventory().getSize();
    }

    /**
     * Sets an extra property of this inventory if supported by that
     * inventory, for example the state of a progress bar.
     *
     * @param prop the window property to update
     * @param value the new value for the window property
     * @return true if the property was updated successfully, false if the
     *     property is not supported by that inventory
     */
    public final boolean setProperty(Property prop, int value) {
        return getPlayer().setWindowProperty(prop, value);
    }

    /**
     * 获取物品栏窗口的标题.
     * <p>
     * 原文:Get the title of this inventory window.
     *
     * @return 标题
     */
    public final String getTitle() {
        return getTopInventory().getTitle();
    }
}
