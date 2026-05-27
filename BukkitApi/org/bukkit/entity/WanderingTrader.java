package org.bukkit.entity;

/**
 * 表示流浪商人NPC
 */
public interface WanderingTrader extends AbstractVillager {

    /**
     * 获取此{@link WanderingTrader}被强制消失前的消失延迟。
     *
     * 如果此值小于或等于0，则商人不会消失。
     *
     * @return 此{@link WanderingTrader}被强制消失前的消失延迟
     * <p>
     * 原文：Gets the despawn delay before this {@link WanderingTrader} is forcibly
     * despawned.
     *
     * If this is less than or equal to 0, then the trader will not be
     * despawned.
     *
     * @return The despawn delay before this {@link WanderingTrader} is forcibly
     * despawned
     */
    public int getDespawnDelay();

    /**
     * 设置此{@link WanderingTrader}被强制消失前的消失延迟。
     *
     * 如果此值小于或等于0，则商人不会消失。
     *
     * @param despawnDelay 此{@link WanderingTrader}被强制消失前的新消失延迟
     * <p>
     * 原文：Sets the despawn delay before this {@link WanderingTrader} is forcibly
     * despawned.
     *
     * If this is less than or equal to 0, then the trader will not be
     * despawned.
     *
     * @param despawnDelay The new despawn delay before this
     * {@link WanderingTrader} is forcibly despawned
     */
    public void setDespawnDelay(int despawnDelay);
}
