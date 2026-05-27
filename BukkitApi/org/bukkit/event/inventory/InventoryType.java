package org.bukkit.event.inventory;

import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.MenuType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 表示 Bukkit 中可用的不同类型的物品栏。
 * <br>
 * 只有标记为 {@link #isCreatable()} 的 InventoryType 才能被创建。
 * <br>
 * 当前无法通过 {@link org.bukkit.Bukkit#createInventory} 创建的物品栏列表是：<br>
 * <blockquote>
 *     {@link InventoryType#CREATIVE}、{@link InventoryType#CRAFTING} 和
 *     {@link InventoryType#MERCHANT}
 * </blockquote>
 *
 * 有关更多信息，请参阅 {@link org.bukkit.Bukkit#createInventory}。
 *
 * @see org.bukkit.Bukkit#createInventory(InventoryHolder, InventoryType)
 */
public enum InventoryType {

    /**
     * 箱子物品栏，具有 0、9、18、27、36、45 或 54 个 CONTAINER 类型的槽位。
     */
    CHEST(27, "Chest", MenuType.GENERIC_9X3),
    /**
     * 发射器物品栏，具有 9 个 CONTAINER 类型的槽位。
     */
    DISPENSER(9, "Dispenser", MenuType.GENERIC_3X3),
    /**
     * 投掷器物品栏，具有 9 个 CONTAINER 类型的槽位。
     */
    DROPPER(9, "Dropper", MenuType.GENERIC_3X3),
    /**
     * 熔炉物品栏，具有一个 RESULT 槽位、一个 CRAFTING 槽位和一个 FUEL 槽位。
     */
    FURNACE(3, "Furnace", MenuType.FURNACE),
    /**
     * 工作台物品栏，具有 9 个 CRAFTING 槽位和一个 RESULT 槽位。
     */
    WORKBENCH(10, "Crafting", MenuType.CRAFTING),
    /**
     * 玩家的合成物品栏，具有 4 个 CRAFTING 槽位和一个 RESULT 槽位。同时意味着 4 个 ARMOR 槽位是可访问的。
     */
    CRAFTING(5, "Crafting", null, false),
    /**
     * 附魔台物品栏，具有两个 CRAFTING 槽位和三个附魔按钮。
     */
    ENCHANTING(2, "Enchanting", MenuType.ENCHANTMENT),
    /**
     * 酿造台物品栏，具有一个 FUEL 槽位和四个 CRAFTING 槽位。
     */
    BREWING(5, "Brewing", MenuType.BREWING_STAND),
    /**
     * 玩家的物品栏，具有 9 个 QUICKBAR 槽位、27 个 CONTAINER 槽位、4 个 ARMOR 槽位和 1 个副手槽位。但 ARMOR 和副手槽位可能对玩家不可见。
     */
    PLAYER(41, "Player", MenuType.GENERIC_9X4),
    /**
     * 创造模式物品栏，只有 9 个 QUICKBAR 槽位，没有其他。（实际的创造界面物品是客户端的，无法由服务器更改。）
     */
    CREATIVE(9, "Creative", null, false),
    /**
     * 商人物品栏，具有 2 个 CRAFTING 槽位和 1 个 RESULT 槽位。
     */
    MERCHANT(3, "Villager", MenuType.MERCHANT, false),
    /**
     * 末影箱物品栏，具有 27 个槽位。
     */
    ENDER_CHEST(27, "Ender Chest", MenuType.GENERIC_9X3),
    /**
     * 铁砧物品栏，具有 2 个 CRAFTING 槽位和 1 个 RESULT 槽位
     */
    ANVIL(3, "Repairing", MenuType.ANVIL),
    /**
     * 锻造台物品栏，具有 3 个 CRAFTING 槽位和 1 个 RESULT 槽位。
     */
    SMITHING(4, "Upgrade Gear", MenuType.SMITHING),
    /**
     * 信标物品栏，具有 1 个 CRAFTING 槽位
     */
    BEACON(1, "container.beacon", MenuType.BEACON),
    /**
     * 漏斗物品栏，具有 5 个 CONTAINER 类型的槽位。
     */
    HOPPER(5, "Item Hopper", MenuType.HOPPER),
    /**
     * 潜影盒物品栏，具有 27 个 CONTAINER 类型的槽位。
     */
    SHULKER_BOX(27, "Shulker Box", MenuType.SHULKER_BOX),
    /**
     * 桶物品栏，具有 27 个 CONTAINER 类型的槽位。
     */
    BARREL(27, "Barrel", MenuType.GENERIC_9X3),
    /**
     * 高炉物品栏，具有一个 RESULT 槽位、一个 CRAFTING 槽位和一个 FUEL 槽位。
     */
    BLAST_FURNACE(3, "Blast Furnace", MenuType.BLAST_FURNACE),
    /**
     * 讲台物品栏，具有 1 个 BOOK 槽位。
     */
    LECTERN(1, "Lectern", MenuType.LECTERN),
    /**
     * 烟熏炉物品栏，具有一个 RESULT 槽位、一个 CRAFTING 槽位和一个 FUEL 槽位。
     */
    SMOKER(3, "Smoker", MenuType.SMOKER),
    /**
     * 织布机物品栏，具有 3 个 CRAFTING 槽位和 1 个 RESULT 槽位。
     */
    LOOM(4, "Loom", MenuType.LOOM),
    /**
     * 制图台物品栏，具有 2 个 CRAFTING 槽位和 1 个 RESULT 槽位。
     */
    CARTOGRAPHY(3, "Cartography Table", MenuType.CARTOGRAPHY_TABLE),
    /**
     * 砂轮物品栏，具有 2 个 CRAFTING 槽位和 1 个 RESULT 槽位。
     */
    GRINDSTONE(3, "Repair & Disenchant", MenuType.GRINDSTONE),
    /**
     * 切石机物品栏，具有 1 个 CRAFTING 槽位和 1 个 RESULT 槽位。
     */
    STONECUTTER(2, "Stonecutter", MenuType.STONECUTTER),
    /**
     * 伪堆肥桶物品栏，具有 0 或 1 个未定义类型的槽位。
     */
    COMPOSTER(1, "Composter", null, false),
    /**
     * 伪雕刻书架物品栏，具有 6 个未定义类型的槽位。
     */
    CHISELED_BOOKSHELF(6, "Chiseled Bookshelf", null, false),
    /**
     * 伪唱片机物品栏，具有 1 个未定义类型的槽位。
     */
    JUKEBOX(1, "Jukebox", null, false),
    /**
     * 伪装饰罐物品栏，具有 1 个未定义类型的槽位。
     */
    DECORATED_POT(1, "Decorated Pot", null, false),
    /**
     * 合成器物品栏，具有 9 个 CRAFTING 槽位。
     */
    CRAFTER(9, "Crafter", MenuType.CRAFTER_3X3),
    /**
     * 新的锻造台物品栏，具有 3 个 CRAFTING 槽位和 1 个 RESULT 槽位。
     *
     * @deprecated use {@link #SMITHING}
     */
    @Deprecated(since = "1.20.1")
    SMITHING_NEW(4, "Upgrade Gear", MenuType.SMITHING),
    ;

    private final int size;
    private final String title;
    private final MenuType menuType;
    private final boolean isCreatable;

    private InventoryType(int defaultSize, /*@NotNull*/ String defaultTitle, @Nullable MenuType type) {
        this(defaultSize, defaultTitle, type, true);
    }

    private InventoryType(int defaultSize, /*@NotNull*/ String defaultTitle, @Nullable MenuType type, boolean isCreatable) {
        size = defaultSize;
        title = defaultTitle;
        this.menuType = type;
        this.isCreatable = isCreatable;
    }

    public int getDefaultSize() {
        return size;
    }

    @NotNull
    public String getDefaultTitle() {
        return title;
    }

    /**
     * 获取此 InventoryType 对应的 {@link MenuType}。
     * <p>
     * 并非所有 InventoryType 都对应一个 {@link MenuType}。这些 InventoryType 也是不可创建的。如果此方法返回 null，则 {@link #isCreatable()} 将返回 false，但 {@link #MERCHANT} 除外。
     * <p>
     * 除了不一定对应一个 {@link MenuType} 外，一些 InventoryType 对应相同的 {@link MenuType}，包括：
     * <ul>
     * <li>Dropper、Dispenser
     * <li>ShulkerBox、Barrel、Chest
     * </ul>
     *
     * @return 对应的 {@link MenuType}
     * <p>原文：Gets the corresponding {@link MenuType} of this InventoryType.
     * <p>
     * Not all InventoryType correspond to a {@link MenuType}. These
     * InventoryTypes are also not creatable. If this method returns null,
     * {@link #isCreatable()} will return false, with the exception of
     * {@link #MERCHANT}.
     * <p>
     * As well as not necessarily corresponding to a {@link MenuType} some
     * InventoryType correspond to the same {@link MenuType}, including:
     * <ul>
     * <li>Dropper, Dispenser
     * <li>ShulkerBox, Barrel, Chest
     * </ul>
     */
    @Nullable
    public MenuType getMenuType() {
        return menuType;
    }

    /**
     * 表示此 InventoryType 可以通过正常的 {@link org.bukkit.Bukkit#createInventory} 方法创建。
     *
     * @return 此 InventoryType 是否可以被创建并展示给玩家
     * <p>原文：Denotes that this InventoryType can be created via the normal
     * {@link org.bukkit.Bukkit#createInventory} methods.
     */
    public boolean isCreatable() {
        return isCreatable;
    }

    public enum SlotType {
        /**
         * 熔炉或合成物品栏中的结果槽位。
         */
        RESULT,
        /**
         * 合成矩阵中的槽位，或'输入'槽位。
         */
        CRAFTING,
        /**
         * 玩家物品栏中的盔甲槽位。
         */
        ARMOR,
        /**
         * 容器或玩家物品栏中的常规槽位；任何其他枚举值未涵盖的内容。
         */
        CONTAINER,
        /**
         * 底部行或快捷栏中的槽位。
         */
        QUICKBAR,
        /**
         * 代表物品栏窗口外部区域的伪槽位。
         */
        OUTSIDE,
        /**
         * 熔炉物品栏中的燃料槽位，或酿造台物品栏中的材料槽位。
         */
        FUEL;
    }
}
