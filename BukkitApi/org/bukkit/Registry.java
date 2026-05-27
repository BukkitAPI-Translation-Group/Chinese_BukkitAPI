package org.bukkit;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.bukkit.advancement.Advancement;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Biome;
import org.bukkit.block.BlockType;
import org.bukkit.block.banner.PatternType;
import org.bukkit.boss.KeyedBossBar;
import org.bukkit.damage.DamageType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Cat;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Frog;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.ZombieNautilus;
import org.bukkit.entity.memory.MemoryKey;
import org.bukkit.generator.structure.Structure;
import org.bukkit.generator.structure.StructureType;
import org.bukkit.inventory.ItemType;
import org.bukkit.inventory.MenuType;
import org.bukkit.inventory.meta.trim.TrimMaterial;
import org.bukkit.inventory.meta.trim.TrimPattern;
import org.bukkit.loot.LootTable;
import org.bukkit.loot.LootTables;
import org.bukkit.map.MapCursor;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 表示可以通过 {@link NamespacedKey} 检索的 Bukkit 对象注册表。
 *
 * @param <T> 注册表中项目的类型
 */
public interface Registry<T extends Keyed> extends Iterable<T> {

    /**
     * 服务器进度。
     *
     * @see Bukkit#getAdvancement(org.bukkit.NamespacedKey)
     * @see Bukkit#advancementIterator()
     * @deprecated Advancement 没有真正的服务端注册表。
     */
    @Deprecated(since = "1.21.4")
    Registry<Advancement> ADVANCEMENT = new Registry<Advancement>() {

        @Nullable
        @Override
        public Advancement get(@NotNull NamespacedKey key) {
            return Bukkit.getAdvancement(key);
        }

        @NotNull
        @Override
        public Advancement getOrThrow(@NotNull NamespacedKey key) {
            Advancement advancement = get(key);

            Preconditions.checkArgument(advancement != null, "No Advancement registry entry found for key %s.", key);

            return advancement;
        }

        @NotNull
        @Override
        public Stream<Advancement> stream() {
            return StreamSupport.stream(spliterator(), false);
        }

        @NotNull
        @Override
        public Iterator<Advancement> iterator() {
            return Bukkit.advancementIterator();
        }
    };
    /**
     * 服务器艺术品。
     *
     * @see Art
     */
    Registry<Art> ART = Objects.requireNonNull(Bukkit.getRegistry(Art.class), "No registry present for Art. This is a bug.");
    /**
     * 属性。
     *
     * @see Attribute
     */
    Registry<Attribute> ATTRIBUTE = Objects.requireNonNull(Bukkit.getRegistry(Attribute.class), "No registry present for Attribute. This is a bug.");
    /**
     * 服务器旗帜图案。
     *
     * @see PatternType
     */
    Registry<PatternType> BANNER_PATTERN = Objects.requireNonNull(Bukkit.getRegistry(PatternType.class), "No registry present for Pattern Type. This is a bug.");
    /**
     * 服务器生物群系。
     *
     * @see Biome
     */
    Registry<Biome> BIOME = Objects.requireNonNull(Bukkit.getRegistry(Biome.class), "No registry present for Biome. This is a bug.");
    /**
     * 服务器方块类型。
     *
     * @see BlockType
     * @apiNote BlockType 尚未准备好供公开使用。
     */
    @ApiStatus.Internal
    Registry<BlockType> BLOCK = Objects.requireNonNull(Bukkit.getRegistry(BlockType.class), "No registry present for BlockType. This is a bug.");
    /**
     * 自定义 Boss 血条。
     *
     * @see Bukkit#getBossBar(org.bukkit.NamespacedKey)
     * @see Bukkit#getBossBars()
     * @deprecated BossBar 没有真正的服务端注册表。
     */
    @Deprecated(since = "1.21.4")
    Registry<KeyedBossBar> BOSS_BARS = new Registry<KeyedBossBar>() {

        @Nullable
        @Override
        public KeyedBossBar get(@NotNull NamespacedKey key) {
            return Bukkit.getBossBar(key);
        }

        @NotNull
        @Override
        public KeyedBossBar getOrThrow(@NotNull NamespacedKey key) {
            KeyedBossBar keyedBossBar = get(key);

            Preconditions.checkArgument(keyedBossBar != null, "No KeyedBossBar registry entry found for key %s.", key);

            return keyedBossBar;
        }

        @NotNull
        @Override
        public Stream<KeyedBossBar> stream() {
            return StreamSupport.stream(spliterator(), false);
        }

        @NotNull
        @Override
        public Iterator<KeyedBossBar> iterator() {
            return Bukkit.getBossBars();
        }
    };
    /**
     * 服务器猫品种。
     *
     * @see Cat.Type
     */
    Registry<Cat.Type> CAT_VARIANT = Objects.requireNonNull(Bukkit.getRegistry(Cat.Type.class), "No registry present for Cat Type. This is a bug.");
    /**
     * 服务器猪变种。
     *
     * @see Pig.Variant
     */
    Registry<Pig.Variant> PIG_VARIANT = Objects.requireNonNull(Bukkit.getRegistry(Pig.Variant.class), "No registry present for Pig Variant. This is a bug.");
    /**
     * 服务器牛变种。
     *
     * @see Cow.Variant
     */
    Registry<Cow.Variant> COW_VARIANT = Objects.requireNonNull(Bukkit.getRegistry(Cow.Variant.class), "No registry present for Cow Variant. This is a bug.");
    /**
     * 服务器鸡变种。
     *
     * @see Chicken.Variant
     */
    Registry<Chicken.Variant> CHICKEN_VARIANT = Objects.requireNonNull(Bukkit.getRegistry(Chicken.Variant.class), "No registry present for Chicken Variant. This is a bug.");
    /**
     * 服务器僵尸鹦鹉螺变种。
     *
     * @see ZombieNautilus.Variant
     */
    Registry<ZombieNautilus.Variant> ZOMBIE_NAUTILUS_VARIANT = Objects.requireNonNull(Bukkit.getRegistry(ZombieNautilus.Variant.class), "No registry present for ZombieNautilus Variant. This is a bug.");
    /**
     * 服务器附魔。
     *
     * @see Enchantment
     */
    Registry<Enchantment> ENCHANTMENT = Objects.requireNonNull(Bukkit.getRegistry(Enchantment.class), "No registry present for Enchantment. This is a bug.");
    /**
     * 服务器实体类型。
     *
     * @see EntityType
     */
    Registry<EntityType> ENTITY_TYPE = new SimpleRegistry<>(EntityType.class, (entity) -> entity != EntityType.UNKNOWN);
    /**
     * 服务器乐器。
     *
     * @see MusicInstrument
     */
    Registry<MusicInstrument> INSTRUMENT = Objects.requireNonNull(Bukkit.getRegistry(MusicInstrument.class), "No registry present for MusicInstrument. This is a bug.");
    /**
     * 服务器物品类型。
     *
     * @see ItemType
     * @apiNote ItemType 尚未准备好供公开使用。
     */
    @ApiStatus.Internal
    Registry<ItemType> ITEM = Objects.requireNonNull(Bukkit.getRegistry(ItemType.class), "No registry present for ItemType. This is a bug.");
    /**
     * 默认服务器战利品表。
     *
     * @see LootTables
     * @deprecated LootTables（不要与 {@link LootTable} 类混淆）没有真正的服务端注册表。
     */
    @Deprecated(since = "1.21.4")
    Registry<LootTables> LOOT_TABLES = new SimpleRegistry<>(LootTables.class);
    /**
     * 服务器材质。
     *
     * @see Material
     */
    Registry<Material> MATERIAL = new SimpleRegistry<>(Material.class, (mat) -> !mat.isLegacy());
    /**
     * 服务器菜单。
     *
     * @see MenuType
     */
    @ApiStatus.Experimental
    Registry<MenuType> MENU = Objects.requireNonNull(Bukkit.getRegistry(MenuType.class), "No registry present for MenuType. This is a bug.");
    /**
     * 服务器药水效果。
     *
     * @see PotionEffectType
     */
    Registry<PotionEffectType> EFFECT = Objects.requireNonNull(Bukkit.getRegistry(PotionEffectType.class), "No registry present for PotionEffectType. This is a bug.");
    /**
     * 服务器粒子。
     *
     * @see Particle
     */
    Registry<Particle> PARTICLE_TYPE = new SimpleRegistry<>(Particle.class, (par) -> par.register);
    /**
     * 服务器药水。
     *
     * @see PotionType
     */
    Registry<PotionType> POTION = new SimpleRegistry<>(PotionType.class);
    /**
     * 服务器统计。
     *
     * @see Statistic
     */
    Registry<Statistic> STATISTIC = new SimpleRegistry<>(Statistic.class);
    /**
     * 服务器结构。
     *
     * @see Structure
     */
    Registry<Structure> STRUCTURE = Objects.requireNonNull(Bukkit.getRegistry(Structure.class), "No registry present for Structure. This is a bug.");
    /**
     * 服务器结构类型。
     *
     * @see StructureType
     */
    Registry<StructureType> STRUCTURE_TYPE = Objects.requireNonNull(Bukkit.getRegistry(StructureType.class), "No registry present for StructureType. This is a bug.");
    /**
     * 声音键。
     *
     * @see Sound
     */
    Registry<Sound> SOUNDS = Objects.requireNonNull(Bukkit.getRegistry(Sound.class), "No registry present for Sound. This is a bug.");
    /**
     * 装饰材料。
     *
     * @see TrimMaterial
     */
    @ApiStatus.Experimental
    Registry<TrimMaterial> TRIM_MATERIAL = Objects.requireNonNull(Bukkit.getRegistry(TrimMaterial.class), "No registry present for TrimMaterial. This is a bug.");
    /**
     * 装饰图案。
     *
     * @see TrimPattern
     */
    @ApiStatus.Experimental
    Registry<TrimPattern> TRIM_PATTERN = Objects.requireNonNull(Bukkit.getRegistry(TrimPattern.class), "No registry present for TrimPattern. This is a bug.");
    /**
     * 伤害类型。
     *
     * @see DamageType
     */
    @ApiStatus.Experimental
    Registry<DamageType> DAMAGE_TYPE = Objects.requireNonNull(Bukkit.getRegistry(DamageType.class), "No registry present for DamageType. This is a bug.");
    /**
     * 唱片机歌曲。
     *
     * @see JukeboxSong
     */
    @ApiStatus.Experimental
    Registry<JukeboxSong> JUKEBOX_SONG = Objects.requireNonNull(Bukkit.getRegistry(JukeboxSong.class), "No registry present for JukeboxSong. This is a bug.");
    /**
     * 村民职业。
     *
     * @see Villager.Profession
     */
    Registry<Villager.Profession> VILLAGER_PROFESSION = Objects.requireNonNull(Bukkit.getRegistry(Villager.Profession.class), "No registry present for Villager Profession. This is a bug.");
    /**
     * 村民类型。
     *
     * @see Villager.Type
     */
    Registry<Villager.Type> VILLAGER_TYPE = Objects.requireNonNull(Bukkit.getRegistry(Villager.Type.class), "No registry present for Villager Type. This is a bug.");
    /**
     * 游戏规则。
     *
     * @see GameRule
     */
    Registry<GameRule> GAME_RULE = Objects.requireNonNull(Bukkit.getRegistry(GameRule.class), "No registry present for Game Rule. This is a bug.");
    /**
     * 记忆键。
     *
     * @see MemoryKey
     */
    Registry<MemoryKey> MEMORY_MODULE_TYPE = new Registry<MemoryKey>() {

        @NotNull
        @Override
        public Iterator iterator() {
            return MemoryKey.values().iterator();
        }

        @Nullable
        @Override
        public MemoryKey get(@NotNull NamespacedKey key) {
            return MemoryKey.getByKey(key);
        }

        @NotNull
        @Override
        public MemoryKey getOrThrow(@NotNull NamespacedKey key) {
            MemoryKey memoryKey = get(key);

            Preconditions.checkArgument(memoryKey != null, "No MemoryKey registry entry found for key %s.", key);

            return memoryKey;
        }

        @NotNull
        @Override
        public Stream<MemoryKey> stream() {
            return StreamSupport.stream(spliterator(), false);
        }
    };
    /**
     * 服务器流体。
     *
     * @see Fluid
     */
    Registry<Fluid> FLUID = Objects.requireNonNull(Bukkit.getRegistry(Fluid.class), "No registry present for Fluid. This is a bug.");
    /**
     * 青蛙变种。
     *
     * @see Frog.Variant
     */
    Registry<Frog.Variant> FROG_VARIANT = Objects.requireNonNull(Bukkit.getRegistry(Frog.Variant.class), "No registry present for Frog Variant. This is a bug.");
    /**
     * 狼变种。
     *
     * @see Wolf.Variant
     */
    Registry<Wolf.Variant> WOLF_VARIANT = Objects.requireNonNull(Bukkit.getRegistry(Wolf.Variant.class), "No registry present for Wolf Variant. This is a bug.");
    /**
     * 地图光标类型。
     *
     * @see MapCursor.Type
     */
    Registry<MapCursor.Type> MAP_DECORATION_TYPE = Objects.requireNonNull(Bukkit.getRegistry(MapCursor.Type.class), "No registry present for MapCursor Type. This is a bug.");
    /**
     * 游戏事件。
     *
     * @see GameEvent
     */
    Registry<GameEvent> GAME_EVENT = Objects.requireNonNull(Bukkit.getRegistry(GameEvent.class), "No registry present for GameEvent. This is a bug.");
    /**
     * 通过键获取对象。
     *
     * @param key 非空键。
     * @return 对象，如果不存在则返回 null。
     *
     * 原文：
     * Get the object by its key.
     *
     * @param key non-null key
     * @return item or null if does not exist
     */
    @Nullable
    T get(@NotNull NamespacedKey key);

    /**
     * 通过键获取对象。
     *
     * 如果没有具有给定键的对象，将抛出异常。
     *
     * @param key 用于获取对象的键。
     * @return 具有给定键的对象。
     * @throws IllegalArgumentException 如果没有具有给定键的对象。
     *
     * 原文：
     * Get the object by its key.
     *
     * If there is no object with the given key, an exception will be thrown.
     *
     * @param key to get the object from
     * @return object with the given key
     * @throws IllegalArgumentException if there is no object with the given key
     */
    @NotNull
    T getOrThrow(@NotNull NamespacedKey key);

    /**
     * 返回一个包含所有已注册到注册表中的注册项的新流。
     *
     * @return 所有注册项的流。
     *
     * 原文：
     * Returns a new stream, which contains all registry items, which are registered to the registry.
     *
     * @return a stream of all registry items
     */
    @NotNull
    Stream<T> stream();

    /**
     * 尝试将注册对象与给定键匹配。
     * <p>
     * 将尝试根据提供的输入找到合理的匹配，可能通过未指定的方式进行。
     *
     * @param input 非空输入。
     * @return 注册对象，如果不存在则返回 null。
     *
     * 原文：
     * Attempts to match the registered object with the given key.
     * <p>
     * This will attempt to find a reasonable match based on the provided input
     * and may do so through unspecified means.
     *
     * @param input non-null input
     * @return registered object or null if does not exist
     */
    @Nullable
    default T match(@NotNull String input) {
        Preconditions.checkArgument(input != null, "input must not be null");

        String filtered = input.toLowerCase(Locale.ROOT).replaceAll("\\s+", "_");
        NamespacedKey namespacedKey = NamespacedKey.fromString(filtered);
        return (namespacedKey != null) ? get(namespacedKey) : null;
    }

    static final class SimpleRegistry<T extends Enum<T> & Keyed> implements Registry<T> {

        private final Class<T> type;
        private final Map<NamespacedKey, T> map;

        protected SimpleRegistry(@NotNull Class<T> type) {
            this(type, Predicates.<T>alwaysTrue());
        }

        protected SimpleRegistry(@NotNull Class<T> type, @NotNull Predicate<T> predicate) {
            ImmutableMap.Builder<NamespacedKey, T> builder = ImmutableMap.builder();

            for (T entry : type.getEnumConstants()) {
                if (predicate.test(entry)) {
                    builder.put(entry.getKey(), entry);
                }
            }

            map = builder.build();
            this.type = type;
        }

        @Nullable
        @Override
        public T get(@NotNull NamespacedKey key) {
            return map.get(key);
        }

        @NotNull
        @Override
        public T getOrThrow(@NotNull NamespacedKey key) {
            T object = get(key);

            Preconditions.checkArgument(object != null, "No %s registry entry found for key %s.", type, key);

            return object;
        }

        @NotNull
        @Override
        public Stream<T> stream() {
            return StreamSupport.stream(spliterator(), false);
        }

        @NotNull
        @Override
        public Iterator<T> iterator() {
            return map.values().iterator();
        }

        @ApiStatus.Internal
        @Deprecated(since = "1.20.6", forRemoval = true)
        public Class<T> getType() {
            return this.type;
        }
    }
}