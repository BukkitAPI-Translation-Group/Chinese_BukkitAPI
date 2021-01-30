package org.bukkit.inventory.meta;

import org.bukkit.Location;
import org.jetbrains.annotations.Nullable;

/**
 * 代表能追踪指定位置的指南针.
 */
public interface CompassMeta extends ItemMeta {

    /**
     * 检测此指南针是否与某个磁石配对 (是否为磁石指针).
     * <p>
     * 原文:
     * Checks if this compass has been paired to a lodestone.
     *
     * @return 配对状态
     */
    boolean hasLodestone();

    /**
     * 获取指南针指向的位置.
     *
     * 调用本方法前先检查 {@link #hasLodestone()}!
     * <p>
     * 原文:
     * Gets the location that this compass will point to.
     *
     * Check {@link #hasLodestone()} first!
     *
     * @return 磁石位置
     */
    @Nullable
    Location getLodestone();

    /**
     * 设置指南针指向的位置.
     * <p>
     * 原文:
     * Sets the location this lodestone compass will point to.
     *
     * @param lodestone 新位置, 或 null 以清除位置
     */
    void setLodestone(@Nullable Location lodestone);

    /**
     * 获取指南针是否正追踪一个指定的磁石 (与磁石相绑定).
     *
     * 若为 true, 仅在追踪的位置有磁石时指南针才会正常工作.
     * <p>
     * 原文:
     * Gets if this compass is tracking a specific lodestone.
     *
     * If true the compass will only work if there is a lodestone at the tracked
     * location.
     *
     * @return 是否追踪磁石
     */
    boolean isLodestoneTracked();

    /**
     * 设置指南针是否正追踪一个指定的磁石.
     *
     * 若为 true, 仅在追踪的位置有磁石时指南针才会正常工作.
     * <p>
     * 原文:
     * Sets if this compass is tracking a specific lodestone.
     *
     * If true the compass will only work if there is a lodestone at the tracked
     * location.
     *
     * @param tracked 新的追踪状态
     */
    void setLodestoneTracked(boolean tracked);

    @Override
    CompassMeta clone();
}
