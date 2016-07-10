package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.SandstoneType;

/**
 * 代表不同种类的沙石.
 */
public class Sandstone extends MaterialData {
    public Sandstone() {
        super(Material.SANDSTONE);
    }

    public Sandstone(SandstoneType type) {
        this();
        setType(type);
    }

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Sandstone(final int type) {
        super(type);
    }

    public Sandstone(final Material type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Sandstone(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Sandstone(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 获取这个沙石的种类.
     * <p>
     * 原文：Gets the current type of this sandstone
     *
     * @return 沙石的种类
     */
    public SandstoneType getType() {
        return SandstoneType.getByData(getData());
    }

    /**
     * 设置这个沙石的种类.
     * <p>
     * 原文：Sets the type of this sandstone
     *
     * @param type 新种类
     */
    public void setType(SandstoneType type) {
        setData(type.getData());
    }

    @Override
    public String toString() {
        return getType() + " " + super.toString();
    }

    @Override
    public Sandstone clone() {
        return (Sandstone) super.clone();
    }
}
