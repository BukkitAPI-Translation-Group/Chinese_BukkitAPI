package org.bukkit.inventory.meta;

import org.bukkit.Material;

/**
 * 代表{@link Material#SKULL_ITEM 头颅}.
 */
public interface SkullMeta extends ItemMeta {

    /**
     * 获取这个头颅的主人.
     * <p>
     * 原文：Gets the owner of the skull.
     *
     * @return 头颅的主人
     */
    String getOwner();

    /**
     * 检测这个头颅是否有主人.
     * <p>
     * 原文：Checks to see if the skull has an owner.
     *
     * @return true表示头颅有主人
     */
    boolean hasOwner();

    /**
     * 设置这个头颅的主人.
     * <p>
     * 插件应该在调用这个方法之前检测hasOwner()是否返回true.
     * <p>
     * 原文：Sets the owner of the skull.
     * <p>
     * Plugins should check that hasOwner() returns true before calling this
     * plugin.
     *
     * @param owner 头颅的新主人
     * @return 如果头颅主人成功被设置则为true
     */
    boolean setOwner(String owner);

    SkullMeta clone();
}