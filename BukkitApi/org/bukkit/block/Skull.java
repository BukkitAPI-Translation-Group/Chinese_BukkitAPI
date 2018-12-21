package org.bukkit.block;

import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.SkullType;
import org.bukkit.block.data.BlockData;

/**
 * 代表一个头颅(快照).
 */
public interface Skull extends BlockState {

    /**
     * 检测此头颅是否有主人.
     * <p>
     * 原文:
     * Checks to see if the skull has an owner
     *
     * @return true表示此头颅有主人
     */
    public boolean hasOwner();

    /**
     * 如果存在，获取这个头颅的主人.
     * <p>
     * 原文:
     * Gets the owner of the skull, if one exists
     *
     * @return 头颅主人的名字，如果此透露没有主人将返回null
     * @deprecated 请查阅 {@link #getOwningPlayer()}.
     */
    @Deprecated
    public String getOwner();

    /**
     * 设置头颅的主人.
     * <p>
     * 提供的名称的配置文件数据涉及一个存在阻塞的Web请求.
     * <p>
     * 原文:
     * Sets the owner of the skull
     * <p>
     * Involves a potentially blocking web request to acquire the profile data for
     * the provided name.
     *
     * @param name 新的头颅主人的名字
     * @return true表示成功设置这个头颅的主人
     * @deprecated 请查阅 {@link #setOwningPlayer(org.bukkit.OfflinePlayer)}.
     */
    @Deprecated
    public boolean setOwner(String name);

    /**
     * Get the player which owns the skull. This player may appear as the
     * texture depending on skull type.
     *
     * @return owning player
     */
    public OfflinePlayer getOwningPlayer();

    /**
     * Set the player which owns the skull. This player may appear as the
     * texture depending on skull type.
     *
     * @param player the owning player
     */
    public void setOwningPlayer(OfflinePlayer player);

    /**
     * 获取这个头颅在世界的角度 (or facing direction if this
     * is a wall mounted skull).
     * <p>
     * 原文:
     * Gets the rotation of the skull in the world (or facing direction if this
     * is a wall mounted skull).
     *
     * @return 头颅的角度
     * @deprecated 请使用 {@link BlockData}
     */
    @Deprecated
    public BlockFace getRotation();

    /**
     * 设置这个头颅在世界的角度 (or facing direction if this
     * is a wall mounted skull).
     * <p>
     * 原文:
     * Sets the rotation of the skull in the world (or facing direction if this
     * is a wall mounted skull).
     *
     * @param rotation 头颅的角度
     * @deprecated 请使用 {@link BlockData}
     */
    @Deprecated
    public void setRotation(BlockFace rotation);

    /**
     * 获取头颅的类型.
     * <p>
     * 原文:
     * Gets the type of skull
     *
     * @return 头颅的类型
     * @deprecated 请检查 {@link Material} 类型
     */
    @Deprecated
    public SkullType getSkullType();

    /**
     * 设置头颅的类型.
     * <p>
     * 原文:
     * Sets the type of skull
     *
     * @param skullType 头颅的类型
     * @deprecated 请检查 {@link Material} 类型
     */
    @Deprecated
    public void setSkullType(SkullType skullType);
}
