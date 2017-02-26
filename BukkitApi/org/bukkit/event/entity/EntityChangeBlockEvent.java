package org.bukkit.event.entity;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当一个非玩家的实体在改变方块时调用该事件。
 * 原文:
 * Called when any Entity, excluding players, changes a block.
 */
public class EntityChangeBlockEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Block block;
    private boolean cancel;
    private final Material to;
    private final byte data;

    /**
     * @param what 造成这次方块改变的生物实体(LivingEntity)类
     * @param block 改变前的方块(Block)类
     * @param to 改变后的材料(Material)类
     * @param data 改变之后的方块数据值
     * @deprecated 不安全的参数
     */
    @Deprecated
    public EntityChangeBlockEvent(final Entity what, final Block block, final Material to, final byte data) {
        super(what);
        this.block = block;
        this.cancel = false;
        this.to = to;
        this.data = data;
    }

    /**
     * 返回改变之前的方块(Block)类
     * 
     * 原文:
     * Gets the block the entity is changing
     *
     * @return 改变之前的方块(Block)类
     */
    public Block getBlock() {
        return block;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * 返回改变后的材料(Material)类
     * 
     * 原文：
     * Gets the Material that the block is changing into
     *
     * @return 改变后的材料(Material)类
     */
    public Material getTo() {
        return to;
    }

    /**
     * 返回改变后的数据值
     * 
     * 原文:
     * Gets the data for the block that would be changed into
     *
     * @return 改变后的数据值
     * @deprecated 不安全的参数
     */
    @Deprecated
    public byte getData() {
        return data;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
