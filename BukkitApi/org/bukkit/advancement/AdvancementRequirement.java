package org.bukkit.advancement;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface AdvancementRequirement {

    /**
     * 获取所有必需的条件.
     * <p>
     * 原文：
     * Get all required criteria.
     *
     * @return 此需求的必需条件列表.
     */
    @NotNull
    List<String> getRequiredCriteria();

    /**
     * 检查需求是否为严格模式.
     * <p>
     * 原文：
     * Check if the requirement is strict.
     *
     * @return 如果需求列表包含一个条件则返回true, 多个则返回false.
     */
    boolean isStrict();
}
