package org.bukkit.entity;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * This interface defines or represents the abstract concept of skeleton-like
 * entities on the server. The interface is hence not a direct representation
 * of an entity but rather serves as a parent to interfaces/entity types like
 * {@link Skeleton}, {@link WitherSkeleton} or {@link Stray}.
 *
 * To compute what specific type of skeleton is present in a variable/field
 * of this type, instanceOf checks against the specific subtypes listed prior
 * are recommended.
 */
public interface AbstractSkeleton extends Monster {

    /**
     * 获取骷髅当前的种类.
     * <p>
     * 原文:Gets the current type of this skeleton.
     *
     * @return 当前的种类
     * @deprecated 应检查这是什么类实例
     */
    @Deprecated
    @NotNull
    public Skeleton.SkeletonType getSkeletonType();

    /**
     * @param type 种类
     * @deprecated Must spawn a new subtype variant
     */
    @Deprecated
    @Contract("_ -> fail")
    public void setSkeletonType(Skeleton.SkeletonType type);
}
