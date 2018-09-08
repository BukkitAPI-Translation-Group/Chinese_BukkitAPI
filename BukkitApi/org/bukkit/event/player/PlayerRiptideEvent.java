package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

/**
 * 当玩家在使用三叉戟上的激流附魔推动它们在空中飞行(需要在下雨才能在空中飞行)时触发本事件
 * <br>
 * 什么是激流:
 * <ul>
 * <li>是三叉戟上的一个附魔</li>
 * <li>最高等级为III</li>
 * <li>用于三叉戟上, 可以在水中或下雨时投掷后推进玩家.</li>
 * <li>激流不会使三叉戟被抛出, 而会使玩家向前推进.</li>
 * <li>如果玩家未处在水中或所处地未下雨, 则玩家将无法投掷激流附魔的三叉戟</li>
 * </ul>
 * <br>
 * 注意: 激流动作在客户端执行, 因此在此事件中操纵玩家可能会产生所不希望的影响.
 * <p>
 * 原文:
 * This event is fired when the player activates the riptide enchantment, using
 * their trident to propel them through the air.
 * <br>
 * N.B. the riptide action is currently performed client side, so manipulating
 * the player in this event may have undesired effects.
 */
public class PlayerRiptideEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    private final ItemStack item;

    public PlayerRiptideEvent(final Player who, final ItemStack item) {
        super(who);
        this.item = item;
    }

    /**
     * 获取包含激流附魔的物品.
     * <p>
     * 原文:
     * Gets the item containing the used enchantment.
     *
     * @return 包含激流附魔的 {@link ItemStack}.
     */
    public ItemStack getItem() {
        return item;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
