package org.bukkit.material;

import org.bukkit.CoalType;
import org.bukkit.Material;

/**
 * 代表不同种类的煤(煤和木炭)
 */
public class Coal extends MaterialData {
    public Coal() {
        super(Material.COAL);
    }

    public Coal(CoalType type) {
        this();
        setType(type);
    }

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Coal(final int type) {
        super(type);
    }

    public Coal(final Material type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Coal(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Coal(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 获取这个煤的种类.
     * <p>
     * 原文：Gets the current type of this coal
     *
     * @return 这个煤的种类(CoalType)
     */
    public CoalType getType() {
        return CoalType.getByData(getData());
    }

    /**
     * 设置这个煤的种类.
     * <p>
     * 原文：Sets the type of this coal
     *
     * @param type 这个煤的新种类
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
