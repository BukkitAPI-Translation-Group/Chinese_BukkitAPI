package org.bukkit.event.inventory;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockExpEvent;

/**
 * 当玩家从熔炉取出产物时触发这个事件. 
 */
public class FurnaceExtractEvent extends BlockExpEvent {
    private final Player player;
    private final Material itemType;
    private final int itemAmount;

    public FurnaceExtractEvent(Player player, Block block, Material itemType, int itemAmount, int exp) {
        super(block, exp);
        this.player = player;
        this.itemType = itemType;
        this.itemAmount = itemAmount;
    }

    /**
     * 获取触发这个事件的玩家. 
     * <p>
     * 原文:Get the player that triggered the event
     *
     * @return 触发这个事件的玩家(译注:即拿取熔炼产物的玩家)
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * 获取被取出的物品的类型. 
     * <p>
     * 原文：Get the Material of the item being retrieved
     *
     * @return 物品类型
     */
    public Material getItemType() {
        return itemType;
    }

    /**
     * 获取被取出的物品的数量. 
     * <p>
     * 原文:Get the item count being retrieved
     *
     * @return 物品数量
     */
    public int getItemAmount() {
        return itemAmount;
    }
}
