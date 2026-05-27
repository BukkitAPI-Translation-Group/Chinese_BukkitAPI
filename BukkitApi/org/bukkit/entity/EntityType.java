package org.bukkit.entity;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.Keyed;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.Translatable;
import org.bukkit.World;
import org.bukkit.entity.boat.AcaciaBoat;
import org.bukkit.entity.boat.AcaciaChestBoat;
import org.bukkit.entity.boat.BambooChestRaft;
import org.bukkit.entity.boat.BambooRaft;
import org.bukkit.entity.boat.BirchBoat;
import org.bukkit.entity.boat.BirchChestBoat;
import org.bukkit.entity.boat.CherryBoat;
import org.bukkit.entity.boat.CherryChestBoat;
import org.bukkit.entity.boat.DarkOakBoat;
import org.bukkit.entity.boat.DarkOakChestBoat;
import org.bukkit.entity.boat.JungleBoat;
import org.bukkit.entity.boat.JungleChestBoat;
import org.bukkit.entity.boat.MangroveBoat;
import org.bukkit.entity.boat.MangroveChestBoat;
import org.bukkit.entity.boat.OakBoat;
import org.bukkit.entity.boat.OakChestBoat;
import org.bukkit.entity.boat.PaleOakBoat;
import org.bukkit.entity.boat.PaleOakChestBoat;
import org.bukkit.entity.boat.SpruceBoat;
import org.bukkit.entity.boat.SpruceChestBoat;
import org.bukkit.entity.minecart.CommandMinecart;
import org.bukkit.entity.minecart.ExplosiveMinecart;
import org.bukkit.entity.minecart.HopperMinecart;
import org.bukkit.entity.minecart.PoweredMinecart;
import org.bukkit.entity.minecart.RideableMinecart;
import org.bukkit.entity.minecart.SpawnerMinecart;
import org.bukkit.entity.minecart.StorageMinecart;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.registry.RegistryAware;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum EntityType implements Keyed, Translatable, RegistryAware {

    // These strings MUST match the strings in nms.EntityTypes and are case sensitive.
    /**
     * 掉落在地面上的物品.
     * <p>
     * 使用 {@link World#dropItem(Location, ItemStack)} 或 {@link
     * World#dropItemNaturally(Location, ItemStack)} 生成.
     */
    ITEM("item", Item.class, 1),
    /**
     * 经验球.
     */
    EXPERIENCE_ORB("experience_orb", ExperienceOrb.class, 2),
    /**
     * @see AreaEffectCloud
     */
    AREA_EFFECT_CLOUD("area_effect_cloud", AreaEffectCloud.class, 3),
    /**
     * @see ElderGuardian
     */
    ELDER_GUARDIAN("elder_guardian", ElderGuardian.class, 4),
    /**
     * @see WitherSkeleton
     */
    WITHER_SKELETON("wither_skeleton", WitherSkeleton.class, 5),
    /**
     * @see Stray
     */
    STRAY("stray", Stray.class, 6),
    /**
     * 飞行中的鸡蛋.
     */
    EGG("egg", Egg.class, 7),
    /**
     * 拴在栅栏柱上的拴绳.
     */
    LEASH_KNOT("leash_knot", LeashHitch.class, 8),
    /**
     * 墙上的画.
     */
    PAINTING("painting", Painting.class, 9),
    /**
     * 箭矢投射物, 可能会插在地面上.
     */
    ARROW("arrow", Arrow.class, 10),
    /**
     * 飞行中的雪球.
     */
    SNOWBALL("snowball", Snowball.class, 11),
    /**
     * 飞行中的大火球, 例如由恶魂投掷.
     */
    FIREBALL("fireball", LargeFireball.class, 12),
    /**
     * 飞行中的小火球, 例如由烈焰人或玩家投掷.
     */
    SMALL_FIREBALL("small_fireball", SmallFireball.class, 13),
    /**
     * 飞行中的末影珍珠.
     */
    ENDER_PEARL("ender_pearl", EnderPearl.class, 14),
    /**
     * 末影之眼信号.
     */
    EYE_OF_ENDER("eye_of_ender", EnderSignal.class, 15),
    /**
     * 飞行中的喷溅药水.
     */
    SPLASH_POTION("splash_potion", SplashPotion.class, 16),
    /**
     * 飞行中的滞留药水.
     */
    LINGERING_POTION("lingering_potion", LingeringPotion.class, -1),
    /**
     * 飞行中的经验瓶.
     */
    EXPERIENCE_BOTTLE("experience_bottle", ThrownExpBottle.class, 17),
    /**
     * 墙上的物品展示框.
     */
    ITEM_FRAME("item_frame", ItemFrame.class, 18),
    /**
     * 飞行中的凋灵骷髅头颅投射物.
     */
    WITHER_SKULL("wither_skull", WitherSkull.class, 19),
    /**
     * 即将爆炸的已点燃TNT.
     */
    TNT("tnt", TNTPrimed.class, 20),
    /**
     * 正在下落或即将下落的方块.
     */
    FALLING_BLOCK("falling_block", FallingBlock.class, 21),
    /**
     * 烟花火箭发射后的内部表示.
     */
    FIREWORK_ROCKET("firework_rocket", Firework.class, 22),
    /**
     * @see Husk
     */
    HUSK("husk", Husk.class, 23),
    /**
     * 类似 {@link #ARROW}, 但会对所有队友施加 {@link PotionEffectType#GLOWING} 效果.
     */
    SPECTRAL_ARROW("spectral_arrow", SpectralArrow.class, 24),
    /**
     * 由 {@link #SHULKER} 发射的子弹.
     */
    SHULKER_BULLET("shulker_bullet", ShulkerBullet.class, 25),
    /**
     * 类似 {@link #FIREBALL}, 但附带额外效果.
     */
    DRAGON_FIREBALL("dragon_fireball", DragonFireball.class, 26),
    /**
     * @see ZombieVillager
     */
    ZOMBIE_VILLAGER("zombie_villager", ZombieVillager.class, 27),
    /**
     * @see SkeletonHorse
     */
    SKELETON_HORSE("skeleton_horse", SkeletonHorse.class, 28),
    /**
     * @see ZombieHorse
     */
    ZOMBIE_HORSE("zombie_horse", ZombieHorse.class, 29),
    /**
     * 用于放置武器/盔甲的机械实体, 带有物品栏.
     */
    ARMOR_STAND("armor_stand", ArmorStand.class, 30),
    /**
     * @see Donkey
     */
    DONKEY("donkey", Donkey.class, 31),
    /**
     * @see Mule
     */
    MULE("mule", Mule.class, 32),
    /**
     * @see EvokerFangs
     */
    EVOKER_FANGS("evoker_fangs", EvokerFangs.class, 33),
    /**
     * @see Evoker
     */
    EVOKER("evoker", Evoker.class, 34),
    /**
     * @see Vex
     */
    VEX("vex", Vex.class, 35),
    /**
     * @see Vindicator
     */
    VINDICATOR("vindicator", Vindicator.class, 36),
    /**
     * @see Illusioner
     */
    ILLUSIONER("illusioner", Illusioner.class, 37),
    /**
     * @see CommandMinecart
     */
    COMMAND_BLOCK_MINECART("command_block_minecart", CommandMinecart.class, 40),
    /**
     * @see RideableMinecart
     */
    MINECART("minecart", RideableMinecart.class, 42),
    /**
     * @see StorageMinecart
     */
    CHEST_MINECART("chest_minecart", StorageMinecart.class, 43),
    /**
     * @see PoweredMinecart
     */
    FURNACE_MINECART("furnace_minecart", PoweredMinecart.class, 44),
    /**
     * @see ExplosiveMinecart
     */
    TNT_MINECART("tnt_minecart", ExplosiveMinecart.class, 45),
    /**
     * @see HopperMinecart
     */
    HOPPER_MINECART("hopper_minecart", HopperMinecart.class, 46),
    /**
     * @see SpawnerMinecart
     */
    SPAWNER_MINECART("spawner_minecart", SpawnerMinecart.class, 47),
    CREEPER("creeper", Creeper.class, 50),
    SKELETON("skeleton", Skeleton.class, 51),
    SPIDER("spider", Spider.class, 52),
    GIANT("giant", Giant.class, 53),
    ZOMBIE("zombie", Zombie.class, 54),
    SLIME("slime", Slime.class, 55),
    GHAST("ghast", Ghast.class, 56),
    ZOMBIFIED_PIGLIN("zombified_piglin", PigZombie.class, 57),
    ENDERMAN("enderman", Enderman.class, 58),
    CAVE_SPIDER("cave_spider", CaveSpider.class, 59),
    SILVERFISH("silverfish", Silverfish.class, 60),
    BLAZE("blaze", Blaze.class, 61),
    MAGMA_CUBE("magma_cube", MagmaCube.class, 62),
    ENDER_DRAGON("ender_dragon", EnderDragon.class, 63),
    WITHER("wither", Wither.class, 64),
    BAT("bat", Bat.class, 65),
    WITCH("witch", Witch.class, 66),
    ENDERMITE("endermite", Endermite.class, 67),
    GUARDIAN("guardian", Guardian.class, 68),
    SHULKER("shulker", Shulker.class, 69),
    PIG("pig", Pig.class, 90),
    SHEEP("sheep", Sheep.class, 91),
    COW("cow", Cow.class, 92),
    CHICKEN("chicken", Chicken.class, 93),
    SQUID("squid", Squid.class, 94),
    WOLF("wolf", Wolf.class, 95),
    MOOSHROOM("mooshroom", MushroomCow.class, 96),
    SNOW_GOLEM("snow_golem", Snowman.class, 97),
    OCELOT("ocelot", Ocelot.class, 98),
    IRON_GOLEM("iron_golem", IronGolem.class, 99),
    HORSE("horse", Horse.class, 100),
    RABBIT("rabbit", Rabbit.class, 101),
    POLAR_BEAR("polar_bear", PolarBear.class, 102),
    LLAMA("llama", Llama.class, 103),
    LLAMA_SPIT("llama_spit", LlamaSpit.class, 104),
    PARROT("parrot", Parrot.class, 105),
    VILLAGER("villager", Villager.class, 120),
    END_CRYSTAL("end_crystal", EnderCrystal.class, 200),
    TURTLE("turtle", Turtle.class, -1),
    PHANTOM("phantom", Phantom.class, -1),
    TRIDENT("trident", Trident.class, -1),
    COD("cod", Cod.class, -1),
    SALMON("salmon", Salmon.class, -1),
    PUFFERFISH("pufferfish", PufferFish.class, -1),
    TROPICAL_FISH("tropical_fish", TropicalFish.class, -1),
    DROWNED("drowned", Drowned.class, -1),
    DOLPHIN("dolphin", Dolphin.class, -1),
    CAT("cat", Cat.class, -1),
    PANDA("panda", Panda.class, -1),
    PILLAGER("pillager", Pillager.class, -1),
    RAVAGER("ravager", Ravager.class, -1),
    TRADER_LLAMA("trader_llama", TraderLlama.class, -1),
    WANDERING_TRADER("wandering_trader", WanderingTrader.class, -1),
    FOX("fox", Fox.class, -1),
    BEE("bee", Bee.class, -1),
    HOGLIN("hoglin", Hoglin.class, -1),
    PIGLIN("piglin", Piglin.class, -1),
    STRIDER("strider", Strider.class, -1),
    ZOGLIN("zoglin", Zoglin.class, -1),
    PIGLIN_BRUTE("piglin_brute", PiglinBrute.class, -1),
    AXOLOTL("axolotl", Axolotl.class, -1),
    GLOW_ITEM_FRAME("glow_item_frame", GlowItemFrame.class, -1),
    GLOW_SQUID("glow_squid", GlowSquid.class, -1),
    GOAT("goat", Goat.class, -1),
    MARKER("marker", Marker.class, -1),
    ALLAY("allay", Allay.class, -1),
    FROG("frog", Frog.class, -1),
    TADPOLE("tadpole", Tadpole.class, -1),
    WARDEN("warden", Warden.class, -1),
    CAMEL("camel", Camel.class, -1),
    BLOCK_DISPLAY("block_display", BlockDisplay.class, -1),
    INTERACTION("interaction", Interaction.class, -1),
    ITEM_DISPLAY("item_display", ItemDisplay.class, -1),
    SNIFFER("sniffer", Sniffer.class, -1),
    TEXT_DISPLAY("text_display", TextDisplay.class, -1),
    BREEZE("breeze", Breeze.class, -1),
    WIND_CHARGE("wind_charge", WindCharge.class, -1),
    BREEZE_WIND_CHARGE("breeze_wind_charge", BreezeWindCharge.class, -1),
    ARMADILLO("armadillo", Armadillo.class, -1),
    BOGGED("bogged", Bogged.class, -1),
    OMINOUS_ITEM_SPAWNER("ominous_item_spawner", OminousItemSpawner.class, -1),
    ACACIA_BOAT("acacia_boat", AcaciaBoat.class, -1),
    ACACIA_CHEST_BOAT("acacia_chest_boat", AcaciaChestBoat.class, -1),
    BAMBOO_RAFT("bamboo_raft", BambooRaft.class, -1),
    BAMBOO_CHEST_RAFT("bamboo_chest_raft", BambooChestRaft.class, -1),
    BIRCH_BOAT("birch_boat", BirchBoat.class, -1),
    BIRCH_CHEST_BOAT("birch_chest_boat", BirchChestBoat.class, -1),
    CHERRY_BOAT("cherry_boat", CherryBoat.class, -1),
    CHERRY_CHEST_BOAT("cherry_chest_boat", CherryChestBoat.class, -1),
    DARK_OAK_BOAT("dark_oak_boat", DarkOakBoat.class, -1),
    DARK_OAK_CHEST_BOAT("dark_oak_chest_boat", DarkOakChestBoat.class, -1),
    JUNGLE_BOAT("jungle_boat", JungleBoat.class, -1),
    JUNGLE_CHEST_BOAT("jungle_chest_boat", JungleChestBoat.class, -1),
    MANGROVE_BOAT("mangrove_boat", MangroveBoat.class, -1),
    MANGROVE_CHEST_BOAT("mangrove_chest_boat", MangroveChestBoat.class, -1),
    OAK_BOAT("oak_boat", OakBoat.class, -1),
    OAK_CHEST_BOAT("oak_chest_boat", OakChestBoat.class, -1),
    PALE_OAK_BOAT("pale_oak_boat", PaleOakBoat.class, -1),
    PALE_OAK_CHEST_BOAT("pale_oak_chest_boat", PaleOakChestBoat.class, -1),
    SPRUCE_BOAT("spruce_boat", SpruceBoat.class, -1),
    SPRUCE_CHEST_BOAT("spruce_chest_boat", SpruceChestBoat.class, -1),
    CREAKING("creaking", Creaking.class, -1),
    HAPPY_GHAST("happy_ghast", HappyGhast.class, -1),
    COPPER_GOLEM("copper_golem", CopperGolem.class, -1),
    MANNEQUIN("mannequin", Mannequin.class, -1),
    CAMEL_HUSK("camel_husk", CamelHusk.class, -1),
    NAUTILUS("nautilus", Nautilus.class, -1),
    PARCHED("parched", Parched.class, -1),
    ZOMBIE_NAUTILUS("zombie_nautilus", ZombieNautilus.class, -1),
    /**
     * 钓鱼线和浮漂.
     */
    FISHING_BOBBER("fishing_bobber", FishHook.class, -1, false),
    /**
     * 闪电.
     * <p>
     * 使用 {@link World#strikeLightning(Location)} 生成.
     */
    LIGHTNING_BOLT("lightning_bolt", LightningStrike.class, -1),
    PLAYER("player", Player.class, -1, false),
    /**
     * 没有实体类的未知实体.
     */
    UNKNOWN(null, null, -1, false);

    private final String name;
    private final Class<? extends Entity> clazz;
    private final short typeId;
    private final boolean independent, living;
    private final NamespacedKey key;

    private static final Map<String, EntityType> NAME_MAP = new HashMap<String, EntityType>();
    private static final Map<Short, EntityType> ID_MAP = new HashMap<Short, EntityType>();

    static {
        for (EntityType type : values()) {
            if (type.name != null) {
                NAME_MAP.put(type.name.toLowerCase(Locale.ROOT), type);
            }
            if (type.typeId > 0) {
                ID_MAP.put(type.typeId, type);
            }
        }
    }

    private EntityType(/*@Nullable*/ String name, /*@Nullable*/ Class<? extends Entity> clazz, int typeId) {
        this(name, clazz, typeId, true);
    }

    private EntityType(/*@Nullable*/ String name, /*@Nullable*/ Class<? extends Entity> clazz, int typeId, boolean independent) {
        this.name = name;
        this.clazz = clazz;
        this.typeId = (short) typeId;
        this.independent = independent;
        this.living = clazz != null && LivingEntity.class.isAssignableFrom(clazz);
        this.key = (name == null) ? null : NamespacedKey.minecraft(name);
    }

    /**
     * 获取实体种类名.
     * <p>
     * 原文:Gets the entity type name.
     *
     * @return the entity type's name
     * @deprecated 不安全的参数
     */
    @Deprecated(since = "1.6.2")
    @Nullable
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     *
     * @see #getKeyOrThrow()
     * @see #isRegistered()
     * @deprecated 键可能并不总是存在, 请改用 {@link #getKeyOrThrow()}.
     */
    @NotNull
    @Override
    @Deprecated(since = "1.21.4")
    public NamespacedKey getKey() {
        return getKeyOrThrow();
    }

    @Nullable
    public Class<? extends Entity> getEntityClass() {
        return clazz;
    }

    /**
     * 获取实体种类id.
     * <p>
     * 原文:Gets the entity type id.
     *
     * @return 种类id
     * @deprecated 不安全的参数
     */
    @Deprecated(since = "1.6.2")
    public short getTypeId() {
        return typeId;
    }

    /**
     * 以给定名称获取对应实体种类.
     * <p>
     * 原文:Gets an entity type from its name.
     *
     * @param name 实体种类名
     * @return 匹配的实体种类, 找不到为null
     * @deprecated 不安全的参数
     */
    @Deprecated(since = "1.6.2")
    @Contract("null -> null")
    @Nullable
    public static EntityType fromName(@Nullable String name) {
        if (name == null) {
            return null;
        }
        return NAME_MAP.get(name.toLowerCase(Locale.ROOT));
    }

    /**
     * 以给定id获取实体种类.
     * <p>
     * 原文:Gets an entity from its id.
     *
     * @param id 实体种类id
     * @return 匹配的实体种类或null
     * @deprecated 不安全的参数
     */
    @Deprecated(since = "1.6.2")
    @Nullable
    public static EntityType fromId(int id) {
        if (id > Short.MAX_VALUE) {
            return null;
        }
        return ID_MAP.get((short) id);
    }

    /**
     * 某些实体无法使用 {@link World#spawnEntity(Location, EntityType)} 或 {@link
     * World#spawn(Location, Class)} 生成, 通常是因为它们需要额外信息才能生成.
     * <p>
     * 原文：Some entities cannot be spawned using {@link
     * World#spawnEntity(Location, EntityType)} or {@link
     * World#spawn(Location, Class)}, usually because they require additional
     * information in order to spawn.
     *
     * @return 如果该实体种类无法生成则返回 false
     */
    public boolean isSpawnable() {
        return independent;
    }

    public boolean isAlive() {
        return living;
    }

    @Override
    @NotNull
    public String getTranslationKey() {
        return Bukkit.getUnsafe().getTranslationKey(this);
    }

    /**
     * 获取此实体种类是否在指定世界中通过特性启用.
     * <p>
     * 原文：Gets if this EntityType is enabled by feature in a world.
     *
     * @param world 要检查的世界
     * @return 如果此实体种类可用于在该世界中生成实体则返回 true
     */
    public boolean isEnabledByFeature(@NotNull World world) {
        return Bukkit.getDataPackManager().isEnabledByFeature(this, world);
    }

    @NotNull
    @Override
    public NamespacedKey getKeyOrThrow() {
        Preconditions.checkState(isRegistered(), "Cannot get key of this registry item, because it is not registered. Use #isRegistered() before calling this method.");
        return this.key;
    }

    @Nullable
    @Override
    public NamespacedKey getKeyOrNull() {
        return this.key;
    }

    @Override
    public boolean isRegistered() {
        return this != UNKNOWN;
    }
}
