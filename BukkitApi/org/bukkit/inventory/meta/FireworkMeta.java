package org.bukkit.inventory.meta;

import java.util.List;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一个{@link Material#FIREWORK_ROCKET 烟花火箭}及其效果.
 */
public interface FireworkMeta extends ItemMeta {

    /**
     * 向烟花火箭添加一个烟花效果.
     * <p>
     * 原文:
     * Add another effect to this firework.
     *
     * @param effect 要添加的烟花效果
     * @throws IllegalArgumentException 若 effect 为 null
     */
    void addEffect(@NotNull FireworkEffect effect) throws IllegalArgumentException;

    /**
     * 向烟花火箭添加多个烟花效果.
     * <p>
     * 原文:
     * Add several effects to this firework.
     *
     * @param effects 要添加的烟花效果
     * @throws IllegalArgumentException 若 effects 为 null
     * @throws IllegalArgumentException 若任意一个效果为 null (可能在前面的效果应用后抛出)
     */
    void addEffects(@NotNull FireworkEffect... effects) throws IllegalArgumentException;

    /**
     * 向烟花火箭添加多个烟花效果.
     * <p>
     * 原文:
     * Add several firework effects to this firework.
     *
     * @param effects 一个可以迭代所需的烟花效果的可迭代对象
     * @throws IllegalArgumentException 若 effects 为 null
     * @throws IllegalArgumentException 若任意一个效果为 null (可能在前面的效果应用后抛出)
     */
    void addEffects(@NotNull Iterable<FireworkEffect> effects) throws IllegalArgumentException;

    /**
     * 获取此烟花火箭的所有烟花效果.
     * <p>
     * 原文:
     * Get the effects in this firework.
     *
     * @return 所有烟花效果的不可变列表
     */
    @NotNull
    List<FireworkEffect> getEffects();

    /**
     * 获取烟花效果的数量.
     * <p>
     * 原文:
     * Get the number of effects in this firework.
     *
     * @return 烟花效果的数量
     */
    int getEffectsSize();

    /**
     * 移除烟花火箭中的一个烟花效果.
     * <p>
     * 原文:
     * Remove an effect from this firework.
     *
     * @param index 烟花效果的序号
     * @throws IndexOutOfBoundsException 若 index {@literal < 0 或 index >} {@link
     *     #getEffectsSize()}
     */
    void removeEffect(int index) throws IndexOutOfBoundsException;

    /**
     * 移除烟花火箭附带的所有效果.
     * <p>
     * 原文:
     * Remove all effects from this firework.
     */
    void clearEffects();

    /**
     * 判断烟花火箭是否含有烟花效果.
     * <p>
     * 原文:
     * Get whether this firework has any effects.
     *
     * @return 烟花火箭是否含有烟花效果.
     */
    boolean hasEffects();

    /**
     * 获取这个烟花火箭的飞行时间的近似值.
     * <p>
     * 译注: 原文中 "height" 有误, 实际为飞行时间而非高度, 但"近似"表述无误,
     * 因为底层的烟花生命周期(单位为 tick)的计算公式为: <code>飞行时间 * 10 + 0~5的随机整数 + 0~6的随机整数</code>.
     * <p>
     * 原文:
     * Gets the approximate height the firework will fly.
     *
     * @return 飞行时间近似值
     */
    int getPower();

    /**
     * 设置这个烟花火箭的飞行时间的近似值. 每一级能量大约是半秒的飞行时间.
     * <p>
     * 原文:
     * Sets the approximate power of the firework. Each level of power is half
     * a second of flight time.
     *
     * @param power 烟花火箭的能量 (持续时间), 取值范围 0 {@literal <=} power {@literal <} 128
     * @throws IllegalArgumentException 若 {@literal power<0 或 power>127}
     */
    void setPower(int power) throws IllegalArgumentException;

    @Override
    @NotNull
    FireworkMeta clone();
}
