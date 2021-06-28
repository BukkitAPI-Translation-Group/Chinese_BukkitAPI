package org.bukkit.entity;

import java.util.Collection;
import java.util.Set;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MainHand;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.PlayerInventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表人类实体, 比如一个NPC或一名玩家
 */
public interface HumanEntity extends LivingEntity, AnimalTamer, InventoryHolder {

    /**
     * 返回该玩家的玩家名.
     * <p>
     * 原文:Returns the name of this player
     *
     * @return 玩家名
     */
    @NotNull
    @Override
    public String getName();

    /**
     * 获取玩家的物品栏(俗称背包).
     * <p>
     * 原文:Get the player's inventory.
     *
     * @return 玩家物品栏, 包含盔甲槽
     */
    @NotNull
    @Override
    public PlayerInventory getInventory();

    /**
     * 获取玩家的末影箱物品栏.
     * <p>
     * 原文:Get the player's EnderChest inventory
     *
     * @return 玩家的末影箱
     */
    @NotNull
    public Inventory getEnderChest();

    /**
     * 获取玩家设置的主手.
     * <p>
     * 原文:Gets the player's selected main hand
     *
     * @return 玩家主手
     */
    @NotNull
    public MainHand getMainHand();

    /**
     * 若玩家当前打开了一个物品栏窗口, 此方法将设置窗口的属性, 比如酿造台的酿造进度.
     * <p>
     * 原文:If the player currently has an inventory window open, this method will
     * set a property of that window, such as the state of a progress bar.
     *
     * @param prop 窗口属性
     * @param value 要设置的属性值
     * @return 若属性成功设置返回true
     */
    public boolean setWindowProperty(@NotNull InventoryView.Property prop, int value);

    /**
     * 获取玩家正在查看的物品栏. 如果他们没有打开任何物品栏窗口, 将返回他们的内部合成视图(玩家背包的那四个格子?).
     * <p>
     * 原文:Gets the inventory view the player is currently viewing. If they do not
     * have an inventory window open, it returns their internal crafting view.
     *
     * @return 物品栏视图
     */
    @NotNull
    public InventoryView getOpenInventory();

    /**
     * 打开一个物品栏, 窗口顶部为你指定的物品栏, 底部为玩家物品栏(背包).
     * <p>
     * 原文:Opens an inventory window with the specified inventory on the top and
     * the player's inventory on the bottom.
     *
     * @param inventory 要打开的物品栏
     * @return 新打开的物品栏的视图
     */
    @Nullable
    public InventoryView openInventory(@NotNull Inventory inventory);

    /**
     * 打开一个空白工作台物品栏界面, 玩家物品栏(背包)在底部.
     * <p>
     * 原文:Opens an empty workbench inventory window with the player's inventory
     * on the bottom.
     *
     * @param location 工作台位置. 若为null, 将使用玩家所处位置
     * @param force 若为false, 同时指定位置不是工作台方块, 将不会打开工作台物品栏, 并返回null(true就是不管怎样都向
     * 玩家展示工作台界面)
     * @return 新打开的物品栏的视图, 如果不能打开返回null
     */
    @Nullable
    public InventoryView openWorkbench(@Nullable Location location, boolean force);

    /**
     * 打开一个空白附魔台物品栏界面, 玩家物品栏(背包)在底部.
     * <p>
     * 原文:Opens an empty enchanting inventory window with the player's inventory
     * on the bottom.
     *
     * @param location 附魔台位置. 若为null, 将使用玩家所处位置
     * @param force 若为false, 同时指定位置不是附魔台方块, 将不会打开工作台物品栏, 并返回null(true就是不管怎样都向
     * 玩家展示附魔台界面)
     * @return 新打开的物品栏的视图, 如果不能打开返回null
     */
    @Nullable
    public InventoryView openEnchanting(@Nullable Location location, boolean force);

    /**
     * 打开指定的物品栏.
     * <p>
     * 原文:Opens an inventory window to the specified inventory view.
     *
     * @param inventory 要打开的物品栏视图
     */
    public void openInventory(@NotNull InventoryView inventory);

    /**
     * 与某村民开始交易.
     *
     * 注意: 同一时间内只有一名玩家可以与此村民进行交易. 欲使多名玩家能同时与此村民进行交易, 请将“force”参数设为true.
     * <p>
     * 原文:Starts a trade between the player and the villager.
     *
     * Note that only one player may trade with a villager at once. You must use
     * the force parameter for this.
     *
     * @param trader 与哪位村民交易. 不能为null
     * @param force 是否强制开始交易, 即使另一名玩家正在与此村民交易
     * @return 新打开的物品栏的视图, 如果不能打开返回null
     */
    @Nullable
    public InventoryView openMerchant(@NotNull Villager trader, boolean force);

    /**
     * 与某商人开始交易.
     *
     * 注意: 同一时间内只有一名玩家可以与此商人进行交易. 欲使多名玩家能同时与此商人进行交易, 请将“force”参数设为true.
     * <p>
     * 原文:Starts a trade between the player and the merchant.
     *
     * Note that only one player may trade with a merchant at once. You must use
     * the force parameter for this.
     *
     * @param merchant 与哪个商人交易. 不能为null
     * @param force 是否强制开始交易, 即使另一名玩家正在与此商人交易
     * @return 新打开的物品栏的视图, 如果不能打开返回null
     */
    @Nullable
    public InventoryView openMerchant(@NotNull Merchant merchant, boolean force);

    /**
     * 强制关闭玩家当前打开的物品栏视图.
     * <p>
     * 原文:Force-closes the currently open inventory view for this player, if any.
     */
    public void closeInventory();

    /**
     * 返回你手握的物品, 可能为空.
     * <p>
     * 原文:Returns the ItemStack currently in your hand, can be empty.
     *
     * @return 你正在握持的物品的ItemStack(物品堆)对象
     * @deprecated 人类现能双持, 请使用 {@link PlayerInventory} 中更明确的方法
     */
    @Deprecated
    @NotNull
    public ItemStack getItemInHand();

    /**
     * 设置你手握的物品, 将替换你所持的任何物品.
     * <p>
     * 原文:Sets the item to the given ItemStack, this will replace whatever the
     * user was holding.
     *
     * @param item 要设置的物品堆
     * @deprecated 人类现能双持, 请使用 {@link PlayerInventory} 中更明确的方法
     */
    @Deprecated
    public void setItemInHand(@Nullable ItemStack item);

    // 待求证
    /**
     * 返回你的鼠标正在拖动的物品, 可能为空. 如果玩家没有打开任何窗口, 将永远为空(AIR).
     * <p>
     * 译注:这个方法是适用于物品拖动场景的, 只有鼠标指针在物品上而没有拖动它是获取不到的(AIR).
     * <p>
     * 原文:Returns the ItemStack currently on your cursor, can be empty. Will
     * always be empty if the player currently has no open window.
     *
     * @return 你正在拖动的物品的ItemStack对象
     */
    @NotNull
    public ItemStack getItemOnCursor();

    /**
     * 设置你正在拖动的物品, 将替换你所拖动的任何物品. 如果玩家没有打开任何窗口, 将永远为空(AIR).
     * <p>
     * 原文:Sets the item to the given ItemStack, this will replace whatever the
     * user was moving. Will always be empty if the player currently has no
     * open window.
     *
     * @param item 要设置的物品堆
     */
    public void setItemOnCursor(@Nullable ItemStack item);

    /**
     * 检查指定物品是否处于冷却状态.
     * <p>
     * 原文:Check whether a cooldown is active on the specified material.
     *
     * @param material 要检查的物品种类
     * @return 该物品是否进入了冷却
     */
    public boolean hasCooldown(@NotNull Material material);

    /**
     * 获取指定物品的冷却时长 (以tick为单位).
     * <p>
     * 原文:Get the cooldown time in ticks remaining for the specified material.
     *
     * @param material 要检查的物品种类
     * @return 剩余冷却时长 (以tick为单位)
     */
    public int getCooldown(@NotNull Material material);

    /**
     * 设置指定物品的冷却时长. 设为0 tick将导致移除此物品的冷却.
     * <p>
     * 冷却被服务器用来针对某些物品比如末影珍珠、盾牌等以防止它们被经常重复使用.
     * <p>
     * 请注意: 冷却时间自身不会阻止某个物品被用来使用或攻击.
     * <p>
     * 原文:Set a cooldown on the specified material for a certain amount of ticks.
     * ticks. 0 ticks will result in the removal of the cooldown.
     * <p>
     * Cooldowns are used by the server for items such as ender pearls and
     * shields to prevent them from being used repeatedly.
     * <p>
     * Note that cooldowns will not by themselves stop an item from being used
     * for attacking.
     *
     * @param material 为哪个物品设置冷却
     * @param ticks 冷却时长(以tick为单位)或设为0来移除它
     */
    public void setCooldown(@NotNull Material material, int ticks);

    /**
     * 获取玩家的睡眠时间 (以tick为单位), 该值可能有上限.
     * <p>
     * 原文:Get the sleep ticks of the player. This value may be capped.
     *
     * @return 玩家睡了多久
     */
    public int getSleepTicks();

    /**
     * Attempts to make the entity sleep at the given location.
     * <br>
     * The location must be in the current world and have a bed placed at the
     * location. The game may also enforce other requirements such as proximity
     * to bed, monsters, and dimension type if force is not set.
     *
     * @param location the location of the bed
     * @param force whether to try and sleep at the location even if not
     * normally possible
     * @return whether the sleep was successful
     */
    public boolean sleep(@NotNull Location location, boolean force);

    /**
     * Causes the player to wakeup if they are currently sleeping.
     *
     * @param setSpawnLocation whether to set their spawn location to the bed
     * they are currently sleeping in
     * @throws IllegalStateException if not sleeping
     */
    public void wakeup(boolean setSpawnLocation);

    /**
     * Gets the location of the bed the player is currently sleeping in
     *
     * @return location
     * @throws IllegalStateException if not sleeping
     */
    @NotNull
    public Location getBedLocation();

    /**
     * 获取此人类当前的{@link GameMode 游戏模式}.
     * <p>
     * 原文:Gets this human's current {@link GameMode}
     *
     * @return 游戏模式
     */
    @NotNull
    public GameMode getGameMode();

    /**
     * 设置此人类的{@link GameMode 游戏模式}.
     * <p>
     * 原文:Sets this human's current {@link GameMode}
     *
     * @param mode 新游戏模式
     */
    public void setGameMode(@NotNull GameMode mode);

    /**
     * 检查玩家是否正在格挡 (换言之, 就是他们使用盾牌, 进入了格挡状态).
     * <p>
     * 原文:Check if the player is currently blocking (ie with a shield).
     *
     * @return 玩家是否正在格挡
     */
    public boolean isBlocking();

    /**
     * 检查玩家是否举起了他们的手 (换言之, 就是他们刚使用盾牌(这时isBlocking返回false),
     * 数百毫秒后将进入格挡状态(这时isBlocking返回true)).
     * <p>
     * 原文:Check if the player currently has their hand raised (ie about to begin
     * blocking).
     *
     * @return 玩家是否举起了他们的手
     */
    public boolean isHandRaised();

    /**
     * Gets the item that the player is using (eating food, drawing back a bow,
     * blocking, etc.)
     *
     * @return the item being used by the player, or null if they are not using
     * an item
     */
    @Nullable
    public ItemStack getItemInUse();

    /**
     * 获取玩家升级所需经验总额.
     * <p>
     * 原文:Get the total amount of experience required for the player to level
     *
     * @return 升级所需经验
     */
    public int getExpToLevel();

    /**
     * Gets the current cooldown for a player's attack.
     *
     * This is used to calculate damage, with 1.0 representing a fully charged
     * attack and 0.0 representing a non-charged attack
     *
     * @return A float between 0.0-1.0 representing the progress of the charge
     */
    public float getAttackCooldown();

    /**
     * Discover a recipe for this player such that it has not already been
     * discovered. This method will add the key's associated recipe to the
     * player's recipe book.
     *
     * @param recipe the key of the recipe to discover
     *
     * @return whether or not the recipe was newly discovered
     */
    public boolean discoverRecipe(@NotNull NamespacedKey recipe);

    /**
     * Discover a collection of recipes for this player such that they have not
     * already been discovered. This method will add the keys' associated
     * recipes to the player's recipe book. If a recipe in the provided
     * collection has already been discovered, it will be silently ignored.
     *
     * @param recipes the keys of the recipes to discover
     *
     * @return the amount of newly discovered recipes where 0 indicates that
     * none were newly discovered and a number equal to {@code recipes.size()}
     * indicates that all were new
     */
    public int discoverRecipes(@NotNull Collection<NamespacedKey> recipes);

    /**
     * Undiscover a recipe for this player such that it has already been
     * discovered. This method will remove the key's associated recipe from the
     * player's recipe book.
     *
     * @param recipe the key of the recipe to undiscover
     *
     * @return whether or not the recipe was successfully undiscovered (i.e. it
     * was previously discovered)
     */
    public boolean undiscoverRecipe(@NotNull NamespacedKey recipe);

    /**
     * Undiscover a collection of recipes for this player such that they have
     * already been discovered. This method will remove the keys' associated
     * recipes from the player's recipe book. If a recipe in the provided
     * collection has not yet been discovered, it will be silently ignored.
     *
     * @param recipes the keys of the recipes to undiscover
     *
     * @return the amount of undiscovered recipes where 0 indicates that none
     * were undiscovered and a number equal to {@code recipes.size()} indicates
     * that all were undiscovered
     */
    public int undiscoverRecipes(@NotNull Collection<NamespacedKey> recipes);

    /**
     * Check whether or not this entity has discovered the specified recipe.
     *
     * @param recipe the key of the recipe to check
     *
     * @return true if discovered, false otherwise
     */
    public boolean hasDiscoveredRecipe(@NotNull NamespacedKey recipe);

    /**
     * Get an immutable set of recipes this entity has discovered.
     *
     * @return all discovered recipes
     */
    @NotNull
    public Set<NamespacedKey> getDiscoveredRecipes();

    /**
     * 获取栖息在玩家左肩上的实体 (通常情况下这是鹦鹉的行为, 目前客户端没有为其他实体定义这一行为), 若没有则返回null.
     * <p>
     * 返回的实体不会在世界内生成, 因此除非这个实体是首次生成的, 大部分对该实体的操作是无效的.
     * <p>
     * 原文:Gets the entity currently perched on the left shoulder or null if no
     * entity.
     * <br>
     * The returned entity will not be spawned within the world, so most
     * operations are invalid unless the entity is first spawned in.
     *
     * @return 坐在玩家左肩的实体
     * @deprecated Bukkit中目前还没有关于序列化实体的语义(格式)的良好定义. 请谨慎使用.
     */
    @Deprecated
    @Nullable
    public Entity getShoulderEntityLeft();

    /**
     * 设置栖息在玩家左肩上的实体(设为null则移除). 该方法将从世界中删除该实体.
     * <p>
     * 请注意: 只有实体的副本将被设置为显示在肩膀上的实体.
     * <p>
     * 也请注意游戏客户端目前只会渲染{@link Parrot 鹦鹉}的坐在肩膀上的行为.
     * <p>
     * 原文:Sets the entity currently perched on the left shoulder, or null to
     * remove. This method will remove the entity from the world.
     * <br>
     * Note that only a copy of the entity will be set to display on the
     * shoulder.
     * <br>
     * Also note that the client will currently only render {@link Parrot}
     * entities.
     *
     * @param entity 坐在玩家左肩的实体
     * @deprecated Bukkit中目前还没有关于序列化实体的语义(格式)的良好定义. 请谨慎使用.
     */
    @Deprecated
    public void setShoulderEntityLeft(@Nullable Entity entity);

    /**
     * 获取栖息在玩家右肩上的实体, 若没有则返回null.
     * <p>
     * 返回的实体不会在世界内生成, 因此除非这个实体是首次生成的, 大部分对该实体的操作是无效的.
     * <p>
     * 原文:Gets the entity currently perched on the right shoulder or null if no
     * entity.
     * <br>
     * The returned entity will not be spawned within the world, so most
     * operations are invalid unless the entity is first spawned in.
     *
     * @return 坐在玩家右肩的实体
     * @deprecated Bukkit中目前还没有关于序列化实体的语义(格式)的良好定义. 请谨慎使用.
     */
    @Deprecated
    @Nullable
    public Entity getShoulderEntityRight();

    /**
     * 设置栖息在玩家右肩上的实体(设为null则移除). 该方法将从世界中删除该实体.
     * <p>
     * 请注意: 只有实体的副本将被设置为显示在肩膀上的实体.
     * <p>
     * 也请注意游戏客户端目前只会渲染{@link Parrot 鹦鹉}的坐在肩膀上的行为.
     * <p>
     * 原文:Sets the entity currently perched on the right shoulder, or null to
     * remove. This method will remove the entity from the world.
     * <br>
     * Note that only a copy of the entity will be set to display on the
     * shoulder.
     * <br>
     * Also note that the client will currently only render {@link Parrot}
     * entities.
     *
     * @param entity 坐在玩家右肩的实体
     * @deprecated Bukkit中目前还没有关于序列化实体的语义(格式)的良好定义. 请谨慎使用.
     */
    @Deprecated
    public void setShoulderEntityRight(@Nullable Entity entity);

    /**
     * Make the entity drop the item in their hand.
     * <br>
     * This will force the entity to drop the item they are holding with
     * an option to drop the entire {@link ItemStack} or just 1 of the items.
     *
     * @param dropAll True to drop entire stack, false to drop 1 of the stack
     * @return True if item was dropped successfully
     */
    public boolean dropItem(boolean dropAll);

    /**
     * 获取玩家的疲劳度.
     * <p>
     * 疲劳度控制者玩家的饥饿消耗. 当玩家达到一定的疲劳度时, 你的饱食度就会下降, 并且疲劳度归零.
     * <p>
     * 译注:如果饱食度为0, 那么就扣饥饿度.
     * <p>
     * 译注2:运动会产生疲劳度.
     * <p>
     * 原文:Gets the players current exhaustion level.
     * <p>
     * Exhaustion controls how fast the food level drops. While you have a
     * certain amount of exhaustion, your saturation will drop to zero, and
     * then your food will drop to zero.
     *
     * @return 疲劳度
     */
    public float getExhaustion();

    /**
     * 设置玩家的疲劳度.
     * <p>
     * 原文:Sets the players current exhaustion level
     *
     * @param value 疲劳度
     */
    public void setExhaustion(float value);

    /**
     * 获取玩家的饱食度(不是饥饿度).
     * <p>
     * 饱食度是一个饥饿度的缓存. 当你的饱食度 {@literal  >} 0的时候,饥饿度是不会下降的.
     * <p>
     * 译注:就是说, 吃东西的时候, 你的饥饿度被填满了, 而多出来的部分就是隐藏的饱食度. 当你的疲劳值(见{@link #getExhaustion() })
     * 达到一定程度时, 如果饱食度不为0, 那么先扣饱食度. 只有当没饱食度时, 才会扣饥饿度. 其实饱食度就是饥饿度, 只不过是隐藏的.
     * <p>
     * 原文:Gets the players current saturation level.
     * <p>
     * Saturation is a buffer for food level. Your food level will not drop if
     * you are saturated {@literal >} 0.
     *
     * @return 饱食度
     */
    public float getSaturation();

    /**
     * 设置玩家的饱食度(不是饥饿度).
     * <p>
     * 原文:Sets the players current saturation level
     *
     * @param value 饱食度
     */
    public void setSaturation(float value);

    /**
     * 获取玩家的饥饿度(不是饱食度).
     * <p>
     * 原文:Gets the players current food level
     *
     * @return 饥饿度
     */
    public int getFoodLevel();

     /**
     * 设置玩家的饥饿度(不是饱食度).
     * <p>
     * 原文:Sets the players current food level
     *
     * @param value 饥饿度
     */
    public void setFoodLevel(int value);

    /**
     * Get the regeneration rate (1 health per x ticks) of
     * the HumanEntity when they have saturation and
     * their food level is {@literal >=} 20. Default is 10.
     *
     * @return the regeneration rate
     */
    public int getSaturatedRegenRate();

    /**
     * Set the regeneration rate (1 health per x ticks) of
     * the HumanEntity when they have saturation and
     * their food level is {@literal >=} 20. Default is 10.
     * Not affected if the world's difficulty is peaceful.
     *
     * @param ticks the amount of ticks to gain 1 health.
     */
    public void setSaturatedRegenRate(int ticks);

    /**
     * Get the regeneration rate (1 health per x ticks) of
     * the HumanEntity when they have no saturation and
     * their food level is {@literal >=} 18. Default is 80.
     *
     * @return the regeneration rate
     */
    public int getUnsaturatedRegenRate();

    /**
     * Get the regeneration rate (1 health per x ticks) of
     * the HumanEntity when they have no saturation and
     * their food level is {@literal >=} 18. Default is 80.
     * Not affected if the world's difficulty is peaceful.
     *
     * @param ticks the amount of ticks to gain 1 health.
     */
    public void setUnsaturatedRegenRate(int ticks);

    /**
     * Get the starvation rate (1 health per x ticks) of
     * the HumanEntity. Default is 80.
     *
     * @return the starvation rate
     */
    public int getStarvationRate();

    /**
     * Get the starvation rate (1 health per x ticks) of
     * the HumanEntity. Default is 80.
     *
     * @param ticks the amount of ticks to lose 1 health
     */
    public void setStarvationRate(int ticks);
}
