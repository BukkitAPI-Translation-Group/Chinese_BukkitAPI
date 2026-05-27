package org.bukkit.event.world;

import org.bukkit.World;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.generator.structure.Structure;
import org.bukkit.util.BoundingBox;
import org.jetbrains.annotations.NotNull;

/**
 * 当 {@link Structure} 在世界中自然生成时触发。
 */
public class AsyncStructureSpawnEvent extends WorldEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled = false;

    private final Structure structure;
    private final BoundingBox boundingBox;

    private final int chunkX, chunkZ;

    public AsyncStructureSpawnEvent(@NotNull World world, @NotNull Structure structure, @NotNull BoundingBox boundingBox, int chunkX, int chunkZ) {
        super(world, true);
        this.structure = structure;
        this.boundingBox = boundingBox;
        this.chunkX = chunkX;
        this.chunkZ = chunkZ;
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
        return boundingBox;
    }

    /**
     * 获取结构起始区块的 x 坐标。
     *
     * <b>注意，尝试检索或与此区块交互是不安全的。此事件仅供参考！</b>
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
     * <b>注意，尝试检索或与此区块交互是不安全的。此事件仅供参考！</b>
     *
     * @return 区块的 z 坐标
     * <p>原文：Get the z coordinate of the origin chunk of the structure.
     */
    public int getChunkZ() {
        return chunkZ;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
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
