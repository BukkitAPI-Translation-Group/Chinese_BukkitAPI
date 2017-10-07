package org.bukkit.material;

import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

/**
 * 为某些物品或方块处理特定的元数据.
 */
public class MaterialData implements Cloneable {
    private final int type;
    private byte data = 0;

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public MaterialData(final int type) {
        this(type, (byte) 0);
    }

    public MaterialData(final Material type) {
        this(type, (byte) 0);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public MaterialData(final int type, final byte data) {
        this.type = type;
        this.data = data;
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public MaterialData(final Material type, final byte data) {
        this(type.getId(), data);
    }

    /**
     * 获取这个物品的原始数据。
     * <p>
     * 原文:Gets the raw data in this material
     *
     * @return 原始数据
     * @deprecated 不安全的参数
     */
    @Deprecated
    public byte getData() {
        return data;
    }

    /**
     * 设置这个物品的原始数据.
     * <p>
     * 原文：Sets the raw data of this material
     *
     * @param data 新的原始数据
     * @deprecated 不安全的参数
     */
    @Deprecated
    public void setData(byte data) {
        this.data = data;
    }

    /**
     * 获取这个MaterialData代表的Material.
     * <p>
     * 原文:Gets the Material that this MaterialData represents
     *
     * @return 这个MaterialData代表的Material
     */
    public Material getItemType() {
        return Material.getMaterial(type);
    }

    /**
     * 获取这个MaterialData代表的Material ID.
     * <p>
     * 原文：Gets the Material Id that this MaterialData represents
     *
     * @return 这个MaterialData代表的Material ID
     * @deprecated 不安全的参数
     */
    @Deprecated
    public int getItemTypeId() {
        return type;
    }

    /**
     * 基于这个MaterialData创建一个新的ItemStack.
     * <p>
     * 原文：Creates a new ItemStack based on this MaterialData
     *
     * @return 新的ItemSatck，包含这个Material的副本
     * @deprecated 这个方法创建一个大小为0的物品堆，通常没有用.
     * 考虑使用 {@link #toItemStack(int)}.
     */
    @Deprecated
    public ItemStack toItemStack() {
        return new ItemStack(type, 0, data);
    }

    /**
     * 基于这个MaterialData创建一个新的ItemStack.
     * <p>
     * 原文:Creates a new ItemStack based on this MaterialData
     *
     * @param amount 这个新的ItemStack的堆大小
     * @return 新的ItemSatck，包含这个Material的副本
     */
    public ItemStack toItemStack(int amount) {
        return new ItemStack(type, amount, data);
    }

    @Override
    public String toString() {
        return getItemType() + "(" + getData() + ")";
    }

    @Override
    public int hashCode() {
        return ((getItemTypeId() << 8) ^ getData());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof MaterialData) {
            MaterialData md = (MaterialData) obj;

            return (md.getItemTypeId() == getItemTypeId() && md.getData() == getData());
        } else {
            return false;
        }
    }

    @Override
    public MaterialData clone() {
        try {
            return (MaterialData) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }
}
