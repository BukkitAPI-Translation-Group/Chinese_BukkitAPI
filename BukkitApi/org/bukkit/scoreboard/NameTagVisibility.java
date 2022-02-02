package org.bukkit.scoreboard;

/**
 * @deprecated 被 {@link Team.OptionStatus} 取代
 */
@Deprecated
public enum NameTagVisibility {

    /**
     * 一直显示玩家名称.
     * <p>
     * 原文:
     * Always show the player's nametag.
     */
    ALWAYS,
    /**
     * 不显示玩家名称.
     * <p>
     * 原文:
     * Never show the player's nametag.
     */
    NEVER,
    /**
     * 玩家名仅显示给同队队友.
     * <p>
     * 原文:
     * Show the player's nametag only to his own team members.
     */
    HIDE_FOR_OTHER_TEAMS,
    /**
     * 玩家名仅显示给其他队伍的成员.
     * <p>
     * 原文:
     * Show the player's nametag only to members of other teams.
     */
    HIDE_FOR_OWN_TEAM;
}
