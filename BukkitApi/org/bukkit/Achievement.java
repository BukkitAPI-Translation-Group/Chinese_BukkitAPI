package org.bukkit;

import org.jetbrains.annotations.Nullable;

/**
 * 代表成就.
 * @deprecated 未来版本的Minecraft将不会有成就(取而代之的是进度).
 */
@Deprecated
public enum Achievement {
    /**
     * 「打开物品栏」.
     * <p>
     * 按“E”来打开你的物品栏
     */
    OPEN_INVENTORY,
    /**
     * 「获得木头」.
     * <p>
     * 摧毁树木直到跳出一个木头方块.
     * <p>
     * 此成就需要前置成就: 「{@linkplain Achievement#OPEN_INVENTORY 打开物品栏}」
     */
    MINE_WOOD(OPEN_INVENTORY),
    /**
     * 「这是？工作台！」.
     * <p>
     * 用四个木板来制作一个工作台.
     * <p>
     * 此成就需要前置成就: 「{@linkplain Achievement#MINE_WOOD 获得木头}」
     */
    BUILD_WORKBENCH(MINE_WOOD),
    /**
     * 「采矿时间到！」.
     * <p>
     * 使用木板和木棍来制作木镐.
     * <p>
     * 此成就需要前置成就: 「{@linkplain Achievement#BUILD_WORKBENCH 这是? 工作台!}」
     */
    BUILD_PICKAXE(BUILD_WORKBENCH),
    /**
     * 「“热”门话题」.
     * <p>
     * 用八个圆石来制作一个熔炉.
     * <p>
     * 此成就需要前置成就: 「{@linkplain Achievement#BUILD_PICKAXE 采矿时间到！}」
     */
    BUILD_FURNACE(BUILD_PICKAXE),
    /**
     * 「来硬的」.
     * <p>
     * 冶炼出一块铁锭.
     * <p>
     * 此成就需要前置成就: 「{@linkplain Achievement#BUILD_FURNACE “热”门话题}」
     */
    ACQUIRE_IRON(BUILD_FURNACE),
    /**
     * 「耕种时间到！」.
     * <p>
     * 使用木板和木棍来制作木锄.
     * <p>
     * 此成就需要前置成就: 「{@linkplain Achievement#BUILD_WORKBENCH 这是? 工作台!}」
     */
    BUILD_HOE(BUILD_WORKBENCH),
    /**
     * 「烤面包」.
     * <p>
     * 用小麦来做面包.
     * <p>
     * 此成就需要前置成就: 「{@linkplain Achievement#BUILD_HOE 耕种时间到！}」
     */
    MAKE_BREAD(BUILD_HOE),
    /**
     * 「蛋糕是个谎言」.
     * <p>
     * 小麦、糖、牛奶和鸡蛋！
     * <p>
     * 此成就需要前置成就: 「{@linkplain Achievement#BUILD_HOE 耕种时间到！}」
     */
    BAKE_CAKE(BUILD_HOE),
    /**
     * 「获得升级」.
     * <p>
     * 制作一把更好的镐.
     * <p>
     * 此成就需要前置成就: 「{@linkplain Achievement#BUILD_PICKAXE 采矿时间到！}」
     */
    BUILD_BETTER_PICKAXE(BUILD_PICKAXE),
    /**
     * 「美味的鱼儿」.
     * <p>
     * 抓了鱼儿然后烤！
     * <p>
     * 此成就需要前置成就: 「{@linkplain Achievement#BUILD_FURNACE “热”门话题}」
     */
    COOK_FISH(BUILD_FURNACE),
    /**
     * 「在铁路上」.
     * <p>
     * 通过矿车旅行，移动到至少离出发点1公里的位置.
     * <p>
     * 此成就需要前置成就: 「{@linkplain Achievement#ACQUIRE_IRON 来硬的}」
     */
    ON_A_RAIL(ACQUIRE_IRON),
    /**
     * 「出击时间到！」.
     * <p>
     * 使用木板和木棍来制作一把木剑！
     * <p>
     * 此成就需要前置成就: 「{@linkplain Achievement#BUILD_WORKBENCH 这是? 工作台!}」
     */
    BUILD_SWORD(BUILD_WORKBENCH),
    /**
     * 「怪物猎人」.
     * <p>
     * 攻击并消灭一只怪物.
     * <p>
     * 此成就需要前置成就: 「{@linkplain Achievement#BUILD_SWORD 出击时间到！}」
     */
    KILL_ENEMY(BUILD_SWORD),
    /**
     * 「斗牛士」.
     * <p>
     * 获得一些皮革.
     * <p>
     * 此成就需要前置成就: 「{@linkplain Achievement#BUILD_SWORD 出击时间到！}」
     */
    KILL_COW(BUILD_SWORD),
    /**
     * 「当猪飞的时候」.
     * <p>
     * 骑着猪从悬崖上飞下.
     * <p>
     * 此成就需要前置成就: 「{@linkplain Achievement#KILL_COW 斗牛士}」
     */
    FLY_PIG(KILL_COW),
    /**
     * 「狙击手的对决」.
     * <p>
     * 用弓箭从50米外干掉一只骷髅.
     * <p>
     * 此成就需要前置成就: 「{@linkplain Achievement#KILL_ENEMY 怪物猎人}」
     */
    SNIPE_SKELETON(KILL_ENEMY),
    /**
     * 「钻石！」
     * <p>
     * 用你的铁镐，挖一些钻石吧.
     * <p>
     * 此成就需要前置成就: 「{@linkplain Achievement#ACQUIRE_IRON 来硬的}」
     */
    GET_DIAMONDS(ACQUIRE_IRON),
    /**
     * 「我们需要再深入些」 .
     * <p>
     * 建造一个通往下界的传送门.
     * <p>
     * 此成就需要前置成就: 「{@link Achievement#GET_DIAMONDS}」
     */
    NETHER_PORTAL(GET_DIAMONDS),
    /**
     * 「见鬼去吧」.
     * <p>
     * 用一团火球干掉一只恶魂.
     * <p>
     * 此成就需要前置成就: 「{@link Achievement#NETHER_PORTAL}」
     */
    GHAST_RETURN(NETHER_PORTAL),
    /**
     * 「与火共舞」.
     * <p>
     * 得到烈焰人的烈焰棒.
     * <p>
     * 此成就需要前置成就: 「{@link Achievement#NETHER_PORTAL}」
     */
    GET_BLAZE_ROD(NETHER_PORTAL),
    /**
     * 「本地的酿造厂」.
     * <p>
     * 酿造一瓶药水.
     * <p>
     * 此成就需要前置成就: 「{@link Achievement#GET_BLAZE_ROD}」
     */
    BREW_POTION(GET_BLAZE_ROD),
    /**
     * 「结束了？」.
     * <p>
     * 找到“末地”.
     * <p>
     * 此成就需要前置成就: 「{@link Achievement#GET_BLAZE_ROD}」
     */
    END_PORTAL(GET_BLAZE_ROD),
    /**
     * 「结束了。」.
     * <p>
     * 击败末影龙.
     * <p>
     * 此成就需要前置成就: 「{@link Achievement#END_PORTAL}」
     */
    THE_END(END_PORTAL),
    /**
     * 「附魔师」.
     * <p>
     * 使用书、黑曜石以及钻石来制作一个附魔台.
     * <p>
     * 此成就需要前置成就: 「{@link Achievement#GET_DIAMONDS}」
     */
    ENCHANTMENTS(GET_DIAMONDS),
    /**
     * 「赶尽杀绝」.
     * <p>
     * 在一击内造成9颗心的伤害.
     * <p>
     * 此成就需要前置成就: 「{@linkplain Achievement#ENCHANTMENTS 附魔师}」
     */
    OVERKILL(ENCHANTMENTS),
    /**
     * 「图书管理员」.
     * <p>
     * 建造一些书架来强化你的附魔台.
     * <p>
     * 此成就需要前置成就: 「{@linkplain Achievement#ENCHANTMENTS 附魔师}」
     */
    BOOKCASE(ENCHANTMENTS),
    /**
     * 「探索的时光」.
     * <p>
     * 发现所有的生物群系.
     * <p>
     * 此成就需要前置成就: 「{@link Achievement#END_PORTAL}」
     */
    EXPLORE_ALL_BIOMES(END_PORTAL),
    /**
     * 「开始了？」.
     * <p>
     * 生成凋灵.
     * <p>
     * 此成就需要前置成就: 「{@linkplain Achievement#THE_END 结束了？}」
     */
    SPAWN_WITHER(THE_END),
    /**
     * 「开始了」.
     * <p>
     * 杀死凋灵.
     * <p>
     * 此成就需要前置成就: 「{@linkplain Achievement#SPAWN_WITHER 开始了？}」
     */
    KILL_WITHER(SPAWN_WITHER),
    /**
     * 「信标工程师」.
     * <p>
     * 制造最高级的信标.
     * <p>
     * 此成就需要前置成就: 「{@linkplain Achievement#KILL_WITHER 开始了}」
     */
    FULL_BEACON(KILL_WITHER),
    /**
     * 「种群恢复」.
     * <p>
     * 喂小麦来繁殖出1头牛.
     * <p>
     * 此成就需要前置成就: 「{@linkplain Achievement#KILL_COW 斗牛士}」
     */
    BREED_COW(KILL_COW),
    /**
     * 「给你钻石！」.
     * <p>
     * 向一名玩家投掷钻石.
     * <p>
     * 此成就需要前置成就: 「{@link Achievement#GET_DIAMONDS}」
     */
    DIAMONDS_TO_YOU(GET_DIAMONDS),
    /**
     * 「君临天下」.
     * <p>
     * 制造一个附魔金苹果.
     * <p>
     * 此成就需要前置成就: 「{@linkplain Achievement#BUILD_BETTER_PICKAXE 获得升级}」
     */
    OVERPOWERED(BUILD_BETTER_PICKAXE)
    ;

    private final Achievement parent;

    private Achievement() {
        parent = null;
    }

    private Achievement(/*@Nullable*/ Achievement parent) {
        this.parent = parent;
    }

    /**
     * 返回想获得这个成就是否需要先获得另外一个成就。
     * <p>
     * 原文:Returns whether or not this achievement has a parent achievement.
     * <p>
     * 译注:比如，获得“这是？工作台！”成就必须要先获得“获得木头！”成就.
     *
     * @return 是否需要获得另一个成就才能获得这个成就
     */
    public boolean hasParent() {
        return parent != null;
    }

    /**
     * 返回获得这个成就需要的父成就，如果没有则返回null。
     * <p>
     * 原文:Returns the parent achievement of this achievement, or null if none.
     *
     * @return 父成就,不存在则为null
     */
    @Nullable
    public Achievement getParent() {
        return parent;
    }
}
