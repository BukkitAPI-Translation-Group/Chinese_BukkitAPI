package org.bukkit;

public interface Nameable {

    /**
     * 获取生物或方块的自定义名称，若无则返回null.
     * <p>
     * 这个方法对玩家没有作用，玩家将一直使用他们的真名.
     * <p>
     * 原文：
     * <p>
     * Gets the custom name on a mob or block. If there is no name this method
     * will return null.
     * <p>
     * This value has no effect on players, they will always use their real
     * name.
     *
     * @return 生物或方块的自定义名称（若无则返回null）
     */
    public String getCustomName();

    /**
     * 设置生物或方块的自定义名称，该名称可被用于死亡信息，且能作为生物头顶的标签内容被发送到客户端.
     * <p> 
     * 设置为空字符串或者null将会清除该生物或方块的自定义名称.
     * <p>
     * 这个方法对玩家没有作用，玩家将一直使用他们的真名.
     * <p>
     * 原文：
     * <p>
     * Sets a custom name on a mob or block. This name will be used in death
     * messages and can be sent to the client as a nameplate over the mob.
     * <p>
     * Setting the name to null or an empty string will clear it.
     * <p>
     * This value has no effect on players, they will always use their real
     * name.
     *
     * @param name 自定义名称
     */
    public void setCustomName(String name);
}
