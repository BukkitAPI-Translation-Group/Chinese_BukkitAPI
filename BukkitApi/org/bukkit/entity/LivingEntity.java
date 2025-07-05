package org.bukkit.entity;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.bukkit.Color;
import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.attribute.Attributable;
import org.bukkit.block.Block;
import org.bukkit.entity.memory.MemoryKey;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一个生物实体，比如一只怪物或一名玩家.
 */
public interface LivingEntity extends Attributable, Damageable, ProjectileSource {

    /**
     * 获取生物实体眼睛离脚高度.
     * <p>
     * 原文：
     * Gets the height of the living entity's eyes above its Location.
     *
     * @return 生物实体眼睛离脚高度
     */
    public double getEyeHeight();

    /**
     * 获取生物实体眼睛离脚高度.
     * <p>
     * 原文：
     * Gets the height of the living entity's eyes above its Location.
     *
     * @param ignorePose 若为true则会无视姿势改变的效果,例如潜行和滑翔
     * @return 生物实体眼睛离脚高度
     */
    public double getEyeHeight(boolean ignorePose);

    /**
     * 获取生物实体眼睛的详细方位的Location对象.
     * <p>
     * 原文：
     * Get a Location detailing the current eye position of the living entity.
     *
     * @return 生物实体眼睛的详细方位的Location对象
     */
    @NotNull
    public Location getEyeLocation();

    /**
     * 获取沿生物实体视线上的所有方块.
     * <p>
     * 这个列表包含生物实体眼睛到目标位置的所有方块.
     * 本方法认为所有方块体积为1x1x1.
     * <p>
     * 原文：
     * Gets all blocks along the living entity's line of sight.
     * <p>
     * This list contains all blocks from the living entity's eye position to
     * target inclusive. This method considers all blocks as 1x1x1 in size.
     *
     * @param transparent 将包含的所有透明方块的ID的Set（设置为null则只包含空气）
     * @param maxDistance 扫描的最大距离（可能被服务器限制，但至少为100个方块）
     * @return 包含沿生物实体视线上的所有方块的列表
     */
    @NotNull
    public List<Block> getLineOfSight(@Nullable Set<Material> transparent, int maxDistance);

    /**
     * 获取生物实体的目标方块.
     * <p>
     * 本方法认为所有方块体积为1x1x1. To take exact block
     * collision shapes into account, see {@link #getTargetBlockExact(int,
     * FluidCollisionMode)}.
     * <p>
     * 原文：
     * Gets the block that the living entity has targeted.
     * <p>
     * This method considers all blocks as 1x1x1 in size. To take exact block
     * collision shapes into account, see {@link #getTargetBlockExact(int,
     * FluidCollisionMode)}.
     *
     * @param transparent 将包含的所有透明方块的ID的Set（设置为null则只包含空气）
     * @param maxDistance 扫描的最大距离（可能被服务器限制，但至少为100个方块）
     * @return block 生物实体的目标方块
     */
    @NotNull
    public Block getTargetBlock(@Nullable Set<Material> transparent, int maxDistance);

    /**
     * 获取沿生物实体视线上最后两个方块.
     * <p>
     * 目标方块将是列表中最后的方块. 本方法认为所有方块体积为1x1x1.
     * <p>
     * 原文：
     * Gets the last two blocks along the living entity's line of sight.
     * <p>
     * The target block will be the last block in the list. This method
     * considers all blocks as 1x1x1 in size.
     *
     * @param transparent 将包含的所有透明方块的ID的Set（设置为null则只包含空气）
     * @param maxDistance 扫描的最大距离。可能被服务器限制，但不会低于100个方块
     * @return 包含沿生物实体视线上最后两个方块的列表
     */
    @NotNull
    public List<Block> getLastTwoTargetBlocks(@Nullable Set<Material> transparent, int maxDistance);

    /**
     * 获取该生物实体瞄准的方块。
     * <p>
     * 这会考虑方块的精确碰撞形状。流体将被忽略。
     * <p>
     * 此操作可能会导致区块加载！某些实现可能会对最大距离施加人工限制。
     * <p>
     * 原文：
     * Gets the block that the living entity has targeted.
     * <p>
     * This takes the blocks' precise collision shapes into account. Fluids are
     * ignored.
     * <p>
     * This may cause loading of chunks! Some implementations may impose
     * artificial restrictions on the maximum distance.
     *
     * @param maxDistance 扫描的最大距离
     * @return 生物实体瞄准的方块
     * @see #getTargetBlockExact(int, org.bukkit.FluidCollisionMode)
     */
    @Nullable
    public Block getTargetBlockExact(int maxDistance);

    /**
     * 获取该生物实体瞄准的方块。
     * <p>
     * 这会考虑方块的精确碰撞形状。
     * <p>
     * 此操作可能会导致区块加载！某些实现可能会对最大距离施加人工限制。
     * <p>
     * 原文：
     * Gets the block that the living entity has targeted.
     * <p>
     * This takes the blocks' precise collision shapes into account.
     * <p>
     * This may cause loading of chunks! Some implementations may impose
     * artificial restrictions on the maximum distance.
     *
     * @param maxDistance 扫描的最大距离
     * @param fluidCollisionMode 流体碰撞模式
     * @return 生物实体瞄准的方块
     * @see #rayTraceBlocks(double, FluidCollisionMode)
     */
    @Nullable
    public Block getTargetBlockExact(int maxDistance, @NotNull FluidCollisionMode fluidCollisionMode);

    /**
     * 执行一次射线追踪，提供有关目标方块的信息。
     * <p>
     * 这会考虑方块的精确碰撞形状。流体将被忽略。
     * <p>
     * 此操作可能会导致区块加载！某些实现可能会对最大距离施加人工限制。
     * <p>
     * 原文：
     * Performs a ray trace that provides information on the targeted block.
     * <p>
     * This takes the blocks' precise collision shapes into account. Fluids are
     * ignored.
     * <p>
     * This may cause loading of chunks! Some implementations may impose
     * artificial restrictions on the maximum distance.
     *
     * @param maxDistance 扫描的最大距离
     * @return 目标方块的信息，如果范围内没有目标方块则返回 <code>null</code>
     * @see #rayTraceBlocks(double, FluidCollisionMode)
     */
    @Nullable
    public RayTraceResult rayTraceBlocks(double maxDistance);

    /**
     * 执行一次射线追踪，提供有关目标方块的信息。
     * <p>
     * 这会考虑方块的精确碰撞形状。
     * <p>
     * 此操作可能会导致区块加载！某些实现可能会对最大距离施加人工限制。
     * <p>
     * 原文：
     * Performs a ray trace that provides information on the targeted block.
     * <p>
     * This takes the blocks' precise collision shapes into account.
     * <p>
     * This may cause loading of chunks! Some implementations may impose
     * artificial restrictions on the maximum distance.
     *
     * @param maxDistance 扫描的最大距离
     * @param fluidCollisionMode 流体碰撞模式
     * @return 目标方块的信息，如果范围内没有目标方块则返回 <code>null</code>
     * @see World#rayTraceBlocks(Location, Vector, double, FluidCollisionMode)
     */
    @Nullable
    public RayTraceResult rayTraceBlocks(double maxDistance, @NotNull FluidCollisionMode fluidCollisionMode);

    /**
     * 返回生物实体剩余的氧气值，单位为tick.
     * <p>
     * 原文：
     * Returns the amount of air that the living entity has remaining, in
     * ticks.
     *
     * @return 剩余的氧气值
     */
    public int getRemainingAir();

    /**
     * 设置生物实体剩余的氧气值，单位为tick.
     * <p>
     * 原文：
     * Sets the amount of air that the living entity has remaining, in ticks.
     *
     * @param ticks 剩余的氧气值
     */
    public void setRemainingAir(int ticks);

    /**
     * 返回生物实体所能拥有的氧气最大值，单位为tick.
     * <p>
     * 原文：
     * Returns the maximum amount of air the living entity can have, in ticks.
     *
     * @return 氧气最大值
     */
    public int getMaximumAir();

    /**
     * 设置生物实体所能拥有的氧气最大值，单位为tick.
     * <p>
     * 原文：
     * Sets the maximum amount of air the living entity can have, in ticks.
     *
     * @param ticks 氧气最大值
     */
    public void setMaximumAir(int ticks);

    /**
     * 获取玩家正在使用的物品（吃食物、拉弓、格挡等）。
     * <p>
     * 原文：
     * Gets the item that the player is using (eating food, drawing back a bow,
     * blocking, etc.)
     *
     * @return 玩家正在使用的物品，如果未使用物品则返回 null
     */
    @Nullable
    public ItemStack getItemInUse();

    /**
     * 获取当前物品使用的剩余 tick 数。
     * <p>
     * 原文：
     * Gets the number of ticks remaining for the current item's usage.
     *
     * @return 剩余的 tick 数
     */
    public int getItemInUseTicks();

    /**
     * 设置当前物品使用的剩余 tick 数。
     * 适用于需要时间使用的物品，如吃食物、拉弓或投掷三叉戟。
     * <p>
     * 原文：
     * Sets the number of ticks that remain for the current item's usage.
     * Applies to items that take time to use, like eating food, drawing a bow,
     * or throwing a trident.
     *
     * @param ticks 剩余的 tick 数
     */
    public void setItemInUseTicks(int ticks);

    /**
     * 获取箭矢离开实体身体的剩余时间（以 tick 为单位）。
     * <p>
     * 原文：
     * Gets the time in ticks until the next arrow leaves the entity's body.
     *
     * @return 箭矢离开的 tick 数
     */
    public int getArrowCooldown();

    /**
     * 设置箭矢离开实体身体的剩余时间（以 tick 为单位）。
     * <p>
     * 原文：
     * Sets the time in ticks until the next arrow leaves the entity's body.
     *
     * @param ticks 箭矢离开的时间
     */
    public void setArrowCooldown(int ticks);

    /**
     * 获取实体身体内的箭矢数量。
     * <p>
     * 原文：
     * Gets the amount of arrows in an entity's body.
     *
     * @return 身体内的箭矢数量
     */
    public int getArrowsInBody();

    /**
     * 设置实体身体内的箭矢数量。
     * <p>
     * 原文：
     * Set the amount of arrows in the entity's body.
     *
     * @param count 实体身体内的箭矢数量
     */
    public void setArrowsInBody(int count);

    /**
     * 返回生物实体当前最大无伤害时间，单位为tick.
     * <p>
     * 即生物实体不会受到伤害的最大持续时间.
     * <p>
     * 原文：
     * Returns the living entity's current maximum no damage ticks.
     * <p>
     * This is the maximum duration in which the living entity will not take
     * damage.
     *
     * @return 最大无伤害时间，单位为tick
     */
    public int getMaximumNoDamageTicks();

    /**
     * 设置生物实体当前当前最大无伤害时间，单位为tick.
     * <p>
     * 原文：
     * Sets the living entity's current maximum no damage ticks.
     *
     * @param ticks 最大无伤害时间，单位为tick
     */
    public void setMaximumNoDamageTicks(int ticks);

    /**
     * 返回生物实体在当前无伤害时间最后受到的伤害.
     * <p>
     * 只有当伤害高于这个数值时生物实体才会进一步受到伤害.
     * <p>
     * 原文:
     * Returns the living entity's last damage taken in the current no damage
     * ticks time.
     * <p>
     * Only damage higher than this amount will further damage the living
     * entity.
     *
     * @return 上一个无伤害时间段内受到的伤害
     */
    public double getLastDamage();

    /**
     * 设置当前无伤害时间段内处理的伤害.
     * <p>
     * 原文：
     * Sets the damage dealt within the current no damage ticks time period.
     *
     * @param damage 伤害总量
     */
    public void setLastDamage(double damage);

    /**
     * 返回生物实体当前无伤害时间，单位为tick.
     * <p>
     * 原文：
     * Returns the living entity's current no damage ticks.
     *
     * @return 无伤害时间，单位为tick
     */
    public int getNoDamageTicks();

    /**
     * 设置生物实体当前无伤害时间，单位为tick.
     * <p>
     * 原文：
     * Sets the living entity's current no damage ticks.
     *
     * @param ticks 无伤害时间，单位为tick
     */
    public void setNoDamageTicks(int ticks);

    /**
     * 获取此实体未执行任何操作的 tick 数。
     * <p>
     * "未操作 tick" 的具体含义因实体而异，无法明确定义。
     * 一些示例包括乌贼使用此值来判断何时游泳，袭击者判断何时被驱逐出袭击，
     * 或生物（如凋灵）作为消失的条件。
     * <p>
     * 原文：
     * Get the ticks that this entity has performed no action.
     * <p>
     * The details of what "no action ticks" entails varies from entity to entity
     * and cannot be specifically defined. Some examples include squid using this
     * value to determine when to swim, raiders for when they are to be expelled
     * from raids, or creatures (such as withers) as a requirement to be despawned.
     *
     * @return 未操作的 tick 数
     */
    public int getNoActionTicks();

    /**
     * 设置此实体未执行任何操作的 tick 数。
     * <p>
     * "未操作 tick" 的具体含义因实体而异，无法明确定义。
     * 一些示例包括乌贼使用此值来判断何时游泳，袭击者判断何时被驱逐出袭击，
     * 或生物（如凋灵）作为消失的条件。
     * <p>
     * 原文：
     * Set the ticks that this entity has performed no action.
     * <p>
     * The details of what "no action ticks" entails varies from entity to entity
     * and cannot be specifically defined. Some examples include squid using this
     * value to determine when to swim, raiders for when they are to be expelled
     * from raids, or creatures (such as withers) as a requirement to be despawned.
     *
     * @param ticks 未操作的 tick 数
     */
    public void setNoActionTicks(int ticks);

    /**
     * 获取击杀指定生物实体的玩家.
     * <p>
     * 可能为空.
     * <p>
     * 原文：
     * Gets the player identified as the killer of the living entity.
     * <p>
     * May be null.
     *
     * @return 击杀指定生物实体的玩家，如果找不到则返回null
     */
    @Nullable
    public Player getKiller();

    /**
     * 向生物实体添加指定的{@link PotionEffect}（药水效果）.
     * <p>
     * 原文：
     * Adds the given {@link PotionEffect} to the living entity.
     *
     * @param effect 添加的药水效果
     * @return 效果是否添加
     */
    public boolean addPotionEffect(@NotNull PotionEffect effect);

    /**
     * 向生物实体添加指定的{@link PotionEffect}（药水效果）.
     * <p>
     * 一个指定的{@link PotionEffectType}（药水效果类型）只能有一种药水效果存在.
     * <p>
     * 原文：
     * Adds the given {@link PotionEffect} to the living entity.
     * <p>
     * Only one potion effect can be present for a given {@link
     * PotionEffectType}.
     *
     * @param effect 添加的药水效果
     * @param force 是否移除冲突的效果
     * @return 效果是否添加
     * @deprecated 由于现已支持多个同种类型的药水效果, 没必要强制添加.
     * <p>译注:在某次版本更新后, Minecraft 自身支持了多个同种药水效果, 效果弱的会被隐藏;
     * 但为兼容性考虑, 如确有覆盖效果需求的, 还是指定force为true
     */
    @Deprecated(since = "1.15.2")
    public boolean addPotionEffect(@NotNull PotionEffect effect, boolean force);

    /**
     * 尝试向生物实体添加所有指定的{@link PotionEffect}（药水效果）.
     * <p>
     * 原文：
     * Attempts to add all of the given {@link PotionEffect} to the living
     * entity.
     *
     * @param effects 添加的效果
     * @return 所有效果是否添加
     */
    public boolean addPotionEffects(@NotNull Collection<PotionEffect> effects);

    /**
     * 返回生物实体是否已经存在一个指定的{@link PotionEffectType}效果.
     * <p>
     * 原文：
     * Returns whether the living entity already has an existing effect of
     * the given {@link PotionEffectType} applied to it.
     *
     * @param type 检查的药水类型
     * @return 是否有指定的药水效果作用于生物实体
     */
    public boolean hasPotionEffect(@NotNull PotionEffectType type);

    /**
     * 返回指定类型的有效{@link PotionEffect}.
     * <p>
     * 如果效果不存在则会返回null.
     * <p>
     * 原文：
     * Returns the active {@link PotionEffect} of the specified type.
     * <p>
     * If the effect is not present on the entity then null will be returned.
     *
     * @param type 检查的药水类型
     * @return 作用于实体的效果，如果没有则返回null。
     */
    @Nullable
    public PotionEffect getPotionEffect(@NotNull PotionEffectType type);

    /**
     * 移除当前所有指定的{@link PotionEffectType}效果.
     * <p>
     * 原文：
     * Removes any effects present of the given {@link PotionEffectType}.
     *
     * @param type 移除的药水类型
     */
    public void removePotionEffect(@NotNull PotionEffectType type);

    /**
     * 返回当前作用于生物实体的所有{@link PotionEffect}.
     * <p>
     * 译注:不要向获得的列表中添加条目, 没有任何效果.
     * <p>
     * 原文：
     * Returns all currently active {@link PotionEffect}s on the living
     * entity.
     *
     * @return 一个{@link PotionEffect}的集合
     */
    @NotNull
    public Collection<PotionEffect> getActivePotionEffects();

    /**
     * 检查生物实体是否阻挡另一个的视线.
     * <p>
     * 这使用了与敌对怪物寻找最近玩家相同的算法.
     * <p>
     * 原文：
     * Checks whether the living entity has block line of sight to another.
     * <p>
     * This uses the same algorithm that hostile mobs use to find the closest
     * player.
     *
     * @param other 确定视线的实体
     * @return 如果存在视线则返回true，否则返回false
     */
    public boolean hasLineOfSight(@NotNull Entity other);

    /**
     * 返回生物实体是否会在远离玩家时消失.
     * <p>
     * 默认情况下，动物不会被移除而怪物会.
     * <p>
     * 原文：
     * Returns if the living entity despawns when away from players or not.
     * <p>
     * By default, animals are not removed while other mobs are.
     *
     * @return 如果生物实体会在远离玩家时消失则返回true
     */
    public boolean getRemoveWhenFarAway();

    /**
     * 设置生物实体是否会在远离玩家时消失.
     * <p>
     * 原文：
     * Sets whether or not the living entity despawns when away from players
     * or not.
     *
     * @param remove 移除状态
     */
    public void setRemoveWhenFarAway(boolean remove);

    /**
     * 获取生物实体穿戴的装备背包栏.
     * <p>
     * 原文：
     * Gets the inventory with the equipment worn by the living entity.
     *
     * @return 生物实体的背包栏
     */
    @Nullable
    public EntityEquipment getEquipment();

    /**
     * 设置生物实体是否能捡拾物品.
	 * <p>
     * 原文：
     * Sets whether or not the living entity can pick up items.
     *
     * @param pickup 生物实体是否能捡拾物品
     */
    public void setCanPickupItems(boolean pickup);

    /**
     * 获取生物实体是否能捡拾物品.
     * <p>
     * 原文：
     * Gets if the living entity can pick up items.
     *
     * @return 生物实体是否能捡拾物品
     */
    public boolean getCanPickupItems();

    /**
     * 返回实体当前是否被拴住.
     * <p>
     * 原文：
     * Returns whether the entity is currently leashed.
     *
     * @return 实体是否被拴住
     */
    public boolean isLeashed();

    /**
     * 获取当前牵引此实体的实体.
     * <p>
     * 原文：
     * Gets the entity that is currently leading this entity.
     *
     * @return 握持拴绳的实体
     * @throws IllegalStateException 如果当前实体没被拴住则抛出错误
     */
    @NotNull
    public Entity getLeashHolder() throws IllegalStateException;

    /**
     * 设置握持拴绳的实体.
     * <p>
     * 此方法对末影龙，凋零，玩家或蝙蝠无效。除拴绳外的非生物实体将不会像握持拴绳者一样持续存在.
     * <p>
     * 原文：
     * Sets the leash on this entity to be held by the supplied entity.
     * <p>
     * This method has no effect on EnderDragons, Withers, Players, or Bats.
     * Non-living entities excluding leashes will not persist as leash
     * holders.
     *
     * @param holder 握持拴绳的实体
     * @return 操作是否成功
     */
    public boolean setLeashHolder(@Nullable Entity holder);

    /**
     * 检查实体是否正在滑翔，如正在使用鞘翅.
     * <p>
     * 原文：
     * Checks to see if an entity is gliding, such as using an Elytra.
     * @return 如果实体正在滑翔则返回true
     */
    public boolean isGliding();

    /**
     * 使实体开始或停止滑翔。即使没有装备鞘翅，这也会有效，但除非有事件取消机制，否则服务器会立即恢复。
     * <p>
     * 原文：
     * Makes entity start or stop gliding. This will work even if an Elytra
     * is not equipped, but will be reverted by the server immediately after
     * unless an event-cancelling mechanism is put in place.
     * @param gliding 如果实体正在滑翔，则为 true。
     */
    public void setGliding(boolean gliding);

    /**
     * 检查实体是否正在游泳。
     * <p>
     * 原文：
     * Checks to see if an entity is swimming.
     *
     * @return 如果该实体正在游泳，则返回 true。
     */
    public boolean isSwimming();

    /**
     * 使实体开始或停止游泳。
     *
     * 如果实体不在水中，可能会产生意想不到的结果。
     * <p>
     * 原文：
     * Makes entity start or stop swimming.
     *
     * This may have unexpected results if the entity is not in water.
     *
     * @param swimming 如果实体正在游泳，则为 true。
     */
    public void setSwimming(boolean swimming);

    /**
     * 检查实体是否正在激流。
     * <p>
     * 原文：
     * Checks to see if an entity is currently riptiding.
     *
     * @return 如果该实体当前正在激流，则返回 true。
     */
    public boolean isRiptiding();

    /**
     * Makes entity start or stop riptiding.
     * <p>
     * Note: This does not damage attackable entities.
     *
     * @param riptiding whether the entity should start riptiding.
     * @see HumanEntity#startRiptideAttack(int, float, ItemStack)
     */
    public void setRiptiding(boolean riptiding);

    /**
     * 返回实体是否正在睡觉.
     * <p>
     * 原文:Returns whether this entity is slumbering.
     *
     * @return 实体睡眠状态
     */
    public boolean isSleeping();

    /**
     * 获取实体是否正在攀爬.
     * <p>
     * 原文:Gets if the entity is climbing.
     *
     * @return 实体攀爬状态
     */
    public boolean isClimbing();

    /**
     * 设置实体是否具有AI. 实体若无AI将完全无法自主移动.
     * <p>
     * 原文：
     * Sets whether an entity will have AI.
     *
     * The entity will be completely unable to move if it has no AI.
     *
     * @param ai 怪物是否具有AI
     */
    void setAI(boolean ai);

    /**
     * 检查实体是否具有AI. 实体若无AI将完全无法自主移动.
     * <p>
     * 原文：
     * Checks whether an entity has AI.
     *
     * The entity will be completely unable to move if it has no AI.
     *
     * @return 如果实体具有AI则返回true
     */
    boolean hasAI();

    /**
     * 让此实体对指定实体进行近战攻击。
     * 攻击伤害由服务器根据该生物的属性和装备计算，
     * 根据需要对 {@code target} 施加击退效果。
     * <p>
     * 原文：
     * Makes this entity attack the given entity with a melee attack.
     *
     * Attack damage is calculated by the server from the attributes and
     * equipment of this mob, and knockback is applied to {@code target} as
     * appropriate.
     *
     * @param target 要攻击的实体。
     */
    public void attack(@NotNull Entity target);

    /**
     * 让此实体挥动其主手。
     * 如果此实体没有挥动主手的动画，则此方法不会执行任何操作。
     * <p>
     * 原文：
     * Makes this entity swing their main hand.
     *
     * This method does nothing if this entity does not have an animation for
     * swinging their main hand.
     */
    public void swingMainHand();

    /**
     * 让此实体挥动其副手。
     * 如果此实体没有挥动副手的动画，则此方法不会执行任何操作。
     * <p>
     * 原文：
     * Makes this entity swing their off hand.
     *
     * This method does nothing if this entity does not have an animation for
     * swinging their off hand.
     */
    public void swingOffHand();

    /**
     * 使此实体闪烁红色，仿佛它们受到了伤害。
     * <p>
     * 原文：
     * Makes this entity flash red as if they were damaged.
     *
     * @param yaw 伤害来源相对于实体的方向，其中 0 表示玩家面前，90 表示右侧，180 表示后方，270 表示左侧。
     */
    public void playHurtAnimation(float yaw);

    /**
     * 设置此实体是否会与其他实体发生碰撞。
     * <p>
     * 对此规则的豁免可以通过 {@link #getCollidableExemptions()} 进行管理。
     * <p>
     * 请注意，客户端可能会预测其与其他实体之间的碰撞，导致此标志在玩家碰撞时无效。
     * 因此，此方法应仅用于设置非玩家实体的碰撞状态。
     * <p>
     * 要控制玩家碰撞，请使用 {@link Team.Option#COLLISION_RULE}，结合 {@link Scoreboard} 和 {@link Team}。
     * <p>
     * 原文：
     * Set if this entity will be subject to collisions with other entities.
     * <p>
     * Exemptions to this rule can be managed with
     * {@link #getCollidableExemptions()}
     * <p>
     * Note that the client may predict the collision between itself and another
     * entity, resulting in this flag not working for player collisions. This
     * method should therefore only be used to set the collision status of
     * non-player entities.
     * <p>
     * To control player collisions, use {@link Team.Option#COLLISION_RULE} in
     * combination with a {@link Scoreboard} and a {@link Team}.
     *
     * @param collidable 碰撞状态
     */
    void setCollidable(boolean collidable);

    /**
     * 获取此实体是否会与其他实体发生碰撞。
     * <p>
     * 某些实体可能会被豁免于此实体的可碰撞规则。
     * 使用 {@link #getCollidableExemptions()} 获取这些实体。
     * <p>
     * 请注意，此方法仅返回自定义的可碰撞状态，
     * 而不考虑实体因其他原因（如死亡）而变得不可碰撞的情况。
     * <p>
     * 请注意，客户端可能会预测其与其他实体之间的碰撞，
     * 导致此标志在玩家碰撞时不准确。
     * 因此，此方法应仅用于检查非玩家实体的碰撞状态。
     * <p>
     * 要检查玩家的碰撞行为，请使用
     * {@link Team.Option#COLLISION_RULE}，结合 {@link Scoreboard} 和 {@link Team}。
     * <p>
     * 原文：
     * Gets if this entity is subject to collisions with other entities.
     * <p>
     * Some entities might be exempted from the collidable rule of this entity.
     * Use {@link #getCollidableExemptions()} to get these.
     * <p>
     * Please note that this method returns only the custom collidable state,
     * not whether the entity is non-collidable for other reasons such as being
     * dead.
     * <p>
     * Note that the client may predict the collision between itself and another
     * entity, resulting in this flag not being accurate for player collisions.
     * This method should therefore only be used to check the collision status
     * of non-player entities.
     * <p>
     * To check the collision behavior for a player, use
     * {@link Team.Option#COLLISION_RULE} in combination with a
     * {@link Scoreboard} and a {@link Team}.
     *
     * @return 碰撞状态
     */
    boolean isCollidable();

    /**
     * 获取可变的 UUID 集合，其中包含被豁免于实体可碰撞规则的实体，
     * 这些实体与此实体的碰撞行为将与之相反。
     * <p>
     * 此集合可以修改，以添加或移除豁免。
     * <p>
     * 例如，如果可碰撞为 true，且某个实体在豁免集合中，
     * 则该实体将不会与其发生碰撞。类似地，如果可碰撞为 false，
     * 而某个实体在此集合中，则仍会与其发生碰撞。
     * <p>
     * 请注意，这些豁免当前不是持久的。
     * <p>
     * 请注意，客户端可能会预测其与其他实体之间的碰撞，
     * 导致这些豁免在玩家碰撞时不准确。
     * 因此，此方法应仅用于豁免非玩家实体。
     * <p>
     * 要为玩家豁免碰撞，请使用 {@link Team.Option#COLLISION_RULE}
     *，结合 {@link Scoreboard} 和 {@link Team}。
     * <p>
     * 原文：
     * Gets a mutable set of UUIDs of the entities which are exempt from the
     * entity's collidable rule and which's collision with this entity will
     * behave the opposite of it.
     * <p>
     * This set can be modified to add or remove exemptions.
     * <p>
     * For example if collidable is true and an entity is in the exemptions set
     * then it will not collide with it. Similarly if collidable is false and an
     * entity is in this set then it will still collide with it.
     * <p>
     * Note these exemptions are not (currently) persistent.
     * <p>
     * Note that the client may predict the collision between itself and another
     * entity, resulting in those exemptions not being accurate for player
     * collisions. This method should therefore only be used to exempt
     * non-player entities.
     * <p>
     * To exempt collisions for a player, use {@link Team.Option#COLLISION_RULE}
     * in combination with a {@link Scoreboard} and a {@link Team}.
     *
     * @return 可碰撞豁免集合
     */
    @NotNull
    Set<UUID> getCollidableExemptions();

    /**
     * 返回指定记忆的值。
     * <p>
     * 请注意，当特定实体默认没有该值时，值为 null。
     * <p>
     * 原文：
     * Returns the value of the memory specified.
     * <p>
     * Note that the value is null when the specific entity does not have that
     * value by default.
     *
     * @param memoryKey 要访问的记忆
     * @param <T> 返回值的类型
     * @return 记忆部分值的实例，如果不存在则返回 null
     */
    @Nullable
    <T> T getMemory(@NotNull MemoryKey<T> memoryKey);

    /**
     * 设置指定记忆的值。
     * <p>
     * 请注意，当特定实体默认没有该值时，值不会被持久化。
     * <p>
     * 原文：
     * Sets the value of the memory specified.
     * <p>
     * Note that the value will not be persisted when the specific entity does
     * not have that value by default.
     *
     * @param memoryKey 要访问的记忆
     * @param memoryValue 一个类型化的记忆值
     * @param <T> 传递值的类型
     */
    <T> void setMemory(@NotNull MemoryKey<T> memoryKey, @Nullable T memoryValue);

    /**
     * 获取此实体在受伤时发出的 {@link Sound}。
     * <p>
     * 原文：
     * Get the {@link Sound} this entity will make when damaged.
     *
     * @return 受伤声音，如果实体不发出声音则返回 null
     */
    @Nullable
    public Sound getHurtSound();

    /**
     * 获取此实体在死亡时发出的 {@link Sound}。
     * <p>
     * 原文：
     * Get the {@link Sound} this entity will make on death.
     *
     * @return 死亡声音，如果实体不发出声音则返回 null
     */
    @Nullable
    public Sound getDeathSound();

    /**
     * 获取此实体从给定高度（以方块为单位）坠落时发出的 {@link Sound}。
     * 如果高度超过 4 个方块，声音通常会在小坠落和大坠落伤害声之间有所不同。
     * <p>
     * 原文：
     * Get the {@link Sound} this entity will make when falling from the given
     * height (in blocks). The sound will often differ between either a small
     * or a big fall damage sound if the height exceeds 4 blocks.
     *
     * @param fallHeight 坠落高度（以方块为单位）
     * @return 坠落伤害声音
     * @see #getFallDamageSoundSmall()
     * @see #getFallDamageSoundBig()
     */
    @NotNull
    public Sound getFallDamageSound(int fallHeight);

    /**
     * 获取此实体从小高度坠落时发出的 {@link Sound}。
     * <p>
     * 原文：
     * Get the {@link Sound} this entity will make when falling from a small
     * height.
     *
     * @return 坠落伤害声音
     */
    @NotNull
    public Sound getFallDamageSoundSmall();

    /**
     * 获取此实体从大高度坠落时发出的 {@link Sound}。
     * <p>
     * 原文：
     * Get the {@link Sound} this entity will make when falling from a large
     * height.
     *
     * @return 坠落伤害声音
     */
    @NotNull
    public Sound getFallDamageSoundBig();

    /**
     * 获取此实体饮用给定 {@link ItemStack} 时发出的 {@link Sound}。
     * <p>
     * 原文：
     * Get the {@link Sound} this entity will make when drinking the given
     * {@link ItemStack}.
     *
     * @param itemStack 正在饮用的物品堆
     * @return 饮用声音
     */
    @NotNull
    public Sound getDrinkingSound(@NotNull ItemStack itemStack);

    /**
     * 获取此实体食用给定 {@link ItemStack} 时发出的 {@link Sound}。
     * <p>
     * 原文：
     * Get the {@link Sound} this entity will make when eating the given
     * {@link ItemStack}.
     *
     * @param itemStack 正在食用的物品堆
     * @return 食用声音
     */
    @NotNull
    public Sound getEatingSound(@NotNull ItemStack itemStack);

    /**
     * 如果此实体可以在水下呼吸，并且在空气供应达到零时不会受到窒息伤害，则返回 true。
     * <p>
     * 原文：
     * Returns true if this entity can breathe underwater and will not take
     * suffocation damage when its air supply reaches zero.
     *
     * @return <code>true</code> 如果实体可以在水下呼吸
     */
    public boolean canBreatheUnderwater();

    /**
     * 获取此实体所属的类别。
     * 类别可能会使此实体受到额外的效果、收益或负面影响。
     * <p>
     * 原文：
     * Get the category to which this entity belongs.
     *
     * Categories may subject this entity to additional effects, benefits or
     * debuffs.
     *
     * @return 实体类别
     * @deprecated 实体分组现在由标签管理，而不是类别
     */
    @NotNull
    @Deprecated(since = "1.20.5")
    public EntityCategory getCategory();

    /**
     * 设置实体是否不可见。
     * <p>
     * 原文：
     * Sets whether the entity is invisible or not.
     *
     * @param invisible 如果实体不可见，则为 true。
     */
    public void setInvisible(boolean invisible);

    /**
     * 获取实体是否不可见。
     * <p>
     * 原文：
     * Gets whether the entity is invisible or not.
     *
     * @return 实体是否不可见
     */
    public boolean isInvisible();

    /**
     * Gets the waypoint color of this entity or null if default/not set.
     *
     * @return waypoint color
     */
    @Nullable
    public Color getWaypointColor();

    /**
     * Sets the waypoint color of this entity, null to reset to default.
     *
     * @param color new color
     */
    public void setWaypointColor(@Nullable Color color);

    /**
     * Gets the waypoint style of this entity.
     *
     * @return waypoint style
     */
    @NotNull
    public NamespacedKey getWaypointStyle();

    /**
     * Sets the waypoint style of this entity.
     *
     * @param key new style key or null for default
     */
    public void setWaypointStyle(@Nullable NamespacedKey key);
}
