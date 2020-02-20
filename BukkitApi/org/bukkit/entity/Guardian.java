package org.bukkit.entity;


/**
 * 守卫海底遗迹的守卫者们.
 */
public interface Guardian extends Monster {

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
