package org.bukkit.event.inventory;

public enum InventoryType {

    /**
     * 有0、9、18、27、36、45、54个槽的箱子背包容器
     */
    CHEST(27,"Chest"),
    /**
     * 有9个槽的发射器背包容器
     */
    DISPENSER(9,"Dispenser"),
    /**
     * 有9个槽的投掷器背包容器
     */
    DROPPER(9, "Dropper"),
    /**
     * 有烧炼产物格子、一个被烧连物品格子和一个放燃料的格子的熔炉背包容器
     */
    FURNACE(3,"Furnace"),
    /**
     * 有9个合成物品槽和合成产物格子的工作台背包容器
     */
    WORKBENCH(10,"Crafting"),
    /**
     * 有4个合成物品槽和一个合成产物格子的玩家合成背包。
     * 同样可以访问四个盔甲格子
     */
    CRAFTING(5,"Crafting"),
    /**
     * 有两个合成槽和三个附魔选项按钮的附魔台背包
     */
    ENCHANTING(2,"Enchanting"),
    /**
     * 酿造台背包，有一个燃料槽、一个配方槽和三个药水槽
     */
    BREWING(5,"Brewing"),
    /**
     * A player's inventory, with 9 QUICKBAR slots, 27 CONTAINER slots, 4 ARMOR
     * slots and 1 offhand slot. The ARMOR and offhand slots may not be visible
     * to the player, though.
     */
    PLAYER(41,"Player"),
    /**
     * The creative mode inventory, with only 9 QUICKBAR slots and nothing
     * else. (The actual creative interface with the items is client-side and
     * cannot be altered by the server.)
     */
    CREATIVE(9,"Creative"),
    /**
     * 有两个交易物槽和一个结果槽的交易背包
     */
    MERCHANT(3,"Villager"),
    /**
     * 有27个槽的末影箱背包
     */
    ENDER_CHEST(27,"Ender Chest"),
    /**
     * 有两个合成槽和一个结果槽的铁砧背包
     */
    ANVIL(3, "Repairing"),
    /**
     * 有一个合成槽的信标背包
     */
    BEACON(1, "container.beacon"),
    /**
     * 有五个槽的漏斗背包容器
     */
    HOPPER(5, "Item Hopper"),
    /**
     * A shulker box inventory, with 27 slots of type CONTAINER.
     */
    SHULKER_BOX(27, "Shulker Box"),
    ;

    private final int size;
    private final String title;

    private InventoryType(int defaultSize, String defaultTitle) {
        size = defaultSize;
        title = defaultTitle;
    }

    public int getDefaultSize() {
        return size;
    }

    public String getDefaultTitle() {
        return title;
    }

    public enum SlotType {
        /**
         * 在熔炉或合成背包里的结果槽
         */
        RESULT,
        /**
         * A slot in the crafting matrix, or the input slot in a furnace
         * inventory, the potion slot in the brewing stand, or the enchanting
         * slot.
         */
        CRAFTING,
        /**
         * 在玩家背包里的盔甲槽
         */
        ARMOR,
        /**
         * A regular slot in the container or the player's inventory; anything
         * not covered by the other enum values.
         */
        CONTAINER,
        /**
         * A slot in the bottom row or quickbar.
         */
        QUICKBAR,
        /**
         * A pseudo-slot representing the area outside the inventory window.
         */
        OUTSIDE,
        /**
         * The fuel slot in a furnace inventory, or the ingredient slot in a
         * brewing stand inventory.
         */
        FUEL;
    }
}