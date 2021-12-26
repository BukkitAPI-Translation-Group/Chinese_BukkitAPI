package org.bukkit.entity;


/**
 * 守卫海底遗迹的守卫者们.
 */
public interface Guardian extends Monster {

    /**
     * Sets whether the guardian laser should show or not.
     *
     * A target must be present. If no target is present the laser will not show
     * and the method will return false.
     *
     * @param activated whether the laser is active
     * @return true if the laser was activated otherwise false
     * @see #getTarget()
     * @see #setTarget(LivingEntity)
     */
    boolean setLaser(boolean activated);

    /**
     * Gets whether the guardian laser is active or not.
     *
     * @return true if the laser is active otherwise false
     */
    boolean hasLaser();

    /**
     * 检测此守卫者是否为远古守卫者.
     * <p>
     * 原文:Check if the Guardian is an elder Guardian
     *
     * @return 此守卫者是否为远古守卫者
     * @deprecated 应检测此实例是否为{@link ElderGuardian} (entity instanceof ElderGuardian)
     */
    @Deprecated
    public boolean isElder();

    /**
     * @param shouldBeElder shouldBeElder
     * @deprecated <b>必须</b>生成新的 {@link ElderGuardian}
     */
    @Deprecated
    public void setElder(boolean shouldBeElder);
}
