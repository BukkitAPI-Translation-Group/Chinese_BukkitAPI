package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 表示一个处于开启或关闭状态的二极管/中继器，具有延迟并面向特定方向。
 *
 * @see Material#LEGACY_DIODE_BLOCK_OFF
 * @see Material#LEGACY_DIODE_BLOCK_ON
 *
 * @deprecated all usage of MaterialData is deprecated and subject to removal.
 * Use {@link org.bukkit.block.data.BlockData}.
 */
@Deprecated(since = "1.14.1")
public class Diode extends MaterialData implements Directional, Redstone {

    protected static final BlockFace DEFAULT_DIRECTION = BlockFace.NORTH;
    protected static final int DEFAULT_DELAY = 1;
    protected static final boolean DEFAULT_STATE = false;

    /**
     * 构造一个开启的二极管，延迟为1且面向默认方向（北）。
     * <p>原文：Constructs a diode switched on, with a delay of 1 and facing the default direction (north).
     *
     * By default this constructor creates a diode that is switched on for
     * backwards compatibility with past implementations.
     */
    public Diode() {
        this(DEFAULT_DIRECTION, DEFAULT_DELAY, true);
    }

    /**
     * 构造一个关闭的二极管，延迟为1且面向指定方向。
     * <p>原文：Constructs a diode switched off, with a delay of 1 and facing the specified direction.
     *
     * @param facingDirection the direction the diode is facing
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
     * @param facingDirection the direction the diode is facing
     * @param delay The number of ticks (1-4) before the diode turns on after
     * being powered
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
     * @param facingDirection the direction the diode is facing
     * @param delay The number of ticks (1-4) before the diode turns on after
     * being powered
     * @param state True if the diode is in the on state
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
     * @param type the type
     * @param data the raw data value
     * @deprecated Magic value
     */
    @Deprecated(since = "1.6.2")
    public Diode(Material type, byte data) {
        super(type, data);
    }

    /**
     * 设置中继器的延迟。
     * <p>原文：Sets the delay of the repeater.
     *
     * @param delay The new delay (1-4)
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
     * @return The delay (1-4)
     */
    public int getDelay() {
        return (getData() >> 2) + 1;
    }

    /**
     * 设置此二极管面向的方向。
     * <p>原文：Sets the direction this diode is facing.
     *
     * @param face The direction to set this diode to
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
     * <p>原文：Gets the direction this diode is facing
     *
     * @return The direction this diode is facing
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
     * @return true if the diode is powered
     */
    @Override
    public boolean isPowered() {
        return getItemType() == Material.LEGACY_DIODE_BLOCK_ON;
    }
}