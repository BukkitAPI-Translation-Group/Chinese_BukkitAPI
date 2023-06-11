package org.bukkit.entity;

/**
 * 代表幻翼.
 * <p>
 * 原文:
 * Represents a phantom.
 */
public interface Phantom extends Flying, Enemy {

    /**
     * @return 幻翼大小.
     */
    public int getSize();

    /**
     * @param sz 幻翼新大小.
     */
    public void setSize(int sz);
}
