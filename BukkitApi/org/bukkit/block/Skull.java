package org.bukkit.block;

import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.SkullType;
import org.bukkit.block.data.BlockData;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表头颅.
 */
public interface Skull extends TileState {

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
     * @return 头颅主人的名字，如果此头颅没有主人将返回null
     * @deprecated 请查阅 {@link #getOwningPlayer()}.
     */
    @Deprecated
    @Nullable
    public String getOwner();

    /**
     * 设置头颅的主人.
     * <p>
     * 根据提供的名称获取配置文件数据时涉及一个可能的阻塞式Web请求.
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
    @Contract("null -> false")
    public boolean setOwner(@Nullable String name);

    /**
     * 获取拥有此头颅的玩家. 该头颅可能显示出玩家皮肤的头部, 这取决于头颅的类型.
     * <p>
     * 原文:Get the player which owns the skull. This player may appear as the
     * texture depending on skull type.
     *
     * @return 头颅所有者
     */
    @Nullable
    public OfflinePlayer getOwningPlayer();

    /**
     * 设置拥有此头颅的玩家. 该头颅可能显示出玩家皮肤的头部, 这取决于头颅的类型.
     * <p>
     * 原文:Set the player which owns the skull. This player may appear as the
     * texture depending on skull type.
     *
     * @param player 头颅所有者
     */
    public void setOwningPlayer(@NotNull OfflinePlayer player);

    /**
     * 获取这个头颅在世界的角度 (或头颅的朝向如果这个头颅被挂在墙上).
     * <p>
     * 原文:
     * Gets the rotation of the skull in the world (or facing direction if this
     * is a wall mounted skull).
     *
     * @return 头颅的角度
     * @deprecated 请使用 {@link BlockData}
     */
    @Deprecated
    @NotNull
    public BlockFace getRotation();

    /**
     * 设置这个头颅在世界的角度 (或头颅的朝向如果这个头颅被挂在墙上).
     * <p>
     * 原文:
     * Sets the rotation of the skull in the world (or facing direction if this
     * is a wall mounted skull).
     *
     * @param rotation 头颅的角度
     * @deprecated 请使用 {@link BlockData}
     */
    @Deprecated
    public void setRotation(@NotNull BlockFace rotation);

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
    @NotNull
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
    @Contract("_ -> fail")
    public void setSkullType(SkullType skullType);
}
