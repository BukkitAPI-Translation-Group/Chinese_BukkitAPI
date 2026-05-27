package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表箱子.
 * @deprecated 所有 MaterialData 的用法均已弃用且将被移除.
 * 请使用 {@link org.bukkit.block.data.BlockData}.
 */
@Deprecated(since = "1.14.1")
public class Chest extends DirectionalContainer {

    public Chest() {
        super(Material.LEGACY_CHEST);
    }

    /**
     * 实例化一个特定朝向的箱子.
     * <p>
     * 原文:Instantiate a chest facing in a particular direction.
     *
     * @param direction 箱子打开时的朝向
     */
    public Chest(BlockFace direction) {
        this();
        setFacingDirection(direction);
    }

    public Chest(final Material type) {
        super(type);
    }

    /**
     * @param type 物品类型
     * @param data 原始数据值
     * @deprecated 不安全的参数
     */
    @Deprecated(since = "1.6.2")
    public Chest(final Material type, final byte data) {
        super(type, data);
    }

    @Override
    public Chest clone() {
        return (Chest) super.clone();
    }
}
