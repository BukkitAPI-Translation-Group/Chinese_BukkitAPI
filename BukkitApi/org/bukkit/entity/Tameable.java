package org.bukkit.entity;

import org.jetbrains.annotations.Nullable;

public interface Tameable extends Animals {

    /**
     * 检查是否已被驯服
     * <p>
     * 如果某物已被驯服，则玩家无法通过常规方法驯服它，即使它不属于任何特定玩家。
     *
     * @return 如果已被驯服则返回true
     * <p>
     * 原文：Check if this is tamed
     * <p>
     * If something is tamed then a player can not tame it through normal
     * methods, even if it does not belong to anyone in particular.
     *
     * @return true if this has been tamed
     */
    public boolean isTamed();

    /**
     * 设置是否已被驯服。如果已使用setOwner方法，则此方法不是必需的，因为它会自动驯服。
     * <p>
     * 如果某物已被驯服，则玩家无法通过常规方法驯服它，即使它不属于任何特定玩家。
     *
     * @param tame 如果为true则表示驯服
     * <p>
     * 原文：Sets if this has been tamed. Not necessary if the method setOwner has
     * been used, as it tames automatically.
     * <p>
     * If something is tamed then a player can not tame it through normal
     * methods, even if it does not belong to anyone in particular.
     *
     * @param tame true if tame
     */
    public void setTamed(boolean tame);

    /**
     * 获取当前所有者AnimalTamer
     *
     * @return 所有者AnimalTamer，如果没有所有者则返回null
     * <p>
     * 原文：Gets the current owning AnimalTamer
     *
     * @return the owning AnimalTamer, or null if not owned
     */
    @Nullable
    public AnimalTamer getOwner();

    /**
     * 设置此实体的所有者为给定的AnimalTamer。
     * <p>
     * 如果所有者不为null，则此实体将被驯服，并移除其当前跟随的路径。如果所有者设置为null，则此实体将被解除驯服，并移除当前所有者。
     *
     * @param tamer 应拥有此实体的AnimalTamer
     * <p>
     * 原文：Set this to be owned by given AnimalTamer.
     * <p>
     * If the owner is not null, this will be tamed and will have any current
     * path it is following removed. If the owner is set to null, this will be
     * untamed, and the current owner removed.
     *
     * @param tamer the AnimalTamer who should own this
     */
    public void setOwner(@Nullable AnimalTamer tamer);

}
