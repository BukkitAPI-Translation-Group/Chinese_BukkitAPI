package org.bukkit.entity;

import org.bukkit.material.Colorable;

/**
 * 代表羊.
 */
public interface Sheep extends Animals, Colorable {

    /**
     * @return 羊是否被剪过毛.
     */
    public boolean isSheared();

    /**
     * @param flag 羊是否被剪过毛.
     */
    public void setSheared(boolean flag);
}