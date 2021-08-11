package org.bukkit.inventory.meta;

import java.util.List;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

/**
 * 代表能够设置自定义药水效果的迷之炖菜.
 */
public interface SuspiciousStewMeta extends ItemMeta {

    /**
     * 检查此迷之炖菜是否拥有药水效果.
     * <p>
     * 原文:
     * Checks for the presence of custom potion effects.
     *
     * @return 是否拥有药水效果
     */
    boolean hasCustomEffects();

    /**
     * 获取这个迷之炖菜的全部自定义效果.
     * <p>
     * 插件应该在调用这个方法之前检查 hasCustomEffects() 是否返回 true.
     * <p>
     * 原文:
     * Gets an immutable list containing all custom potion effects applied to
     * this suspicious stew.
     * <p>
     * Plugins should check that hasCustomEffects() returns true before calling
     * this method.
     *
     * @return 自定义效果列表 (不可变)
     */
    @NotNull
    List<PotionEffect> getCustomEffects();

    /**
     * 添加一个自定义药水效果到这个迷之炖菜上.
     * <p>
     * 原文:
     * Adds a custom potion effect to this suspicious stew.
     *
     * @param effect 要添加的药水效果
     * @param overwrite 如果有相同类型的效果存在想要覆盖就设为 true
     * @return 如果迷之炖菜的属性改变了则为 true
     */
    boolean addCustomEffect(@NotNull PotionEffect effect, boolean overwrite);

    /**
     * 移除这个迷之炖菜的一个自定义效果.
     * <p>
     * 原文:
     * Removes a custom potion effect from this suspicious stew.
     *
     * @param type 要移除的药水效果类型
     * @return 如果迷之炖菜的属性改变了则为 true
     */
    boolean removeCustomEffect(@NotNull PotionEffectType type);

    /**
     * 检查这个迷之炖菜是否有指定的药水效果.
     * <p>
     * 原文:
     * Checks for a specific custom potion effect type on this suspicious stew.
     *
     * @param type 要检查的药水效果
     * @return 存在此药水效果则返回 true
     */
    boolean hasCustomEffect(@NotNull PotionEffectType type);

    /**
     * 移除这个迷之炖菜的全部自定义药水效果.
     * <p>
     * 原文:
     * Removes all custom potion effects from this suspicious stew.
     *
     * @return 如果迷之炖菜的属性改变了则为 true
     */
    boolean clearCustomEffects();

    @Override
    SuspiciousStewMeta clone();
}
