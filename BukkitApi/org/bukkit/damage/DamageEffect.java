package org.bukkit.damage;

import com.google.common.base.Preconditions;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.jetbrains.annotations.NotNull;

/**
 * 代表造成伤害时发生的效果类型. 目前, 效果仅决定播放的声音.
 */
public interface DamageEffect {

    /**
     * 默认的伤害效果.
     */
    public static final DamageEffect HURT = getDamageEffect("hurt");
    /**
     * 荆棘.
     */
    public static final DamageEffect THORNS = getDamageEffect("thorns");
    /**
     * 溺水.
     */
    public static final DamageEffect DROWNING = getDamageEffect("drowning");
    /**
     * 单次燃烧刻(火焰、岩浆等).
     */
    public static final DamageEffect BURNING = getDamageEffect("burning");
    /**
     * 被浆果丛刺伤.
     */
    public static final DamageEffect POKING = getDamageEffect("poking");
    /**
     * 冻结刻(细雪).
     */
    public static final DamageEffect FREEZING = getDamageEffect("freezing");

    @NotNull
    private static DamageEffect getDamageEffect(@NotNull String key) {
        return Preconditions.checkNotNull(Bukkit.getUnsafe().getDamageEffect(key), "No DamageEffect found for %s. This is a bug.", key);
    }

    /**
     * 获取此{@link DamageEffect}播放的{@link Sound}.
     * <p>
     * 原文：
     * Get the {@link Sound} played for this {@link DamageEffect}.
     *
     * @return 声音
     */
    @NotNull
    public Sound getSound();
}
