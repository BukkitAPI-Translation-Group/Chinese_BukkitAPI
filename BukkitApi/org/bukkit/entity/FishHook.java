package org.bukkit.entity;

/**
 * 代表一个鱼钩.
 * <p>
 * 原文:
 * Represents a fishing hook.
 */
public interface FishHook extends Projectile {
    /**
     * 获取鱼咬钩的几率.
     * <p>
     * 0.0 = 永不上钩.<br>
     * 1.0 = 立即咬钩.
     * <p>
     * 原文:
     * Gets the chance of a fish biting.
     * <p>
     * 0.0 = No Chance.<br>
     * 1.0 = Instant catch.
     *
     * @return chance 咬钩几率
     * @deprecated Minecraft新版本中已无效果
     */
    @Deprecated
    public double getBiteChance();

    /**
     * Sets the chance of a fish biting.
     * <p>
     * 0.0 = No Chance.<br>
     * 1.0 = Instant catch.
     *
     * @param chance the bite chance
     * @throws IllegalArgumentException if the bite chance is not between 0
     *     and 1
     * @deprecated has no effect in newer Minecraft versions
     */
    @Deprecated
    public void setBiteChance(double chance) throws IllegalArgumentException;
}
