package org.bukkit;

import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import org.bukkit.registry.RegistryAware;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表 Mojang 通用游戏事件.
 * <p>
 * 译注:这些事件非 Bukkit 框架内提供的事件, 而是 Mojang 在原游戏引入的事件,
 * 目前已知原版游戏用于<a href="https://zh.minecraft.wiki/w/%E5%B9%BD%E5%8C%BF%E6%84%9F%E6%B5%8B%E4%BD%93">幽匿感测体</a>中.
 * <p>
 * 不过 Bukkit 框架提供了一个新的事件: {@link org.bukkit.event.world.GenericGameEvent}, 使得监听 Mojang 游戏事件成为可能.
 * <p>
 * 原文:Represents a generic Mojang game event.
 *
 * @since 1.17
 */
public abstract class GameEvent implements Keyed, RegistryAware {

    public static final GameEvent BLOCK_ACTIVATE = getEvent("block_activate");
    public static final GameEvent BLOCK_ATTACH = getEvent("block_attach");
    public static final GameEvent BLOCK_CHANGE = getEvent("block_change");
    public static final GameEvent BLOCK_CLOSE = getEvent("block_close");
    public static final GameEvent BLOCK_DEACTIVATE = getEvent("block_deactivate");
    public static final GameEvent BLOCK_DESTROY = getEvent("block_destroy");
    public static final GameEvent BLOCK_DETACH = getEvent("block_detach");
    public static final GameEvent BLOCK_OPEN = getEvent("block_open");
    public static final GameEvent BLOCK_PLACE = getEvent("block_place");
    @Deprecated(since = "1.19")
    public static final GameEvent BLOCK_PRESS = getEvent("block_activate");
    @Deprecated(since = "1.19")
    public static final GameEvent BLOCK_SWITCH = getEvent("block_activate");
    @Deprecated(since = "1.19")
    public static final GameEvent BLOCK_UNPRESS = getEvent("block_deactivate");
    @Deprecated(since = "1.19")
    public static final GameEvent BLOCK_UNSWITCH = getEvent("block_deactivate");
    public static final GameEvent CONTAINER_CLOSE = getEvent("container_close");
    public static final GameEvent CONTAINER_OPEN = getEvent("container_open");
    @Deprecated(since = "1.20")
    public static final GameEvent DISPENSE_FAIL = getEvent("block_activate");
    public static final GameEvent DRINK = getEvent("drink");
    @Deprecated(since = "1.19")
    public static final GameEvent DRINKING_FINISH = getEvent("drink");
    public static final GameEvent EAT = getEvent("eat");
    @Deprecated(since = "1.19")
    public static final GameEvent ELYTRA_FREE_FALL = getEvent("elytra_glide");
    public static final GameEvent ELYTRA_GLIDE = getEvent("elytra_glide");
    public static final GameEvent ENTITY_DAMAGE = getEvent("entity_damage");
    @Deprecated(since = "1.19")
    public static final GameEvent ENTITY_DAMAGED = getEvent("entity_damage");
    public static final GameEvent ENTITY_DIE = getEvent("entity_die");
    public static final GameEvent ENTITY_DISMOUNT = getEvent("entity_dismount");
    @Deprecated(since = "1.19")
    public static final GameEvent ENTITY_DYING = getEvent("entity_die");
    public static final GameEvent ENTITY_INTERACT = getEvent("entity_interact");
    public static final GameEvent ENTITY_MOUNT = getEvent("entity_mount");
    @Deprecated(since = "1.19")
    public static final GameEvent ENTITY_KILLED = getEvent("entity_die");
    public static final GameEvent ENTITY_PLACE = getEvent("entity_place");
    public static final GameEvent ENTITY_ACTION = getEvent("entity_action");
    @Deprecated(since = "1.20.2")
    public static final GameEvent ENTITY_ROAR = getEvent("entity_action");
    @Deprecated(since = "1.20.2")
    public static final GameEvent ENTITY_SHAKE = getEvent("entity_action");
    public static final GameEvent EQUIP = getEvent("equip");
    public static final GameEvent EXPLODE = getEvent("explode");
    public static final GameEvent FLAP = getEvent("flap");
    public static final GameEvent FLUID_PICKUP = getEvent("fluid_pickup");
    public static final GameEvent FLUID_PLACE = getEvent("fluid_place");
    public static final GameEvent HIT_GROUND = getEvent("hit_ground");
    public static final GameEvent INSTRUMENT_PLAY = getEvent("instrument_play");
    public static final GameEvent ITEM_INTERACT_FINISH = getEvent("item_interact_finish");
    public static final GameEvent ITEM_INTERACT_START = getEvent("item_interact_start");
    public static final GameEvent JUKEBOX_PLAY = getEvent("jukebox_play");
    public static final GameEvent JUKEBOX_STOP_PLAY = getEvent("jukebox_stop_play");
    public static final GameEvent LIGHTNING_STRIKE = getEvent("lightning_strike");
    @Deprecated(since = "1.19")
    public static final GameEvent MOB_INTERACT = getEvent("entity_interact");
    public static final GameEvent NOTE_BLOCK_PLAY = getEvent("note_block_play");
    @Deprecated(since = "1.20")
    public static final GameEvent PISTON_CONTRACT = getEvent("block_deactivate");
    @Deprecated(since = "1.20")
    public static final GameEvent PISTON_EXTEND = getEvent("block_activate");
    public static final GameEvent PRIME_FUSE = getEvent("prime_fuse");
    public static final GameEvent PROJECTILE_LAND = getEvent("projectile_land");
    public static final GameEvent PROJECTILE_SHOOT = getEvent("projectile_shoot");
    @Deprecated(since = "1.19")
    public static final GameEvent RAVAGER_ROAR = getEvent("entity_action");
    @Deprecated(since = "1.19")
    public static final GameEvent RING_BELL = getEvent("block_change");
    public static final GameEvent SCULK_SENSOR_TENDRILS_CLICKING = getEvent("sculk_sensor_tendrils_clicking");
    public static final GameEvent SHEAR = getEvent("shear");
    public static final GameEvent SHRIEK = getEvent("shriek");
    @Deprecated(since = "1.19")
    public static final GameEvent SHULKER_CLOSE = getEvent("container_close");
    @Deprecated(since = "1.19")
    public static final GameEvent SHULKER_OPEN = getEvent("container_open");
    public static final GameEvent SPLASH = getEvent("splash");
    public static final GameEvent STEP = getEvent("step");
    public static final GameEvent SWIM = getEvent("swim");
    public static final GameEvent TELEPORT = getEvent("teleport");
    public static final GameEvent UNEQUIP = getEvent("unequip");
    @Deprecated(since = "1.19")
    public static final GameEvent WOLF_SHAKING = getEvent("entity_action");
    public static final GameEvent RESONATE_1 = getEvent("resonate_1");
    public static final GameEvent RESONATE_2 = getEvent("resonate_2");
    public static final GameEvent RESONATE_3 = getEvent("resonate_3");
    public static final GameEvent RESONATE_4 = getEvent("resonate_4");
    public static final GameEvent RESONATE_5 = getEvent("resonate_5");
    public static final GameEvent RESONATE_6 = getEvent("resonate_6");
    public static final GameEvent RESONATE_7 = getEvent("resonate_7");
    public static final GameEvent RESONATE_8 = getEvent("resonate_8");
    public static final GameEvent RESONATE_9 = getEvent("resonate_9");
    public static final GameEvent RESONATE_10 = getEvent("resonate_10");
    public static final GameEvent RESONATE_11 = getEvent("resonate_11");
    public static final GameEvent RESONATE_12 = getEvent("resonate_12");
    public static final GameEvent RESONATE_13 = getEvent("resonate_13");
    public static final GameEvent RESONATE_14 = getEvent("resonate_14");
    public static final GameEvent RESONATE_15 = getEvent("resonate_15");

    /**
     * {@inheritDoc}
     *
     * @see #getKeyOrThrow()
     * @see #isRegistered()
     * @deprecated A key might not always be present, use {@link #getKeyOrThrow()} instead.
     */
    @NotNull
    @Override
    @Deprecated(since = "1.21.4")
    public abstract NamespacedKey getKey();

    /**
     * 根据指定的{@link NamespacedKey}获取{@link GameEvent 游戏事件}.
     * <p>
     * 原文:Returns a {@link GameEvent} by a {@link NamespacedKey}.
     *
     * @param namespacedKey the key
     * @return 游戏事件, 如果 key 不存在则返回 null
     * @deprecated 请使用 {@link Registry#get(NamespacedKey)}
     */
    @Nullable
    @Deprecated(since = "1.20.1")
    public static GameEvent getByKey(@NotNull NamespacedKey namespacedKey) {
        return Registry.GAME_EVENT.get(namespacedKey);
    }

    /**
     * 返回所有游戏事件的集合.
     * <p>
     * 原文:Returns the set of all GameEvents.
     *
     * @return 游戏事件键的集合
     * @deprecated 请使用 {@link Registry#iterator()}
     */
    @NotNull
    @Deprecated(since = "1.20.1")
    public static Collection<GameEvent> values() {
        return Collections.unmodifiableCollection(Lists.newArrayList(Registry.GAME_EVENT));
    }

    @NotNull
    private static GameEvent getEvent(@NotNull String key) {
        return Registry.GAME_EVENT.getOrThrow(NamespacedKey.minecraft(key));
    }
}
