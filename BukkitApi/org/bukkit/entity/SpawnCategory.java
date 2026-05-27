package org.bukkit.entity;

/**
 * 代表具有共享生成行为和生物上限的实体组。
 *
 * @see <a href="https://minecraft.wiki/w/Spawn#Java_Edition_mob_cap">Minecraft Wiki</a>
 */
public enum SpawnCategory {

    /**
     * 与怪物相关的实体，例如：女巫、僵尸、苦力怕等。
     */
    MONSTER,
    /**
     * 与动物相关的实体，例如：炽足兽、牛、海龟等。
     */
    ANIMAL,
    /**
     * 与水生动物相关的实体，例如：鱿鱼或海豚。
     */
    WATER_ANIMAL,
    /**
     * 与水生环境生物相关的实体，例如：鳕鱼、河豚、热带鱼、鲑鱼等。
     */
    WATER_AMBIENT,
    /**
     * 与水下生物相关的实体，例如：发光鱿鱼。
     */
    WATER_UNDERGROUND_CREATURE,
    /**
     * 与环境生物相关的实体，例如：蝙蝠。
     */
    AMBIENT,
    /**
     * 所有美西螈都属于此分类。
     */
    AXOLOTL,
    /**
     * 与生物无关的实体，例如：玩家、盔甲架、船等。
     */
    MISC;
}
