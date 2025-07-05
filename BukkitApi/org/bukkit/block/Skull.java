package org.bukkit.block;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.SkullType;
import org.bukkit.block.data.BlockData;
import org.bukkit.profile.PlayerProfile;
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
    @Deprecated(since = "1.9.4")
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
    @Deprecated(since = "1.9.4")
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
     * 获取拥有此头颅的玩家的资料. 此玩家资料所含的纹理取决于头颅类型.
     * <p>
     * 原文:Gets the profile of the player who owns the skull. This player profile
     * may appear as the texture depending on skull type.
     *
     * @return 头颅所有者的资料
     */
    @Nullable
    PlayerProfile getOwnerProfile();

    /**
     * 设置拥有此头颅的玩家的资料. 此玩家资料所含的纹理取决于头颅类型.
     * <p>
     * 此资料必须包含唯一 id 和皮肤纹理. 如果两者都缺, 则资料必须包含玩家名,
     * 服务器将利用玩家名来尝试查找其唯一 id 和皮肤纹理.
     * <p>
     * 原文:Sets the profile of the player who owns the skull. This player profile
     * may appear as the texture depending on skull type.
     * <p>
     * The profile must contain both a unique id and a skin texture. If either
     * of these is missing, the profile must contain a name by which the server
     * will then attempt to look up the unique id and skin texture.
     *
     * @param profile 头颅所有者的资料
     * @throws IllegalArgumentException 如果资料没有包含必要信息
     */
    void setOwnerProfile(@Nullable PlayerProfile profile);

    /**
     * Gets the sound to play if the skull is placed on a note block.
     * <br>
     * <strong>Note:</strong> This only works for player heads. For other heads,
     * see {@link org.bukkit.Instrument}.
     *
     * @return the key of the sound, or null
     */
    @Nullable
    public NamespacedKey getNoteBlockSound();

    /**
     * Sets the sound to play if the skull is placed on a note block.
     * <br>
     * <strong>Note:</strong> This only works for player heads. For other heads,
     * see {@link org.bukkit.Instrument}.
     *
     * @param noteBlockSound the key of the sound to be played, or null
     *
     */
    public void setNoteBlockSound(@Nullable NamespacedKey noteBlockSound);

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
    @Deprecated(since = "1.13")
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
    @Deprecated(since = "1.13")
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
    @Deprecated(since = "1.13")
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
    @Deprecated(since = "1.13")
    @Contract("_ -> fail")
    public void setSkullType(SkullType skullType);
}
