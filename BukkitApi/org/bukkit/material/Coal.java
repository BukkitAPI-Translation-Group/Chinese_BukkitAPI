package org.bukkit.material;

import org.bukkit.CoalType;
import org.bukkit.Material;

/**
 * 代表不同类型的煤炭。
 *
 * @deprecated 所有 MaterialData 的用法均已弃用并可能被移除。
 * 请使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class Coal extends MaterialData {
    public Coal() {
        super(Material.LEGACY_COAL);
    }

    public Coal(CoalType type) {
        this();
        setType(type);
    }

    public Coal(final Material type) {
        super(type);
    }

    /**
     * @param type 类型
     * @param data 原始数据值
     * @deprecated 魔法值
     */
    @Deprecated(since = "1.6.2")
    public Coal(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 获取此煤炭的当前类型。
     *
     * @return 此煤炭的 CoalType
     * <p>
     * 原文：Gets the current type of this coal
     */
    public CoalType getType() {
        return CoalType.getByData(getData());
    }

    /**
     * 设置此煤炭的类型。
     *
     * @param type 此煤炭的新类型
     * <p>
     * 原文：Sets the type of this coal
     */
    public void setType(CoalType type) {
        setData(type.getData());
    }

    @Override
    public String toString() {
        return getType() + " " + super.toString();
    }

    @Override
    public Coal clone() {
        return (Coal) super.clone();
    }
}