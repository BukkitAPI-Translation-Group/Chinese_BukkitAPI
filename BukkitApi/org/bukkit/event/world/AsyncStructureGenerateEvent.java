package org.bukkit.event.world;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.event.HandlerList;
import org.bukkit.generator.structure.Structure;
import org.bukkit.util.BlockTransformer;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.EntityTransformer;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 此事件有时会同步触发，取决于其触发方式。
 * <p>
 * 构造函数提供了一个布尔值来指示事件是同步还是异步触发的。当异步触发时，此事件可以从除主线程外的任意线程调用，并且对 API 的访问是受限的。
 * <p>
 * 如果 {@link Structure} 是在世界区块中自然生成的，则此事件将是异步的。如果玩家执行了 '/place structure' 命令，则此事件将是同步的。
 *
 * 允许注册可以修改结构放置的方块和生成的实体的转换器。
 * <p>
 * 应注意检查 {@link #isAsynchronous()} 并适当地处理事件。
 */
@ApiStatus.Experimental
public class AsyncStructureGenerateEvent extends WorldEvent {

    public static enum Cause {
        COMMAND,
        WORLD_GENERATION,
        CUSTOM;
    }

    private static final HandlerList handlers = new HandlerList();

    private final Cause cause;

    private final Structure structure;
    private final BoundingBox boundingBox;

    private final int chunkX, chunkZ;

    private final Map<NamespacedKey, BlockTransformer> blockTransformers = new LinkedHashMap<>();
    private final Map<NamespacedKey, EntityTransformer> entityTransformers = new LinkedHashMap<>();

    public AsyncStructureGenerateEvent(@NotNull World world, boolean async, @NotNull Cause cause, @NotNull Structure structure, @NotNull BoundingBox boundingBox, int chunkX, int chunkZ) {
        super(world, async);
        this.structure = structure;
        this.boundingBox = boundingBox;
        this.chunkX = chunkX;
        this.chunkZ = chunkZ;
        this.cause = cause;
    }

    /**
     * 获取事件原因。
     *
     * @return 事件原因
     * <p>原文：Gets the event cause.
     */
    @NotNull
    public Cause getCause() {
        return cause;
    }

    /**
     * 通过键获取方块转换器。
     *
     * @param key 方块转换器的键
     *
     * @return 方块转换器或 null
     * <p>原文：Gets a block transformer by key.
     */
    @Nullable
    public BlockTransformer getBlockTransformer(@NotNull NamespacedKey key) {
        Preconditions.checkNotNull(key, "NamespacedKey cannot be null");
        return blockTransformers.get(key);
    }

    /**
     * 将方块转换器设置到指定键。
     *
     * @param key 键
     * @param transformer 方块转换器
     * <p>原文：Sets a block transformer to a key.
     */
    public void setBlockTransformer(@NotNull NamespacedKey key, @NotNull BlockTransformer transformer) {
        Preconditions.checkNotNull(key, "NamespacedKey cannot be null");
        Preconditions.checkNotNull(transformer, "BlockTransformer cannot be null");
        blockTransformers.put(key, transformer);
    }

    /**
     * 移除一个方块转换器。
     *
     * @param key 方块转换器的键
     * <p>原文：Removes a block transformer.
     */
    public void removeBlockTransformer(@NotNull NamespacedKey key) {
        Preconditions.checkNotNull(key, "NamespacedKey cannot be null");
        blockTransformers.remove(key);
    }

    /**
     * 移除所有方块转换器。
     * <p>原文：Removes all block transformers.
     */
    public void clearBlockTransformers() {
        blockTransformers.clear();
    }

    /**
     * 获取所有方块转换器的不可修改映射。
     *
     * @return 方块转换器的映射
     * <p>原文：Gets all block transformers in a unmodifiable map.
     */
    @NotNull
    public Map<NamespacedKey, BlockTransformer> getBlockTransformers() {
        return Collections.unmodifiableMap(blockTransformers);
    }

    /**
     * 通过键获取实体转换器。
     *
     * @param key 实体转换器的键
     *
     * @return 实体转换器或 null
     * <p>原文：Gets a entity transformer by key.
     */
    @Nullable
    public EntityTransformer getEntityTransformer(@NotNull NamespacedKey key) {
        Preconditions.checkNotNull(key, "NamespacedKey cannot be null");
        return entityTransformers.get(key);
    }

    /**
     * 将实体转换器设置到指定键。
     *
     * @param key 键
     * @param transformer 实体转换器
     * <p>原文：Sets a entity transformer to a key.
     */
    public void setEntityTransformer(@NotNull NamespacedKey key, @NotNull EntityTransformer transformer) {
        Preconditions.checkNotNull(key, "NamespacedKey cannot be null");
        Preconditions.checkNotNull(transformer, "EntityTransformer cannot be null");
        entityTransformers.put(key, transformer);
    }

    /**
     * 移除一个实体转换器。
     *
     * @param key 实体转换器的键
     * <p>原文：Removes a entity transformer.
     */
    public void removeEntityTransformer(@NotNull NamespacedKey key) {
        Preconditions.checkNotNull(key, "NamespacedKey cannot be null");
        entityTransformers.remove(key);
    }

    /**
     * 移除所有实体转换器。
     * <p>原文：Removes all entity transformers.
     */
    public void clearEntityTransformers() {
        entityTransformers.clear();
    }

    /**
     * 获取所有实体转换器的不可修改映射。
     *
     * @return 实体转换器的映射
     * <p>原文：Gets all entity transformers in a unmodifiable map.
     */
    @NotNull
    public Map<NamespacedKey, EntityTransformer> getEntityTransformers() {
        return Collections.unmodifiableMap(entityTransformers);
    }

    /**
     * 获取生成的结构引用。
     *
     * @return 结构
     * <p>原文：Get the structure reference that is generated.
     */
    @NotNull
    public Structure getStructure() {
        return structure;
    }

    /**
     * 获取结构的边界框。
     *
     * @return 边界框
     * <p>原文：Get the bounding box of the structure.
     */
    @NotNull
    public BoundingBox getBoundingBox() {
        return boundingBox.clone();
    }

    /**
     * 获取结构起始区块的 x 坐标。
     *
     * @return 区块的 x 坐标
     * <p>原文：Get the x coordinate of the origin chunk of the structure.
     */
    public int getChunkX() {
        return chunkX;
    }

    /**
     * 获取结构起始区块的 z 坐标。
     *
     * @return 区块的 z 坐标
     * <p>原文：Get the z coordinate of the origin chunk of the structure.
     */
    public int getChunkZ() {
        return chunkZ;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
