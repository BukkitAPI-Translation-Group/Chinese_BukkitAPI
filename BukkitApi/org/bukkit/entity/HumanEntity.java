package org.bukkit.entity;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.inventory.MainHand;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.permissions.Permissible;

/**
 * 代表一个人类实体，如一个NPC（村民）或一名玩家
 * 原文：
 * Represents a human entity, such as an NPC or a player
 */
public interface HumanEntity extends LivingEntity, AnimalTamer, Permissible, InventoryHolder {

    /**
     * 返回玩家名称
     * 原文：
     * Returns the name of this player
     *
     * @return 玩家名称
     */
    public String getName();

    /**
     * 获取玩家的背包。
     * 原文：
     * Get the player's inventory.
     *
     * @return 玩家的背包，包含防具槽。
     */
    public PlayerInventory getInventory();

    /**
     * 获取玩家的末影箱库存
     * 原文：
     * Get the player's EnderChest inventory
     *
     * @return 玩家的末影箱
     */
    public Inventory getEnderChest();

    /**
     * 获取玩家选定的主手
     * 原文：
     * Gets the player's selected main hand
     *
     * @return 玩家的主手
     */
    public MainHand getMainHand();

    /**
     * 如果玩家当前打开了一个库存窗口，这个方法能够设置窗口的属性，如进度条的状态。
     * 原文：
     * If the player currently has an inventory window open, this method will
     * set a property of that window, such as the state of a progress bar.
     *
     * @param prop 选定的属性
     * @param value 属性的设定值
     * @return 成功设置属性则返回true。
     */
    public boolean setWindowProperty(InventoryView.Property prop, int value);

    /**
     * 获取玩家当前浏览的库存视图。如果他们没有打开库存窗口，就会返回他们的背包视图（？）。
     * 原文：
     * Gets the inventory view the player is currently viewing. If they do not
     * have an inventory window open, it returns their internal crafting view.
     *
     * @return 库存视图。
     */
    public InventoryView getOpenInventory();

    /**
     * 打开一个库存窗口，窗口的顶部为指定的库存，底部为玩家的背包。
     * 原文：
     * Opens an inventory window with the specified inventory on the top and
     * the player's inventory on the bottom.
     *
     * @param inventory 打开的库存
     * @return 最近被打开的库存视图
     */
    public InventoryView openInventory(Inventory inventory);

    /**
     * 打开一个空的工作台库存窗口，底部为玩家的背包。
     * 原文：
     * Opens an empty workbench inventory window with the player's inventory
     * on the bottom.
     *
     * @param location 工作台位置。如果为空，则使用玩家的位置。
     * @param force 如果为false且指定位置没有工作台方块，则不会打开窗口且返回null。
     * @return 如果打开成功则返回最近被打开的库存视图，否则返回null。
     */
    public InventoryView openWorkbench(Location location, boolean force);

    /**
     * 打开一个空的附魔台库存窗口，底部为玩家的背包。
     * 原文：
     * Opens an empty enchanting inventory window with the player's inventory
     * on the bottom.
     *
     * @param location 附魔台位置。如果为空，则使用玩家的位置。
     * @param force 如果为false且指定位置没有附魔台方块，则不会打开窗口且返回null。
     * @return 如果打开成功则返回最近被打开的库存视图，否则返回null。
     */
    public InventoryView openEnchanting(Location location, boolean force);

    /**
     * 打开指定的库存窗口。
     * 原文：
     * Opens an inventory window to the specified inventory view.
     *
     * @param inventory 指定的库存
     */
    public void openInventory(InventoryView inventory);

    /**
     * 创建一个玩家与村民间的交易.
     * 
     * 注意一个村民同时只能有一名玩家交易。因此必须使用force参数.
     * 原文：
     * Starts a trade between the player and the villager.
     *
     * Note that only one player may trade with a villager at once. You must use
     * the force parameter for this.
     *
     * @param trader 交易的村民。不能为空
     * @param force 如果当前有另一名玩家正在交易是否强制创建交易
     * @return 如果打开成功则返回最近被打开的库存视图，否则返回null
     */
    public InventoryView openMerchant(Villager trader, boolean force);

    /**
     * Starts a trade between the player and the merchant.
     *
     * Note that only one player may trade with a merchant at once. You must use
     * the force parameter for this.
     *
     * @param merchant The merchant to trade with. Cannot be null.
     * @param force whether to force the trade even if another player is trading
     * @return The newly opened inventory view, or null if it could not be
     * opened.
     */
    public InventoryView openMerchant(Merchant merchant, boolean force);

    /**
     * 强制关闭指定玩家当前打开的库存视图。
     * 原文：
     * Force-closes the currently open inventory view for this player, if any.
     */
    public void closeInventory();

    /**
     * 返回当前手里的ItemStack（物品堆），可为空。
     * 原文：
     * Returns the ItemStack currently in your hand, can be empty.
     *
     * @return 当前手里物品的ItemStack对象。
     * @deprecated 人类现在能够双持，请使用{@link PlayerInventory}中更明确的方法。
     */
    @Deprecated
    public ItemStack getItemInHand();

    /**
     * 设置指定物品堆（ItemStack）中的物品，将替换原本的物品。
     * 原文：
     * Sets the item to the given ItemStack, this will replace whatever the
     * user was holding.
     *
     * @param item 最终设置的物品堆（ItemStack）
     * @deprecated 人类现在能够双持，请使用{@link PlayerInventory}中更明确的方法。
     */
    @Deprecated
    public void setItemInHand(ItemStack item);

    /**
     * 返回当前光标中的物品堆（ItemStack），可为空。如果玩家当前没有打开窗口则返回空。
     * 原文：
     * Returns the ItemStack currently on your cursor, can be empty. Will
     * always be empty if the player currently has no open window.
     *
     * @return 正在移动的物品的ItemStack对象。
     */
    public ItemStack getItemOnCursor();

    /**
     * 设置指定物品堆（ItemStack）中的物品，将替换原本的物品。如果玩家当前没有打开窗口则返回空。
     * 原文：
     * Sets the item to the given ItemStack, this will replace whatever the
     * user was moving. Will always be empty if the player currently has no
     * open window.
     *
     * @param item 最终设置的物品堆（ItemStack）
     */
    public void setItemOnCursor(ItemStack item);

    /**
     * 返回指定玩家是否正在睡眠。
     * 原文：
     * Returns whether this player is slumbering.
     *
     * @return 睡眠状态
     */
    public boolean isSleeping();

    /**
     * 获取玩家的睡眠时间（单位为tick）。这个值可能被封顶。
     * 原文：
     * Get the sleep ticks of the player. This value may be capped.
     *
     * @return 睡眠时间（单位为tick）
     */
    public int getSleepTicks();

    /**
     * 获取玩家当前{@link GameMode}（游戏模式）
     * 原文：
     * Gets this human's current {@link GameMode}
     *
     * @return 当前游戏模式
     */
    public GameMode getGameMode();

    /**
     * 设置玩家当前{@link GameMode}（游戏模式）
     * 原文：
     * Sets this human's current {@link GameMode}
     *
     * @param mode 新的游戏模式
     */
    public void setGameMode(GameMode mode);

    /**
     * 检查指定玩家是否正在格挡（使用剑）。
     * 原文：
     * Check if the player is currently blocking (ie with a sword).
     *
     * @return 是否正在格挡。
     */
    public boolean isBlocking();

    /**
     * Check if the player currently has their hand raised (ie about to begin
     * blocking).
     *
     * @return Whether their hand is raised
     */
    public boolean isHandRaised();

    /**
     * 获取玩家升级所需经验总额
     * Get the total amount of experience required for the player to level
     *
     * @return 升级所需经验
     */
    public int getExpToLevel();
}