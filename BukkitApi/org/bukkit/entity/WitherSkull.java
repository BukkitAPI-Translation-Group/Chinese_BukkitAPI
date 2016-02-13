package org.bukkit.entity;

/**
 * 代表凋零之首.
 * <p>
 * 有关凋零之首，请参阅 MineCraft 中文Wiki 上的<a href="http://minecraft-zh.gamepedia.com/%E5%87%8B%E9%9B%B6">凋零</a>部分.
 */
public interface WitherSkull extends Fireball {

    /**
     * 设置这个凋零之首是否充能.
     * <p>
     * 译注：凋零之首分为黑色的和蓝色的，难道BukkitAPI的编写者把蓝色的凋零之首认为是充能的凋零之首？目前尚未得到测试，无法证明此观点.下同.
     * <p>
     * 原文：Sets the charged status of the wither skull.
     *
     * @param charged 这个凋零之首是否充能
     */
    public void setCharged(boolean charged);

    /**
     * 获取这个凋零之首是否充能.
     * <p>
     * 原文：Gets whether or not the wither skull is charged.
     *
     * @return 这个凋零之首是否充能
     */
    public boolean isCharged();
}