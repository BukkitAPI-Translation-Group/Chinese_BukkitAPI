package org.bukkit.entity;

/**
 * 代表 {@link ComplexLivingEntity} 的一部分.
 * <p>
 * 原文:
 * Represents a single part of a {@link ComplexLivingEntity}
 */
public interface ComplexEntityPart extends Entity {

    /**
     * 获得此组件的父对象 {@link ComplexLivingEntity}
     * <p>
     * 原文:
     * Gets the parent {@link ComplexLivingEntity} of this part.
     *
     * @return Parent 复杂实体
     */
    public ComplexLivingEntity getParent();
}
