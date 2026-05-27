package org.bukkit.entity;

import org.bukkit.GameEvent;
import org.bukkit.enchantments.Enchantment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表雷击的实例，可能会或者不会造成伤害。
 */
public interface LightningStrike extends Entity {

    /**
     * 返回雷击是否是没有伤害的效果。
     * <p>
     * 原文：Returns whether the strike is an effect that does no damage.
     *
     * @return 雷击是否为效果
     */
    public boolean isEffect();

    /**
     * 获取雷击被移除前将会发生的闪烁次数。默认情况下此值在 1 到 3 之间。
     * <p>
     * 原文: Get the amount of flashes that will occur before the lightning is
     * removed. By default this value is between 1 and 3.
     *
     * @return 闪烁次数
     */
    public int getFlashes();

    /**
     * 设置雷击被移除前将会发生的闪烁次数。当此雷击的生命值降至 0 以下时将会发生一次闪烁。
     * <p>
     * 原文: Set the amount of flashes that will occur before the lightning is
     * removed. One flash will occur after this lightning strike's life has reduced below 0.
     *
     * @param flashes 闪烁次数
     */
    public void setFlashes(int flashes);

    /**
     * 获取此雷击对其命中实体造成伤害的持续刻数。
     * <p>
     * 当生命刻数为负时，有随机几率触发另一次闪烁并将生命刻数重置为 1。
     * <p>
     * 原文: Get the amount of ticks this lightning strike will inflict damage
     * upon its hit entities. When life ticks are negative, there is a random
     * chance that another flash will be initiated and life ticks reset to 1.
     *
     * @return 生命刻数
     */
    public int getLifeTicks();

    /**
     * 设置此雷击对其命中实体造成伤害的持续刻数。
     * <p>
     * 当生命刻数为负时，有随机几率触发另一次闪烁并将生命刻数重置为 1。
     * 此外，如果生命刻数设置为 2（雷击生成时的默认值），将会触发一系列事件：
     * <ul>
     *   <li>播放冲击音效
     *   <li>生成火焰（取决于难度）
     *   <li>激活避雷针（如果被击中）
     *   <li>剥离铜锈（如果被击中）
     *   <li>触发 {@link GameEvent#LIGHTNING_STRIKE} 游戏事件
     * </ul>
     * <p>
     * 原文: Get the amount of ticks this lightning strike will inflict damage
     * upon its hit entities. When life ticks are negative, there is a random
     * chance that another flash will be initiated and life ticks reset to 1.
     * Additionally, if life ticks are set to 2 (the default value when a
     * lightning strike has been spawned), a list of events will occur.
     *
     * @param ticks 生命刻数
     */
    public void setLifeTicks(int ticks);

    /**
     * 获取导致此雷击的 {@link Player}。当玩家在暴风雨中向实体投掷带有
     * {@link Enchantment#CHANNELING 引雷} 附魔的三叉戟时会自然触发此情况。
     * <p>
     * 原文: Get the {@link Player} that caused this lightning to strike. This
     * will occur naturally if a trident enchanted with
     * {@link Enchantment#CHANNELING Channeling} were thrown at an entity
     * during a storm.
     *
     * @return 导致雷击的玩家
     */
    @Nullable
    public Player getCausingPlayer();

    /**
     * 设置导致此雷击的 {@link Player}。
     * <p>
     * 原文: Set the {@link Player} that caused this lightning to strike.
     *
     * @param player 导致雷击的玩家
     */
    public void setCausingPlayer(@Nullable Player player);

    // Spigot start
    public class Spigot extends Entity.Spigot {

        /*
         * 返回此雷击是否为静默的(是否发声).
         * <p>
         * 原文:Returns whether the strike is silent.
         *
         * @return 此雷击是否为静默的(true代表静默, 不会发声, false代表会产生雷响).
         * @deprecated 声音现由客户端控制, 且不可移除
         */
        @Deprecated(since = "1.20.4")
        public boolean isSilent() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @NotNull
    @Override
    Spigot spigot();
    // Spigot end
}