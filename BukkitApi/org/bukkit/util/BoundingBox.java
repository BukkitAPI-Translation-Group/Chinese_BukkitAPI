package org.bukkit.util;

import com.google.common.base.Preconditions;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 可变轴对齐边界框（AABB）。
 * <p>
 * 这基本上表示一个矩形框（由最小和最大角指定），可用于描述对象（如实体、方块或矩形区域）在 3D 空间中的位置和范围。其边缘和面与笛卡尔坐标系的轴平行。
 * <p>
 * 边界框可能是退化的（一个或多个边的长度为 0）。
 * <p>
 * 由于边界框是可变的，如果以后修改它们，长期存储可能会很危险。如果您想保留边界框，调用 {@link #clone()} 获取副本可能是明智的。
 */
@SerializableAs("BoundingBox")
public class BoundingBox implements Cloneable, ConfigurationSerializable {

    /**
     * 使用给定向量的坐标作为角创建新的边界框。
     * <p>
     * 原文：
     * Creates a new bounding box using the coordinates of the given vectors as
     * corners.
     *
     * @param corner1 第一个角
     * @param corner2 第二个角
     * @return 边界框
     */
    @NotNull
    public static BoundingBox of(@NotNull Vector corner1, @NotNull Vector corner2) {
        Preconditions.checkArgument(corner1 != null, "Corner1 is null!");
        Preconditions.checkArgument(corner2 != null, "Corner2 is null!");
        return new BoundingBox(corner1.getX(), corner1.getY(), corner1.getZ(), corner2.getX(), corner2.getY(), corner2.getZ());
    }

    /**
     * 使用给定位置的坐标作为角创建新的边界框。
     * <p>
     * 原文：
     * Creates a new bounding box using the coordinates of the given locations
     * as corners.
     *
     * @param corner1 第一个角
     * @param corner2 第二个角
     * @return 边界框
     */
    @NotNull
    public static BoundingBox of(@NotNull Location corner1, @NotNull Location corner2) {
        Preconditions.checkArgument(corner1 != null, "Corner1 is null!");
        Preconditions.checkArgument(corner2 != null, "Corner2 is null!");
        Preconditions.checkArgument(Objects.equals(corner1.getWorld(), corner2.getWorld()), "Locations from different worlds!");
        return new BoundingBox(corner1.getX(), corner1.getY(), corner1.getZ(), corner2.getX(), corner2.getY(), corner2.getZ());
    }

    /**
     * 使用给定方块的坐标作为角创建新的边界框。
     * <p>
     * 边界框的大小将完全包含两个方块。
     * <p>
     * 原文：
     * Creates a new bounding box using the coordinates of the given blocks as
     * corners.
     * <p>
     * The bounding box will be sized to fully contain both blocks.
     *
     * @param corner1 第一个角方块
     * @param corner2 第二个角方块
     * @return 边界框
     */
    @NotNull
    public static BoundingBox of(@NotNull Block corner1, @NotNull Block corner2) {
        Preconditions.checkArgument(corner1 != null, "Corner1 is null!");
        Preconditions.checkArgument(corner2 != null, "Corner2 is null!");
        Preconditions.checkArgument(Objects.equals(corner1.getWorld(), corner2.getWorld()), "Blocks from different worlds!");

        int x1 = corner1.getX();
        int y1 = corner1.getY();
        int z1 = corner1.getZ();
        int x2 = corner2.getX();
        int y2 = corner2.getY();
        int z2 = corner2.getZ();

        int minX = Math.min(x1, x2);
        int minY = Math.min(y1, y2);
        int minZ = Math.min(z1, z2);
        int maxX = Math.max(x1, x2) + 1;
        int maxY = Math.max(y1, y2) + 1;
        int maxZ = Math.max(z1, z2) + 1;

        return new BoundingBox(minX, minY, minZ, maxX, maxY, maxZ);
    }

    /**
     * 创建包含给定方块的新 1x1x1 大小边界框。
     * <p>
     * 原文：
     * Creates a new 1x1x1 sized bounding box containing the given block.
     *
     * @param block 方块
     * @return 边界框
     */
    @NotNull
    public static BoundingBox of(@NotNull Block block) {
        Preconditions.checkArgument(block != null, "Block is null!");
        return new BoundingBox(block.getX(), block.getY(), block.getZ(), block.getX() + 1, block.getY() + 1, block.getZ() + 1);
    }

    /**
     * 使用给定中心和范围创建新的边界框。
     * <p>
     * 原文：
     * Creates a new bounding box using the given center and extents.
     *
     * @param center 中心
     * @param x 边界框沿 x 轴大小的 1/2
     * @param y 边界框沿 y 轴大小的 1/2
     * @param z 边界框沿 z 轴大小的 1/2
     * @return 边界框
     */
    @NotNull
    public static BoundingBox of(@NotNull Vector center, double x, double y, double z) {
        Preconditions.checkArgument(center != null, "Center is null!");
        return new BoundingBox(center.getX() - x, center.getY() - y, center.getZ() - z, center.getX() + x, center.getY() + y, center.getZ() + z);
    }

    /**
     * 使用给定中心和范围创建新的边界框。
     * <p>
     * 原文：
     * Creates a new bounding box using the given center and extents.
     *
     * @param center 中心
     * @param x 边界框沿 x 轴大小的 1/2
     * @param y 边界框沿 y 轴大小的 1/2
     * @param z 边界框沿 z 轴大小的 1/2
     * @return 边界框
     */
    @NotNull
    public static BoundingBox of(@NotNull Location center, double x, double y, double z) {
        Preconditions.checkArgument(center != null, "Center is null!");
        return new BoundingBox(center.getX() - x, center.getY() - y, center.getZ() - z, center.getX() + x, center.getY() + y, center.getZ() + z);
    }

    private double minX;
    private double minY;
    private double minZ;
    private double maxX;
    private double maxY;
    private double maxZ;

    /**
     * 创建一个新的（退化）边界框，所有角坐标为 <code>0</code>。
     */
    public BoundingBox() {
        this.resize(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
    }

    /**
     * 从给定角坐标创建新的边界框。
     * <p>
     * 原文：
     * Creates a new bounding box from the given corner coordinates.
     *
     * @param x1 第一个角的 x 值
     * @param y1 第一个角的 y 值
     * @param z1 第一个角的 z 值
     * @param x2 第二个角的 x 值
     * @param y2 第二个角的 y 值
     * @param z2 第二个角的 z 值
     */
    public BoundingBox(double x1, double y1, double z1, double x2, double y2, double z2) {
        this.resize(x1, y1, z1, x2, y2, z2);
    }

    /**
     * 调整此边界框的大小。
     * <p>
     * 原文：
     * Resizes this bounding box.
     *
     * @param x1 第一个角的 x 值
     * @param y1 第一个角的 y 值
     * @param z1 第一个角的 z 值
     * @param x2 第二个角的 x 值
     * @param y2 第二个角的 y 值
     * @param z2 第二个角的 z 值
     * @return 此边界框（已调整大小）
     */
    @NotNull
    public BoundingBox resize(double x1, double y1, double z1, double x2, double y2, double z2) {
        NumberConversions.checkFinite(x1, "x1 not finite");
        NumberConversions.checkFinite(y1, "y1 not finite");
        NumberConversions.checkFinite(z1, "z1 not finite");
        NumberConversions.checkFinite(x2, "x2 not finite");
        NumberConversions.checkFinite(y2, "y2 not finite");
        NumberConversions.checkFinite(z2, "z2 not finite");

        this.minX = Math.min(x1, x2);
        this.minY = Math.min(y1, y2);
        this.minZ = Math.min(z1, z2);
        this.maxX = Math.max(x1, x2);
        this.maxY = Math.max(y1, y2);
        this.maxZ = Math.max(z1, z2);
        return this;
    }

    /**
     * 获取最小 x 值。
     * <p>
     * 原文：
     * Gets the minimum x value.
     *
     * @return 最小 x 值
     */
    public double getMinX() {
        return minX;
    }

    /**
     * 获取最小 y 值。
     * <p>
     * 原文：
     * Gets the minimum y value.
     *
     * @return 最小 y 值
     */
    public double getMinY() {
        return minY;
    }

    /**
     * 获取最小 z 值。
     * <p>
     * 原文：
     * Gets the minimum z value.
     *
     * @return 最小 z 值
     */
    public double getMinZ() {
        return minZ;
    }

    /**
     * 获取最小角作为向量。
     * <p>
     * 原文：
     * Gets the minimum corner as vector.
     *
     * @return 最小角作为向量
     */
    @NotNull
    public Vector getMin() {
        return new Vector(minX, minY, minZ);
    }

    /**
     * 获取最大 x 值。
     * <p>
     * 原文：
     * Gets the maximum x value.
     *
     * @return 最大 x 值
     */
    public double getMaxX() {
        return maxX;
    }

    /**
     * 获取最大 y 值。
     * <p>
     * 原文：
     * Gets the maximum y value.
     *
     * @return 最大 y 值
     */
    public double getMaxY() {
        return maxY;
    }

    /**
     * 获取最大 z 值。
     * <p>
     * 原文：
     * Gets the maximum z value.
     *
     * @return 最大 z 值
     */
    public double getMaxZ() {
        return maxZ;
    }

    /**
     * 获取最大角作为向量。
     * <p>
     * 原文：
     * Gets the maximum corner as vector.
     *
     * @return 最大角向量
     */
    @NotNull
    public Vector getMax() {
        return new Vector(maxX, maxY, maxZ);
    }

    /**
     * 获取边界框在 x 方向的宽度。
     * <p>
     * 原文：
     * Gets the width of the bounding box in the x direction.
     *
     * @return x 方向的宽度
     */
    public double getWidthX() {
        return (this.maxX - this.minX);
    }

    /**
     * 获取边界框在 z 方向的宽度。
     * <p>
     * 原文：
     * Gets the width of the bounding box in the z direction.
     *
     * @return z 方向的宽度
     */
    public double getWidthZ() {
        return (this.maxZ - this.minZ);
    }

    /**
     * 获取边界框的高度。
     * <p>
     * 原文：
     * Gets the height of the bounding box.
     *
     * @return 高度
     */
    public double getHeight() {
        return (this.maxY - this.minY);
    }

    /**
     * 获取边界框的体积。
     * <p>
     * 原文：
     * Gets the volume of the bounding box.
     *
     * @return 体积
     */
    public double getVolume() {
        return (this.getHeight() * this.getWidthX() * this.getWidthZ());
    }

    /**
     * 获取边界框中心的 x 坐标。
     * <p>
     * 原文：
     * Gets the x coordinate of the center of the bounding box.
     *
     * @return 中心的 x 坐标
     */
    public double getCenterX() {
        return (this.minX + this.getWidthX() * 0.5D);
    }

    /**
     * 获取边界框中心的 y 坐标。
     * <p>
     * 原文：
     * Gets the y coordinate of the center of the bounding box.
     *
     * @return 中心的 y 坐标
     */
    public double getCenterY() {
        return (this.minY + this.getHeight() * 0.5D);
    }

    /**
     * 获取边界框中心的 z 坐标。
     * <p>
     * 原文：
     * Gets the z coordinate of the center of the bounding box.
     *
     * @return 中心的 z 坐标
     */
    public double getCenterZ() {
        return (this.minZ + this.getWidthZ() * 0.5D);
    }

    /**
     * 获取边界框的中心。
     * <p>
     * 原文：
     * Gets the center of the bounding box.
     *
     * @return 中心
     */
    @NotNull
    public Vector getCenter() {
        return new Vector(this.getCenterX(), this.getCenterY(), this.getCenterZ());
    }

    /**
     * 复制另一个边界框。
     * <p>
     * 原文：
     * Copies another bounding box.
     *
     * @param other 另一个边界框
     * @return 此边界框
     */
    @NotNull
    public BoundingBox copy(@NotNull BoundingBox other) {
        Preconditions.checkArgument(other != null, "Other bounding box is null!");
        return this.resize(other.getMinX(), other.getMinY(), other.getMinZ(), other.getMaxX(), other.getMaxY(), other.getMaxZ());
    }

    /**
     * 在相应方向上按给定值扩展此边界框。
     * <p>
     * 负值将在相应方向上收缩边界框。收缩将限制在受影响相对面以均匀速度收缩时会相遇的点。
     * <p>
     * 原文：
     * Expands this bounding box by the given values in the corresponding
     * directions.
     * <p>
     * Negative values will shrink the bounding box in the corresponding
     * direction. Shrinking will be limited to the point where the affected
     * opposite faces would meet if the they shrank at uniform speeds.
     *
     * @param negativeX 负 x 方向的扩展量
     * @param negativeY 负 y 方向的扩展量
     * @param negativeZ 负 z 方向的扩展量
     * @param positiveX 正 x 方向的扩展量
     * @param positiveY 正 y 方向的扩展量
     * @param positiveZ 正 z 方向的扩展量
     * @return 此边界框（已扩展）
     */
    @NotNull
    public BoundingBox expand(double negativeX, double negativeY, double negativeZ, double positiveX, double positiveY, double positiveZ) {
        if (negativeX == 0.0D && negativeY == 0.0D && negativeZ == 0.0D && positiveX == 0.0D && positiveY == 0.0D && positiveZ == 0.0D) {
            return this;
        }
        double newMinX = this.minX - negativeX;
        double newMinY = this.minY - negativeY;
        double newMinZ = this.minZ - negativeZ;
        double newMaxX = this.maxX + positiveX;
        double newMaxY = this.maxY + positiveY;
        double newMaxZ = this.maxZ + positiveZ;

        // limit shrinking:
        if (newMinX > newMaxX) {
            double centerX = this.getCenterX();
            if (newMaxX >= centerX) {
                newMinX = newMaxX;
            } else if (newMinX <= centerX) {
                newMaxX = newMinX;
            } else {
                newMinX = centerX;
                newMaxX = centerX;
            }
        }
        if (newMinY > newMaxY) {
            double centerY = this.getCenterY();
            if (newMaxY >= centerY) {
                newMinY = newMaxY;
            } else if (newMinY <= centerY) {
                newMaxY = newMinY;
            } else {
                newMinY = centerY;
                newMaxY = centerY;
            }
        }
        if (newMinZ > newMaxZ) {
            double centerZ = this.getCenterZ();
            if (newMaxZ >= centerZ) {
                newMinZ = newMaxZ;
            } else if (newMinZ <= centerZ) {
                newMaxZ = newMinZ;
            } else {
                newMinZ = centerZ;
                newMaxZ = centerZ;
            }
        }
        return this.resize(newMinX, newMinY, newMinZ, newMaxX, newMaxY, newMaxZ);
    }

    /**
     * 在正负方向上按给定值均匀扩展此边界框。
     * <p>
     * 负值将收缩边界框。收缩将限制在边界框的当前大小。
     * <p>
     * 原文：
     * Expands this bounding box uniformly by the given values in both positive
     * and negative directions.
     * <p>
     * Negative values will shrink the bounding box. Shrinking will be limited
     * to the bounding box's current size.
     *
     * @param x 正负 x 方向上的扩展量
     * @param y 正负 y 方向上的扩展量
     * @param z 正负 z 方向上的扩展量
     * @return 此边界框（已扩展）
     */
    @NotNull
    public BoundingBox expand(double x, double y, double z) {
        return this.expand(x, y, z, x, y, z);
    }

    /**
     * 在正负方向上按给定值均匀扩展此边界框。
     * <p>
     * 负值将收缩边界框。收缩将限制在边界框的当前大小。
     * <p>
     * 原文：
     * Expands this bounding box uniformly by the given values in both positive
     * and negative directions.
     * <p>
     * Negative values will shrink the bounding box. Shrinking will be limited
     * to the bounding box's current size.
     *
     * @param expansion 扩展值
     * @return 此边界框（已扩展）
     */
    @NotNull
    public BoundingBox expand(@NotNull Vector expansion) {
        Preconditions.checkArgument(expansion != null, "Expansion is null!");
        double x = expansion.getX();
        double y = expansion.getY();
        double z = expansion.getZ();
        return this.expand(x, y, z, x, y, z);
    }

    /**
     * 在所有方向上按给定值均匀扩展此边界框。
     * <p>
     * 负值将收缩边界框。收缩将限制在边界框的当前大小。
     * <p>
     * 原文：
     * Expands this bounding box uniformly by the given value in all directions.
     * <p>
     * A negative value will shrink the bounding box. Shrinking will be limited
     * to the bounding box's current size.
     *
     * @param expansion 扩展量
     * @return 此边界框（已扩展）
     */
    @NotNull
    public BoundingBox expand(double expansion) {
        return this.expand(expansion, expansion, expansion, expansion, expansion, expansion);
    }

    /**
     * 在指定方向上扩展此边界框。
     * <p>
     * 方向的大小将缩放扩展。负的扩展值将在此方向上收缩边界框。收缩将限制在边界框的当前大小。
     * <p>
     * 原文：
     * Expands this bounding box in the specified direction.
     * <p>
     * The magnitude of the direction will scale the expansion. A negative
     * expansion value will shrink the bounding box in this direction. Shrinking
     * will be limited to the bounding box's current size.
     *
     * @param dirX x 方向分量
     * @param dirY y 方向分量
     * @param dirZ z 方向分量
     * @param expansion 扩展量
     * @return 此边界框（已扩展）
     */
    @NotNull
    public BoundingBox expand(double dirX, double dirY, double dirZ, double expansion) {
        if (expansion == 0.0D) return this;
        if (dirX == 0.0D && dirY == 0.0D && dirZ == 0.0D) return this;

        double negativeX = (dirX < 0.0D ? (-dirX * expansion) : 0.0D);
        double negativeY = (dirY < 0.0D ? (-dirY * expansion) : 0.0D);
        double negativeZ = (dirZ < 0.0D ? (-dirZ * expansion) : 0.0D);
        double positiveX = (dirX > 0.0D ? (dirX * expansion) : 0.0D);
        double positiveY = (dirY > 0.0D ? (dirY * expansion) : 0.0D);
        double positiveZ = (dirZ > 0.0D ? (dirZ * expansion) : 0.0D);
        return this.expand(negativeX, negativeY, negativeZ, positiveX, positiveY, positiveZ);
    }

    /**
     * 在指定方向上扩展此边界框。
     * <p>
     * 方向的大小将缩放扩展。负的扩展值将在此方向上收缩边界框。收缩将限制在边界框的当前大小。
     * <p>
     * 原文：
     * Expands this bounding box in the specified direction.
     * <p>
     * The magnitude of the direction will scale the expansion. A negative
     * expansion value will shrink the bounding box in this direction. Shrinking
     * will be limited to the bounding box's current size.
     *
     * @param direction 方向
     * @param expansion 扩展量
     * @return 此边界框（已扩展）
     */
    @NotNull
    public BoundingBox expand(@NotNull Vector direction, double expansion) {
        Preconditions.checkArgument(direction != null, "Direction is null!");
        return this.expand(direction.getX(), direction.getY(), direction.getZ(), expansion);
    }

    /**
     * 在给定方块面指定的方向上扩展此边界框。
     * <p>
     * 负的扩展值将在此方向上收缩边界框。收缩将限制在边界框的当前大小。
     * <p>
     * 原文：
     * Expands this bounding box in the direction specified by the given block
     * face.
     * <p>
     * A negative expansion value will shrink the bounding box in this
     * direction. Shrinking will be limited to the bounding box's current size.
     *
     * @param blockFace 方块面
     * @param expansion 扩展量
     * @return 此边界框（已扩展）
     */
    @NotNull
    public BoundingBox expand(@NotNull BlockFace blockFace, double expansion) {
        Preconditions.checkArgument(blockFace != null, "Block face is null!");
        if (blockFace == BlockFace.SELF) return this;

        return this.expand(blockFace.getDirection(), expansion);
    }

    /**
     * 在指定方向上扩展此边界框。
     * <p>
     * 负值将在负方向上扩展边界框，正值将在正方向上扩展。方向分量的大小决定相应的扩展量。
     * <p>
     * 原文：
     * Expands this bounding box in the specified direction.
     * <p>
     * Negative values will expand the bounding box in the negative direction,
     * positive values will expand it in the positive direction. The magnitudes
     * of the direction components determine the corresponding amounts of
     * expansion.
     *
     * @param dirX x 方向分量
     * @param dirY y 方向分量
     * @param dirZ z 方向分量
     * @return 此边界框（已扩展）
     */
    @NotNull
    public BoundingBox expandDirectional(double dirX, double dirY, double dirZ) {
        return this.expand(dirX, dirY, dirZ, 1.0D);
    }

    /**
     * 在指定方向上扩展此边界框。
     * <p>
     * 负值将在负方向上扩展边界框，正值将在正方向上扩展。方向向量的大小决定扩展量。
     * <p>
     * 原文：
     * Expands this bounding box in the specified direction.
     * <p>
     * Negative values will expand the bounding box in the negative direction,
     * positive values will expand it in the positive direction. The magnitude
     * of the direction vector determines the amount of expansion.
     *
     * @param direction 扩展的方向和大小
     * @return 此边界框（已扩展）
     */
    @NotNull
    public BoundingBox expandDirectional(@NotNull Vector direction) {
        Preconditions.checkArgument(direction != null, "Expansion is null!");
        return this.expand(direction.getX(), direction.getY(), direction.getZ(), 1.0D);
    }

    /**
     * 扩展此边界框以包含（或边界）指定位置。
     * <p>
     * 原文：
     * Expands this bounding box to contain (or border) the specified position.
     *
     * @param posX x 位置值
     * @param posY y 位置值
     * @param posZ z 位置值
     * @return 此边界框（已扩展）
     * @see #contains(double, double, double)
     */
    @NotNull
    public BoundingBox union(double posX, double posY, double posZ) {
        double newMinX = Math.min(this.minX, posX);
        double newMinY = Math.min(this.minY, posY);
        double newMinZ = Math.min(this.minZ, posZ);
        double newMaxX = Math.max(this.maxX, posX);
        double newMaxY = Math.max(this.maxY, posY);
        double newMaxZ = Math.max(this.maxZ, posZ);
        if (newMinX == this.minX && newMinY == this.minY && newMinZ == this.minZ && newMaxX == this.maxX && newMaxY == this.maxY && newMaxZ == this.maxZ) {
            return this;
        }
        return this.resize(newMinX, newMinY, newMinZ, newMaxX, newMaxY, newMaxZ);
    }

    /**
     * 扩展此边界框以包含（或边界）指定位置。
     * <p>
     * 原文：
     * Expands this bounding box to contain (or border) the specified position.
     *
     * @param position 位置
     * @return 此边界框（已扩展）
     * @see #contains(double, double, double)
     */
        Preconditions.checkArgument(position != null, "Position is null!");
        return this.union(position.getX(), position.getY(), position.getZ());
    }

    /**
     * 扩展此边界框以包含（或边界）指定位置。
     * <p>
     * 原文：
     * Expands this bounding box to contain (or border) the specified position.
     *
     * @param position 位置
     * @return 此边界框（已扩展）
     * @see #contains(double, double, double)
     */
        Preconditions.checkArgument(position != null, "Position is null!");
        return this.union(position.getX(), position.getY(), position.getZ());
    }

    /**
     * 扩展此边界框以包含此边界框和给定边界框。
     * <p>
     * 原文：
     * Expands this bounding box to contain both this and the given bounding
     * box.
     *
     * @param other 另一个边界框
     * @return 此边界框（已扩展）
     */
    @NotNull
    public BoundingBox union(@NotNull BoundingBox other) {
        Preconditions.checkArgument(other != null, "Other bounding box is null!");
        if (this.contains(other)) return this;
        double newMinX = Math.min(this.minX, other.minX);
        double newMinY = Math.min(this.minY, other.minY);
        double newMinZ = Math.min(this.minZ, other.minZ);
        double newMaxX = Math.max(this.maxX, other.maxX);
        double newMaxY = Math.max(this.maxY, other.maxY);
        double newMaxZ = Math.max(this.maxZ, other.maxZ);
        return this.resize(newMinX, newMinY, newMinZ, newMaxX, newMaxY, newMaxZ);
    }

    /**
     * 调整此边界框大小以表示此边界框与给定边界的交集。
     * <p>
     * 原文：
     * Resizes this bounding box to represent the intersection of this and the
     * given bounding box.
     *
     * @param other 另一个边界框
     * @return 此边界框（现在表示交集）
     * @throws IllegalArgumentException 如果边界框不重叠
     */
    @NotNull
    public BoundingBox intersection(@NotNull BoundingBox other) {
        Preconditions.checkArgument(other != null, "Other bounding box is null!");
        Preconditions.checkArgument(this.overlaps(other), "The bounding boxes do not overlap!");
        double newMinX = Math.max(this.minX, other.minX);
        double newMinY = Math.max(this.minY, other.minY);
        double newMinZ = Math.max(this.minZ, other.minZ);
        double newMaxX = Math.min(this.maxX, other.maxX);
        double newMaxY = Math.min(this.maxY, other.maxY);
        double newMaxZ = Math.min(this.maxZ, other.maxZ);
        return this.resize(newMinX, newMinY, newMinZ, newMaxX, newMaxY, newMaxZ);
    }

    /**
     * 按给定量移动此边界框。
     * <p>
     * 原文：
     * Shifts this bounding box by the given amounts.
     *
     * @param shiftX x 方向的移动量
     * @param shiftY y 方向的移动量
     * @param shiftZ z 方向的移动量
     * @return 此边界框（已移动）
     */
    @NotNull
    public BoundingBox shift(double shiftX, double shiftY, double shiftZ) {
        if (shiftX == 0.0D && shiftY == 0.0D && shiftZ == 0.0D) return this;
        return this.resize(this.minX + shiftX, this.minY + shiftY, this.minZ + shiftZ,
                this.maxX + shiftX, this.maxY + shiftY, this.maxZ + shiftZ);
    }

    /**
     * 按给定量移动此边界框。
     * <p>
     * 原文：
     * Shifts this bounding box by the given amounts.
     *
     * @param shift 移动量
     * @return 此边界框（已移动）
     */
        Preconditions.checkArgument(shift != null, "Shift is null!");
        return this.shift(shift.getX(), shift.getY(), shift.getZ());
    }

    /**
     * 按给定量移动此边界框。
     * <p>
     * 原文：
     * Shifts this bounding box by the given amounts.
     *
     * @param shift 移动量
     * @return 此边界框（已移动）
     */
        Preconditions.checkArgument(shift != null, "Shift is null!");
        return this.shift(shift.getX(), shift.getY(), shift.getZ());
    }

    private boolean overlaps(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        return this.minX < maxX && this.maxX > minX
                && this.minY < maxY && this.maxY > minY
                && this.minZ < maxZ && this.maxZ > minZ;
    }

    /**
     * 检查此边界框是否与给定边界框重叠。
     * <p>
     * 仅在边界处相交的边界框不被视为重叠。
     * <p>
     * 原文：
     * Checks if this bounding box overlaps with the given bounding box.
     * <p>
     * Bounding boxes that are only intersecting at the borders are not
     * considered overlapping.
     *
     * @param other 另一个边界框
     * @return <code>true</code> 如果重叠
     */
    public boolean overlaps(@NotNull BoundingBox other) {
        Preconditions.checkArgument(other != null, "Other bounding box is null!");
        return this.overlaps(other.minX, other.minY, other.minZ, other.maxX, other.maxY, other.maxZ);
    }

    /**
     * 检查此边界框是否与给定角定义的边界框重叠。
     * <p>
     * 仅在边界处相交的边界框不被视为重叠。
     * <p>
     * 原文：
     * Checks if this bounding box overlaps with the bounding box that is
     * defined by the given corners.
     * <p>
     * Bounding boxes that are only intersecting at the borders are not
     * considered overlapping.
     *
     * @param min 第一个角
     * @param max 第二个角
     * @return <code>true</code> 如果重叠
     */
    public boolean overlaps(@NotNull Vector min, @NotNull Vector max) {
        Preconditions.checkArgument(min != null, "Min is null!");
        Preconditions.checkArgument(max != null, "Max is null!");
        double x1 = min.getX();
        double y1 = min.getY();
        double z1 = min.getZ();
        double x2 = max.getX();
        double y2 = max.getY();
        double z2 = max.getZ();
        return this.overlaps(Math.min(x1, x2), Math.min(y1, y2), Math.min(z1, z2),
                Math.max(x1, x2), Math.max(y1, y2), Math.max(z1, z2));
    }

    /**
     * 检查此边界框是否包含指定位置。
     * <p>
     * 恰好在边界框最小边界上的位置被视为在边界框内，而恰好在最大边界上的位置被视为在外。这允许边界框直接相邻放置，位置始终只位于其中一个边界框内。
     * <p>
     * 原文：
     * Checks if this bounding box contains the specified position.
     * <p>
     * Positions exactly on the minimum borders of the bounding box are
     * considered to be inside the bounding box, while positions exactly on the
     * maximum borders are considered to be outside. This allows bounding boxes
     * to reside directly next to each other with positions always only residing
     * in exactly one of them.
     *
     * @param x 位置的 x 坐标
     * @param y 位置的 y 坐标
     * @param z 位置的 z 坐标
     * @return <code>true</code> 如果边界框包含该位置
     */
    public boolean contains(double x, double y, double z) {
        return x >= this.minX && x < this.maxX
                && y >= this.minY && y < this.maxY
                && z >= this.minZ && z < this.maxZ;
    }

    /**
     * 检查此边界框是否包含指定位置。
     * <p>
     * 恰好在边界框最小边界上的位置被视为在边界框内，而恰好在最大边界上的位置被视为在外。这允许边界框直接相邻放置，位置始终只位于其中一个边界框内。
     * <p>
     * 原文：
     * Checks if this bounding box contains the specified position.
     * <p>
     * Positions exactly on the minimum borders of the bounding box are
     * considered to be inside the bounding box, while positions exactly on the
     * maximum borders are considered to be outside. This allows bounding boxes
     * to reside directly next to each other with positions always only residing
     * in exactly one of them.
     *
     * @param position 位置
     * @return <code>true</code> 如果边界框包含该位置
     */
    public boolean contains(@NotNull Vector position) {
        Preconditions.checkArgument(position != null, "Position is null!");
        return this.contains(position.getX(), position.getY(), position.getZ());
    }

    private boolean contains(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        return this.minX <= minX && this.maxX >= maxX
                && this.minY <= minY && this.maxY >= maxY
                && this.minZ <= minZ && this.maxZ >= maxZ;
    }

    /**
     * 检查此边界框是否完全包含给定边界框。
     * <p>
     * 原文：
     * Checks if this bounding box fully contains the given bounding box.
     *
     * @param other 另一个边界框
     * @return <code>true</code> 如果边界框包含给定边界框
     */
    public boolean contains(@NotNull BoundingBox other) {
        Preconditions.checkArgument(other != null, "Other bounding box is null!");
        return this.contains(other.minX, other.minY, other.minZ, other.maxX, other.maxY, other.maxZ);
    }

    /**
     * 检查此边界框是否完全包含给定角定义的边界框。
     * <p>
     * 原文：
     * Checks if this bounding box fully contains the bounding box that is
     * defined by the given corners.
     *
     * @param min 第一个角
     * @param max 第二个角
     * @return <code>true</code> 如果边界框包含指定的边界框
     */
    public boolean contains(@NotNull Vector min, @NotNull Vector max) {
        Preconditions.checkArgument(min != null, "Min is null!");
        Preconditions.checkArgument(max != null, "Max is null!");
        double x1 = min.getX();
        double y1 = min.getY();
        double z1 = min.getZ();
        double x2 = max.getX();
        double y2 = max.getY();
        double z2 = max.getZ();
        return this.contains(Math.min(x1, x2), Math.min(y1, y2), Math.min(z1, z2),
                Math.max(x1, x2), Math.max(y1, y2), Math.max(z1, z2));
    }

    /**
     * 计算此边界框与指定线段的交点。
     * <p>
     * 在边和角处的交点会产生一个受影响的方块面作为命中结果，但不确定是哪一个。
     * <p>
     * 原文：
     * Calculates the intersection of this bounding box with the specified line
     * segment.
     * <p>
     * Intersections at edges and corners yield one of the affected block faces
     * as hit result, but it is not defined which of them.
     *
     * @param start 起始位置
     * @param direction 光线方向
     * @param maxDistance 最大距离
     * @return 光线追踪命中结果，如果没有命中则返回 <code>null</code>
     */
    @Nullable
    public RayTraceResult rayTrace(@NotNull Vector start, @NotNull Vector direction, double maxDistance) {
        Preconditions.checkArgument(start != null, "Start is null!");
        start.checkFinite();
        Preconditions.checkArgument(direction != null, "Direction is null!");
        direction.checkFinite();
        Preconditions.checkArgument(direction.lengthSquared() > 0, "Direction's magnitude is 0!");
        if (maxDistance < 0.0D) return null;

        // ray start:
        double startX = start.getX();
        double startY = start.getY();
        double startZ = start.getZ();

        // ray direction:
        Vector dir = direction.clone().normalizeZeros().normalize();
        double dirX = dir.getX();
        double dirY = dir.getY();
        double dirZ = dir.getZ();

        // saving a few divisions below:
        // Note: If one of the direction vector components is 0.0, these
        // divisions result in infinity. But this is not a problem.
        double divX = 1.0D / dirX;
        double divY = 1.0D / dirY;
        double divZ = 1.0D / dirZ;

        double tMin;
        double tMax;
        BlockFace hitBlockFaceMin;
        BlockFace hitBlockFaceMax;

        // intersections with x planes:
        if (dirX >= 0.0D) {
            tMin = (this.minX - startX) * divX;
            tMax = (this.maxX - startX) * divX;
            hitBlockFaceMin = BlockFace.WEST;
            hitBlockFaceMax = BlockFace.EAST;
        } else {
            tMin = (this.maxX - startX) * divX;
            tMax = (this.minX - startX) * divX;
            hitBlockFaceMin = BlockFace.EAST;
            hitBlockFaceMax = BlockFace.WEST;
        }

        // intersections with y planes:
        double tyMin;
        double tyMax;
        BlockFace hitBlockFaceYMin;
        BlockFace hitBlockFaceYMax;
        if (dirY >= 0.0D) {
            tyMin = (this.minY - startY) * divY;
            tyMax = (this.maxY - startY) * divY;
            hitBlockFaceYMin = BlockFace.DOWN;
            hitBlockFaceYMax = BlockFace.UP;
        } else {
            tyMin = (this.maxY - startY) * divY;
            tyMax = (this.minY - startY) * divY;
            hitBlockFaceYMin = BlockFace.UP;
            hitBlockFaceYMax = BlockFace.DOWN;
        }
        if ((tMin > tyMax) || (tMax < tyMin)) {
            return null;
        }
        if (tyMin > tMin) {
            tMin = tyMin;
            hitBlockFaceMin = hitBlockFaceYMin;
        }
        if (tyMax < tMax) {
            tMax = tyMax;
            hitBlockFaceMax = hitBlockFaceYMax;
        }

        // intersections with z planes:
        double tzMin;
        double tzMax;
        BlockFace hitBlockFaceZMin;
        BlockFace hitBlockFaceZMax;
        if (dirZ >= 0.0D) {
            tzMin = (this.minZ - startZ) * divZ;
            tzMax = (this.maxZ - startZ) * divZ;
            hitBlockFaceZMin = BlockFace.NORTH;
            hitBlockFaceZMax = BlockFace.SOUTH;
        } else {
            tzMin = (this.maxZ - startZ) * divZ;
            tzMax = (this.minZ - startZ) * divZ;
            hitBlockFaceZMin = BlockFace.SOUTH;
            hitBlockFaceZMax = BlockFace.NORTH;
        }
        if ((tMin > tzMax) || (tMax < tzMin)) {
            return null;
        }
        if (tzMin > tMin) {
            tMin = tzMin;
            hitBlockFaceMin = hitBlockFaceZMin;
        }
        if (tzMax < tMax) {
            tMax = tzMax;
            hitBlockFaceMax = hitBlockFaceZMax;
        }

        // intersections are behind the start:
        if (tMax < 0.0D) return null;
        // intersections are to far away:
        if (tMin > maxDistance) {
            return null;
        }

        // find the closest intersection:
        double t;
        BlockFace hitBlockFace;
        if (tMin < 0.0D) {
            t = tMax;
            hitBlockFace = hitBlockFaceMax;
        } else {
            t = tMin;
            hitBlockFace = hitBlockFaceMin;
        }
        // reusing the newly created direction vector for the hit position:
        Vector hitPosition = dir.multiply(t).add(start);
        return new RayTraceResult(hitPosition, hitBlockFace);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(maxX);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(maxY);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(maxZ);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(minX);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(minY);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(minZ);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BoundingBox)) return false;
        BoundingBox other = (BoundingBox) obj;
        if (Double.doubleToLongBits(maxX) != Double.doubleToLongBits(other.maxX)) return false;
        if (Double.doubleToLongBits(maxY) != Double.doubleToLongBits(other.maxY)) return false;
        if (Double.doubleToLongBits(maxZ) != Double.doubleToLongBits(other.maxZ)) return false;
        if (Double.doubleToLongBits(minX) != Double.doubleToLongBits(other.minX)) return false;
        if (Double.doubleToLongBits(minY) != Double.doubleToLongBits(other.minY)) return false;
        if (Double.doubleToLongBits(minZ) != Double.doubleToLongBits(other.minZ)) return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BoundingBox [minX=");
        builder.append(minX);
        builder.append(", minY=");
        builder.append(minY);
        builder.append(", minZ=");
        builder.append(minZ);
        builder.append(", maxX=");
        builder.append(maxX);
        builder.append(", maxY=");
        builder.append(maxY);
        builder.append(", maxZ=");
        builder.append(maxZ);
        builder.append("]");
        return builder.toString();
    }

    /**
     * 创建此边界框的副本。
     * <p>
     * 原文：
     * Creates a copy of this bounding box.
     *
     * @return 克隆的边界框
     */
    @NotNull
    @Override
    public BoundingBox clone() {
        try {
            return (BoundingBox) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }

    @NotNull
    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> result = new LinkedHashMap<String, Object>();
        result.put("minX", minX);
        result.put("minY", minY);
        result.put("minZ", minZ);
        result.put("maxX", maxX);
        result.put("maxY", maxY);
        result.put("maxZ", maxZ);
        return result;
    }

    @NotNull
    public static BoundingBox deserialize(@NotNull Map<String, Object> args) {
        double minX = 0.0D;
        double minY = 0.0D;
        double minZ = 0.0D;
        double maxX = 0.0D;
        double maxY = 0.0D;
        double maxZ = 0.0D;

        if (args.containsKey("minX")) {
            minX = ((Number) args.get("minX")).doubleValue();
        }
        if (args.containsKey("minY")) {
            minY = ((Number) args.get("minY")).doubleValue();
        }
        if (args.containsKey("minZ")) {
            minZ = ((Number) args.get("minZ")).doubleValue();
        }
        if (args.containsKey("maxX")) {
            maxX = ((Number) args.get("maxX")).doubleValue();
        }
        if (args.containsKey("maxY")) {
            maxY = ((Number) args.get("maxY")).doubleValue();
        }
        if (args.containsKey("maxZ")) {
            maxZ = ((Number) args.get("maxZ")).doubleValue();
        }

        return new BoundingBox(minX, minY, minZ, maxX, maxY, maxZ);
    }
}
