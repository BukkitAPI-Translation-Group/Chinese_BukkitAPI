package org.bukkit.util;

import java.util.Objects;
import org.apache.commons.lang.Validate;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 射线追踪的命中结果.
 * <p>
 * 只有命中位置保证始终存在. 其他属性的存在性取决于命中的对象和执行射线跟踪的上下文.
 * <p>
 * 原文:
 * The hit result of a ray trace.
 * <p>
 * Only the hit position is guaranteed to always be available. The availability
 * of the other attributes depends on what got hit and on the context in which
 * the ray trace was performed.
 */
public class RayTraceResult {

    private final Vector hitPosition;

    private final Block hitBlock;
    private final BlockFace hitBlockFace;
    private final Entity hitEntity;

    private RayTraceResult(@NotNull Vector hitPosition, @Nullable Block hitBlock, @Nullable BlockFace hitBlockFace, @Nullable Entity hitEntity) {
        Validate.notNull(hitPosition, "Hit position is null!");
        this.hitPosition = hitPosition.clone();
        this.hitBlock = hitBlock;
        this.hitBlockFace = hitBlockFace;
        this.hitEntity = hitEntity;
    }

    /**
     * 创建一个射线跟踪器结果.
     * <p>
     * 原文:
     * Creates a RayTraceResult.
     *
     * @param hitPosition 命中位置
     */
    public RayTraceResult(@NotNull Vector hitPosition) {
        this(hitPosition, null, null, null);
    }

    /**
     * 创建一个射线跟踪器结果.
     * <p>
     * 原文:
     * Creates a RayTraceResult.
     *
     * @param hitPosition 命中位置
     * @param hitBlockFace 命中方块的方向
     */
    public RayTraceResult(@NotNull Vector hitPosition, @Nullable BlockFace hitBlockFace) {
        this(hitPosition, null, hitBlockFace, null);
    }

    /**
     * 创建一个射线跟踪器结果.
     * <p>
     * 原文:
     * Creates a RayTraceResult.
     *
     * @param hitPosition 命中位置
     * @param hitBlock 命中方块
     * @param hitBlockFace 命中方块的方向
     */
    public RayTraceResult(@NotNull Vector hitPosition, @Nullable Block hitBlock, @Nullable BlockFace hitBlockFace) {
        this(hitPosition, hitBlock, hitBlockFace, null);
    }

    /**
     * 创建一个射线跟踪器结果.
     * <p>
     * 原文:
     * Creates a RayTraceResult.
     *
     * @param hitPosition 命中位置
     * @param hitEntity 命中实体
     */
    public RayTraceResult(@NotNull Vector hitPosition, @Nullable Entity hitEntity) {
        this(hitPosition, null, null, hitEntity);
    }

    /**
     * 创建一个射线跟踪器结果.
     * <p>
     * 原文:
     * Creates a RayTraceResult.
     *
     * @param hitPosition 命中位置
     * @param hitEntity 命中实体
     * @param hitBlockFace 命中方块的方向
     */
    public RayTraceResult(@NotNull Vector hitPosition, @Nullable Entity hitEntity, @Nullable BlockFace hitBlockFace) {
        this(hitPosition, null, hitBlockFace, hitEntity);
    }

    /**
     * 获取命中的精确位置.
     * <p>
     * 原文:
     * Gets the exact position of the hit.
     *
     * @return 精确命中位置的副本
     */
    @NotNull
    public Vector getHitPosition() {
        return hitPosition.clone();
    }

    /**
     * 获取命中的方块.
     * <p>
     * 原文:
     * Gets the hit block.
     *
     * @return 命中的方块或<code>null</code>(如果不存在)
     */
    @Nullable
    public Block getHitBlock() {
        return hitBlock;
    }

    /**
     * 获取命中方块的方向.
     * <p>
     * 原文:
     * Gets the hit block face.
     *
     * @return 命中方块的方向或<code>null</code>(如果不存在)
     */
    @Nullable
    public BlockFace getHitBlockFace() {
        return hitBlockFace;
    }

    /**
     * 获取命中的实体.
     * <p>
     * 原文:
     * Gets the hit entity.
     *
     * @return 命中的实体或<code>null</code>(如果不存在)
     */
    @Nullable
    public Entity getHitEntity() {
        return hitEntity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + hitPosition.hashCode();
        result = prime * result + ((hitBlock == null) ? 0 : hitBlock.hashCode());
        result = prime * result + ((hitBlockFace == null) ? 0 : hitBlockFace.hashCode());
        result = prime * result + ((hitEntity == null) ? 0 : hitEntity.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RayTraceResult)) return false;
        RayTraceResult other = (RayTraceResult) obj;
        if (!hitPosition.equals(other.hitPosition)) return false;
        if (!Objects.equals(hitBlock, other.hitBlock)) return false;
        if (!Objects.equals(hitBlockFace, other.hitBlockFace)) return false;
        if (!Objects.equals(hitEntity, other.hitEntity)) return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RayTraceResult [hitPosition=");
        builder.append(hitPosition);
        builder.append(", hitBlock=");
        builder.append(hitBlock);
        builder.append(", hitBlockFace=");
        builder.append(hitBlockFace);
        builder.append(", hitEntity=");
        builder.append(hitEntity);
        builder.append("]");
        return builder.toString();
    }
}
