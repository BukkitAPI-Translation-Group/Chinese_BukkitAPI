package org.bukkit.inventory.meta;

import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.profile.PlayerProfile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表头颅.
 */
public interface SkullMeta extends ItemMeta {

    /**
     * 获取这个头颅的主人.
     * <p>
     * 原文:
     * Gets the owner of the skull.
     *
     * @return 头颅的主人
     * @deprecated 另请参阅 {@link #getOwningPlayer()}..
     */
    @Deprecated
    @Nullable
    String getOwner();

    /**
     * 检测这个头颅是否有主人.
     * <p>
     * 原文:
     * Checks to see if the skull has an owner.
     *
     * @return true 表示头颅有主人
     */
    boolean hasOwner();

    /**
     * 设置这个头颅的主人.
     * <p>
     * 原文:
     * Sets the owner of the skull.
     *
     * @param owner 头颅的新主人
     * @return 如果头颅主人成功被设置则为 true
     * @deprecated 另请参阅 {@link #setOwningPlayer(org.bukkit.OfflinePlayer)}.
     */
    @Deprecated
    boolean setOwner(@Nullable String owner);

    /**
     * 获取这个头颅的主人.
     * <p>
     * 原文:
     * Gets the owner of the skull.
     *
     * @return 头颅的主人
     */
    @Nullable
    OfflinePlayer getOwningPlayer();

    /**
     * 设置这个头颅的主人.
     * <p>
     * 插件应该在调用这个方法之前检查 hasOwner() 是否返回true.
     * <p>
     * 原文:
     * Sets the owner of the skull.
     * <p>
     * Plugins should check that hasOwner() returns true before calling this
     * plugin.
     *
     * @param owner 头颅的新主人
     * @return 如果头颅主人成功被设置则为 true
     */
    boolean setOwningPlayer(@Nullable OfflinePlayer owner);

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
     * Sets the sound to play if the skull is placed on a note block.
     * <br>
     * <strong>Note:</strong> This only works for player heads. For other heads,
     * see {@link org.bukkit.Instrument}.
     *
     * @param noteBlockSound the key of the sound to be played, or null
     */
    void setNoteBlockSound(@Nullable NamespacedKey noteBlockSound);

    /**
     * Gets the sound to play if the skull is placed on a note block.
     * <br>
     * <strong>Note:</strong> This only works for player heads. For other heads,
     * see {@link org.bukkit.Instrument}.
     *
     * @return the key of the sound, or null
     */
    @Nullable
    NamespacedKey getNoteBlockSound();

    @Override
    @NotNull
    SkullMeta clone();
}