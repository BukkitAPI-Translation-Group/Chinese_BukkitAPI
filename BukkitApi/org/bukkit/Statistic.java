package org.bukkit;

/**
 * 表示一项被服务器监测的统计数据。润笔工作未完成
 */
public enum Statistic {
    /**
     * 造成伤害
     */
    DAMAGE_DEALT,
    /**
     * 收到伤害
     */
    DAMAGE_TAKEN,
    /**
     * 死亡次数
     */
    DEATHS,
    /**
     * 击杀数(怪物)
     */
    MOB_KILLS,
    /**
     * 击杀数(玩家)
     */
    PLAYER_KILLS,
    /**
     * 捕获的鱼
     */
    FISH_CAUGHT,
    /**
     * 动物饲养
     */
    ANIMALS_BRED,
    /**
     * 宝鱼
     */
    TREASURE_FISHED,
    /**
     * 垃圾打捞
     */
    JUNK_FISHED,
    /**
     * 离开游戏
     */
    LEAVE_GAME,
    /**
     * 跳
     */
    JUMP,
    /**
     * 破坏方块
     */
    DROP(Type.ITEM),
    /**
     * 放置方块
     */
    PICKUP(Type.ITEM),
    /**
     * 游玩时间
     */
    PLAY_ONE_TICK,
    /**
     * 走
     */
    WALK_ONE_CM,
    /**
     * 游
     */
    SWIM_ONE_CM,
    /**
     * 下落
     */
    FALL_ONE_CM,
    /**
     * 潜行时间
     */
    SNEAK_TIME,
    /**
     * 上升
     */
    CLIMB_ONE_CM,
    /**
     * 飞
     */
    FLY_ONE_CM,
    /**
     * 潜水
     */
    DIVE_ONE_CM,
    /**
     * 矿车
     */
    MINECART_ONE_CM,
    /**
     * 船
     */
    BOAT_ONE_CM,
    /**
     * 骑猪
     */
    PIG_ONE_CM,
    /**
     * 骑马
     */
    HORSE_ONE_CM,
    /**
     * 冲刺
     */
    SPRINT_ONE_CM,
    /**
     * 潜行
     */
    CROUCH_ONE_CM,
    /**
     * 飞行(驾驶)
     */
    AVIATE_ONE_CM,
    /**
     * 矿物开凿
     */
    MINE_BLOCK(Type.BLOCK),
    /**
     * 使用项目
     */
    USE_ITEM(Type.ITEM),
    /**
     * 中断项目
     */
    BREAK_ITEM(Type.ITEM),
    /**
     * 合成
     */
    CRAFT_ITEM(Type.ITEM),
    /**
     * 杀死实体
     */
    KILL_ENTITY(Type.ENTITY),
    /**
     * 死亡(被怪物)
     */
    ENTITY_KILLED_BY(Type.ENTITY),
    /**
     * 死亡后到复活的时间
     */
    TIME_SINCE_DEATH,
    /**
     * 和村民说话
     */
    TALKED_TO_VILLAGER,
    /**
     * 和村民交易
     */
    TRADED_WITH_VILLAGER,
    /**
     * 吃蛋糕
     */
    CAKE_SLICES_EATEN,
    /**
     * 锅里
     */
    CAULDRON_FILLED,
    /**
     * 釜用
     */
    CAULDRON_USED,
    /**
     * 甲清洗
     */
    ARMOR_CLEANED,
    /**
     * 旗帜清洗
     */
    BANNER_CLEANED,
    /**
     * brewingstand互动
     */
    BREWINGSTAND_INTERACTION,
    /**
     * 灯塔的作用
     */
    BEACON_INTERACTION,
    /**
     * 滴管检查
     */
    DROPPER_INSPECTED,
    /**
     * 漏斗检验
     */
    HOPPER_INSPECTED,
    /**
     * 机检查
     */
    DISPENSER_INSPECTED,
    /**
     * 音符盒了
     */
    NOTEBLOCK_PLAYED,
    /**
     * 音符盒调谐
     */
    NOTEBLOCK_TUNED,
    /**
     * 花卉盆栽
     */
    FLOWER_POTTED,
    /**
     * 陷胸引发
     */
    TRAPPED_CHEST_TRIGGERED,
    /**
     * 末影箱
     */
    ENDERCHEST_OPENED,
    /**
     * 附魔
     */
    ITEM_ENCHANTED,
    /**
     * 记录了
     */
    RECORD_PLAYED,
    /**
     * 炉的作用
     */
    FURNACE_INTERACTION,
    /**
     * 制作表相互作用
     */
    CRAFTING_TABLE_INTERACTION,
    /**
     * 开箱子
     */
    CHEST_OPENED,
    /**
     * 睡在床上
     */
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
     * 原文： Gets the type of this statistic.
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
     * 这是个多余的方法，相当于检查<code>getType() != Type.UNTYPED</code> 原文： Checks if this
     * is a substatistic.
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
     * 检查是否为一项用于处理方块的次级统计数据。
     * <p>
     * 这是个多余的方法，相当于检查<code>getType() == Type.BLOCK</code>
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

    /**
     * 统计数据的类型。
     * <p>
     * 原文： The type of statistic.
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
         * 原文： Statistics of this type require an EntityType qualifier.
         */
        ENTITY;
    }
}
