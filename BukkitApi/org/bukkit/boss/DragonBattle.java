package org.bukkit.boss;

import java.util.Collection;
import org.bukkit.Location;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.EnderDragon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一个末地环境中的龙战状态.
 */
public interface DragonBattle {

    /**
     * 获取此战斗中活跃的{@link EnderDragon}.
     * <br>
     * 如果龙已被击杀则返回null.
     * <p>
     * 原文：
     * Get the {@link EnderDragon} active in this battle.
     * <br>
     * Will return null if the dragon has been slain.
     *
     * @return 末影龙. 如果已死亡则返回null
     */
    @Nullable
    public EnderDragon getEnderDragon();

    /**
     * 获取此龙战显示的Boss血条.
     * <p>
     * 原文：
     * Get the boss bar to be displayed for this dragon battle.
     *
     * @return Boss血条
     */
    @NotNull
    public BossBar getBossBar();

    /**
     * 获取末地传送门的位置.
     * <br>
     * 此位置将在传送门底座(底部)的中心.
     * <p>
     * 原文：
     * Get the location of the end portal.
     * <br>
     * This location will be at the center of the base (bottom) of the portal.
     *
     * @return 末地传送门的位置, 如果未生成则返回null
     */
    @Nullable
    public Location getEndPortalLocation();

    /**
     * 生成末地传送门.
     * <p>
     * 原文：
     * Generate the end portal.
     *
     * @param withPortals 是否应生成末地传送门方块
     *
     * @return 如果已生成返回true, 如果已存在返回false
     */
    public boolean generateEndPortal(boolean withPortals);

    /**
     * 检查第一只龙是否已被击杀过.
     * <p>
     * 原文：
     * Check whether the first dragon has been killed already.
     *
     * @return 如果之前被击杀过返回true, 否则返回false
     */
    public boolean hasBeenPreviouslyKilled();

    /**
     * 设置第一只龙是否已被击杀过.
     * <br>
     * 如果龙之前未被击杀, 当它最终被击杀时将生成传送门.
     * <p>
     * 原文：
     * Sets whether the first dragon has been killed already.
     * <br>
     * If the dragon has not previously been killed, a portal will be generated
     * when it is finally killed.
     *
     * @param previouslyKilled 如果龙之前被击杀过则为true, 否则为false
     */
    public void setPreviouslyKilled(boolean previouslyKilled);

    /**
     * 尝试启动重生序列来召唤龙, 就像玩家在传送门上放置了4个末地水晶一样.
     * <p>
     * 原文：
     * Try to initiate a respawn sequence to summon the dragon as though a player has
     * placed 4 end crystals on the portal.
     */
    public void initiateRespawn();

    /**
     * 尝试启动重生序列来召唤龙.
     * <p>
     * 原文：
     * Try to initiate a respawn sequence to summon the dragon.
     *
     * @param enderCrystals 用于重生的{@link EnderCrystal 末地水晶}, 为null或空列表则使重生序列不可取消.
     * null条目或不在此龙战同一世界的水晶将被忽略.
     *
     * @return 如果重生已启动返回true, 否则返回false.
     */
    public boolean initiateRespawn(@Nullable Collection<EnderCrystal> enderCrystals);

    /**
     * 获取此战斗当前的重生阶段.
     * <p>
     * 原文：
     * Get this battle's current respawn phase.
     *
     * @return 当前的重生阶段.
     */
    @NotNull
    public RespawnPhase getRespawnPhase();

    /**
     * 设置龙的重生阶段.
     * <br>
     * 如果龙重生未在进行中, 此方法将不会成功.
     * <p>
     * 原文：
     * Set the dragon's respawn phase.
     * <br>
     * This method will is unsuccessful if a dragon respawn is not in progress.
     *
     * @param phase 要设置的阶段
     *
     * @return 如果成功返回true, 否则返回false
     *
     * @see #initiateRespawn()
     */
    public boolean setRespawnPhase(@NotNull RespawnPhase phase);

    /**
     * 重置位于黑曜石柱上的水晶(移除其光束目标和无敌状态).
     * <p>
     * 原文：
     * Reset the crystals located on the obsidian pillars (remove their beam
     * targets and invulnerability).
     */
    public void resetCrystals();

    /**
     * 代表龙重生过程中的一个阶段.
     */
    public enum RespawnPhase {

        /**
         * 水晶光束指向天空.
         */
        START,
        /**
         * 水晶光束保持向上.
         */
        PREPARING_TO_SUMMON_PILLARS,
        /**
         * 水晶光束从一个柱子指向另一个柱子, 必要时重新生成其水晶.
         */
        SUMMONING_PILLARS,
        /**
         * 所有水晶(包括来自柱子的)都指向天空. 随后召唤龙并摧毁用于启动龙重生的水晶.
         */
        SUMMONING_DRAGON,
        /**
         * 重生序列结束. 龙被实际召唤.
         */
        END,
        /**
         * 没有重生在进行中.
         */
        NONE;
    }
}
