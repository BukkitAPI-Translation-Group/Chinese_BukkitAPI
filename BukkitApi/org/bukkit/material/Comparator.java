package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表开启或关闭状态的红石比较器.
 *
 * @see Material#REDSTONE_COMPARATOR_OFF
 * @see Material#REDSTONE_COMPARATOR_ON
 */
public class Comparator extends MaterialData implements Directional, Redstone {
    protected static final BlockFace DEFAULT_DIRECTION = BlockFace.NORTH;
    protected static final boolean DEFAULT_SUBTRACTION_MODE = false;
    protected static final boolean DEFAULT_STATE = false;

    /**
     * 构造一个关闭状态的、默认模式默认朝向（北）的红石比较器.
     * <p>
     * 原文:Constructs a comparator switched off, with the default mode (normal) and facing the default direction (north).
     */
    public Comparator() {
        this(DEFAULT_DIRECTION, DEFAULT_SUBTRACTION_MODE, false);
    }

    /**
     * 构造一个关闭状态的、默认模式指定朝向的红石比较器.
     * <p>
     * 原文:Constructs a comparator switched off, with the default mode (normal) and facing the specified direction.
     *
     * @param facingDirection 朝向
     *
     * @see BlockFace
     */
    public Comparator(BlockFace facingDirection) {
        this(facingDirection, DEFAULT_SUBTRACTION_MODE, DEFAULT_STATE);
    }

    /**
     * 构造一个关闭状态的、指定模式指定朝向的红石比较器.
     * <p>
     * 原文:Constructs a comparator switched off, with the specified mode and facing the specified direction.
     *
     * @param facingDirection 朝向
     * @param isSubtraction true 如果红石比较器为减法模式
     *
     * @see BlockFace
     */
    public Comparator(BlockFace facingDirection, boolean isSubtraction) {
    	this(facingDirection, isSubtraction, DEFAULT_STATE);
    }

    /**
     * 构造一个开启或关闭状态的、指定模式指定朝向的红石比较器.
     * <p>
     * 原文:Constructs a comparator switched on or off, with the specified mode and facing the specified direction.
     *
     * @param facingDirection 朝向
     * @param isSubtraction true 如果红石比较器为减法模式
     * @param state 激活状态
     *
     * @see BlockFace
     */
    public Comparator(BlockFace facingDirection, boolean isSubtraction, boolean state) {
        super(state ? Material.REDSTONE_COMPARATOR_ON : Material.REDSTONE_COMPARATOR_OFF);
        setFacingDirection(facingDirection);
        setSubtractionMode(isSubtraction);
    }

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Comparator(int type) {
        super(type);
    }

    public Comparator(Material type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Comparator(int type, byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Comparator(Material type, byte data) {
        super(type, data);
    }

    /**
     * 设置该红石比较器是否为减法模式.
     * <p>
     * 原文:Sets whether the comparator is in subtraction mode.
     *
     * @param isSubtraction true 如果红石比较器为减法模式
     */
    public void setSubtractionMode(boolean isSubtraction) {
        setData((byte) (getData() & 0xB | (isSubtraction ? 0x4 : 0x0)));
    }

    /**
     * 检测这个红石即比较器是否为减法模式.
     * <p>
     * 原文:Checks whether the comparator is in subtraction mode
     *
     * @return true 如果红石比较器为减法模式
     */
    public boolean isSubtractionMode() {
        return (getData() & 0x4) != 0;
    }

    /**
     * 设置这个红石比较器的朝向.
     * <p>
     * 原文:Sets the direction this comparator is facing
     *
     * @param face 朝向
     *
     * @see BlockFace
     */
    @Override
    public void setFacingDirection(BlockFace face) {
        int data = getData() & 0xC;

        switch (face) {
        case EAST:
            data |= 0x1;
            break;

        case SOUTH:
            data |= 0x2;
            break;

        case WEST:
            data |= 0x3;
            break;

        case NORTH:
        default:
            data |= 0x0;
        }

        setData((byte) data);
    }

    /**
     * 获取这个红石比较器的朝向.
     * <p>
     * 原文:Gets the direction this comparator is facing
     *
     * @return 朝向
     *
     * @see BlockFace
     */
    @Override
    public BlockFace getFacing() {
        byte data = (byte) (getData() & 0x3);

        switch (data) {
        case 0x0:
        default:
            return BlockFace.NORTH;

        case 0x1:
            return BlockFace.EAST;

        case 0x2:
            return BlockFace.SOUTH;

        case 0x3:
            return BlockFace.WEST;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " facing " + getFacing() + " in " + (isSubtractionMode() ? "subtraction" : "comparator") + " mode";
    }

    @Override
    public Comparator clone() {
        return (Comparator) super.clone();
    }

    /**
     * 检测这个红石比较器是否充能.
     * <p>
     * 原文:Checks if the comparator is powered
     *
     * @return 这个红石比较器是否充能
     */
    @Override
    public boolean isPowered() {
        return getItemType() == Material.REDSTONE_COMPARATOR_ON;
    }

    /**
     * 检测这个红石比较器是否输出信号.
     * <p>
     * 原文:Checks if the comparator is being powered
     *
     * @return 这个红石比较器是否输出信号
     */
    public boolean isBeingPowered() {
        return (getData() & 0x8) != 0;
    }
}
