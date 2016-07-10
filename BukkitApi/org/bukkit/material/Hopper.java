package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * Represents a hopper in an active or deactivated state and facing in a
 * specific direction.
 *
 * @see Material#HOPPER
 */
public class Hopper extends MaterialData implements Directional, Redstone {

    protected static final BlockFace DEFAULT_DIRECTION = BlockFace.DOWN;
    protected static final boolean DEFAULT_ACTIVE = true;

    /**
     * 构造一个默认朝向（下）、激活的漏斗.
     * <p>
     * 原文:Constructs a hopper facing the default direction (down) and initially
     * active.
     */
    public Hopper() {
        this(DEFAULT_DIRECTION, DEFAULT_ACTIVE);
    }

    /**
     * 构造一个指定朝向、激活的漏斗.
     * <p>
     * 原文:Constructs a hopper facing the specified direction and initially active.
     *
     * @param facingDirection 朝向
     *
     * @see BlockFace
     */
    public Hopper(BlockFace facingDirection) {
        this(facingDirection, DEFAULT_ACTIVE);
    }

    /**
     * 构造一个指定朝向、指定激活状态的漏斗.
     * <p>
     * 原文:Constructs a hopper facing the specified direction and either active or
     * not.
     *
     * @param facingDirection 朝向
     * @param isActive 这个漏斗是否被激活
     *
     * @see BlockFace
     */
    public Hopper(BlockFace facingDirection, boolean isActive) {
        super(Material.HOPPER);
        setFacingDirection(facingDirection);
        setActive(isActive);
    }

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Hopper(int type) {
        super(type);
    }

    public Hopper(Material type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Hopper(int type, byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Hopper(Material type, byte data) {
        super(type, data);
    }

    /**
     * 设置这个漏斗是否被激活.
     * <p>
     * 原文:Sets whether the hopper is active or not.
     *
     * @param isActive 这个漏斗是否被激活
     */
    public void setActive(boolean isActive) {
        setData((byte) (getData() & 0x7 | (isActive ? 0x0 : 0x8)));
    }

    /**
     * 检测这个漏斗是否被激活.
     * <p>
     * 原文:Checks whether the hopper is active or not.
     *
     * @return 这个漏斗是否被激活
     */
    public boolean isActive() {
        return (getData() & 0x8) == 0;
    }

    /**
     * 设置这个漏斗的朝向.
     * <p>
     * 原文:Sets the direction this hopper is facing
     *
     * @param face 朝向
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
     * 获取这个漏斗的朝向.
     * <p>
     * 原文:Gets the direction this hopper is facing
     *
     * @return 朝向
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
     * 检测这个漏斗是否充能.
     * <p>
     * 原文:Checks if the hopper is powered.
     *
     * @return 这个漏斗是否充能
     */
    @Override
    public boolean isPowered() {
        return (getData() & 0x8) != 0;
    }
}
