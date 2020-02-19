package org.bukkit;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.bukkit.entity.Raider;
import org.jetbrains.annotations.NotNull;

/**
 * 代表袭击事件 (<a href="https://minecraft-zh.gamepedia.com/%E8%A2%AD%E5%87%BB" target="_blank">Minecraft Wiki - 袭击</a>).
 */
public interface Raid {

    /**
     * 判断袭击是否已开始.
     * <p>
     * 原文:Get whether this raid started.
     *
     * @return 袭击是否已开始
     */
    boolean isStarted();

    /**
     * 获取袭击持续了多久.
     * <p>
     * 原文:Gets the amount of ticks this raid has existed.
     *
     * @return 袭击已持续的时长, 以游戏刻为单位
     */
    long getActiveTicks();

    /**
     * 获取此次袭击中不祥之兆状态的等级.
     * <p>
     * 原文:Gets the Bad Omen level of this raid.
     *
     * @return 不祥之兆状态等级 (范围为0-5)
     */
    int getBadOmenLevel();

    /**
     * 设置此次袭击中不祥之兆状态的等级.
     * <br>
     * 如果此等级大于1, 将会有额外的与最终波强度一致的袭击波.
     * <p>
     * 原文:Sets the Bad Omen level.
     * <br>
     * If the level is higher than 1, there will be an additional wave that as
     * strong as the final wave.
     *
     * @param badOmenLevel 新的不祥之兆状态等级 (范围为0-5)
     * @throws IllegalArgumentException 等级数值不在有效范围之内
     */
    void setBadOmenLevel(int badOmenLevel);

    /**
     * 获取袭击的中心位置.
     * <p>
     * 原文:Gets the center location where the raid occurs.
     *
     * @return 袭击中心位置
     */
    @NotNull
    Location getLocation();

    /**
     * 获取此袭击的状态.
     * <br>
     * 请不要使用本方法来检查袭击是否已开始, 应使用{@link #isStarted()}.
     * <p>
     * 原文:Gets the current status of the raid.
     * <br>
     * Do not use this method to check if the raid has been started, call
     * {@link #isStarted()} instead.
     *
     * @return 袭击状态
     */
    @NotNull
    RaidStatus getStatus();

    /**
     * 获取袭击中已生成的怪物的波数.
     * <p>
     * 原文:Gets the number of raider groups which have spawned.
     *
     * @return 已生成的怪物的波数
     */
    int getSpawnedGroups();

    /**
     * 获取袭击中生成的怪物的总波数.
     * <br>
     * 该方法返回的结果也包括额外的袭击波数 (若存在).
     * <br>
     * 译注:不祥之兆的等级会影响是否有额外的袭击波数 (大于1会有额外的一波或数波袭击).
     * <p>
     * 原文:Gets the number of raider groups which would spawn.
     * <br>
     * This also includes the group which spawns in the additional wave (if
     * present).
     *
     * @return 袭击总波数 (含额外袭击波数)
     */
    int getTotalGroups();

    /**
     * 获取袭击的总波数 (排除额外的袭击波数).
     * <p>
     * 原文:Gets the number of waves in this raid (exclude the additional wave).
     *
     * @return 袭击总波数 (不含额外袭击波数)
     */
    int getTotalWaves();

    /**
     * 获取所有袭击者的最大生命值总和.
     * <p>
     * 原文:Gets the sum of all raider's health.
     *
     * @return 袭击者最大生命值总和
     */
    float getTotalHealth();

    /**
     * 获取本次袭击中获胜的英雄(玩家)们的UUID.
     * <p>
     * 原文:Get the UUID of all heroes in this raid.
     *
     * @return 获胜的英雄(玩家)们的UUID
     */
    @NotNull
    Set<UUID> getHeroes();

    /**
     * 获取当前一波袭击中所有存活的{@link Raider 袭击者}.
     * <p>
     * 原文:Gets all remaining {@link Raider} in the present wave.
     *
     * @return 所有存活的{@link Raider 袭击者}的列表
     */
    @NotNull
    List<Raider> getRaiders();

    /**
     * 代表{@link Raid 袭击}的状态.
     */
    public enum RaidStatus {

        /**
         * 袭击正在进行中.
         */
        ONGOING,
        /**
         * 英雄(玩家们)击败了所有的袭击者.
         */
        VICTORY,
        /**
         * 村庄已被摧毁 (即所有村民被杀死).
         */
        LOSS,
        /**
         * 袭击被终止.
         */
        STOPPED;
    }
}
