package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表一个处于开启或关闭状态、处于正常或减法模式并朝向特定方向的比较器。
 *
 * @see Material#LEGACY_REDSTONE_COMPARATOR_OFF
 * @see Material#LEGACY_REDSTONE_COMPARATOR_ON
 *
 * @deprecated 所有 MaterialData 的用法均已弃用并可能被移除。
 * 请使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class Comparator extends MaterialData implements Directional, Redstone {
    protected static final BlockFace DEFAULT_DIRECTION = BlockFace.NORTH;
    protected static final boolean DEFAULT_SUBTRACTION_MODE = false;
    protected static final boolean DEFAULT_STATE = false;

    /**
     * 构造一个关闭的比较器，使用默认模式（正常）并朝向默认方向（北）。
     * <p>
     * 原文：Constructs a comparator switched off, with the default mode (normal) and facing the default direction (north).
     */
    public Comparator() {
        this(DEFAULT_DIRECTION, DEFAULT_SUBTRACTION_MODE, false);
    }

    /**
     * 构造一个关闭的比较器，使用默认模式（正常）并朝向指定方向。
     *
     * @param facingDirection 比较器朝向的方向
     *
     * @see BlockFace
     * <p>
     * 原文：Constructs a comparator switched off, with the default mode (normal) and facing the specified direction.
     */
    public Comparator(BlockFace facingDirection) {
        this(facingDirection, DEFAULT_SUBTRACTION_MODE, DEFAULT_STATE);
    }

    /**
     * 构造一个关闭的比较器，使用指定模式并朝向指定方向。
     *
     * @param facingDirection 比较器朝向的方向
     * @param isSubtraction 如果比较器处于减法模式则为 true，正常比较器操作则为 false
     *
     * @see BlockFace
     * <p>
     * 原文：Constructs a comparator switched off, with the specified mode and facing the specified direction.
     */
    public Comparator(BlockFace facingDirection, boolean isSubtraction) {
        this(facingDirection, isSubtraction, DEFAULT_STATE);
    }

    /**
     * 构造一个开启或关闭的比较器，使用指定模式并朝向指定方向。
     *
     * @param facingDirection 比较器朝向的方向
     * @param isSubtraction 如果比较器处于减法模式则为 true，正常比较器操作则为 false
     * @param state 如果比较器处于开启状态则为 true
     *
     * @see BlockFace
     * <p>
     * 原文：Constructs a comparator switched on or off, with the specified mode and facing the specified direction.
     */
    public Comparator(BlockFace facingDirection, boolean isSubtraction, boolean state) {
        super(state ? Material.LEGACY_REDSTONE_COMPARATOR_ON : Material.LEGACY_REDSTONE_COMPARATOR_OFF);
        setFacingDirection(facingDirection);
        setSubtractionMode(isSubtraction);
    }

    public Comparator(Material type) {
        super(type);
    }

    /**
     * @param type 类型
     * @param data 原始数据值
     * @deprecated 魔法值
     */
    @Deprecated(since = "1.9")
    public Comparator(Material type, byte data) {
        super(type, data);
    }

    /**
     * 设置比较器是否处于减法模式。
     *
     * @param isSubtraction 如果比较器处于减法模式则为 true，正常比较器操作则为 false
     * <p>
     * 原文：Sets whether the comparator is in subtraction mode.
     */
    public void setSubtractionMode(boolean isSubtraction) {
        setData((byte) (getData() & 0xB | (isSubtraction ? 0x4 : 0x0)));
    }

    /**
     * 检查比较器是否处于减法模式。
     *
     * @return 如果比较器处于减法模式则返回 true，正常比较器操作则返回 false
     * <p>
     * 原文：Checks whether the comparator is in subtraction mode
     */
    public boolean isSubtractionMode() {
        return (getData() & 0x4) != 0;
    }

    /**
     * 设置此比较器的朝向。
     *
     * @param face 设置此比较器的方向
     *
     * @see BlockFace
     * <p>
     * 原文：Sets the direction this comparator is facing
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
     * 获取此比较器的朝向。
     *
     * @return 此比较器的朝向
     *
     * @see BlockFace
     * <p>
     * 原文：Gets the direction this comparator is facing
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
     * 检查比较器是否被激活。
     *
     * @return 如果比较器被激活则返回 true
     * <p>
     * 原文：Checks if the comparator is powered
     */
    @Override
    public boolean isPowered() {
        return getItemType() == Material.LEGACY_REDSTONE_COMPARATOR_ON;
    }

    /**
     * 检查比较器是否正在被供电。
     *
     * @return 如果比较器正在被供电则返回 true
     * <p>
     * 原文：Checks if the comparator is being powered
     */
    public boolean isBeingPowered() {
        return (getData() & 0x8) != 0;
    }
}