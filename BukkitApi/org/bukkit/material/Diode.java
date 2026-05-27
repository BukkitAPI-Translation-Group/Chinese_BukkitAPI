package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 表示一个处于开启或关闭状态的二极管/中继器，具有延迟并面向特定方向。
 *
 * @see Material#LEGACY_DIODE_BLOCK_OFF
 * @see Material#LEGACY_DIODE_BLOCK_ON
 *
 * @deprecated 所有MaterialData的用法都已弃用并将被移除。
 * 请使用{@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class Diode extends MaterialData implements Directional, Redstone {

    protected static final BlockFace DEFAULT_DIRECTION = BlockFace.NORTH;
    protected static final int DEFAULT_DELAY = 1;
    protected static final boolean DEFAULT_STATE = false;

    /**
     * 构造一个开启的二极管，延迟为1且面向默认方向（北）。
     * <p>原文：Constructs a diode switched on, with a delay of 1 and facing the default direction (north).
     * <p>
     * 默认情况下, 此构造函数创建一个开启的二极管, 以保持与过去实现的向后兼容性.
     */
    public Diode() {
        this(DEFAULT_DIRECTION, DEFAULT_DELAY, true);
    }

    /**
     * 构造一个关闭的二极管，延迟为1且面向指定方向。
     * <p>原文：Constructs a diode switched off, with a delay of 1 and facing the specified direction.
     *
     * @param facingDirection 二极管面向的方向
     *
     * @see BlockFace
     */
    public Diode(BlockFace facingDirection) {
        this(facingDirection, DEFAULT_DELAY, DEFAULT_STATE);
    }

    /**
     * 构造一个关闭的二极管，具有指定延迟并面向指定方向。
     * <p>原文：Constructs a diode switched off, with the specified delay and facing the specified direction.
     *
     * @param facingDirection 二极管面向的方向
     * @param delay 二极管被充能后开启所需的 tick 数（1-4）
     *
     * @see BlockFace
     */
    public Diode(BlockFace facingDirection, int delay) {
        this(facingDirection, delay, DEFAULT_STATE);
    }

    /**
     * 构造一个开启或关闭的二极管，具有指定延迟并面向指定方向。
     * <p>原文：Constructs a diode switched on or off, with the specified delay and facing the specified direction.
     *
     * @param facingDirection 二极管面向的方向
     * @param delay 二极管被充能后开启所需的 tick 数（1-4）
     * @param state 二极管是否处于开启状态
     *
     * @see BlockFace
     */
    public Diode(BlockFace facingDirection, int delay, boolean state) {
        super(state ? Material.LEGACY_DIODE_BLOCK_ON : Material.LEGACY_DIODE_BLOCK_OFF);
        setFacingDirection(facingDirection);
        setDelay(delay);
    }

    public Diode(Material type) {
        super(type);
    }

    /**
     * @param type 类型
     * @param data 原始数据值
     * @deprecated 不安全的参数
     */
    @Deprecated(since = "1.6.2")
    public Diode(Material type, byte data) {
        super(type, data);
    }

    /**
     * 设置中继器的延迟。
     * <p>原文：Sets the delay of the repeater.
     *
     * @param delay 新延迟（1-4）
     */
    public void setDelay(int delay) {
        if (delay > 4) {
            delay = 4;
        }
        if (delay < 1) {
            delay = 1;
        }
        byte newData = (byte) (getData() & 0x3);

        setData((byte) (newData | ((delay - 1) << 2)));
    }

    /**
     * 获取中继器的延迟（以tick为单位）。
     * <p>原文：Gets the delay of the repeater in ticks.
     *
     * @return 延迟（1-4）
     */
    public int getDelay() {
        return (getData() >> 2) + 1;
    }

    /**
     * 设置此二极管面向的方向。
     * <p>原文：Sets the direction this diode is facing.
     *
     * @param face 此二极管要面向的方向
     *
     * @see BlockFace
     */
    @Override
    public void setFacingDirection(BlockFace face) {
        int delay = getDelay();
        byte data;

        switch (face) {
            case EAST:
                data = 0x1;
                break;
            case SOUTH:
                data = 0x2;
                break;
            case WEST:
                data = 0x3;
                break;
            case NORTH:
            default:
                data = 0x0;
        }

        setData(data);
        setDelay(delay);
    }

    /**
     * 获取此二极管面向的方向。
     * <p>原文：Gets the direction this diode is facing.
     *
     * @return 此二极管面向的方向
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
        return super.toString() + " facing " + getFacing() + " with " + getDelay() + " ticks delay";
    }

    @Override
    public Diode clone() {
        return (Diode) super.clone();
    }

    /**
     * 检查二极管是否被充能。
     * <p>原文：Checks if the diode is powered.
     *
     * @return 二极管是否被充能
     */
    @Override
    public boolean isPowered() {
        return getItemType() == Material.LEGACY_DIODE_BLOCK_ON;
    }
}