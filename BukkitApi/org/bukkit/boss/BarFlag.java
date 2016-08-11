package org.bukkit.boss;

public enum BarFlag {

    /**
     * 凋零血条的属性（战斗时天空会变暗）
     */
    DARKEN_SKY,
    /**
     * 末影龙的血条属性，告诉客户端该播放打末影龙时候的BGM
     */
    PLAY_BOSS_MUSIC,
    /**
     * 在血条所在的世界产生迷雾
     */
    CREATE_FOG,
}