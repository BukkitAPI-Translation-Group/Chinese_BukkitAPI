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
     * @param type 原始类型id
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
     * @param type 原始类型id
     * @param data 原始数据值
     * @deprecated 不安全的参数
     */
    @Deprecated
    public PressurePlate(int type, byte data) {
        super(type, data);
    }

    /**
     * @param type 类型
     * @param data 原始数据值
     * @deprecated 不安全的参数
     */
    @Deprecated
    public PressurePlate(Material type, byte data) {
        super(type, data);
    }

    /**
     * 检测这个压力板是否被触发(踩下).
     * <p>
     * 注：译者自加.
     */
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