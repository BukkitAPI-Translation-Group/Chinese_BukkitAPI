package org.bukkit.entity;

import java.util.Set;
import org.jetbrains.annotations.NotNull;

/**
 * 代表复杂生物 --- 由多种较小实体部分组成 (目前只有末影龙属于此行列).
 */
public interface ComplexLivingEntity extends LivingEntity {
    /**
     * 获取组成此复杂生物的实体部件.
     * <p>
     * 原文:Gets a list of parts that belong to this complex entity
     *
     * @return 组成此复杂生物的实体部件
     */
    @NotNull
    public Set<ComplexEntityPart> getParts();
}
