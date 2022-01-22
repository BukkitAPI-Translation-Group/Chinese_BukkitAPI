package org.bukkit.entity;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.attribute.Attributable;
import org.bukkit.block.Block;
import org.bukkit.entity.memory.MemoryKey;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
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
     * Gets the block that the living entity has targeted.
     * <p>
     * This takes the blocks' precise collision shapes into account. Fluids are
     * ignored.
     * <p>
     * This may cause loading of chunks! Some implementations may impose
     * artificial restrictions on the maximum distance.
     *
     * @param maxDistance the maximum distance to scan
     * @return block that the living entity has targeted
     * @see #getTargetBlockExact(int, org.bukkit.FluidCollisionMode)
     */
    @Nullable
    public Block getTargetBlockExact(int maxDistance);

    /**
     * Gets the block that the living entity has targeted.
     * <p>
     * This takes the blocks' precise collision shapes into account.
     * <p>
     * This may cause loading of chunks! Some implementations may impose
     * artificial restrictions on the maximum distance.
     *
     * @param maxDistance the maximum distance to scan
     * @param fluidCollisionMode the fluid collision mode
     * @return block that the living entity has targeted
     * @see #rayTraceBlocks(double, FluidCollisionMode)
     */
    @Nullable
    public Block getTargetBlockExact(int maxDistance, @NotNull FluidCollisionMode fluidCollisionMode);

    /**
     * Performs a ray trace that provides information on the targeted block.
     * <p>
     * This takes the blocks' precise collision shapes into account. Fluids are
     * ignored.
     * <p>
     * This may cause loading of chunks! Some implementations may impose
     * artificial restrictions on the maximum distance.
     *
     * @param maxDistance the maximum distance to scan
     * @return information on the targeted block, or <code>null</code> if there
     *     is no targeted block in range
     * @see #rayTraceBlocks(double, FluidCollisionMode)
     */
    @Nullable
    public RayTraceResult rayTraceBlocks(double maxDistance);

    /**
     * Performs a ray trace that provides information on the targeted block.
     * <p>
     * This takes the blocks' precise collision shapes into account.
     * <p>
     * This may cause loading of chunks! Some implementations may impose
     * artificial restrictions on the maximum distance.
     *
     * @param maxDistance the maximum distance to scan
     * @param fluidCollisionMode the fluid collision mode
     * @return information on the targeted block, or <code>null</code> if there
     *     is no targeted block in range
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
     * Gets the time in ticks until the next arrow leaves the entity's body.
     *
     * @return ticks until arrow leaves
     */
    public int getArrowCooldown();

    /**
     * Sets the time in ticks until the next arrow leaves the entity's body.
     *
     * @param ticks time until arrow leaves
     */
    public void setArrowCooldown(int ticks);

    /**
     * Gets the amount of arrows in an entity's body.
     *
     * @return amount of arrows in body
     */
    public int getArrowsInBody();

    /**
     * Set the amount of arrows in the entity's body.
     *
     * @param count amount of arrows in entity's body
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
     * 原文:Returns the living entity's last damage taken in the current no damage
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
    @Deprecated
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
     * Makes entity start or stop gliding. This will work even if an Elytra
     * is not equipped, but will be reverted by the server immediately after
     * unless an event-cancelling mechanism is put in place.
     * @param gliding True if the entity is gliding.
     */
    public void setGliding(boolean gliding);

    /**
     * Checks to see if an entity is swimming.
     *
     * @return True if this entity is swimming.
     */
    public boolean isSwimming();

    /**
     * Makes entity start or stop swimming.
     *
     * This may have unexpected results if the entity is not in water.
     *
     * @param swimming True if the entity is swimming.
     */
    public void setSwimming(boolean swimming);

    /**
     * Checks to see if an entity is currently using the Riptide enchantment.
     *
     * @return True if this entity is currently riptiding.
     */
    public boolean isRiptiding();

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
     * Makes this entity attack the given entity with a melee attack.
     *
     * Attack damage is calculated by the server from the attributes and
     * equipment of this mob, and knockback is applied to {@code target} as
     * appropriate.
     *
     * @param target entity to attack.
     */
    public void attack(@NotNull Entity target);

    /**
     * Makes this entity swing their main hand.
     *
     * This method does nothing if this entity does not have an animation for
     * swinging their main hand.
     */
    public void swingMainHand();

    /**
     * Makes this entity swing their off hand.
     *
     * This method does nothing if this entity does not have an animation for
     * swinging their off hand.
     */
    public void swingOffHand();

    /**
     * Set if this entity will be subject to collisions with other entities.
     * <p>
     * Exemptions to this rule can be managed with
     * {@link #getCollidableExemptions()}
     *
     * @param collidable collision status
     */
    void setCollidable(boolean collidable);

    /**
     * Gets if this entity is subject to collisions with other entities.
     * <p>
     * Some entities might be exempted from the collidable rule of this entity.
     * Use {@link #getCollidableExemptions()} to get these.
     * <p>
     * Please note that this method returns only the custom collidable state,
     * not whether the entity is non-collidable for other reasons such as being
     * dead.
     *
     * @return collision status
     */
    boolean isCollidable();

    /**
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
     *
     * @return the collidable exemption set
     */
    @NotNull
    Set<UUID> getCollidableExemptions();

    /**
     * Returns the value of the memory specified.
     * <p>
     * Note that the value is null when the specific entity does not have that
     * value by default.
     *
     * @param memoryKey memory to access
     * @param <T> the type of the return value
     * @return a instance of the memory section value or null if not present
     */
    @Nullable
    <T> T getMemory(@NotNull MemoryKey<T> memoryKey);

    /**
     * Sets the value of the memory specified.
     * <p>
     * Note that the value will not be persisted when the specific entity does
     * not have that value by default.
     *
     * @param memoryKey the memory to access
     * @param memoryValue a typed memory value
     * @param <T> the type of the passed value
     */
    <T> void setMemory(@NotNull MemoryKey<T> memoryKey, @Nullable T memoryValue);

    /**
     * Get the category to which this entity belongs.
     *
     * Categories may subject this entity to additional effects, benefits or
     * debuffs.
     *
     * @return the entity category
     */
    @NotNull
    public EntityCategory getCategory();

    /**
     * Sets whether the entity is invisible or not.
     *
     * @param invisible If the entity is invisible
     */
    public void setInvisible(boolean invisible);

    /**
     * Gets whether the entity is invisible or not.
     *
     * @return Whether the entity is invisible
     */
    public boolean isInvisible();
}
