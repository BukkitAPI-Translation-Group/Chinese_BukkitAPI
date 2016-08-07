package org.bukkit.scoreboard;

/**
 * @deprecated replaced by {@link Team.OptionStatus}
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
     * 仅显示在玩家所在队伍玩家计分板中.
     * <p>
     * Show the player's nametag only to his own team members.
     */
    HIDE_FOR_OTHER_TEAMS,
    /**
     * 仅显示在其他队伍计分板中.
     * <p>
     * 原文:
     * Show the player's nametag only to members of other teams.
     */
    HIDE_FOR_OWN_TEAM;
}
