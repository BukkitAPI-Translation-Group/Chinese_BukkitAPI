package org.bukkit.entity;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.Locale;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Keyed;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.registry.RegistryAware;
import org.bukkit.util.OldEnum;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 表示村民NPC
 */
public interface Villager extends AbstractVillager {

    /**
     * 获取此村民的当前职业。
     *
     * @return 当前职业。
     * <p>
     * 原文：Gets the current profession of this villager.
     *
     * @return Current profession.
     */
    @NotNull
    public Profession getProfession();

    /**
     * 设置此村民的新职业。
     *
     * @param profession 新职业。
     * <p>
     * 原文：Sets the new profession of this villager.
     *
     * @param profession New profession.
     */
    public void setProfession(@NotNull Profession profession);

    /**
     * 获取此村民的当前类型。
     *
     * @return 当前类型。
     * <p>
     * 原文：Gets the current type of this villager.
     *
     * @return Current type.
     */
    @NotNull
    public Type getVillagerType();

    /**
     * 设置此村民的新类型。
     *
     * @param type 新类型。
     * <p>
     * 原文：Sets the new type of this villager.
     *
     * @param type New type.
     */
    public void setVillagerType(@NotNull Type type);

    /**
     * 获取此村民的等级。
     *
     * 等级为1且没有经验的村民可能会失去其职业。
     *
     * @return 此村民的等级
     * <p>
     * 原文：Gets the level of this villager.
     *
     * A villager with a level of 1 and no experience is liable to lose its
     * profession.
     *
     * @return this villager's level
     */
    public int getVillagerLevel();

    /**
     * 设置此村民的等级。
     *
     * 等级为1且没有经验的村民可能会失去其职业。
     *
     * @param level 新等级
     * @throws IllegalArgumentException 如果等级不在[1, 5]范围内
     * <p>
     * 原文：Sets the level of this villager.
     *
     * A villager with a level of 1 and no experience is liable to lose its
     * profession.
     *
     * @param level the new level
     * @throws IllegalArgumentException if level not between [1, 5]
     */
    public void setVillagerLevel(int level);

    /**
     * 获取此村民的交易经验。
     *
     * @return 交易经验
     * <p>
     * 原文：Gets the trading experience of this villager.
     *
     * @return trading experience
     */
    public int getVillagerExperience();

    /**
     * 设置此村民的交易经验。
     *
     * @param experience 新经验
     * @throws IllegalArgumentException 如果经验 &lt; 0
     * <p>
     * 原文：Sets the trading experience of this villager.
     *
     * @param experience new experience
     * @throws IllegalArgumentException if experience &lt; 0
     */
    public void setVillagerExperience(int experience);

    /**
     * 尝试让此村民在给定位置睡觉。
     * <br>
     * 该位置必须在当前世界中，并且在该位置放置了床。村民在睡觉时会将头放在指定的方块上。
     *
     * @param location 床的位置
     * @return 睡觉是否成功
     * <p>
     * 原文：Attempts to make this villager sleep at the given location.
     * <br>
     * The location must be in the current world and have a bed placed at the
     * location. The villager will put its head on the specified block while
     * sleeping.
     *
     * @param location the location of the bed
     * @return whether the sleep was successful
     */
    public boolean sleep(@NotNull Location location);

    /**
     * 如果此村民正在睡觉，则唤醒他。
     *
     * @throws IllegalStateException 如果没有在睡觉
     * <p>
     * 原文：Causes this villager to wake up if he's currently sleeping.
     *
     * @throws IllegalStateException if not sleeping
     */
    public void wakeup();

    /**
     * 让此村民摇头。
     * <p>
     * 原文：Causes this villager to shake his head.
     */
    public void shakeHead();

    /**
     * 将此村民转换为僵尸村民，就像被僵尸杀死一样。
     *
     * <b>注意：</b>这将触发EntityTransformEvent
     *
     * @return 转换后的实体{@link ZombieVillager}，如果转换被取消则返回null
     * <p>
     * 原文：Convert this Villager into a ZombieVillager as if it was killed by a
     * Zombie.
     *
     * <b>Note:</b> this will fire a EntityTransformEvent
     *
     * @return the converted entity {@link ZombieVillager} or null if the
     * conversion its cancelled
     */
    @Nullable
    public ZombieVillager zombify();

    /**
     * 获取实体对给定类型的声誉。
     *
     * @param uuid 正在检查声誉的实体的UUID
     * @param reputationType 要获取的声誉类型
     * @return 给定声誉类型的当前声誉
     * <p>
     * 原文：Gets the reputation of an entity for a given type.
     *
     * @param uuid the UUID of the entity whose reputation is being checked
     * @param reputationType reputation type to be retrieved
     * @return current reputation for the given reputation type
     */
    public int getReputation(@NotNull UUID uuid, @NotNull ReputationType reputationType);

    /**
     * 获取实体对给定类型的加权声誉。
     *
     * <p>实体的总声誉是其每种类型加权声誉的总和，其中声誉乘以分配给其类型的权重。
     *
     * @param uuid 正在检查声誉的实体的UUID
     * @param reputationType 要获取的声誉类型
     * @return 给定声誉类型的当前声誉
     * @see ReputationType#getWeight()
     * <p>
     * 原文：Gets the weighted reputation of an entity for a given type.
     *
     * <p>The total reputation of an entity is a sum of its weighted
     * reputations of each type, where the reputation is multiplied by weight
     * assigned to its type.
     *
     * @param uuid the UUID of the entity whose reputation is being checked
     * @param reputationType reputation type to be retrieved
     * @return current reputation for the given reputation type
     * @see ReputationType#getWeight()
     */
    public int getWeightedReputation(@NotNull UUID uuid, @NotNull ReputationType reputationType);

    /**
     * 获取实体的声誉。
     *
     * @param uuid 正在检查声誉的实体的UUID
     * @return 给定声誉类型的当前声誉
     * <p>
     * 原文：Gets the reputation of an entity.
     *
     * @param uuid the UUID of the entity whose reputation is being checked
     * @return current reputation for the given reputation type
     */
    public int getReputation(@NotNull UUID uuid);

    /**
     * 向给定实体添加给定类型的声誉。
     *
     * <p>最终值将被限制在所提供声誉类型支持的最大值内。如果最终值低于声誉丢弃阈值，则与此声誉类型相关的八卦将被移除。
     *
     * <p>注意：这将触发{@link org.bukkit.event.entity.VillagerReputationChangeEvent}。
     *
     * @param uuid 正在添加声誉的实体的UUID
     * @param reputationType 要修改的声誉类型
     * @param amount 要添加的声誉数量
     * <p>
     * 原文：Add reputation of a given type towards a given entity.
     *
     * <p>The final value will be clamped to the maximum value supported by the
     * provided reputation type. If the final value is below the reputation
     * discard threshold, gossip associated with this reputation type will be
     * removed.
     *
     * <p>Note: this will fire a
     * {@link org.bukkit.event.entity.VillagerReputationChangeEvent}.
     *
     * @param uuid the UUID of the entity for whom the reputation is being
     *             added
     * @param reputationType reputation type to be modified
     * @param amount amount of reputation to add
     */
    public void addReputation(@NotNull UUID uuid, @NotNull ReputationType reputationType, int amount);

    /**
     * 向给定实体添加给定类型的声誉，并指定更改原因。
     *
     * <p>最终值将被限制在所提供声誉类型支持的最大值内。如果最终值低于声誉丢弃阈值，则与此声誉类型相关的八卦将被移除。
     *
     * <p>注意：这将触发{@link org.bukkit.event.entity.VillagerReputationChangeEvent}。
     *
     * @param uuid 正在添加声誉的实体的UUID
     * @param reputationType 要修改的声誉类型
     * @param amount 要添加的声誉数量
     * @param changeReason 声誉更改原因
     * <p>
     * 原文：Add reputation of a given type towards a given entity, with a specific
     * change reason.
     *
     * <p>The final value will be clamped to the maximum value supported by the
     * provided reputation type. If the final value is below the reputation
     * discard threshold, gossip associated with this reputation type will be
     * removed.
     *
     * <p>Note: this will fire a
     * {@link org.bukkit.event.entity.VillagerReputationChangeEvent}.
     *
     * @param uuid the UUID of the entity for whom the reputation is being
     *             added
     * @param reputationType reputation type to be modified
     * @param amount amount of reputation to add
     * @param changeReason reputation change reason
     */
    public void addReputation(@NotNull UUID uuid, @NotNull ReputationType reputationType, int amount, @NotNull ReputationEvent changeReason);

    /**
     * 移除给定实体给定类型的声誉。
     *
     * <p>最终值将被限制在所提供声誉类型支持的最大值内。如果最终值低于声誉丢弃阈值，则与此声誉类型相关的八卦将被移除。
     *
     * <p>注意：这将触发{@link org.bukkit.event.entity.VillagerReputationChangeEvent}。
     *
     * @param uuid 正在移除声誉的实体的UUID
     * @param reputationType 要修改的声誉类型
     * @param amount 要移除的声誉数量
     * <p>
     * 原文：Remove reputation of a given type towards a given entity.
     *
     * <p>The final value will be clamped to the maximum value supported by the
     * provided reputation type. If the final value is below the reputation
     * discard threshold, gossip associated with this reputation type will be
     * removed.
     *
     * <p>Note: this will fire a
     * {@link org.bukkit.event.entity.VillagerReputationChangeEvent}.
     *
     * @param uuid the UUID of the entity for whom the reputation is being
     *             removed
     * @param reputationType reputation type to be modified
     * @param amount amount of reputation to remove
     */
    public void removeReputation(@NotNull UUID uuid, @NotNull ReputationType reputationType, int amount);

    /**
     * 移除给定实体给定类型的声誉，并指定更改原因。
     *
     * <p>最终值将被限制在所提供声誉类型支持的最大值内。如果最终值低于声誉丢弃阈值，则与此声誉类型相关的八卦将被移除。
     *
     * <p>注意：这将触发{@link org.bukkit.event.entity.VillagerReputationChangeEvent}。
     *
     * @param uuid 正在移除声誉的实体的UUID
     * @param reputationType 要修改的声誉类型
     * @param amount 要移除的声誉数量
     * @param changeReason 声誉更改原因
     * <p>
     * 原文：Remove reputation of a given type towards a given entity, with a
     * specific change reason.
     *
     * <p>The final value will be clamped to the maximum value supported by the
     * provided reputation type. If the final value is below the reputation
     * discard threshold, gossip associated with this reputation type will be
     * removed.
     *
     * <p>Note: this will fire a
     * {@link org.bukkit.event.entity.VillagerReputationChangeEvent}.
     *
     * @param uuid the UUID of the entity for whom the reputation is being
     *             removed
     * @param reputationType reputation type to be modified
     * @param amount amount of reputation to remove
     * @param changeReason reputation change reason
     */
    public void removeReputation(@NotNull UUID uuid, @NotNull ReputationType reputationType, int amount, @NotNull ReputationEvent changeReason);

    /**
     * 设置给定实体给定类型的声誉。
     *
     * <p>最终值将被限制在所提供声誉类型支持的最大值内。如果最终值低于声誉丢弃阈值，则与此声誉类型相关的八卦将被移除。
     *
     * <p>注意：这将触发{@link org.bukkit.event.entity.VillagerReputationChangeEvent}。
     *
     * @param uuid 正在添加声誉的实体的UUID
     * @param reputationType 要修改的声誉类型
     * @param amount 要添加的声誉数量
     * <p>
     * 原文：Set reputation of a given type towards a given entity.
     *
     * <p>The final value will be clamped to the maximum value supported by the
     * provided reputation type. If the final value is below the reputation
     * discard threshold, gossip associated with this reputation type will be
     * removed.
     *
     * <p>Note: this will fire a
     * {@link org.bukkit.event.entity.VillagerReputationChangeEvent}.
     *
     * @param uuid the UUID of the entity for whom the reputation is being
     *             added
     * @param reputationType reputation type to be modified
     * @param amount amount of reputation to add
     */
    public void setReputation(@NotNull UUID uuid, @NotNull ReputationType reputationType, int amount);

    /**
     * 设置给定实体给定类型的声誉，并指定更改原因。
     *
     * <p>最终值将被限制在所提供声誉类型支持的最大值内。如果最终值低于声誉丢弃阈值，则与此声誉类型相关的八卦将被移除。
     *
     * <p>注意：这将触发{@link org.bukkit.event.entity.VillagerReputationChangeEvent}。
     *
     * @param uuid 正在添加声誉的实体的UUID
     * @param reputationType 要修改的声誉类型
     * @param amount 要添加的声誉数量
     * @param changeReason 声誉更改原因
     * <p>
     * 原文：Set reputation of a given type towards a given entity, with a specific
     * change reason.
     *
     * <p>The final value will be clamped to the maximum value supported by the
     * provided reputation type. If the final value is below the reputation
     * discard threshold, gossip associated with this reputation type will be
     * removed.
     *
     * <p>Note: this will fire a
     * {@link org.bukkit.event.entity.VillagerReputationChangeEvent}.
     *
     * @param uuid the UUID of the entity for whom the reputation is being
     *             added
     * @param reputationType reputation type to be modified
     * @param amount amount of reputation to add
     * @param changeReason reputation change reason
     */
    public void setReputation(@NotNull UUID uuid, @NotNull ReputationType reputationType, int amount, @NotNull ReputationEvent changeReason);

    /**
     * 设置此村民的声誉衰减时间。
     *
     * <p>默认为<b>24000</b>（1个昼夜周期）。
     *
     * @param ticks 村民声誉衰减的刻数
     * <p>
     * 原文：Sets the reputation decay time for this villager.
     *
     * <p>Defaults to <b>24000</b> (1 daylight cycle).
     *
     * @param ticks amount of ticks until the villager's reputation decays
     */
    public void setGossipDecayTime(long ticks);

    /**
     * 获取此村民的声誉衰减时间。
     *
     * <p>默认为<b>24000</b>（1个昼夜周期）。
     *
     * @return 村民声誉衰减的刻数
     * <p>
     * 原文：Gets the reputation decay time for this villager.
     *
     * <p>Defaults to <b>24000</b> (1 daylight cycle).
     *
     * @return amount of ticks until the villager's reputation decays
     */
    public long getGossipDecayTime();

    /**
     * 表示村民类型，通常对应它们生成的生物群系。
     */
    interface Type extends OldEnum<Type>, Keyed, RegistryAware {

        Type DESERT = getType("desert");
        Type JUNGLE = getType("jungle");
        Type PLAINS = getType("plains");
        Type SAVANNA = getType("savanna");
        Type SNOW = getType("snow");
        Type SWAMP = getType("swamp");
        Type TAIGA = getType("taiga");

        @NotNull
        private static Type getType(@NotNull String key) {
            return Registry.VILLAGER_TYPE.getOrThrow(NamespacedKey.minecraft(key));
        }

        /**
         * {@inheritDoc}
         *
         * @see #getKeyOrThrow()
         * @see #isRegistered()
         * @deprecated 密钥可能并不总是存在，请使用{@link #getKeyOrThrow()}代替。
         * <p>
         * 原文：{@inheritDoc}
         *
         * @see #getKeyOrThrow()
         * @see #isRegistered()
         * @deprecated A key might not always be present, use {@link #getKeyOrThrow()} instead.
         */
        @NotNull
        @Override
        @Deprecated(since = "1.21.4")
        NamespacedKey getKey();

        /**
         * @param name 村民类型名称。
         * @return 具有给定名称的村民类型。
         * @deprecated 仅为向后兼容，请使用{@link Registry#get(NamespacedKey)}代替。
         * <p>
         * 原文：@param name of the villager type.
         * @return the villager type with the given name.
         * @deprecated only for backwards compatibility, use {@link Registry#get(NamespacedKey)} instead.
         */
        @NotNull
        @Deprecated(since = "1.21")
        static Type valueOf(@NotNull String name) {
            Type type = Registry.VILLAGER_TYPE.get(NamespacedKey.fromString(name.toLowerCase(Locale.ROOT)));
            Preconditions.checkArgument(type != null, "No villager type found with the name %s", name);
            return type;
        }

        /**
         * @return 所有已知村民类型的数组。
         * @deprecated 请使用{@link Registry#iterator()}。
         * <p>
         * 原文：@return an array of all known villager types.
         * @deprecated use {@link Registry#iterator()}.
         */
        @NotNull
        @Deprecated(since = "1.21")
        static Type[] values() {
            return Lists.newArrayList(Registry.VILLAGER_TYPE).toArray(new Type[0]);
        }
    }

    /**
     * 表示村民可能拥有的各种不同职业。
     * 村民根据其职业有不同的交易选项。
     */
    interface Profession extends OldEnum<Profession>, Keyed, RegistryAware {

        Profession NONE = getProfession("none");
        /**
         * 盔甲匠职业。穿着黑色围裙。盔甲匠主要交易铁盔甲、锁链盔甲，有时还有钻石盔甲。
         */
        Profession ARMORER = getProfession("armorer");
        /**
         * 屠夫职业。穿着白色围裙。屠夫主要交易生食和熟食。
         */
        Profession BUTCHER = getProfession("butcher");
        /**
         * 制图师职业。穿着白色长袍。制图师主要交易探索地图和一些纸张。
         */
        Profession CARTOGRAPHER = getProfession("cartographer");
        /**
         * 牧师职业。穿着紫色长袍。牧师主要交易腐肉、金锭、红石、青金石、末影珍珠、荧石和附魔之瓶。
         */
        Profession CLERIC = getProfession("cleric");
        /**
         * 农民职业。穿着棕色长袍。农民主要交易与食物相关的物品。
         */
        Profession FARMER = getProfession("farmer");
        /**
         * 渔夫职业。穿着棕色长袍。渔夫主要交易鱼类，也可能出售线和/或煤炭。
         */
        Profession FISHERMAN = getProfession("fisherman");
        /**
         * 制箭师职业。穿着棕色长袍。制箭师主要交易线、弓和箭。
         */
        Profession FLETCHER = getProfession("fletcher");
        /**
         * 皮匠职业。穿着白色围裙。皮匠主要交易皮革和皮革盔甲，以及鞍。
         */
        Profession LEATHERWORKER = getProfession("leatherworker");
        /**
         * 图书管理员职业。穿着白色长袍。图书管理员主要交易纸张、书籍和附魔书。
         */
        Profession LIBRARIAN = getProfession("librarian");
        /**
         * 石匠职业。
         */
        Profession MASON = getProfession("mason");
        /**
         * 傻瓜职业。穿着绿色围裙，不能交易。傻瓜村民不做任何事情。默认情况下他们没有任何交易。
         */
        Profession NITWIT = getProfession("nitwit");
        /**
         * 牧羊人职业。穿着棕色长袍。牧羊人主要交易羊毛物品和剪刀。
         */
        Profession SHEPHERD = getProfession("shepherd");
        /**
         * 工具匠职业。穿着黑色围裙。工具匠主要交易铁制和钻石工具。
         */
        Profession TOOLSMITH = getProfession("toolsmith");
        /**
         * 武器匠职业。穿着黑色围裙。武器匠主要交易铁制和钻石武器，有时是附魔的。
         */
        Profession WEAPONSMITH = getProfession("weaponsmith");

        @NotNull
        private static Profession getProfession(@NotNull String key) {
            return Registry.VILLAGER_PROFESSION.getOrThrow(NamespacedKey.minecraft(key));
        }

        /**
         * {@inheritDoc}
         *
         * @see #getKeyOrThrow()
         * @see #isRegistered()
         * @deprecated 密钥可能并不总是存在，请使用{@link #getKeyOrThrow()}代替。
         * <p>
         * 原文：{@inheritDoc}
         *
         * @see #getKeyOrThrow()
         * @see #isRegistered()
         * @deprecated A key might not always be present, use {@link #getKeyOrThrow()} instead.
         */
        @NotNull
        @Override
        @Deprecated(since = "1.21.4")
        NamespacedKey getKey();

        /**
         * @param name 村民职业名称。
         * @return 具有给定名称的村民职业。
         * @deprecated 仅为向后兼容，请使用{@link Registry#get(NamespacedKey)}代替。
         * <p>
         * 原文：@param name of the villager profession.
         * @return the villager profession with the given name.
         * @deprecated only for backwards compatibility, use {@link Registry#get(NamespacedKey)} instead.
         */
        @NotNull
        @Deprecated(since = "1.21")
        static Profession valueOf(@NotNull String name) {
            Profession profession = Registry.VILLAGER_PROFESSION.get(NamespacedKey.fromString(name.toLowerCase(Locale.ROOT)));
            Preconditions.checkArgument(profession != null, "No villager profession found with the name %s", name);
            return profession;
        }

        /**
         * @return 所有已知村民职业的数组。
         * @deprecated 请使用{@link Registry#iterator()}。
         * <p>
         * 原文：@return an array of all known villager professions.
         * @deprecated use {@link Registry#iterator()}.
         */
        @NotNull
        @Deprecated(since = "1.21")
        static Profession[] values() {
            return Lists.newArrayList(Registry.VILLAGER_PROFESSION).toArray(new Profession[0]);
        }
    }

    /**
     * 用于八卦中的声誉类型。
     */
    interface ReputationType {

        /**
         * 重大负面声誉。由杀死村民引起。
         */
        ReputationType MAJOR_NEGATIVE = getReputationType("major_negative");
        /**
         * 轻微负面声誉。由攻击村民引起。
         */
        ReputationType MINOR_NEGATIVE = getReputationType("minor_negative");
        /**
         * 轻微正面声誉。由治愈村民引起。
         */
        ReputationType MINOR_POSITIVE = getReputationType("minor_positive");
        /**
         * 重大正面声誉。由治愈村民引起，它永远不会在八卦中共享，也永远不会衰减。
         */
        ReputationType MAJOR_POSITIVE = getReputationType("major_positive");
        /**
         * 交易声誉。它与轻微正面声誉具有相同的权重，由与村民交易引起。
         */
        ReputationType TRADING = getReputationType("trading");

        /**
         * 获取此类型的最大声誉值。
         * @return 此声誉类型的最大值
         * <p>
         * 原文：Get maximum reputation value of this type.
         * @return maximum value of this reputation type
         */
        int getMaxValue();

        /**
         * 获取此声誉类型的权重。
         *
         * <p>在计算实体的总声誉时，每种类型的声誉乘以其权重。
         *
         * @return 分配给此声誉类型的权重
         * <p>
         * 原文：Get weight of this reputation type.
         *
         * <p>When calculating total reputation of an entity, reputation of
         * each type is multiplied by its weight.
         *
         * @return weight assigned to this reputation type
         */
        int getWeight();

        private static ReputationType getReputationType(String key) {
            return Bukkit.getUnsafe().createReputationType(key);
        }
    }

    /**
     * 声誉变更原因。
     */
    interface ReputationEvent {

        /**
         * 村民被玩家治愈。
         */
        ReputationEvent ZOMBIE_VILLAGER_CURED = getReputationEvent("zombie_villager_cured");
        /**
         * 玩家与村民进行了交易。
         */
        ReputationEvent TRADE = getReputationEvent("trade");
        /**
         * 村民被实体伤害。
         */
        ReputationEvent VILLAGER_HURT = getReputationEvent("villager_hurt");
        /**
         * 村民被实体杀死。
         */
        ReputationEvent VILLAGER_KILLED = getReputationEvent("villager_killed");
        /**
         * 村民与另一个村民八卦。
         */
        ReputationEvent GOSSIP = getReputationEvent("bukkit_gossip");
        /**
         * 声誉随时间衰减。
         */
        ReputationEvent DECAY = getReputationEvent("bukkit_decay");
        /**
         * 村庄的铁傀儡被实体杀死。
         */
        ReputationEvent GOLEM_KILLED = getReputationEvent("golem_killed");
        /**
         * 未指定原因。只能通过编程方式设置声誉时使用。
         */
        ReputationEvent UNSPECIFIED = getReputationEvent("bukkit_unspecified");

        private static ReputationEvent getReputationEvent(String key) {
            return Bukkit.getUnsafe().createReputationEvent(key);
        }
    }
}