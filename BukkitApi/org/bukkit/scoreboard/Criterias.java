package org.bukkit.scoreboard;

/**
 * 游戏内标准计分项目（生命、击杀信息、死亡次数）.
 * <p>
 * 原文:
 * Criteria names which trigger an objective to be modified by actions in-game.
 * <p>
 */
public class Criterias {
    public static final String HEALTH;
    public static final String PLAYER_KILLS;
    public static final String TOTAL_KILLS;
    public static final String DEATHS;

    static {
        HEALTH="health";
        PLAYER_KILLS="playerKillCount";
        TOTAL_KILLS="totalKillCount";
        DEATHS="deathCount";
    }

    private Criterias() {}
}
