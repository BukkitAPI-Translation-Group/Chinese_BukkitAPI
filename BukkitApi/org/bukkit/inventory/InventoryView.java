package org.bukkit.inventory;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表连接两个物品栏(从UI上理解即为上下各一个)与单个玩家
 * (其物品栏可能也可能不是视图代表的两个物品栏之一)的背包视图.
 * <p>
 * 原文:Represents a view linking two inventories and a single player (whose
 * inventory may or may not be one of the two).
 */
public interface InventoryView {
    public static final int OUTSIDE = -999;
    /**
     * 代表物品栏窗口视图的一些额外属性.
     * @deprecated 请使用 {@link InventoryView} 及其子类
     */
    @Deprecated(forRemoval = true, since = "1.21")
    public enum Property {
        /**
         * 酿造台燃烧进度.
         */
        BREW_TIME(0, InventoryType.BREWING),
        /**
         * 酿造台燃料槽的进度.
         *
         * 取值范围为 0 到 20, 0 表示空, 20 表示满.
         * <p>
         * 原文：The progress of the fuel slot in a brewing inventory.
         *
         * This is a value between 0 and 20, with 0 making the bar empty, and 20
         * making the bar full.
         */
        FUEL_TIME(1, InventoryType.BREWING),
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
         * 附魔台中, 顶部按钮的经验等级值.
         * <p>
         * 原文：In an enchanting inventory, the top button's experience level
         * value.
         */
        ENCHANT_BUTTON1(0, InventoryType.ENCHANTING),
        /**
         * 附魔台中, 中间按钮的经验等级值.
         * <p>
         * 原文：In an enchanting inventory, the middle button's experience level
         * value.
         */
        ENCHANT_BUTTON2(1, InventoryType.ENCHANTING),
        /**
         * 附魔台中, 底部按钮的经验等级值.
         * <p>
         * 原文：In an enchanting inventory, the bottom button's experience level
         * value.
         */
        ENCHANT_BUTTON3(2, InventoryType.ENCHANTING),
        /**
         * 附魔台中, 玩家 xpSeed 的前四位.
         * <p>
         * 原文：In an enchanting inventory, the first four bits of the player's xpSeed.
         */
        ENCHANT_XP_SEED(3, InventoryType.ENCHANTING),
        /**
         * 附魔台中, 顶部按钮的附魔 ID.
         * <p>
         * 原文：In an enchanting inventory, the top button's enchantment's id
         */
        ENCHANT_ID1(4, InventoryType.ENCHANTING),
        /**
         * 附魔台中, 中间按钮的附魔 ID.
         * <p>
         * 原文：In an enchanting inventory, the middle button's enchantment's id
         */
        ENCHANT_ID2(5, InventoryType.ENCHANTING),
        /**
         * 附魔台中, 底部按钮的附魔 ID.
         * <p>
         * 原文：In an enchanting inventory, the bottom button's enchantment's id
         */
        ENCHANT_ID3(6, InventoryType.ENCHANTING),
        /**
         * 附魔台中, 顶部按钮的等级值.
         * <p>
         * 原文：In an enchanting inventory, the top button's level value.
         */
        ENCHANT_LEVEL1(7, InventoryType.ENCHANTING),
        /**
         * 附魔台中, 中间按钮的等级值.
         * <p>
         * 原文：In an enchanting inventory, the middle button's level value.
         */
        ENCHANT_LEVEL2(8, InventoryType.ENCHANTING),
        /**
         * 附魔台中, 底部按钮的等级值.
         * <p>
         * 原文：In an enchanting inventory, the bottom button's level value.
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
        REPAIR_COST(0, InventoryType.ANVIL),
        /**
         * 讲台当前打开的书页.
         * <p>
         * 原文：The lectern's current open book page
         */
        BOOK_PAGE(0, InventoryType.LECTERN);
        int id;
        InventoryType style;
        private Property(int id, /*@NotNull*/ InventoryType appliesTo) {
            this.id = id;
            style = appliesTo;
        }

        @NotNull
        public InventoryType getType() {
            return style;
        }

        /**
         * 获取此窗口视图的id.
         * <p>
         * 原文:Gets the id of this view.
         * @return 此窗口视图的id
         * @deprecated 不安全的参数
         */
        @Deprecated(since = "1.6.2")
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
    @NotNull
    public Inventory getTopInventory();

    /**
     * 获取此窗口视图下方的物品栏 (通常是玩家背包).
     * <p>
     * 原文:Get the lower inventory involved in this transaction.
     *
     * @return 物品栏
     */
    @NotNull
    public Inventory getBottomInventory();

    /**
     * 获取正查看此窗口的玩家.
     * <p>
     * 原文:Get the player viewing.
     *
     * @return 玩家
     */
    @NotNull
    public HumanEntity getPlayer();

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
    @NotNull
    public InventoryType getType();

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
    public void setItem(int slot, @Nullable ItemStack item);

    /**
     * 获取该物品栏指定槽位的物品.
     * <p>
     * 原文:Gets one item in this inventory view by its raw slot ID.
     *
     * @param slot 槽位id (可以通过InventoryClickEvent.getRawSlot()获取)
     * @return 该槽位内的物品
     */
    @Nullable
    public ItemStack getItem(int slot);

    /**
     * 设置玩家客户端鼠标光标所指位置上的物品.
     * <p>
     * 原文:Sets the item on the cursor of one of the viewing players.
     *
     * @param item 要放置的物品, null则清除
     */
    public void setCursor(@Nullable ItemStack item);

    /**
     * 获取玩家客户端鼠标光标所指位置上的物品.
     * <p>
     * 原文:Get the item on the cursor of one of the viewing players.
     *
     * @return 光标所指物品, 如果所指槽位为空返回null
     */
    @Nullable
    public ItemStack getCursor();

    /**
     * 获取与给定原始槽位 ID 对应的物品栏.
     *
     * 如果槽位 ID 是 {@link #OUTSIDE} 则返回 null, 否则对于非法和负数槽位 ID 的行为是未定义的.
     *
     * 可与 {@link #convertSlot(int)} 一起使用来直接索引底层物品栏.
     * <p>
     * 原文：Gets the inventory corresponding to the given raw slot ID.
     *
     * If the slot ID is {@link #OUTSIDE} null will be returned, otherwise
     * behaviour for illegal and negative slot IDs is undefined.
     *
     * May be used with {@link #convertSlot(int)} to directly index an
     * underlying inventory.
     *
     * @param rawSlot 原始槽位 ID
     * @return 对应的物品栏, 或 null
     */
    @Nullable
    public Inventory getInventory(int rawSlot);

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
    public int convertSlot(int rawSlot);

    /**
     * 根据原始槽位 ID 确定槽位的类型.
     * <p>
     * 如果槽位类型未知, 则返回 {@link InventoryType.SlotType#CONTAINER}.
     * <p>
     * 原文：Determine the type of the slot by its raw slot ID.
     * <p>
     * If the type of the slot is unknown, then
     * {@link InventoryType.SlotType#CONTAINER} will be returned.
     *
     * @param slot 原始槽位 ID
     * @return 槽位类型
     */
    @NotNull
    public InventoryType.SlotType getSlotType(int slot);

    /**
     * 关闭该窗口视图.
     * <p>
     * 原文:Closes the inventory view.
     */
    public void close();

    /**
     * 检查此视图中的总槽位数, 合并上方和下方物品栏.
     * <p>
     * 注意, 如果某些槽位未被使用, 此值可能大于两个物品栏的总和.
     * <p>
     * 原文：Check the total number of slots in this view, combining the upper and
     * lower inventories.
     * <p>
     * Note though that it's possible for this to be greater than the sum of
     * the two inventories if for example some slots are not being used.
     *
     * @return 总大小
     */
    public int countSlots();

    /**
     * 设置此物品栏的额外属性 (如果该物品栏支持), 例如进度条的状态.
     * <p>
     * 原文：Sets an extra property of this inventory if supported by that
     * inventory, for example the state of a progress bar.
     *
     * @param prop 要更新的窗口属性
     * @param value 窗口属性的新值
     * @return 如果属性更新成功则返回 true, 如果该物品栏不支持该属性则返回 false
     */
    public boolean setProperty(@NotNull Property prop, int value);

    /**
     * 获取物品栏窗口的标题.
     * <p>
     * 原文:Get the title of this inventory window.
     *
     * @return 标题
     */
    @NotNull
    public String getTitle();

    /**
     * 获取此物品栏窗口的原始标题 (在使用 {@link #setTitle(String)} 进行任何更改之前).
     * <p>
     * 原文：Get the original title of this inventory window, before any changes were
     * made using {@link #setTitle(String)}.
     *
     * @return 原始标题
     */
    @NotNull
    public String getOriginalTitle();

    /**
     * 设置此物品栏窗口的标题 (如果物品栏窗口支持).
     * <p>
     * 注意, 如果物品栏不支持可更改的标题 (即不是可创建的或由玩家查看的), 则此方法将抛出异常.
     * <p>
     * 原文：Sets the title of this inventory window to the specified title if the
     * inventory window supports it.
     * <p>
     * Note if the inventory does not support titles that can be changed (ie, it
     * is not creatable or viewed by a player), then this method will throw an
     * exception.
     *
     * @param title 新标题
     */
    public void setTitle(@NotNull String title);
}
