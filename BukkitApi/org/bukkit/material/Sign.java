package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 告示牌的 MaterialData。
 *
 * @deprecated 所有 MaterialData 的用法都已弃用并可能被移除。
 * 请使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class Sign extends MaterialData implements Attachable {
    public Sign() {
        super(Material.LEGACY_SIGN_POST);
    }

    public Sign(final Material type) {
        super(type);
    }

    /**
     * @param type 原始类型 ID
     * @param data 原始数据值
     * @deprecated 魔法值
     * <p>原文：Magic value
     */
    @Deprecated(since = "1.6.2")
    public Sign(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 检查此告示牌是否附着在墙上。
     *
     * @return 如果此告示牌附着在墙上则返回 true，如果放置在方块顶部则返回 false
     * <p>原文：Check if this sign is attached to a wall
     */
    public boolean isWallSign() {
        return getItemType() == Material.LEGACY_WALL_SIGN;
    }

    /**
     * 获取此方块所附着的面。
     *
     * @return 附着的 BlockFace
     * <p>原文：Gets the face that this block is attached on
     */
    @Override
    public BlockFace getAttachedFace() {
        if (isWallSign()) {
            byte data = getData();

            switch (data) {
            case 0x2:
                return BlockFace.SOUTH;

            case 0x3:
                return BlockFace.NORTH;

            case 0x4:
                return BlockFace.EAST;

            case 0x5:
                return BlockFace.WEST;
            }

            return null;
        } else {
            return BlockFace.DOWN;
        }
    }

    /**
     * 获取此告示牌当前朝向的方向。
     *
     * @return 指示此告示牌朝向的 BlockFace
     * <p>原文：Gets the direction that this sign is currently facing
     */
    @Override
    public BlockFace getFacing() {
        byte data = getData();

        if (!isWallSign()) {
            switch (data) {
            case 0x0:
                return BlockFace.SOUTH;

            case 0x1:
                return BlockFace.SOUTH_SOUTH_WEST;

            case 0x2:
                return BlockFace.SOUTH_WEST;

            case 0x3:
                return BlockFace.WEST_SOUTH_WEST;

            case 0x4:
                return BlockFace.WEST;

            case 0x5:
                return BlockFace.WEST_NORTH_WEST;

            case 0x6:
                return BlockFace.NORTH_WEST;

            case 0x7:
                return BlockFace.NORTH_NORTH_WEST;

            case 0x8:
                return BlockFace.NORTH;

            case 0x9:
                return BlockFace.NORTH_NORTH_EAST;

            case 0xA:
                return BlockFace.NORTH_EAST;

            case 0xB:
                return BlockFace.EAST_NORTH_EAST;

            case 0xC:
                return BlockFace.EAST;

            case 0xD:
                return BlockFace.EAST_SOUTH_EAST;

            case 0xE:
                return BlockFace.SOUTH_EAST;

            case 0xF:
                return BlockFace.SOUTH_SOUTH_EAST;
            }

            return null;
        } else {
            return getAttachedFace().getOppositeFace();
        }
    }

    @Override
    public void setFacingDirection(BlockFace face) {
        byte data;

        if (isWallSign()) {
            switch (face) {
            case NORTH:
                data = 0x2;
                break;

            case SOUTH:
                data = 0x3;
                break;

            case WEST:
                data = 0x4;
                break;

            case EAST:
            default:
                data = 0x5;
            }
        } else {
            switch (face) {
            case SOUTH:
                data = 0x0;
                break;

            case SOUTH_SOUTH_WEST:
                data = 0x1;
                break;

            case SOUTH_WEST:
                data = 0x2;
                break;

            case WEST_SOUTH_WEST:
                data = 0x3;
                break;

            case WEST:
                data = 0x4;
                break;

            case WEST_NORTH_WEST:
                data = 0x5;
                break;

            case NORTH_WEST:
                data = 0x6;
                break;

            case NORTH_NORTH_WEST:
                data = 0x7;
                break;

            case NORTH:
                data = 0x8;
                break;

            case NORTH_NORTH_EAST:
                data = 0x9;
                break;

            case NORTH_EAST:
                data = 0xA;
                break;

            case EAST_NORTH_EAST:
                data = 0xB;
                break;

            case EAST:
                data = 0xC;
                break;

            case EAST_SOUTH_EAST:
                data = 0xD;
                break;

            case SOUTH_SOUTH_EAST:
                data = 0xF;
                break;

            case SOUTH_EAST:
            default:
                data = 0xE;
            }
        }

        setData(data);
    }

    @Override
    public String toString() {
        return super.toString() + " facing " + getFacing();
    }

    @Override
    public Sign clone() {
        return (Sign) super.clone();
    }
}