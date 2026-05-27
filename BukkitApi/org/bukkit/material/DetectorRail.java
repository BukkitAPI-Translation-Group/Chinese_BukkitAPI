package org.bukkit.material;

import org.bukkit.Material;

/**
 * 代表一个探测铁轨。
 *
 * @deprecated 所有 MaterialData 的用法均已弃用并可能被移除。
 * 请使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class DetectorRail extends ExtendedRails implements PressureSensor {
    public DetectorRail() {
        super(Material.LEGACY_DETECTOR_RAIL);
    }

    public DetectorRail(final Material type) {
        super(type);
    }

    /**
     * @param type 类型
     * @param data 原始数据值
     * @deprecated 魔法值
     */
    @Deprecated(since = "1.6.2")
    public DetectorRail(final Material type, final byte data) {
        super(type, data);
    }

    @Override
    public boolean isPressed() {
        return (getData() & 0x8) == 0x8;
    }

    public void setPressed(boolean isPressed) {
        setData((byte) (isPressed ? (getData() | 0x8) : (getData() & ~0x8)));
    }

    @Override
    public DetectorRail clone() {
        return (DetectorRail) super.clone();
    }
}