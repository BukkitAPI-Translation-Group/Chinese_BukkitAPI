package org.bukkit.block.data;

import org.bukkit.Material;
import org.bukkit.Server;

public interface BlockData extends Cloneable {

    /**
     * 获取该BlockData实例描述的物品.
     * <p>
     * 原文:Get the Material represented by this block data.
     *
     * @return 物品
     */
    Material getMaterial();

    /**
     * 获取方块数据值,当将此数据值传入给 {@link Server#createBlockData(java.lang.String)}
     * 方法时,将无缝重建此实例.
     * <p>
     * 原文:Gets a string, which when passed into a method such as
     * {@link Server#createBlockData(java.lang.String)} will unambiguously
     * recreate this instance.
     *
     * @return 方块序列化的数据值
     */
    String getAsString();

    /**
     * 返回该BlockData实例的副本.
     * <p>
     * 原文:Returns a copy of this BlockData.
     *
     * @return BlockData副本
     */
    BlockData clone();
}
