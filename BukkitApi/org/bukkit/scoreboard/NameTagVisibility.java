package org.bukkit.scoreboard;

public enum NameTagVisibility {

    /**
     * 一直显示玩家名称
     */
    ALWAYS,
    /**
     * 不显示玩家名称
     */
    NEVER,
    /**
     * 仅显示在玩家所在队伍玩家计分板中
     */
    HIDE_FOR_OTHER_TEAMS,
    /**
     * 仅显示在其他队伍计分板中
     */
    HIDE_FOR_OWN_TEAM;
}
