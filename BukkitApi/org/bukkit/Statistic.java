package org.bukkit;

import java.util.Locale;
import org.jetbrains.annotations.NotNull;

/**
 * 表示被服务器监测的统计数据
 */
public enum Statistic implements Keyed {
    DAMAGE_DEALT,
    DAMAGE_TAKEN,
    DEATHS,
    MOB_KILLS,
    PLAYER_KILLS,
    FISH_CAUGHT,
    ANIMALS_BRED,
    LEAVE_GAME,
    JUMP,
    DROP_COUNT,
    DROP(Type.ITEM),
    PICKUP(Type.ITEM),
    /**
     * Name is misleading, actually records ticks played.
     */
    PLAY_ONE_MINUTE,
    TOTAL_WORLD_TIME,
    WALK_ONE_CM,
    WALK_ON_WATER_ONE_CM,
    FALL_ONE_CM,
    SNEAK_TIME,
    CLIMB_ONE_CM,
    FLY_ONE_CM,
    WALK_UNDER_WATER_ONE_CM,
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
    SLEEP_IN_BED,
    SHULKER_BOX_OPENED,
    TIME_SINCE_REST,
    SWIM_ONE_CM,
    DAMAGE_DEALT_ABSORBED,
    DAMAGE_DEALT_RESISTED,
    DAMAGE_BLOCKED_BY_SHIELD,
    DAMAGE_ABSORBED,
    DAMAGE_RESISTED,
    CLEAN_SHULKER_BOX,
    OPEN_BARREL,
    INTERACT_WITH_BLAST_FURNACE,
    INTERACT_WITH_SMOKER,
    INTERACT_WITH_LECTERN,
    INTERACT_WITH_CAMPFIRE,
    INTERACT_WITH_CARTOGRAPHY_TABLE,
    INTERACT_WITH_LOOM,
    INTERACT_WITH_STONECUTTER,
    BELL_RING,
    RAID_TRIGGER,
    RAID_WIN,
    INTERACT_WITH_ANVIL,
    INTERACT_WITH_GRINDSTONE,
    TARGET_HIT,
    INTERACT_WITH_SMITHING_TABLE,
    STRIDER_ONE_CM;

    private final Type type;
    private final NamespacedKey key;

    private Statistic() {
        this(Type.UNTYPED);
    }

    private Statistic(/*@NotNull*/ Type type) {
        this.type = type;
        this.key = NamespacedKey.minecraft(name().toLowerCase(Locale.ROOT));
    }

    /**
     * 获取这项统计数据的种类.
     * <p>
     * 原文：Gets the type of this statistic.
     *
     * @return 这项统计数据的种类
     */
    @NotNull
    public Type getType() {
        return type;
    }

    /**
     * 检查该数据是否为次级统计数据.
     * <p>
     * 一项次级统计数据同时存在于每个方块、物品或实体(取决于{@link #getType()}).
     * <p>
     * 这是个多余的方法，相当于检查<code>getType() != Type.UNTYPED</code>.
     * <p>
     * 原文：Checks if this is a substatistic.
     * <p>
     * A substatistic exists en masse for each block, item, or entitytype,
     * depending on {@link #getType()}.
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
     * 检查是否为一项用于处理方块的次级统计数据.
     * <p>
     * 这是个多余的方法，相当于检查<code>getType() == Type.BLOCK</code>.
     * <p>
     * 原文: Checks if this is a substatistic dealing with blocks.
     * <p>
     * This is a redundant method and equivalent to checking
     * <code>getType() == Type.BLOCK</code>
     *
     * @return 用于处理方块则返回true，否则返回false
     */
    public boolean isBlock() {
        return type == Type.BLOCK;
    }

    @NotNull
    @Override
    public NamespacedKey getKey() {
        return key;
    }

    /**
     * 统计数据的种类
     */
    public enum Type {
        /**
         * 无类型的统计数据（通用统计数据）
         */
        UNTYPED,
        /**
         * 与物品有关的统计数据
         */
        ITEM,
        /**
         * 与方块有关的统计数据
         */
        BLOCK,
        /**
         * 与实体有关的统计数据
         */
        ENTITY;
    }
}
