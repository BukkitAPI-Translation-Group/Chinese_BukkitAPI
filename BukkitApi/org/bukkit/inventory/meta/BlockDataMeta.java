package org.bukkit.inventory.meta;

import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.jetbrains.annotations.NotNull;

public interface BlockDataMeta extends ItemMeta {

    /**
     * 返回此物品是否有附加的方块数据.
     * <p>
     * 原文:
     * Returns whether the item has block data currently attached to it.
     *
     * @return 是否附加了方块数据
     */
    boolean hasBlockData();

    /**
     * 返回附加给此物品的方块数据, 若不存在则创建一个新的.
     *
     * 此状态是一个副本, 它必须用 {@link #setBlockData(org.bukkit.block.data.BlockData)} 设置回去 (或设置给其它物品).
     * <p>
     * 原文:
     * Returns the currently attached block data for this item or creates a new
     * one if one doesn't exist.
     *
     * The state is a copy, it must be set back (or to another item) with
     * {@link #setBlockData(org.bukkit.block.data.BlockData)}
     *
     * @param material 希望获取到的方块数据与哪种物品相关
     * @return 附加的数据或新数据
     */
    @NotNull
    BlockData getBlockData(@NotNull Material material);

    /**
     * 附加方块数据副本给此物品.
     * <p>
     * 原文:
     * Attaches a copy of the passed block data to the item.
     *
     * @param blockData 要附加的方块数据
     * @throws IllegalArgumentException 若 blockData 为 null 或对此物品无效
     */
    void setBlockData(@NotNull BlockData blockData);
}
