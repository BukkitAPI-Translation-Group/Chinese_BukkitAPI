package org.bukkit.structure;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import org.bukkit.Location;
import org.bukkit.RegionAccessor;
import org.bukkit.block.structure.Mirror;
import org.bukkit.block.structure.StructureRotation;
import org.bukkit.entity.Entity;
import org.bukkit.persistence.PersistentDataHolder;
import org.bukkit.util.BlockTransformer;
import org.bukkit.util.BlockVector;
import org.bukkit.util.EntityTransformer;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * 表示一个结构。
 * <p>
 * 结构是一个可变的模板，包含已捕获的方块和实体，可以复制回世界中。
 * 通过 {@link org.bukkit.Server#getStructureManager()} 获取的 {@link StructureManager}
 * 允许你创建新结构、加载现有结构和保存结构。
 * <p>
 * 为了使结构能被结构方块使用，需要在 {@link StructureManager} 中
 * {@link StructureManager#registerStructure(org.bukkit.NamespacedKey, Structure) 注册}，
 * 或者位于主世界文件夹、数据包或服务器自身的默认资源中，以便 StructureManager 能找到它。
 */
public interface Structure extends PersistentDataHolder {

    /**
     * 获取结构的当前尺寸。
     * <p>
     * 原文：
     * Gets the current size of the structure.
     * <p>
     * The size of the structure may not be fixed.
     *
     * @return 表示结构沿各轴尺寸的新向量。
     */
    @NotNull
    BlockVector getSize();

    /**
     * 获取可用的方块调色板列表。
     * <p>
     * 原文：
     * Gets a list of available block palettes.
     *
     * @return 此结构的可用变体列表。
     */
    @NotNull
    List<Palette> getPalettes();

    /**
     * 获取此结构中调色板的数量。
     * <p>
     * 原文：
     * Gets the number of palettes in this structure.
     *
     * @return 此结构中调色板的数量。
     */
    int getPaletteCount();

    /**
     * 获取已包含在结构中的实体列表。
     * <p>
     * 原文：
     * Gets a list of entities that have been included in the Structure.
     *
     * The entity positions are offsets relative to the structure's position
     * that is provided once the structure is placed into the world.
     *
     * @return 包含在结构中的实体列表。
     */
    @NotNull
    List<Entity> getEntities();

    /**
     * 获取此结构中实体的数量。
     * <p>
     * 原文：
     * Gets the number of entities in this structure.
     *
     * @return 此结构中实体的数量。
     */
    int getEntityCount();

    /**
     * 将结构放置到世界中。
     * <p>
     * 原文：
     * Place a structure in the world.
     *
     * @param location 放置结构的位置。
     * @param includeEntities 是否生成结构中存在的实体。
     * @param structureRotation 结构的旋转。
     * @param mirror 结构的镜像设置。
     * @param palette 要使用的结构调色板索引，从 {@code 0} 开始，或使用 {@code -1} 随机选择调色板。
     * @param integrity 通过随机跳过放置方块来决定建筑的损坏程度。此值范围为 0 到 1。
     *                  0 表示移除所有方块，1 表示以原始状态生成结构。
     * @param random 用于设置结构 {@link org.bukkit.loot.LootTable} 和完整性的随机数生成器。
     */
    void place(@NotNull Location location, boolean includeEntities, @NotNull StructureRotation structureRotation, @NotNull Mirror mirror, int palette, float integrity, @NotNull Random random);

    /**
     * 将结构放置到世界中。
     * <p>
     * 原文：
     * Place a structure in the world.
     *
     * @param location 放置结构的位置。
     * @param includeEntities 是否生成结构中存在的实体。
     * @param structureRotation 结构的旋转。
     * @param mirror 结构的镜像设置。
     * @param palette 要使用的结构调色板索引，从 {@code 0} 开始，或使用 {@code -1} 随机选择调色板。
     * @param integrity 通过随机跳过放置方块来决定建筑的损坏程度。此值范围为 0 到 1。
     *                  0 表示移除所有方块，1 表示以原始状态生成结构。
     * @param random 用于设置结构 {@link org.bukkit.loot.LootTable} 和完整性的随机数生成器。
     * @param blockTransformers 应用于结构的 {@link BlockTransformer} 集合。
     * @param entityTransformers 应用于结构的 {@link EntityTransformer} 集合。
     */
    @ApiStatus.Experimental
    void place(@NotNull Location location, boolean includeEntities, @NotNull StructureRotation structureRotation, @NotNull Mirror mirror, int palette, float integrity, @NotNull Random random, @NotNull Collection<BlockTransformer> blockTransformers, @NotNull Collection<EntityTransformer> entityTransformers);

    /**
     * 将结构放置到世界中。
     * <p>
     * 原文：
     * Place a structure in the world.
     *
     * @param regionAccessor 要放置结构的世界。
     * @param location 放置结构的位置。
     * @param includeEntities 是否生成结构中存在的实体。
     * @param structureRotation 结构的旋转。
     * @param mirror 结构的镜像设置。
     * @param palette 要使用的结构调色板索引，从 {@code 0} 开始，或使用 {@code -1} 随机选择调色板。
     * @param integrity 通过随机跳过放置方块来决定建筑的损坏程度。此值范围为 0 到 1。
     *                  0 表示移除所有方块，1 表示以原始状态生成结构。
     * @param random 用于设置结构 {@link org.bukkit.loot.LootTable} 和完整性的随机数生成器。
     */
    void place(@NotNull RegionAccessor regionAccessor, @NotNull BlockVector location, boolean includeEntities, @NotNull StructureRotation structureRotation, @NotNull Mirror mirror, int palette, float integrity, @NotNull Random random);

    /**
     * 将结构放置到世界中。
     * <p>
     * 原文：
     * Place a structure in the world.
     *
     * @param regionAccessor 要放置结构的世界。
     * @param location 放置结构的位置。
     * @param includeEntities 是否生成结构中存在的实体。
     * @param structureRotation 结构的旋转。
     * @param mirror 结构的镜像设置。
     * @param palette 要使用的结构调色板索引，从 {@code 0} 开始，或使用 {@code -1} 随机选择调色板。
     * @param integrity 通过随机跳过放置方块来决定建筑的损坏程度。此值范围为 0 到 1。
     *                  0 表示移除所有方块，1 表示以原始状态生成结构。
     * @param random 用于设置结构 {@link org.bukkit.loot.LootTable} 和完整性的随机数生成器。
     * @param blockTransformers 应用于结构的 {@link BlockTransformer} 集合。
     * @param entityTransformers 应用于结构的 {@link EntityTransformer} 集合。
     */
    @ApiStatus.Experimental
    void place(@NotNull RegionAccessor regionAccessor, @NotNull BlockVector location, boolean includeEntities, @NotNull StructureRotation structureRotation, @NotNull Mirror mirror, int palette, float integrity, @NotNull Random random, @NotNull Collection<BlockTransformer> blockTransformers, @NotNull Collection<EntityTransformer> entityTransformers);

    /**
     * 从世界中的一个区域填充结构。原点和尺寸将根据提供的两个角自动计算。
     * <p>
     * 原文：
     * Fills the structure from an area in a world. The origin and size will be
     * calculated automatically from the two corners provided.
     * <p>
     * Be careful as this will override the current data of the structure.
     * <p>
     * Be aware that this method allows for creating structures larger than the
     * 48x48x48 size that Minecraft's Structure blocks support. Any structures
     * saved this way can not be loaded by using a structure block. Using the
     * API however will still work.
     *
     * @param corner1 结构的一个角。
     * @param corner2 与 corner1 相对的角。
     * @param includeEntities 是否在保存的结构中包含实体。
     */
    void fill(@NotNull Location corner1, @NotNull Location corner2, boolean includeEntities);

    /**
     * 从世界中的一个区域填充结构，从指定的原点开始，沿各轴按指定的尺寸向量扩展。
     * <p>
     * 原文：
     * Fills the Structure from an area in a world, starting at the specified
     * origin and extending in each axis according to the specified size vector.
     * <p>
     * Be careful as this will override the current data of the structure.
     * <p>
     * Be aware that this method allows for saving structures larger than the
     * 48x48x48 size that Minecraft's Structure blocks support. Any structures
     * saved this way can not be loaded by using a structure block. Using the
     * API however will still work.
     *
     * @param origin 结构的原点。
     * @param size 结构的尺寸，必须至少为 1x1x1。
     * @param includeEntities 是否在保存的结构中包含实体。
     * @throws IllegalArgumentException 如果尺寸小于 1x1x1 则抛出异常。
     */
    void fill(@NotNull Location origin, @NotNull BlockVector size, boolean includeEntities);
}
