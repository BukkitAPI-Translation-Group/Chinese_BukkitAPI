package org.bukkit;

/**
 * 表示一项被服务器监测的统计数据。
 */
public enum Statistic {
    DAMAGE_DEALT,
    DAMAGE_TAKEN,
    DEATHS,
    MOB_KILLS,
    PLAYER_KILLS,
    FISH_CAUGHT,
    ANIMALS_BRED,
    TREASURE_FISHED,
    JUNK_FISHED,
    LEAVE_GAME,
    JUMP,
    DROP(Type.ITEM),
    PICKUP(Type.ITEM),
    PLAY_ONE_TICK,
    WALK_ONE_CM,
    SWIM_ONE_CM,
    FALL_ONE_CM,
    SNEAK_TIME,
    CLIMB_ONE_CM,
    FLY_ONE_CM,
    DIVE_ONE_CM,
    MINECART_ONE_CM,
    BOAT_ONE_CM,
    PIG_ONE_CM,
    HORSE_ONE_CM,
    SPRINT_ONE_CM,
    CROUCH_ONE_CM,
    AVIATE_ONE_CM,
    MINE_BLOCK(Type.BLOCK),
    USE_ITEM(Type.ITEM),
    BREAK_ITEM(Type.ITEM),
    CRAFT_ITEM(Type.ITEM),
    KILL_ENTITY(Type.ENTITY),
    ENTITY_KILLED_BY(Type.ENTITY),
    TIME_SINCE_DEATH,
    TALKED_TO_VILLAGER,
    TRADED_WITH_VILLAGER,
    CAKE_SLICES_EATEN,
    CAULDRON_FILLED,
    CAULDRON_USED,
    ARMOR_CLEANED,
    BANNER_CLEANED,
    BREWINGSTAND_INTERACTION,
    BEACON_INTERACTION,
    DROPPER_INSPECTED,
    HOPPER_INSPECTED,
    DISPENSER_INSPECTED,
    NOTEBLOCK_PLAYED,
    NOTEBLOCK_TUNED,
    FLOWER_POTTED,
    TRAPPED_CHEST_TRIGGERED,
    ENDERCHEST_OPENED,
    ITEM_ENCHANTED,
    RECORD_PLAYED,
    FURNACE_INTERACTION,
    CRAFTING_TABLE_INTERACTION,
    CHEST_OPENED,
    SLEEP_IN_BED;

    private final Type type;

    private Statistic() {
        this(Type.UNTYPED);
    }

    private Statistic(Type type) {
        this.type = type;
    }

    /**
     * 获取这项统计数据的类型。
     * <p>
     * 原文：
     * Gets the type of this statistic.
     *
     * @return 这项统计数据的类型
     */
    public Type getType() {
        return type;
    }

    /**
     * 检查是否为次级统计数据。
     * <p>
     * 一项次级统计数据同时存在于每个方块、物品或实体(取决于{@link #getType()})。
     * <p>
     * 这是个多余的方法，相当于检查<code>getType() != Type.UNTYPED</code>
     * 原文：
     * Checks if this is a substatistic.
     * <p>
     * A substatistic exists en masse for each block, item, or entitytype, depending on
     * {@link #getType()}.
     * <p>
     * This is a redundant method and equivalent to checking
     * <code>getType() != Type.UNTYPED</code>
     *
     * @return 如果为次级统计数据则返回true，否则返回false
     */
    public boolean isSubstatistic() {
        return type != Type.UNTYPED;
    }

    /**
     * 检查是否为一项用于处理方块的次级统计数据。
     * <p>
     * 这是个多余的方法，相当于检查<code>getType() == Type.BLOCK</code>
     * <p>
     * 原文:
     * Checks if this is a substatistic dealing with blocks.
     * <p>
     * This is a redundant method and equivalent to checking
     * <code>getType() == Type.BLOCK</code>
     *
     * @return 用于处理方块则返回true，否则返回false
     */
    public boolean isBlock() {
        return type == Type.BLOCK;
    }

    /**
     * 统计数据的类型。
     * <p>
     * 原文：
     * The type of statistic.
     *
     */
    public enum Type {
        /**
         * 这种类型的统计数据不需要限定符。
         */
        UNTYPED,

        /**
         * 这种类型的统计数据需要一个关于物品的限定符。
         */
        ITEM,

        /**
         * 这种类型的统计数据需要一个关于方块的限定符。
         */
        BLOCK,

        /**
         * 这种类型的统计数据需要一个关于实体的限定符。
         * <p>
         * 原文：
         * Statistics of this type require an EntityType qualifier.
         */
        ENTITY;
    }
}