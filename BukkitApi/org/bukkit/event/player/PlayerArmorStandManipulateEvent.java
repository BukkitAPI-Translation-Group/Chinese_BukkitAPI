package org.bukkit.event.player;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 当玩家与装甲架交互并且进行交换, 取回或放置物品时触发本事件.
 * <p>
 * 原文: Called when a player interacts with an armor stand and will either swap, retrieve or
 * place an item.
 */
public class PlayerArmorStandManipulateEvent extends PlayerInteractEntityEvent {

    private static final HandlerList handlers = new HandlerList();

    private final ItemStack playerItem;
    private final ItemStack armorStandItem;
    private final EquipmentSlot slot;

    public PlayerArmorStandManipulateEvent(@NotNull final Player who, @NotNull final ArmorStand clickedEntity, @NotNull final ItemStack playerItem, @NotNull final ItemStack armorStandItem, @NotNull final EquipmentSlot slot, @NotNull EquipmentSlot hand) {
        super(who, clickedEntity, hand);
        this.playerItem = playerItem;
        this.armorStandItem = armorStandItem;
        this.slot = slot;
    }

    @Deprecated(since = "1.19.2")
    public PlayerArmorStandManipulateEvent(@NotNull final Player who, @NotNull final ArmorStand clickedEntity, @NotNull final ItemStack playerItem, @NotNull final ItemStack armorStandItem, @NotNull final EquipmentSlot slot) {
        this(who, clickedEntity, playerItem, armorStandItem, slot, EquipmentSlot.HAND);
    }

    /**
     * 返回玩家手持的物品.
     * <ul>
     * <li>如果玩家手持的物品为空时, 并且盔甲架的物品也为空时, 那么则玩家和盔甲架之间将不会有物品交换.</li>
     * <li>如果玩家手持的物品为空时，但是盔甲架的物品不为空时，那么玩家将获得盔甲架的物品.</li>
     * <li>如果玩家手持的物品不为空时，但盔甲架的物品为空时，则玩家物品将被放在盔甲架上.</li>
     * <li>如果玩家手持的物品不为空时，盔甲架的物品也不为空时，则玩家物品将和盔甲架的物品将进行交换.</li>
     * <li>如果该事件被取消, 那么交换将不会进行, 即物品不会进行交换.</li>
     * </ul>
     * <p>
     * 原文: Returns the item held by the player.
     * <p>
     * If this item is empty and the armor stand item is also empty, there will be no
     * transaction between the player and the armor stand. If the player's item is empty
     * but the armor stand item is not, the player's item will be placed on the armor
     * stand. If both items are not empty, the items will be swapped.
     * <p>
     * In the case that this event is cancelled, the original items will remain the same.
     * @return the item held by the player.
     *
     * @return 玩家手持的物品 {@link ItemStack}
     */
    @NotNull
    public ItemStack getPlayerItem() {
        return this.playerItem;
    }

    /**
     * 返回盔甲架的物品.
     * <ul>
     * <li>如果玩家手持的物品为空时, 并且盔甲架的物品也为空时, 那么则玩家和盔甲架之间将不会有物品交换.</li>
     * <li>如果玩家手持的物品为空时，但是盔甲架的物品不为空时，那么玩家将获得盔甲架的物品.</li>
     * <li>如果玩家手持的物品不为空时，但盔甲架的物品为空时，则玩家物品将被放在盔甲架上.</li>
     * <li>如果玩家手持的物品不为空时，盔甲架的物品也不为空时，则玩家物品将和盔甲架的物品将进行交换.</li>
     * <li>如果该事件被取消, 那么交换将不会进行, 即物品不会进行交换.</li>
     * </ul>
     * <p>
     * 原文: Returns the item held by the armor stand.
     * <p>
     * If this item is empty and the player's item is also empty, there will be no
     * transaction between the player and the armor stand. If the player's item is empty
     * but the armor stand item is not, then the player will obtain the armor stand item.
     * In the case that the player's item is not empty but the armor stand item is empty,
     * the player's item will be placed on the armor stand. If both items are not empty,
     * the items will be swapped.
     * <p>
     * In the case that the event is cancelled the original items will remain the same.
     *
     * @return 盔甲架的的物品 {@link ItemStack}
     */
    @NotNull
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
    @NotNull
    public EquipmentSlot getSlot() {
        return this.slot;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Note that this is not the hand of the armor stand that was changed, but rather
     * the hand used by the player to swap items with the armor stand.
     */
    @NotNull
    @Override
    public EquipmentSlot getHand() {
        return super.getHand();
    }

    @NotNull
    @Override
    public ArmorStand getRightClicked() {
        return (ArmorStand) this.clickedEntity;
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
