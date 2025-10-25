package org.bukkit.block;

import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

/**
 * 代表方块的朝向.
 */
public enum BlockFace {
    NORTH(0, 0, -1),
    EAST(1, 0, 0),
    SOUTH(0, 0, 1),
    WEST(-1, 0, 0),
    UP(0, 1, 0),
    DOWN(0, -1, 0),
    NORTH_EAST(NORTH, EAST),
    NORTH_WEST(NORTH, WEST),
    SOUTH_EAST(SOUTH, EAST),
    SOUTH_WEST(SOUTH, WEST),
    WEST_NORTH_WEST(WEST, NORTH_WEST),
    NORTH_NORTH_WEST(NORTH, NORTH_WEST),
    NORTH_NORTH_EAST(NORTH, NORTH_EAST),
    EAST_NORTH_EAST(EAST, NORTH_EAST),
    EAST_SOUTH_EAST(EAST, SOUTH_EAST),
    SOUTH_SOUTH_EAST(SOUTH, SOUTH_EAST),
    SOUTH_SOUTH_WEST(SOUTH, SOUTH_WEST),
    WEST_SOUTH_WEST(WEST, SOUTH_WEST),
    SELF(0, 0, 0);

    private final int modX;
    private final int modY;
    private final int modZ;

    private BlockFace(final int modX, final int modY, final int modZ) {
        this.modX = modX;
        this.modY = modY;
        this.modZ = modZ;
    }

    private BlockFace(final BlockFace face1, final BlockFace face2) {
        this.modX = face1.getModX() + face2.getModX();
        this.modY = face1.getModY() + face2.getModY();
        this.modZ = face1.getModZ() + face2.getModZ();
    }

    /**
     * 获取此朝向的X轴坐标偏移量, 用以获取其表示的方块.
     * <p>
     * 原文:Get the amount of X-coordinates to modify to get the represented block
     *
     * @return X轴坐标偏移量
     */
    public int getModX() {
        return modX;
    }

    /**
     * 获取此朝向的Y轴坐标偏移量, 用以获取其表示的方块.
     * <p>
     * 原文:
     * Get the amount of Y-coordinates to modify to get the represented block
     *
     * @return Y轴坐标偏移量
     */
    public int getModY() {
        return modY;
    }

    /*
     * 获取此朝向的Z轴坐标偏移量, 用以获取其表示的方块.
     * <p>
     * 原文:
     * Get the amount of Z-coordinates to modify to get the represented block
     *
     * @return Z轴坐标偏移量
     */
    public int getModZ() {
        return modZ;
    }

    /**
     * 获取与此朝向相对应的单位向量.
     * <p>
     * 原文:Gets the normal vector corresponding to this block face.
     *
     * @return 对应的单位向量
     */
    @NotNull
    public Vector getDirection() {
        Vector direction = new Vector(modX, modY, modZ);
        if (modX != 0 || modY != 0 || modZ != 0) {
            direction.normalize();
        }
        return direction;
    }

    /**
     * 如果此面与三维笛卡尔空间中的单位轴对齐(即NORTH、SOUTH、EAST、WEST、UP、DOWN), 则返回true.
     * <p>
     * 原文:
     * Returns true if this face is aligned with one of the unit axes in 3D
     * Cartesian space (ie NORTH, SOUTH, EAST, WEST, UP, DOWN).
     *
     * @return 笛卡尔状态
     */
    public boolean isCartesian() {
        switch (this) {
            case NORTH:
            case SOUTH:
            case EAST:
            case WEST:
            case UP:
            case DOWN:
                return true;
            default:
                return false;
        }
    }

    /**
     * 获取与此面相对的面.
     * <p>
     * 原文:
     * Gets the opposite face.
     *
     * @return 相对的面
     */
    @NotNull
    public BlockFace getOppositeFace() {
        switch (this) {
        case NORTH:
            return BlockFace.SOUTH;

        case SOUTH:
            return BlockFace.NORTH;

        case EAST:
            return BlockFace.WEST;

        case WEST:
            return BlockFace.EAST;

        case UP:
            return BlockFace.DOWN;

        case DOWN:
            return BlockFace.UP;

        case NORTH_EAST:
            return BlockFace.SOUTH_WEST;

        case NORTH_WEST:
            return BlockFace.SOUTH_EAST;

        case SOUTH_EAST:
            return BlockFace.NORTH_WEST;

        case SOUTH_WEST:
            return BlockFace.NORTH_EAST;

        case WEST_NORTH_WEST:
            return BlockFace.EAST_SOUTH_EAST;

        case NORTH_NORTH_WEST:
            return BlockFace.SOUTH_SOUTH_EAST;

        case NORTH_NORTH_EAST:
            return BlockFace.SOUTH_SOUTH_WEST;

        case EAST_NORTH_EAST:
            return BlockFace.WEST_SOUTH_WEST;

        case EAST_SOUTH_EAST:
            return BlockFace.WEST_NORTH_WEST;

        case SOUTH_SOUTH_EAST:
            return BlockFace.NORTH_NORTH_WEST;

        case SOUTH_SOUTH_WEST:
            return BlockFace.NORTH_NORTH_EAST;

        case WEST_SOUTH_WEST:
            return BlockFace.EAST_NORTH_EAST;

        case SELF:
            return BlockFace.SELF;
        }

        return BlockFace.SELF;
    }
}