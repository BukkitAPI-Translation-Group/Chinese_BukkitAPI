package org.bukkit.event.inventory;

public enum InventoryType {

    /**
     * 一个有0、9、18、27、36、45、54个格子的箱子背包容器
     */
    CHEST(27,"Chest"),
    /**
     * 一个有9个格子的发射器背包容器
     */
    DISPENSER(9,"Dispenser"),
    /**
     * 一个有9个格子的投掷器背包容器
     */
    DROPPER(9, "Dropper"),
    /**
     * 一个有烧炼产物格子、一个被烧连物品格子和一个放燃料的格子的熔炉背包容器
     */
    FURNACE(3,"Furnace"),
    /**
     * 一个有9个合成物品格子和合成产物格子的工作台背包容器
     */
    WORKBENCH(10,"Crafting"),
    /**
     * A player's crafting inventory, with 4 CRAFTING slots and a RESULT slot.
     * Also implies that the 4 ARMOR slots are accessible.
     */
    CRAFTING(5,"Crafting"),
    /**
     * An enchantment table inventory, with two CRAFTING slots and three
     * enchanting buttons.
     */
    ENCHANTING(2,"Enchanting"),
    /**
     * A brewing stand inventory, with one FUEL slot and three CRAFTING slots.
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
     * The merchant inventory, with 2 TRADE-IN slots, and 1 RESULT slot.
     */
    MERCHANT(3,"Villager"),
    /**
     * The ender chest inventory, with 27 slots.
     */
    ENDER_CHEST(27,"Ender Chest"),
    /**
     * An anvil inventory, with 2 CRAFTING slots and 1 RESULT slot
     */
    ANVIL(3, "Repairing"),
    /**
     * A beacon inventory, with 1 CRAFTING slot
     */
    BEACON(1, "container.beacon"),
    /**
     * A hopper inventory, with 5 slots of type CONTAINER.
     */
    HOPPER(5, "Item Hopper"),
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
         * A result slot in a furnace or crafting inventory.
         */
        RESULT,
        /**
         * A slot in the crafting matrix, or the input slot in a furnace
         * inventory, the potion slot in the brewing stand, or the enchanting
         * slot.
         */
        CRAFTING,
        /**
         * An armour slot in the player's inventory.
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