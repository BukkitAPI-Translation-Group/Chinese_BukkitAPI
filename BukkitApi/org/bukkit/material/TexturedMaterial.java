package org.bukkit.material;

import java.util.List;

import org.bukkit.Material;

/**
 * 代表有材质的物品，比如台阶和石砖
 */
public abstract class TexturedMaterial extends MaterialData {

    public TexturedMaterial(Material m) {
        super(m);
    }

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public TexturedMaterial(int type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public TexturedMaterial(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public TexturedMaterial(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 检索可能的材质列表.列表的第一个元素将用来作为缺省值.
     * <p>
     * 原文:Retrieve a list of possible textures. The first element of the list
     * will be used as a default.
     *
     * @return 这个方块可能的材质列表
     */
    public abstract List<Material> getTextures();

    /**
     * 获取这个方块是由什么物品制成的。
     * <p>
     * 原文:Gets the current Material this block is made of
     *
     * @return 这个方块由什么物品制成
     */
    public Material getMaterial() {
        int n = getTextureIndex();
        if (n > getTextures().size() - 1) {
            n = 0;
        }

        return getTextures().get(n);
    }

    /**
     * 设置这个方块是由什么物品制成的.
     * <p>
     * 原文:Sets the material this block is made of
     *
     * @param material 这个方块由什么物品制成
     */
    public void setMaterial(Material material) {
        if (getTextures().contains(material)) {
            setTextureIndex(getTextures().indexOf(material));
        } else {
            setTextureIndex(0x0);
        }
    }

    /**
     * 获取物品的材质类型。
     * <p>
     * 译注:该方法即为获取物品数据值。关于数据值，请参考Minecraft Wiki。
     * <p>
     * 原文:Get material index from data
     *
     * @return 物品的材质类型
     * @deprecated 不安全的参数
     */
    @Deprecated
    protected int getTextureIndex() {
        return getData(); // Default to using all bits - override for other mappings
    }

    /**
     * 设置物品的材质类型。
     * <p>
     * 译注:该方法即为设置物品数据值。关于数据值，请参考Minecraft Wiki。
     * <p>
     * 原文:Set material index
     *
     * @param idx 物品的材质类型
     * @deprecated 不安全的参数
     */
    @Deprecated
    protected void setTextureIndex(int idx) {
        setData((byte) idx); // Default to using all bits - override for other mappings
    }

    @Override
    public String toString() {
        return getMaterial() + " " + super.toString();
    }

    @Override
    public TexturedMaterial clone() {
        return (TexturedMaterial) super.clone();
    }
}
