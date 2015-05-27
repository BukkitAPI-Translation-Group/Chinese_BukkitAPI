package org.bukkit.event.player;

import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.entity.Player;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

/**
 * 在当玩家与盔甲架互交的时候被激发.
 */
public class PlayerArmorStandManipulateEvent extends PlayerInteractEntityEvent {

    private static final HandlerList handlers = new HandlerList();

    private final ItemStack playerItem;
    private final ItemStack armorStandItem;
    private final EquipmentSlot slot;

    public PlayerArmorStandManipulateEvent(final Player who, final ArmorStand clickedEntity, final ItemStack playerItem, final ItemStack armorStandItem, final EquipmentSlot slot) {
        super(who, clickedEntity);
        this.playerItem = playerItem;
        this.armorStandItem = armorStandItem;
        this.slot = slot;
    }

    /**
     * 获得玩家手里握着的物品
     * 如果玩家是空手右键而且盔甲架上面也是空的，这个事件不会被调动
     * 如果玩家是空手而盔甲架上面有物品，玩家会获得这个物品
     * 其他的还要解释么.....
     * 如果事件被取消的话所有物品会保持一致
     * @return 玩家手里的物品
     */
    public ItemStack getPlayerItem() {
        return this.playerItem;
    }

    /**
     * 获得盔甲架上面的物品
     * 如果玩家是空手右键而且盔甲架上面也是空的，这个事件不会被调动
     * 如果玩家是空手而盔甲架上面有物品，玩家会获得这个物品
     * 其他的还要解释么.....
     * @return 盔甲架上面的物品
     */
    public ItemStack getArmorStandItem() {
        return this.armorStandItem;
    }

    /**
     * 获得在这个事件中盔甲架被调用的物品栏编号.
     *
     * @return 盔甲架被调用的物品栏编号.
     */
    public EquipmentSlot getSlot() {
        return this.slot;
    }

    @Override
    public ArmorStand getRightClicked() {
        return (ArmorStand) this.clickedEntity;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
