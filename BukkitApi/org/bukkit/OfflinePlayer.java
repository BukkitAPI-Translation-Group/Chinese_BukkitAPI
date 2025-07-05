package org.bukkit;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;
import org.bukkit.ban.ProfileBanList;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.permissions.ServerOperator;
import org.bukkit.profile.PlayerProfile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一个对玩家身份及其附属数据的引用, 数据存储于磁盘中, 因此不需要玩家在线即可获取到玩家的引用.
 */
public interface OfflinePlayer extends ServerOperator, AnimalTamer, ConfigurationSerializable {

    /**
     * 检查玩家是否在线
     * <p>
     * 原文:Checks if this player is currently online
     *
     * @return 在线返回true,反之返回false
     */
    public boolean isOnline();

    /**
     * 返回该玩家的游戏名
     * <p>
     * 游戏名并不再是唯一的游戏标识,如果你希望长时间储存,建议使用{@link #getUniqueId()}来替代
     * <p>
     * 原文:Names are no longer unique past a single game session. For persistent storage
     * <p>
     * it is recommended that you use {@link #getUniqueId()} instead.
     *
     * @return 返回玩家游戏名,如果玩家不存在返回null
     */
    @Override
    @Nullable
    public String getName();

    /**
     * 返回该玩家的游戏UUID标识
     *
     * @return 玩家游戏UUID
     */
    @Override
    @NotNull
    public UUID getUniqueId();

    /**
     * 获取玩家资料的一份副本.
     * <p>
     * 如果此玩家在线, 则返回的资料是完整的.
     * 否则, 只保证唯一 id 存在于资料中. 您可以使用
     * {@link PlayerProfile#update()} 来补全返回的资料.
     * <p>
     * 原文:Gets a copy of the player's profile.
     * <p>
     * If the player is online, the returned profile will be complete.
     * Otherwise, only the unique id is guaranteed to be present. You can use
     * {@link PlayerProfile#update()} to complete the returned profile.
     *
     * @return 玩家资料
     */
    @NotNull
    PlayerProfile getPlayerProfile();

    /**
     * 检测该玩家是否被封禁
     *
     * @return 是否被封禁
     */
    public boolean isBanned();

    /**
     * Adds this user to the {@link ProfileBanList}. If a previous ban exists, this will
     * update the entry.
     *
     * @param reason reason for the ban, null indicates implementation default
     * @param expires date for the ban's expiration (unban), or null to imply
     *     forever
     * @param source source of the ban, null indicates implementation default
     * @return the entry for the newly created ban, or the entry for the
     *     (updated) previous ban
     */
    @Nullable
    public BanEntry<PlayerProfile> ban(@Nullable String reason, @Nullable Date expires, @Nullable String source);

    /**
     * Adds this user to the {@link ProfileBanList}. If a previous ban exists, this will
     * update the entry.
     *
     * @param reason reason for the ban, null indicates implementation default
     * @param expires instant for the ban's expiration (unban), or null to imply
     *     forever
     * @param source source of the ban, null indicates implementation default
     * @return the entry for the newly created ban, or the entry for the
     *     (updated) previous ban
     */
    @Nullable
    public BanEntry<PlayerProfile> ban(@Nullable String reason, @Nullable Instant expires, @Nullable String source);

    /**
     * Adds this user to the {@link ProfileBanList}. If a previous ban exists, this will
     * update the entry.
     *
     * @param reason reason for the ban, null indicates implementation default
     * @param duration how long the ban last, or null to imply
     *     forever
     * @param source source of the ban, null indicates implementation default
     * @return the entry for the newly created ban, or the entry for the
     *     (updated) previous ban
     */
    @Nullable
    public BanEntry<PlayerProfile> ban(@Nullable String reason, @Nullable Duration duration, @Nullable String source);

    /**
     * 检测玩家是否存在白名单列表中
     *
     * @return 是否加白
     */
    public boolean isWhitelisted();

    /**
     * 将玩家添加到白名单列表或移除
     *
     * @param value 如果要添加到白名单列表内使用true,反之使用false
     */
    public void setWhitelisted(boolean value);

    /**
     * 获取一个 {@link Player}对象
     * <p>
     * 原文:Gets a {@link Player} object that this represents, if there is one
     * <p>
     * 如果玩家在线,返回Player对象数据,反之返回null
     *
     * @return 玩家Player对象
     */
    @Nullable
    public Player getPlayer();

    /**
     * 获取该玩家第一次进入服务器的时间
     * <p>
     * 原文:Gets the first date and time that this player was witnessed on this
     * server.
     * <p>
     * 返回自1970年1月1日0日0分距当前时间的毫秒数.但如果该玩家从未进入服务器,则会返回0
     * <p>
     * If the player has never played before, this will return 0. Otherwise,
     * it will be the amount of milliseconds since midnight, January 1, 1970
     * UTC.
     *
     * @return 返回玩家第一次进入服务器的时间
     */
    public long getFirstPlayed();

    /**
     * 获取该玩家最后一次登录服务器的时间
     * <p>
     * 原文:Gets the last date and time that this player was witnessed on this
     * server.
     * <p>
     * 返回自1970年1月1日0日0分距当前时间的毫秒数.但如果该玩家从未进入服务器,则会返回0
     * <p>
     * 原文:If the player has never played before, this will return 0. Otherwise,
     * it will be the amount of milliseconds since midnight, January 1, 1970
     * UTC.
     *
     * @return 返回最后登录的时间
     */
    public long getLastPlayed();

    /**
     * 检测该玩家是否在先前在此服游戏过
     * <p>
     * 原文:Checks if this player has played on this server before.
     *
     * @return 如果是返回true,反之返回false
     */
    public boolean hasPlayedBefore();

    /**
     * 获取该玩家在床的重生点的Location对象,但如果该玩家从未使用过床或该重生点无效,则会返回null
     * <p>
     * 原文:Gets the Location where the player will spawn at their bed, null if
     * they have not slept in one or their current bed spawn is invalid.
     *
     * @return 获取玩家的床重生点Location对象信息.如果不存在返回null
     *
     * @see #getRespawnLocation()
     * @deprecated 误导性的方法名称. 此方法也同时返回复活锚点的位置
     */
    @Nullable
    @Deprecated(since = "1.20.4")
    public Location getBedSpawnLocation();

    /**
     * Gets the Location where the player will spawn at, null if they
     * don't have a valid respawn point.
     *
     * @return respawn location if exists, otherwise null.
     */
    @Nullable
    public Location getRespawnLocation();

    /**
     * 把该玩家的统计信息里的某项+1. <p>
     * 这相当于下面的代码: <p>
     * <code>incrementStatistic(Statistic, 1)</code> <p>
     * 原文:Increments the given statistic for this player.
     * <p>
     * This is equivalent to the following code: <p>
     * <code>incrementStatistic(Statistic, 1)</code> <p>
     *
     * @param statistic 要+1的统计项
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果这个statictic需要一个额外的参数??
     */
    public void incrementStatistic(@NotNull Statistic statistic) throws IllegalArgumentException;

    /**
     * 把该玩家的统计信息里的某项-1. <p>
     * 这相当于下面的代码: <p>
     * <code>decrementStatistic(Statistic, 1)</code>
     * 原文:Decrements the given statistic for this player.
     * <p>
     * This is equivalent to the following code:
     * <code>decrementStatistic(Statistic, 1)</code> <p>
     *
     * @param statistic 要减少的统计项目
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果这个统计需要一个额外的参数??
     */
    public void decrementStatistic(@NotNull Statistic statistic) throws IllegalArgumentException;

    /**
     * 把该玩家的统计信息里的某项加上指定的值. <p>
     * 原文:Increments the given statistic for this player. <p>
     *
     * @param statistic 要增加的统计项
     * @param amount 要增加多少
     * @throws IllegalArgumentException 当statistic为null
     * @throws IllegalArgumentException 当amount无效
     * @throws IllegalArgumentException 如果这个统计需要一个额外的参数?
     */
    public void incrementStatistic(@NotNull Statistic statistic, int amount) throws IllegalArgumentException;

    /**
     * 把该玩家的统计信息里的某项减少指定的值. <p>
     * 原文:Decrements the given statistic for this player. <p>
     *
     * @param statistic 要减少的统计项
     * @param amount 要减少多少
     * @throws IllegalArgumentException 当statistic为null
     * @throws IllegalArgumentException 当amount无效
     * @throws IllegalArgumentException 如果这个统计需要一个额外的参数??
     */
    public void decrementStatistic(@NotNull Statistic statistic, int amount) throws IllegalArgumentException;

    /**
     * 设置该玩家的统计信息里的某项的值. <p>
     * 原文:Sets the given statistic for this player. <p>
     *
     * @param statistic 要设置的统计项
     * @param newValue 要把statistic设置成的值
     * @throws IllegalArgumentException 当statistic为null
     * @throws IllegalArgumentException 当amount无效
     * @throws IllegalArgumentException 如果这个统计需要一个额外的参数??
     */
    public void setStatistic(@NotNull Statistic statistic, int newValue) throws IllegalArgumentException;

    /**
     * 得到该玩家的统计信息中某项的值. <p>
     * 原文:Gets the value of the given statistic for this player. <p>
     *
     * @param statistic 要获取值的统计项
     * @return statistic的值
     * @throws IllegalArgumentException 当statistic为null
     * @throws IllegalArgumentException 当amount无效
     * @throws IllegalArgumentException 如果这个统计需要一个额外的参数??
     */
    public int getStatistic(@NotNull Statistic statistic) throws IllegalArgumentException;

    /**
     * 把该玩家的统计信息中跟方块/物品有关的统计项加上一个{@link Material}. <p>
     * 这相当于下面的代码:
     * <code>incrementStatistic(Statistic, Material, 1)</code>
     * 原文:Increments the given statistic for this player for the given material.
     * <p>
     * This is equivalent to the following code:
     * <code>incrementStatistic(Statistic, Material, 1)</code>
     * 译注:比如,要想给玩家的"已破坏过的方块数量"统计里增加一个石头,就用incrementStatistic(统计, Material.STONE)
     *
     * @param statistic 要操纵的统计
     * @param material 要给statistic增加的Material
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果material为null
     * @throws IllegalArgumentException 如果这个成就项使用的不是Material
     */
    public void incrementStatistic(@NotNull Statistic statistic, @NotNull Material material) throws IllegalArgumentException;

    /**
     * 把该玩家的统计信息中跟方块/物品有关的统计项减少一个{@link Material}. <p>
     * 原文:Decrements the given statistic for this player for the given material.
     * <p>
     * This is equivalent to the following code:
     * <code>decrementStatistic(Statistic, Material, 1)</code>
     * 译注:比如,要想给玩家的"已破坏过的方块数量"统计里减少一个石头,就用decrementStatistic(统计, Material.STONE);
     *
     * @param statistic 要操纵的统计
     * @param material 要给statistic减少的Material
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果material为null
     * @throws IllegalArgumentException 如果这个成就项使用的不是Material
     */
    public void decrementStatistic(@NotNull Statistic statistic, @NotNull Material material) throws IllegalArgumentException;

    /**
     * 获取该玩家的统计信息中跟方块/物品有关的统计项的某{@link Material}有多少. <p>
     * 原文:Gets the value of the given statistic for this player. <p>
     * 译注:译注:比如,要想获得玩家的"已破坏过的方块数量"统计里有多少石头,就用getStatistic(统计,Material.STONE);
     *
     * @param statistic 要获取的统计项
     * @param material statistic中,要获取值的Material
     * @return statistic中,material的数量
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果material为null
     * @throws IllegalArgumentException 如果这个成就项使用的不是Material
     */
    public int getStatistic(@NotNull Statistic statistic, @NotNull Material material) throws IllegalArgumentException;

    /**
     * 把该玩家的统计信息中跟方块/物品有关的统计项中的某{@link Material}加上指定的值. <p>
     * 原文:Increments the given statistic for this player for the given material. <p>
     * 译注:比如,要想给玩家的"已破坏过的方块数量"统计里增加指定数量的石头,就用incrementStatistic(统计, Material.STONE, 数量);
     *
     * @param statistic 要操作的统计项
     * @param material statistic里要操作的某个Material
     * @param amount 要把statistic中的material增加多少
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果material为null
     * @throws IllegalArgumentException 如果amount无效
     * @throws IllegalArgumentException 如果statistic跟方块/物品无关
     */
    public void incrementStatistic(@NotNull Statistic statistic, @NotNull Material material, int amount) throws IllegalArgumentException;

    /**
     * 把该玩家的统计信息中跟方块/物品有关的统计项中的某{@link Material}减少指定的值. <p>
     * 原文:Decrements the given statistic for this player for the given material. <p>
     * 译注:该方法与{@link #incrementStatistic(org.bukkit.Statistic, org.bukkit.Material, int) }相反.
     *
     * @param statistic 要减少的统计项
     * @param material statistic中要操作的某个Material
     * @param amount 要把statistic中的material减少多少
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果material为null
     * @throws IllegalArgumentException 如果amount无效
     * @throws IllegalArgumentException 如果这个statistic的值不是Material
     */
    public void decrementStatistic(@NotNull Statistic statistic, @NotNull Material material, int amount) throws IllegalArgumentException;

    /**
     * 把该玩家的统计信息中的某个跟方块/物品有关的统计项中的某{@link Material}的数量设定为某值. <p>
     * 原文:Sets the given statistic for this player for the given material. <p>
     * 译注:比如,要想给玩家的"已破坏过的方块数量"统计里的石头破坏数设定为指定数量,就用setStatistic(统计, Material.STONE, 数量);
     *
     * @param statistic 要设置的统计项
     * @param material statistic中的某个Material
     * @param newValue 要把statistic中的material设置的值
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果material为null
     * @throws IllegalArgumentException 如果newVaule无效
     * @throws IllegalArgumentException 如果statistic跟方块/物品无关
     */
    public void setStatistic(@NotNull Statistic statistic, @NotNull Material material, int newValue) throws IllegalArgumentException;

    /**
     * 把该玩家的统计信息中跟实体有关的统计项中的某种实体({@link EntityType})的数量+1. <p>
     * 这相当于下面的代码: <p>
     * <code>incrementStatistic(Statistic, EntityType, 1)</code> <p>
     * 原文:Increments the given statistic for this player for the given entity.
     * <p>
     * This is equivalent to the following code:
     * <code>incrementStatistic(Statistic, EntityType, 1)</code> <p>
     * 译注:比如,要项给玩家的"已杀过的生物数量"统计里的僵尸数量加上1,就用incrementStatistic(Statistic,EntityType.Zombie);
     *
     * @param statistic 要更改的统计项
     * @param entityType statistic中的某种实体
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果entityType为null
     * @throws IllegalArgumentException 如果statistic与实体无关
     */
    public void incrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType) throws IllegalArgumentException;

    /**
     * 把该玩家的统计信息中跟实体有关的统计项中的某种实体({@link EntityType})的数量-1. <p>
     * 这相当于下面的代码: <p>
     * <code>decrementStatistic(Statistic, EntityType, 1)</code> <p>
     * 原文:Decrements the given statistic for this player for the given entity.
     * <p>
     * This is equivalent to the following code:
     * <code>decrementStatistic(Statistic, EntityType, 1)</code> <p>
     * 译注:该方法与{@link #incrementStatistic(org.bukkit.Statistic, org.bukkit.entity.EntityType) }相反,可以参见该方法.
     *
     * @param statistic 要更改的统计项
     * @param entityType statistic中的某种实体
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果entityType为null
     * @throws IllegalArgumentException 如果statistic与实体无关
     */
    public void decrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType) throws IllegalArgumentException;

    /**
     * 获得该玩家的统计信息中跟实体有关的统计项中的某实体({@link EntityType})数量. <p>
     * 原文:Gets the value of the given statistic for this player. <p>
     * 译注:比如,要获得玩家杀过多少僵尸,就用getStatistic(记录玩家杀实体的统计项,EntityType.Zombie);
     *
     * @param statistic 要获得某实体数的统计项
     * @param entityType 要获取数量的statistic的某实体
     * @return statistic中entitytype中的值
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果entitytype为null
     * @throws IllegalArgumentException 如果statistic与实体无关
     */
    public int getStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType) throws IllegalArgumentException;

    /**
     * 将该玩家的统计信息中的某个跟实体有关的统计项的某实体类型({@link EntityType})加上指定的数值. <p>
     * 原文:Increments the given statistic for this player for the given entity. <p>
     * 译注:跟{@link #incrementStatistic(org.bukkit.Statistic, org.bukkit.entity.EntityType) }类似.只不过这个方法可以指定每次加多少.
     *
     * @param statistic 要操作的统计项
     * @param entityType 要增加的statistic中的某实体
     * @param amount 要增加的数量
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果entitytype为null
     * @throws IllegalArgumentException 如果amount无效
     * @throws IllegalArgumentException 如果statistic与实体无关
     */
    public void incrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType, int amount) throws IllegalArgumentException;

    /**
     * 将该玩家的统计信息中某个跟实体有关的统计项中的某实体类型({@link EntityType})减少指定的值. <p>
     * 原文:Decrements the given statistic for this player for the given entity. <p>
     * 译注:与{@link #incrementStatistic(org.bukkit.Statistic, org.bukkit.entity.EntityType, int) }相反.
     *
     * @param statistic 要操作的统计项
     * @param entityType 要减少的statistic中的某实体
     * @param amount 要减少的数量
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果entitytype为null
     * @throws IllegalArgumentException 如果amount无效
     * @throws IllegalArgumentException 如果statistic与实体无关
     */
    public void decrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType, int amount);

    /**
     * 设置该玩家的统计信息中某个跟实体有关的统计项的某实体类型({@link EntityType})为某个数值. <p>
     * 原文:Sets the given statistic for this player for the given entity. <p>
     *
     * @param statistic 要设置的统计项
     * @param entityType 要设置的statistic中的某实体类型
     * @param newValue 要把statistic中entitytype的数量设置成的值
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果entitytype为null
     * @throws IllegalArgumentException 如果newValue无效
     * @throws IllegalArgumentException 如果statistic与实体无关
     */
    public void setStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType, int newValue);

    /**
     * Gets the player's last death location.
     *
     * @return the last death location if it exists, otherwise null.
     */
    @Nullable
    public Location getLastDeathLocation();

    /**
     * Gets the player's current location.
     *
     * @return the player's location, {@code null} if player hasn't ever played
     * before.
     */
    @Nullable
    public Location getLocation();
}
