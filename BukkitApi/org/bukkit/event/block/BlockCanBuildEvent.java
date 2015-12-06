package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.Material;
import org.bukkit.event.HandlerList;

/**
 * 当我们尝试建造一个方块的时候，可以看到我们是否可以在此建造它。
 * <p>
 * 注意:
 * <ul>
 * <li>方法 getBlock() 返回的是我们正试图放置在其上面的方块,不是我们试图放置的方块。
 * <li>如果你想知道玩家放置的是什么方块, 用 {@link #getMaterial()} 或者 {@link #getMaterialId()} 来代替.
 * </ul>
 */
public class BlockCanBuildEvent extends BlockEvent {
    private static final HandlerList handlers = new HandlerList();
    protected boolean buildable;

    /**
     *
     * @deprecated 不安全的参数
     */
    @Deprecated
    protected int material;

    /**
     *
     * @deprecated 不安全的参数
     * @param block 这个事件涉及的方块
     * @param id 这个要放置的方块的ID
     * @param canBuild 是否可以建造
     */
    @Deprecated
    public BlockCanBuildEvent(final Block block, final int id, final boolean canBuild) {
        super(block);
        buildable = canBuild;
        material = id;
    }

    /**
     * 获取是否可以在此建造此方块
     * <p>
     * 默认情况下, 是否可以在此建造返回的是 Minecraft的值。
     * <p>
     * 原文：Gets whether or not the block can be built here.
     * <p>
     * By default, returns Minecraft's answer on whether the block can be
     * built here or not.
     *
     * @return boolean 此方块是否可以在此建造
     */
    public boolean isBuildable() {
        return buildable;
    }

    /**
     * 设置此方块是否可以在此建造。
     * <p>
     * 原文：Sets whether the block can be built here or not.
     *
     * @param cancel 允许建造请输入true,反之为false。
     */
    public void setBuildable(boolean cancel) {
        this.buildable = cancel;
    }

    /**
     * 获取我们试图放置的方块的 Material.
     * 原文：Gets the Material that we are trying to place.
     *
     * @return 我们试图放置的方块的 Material
     */
    public Material getMaterial() {
        return Material.getMaterial(material);
    }

    /**
     * 获取我们试图放置的方块的ID.
     * <p>
     * 原文：Gets the Material ID for the Material that we are trying to place.
     *
     * @return 我们试图放置的方块的ID
     * @deprecated 不安全的参数
     */
    @Deprecated
    public int getMaterialId() {
        return material;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}