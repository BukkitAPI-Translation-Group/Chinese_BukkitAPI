package org.bukkit.packs;

import java.util.Collection;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.BlockType;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemType;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 数据包管理器.
 */
public interface DataPackManager {

    /**
     * 返回服务器上所有可用的{@link DataPack}.
     * <p>
     * 原文：
     * Return all the available {@link DataPack}s on the server.
     *
     * @return {@link DataPack}的集合
     */
    @NotNull
    public Collection<DataPack> getDataPacks();

    /**
     * 通过键获取{@link DataPack}.
     * <p>
     * 原文：
     * Gets a {@link DataPack} by its key.
     *
     * @param dataPackKey {@link DataPack}的键
     * @return {@link DataPack}, 如果不存在则返回null
     */
    @Nullable
    public DataPack getDataPack(@NotNull NamespacedKey dataPackKey);

    /**
     * 返回世界中所有启用的{@link DataPack}.
     * <p>
     * 原文：
     * Return all the enabled {@link DataPack} in the World.
     *
     * @param world 要搜索的世界
     * @return {@link DataPack}的集合
     */
    @NotNull
    public Collection<DataPack> getEnabledDataPacks(@NotNull World world);

    /**
     * 返回世界中所有禁用的{@link DataPack}.
     * <p>
     * 原文：
     * Return all the disabled {@link DataPack} in the World.
     *
     * @param world 要搜索的世界
     * @return {@link DataPack}的集合
     */
    @NotNull
    public Collection<DataPack> getDisabledDataPacks(@NotNull World world);

    /**
     * 获取Material是否在世界中被特性启用.
     * <p>
     * 原文：
     * Gets if the Material is enabled for use by the features in World.
     *
     * @param material 要检查的Material(需要是{@link Material#isItem()}或{@link Material#isBlock()})
     * @param world 要检查的世界
     * @return {@code True} 如果与material相关的物品/方块被启用
     */
    public boolean isEnabledByFeature(@NotNull Material material, @NotNull World world);

    /**
     * 获取ItemType是否在世界中被特性启用.
     * <p>
     * 原文：
     * Gets if the ItemType is enabled for use by the features in World.
     *
     * @param itemType 要检查的ItemType
     * @param world 要检查的世界
     * @return {@code True} 如果ItemType被启用
     * @apiNote 此方法尚未准备好公开使用
     */
    @ApiStatus.Internal
    public boolean isEnabledByFeature(@NotNull ItemType itemType, @NotNull World world);

    /**
     * 获取BlockType是否在世界中被特性启用.
     * <p>
     * 原文：
     * Gets if the BlockType is enabled for use by the features in World.
     *
     * @param blockType 要检查的BlockType
     * @param world 要检查的世界
     * @return {@code True} 如果BlockType被启用
     * @apiNote 此方法尚未准备好公开使用
     */
    @ApiStatus.Internal
    public boolean isEnabledByFeature(@NotNull BlockType blockType, @NotNull World world);

    /**
     * 获取EntityType是否在世界中被特性启用.
     * <p>
     * 原文：
     * Gets if the EntityType is enabled for use by the Features in World.
     *
     * @param entityType 要检查的EntityType
     * @param world 要检查的世界
     * @return {@code True} 如果实体类型被启用
     */
    public boolean isEnabledByFeature(@NotNull EntityType entityType, @NotNull World world);
}
