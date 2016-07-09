package org.bukkit.material;

import org.bukkit.Material;

/**
 * 代表压力板
 */
public class PressurePlate extends MaterialData implements PressureSensor {
    public PressurePlate() {
        super(Material.WOOD_PLATE);
    }

    /**
     * @param type raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public PressurePlate(int type) {
        super(type);
    }

    public PressurePlate(Material type) {
        super(type);
    }

    /**
     * @param type raw type id
     * @param data raw data
     * @deprecated 不安全的参数
     */
    @Deprecated
    public PressurePlate(int type, byte data) {
        super(type, data);
    }

    /**
     * @param type 类型
     * @param data raw data
     * @deprecated 不安全的参数
     */
    @Deprecated
    public PressurePlate(Material type, byte data) {
        super(type, data);
    }

    public boolean isPressed() {
        return getData() == 0x1;
    }

    @Override
    public String toString() {
        return super.toString() + (isPressed() ? " PRESSED" : "");
    }

    @Override
    public PressurePlate clone() {
        return (PressurePlate) super.clone();
    }
}
