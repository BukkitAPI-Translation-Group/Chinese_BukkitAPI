package org.bukkit.entity;

import org.bukkit.Location;
import org.bukkit.EntityEffect;
import org.bukkit.Nameable;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.material.Directional;
import org.bukkit.metadata.Metadatable;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.command.CommandSender;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

/**
 * 表示世界中的基本实体
 * <p>
 * 原文:
 * Represents a base entity in the world
 */
public interface Entity extends Metadatable, CommandSender, Nameable {

    /**
     * 获取实体当前位置
     * <p>
     * 原文:
     * Gets the entity's current position
     *
     * @return 一个新的 Location, 包含此实体的位置
     */
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
    public Location getLocation(Location loc);

    /**
     * 设置此实体的速度(向量)
     * <p>
     * 原文:
     * Sets this entity's velocity
     *
     * @param velocity 新的行进速度(向量)
     */
    public void setVelocity(Vector velocity);

    /**
     * 获取此实体的速度(向量)
     * <p>
     * 原文:
     * Gets this entity's current velocity
     *
     * @return 实体当前行进速度(向量)
     */
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
     */
    public boolean isOnGround();

    /**
     * 获取实体当前所在的世界
     * <p>
     * 原文:
     * Gets the current world this entity resides in
     *
     * @return 世界
     */
    public World getWorld();

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
    public boolean teleport(Location location);

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
    public boolean teleport(Location location, TeleportCause cause);

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
    public boolean teleport(Entity destination);

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
    public boolean teleport(Entity destination, TeleportCause cause);

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
    public List<org. bukkit. entity. Entity> getNearbyEntities(double x, double y, double z);

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
     * 将实体标记为删除. 
     * <p>
     * 原文:
     * Mark the entity's removal. 
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
     * 如果此实体已经死亡, 或因为其他原因被抹去, 则返回false. 
     * <p>
     * 原文:
     * Returns false if the entity has died or been despawned for some other
     * reason. 
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
     * @deprecated draft API
     */
    @Deprecated
    public boolean isPersistent();

    /**
     * Sets whether or not the entity gets persisted.
     *
     * @param persistent the persistence status
     * @see #isPersistent()
     * @deprecated draft API
     */
    @Deprecated
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
    @Deprecated
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
     * {@link #getPassengers()}
     */
    @Deprecated
    public boolean setPassenger(Entity passenger);

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
    public boolean addPassenger(Entity passenger);

    /**
     * 移除一名乘客. 
     * <p>
     * 原文:
     * Remove a passenger from the vehicle. 
     *
     * @param passenger 要移除的乘客
     * @return 如果因为某种原因不能删除, 则返回false
     */
    public boolean removePassenger(Entity passenger);

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
     */
    public void setLastDamageCause(EntityDamageEvent event);

    /**
     * 获取此实体上的最后一个{@link EntityDamageEvent}. 
     * <p>
     * 原文:
     * Retrieve the last {@link EntityDamageEvent} inflicted on this entity. 
     * This event may have been cancelled. 
     *
     * @return 最后一个已知的{@link EntityDamageEvent}, 如果迄今为止没有受到伤害, 则为null
     */
    public EntityDamageEvent getLastDamageCause();

    /**
     * 返回实体的UUID (唯一且持久的id)
     * <p>
     * 原文:
     * Returns a unique and persistent id for this entity
     *
     * @return UUID
     */
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
    public void playEffect(EntityEffect type);

    /**
     * 获取实体类型
     * <p>
     * 原文:
     * Get the type of the entity. 
     *
     * @return 实体类型. 
     */
    public EntityType getType();

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
     * 获取玩家所在的载具, 若没有则返回null. 
     * <p>
     * 原文:
     * Get the vehicle that this player is inside. If there is no vehicle,
     * null will be returned. 
     *
     * @return 当前载具
     */
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
     * 设置实体是否有团队颜色(默认白色)的发光. 
     * <p>
     * 原文:
     * Sets whether the entity has a team colored (default: white) glow. 
     *
     * @param flag 是否发光
     */
    void setGlowing(boolean flag);

    /**
     * 获取实体是否发光. 
     * <p>
     * 原文:
     * Gets whether the entity is glowing or not. 
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
     * 获取实体是否静音.  
     * <p>
     * 原文:
     * Gets whether the entity is silent or not. 
     *
     * @return 实体是否静音
     */
    public boolean isSilent();

    /**
     * 获取实体是否静音. 
     * <br>
     * 当尸体被静音时, 它不会发出任何声音. 
     * <p>
     * 原文:
     * Sets whether the entity is silent or not. 
     * <p>
     * When an entity is silent it will not produce any sound. 
     *
     * @param flag 实体是否静音
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
    boolean addScoreboardTag(String tag);

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
    boolean removeScoreboardTag(String tag);

    /**
     * 返回实体被活塞移动时的反应. 
     * <p>
     * 原文:
     * Returns the reaction of the entity when moved by a piston. 
     *
     * @return 反应
     */
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
    BlockFace getFacing();
}
