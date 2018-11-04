package org.bukkit.material;

import org.bukkit.Material;

/**
 * 代表命令方块.
 */
public class Command extends MaterialData implements Redstone {
    public Command() {
        super(Material.LEGACY_COMMAND);
    }

    public Command(final Material type) {
        super(type);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Command(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 获取这个方块是否充能.
     * <p>
     * 原文:Gets the current state of this Material, indicating if it's powered or
     * unpowered
     *
     * @return 这个方块是否充能
     */
    public boolean isPowered() {
        return (getData() & 1) != 0;
    }

    /**
     * 设置这个方块是否充能.
     * <p>
     * 原文:Sets the current state of this Material
     *
     * @param bool 这个方块是否充能
     */
    public void setPowered(boolean bool) {
        setData((byte) (bool ? (getData() | 1) : (getData() & -2)));
    }

    @Override
    public String toString() {
        return super.toString() + " " + (isPowered() ? "" : "NOT ") + "POWERED";
    }

    @Override
    public Command clone() {
        return (Command) super.clone();
    }
}
