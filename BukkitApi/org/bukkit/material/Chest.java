package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表箱子
 */
public class Chest extends DirectionalContainer {

    public Chest() {
        super(Material.CHEST);
    }

    /**
     * 实例化一个特定朝向的箱子.
     * <p>
     * 原文：Instantiate a chest facing in a particular direction.
     *
     * @param direction 箱子打开时的朝向
     */
    public Chest(BlockFace direction) {
        this();
        setFacingDirection(direction);
    }

    /**
     * @param type 原始类型id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Chest(final int type) {
        super(type);
    }

    public Chest(final Material type) {
        super(type);
    }

    /**
     * @param type 原始类型id
     * @param data 原始数据值
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Chest(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type 类型
     * @param data 原始数据值
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Chest(final Material type, final byte data) {
        super(type, data);
    }

    @Override
    public Chest clone() {
        return (Chest) super.clone();
    }
}