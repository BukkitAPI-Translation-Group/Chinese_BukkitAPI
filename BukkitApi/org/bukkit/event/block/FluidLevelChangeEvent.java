package org.bukkit.event.block;

import com.google.common.base.Preconditions;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当液体方块的液面高度因相邻方块而发生变化时触发本事件.
 */
public class FluidLevelChangeEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    //
    private BlockData newData;

    public FluidLevelChangeEvent(@NotNull Block theBlock, @NotNull BlockData newData) {
        super(theBlock);
        this.newData = newData;
    }

    /**
     * 获取变化后的方块的新数据.
     * <p>
     * 原文:Gets the new data of the changed block.
     *
     * @return 新方块数据
     */
    @NotNull
    public BlockData getNewData() {
        return newData;
    }

    /**
     * 设置变化后的方块的新数据. 必须与旧方块数据描述的物品种类相同.
     * <p>
     * 原文:Sets the new data of the changed block. Must be of the same Material as
     * the old one.
     *
     * @param newData 新方块数据
     */
    public void setNewData(@NotNull BlockData newData) {
        Preconditions.checkArgument(newData != null, "newData null");
        Preconditions.checkArgument(this.newData.getMaterial().equals(newData.getMaterial()), "Cannot change fluid type");

        this.newData = newData;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
