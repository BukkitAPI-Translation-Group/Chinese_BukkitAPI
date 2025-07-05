package org.bukkit.entity;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Nameable;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.command.CommandSender;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.material.Directional;
import org.bukkit.metadata.Metadatable;
import org.bukkit.persistence.PersistentDataHolder;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 表示世界中的基本实体.
 * <p>
 * 当 {@link #isInWorld()} 返回 false 时, 不保证所有方法都可用/或者有副作用.
 * <p>
 * 原文:
 * Represents a base entity in the world
 * <p>
 * Not all methods are guaranteed to work/may have side effects when
 * {@link #isInWorld()} is false.
 */
public interface Entity extends Metadatable, CommandSender, Nameable, PersistentDataHolder {

    /**
     * 获取实体当前位置
     * <p>
     * 原文:
     * Gets the entity's current position
     *
     * @return 一个新的 Location, 包含此实体的位置
     */
    @NotNull
    public Location getLocation();

    /**
     * 将实体的当前位置存储到提供的Location中. 
     * <br>
     * 如果提供的Location为null，则此方法不会执行任何操作并返回null. 
     * <p>
     * 原文:
     * Stores the entity's current position in the provided Location object. 
     * <p>
     * If the provided Location is null this method does nothing and returns
     * null. 
     *
     * @param loc 要复制到的Location实例
     * @return 提供的Location或null
     */
    @Contract("null -> null; !null -> !null")
    @Nullable
    public Location getLocation(@Nullable Location loc);

    /**
     * 设置此实体的速度 (单位: 米每tick).
     * <p>
     * 原文:
     * Sets this entity's velocity
     *
     * @param velocity 新的行进速度(向量)
     */
    public void setVelocity(@NotNull Vector velocity);

    /**
     * 获取此实体的速度.
     * <p>
     * 原文:
     * Gets this entity's current velocity
     *
     * @return 实体当前行进速度(向量)
     */
    @NotNull
    public Vector getVelocity();

    /**
     * 获取实体高度
     * <p>
     * 原文:
     * Gets the entity's height
     *
     * @return 实体高度
     */
    public double getHeight();

    /**
     * 获取实体宽度
     * <p>
     * 原文:
     * Gets the entity's width
     *
     * @return 实体宽度
     */
    public double getWidth();

    /**
     * Gets the entity's current bounding box.
     * <p>
     * The returned bounding box reflects the entity's current location and
     * size.
     *
     * @return the entity's current bounding box
     */
    @NotNull
    public BoundingBox getBoundingBox();

    /**
     * 返回实体是否站在地面上. 
     * <br>
     * 此值状态由服务器更新, 除非实体移动，否则不会重新计算. 
     * <p>
     * 原文:
     * Returns true if the entity is supported by a block. This value is a
     * state updated by the server and is not recalculated unless the entity
     * moves. 
     *
     * @return 实体是否站在地上
     * @see Player#isOnGround()
     */
    public boolean isOnGround();

    /**
     * 返回实体是否在水中.
     * <p>
     * 原文:
     * Returns true if the entity is in water.
     *
     * @return 实体是否在水中
     */
    public boolean isInWater();

    /**
     * 获取实体当前所在的世界
     * <p>
     * 原文:
     * Gets the current world this entity resides in
     *
     * @return 世界
     */
    @NotNull
    public World getWorld();

    /**
     * Sets the entity's rotation.
     * <p>
     * Note that if the entity is affected by AI, it may override this rotation.
     *
     * @param yaw the yaw
     * @param pitch the pitch
     * @throws UnsupportedOperationException if used for players
     */
    public void setRotation(float yaw, float pitch);

    /**
     * 将此实体传送到给定位置. 
     * <br>
     * 如果该实体乘坐载具, 则在传送之前卸下载具. 
     * <p>
     * 原文:
     * Teleports this entity to the given location. If this entity is riding a
     * vehicle, it will be dismounted prior to teleportation. 
     *
     * @param location 此实体要传送到的新位置
     * @return 是否传送成功
     */
    public boolean teleport(@NotNull Location location);

    /**
     * 将此实体传送到给定位置. 
     * <br>
     * 如果该实体乘坐载具, 则在传送之前卸下载具. 
     * <p>
     * 原文:
     * Teleports this entity to the given location. If this entity is riding a
     * vehicle, it will be dismounted prior to teleportation. 
     *
     * @param location 此实体要传送到的新位置
     * @param cause 传送原因
     * @return 是否传送成功
     */
    public boolean teleport(@NotNull Location location, @NotNull TeleportCause cause);

    /**
     * 将此实体传送到目标实体. 
     * <br>
     * 如果该实体乘坐载具, 则在传送之前离开载具. 
     * <p>
     * 原文:
     * Teleports this entity to the target Entity. If this entity is riding a
     * vehicle, it will be dismounted prior to teleportation. 
     *
     * @param destination 目标实体
     * @return 是否传送成功
     */
    public boolean teleport(@NotNull Entity destination);

    /**
     * 将此实体传送到目标实体. 
     * <br>
     * 如果该实体乘坐载具, 则在传送之前离开载具. 
     * <p>
     * 原文:
     * Teleports this entity to the given location. If this entity is riding a
     * vehicle, it will be dismounted prior to teleportation. 
     *
     * @param destination 目标实体
     * @param cause 传送原因
     * @return 是否传送成功
     */
    public boolean teleport(@NotNull Entity destination, @NotNull TeleportCause cause);

    /**
     * 返回以此实体为中心的边界框内的所有实体. 
     * <p>
     * 原文:
     * Returns a list of entities within a bounding box centered around this
     * entity
     *
     * @param x 边界框X轴半径
     * @param y 边界框Y轴半径
     * @param z 边界框Z轴半径
     * @return {@code List<Entity>} 附近的实体列表
     */
    @NotNull
    public List<org.bukkit.entity.Entity> getNearbyEntities(double x, double y, double z);

    /**
     * 返回此实体的唯一ID
     * <p>
     * 原文:
     * Returns a unique id for this entity
     *
     * @return 实体ID
     */
    public int getEntityId();

    /**
     * 返回实体当前着火的tick (还有多久停止着火)
     * <p>
     * 原文:
     * Returns the entity's current fire ticks (ticks before the entity stops
     * being on fire). 
     *
     * @return 着火刻的数值
     */
    public int getFireTicks();

    /**
     * 返回实体的最大着火刻
     * <p>
     * 原文:
     * Returns the entity's maximum fire ticks. 
     *
     * @return 最大着火刻的数值
     */
    public int getMaxFireTicks();

    /**
     * 设置实体当前着火的tick (还有多久停止着火)
     * <p>
     * 原文:
 	 * Sets the entity's current fire ticks (ticks before the entity stops
     * being on fire). 
     *
     * @param ticks 剩余的刻数
     */
    public void setFireTicks(int ticks);

    /**
     * Sets if the entity has visual fire (it will always appear to be on fire).
     *
     * @param fire whether visual fire is enabled
     */
    void setVisualFire(boolean fire);

    /**
     * Gets if the entity has visual fire (it will always appear to be on fire).
     *
     * @return whether visual fire is enabled
     */
    boolean isVisualFire();

    /**
     * Returns the entity's current freeze ticks (amount of ticks the entity has
     * been in powdered snow).
     *
     * @return int freeze ticks
     */
    int getFreezeTicks();

    /**
     * Returns the entity's maximum freeze ticks (amount of ticks before it will
     * be fully frozen)
     *
     * @return int max freeze ticks
     */
    int getMaxFreezeTicks();

    /**
     * Sets the entity's current freeze ticks (amount of ticks the entity has
     * been in powdered snow).
     *
     * @param ticks Current ticks
     */
    void setFreezeTicks(int ticks);

    /**
     * Gets if the entity is fully frozen (it has been in powdered snow for max
     * freeze ticks).
     *
     * @return freeze status
     */
    boolean isFrozen();

    /**
     * 将实体标记为删除. 
     * <p>
     * 原文:
     * Mark the entity's removal.
     *
     * @throws UnsupportedOperationException 如果你试图移除一名 {@link Player 玩家}. 对于此场景请使用 {@link Player#kickPlayer(String)}
     */
    public void remove();

    /**
     * 返回此实体是否已被标记为删除. 
     * <p>
     * 原文:
     * Returns true if this entity has been marked for removal. 
     *
     * @return 实体是否死亡
     */
    public boolean isDead();

    /**
     * 如果此实体已经死亡、因为其他原因被抹去或尚未添加到世界, 则返回false. 
     * <p>
     * 原文:
     * Returns false if the entity has died, been despawned for some other
     * reason, or has not been added to the world. 
     *
     * @return 实体是否有效. 
     */
    public boolean isValid();

    /**
     * 返回包含此实体的服务器
     * <p>
     * 原文:
     * Gets the {@link Server} that contains this Entity
     *
     * @return 运行此实体的服务器
     */
    @Override
    @NotNull
    public Server getServer();

    /**
     * Returns true if the entity gets persisted.
     * <p>
     * By default all entities are persistent. An entity will also not get
     * persisted, if it is riding an entity that is not persistent.
     * <p>
     * The persistent flag on players controls whether or not to save their
     * playerdata file when they quit. If a player is directly or indirectly
     * riding a non-persistent entity, the vehicle at the root and all its
     * passengers won't get persisted.
     * <p>
     * <b>This should not be confused with
     * {@link LivingEntity#setRemoveWhenFarAway(boolean)} which controls
     * despawning of living entities. </b>
     *
     * @return true if this entity is persistent
     */
    public boolean isPersistent();

    /**
     * Sets whether or not the entity gets persisted.
     *
     * @param persistent the persistence status
     * @see #isPersistent()
     */
    public void setPersistent(boolean persistent);

    /**
     * 获取乘坐载具的主要乘客.
     * <br>
     * 可能会有多个乘客, 这个方法只返回主要乘客.
     * <p>
     * 原文:Gets the primary passenger of a vehicle. For vehicles that could have
     * multiple passengers, this will only return the primary passenger. 
     *
     * @return 一个实体
     * @deprecated 实体可能有多名乘客. 请使用
     * {@link #getPassengers()}
     */
    @Deprecated(since = "1.11.2")
    @Nullable
    public Entity getPassenger();

    /**
     * 设置乘坐载具的主要乘客. 
     * <p>
     * 原文:
     * Set the passenger of a vehicle. 
     *
     * @param passenger 新乘客
     * @return 如果因为某种原因不能设置, 则返回false
     * @deprecated 实体可能有多名乘客. 请使用
     * {@link #addPassenger(org.bukkit.entity.Entity)}
     */
    @Deprecated(since = "1.11.2")
    public boolean setPassenger(@NotNull Entity passenger);

    /**
     * 获取载具的乘客列表. 
     * <br>
     * 对返回列表的操作不会反映到实体的当前乘客列表上, 也不保证返回列表的可变性. 
     * <p>
     * 原文:
     * Gets a list of passengers of this vehicle. 
     * <p>
     * The returned list will not be directly linked to the entity's current
     * passengers, and no guarantees are made as to its mutability. 
     *
     * @return 与当前乘客相对应的实体列表. 
     */
    @NotNull
    public List<Entity> getPassengers();

    /** 
     * 添加一名乘客. 
     * <p>
     * 原文:
     * Add a passenger to the vehicle. 
     *
     * @param passenger 要添加的乘客
     * @return 如果因为某种原因不能添加, 则返回false
     */
    public boolean addPassenger(@NotNull Entity passenger);

    /**
     * 移除一名乘客. 
     * <p>
     * 原文:
     * Remove a passenger from the vehicle. 
     *
     * @param passenger 要移除的乘客
     * @return 如果因为某种原因不能删除, 则返回false
     */
    public boolean removePassenger(@NotNull Entity passenger);

    /**
     * 检查是否有乘客. 
     * <p>
     * 原文:
     * Check if a vehicle has passengers. 
     *
     * @return 载具是否为空. 
     */
    public boolean isEmpty();

    /**
     * 弹出所有乘客. 
     * <p>
     * 原文:
     * Eject any passenger. 
     *
     * @return 是否有乘客被弹出. 
     */
    public boolean eject();

    /**
     * 返回此实体已下落的距离. 
     * <p>
     * 原文:
     * Returns the distance this entity has fallen
     *
     * @return 距离. 
     */
    public float getFallDistance();

    /**
     * 设置此实体已下落的距离. 
     * <p>
     * 原文:
     * Sets the fall distance for this entity
     *
     * @param distance 新距离. 
     */
    public void setFallDistance(float distance);

    /**
     * 记录此实体上的最后一个{@link EntityDamageEvent}. 
     * <p>
     * 原文:
     * Record the last {@link EntityDamageEvent} inflicted on this entity
     *
     * @param event 一个 {@link EntityDamageEvent}
     * @deprecated 此方法仅供内部使用, 将被移除
     */
    @Deprecated(since = "1.20.4", forRemoval = true)
    public void setLastDamageCause(@Nullable EntityDamageEvent event);

    /**
     * 获取此实体上的最后一个{@link EntityDamageEvent}. 
     * <p>
     * 原文:
     * Retrieve the last {@link EntityDamageEvent} inflicted on this entity. 
     * This event may have been cancelled. 
     *
     * @return 最后一个已知的{@link EntityDamageEvent}, 如果迄今为止没有受到伤害, 则为null
     */
    @Nullable
    public EntityDamageEvent getLastDamageCause();

    /**
     * 返回实体的UUID (唯一且持久的id)
     * <p>
     * 原文:
     * Returns a unique and persistent id for this entity
     *
     * @return UUID
     */
    @NotNull
    public UUID getUniqueId();

    /**
     * 获取此实体生存时间刻. 
     * <br>
     * 这相当于实体的"年龄". 
     * <p>
     * 原文:
     * Gets the amount of ticks this entity has lived for. 
     * <p>
     * This is the equivalent to "age" in entities. 
     *
     * @return 实体年龄
     */
    public int getTicksLived();

    /**
     * 设置此实体生存时间刻. 
     * <br>
     * 这相当于实体中的"年龄". 不得少于一个tick. 
     * <p>
     * 原文:
     * Sets the amount of ticks this entity has lived for. 
     * <p>
     * This is the equivalent to "age" in entities. May not be less than one
     * tick. 
     *
     * @param value 实体年龄
     */
    public void setTicksLived(int value);

    /**
     * 为此实体执行指定的{@link EntityEffect}. 
     * <br>
     * 这将对实体附近的所有玩家都是可见的. 
     * <br>
     * 如果效果不适用于此类实体，则不会播放. 
     * <p>
     * 原文:
     * Performs the specified {@link EntityEffect} for this entity. 
     * <p>
     * This will be viewable to all players near the entity. 
     * <p>
     * If the effect is not applicable to this class of entity, it will not play. 
     *
     * @param type 播放效果. 
     */
    public void playEffect(@NotNull EntityEffect type);

    /**
     * 获取实体类型
     * <p>
     * 原文:
     * Get the type of the entity. 
     *
     * @return 实体类型. 
     */
    @NotNull
    public EntityType getType();

    /**
     * Get the {@link Sound} this entity makes while swimming.
     *
     * @return the swimming sound
     */
    @NotNull
    public Sound getSwimSound();

    /**
     * Get the {@link Sound} this entity makes when splashing in water. For most
     * entities, this is just {@link Sound#ENTITY_GENERIC_SPLASH}.
     *
     * @return the splash sound
     */
    @NotNull
    public Sound getSwimSplashSound();

    /**
     * Get the {@link Sound} this entity makes when splashing in water at high
     * speeds. For most entities, this is just {@link Sound#ENTITY_GENERIC_SPLASH}.
     *
     * @return the splash sound
     */
    @NotNull
    public Sound getSwimHighSpeedSplashSound();

    /**
     * 返回此实体是否在载具内. 
     * <p>
     * 原文:
     * Returns whether this entity is inside a vehicle. 
     *
     * @return 此实体是否在载具内. 
     */
    public boolean isInsideVehicle();

    /**
     * 离开当前的载具. 如果实体当前在载具中(并从中移除), 则返回true, 否则将返回false. 
     * <p>
     * 原文:
     * Leave the current vehicle. If the entity is currently in a vehicle (and
     * is removed from it), true will be returned, otherwise false will be
     * returned. 
     *
     * @return 是否成功离开. 
     */
    public boolean leaveVehicle();

    /**
     * 获取实体所在的载具, 若没有则返回null. 
     * <p>
     * 原文:
     * Get the vehicle that this entity is inside. If there is no vehicle,
     * null will be returned.
     *
     * @return 当前载具
     */
    @Nullable
    public Entity getVehicle();

    /**
     * 设置是否在客户端上显示实体的自定义名称. 名称将会像玩家一样显示在实体上方. 
     * <br>
     * 这个值对玩家无效, 玩家会一直显示. 
     * <p>
     * 原文:
     * Sets whether or not to display the mob's custom name client side. The
     * name will be displayed above the mob similarly to a player. 
     * <p>
     * This value has no effect on players, they will always display their
     * name. 
     *
     * @param flag 是否显示自定义名称
     */
    public void setCustomNameVisible(boolean flag);

    /**
     * 获取是否在客户端上显示实体的自定义名称. 名称将会像玩家一样显示在实体上方. 
     * <br>
     * 这个值对玩家无效, 玩家会一直显示. 
     * <p>
     * 原文:
     * Gets whether or not the mob's custom name is displayed client side. 
     * <p>
     * This value has no effect on players, they will always display their
     * name. 
     *
     * @return 是否显示自定义名称
     */
    public boolean isCustomNameVisible();

    /**
     * Sets whether or not this entity is visible by default.
     *
     * If this entity is not visible by default, then
     * {@link Player#showEntity(org.bukkit.plugin.Plugin, org.bukkit.entity.Entity)}
     * will need to be called before the entity is visible to a given player.
     *
     * @param visible default visibility status
     */
    public void setVisibleByDefault(boolean visible);

    /**
     * Gets whether or not this entity is visible by default.
     *
     * If this entity is not visible by default, then
     * {@link Player#showEntity(org.bukkit.plugin.Plugin, org.bukkit.entity.Entity)}
     * will need to be called before the entity is visible to a given player.
     *
     * @return default visibility status
     */
    public boolean isVisibleByDefault();
    
    /**
     * Get all players that are currently tracking this entity.
     * <p>
     * 'Tracking' means that this entity has been sent to the player and that
     * they are receiving updates on its state. Note that the client's {@code
     * 'Entity Distance'} setting does not affect the range at which entities
     * are tracked.
     *
     * @return the players tracking this entity, or an empty set if none
     */
    @NotNull
    Set<Player> getTrackedBy();

    /**
     * 设置实体是否有团队颜色(默认白色)的发光. 
     * <b>注意:本方法用到了实体的'Glowing'属性, 不是给实体应用发光药水效果.</b>
     * <p>
     * 原文:
     * Sets whether the entity has a team colored (default: white) glow.
     *
     * <b>nb: this refers to the 'Glowing' entity property, not whether a
     * glowing potion effect is applied</b>
     *
     * @param flag 是否发光
     */
    void setGlowing(boolean flag);

    /**
     * 获取实体是否发光. 
     * <b>注意:本方法用到了实体的'Glowing'属性, 不是给实体应用发光药水效果.</b>
     * <p>
     * 原文:
     * <b>nb: this refers to the 'Glowing' entity property, not whether a
     * glowing potion effect is applied</b>
     *
     * @return 是否发光
     */
    boolean isGlowing();

    /**
     * 设置实体是否无敌. 
     * <br>
     * 当一个实体无敌时, 它只能被创造性模式中的玩家攻击. 
     * <p>
     * 原文:
     * Sets whether the entity is invulnerable or not. 
     * <p>
     * When an entity is invulnerable it can only be damaged by players in
     * creative mode. 
     *
     * @param flag 是否无敌
     */
    public void setInvulnerable(boolean flag);

    /**
     * 获取实体是否无敌. 
     * <p>
     * 原文:
     * Gets whether the entity is invulnerable or not. 
     *
     * @return 是否无敌
     */
    public boolean isInvulnerable();

    /**
     * 获取实体是否保持安静.  
     * <p>
     * 原文:
     * Gets whether the entity is silent or not. 
     *
     * @return 实体是否保持安静
     */
    public boolean isSilent();

    /**
     * 获取实体是否保持安静.
     * <br>
     * 当实体静默时, 它不会发出任何声音. 
     * <p>
     * 原文:
     * Sets whether the entity is silent or not. 
     * <p>
     * When an entity is silent it will not produce any sound. 
     *
     * @param flag 实体是否保持安静
     */
    public void setSilent(boolean flag);

    /**
     * 返回重力是否适用于此实体.  
     * <p>
     * 原文:
     * Returns whether gravity applies to this entity. 
     *
     * @return 重力是否适用于此实体
     */
    boolean hasGravity();

    /**
     * 设置重力是否适用于此实体.  
     * <p>
     * 原文:
     * Sets whether gravity applies to this entity. 
     *
     * @param gravity 重力是否适用于此实体
     */
    void setGravity(boolean gravity);

    /**
     * 获取此实体能再次使用传送门前需要等待的时间 (以刻为单位).  
     * <p>
     * 原文:
     * Gets the period of time (in ticks) before this entity can use a portal. 
     *
     * @return portal cooldown ticks
     */
    int getPortalCooldown();

    /**
     * Sets the period of time (in ticks) before this entity can use a portal. 
     *
     * @param cooldown portal cooldown ticks
     */
    void setPortalCooldown(int cooldown);

    /**
     * 返回实体标签集合. 
     * <br>
     * 实体的标签数不得超过1024个. 
     * <p>
     * 原文:
     * Returns a set of tags for this entity. 
     * <br>
     * Entities can have no more than 1024 tags. 
     *
     * @return 此实体的标签集合
     */
    @NotNull
    Set<String> getScoreboardTags();

    /**
     * 为此实体添加一个标签. 
     * <br>
     * 实体的标签数不得超过1024个. 
     * <p>
     * 原文:
     * Add a tag to this entity. 
     * <br>
     * Entities can have no more than 1024 tags. 
     *
     * @param tag 要添加的标签
     * @return 是否成功添加
     */
    boolean addScoreboardTag(@NotNull String tag);

    /**
     * 删除此实体的一个标签. 
     * <br>
     * 实体的标签数不得超过1024个. 
     * <p>
     * 原文:
     * Removes a given tag from this entity. 
     *
     * @param tag 要删除的标签
     * @return 是否成功删除
     */
    boolean removeScoreboardTag(@NotNull String tag);

    /**
     * 返回实体被活塞移动时的反应. 
     * <p>
     * 原文:
     * Returns the reaction of the entity when moved by a piston. 
     *
     * @return 反应
     */
    @NotNull
    PistonMoveReaction getPistonMoveReaction();

    /**
     * Get the closest cardinal {@link BlockFace} direction an entity is
     * currently facing.
     * <br>
     * This will not return any non-cardinal directions such as
     * {@link BlockFace#UP} or {@link BlockFace#DOWN}.
     * <br>
     * {@link Hanging} entities will override this call and thus their behavior
     * may be different.
     *
     * @return the entity's current cardinal facing.
     * @see Hanging
     * @see Directional#getFacing()
     */
    @NotNull
    BlockFace getFacing();

    /**
     * Gets the entity's current pose.
     *
     * <b>Note that the pose is only updated at the end of a tick, so may be
     * inconsistent with other methods. eg {@link Player#isSneaking()} being
     * true does not imply the current pose will be {@link Pose#SNEAKING}</b>
     *
     * @return current pose
     */
    @NotNull
    Pose getPose();

    /**
     * Get the category of spawn to which this entity belongs.
     *
     * @return the entity´s category spawn
     */
    @NotNull
    SpawnCategory getSpawnCategory();

    /**
     * Checks if this entity has been spawned in a world. <br>
     * Entities not spawned in a world will not tick, be sent to players, or be
     * saved to the server files.
     *
     * @return whether the entity has been spawned in a world
     */
    boolean isInWorld();

    /**
     * Get this entity as an NBT string.
     * <p>
     * This string should not be relied upon as a serializable value.
     *
     * @return the NBT string or null if one cannot be made
     */
    @Nullable
    @ApiStatus.Experimental
    String getAsString();

    /**
     * Crates an {@link EntitySnapshot} representing the current state of this entity.
     *
     * @return a snapshot representing this entity or null if one cannot be made
     */
    @Nullable
    @ApiStatus.Experimental
    EntitySnapshot createSnapshot();

    /**
     * Creates a copy of this entity and all its data. Does not spawn the copy in
     * the world. <br>
     * <b>Note:</b> Players cannot be copied.
     *
     * @return a copy of this entity.
     */
    @NotNull
    @ApiStatus.Experimental
    Entity copy();

    /**
     * Creates a copy of this entity and all its data. Spawns the copy at the given location. <br>
     * <b>Note:</b> Players cannot be copied.
     * @param to the location to copy to
     * @return a copy of this entity.
     */
    @NotNull
    @ApiStatus.Experimental
    Entity copy(@NotNull Location to);

    // Spigot start
    public class Spigot extends CommandSender.Spigot {

    }

    @NotNull
    @Override
    Spigot spigot();
    // Spigot end
}
