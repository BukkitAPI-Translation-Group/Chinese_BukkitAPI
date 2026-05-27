package org.bukkit.material;

import org.bukkit.Material;

/**
 * 代表一个压力板。
 *
 * @deprecated 所有 MaterialData 的用法都已弃用并可能被移除。
 * 请使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class PressurePlate extends MaterialData implements PressureSensor {
    public PressurePlate() {
        super(Material.LEGACY_WOOD_PLATE);
    }

    public PressurePlate(Material type) {
        super(type);
    }

    /**
     * @param type 物品类型
     * @param data 原始数据值
     * @deprecated 魔法值
     * <p>原文：Magic value
     */
    @Deprecated(since = "1.6.2")
    public PressurePlate(Material type, byte data) {
        super(type, data);
    }

    @Override
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