package org.bukkit.event.player;

import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.entity.Player;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

/**
 * 当玩家与装甲架交互并且进行交换, 取回或放置物品时触发本事件.
 * <p>
 * 原文: Called when a player interacts with an armor stand and will either swap, retrieve or place an item.
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
     * 返回玩家手持的物品.
     * <ul>
     * <li>如果玩家手持的物品为null时, 并且盔甲架的物品也为null时, 那么则玩家和盔甲架之间将不会有物品交换.</li>
     * <li>如果玩家手持的物品为null时，但是盔甲架的物品不为null时，那么玩家将获得盔甲架的物品.</li>
     * <li>如果玩家手持的物品不为null时，但盔甲架的物品为null时，则玩家物品将被放在盔甲架上.</li>
     * <li>如果玩家手持的物品不为null时，盔甲架的物品也不为null时，则玩家物品将和盔甲架的物品将进行交换.</li>
     * <li>如果该事件被取消, 那么交换将不会进行, 即物品不会进行交换.</li>
     * </ul>
     * <p>
     * 原文: Returns the item held by the player. If this Item is null and the armor stand Item is also null,
     * there will be no transaction between the player and the armor stand.
     * If the Player's item is null, but the armor stand item is not then the player will obtain the armor stand item.
     * In the case that the Player's item is not null, but the armor stand item is null, the players item will be placed on the armor stand.
     * If both items are not null, the items will be swapped.
     * In the case that the event is cancelled the original items will remain the same.
     *
     * @return 玩家手持的物品 {@link ItemStack}
     */
    public ItemStack getPlayerItem() {
        return this.playerItem;
    }

    /**
     * 返回盔甲架的物品
     * <ul>
     * <li>如果玩家手持的物品为null时, 并且盔甲架的物品也为null时, 那么则玩家和盔甲架之间将不会有物品交换.</li>
     * <li>如果玩家手持的物品为null时，但是盔甲架的物品不为null时，那么玩家将获得盔甲架的物品.</li>
     * <li>如果玩家手持的物品不为null时，但盔甲架的物品为null时，则玩家物品将被放在盔甲架上.</li>
     * <li>如果玩家手持的物品不为null时，盔甲架的物品也不为null时，则玩家物品将和盔甲架的物品将进行交换.</li>
     * <li>如果该事件被取消, 那么交换将不会进行, 即物品不会进行交换.</li>
     * </ul>
     * <p>
     * 原文: Returns the item held by the armor stand.
     * If this Item is null and the player's Item is also null, there will be no transaction between the player and the armor stand.
     * If the Player's item is null, but the armor stand item is not then the player will obtain the armor stand item.
     * In the case that the Player's item is not null, but the armor stand item is null, the players item will be placed on the armor stand.
     * If both items are not null, the items will be swapped.
     * In the case that the event is cancelled the original items will remain the same.
     *
     * @return 盔甲架的的物品 {@link ItemStack}
     */
    public ItemStack getArmorStandItem() {
        return this.armorStandItem;
    }

    /**
     * 返回在此事件中盔甲架的装备槽.
     * <p>
     * 原文: Returns the raw item slot of the armor stand in this event.
     *
     * @return 获得或放置盔甲架的物品的下标. {@link EquipmentSlot}
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
