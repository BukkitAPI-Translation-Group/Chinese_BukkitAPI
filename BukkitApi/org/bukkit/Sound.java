package org.bukkit;

/**
 * 服务器能给玩家发送的声音的一个枚举。
 * <p>
 * 警告：在某些时候，声音可能被这个枚举或Minecraft自己新增/移除！ 不保证声音能播放，不保证一些声音值会从这个枚举移除。
 * 因此，你不应该依赖这个类的顺序值。
 */
public enum Sound {
    /**
     * 氛围洞
     */
    AMBIENCE_CAVE,
    /**
     * 氛围雨
     */
    AMBIENCE_RAIN,
    /**
     * 氛围雷
     */
    AMBIENCE_THUNDER,
    /**
     * 砧破
     */
    ANVIL_BREAK,
    /**
     * 砧放置
     */
    ANVIL_LAND,
    /**
     * 砧使用
     */
    ANVIL_USE,
    /**
     * 箭头击中
     */
    ARROW_HIT,
    /**
     * 打嗝
     */
    BURP,
    /**
     * 胸腔闭
     */
    CHEST_CLOSE,
    /**
     * 胸部开放
     */
    CHEST_OPEN,
    /**
     * 点击
     */
    CLICK,
    /**
     * 关门
     */
    DOOR_CLOSE,
    /**
     * 门打开
     */
    DOOR_OPEN,
    /**
     * 喝
     */
    DRINK,
    /**
     * 吃
     */
    EAT,
    /**
     * 爆炸
     */
    EXPLODE,
    /**
     * 秋天大
     */
    FALL_BIG,
    /**
     * 落小
     */
    FALL_SMALL,
    /**
     * 火
     */
    FIRE,
    /**
     * 点燃
     */
    FIRE_IGNITE,
    /**
     * 菲士
     */
    FIZZ,
    /**
     * 熔断器
     */
    FUSE,
    /**
     * 玻璃
     */
    GLASS,
    /**
     * 伤肉
     */
    HURT_FLESH,
    /**
     * 项目中断
     */
    ITEM_BREAK,
    /**
     * 物品拾取
     */
    ITEM_PICKUP,
    /**
     * 熔岩
     */
    LAVA,
    /**
     * 熔岩流行
     */
    LAVA_POP,
    /**
     * 水平上升
     */
    LEVEL_UP,
    /**
     * 矿车基地
     */
    MINECART_BASE,
    /**
     * 矿车内
     */
    MINECART_INSIDE,
    /**
     * 低音低音
     */
    NOTE_BASS,
    /**
     * 音符钢琴
     */
    NOTE_PIANO,
    /**
     * 低音鼓
     */
    NOTE_BASS_DRUM,
    /**
     * 便条棒
     */
    NOTE_STICKS,
    /**
     * 低音吉他
     */
    NOTE_BASS_GUITAR,
    /**
     * 鼓鼓
     */
    NOTE_SNARE_DRUM,
    /**
     * 注意采样
     */
    NOTE_PLING,
    /**
     * 球头
     */
    ORB_PICKUP,
    /**
     * 活塞延伸
     */
    PISTON_EXTEND,
    /**
     * 活塞缩回
     */
    PISTON_RETRACT,
    /**
     * 门户
     */
    PORTAL,
    /**
     * 门户旅游
     */
    PORTAL_TRAVEL,
    /**
     * 门触发器
     */
    PORTAL_TRIGGER,
    /**
     * 射击箭头
     */
    SHOOT_ARROW,
    /**
     * 飞溅
     */
    SPLASH,
    /**
     * SPLASH2
     */
    SPLASH2,
    /**
     * 步草
     */
    STEP_GRASS,
    /**
     * 阶梯碎石
     */
    STEP_GRAVEL,
    /**
     * 阶梯阶梯
     */
    STEP_LADDER,
    /**
     * 阶梯砂
     */
    STEP_SAND,
    /**
     * 阶梯雪
     */
    STEP_SNOW,
    /**
     * 阶梯石
     */
    STEP_STONE,
    /**
     * 步木
     */
    STEP_WOOD,
    /**
     * 步毛
     */
    STEP_WOOL,
    /**
     * 游泳
     */
    SWIM,
    /**
     * 水
     */
    WATER,
    /**
     * 木材点击
     */
    WOOD_CLICK,
    // Mob sounds
    /**
     * 蝙蝠死亡
     */
    BAT_DEATH,
    /**
     * 蝙蝠伤害
     */
    BAT_HURT,
    /**
     * 蝙蝠空闲
     */
    BAT_IDLE,
    /**
     * 蝙蝠回路
     */
    BAT_LOOP,
    /**
     * 蝙蝠起飞
     */
    BAT_TAKEOFF,
    /**
     * 火焰呼吸
     */
    BLAZE_BREATH,
    /**
     * 火焰死亡
     */
    BLAZE_DEATH,
    /**
     * 火焰击中
     */
    BLAZE_HIT,
    /**
     * 猫的嘶嘶声
     */
    CAT_HISS,
    /**
     * 猫撞
     */
    CAT_HIT,
    /**
     * 猫喵
     */
    CAT_MEOW,
    /**
     * 猫的咕噜声
     */
    CAT_PURR,
    /**
     * 猫purreow
     */
    CAT_PURREOW,
    /**
     * 鸡闲
     */
    CHICKEN_IDLE,
    /**
     * 鸡肉伤害
     */
    CHICKEN_HURT,
    /**
     * 鸡蛋
     */
    CHICKEN_EGG_POP,
    /**
     * 鸡走
     */
    CHICKEN_WALK,
    /**
     * 奶牛闲置
     */
    COW_IDLE,
    /**
     * 奶牛伤害
     */
    COW_HURT,
    /**
     * 奶牛行走
     */
    COW_WALK,
    /**
     * 爬山虎的嘶嘶声
     */
    CREEPER_HISS,
    /**
     * 爬山虎的死亡
     */
    CREEPER_DEATH,
    /**
     * 末影龙死亡
     */
    ENDERDRAGON_DEATH,
    /**
     * 末影龙咆哮
     */
    ENDERDRAGON_GROWL,
    /**
     * 末影龙打
     */
    ENDERDRAGON_HIT,
    /**
     * 末影龙翅膀
     */
    ENDERDRAGON_WINGS,
    /**
     * 末影人死亡
     */
    ENDERMAN_DEATH,
    /**
     * 末影人打
     */
    ENDERMAN_HIT,
    /**
     * 末影人闲置
     */
    ENDERMAN_IDLE,
    /**
     * 末影人瞬移
     */
    ENDERMAN_TELEPORT,
    /**
     * 末影人的尖叫
     */
    ENDERMAN_SCREAM,
    /**
     * 末影人的凝视
     */
    ENDERMAN_STARE,
    /**
     * 可怕的尖叫
     */
    GHAST_SCREAM,
    /**
     * scream2枯萎
     */
    GHAST_SCREAM2,
    /**
     * 可怕的电荷
     */
    GHAST_CHARGE,
    /**
     * 可怕的死亡
     */
    GHAST_DEATH,
    /**
     * 可怕的火球
     */
    GHAST_FIREBALL,
    /**
     * 可怕的呻吟
     */
    GHAST_MOAN,
    /**
     * 铁傀儡死亡
     */
    IRONGOLEM_DEATH,
    /**
     * 铁傀儡打
     */
    IRONGOLEM_HIT,
    /**
     * 铁傀儡扔
     */
    IRONGOLEM_THROW,
    /**
     * 铁傀儡走
     */
    IRONGOLEM_WALK,
    /**
     * 岩浆怪走
     */
    MAGMACUBE_WALK,
    /**
     * 岩浆怪 walk2
     */
    MAGMACUBE_WALK2,
    /**
     * 岩浆怪跳
     */
    MAGMACUBE_JUMP,
    /**
     * 猪闲
     */
    PIG_IDLE,
    /**
     * 猪死亡
     */
    PIG_DEATH,
    /**
     * 猪走路
     */
    PIG_WALK,
    /**
     * 羊闲
     */
    SHEEP_IDLE,
    /**
     * 羊剪
     */
    SHEEP_SHEAR,
    /**
     * 羊走
     */
    SHEEP_WALK,
    /**
     * 银鱼打
     */
    SILVERFISH_HIT,
    /**
     * 银鱼杀
     */
    SILVERFISH_KILL,
    /**
     * 银鱼闲置
     */
    SILVERFISH_IDLE,
    /**
     * 银鱼走
     */
    SILVERFISH_WALK,
    /**
     * 骨架空闲
     */
    SKELETON_IDLE,
    /**
     * 骨骼死亡
     */
    SKELETON_DEATH,
    /**
     * 骨骼受伤
     */
    SKELETON_HURT,
    /**
     * 骨骼行走
     */
    SKELETON_WALK,
    /**
     * 粘液攻击
     */
    SLIME_ATTACK,
    /**
     * 粘液走
     */
    SLIME_WALK,
    /**
     * 煤泥walk2
     */
    SLIME_WALK2,
    /**
     * 蜘蛛空闲
     */
    SPIDER_IDLE,
    /**
     * 蜘蛛死亡
     */
    SPIDER_DEATH,
    /**
     * 蜘蛛行走
     */
    SPIDER_WALK,
    /**
     * 枯萎死亡
     */
    WITHER_DEATH,
    /**
     * 枯萎伤害
     */
    WITHER_HURT,
    /**
     * 闲置
     */
    WITHER_IDLE,
    /**
     * 枯萎射击
     */
    WITHER_SHOOT,
    /**
     * 枯萎产卵
     */
    WITHER_SPAWN,
    /**
     * 狼皮
     */
    WOLF_BARK,
    /**
     * 狼性死亡
     */
    WOLF_DEATH,
    /**
     * 狼咆哮
     */
    WOLF_GROWL,
    /**
     * 狼叫
     */
    WOLF_HOWL,
    /**
     * 狼伤害
     */
    WOLF_HURT,
    /**
     * 狼裤
     */
    WOLF_PANT,
    /**
     * 狼摇
     */
    WOLF_SHAKE,
    /**
     * 狼走
     */
    WOLF_WALK,
    /**
     * 狼发牢骚
     */
    WOLF_WHINE,
    /**
     * 僵尸金属
     */
    ZOMBIE_METAL,
    /**
     * 僵尸木
     */
    ZOMBIE_WOOD,
    /**
     * 僵尸woodbreak
     */
    ZOMBIE_WOODBREAK,
    /**
     * 僵尸闲置
     */
    ZOMBIE_IDLE,
    /**
     * 僵尸死亡
     */
    ZOMBIE_DEATH,
    /**
     * 僵尸伤害
     */
    ZOMBIE_HURT,
    /**
     * 僵尸感染
     */
    ZOMBIE_INFECT,
    /**
     * 僵尸unfect
     */
    ZOMBIE_UNFECT,
    /**
     * 僵尸补救
     */
    ZOMBIE_REMEDY,
    /**
     * 僵尸行走
     */
    ZOMBIE_WALK,
    /**
     * 僵尸猪闲
     */
    ZOMBIE_PIG_IDLE,
    /**
     * 僵尸猪生气
     */
    ZOMBIE_PIG_ANGRY,
    /**
     * 僵尸猪死亡
     */
    ZOMBIE_PIG_DEATH,
    /**
     * 僵尸猪伤害
     */
    ZOMBIE_PIG_HURT,
    // Dig Sounds
    /**
     * 挖毛
     */
    DIG_WOOL,
    /**
     * 挖草
     */
    DIG_GRASS,
    /**
     * 挖砾
     */
    DIG_GRAVEL,
    /**
     * 挖砂
     */
    DIG_SAND,
    /**
     * 挖雪
     */
    DIG_SNOW,
    /**
     * 挖石
     */
    DIG_STONE,
    /**
     * 刨木
     */
    DIG_WOOD,
    /**/
    // Fireworks
    /**
     * 烟花爆炸
     */
    FIREWORK_BLAST,
    /**
     * 烟花次热闹的聚会
     */
    FIREWORK_BLAST2,
    /**
     * 烟火大爆炸
     */
    FIREWORK_LARGE_BLAST,
    /**
     * 烟花大次热闹的聚会
     */
    FIREWORK_LARGE_BLAST2,
    /**
     * 烟火闪烁
     */
    FIREWORK_TWINKLE,
    /**
     * 烟花twinkle2
     */
    FIREWORK_TWINKLE2,
    /**
     * 烟火发射
     */
    FIREWORK_LAUNCH,
    /**
     * 成功命中
     */
    SUCCESSFUL_HIT,
    // Horses
    /**
     * 马生气
     */
    HORSE_ANGRY,
    /**
     * 马装甲
     */
    HORSE_ARMOR,
    /**
     * 马呼吸
     */
    HORSE_BREATHE,
    /**
     * 马死亡
     */
    HORSE_DEATH,
    /**
     * 马驰骋
     */
    HORSE_GALLOP,
    /**
     * 马打
     */
    HORSE_HIT,
    /**
     * 马闲
     */
    HORSE_IDLE,
    /**
     * 马跳
     */
    HORSE_JUMP,
    /**
     * 马土地
     */
    HORSE_LAND,
    /**
     * 马鞍
     */
    HORSE_SADDLE,
    /**
     * 马软
     */
    HORSE_SOFT,
    /**
     * 马木
     */
    HORSE_WOOD,
    /**
     * 驴生气
     */
    DONKEY_ANGRY,
    /**
     * 驴死亡
     */
    DONKEY_DEATH,
    /**
     * 驴打
     */
    DONKEY_HIT,
    /**
     * 驴闲
     */
    DONKEY_IDLE,
    /**
     * 马骨骼死亡
     */
    HORSE_SKELETON_DEATH,
    /**
     * 马骨骼撞击
     */
    HORSE_SKELETON_HIT,
    /**
     * 马骨骨
     */
    HORSE_SKELETON_IDLE,
    /**
     * 马僵尸死亡
     */
    HORSE_ZOMBIE_DEATH,
    /**
     * 马僵尸袭击
     */
    HORSE_ZOMBIE_HIT,
    /**
     * 马僵尸闲置
     */
    HORSE_ZOMBIE_IDLE,
    // Villager
    /**
     * 村民死亡
     */
    VILLAGER_DEATH,
    /**
     * 村民讨价还价
     */
    VILLAGER_HAGGLE,
    /**
     * 村民打
     */
    VILLAGER_HIT,
    /**
     * 村民闲
     */
    VILLAGER_IDLE,
    /**
     * 村民无
     */
    VILLAGER_NO,
    /**
     * 村民是
     */
    VILLAGER_YES,

}
