package org.bukkit.entity;

import java.util.UUID;

public interface AnimalTamer {

    /**
     * 这是指定的AnimalTamer的名称.
     * <p>
     * 原文:
     * This is the name of the specified AnimalTamer.
     *
     * @return 如果名称不能被引用，改名称可以引用被驯养的动物或为
     */
    public String getName();

    /**
     * 这是指定的AnimalTamer的UUID.
     * <p>
     * 原文:
     * This is the UUID of the specified AnimalTamer.
     *
     * @return AnimalTamer引用的UUID
     */
    public UUID getUniqueId();
}