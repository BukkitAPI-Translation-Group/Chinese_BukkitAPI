package org.bukkit.entity;

/**
 * 代表史莱姆.
 */
public interface Slime extends Mob {

    /**
     * @return 史莱姆的大小
     */
    public int getSize();

    /**
     * @param sz 史莱姆新的大小.
     */
    public void setSize(int sz);
}