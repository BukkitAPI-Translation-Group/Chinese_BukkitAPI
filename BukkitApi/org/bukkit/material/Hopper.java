package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表一个处于激活或停用状态并面向特定方向的漏斗。
 *
 * @see Material#HOPPER
 *
 * @deprecated 所有 MaterialData 的用法均已弃用并可能被移除.
 * 请使用 {@link org.bukkit.block.data.BlockData}.
 */
@Deprecated(since = "1.14.1")
public class Hopper extends MaterialData implements Directional, Redstone {

    protected static final BlockFace DEFAULT_DIRECTION = BlockFace.DOWN;
    protected static final boolean DEFAULT_ACTIVE = true;

    /**
     * 构造一个面向默认方向（下）且初始激活的漏斗。
     * <p>原文：Constructs a hopper facing the default direction (down) and initially active.
     */
    public Hopper() {
        this(DEFAULT_DIRECTION, DEFAULT_ACTIVE);
    }

    /**
     * 构造一个面向指定方向且初始激活的漏斗。
     * <p>原文：Constructs a hopper facing the specified direction and initially active.
     *
     * @param facingDirection 漏斗面向的方向
     *
     * @see BlockFace
     */
    public Hopper(BlockFace facingDirection) {
        this(facingDirection, DEFAULT_ACTIVE);
    }

    /**
     * 构造一个面向指定方向且激活或停用的漏斗。
     * <p>原文：Constructs a hopper facing the specified direction and either active or not.
     *
     * @param facingDirection 漏斗面向的方向
     * @param isActive 如果漏斗初始为激活状态则为 true，如果停用则为 false
     *
     * @see BlockFace
     */
    public Hopper(BlockFace facingDirection, boolean isActive) {
        super(Material.LEGACY_HOPPER);
        setFacingDirection(facingDirection);
        setActive(isActive);
    }

    public Hopper(Material type) {
        super(type);
    }

    /**
     * @param type 材料类型
     * @param data 原始数据值
     * @deprecated Magic value
     */
    @Deprecated(since = "1.9")
    public Hopper(Material type, byte data) {
        super(type, data);
    }

    /**
     * 设置漏斗是否激活。
     * <p>原文：Sets whether the hopper is active or not.
     *
     * @param isActive 如果漏斗激活则为 true，如果被红石信号停用则为 false
     */
    public void setActive(boolean isActive) {
        setData((byte) (getData() & 0x7 | (isActive ? 0x0 : 0x8)));
    }

    /**
     * 检查漏斗是否激活。
     * <p>原文：Checks whether the hopper is active or not.
     *
     * @return 如果漏斗激活则为 true，如果停用则为 false
     */
    public boolean isActive() {
        return (getData() & 0x8) == 0;
    }

    /**
     * 设置此漏斗面向的方向。
     * <p>原文：Sets the direction this hopper is facing
     *
     * @param face 要设置的漏斗朝向
     *
     * @see BlockFace
     */
    @Override
    public void setFacingDirection(BlockFace face) {
        int data = getData() & 0x8;

        switch (face) {
            case DOWN:
                data |= 0x0;
                break;
            case NORTH:
                data |= 0x2;
                break;
            case SOUTH:
                data |= 0x3;
                break;
            case WEST:
                data |= 0x4;
                break;
            case EAST:
                data |= 0x5;
                break;
        }

        setData((byte) data);
    }

    /**
     * 获取此漏斗面向的方向。
     * <p>原文：Gets the direction this hopper is facing
     *
     * @return 漏斗面向的方向
     *
     * @see BlockFace
     */
    @Override
    public BlockFace getFacing() {
        byte data = (byte) (getData() & 0x7);

        switch (data) {
            default:
            case 0x0:
                return BlockFace.DOWN;
            case 0x2:
                return BlockFace.NORTH;
            case 0x3:
                return BlockFace.SOUTH;
            case 0x4:
                return BlockFace.WEST;
            case 0x5:
                return BlockFace.EAST;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " facing " + getFacing();
    }

    @Override
    public Hopper clone() {
        return (Hopper) super.clone();
    }

    /**
     * 检查漏斗是否被充能。
     * <p>原文：Checks if the hopper is powered.
     *
     * @return 如果漏斗被充能则为 true
     */
    @Override
    public boolean isPowered() {
        return (getData() & 0x8) != 0;
    }
}