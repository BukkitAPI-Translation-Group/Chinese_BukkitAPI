package org.bukkit;

import com.google.common.base.Preconditions;
import org.bukkit.block.data.BlockData;
import org.bukkit.inventory.ItemStack;
import org.bukkit.registry.RegistryAware;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum Particle implements Keyed, RegistryAware {
    POOF("poof"),
    EXPLOSION("explosion"),
    EXPLOSION_EMITTER("explosion_emitter"),
    FIREWORK("firework"),
    BUBBLE("bubble"),
    SPLASH("splash"),
    FISHING("fishing"),
    UNDERWATER("underwater"),
    CRIT("crit"),
    ENCHANTED_HIT("enchanted_hit"),
    SMOKE("smoke"),
    LARGE_SMOKE("large_smoke"),
    /**
     * Uses {@link Spell} as DataType
     */
    EFFECT("effect", Spell.class),
    /**
     * Uses {@link Spell} as DataType
     */
    INSTANT_EFFECT("instant_effect", Spell.class),
    /**
     * Uses {@link Color} as DataType
     */
    ENTITY_EFFECT("entity_effect", Color.class),
    WITCH("witch"),
    DRIPPING_WATER("dripping_water"),
    DRIPPING_LAVA("dripping_lava"),
    ANGRY_VILLAGER("angry_villager"),
    HAPPY_VILLAGER("happy_villager"),
    MYCELIUM("mycelium"),
    NOTE("note"),
    PORTAL("portal"),
    ENCHANT("enchant"),
    FLAME("flame"),
    LAVA("lava"),
    CLOUD("cloud"),
    /**
     * Uses {@link Particle.DustOptions} as DataType
     */
    DUST("dust", DustOptions.class),
    ITEM_SNOWBALL("item_snowball"),
    ITEM_SLIME("item_slime"),
    HEART("heart"),
    /**
     * Uses {@link ItemStack} as DataType
     */
    ITEM("item", ItemStack.class),
    /**
     * Uses {@link BlockData} as DataType
     */
    BLOCK("block", BlockData.class),
    RAIN("rain"),
    ELDER_GUARDIAN("elder_guardian"),
    /**
     * Uses {@link Float} as DataType
     */
    DRAGON_BREATH("dragon_breath", Float.class),
    END_ROD("end_rod"),
    DAMAGE_INDICATOR("damage_indicator"),
    SWEEP_ATTACK("sweep_attack"),
    /**
     * Uses {@link BlockData} as DataType
     */
    FALLING_DUST("falling_dust", BlockData.class),
    TOTEM_OF_UNDYING("totem_of_undying"),
    SPIT("spit"),
    SQUID_INK("squid_ink"),
    BUBBLE_POP("bubble_pop"),
    CURRENT_DOWN("current_down"),
    BUBBLE_COLUMN_UP("bubble_column_up"),
    NAUTILUS("nautilus"),
    DOLPHIN("dolphin"),
    SNEEZE("sneeze"),
    CAMPFIRE_COSY_SMOKE("campfire_cosy_smoke"),
    CAMPFIRE_SIGNAL_SMOKE("campfire_signal_smoke"),
    COMPOSTER("composter"),
    /**
     * Uses {@link Color} as DataType
     */
    FLASH("flash", Color.class),
    FALLING_LAVA("falling_lava"),
    LANDING_LAVA("landing_lava"),
    FALLING_WATER("falling_water"),
    DRIPPING_HONEY("dripping_honey"),
    FALLING_HONEY("falling_honey"),
    LANDING_HONEY("landing_honey"),
    FALLING_NECTAR("falling_nectar"),
    SOUL_FIRE_FLAME("soul_fire_flame"),
    ASH("ash"),
    CRIMSON_SPORE("crimson_spore"),
    WARPED_SPORE("warped_spore"),
    SOUL("soul"),
    DRIPPING_OBSIDIAN_TEAR("dripping_obsidian_tear"),
    FALLING_OBSIDIAN_TEAR("falling_obsidian_tear"),
    LANDING_OBSIDIAN_TEAR("landing_obsidian_tear"),
    REVERSE_PORTAL("reverse_portal"),
    WHITE_ASH("white_ash"),
    /**
     * Uses {@link DustTransition} as DataType
     */
    DUST_COLOR_TRANSITION("dust_color_transition", DustTransition.class),
    /**
     * Uses {@link Vibration} as DataType
     */
    VIBRATION("vibration", Vibration.class),
    FALLING_SPORE_BLOSSOM("falling_spore_blossom"),
    SPORE_BLOSSOM_AIR("spore_blossom_air"),
    SMALL_FLAME("small_flame"),
    SNOWFLAKE("snowflake"),
    DRIPPING_DRIPSTONE_LAVA("dripping_dripstone_lava"),
    FALLING_DRIPSTONE_LAVA("falling_dripstone_lava"),
    DRIPPING_DRIPSTONE_WATER("dripping_dripstone_water"),
    FALLING_DRIPSTONE_WATER("falling_dripstone_water"),
    GLOW_SQUID_INK("glow_squid_ink"),
    GLOW("glow"),
    WAX_ON("wax_on"),
    WAX_OFF("wax_off"),
    ELECTRIC_SPARK("electric_spark"),
    SCRAPE("scrape"),
    SONIC_BOOM("sonic_boom"),
    SCULK_SOUL("sculk_soul"),
    /**
     * Use {@link Float} as DataType
     */
    SCULK_CHARGE("sculk_charge", Float.class),
    SCULK_CHARGE_POP("sculk_charge_pop"),
    /**
     * Use {@link Integer} as DataType
     */
    SHRIEK("shriek", Integer.class),
    CHERRY_LEAVES("cherry_leaves"),
    PALE_OAK_LEAVES("pale_oak_leaves"),
    /**
     * Uses {@link Color} as DataType
     */
    TINTED_LEAVES("tinted_leaves", Color.class),
    EGG_CRACK("egg_crack"),
    DUST_PLUME("dust_plume"),
    WHITE_SMOKE("white_smoke"),
    GUST("gust"),
    SMALL_GUST("small_gust"),
    GUST_EMITTER_LARGE("gust_emitter_large"),
    GUST_EMITTER_SMALL("gust_emitter_small"),
    TRIAL_SPAWNER_DETECTION("trial_spawner_detection"),
    TRIAL_SPAWNER_DETECTION_OMINOUS("trial_spawner_detection_ominous"),
    VAULT_CONNECTION("vault_connection"),
    INFESTED("infested"),
    ITEM_COBWEB("item_cobweb"),
    /**
     * Uses {@link BlockData} as DataType
     */
    DUST_PILLAR("dust_pillar", BlockData.class),
    /**
     * Uses {@link BlockData} as DataType
     */
    @ApiStatus.Experimental
    BLOCK_CRUMBLE("block_crumble", BlockData.class),
    /**
     * Uses {@link Trail} as DataType
     */
    @ApiStatus.Experimental
    TRAIL("trail", Trail.class),
    OMINOUS_SPAWNING("ominous_spawning"),
    RAID_OMEN("raid_omen"),
    TRIAL_OMEN("trial_omen"),
    /**
     * Uses {@link BlockData} as DataType
     */
    BLOCK_MARKER("block_marker", BlockData.class),
    FIREFLY("firefly"),
    COPPER_FIRE_FLAME("copper_fire_flame"),
    ;

    private final NamespacedKey key;
    private final Class<?> dataType;
    final boolean register;

    Particle(String key) {
        this(key, Void.class);
    }

    Particle(String key, boolean register) {
        this(key, Void.class, register);
    }

    Particle(String key, /*@NotNull*/ Class<?> data) {
        this(key, data, true);
    }

    Particle(String key, /*@NotNull*/ Class<?> data, boolean register) {
        if (key != null) {
            this.key = NamespacedKey.minecraft(key);
        } else {
            this.key = null;
        }
        dataType = data;
        this.register = register;
    }

    /**
     * 返回粒子所需的数据类型。
     *
     * @return 所需的数据类型。
     *
     * 原文：
     * Returns the required data type for the particle
     * @return the required data type
     */
    @NotNull
    public Class<?> getDataType() {
        return dataType;
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
        return this.key != null;
    }

    /**
     * {@inheritDoc}
     *
     * @see #getKeyOrThrow()
     * @see #isRegistered()
     * @deprecated 键可能并不总是存在，请改用 {@link #getKeyOrThrow()}。
     *
     * 原文：
     * A key might not always be present, use {@link #getKeyOrThrow()} instead.
     */
    @NotNull
    @Override
    @Deprecated(since = "1.21.4")
    public NamespacedKey getKey() {
        return getKeyOrThrow();
    }

    /**
     * 可以应用于红石粉粒子的选项 - 粒子颜色和大小。
     */
    public static class DustOptions {

        private final Color color;
        private final float size;

        public DustOptions(@NotNull Color color, float size) {
            Preconditions.checkArgument(color != null, "color");
            this.color = color;
            this.size = size;
        }

        /**
         * 要显示的粒子的颜色。
         *
         * @return 粒子颜色。
         *
         * 原文：
         * The color of the particles to be displayed.
         *
         * @return particle color
         */
        @NotNull
        public Color getColor() {
            return color;
        }

        /**
         * 粒子的相对大小。
         *
         * @return 粒子的相对大小。
         *
         * 原文：
         * Relative size of the particle.
         *
         * @return relative particle size
         */
        public float getSize() {
            return size;
        }
    }

    /**
     * 可以应用于颜色渐变粒子的选项。
     */
    public static class DustTransition extends DustOptions {

        private final Color toColor;

        public DustTransition(@NotNull Color fromColor, @NotNull Color toColor, float size) {
            super(fromColor, size);

            Preconditions.checkArgument(toColor != null, "toColor");
            this.toColor = toColor;
        }

        /**
         * 要显示的粒子的最终颜色。
         *
         * @return 粒子的最终颜色。
         *
         * 原文：
         * The final of the particles to be displayed.
         *
         * @return final particle color
         */
        @NotNull
        public Color getToColor() {
            return toColor;
        }
    }

    /**
     * 可以应用于轨迹粒子的选项 - 位置、颜色和持续时间。
     */
    @ApiStatus.Experimental
    public static class Trail {

        private final Location target;
        private final Color color;
        private final int duration;

        public Trail(@NotNull Location target, @NotNull Color color, int duration) {
            this.target = target;
            this.color = color;
            this.duration = duration;
        }

        /**
         * 要显示的粒子的目标。
         *
         * @return 粒子目标。
         *
         * 原文：
         * The target of the particles to be displayed.
         *
         * @return particle target
         */
        @NotNull
        public Location getTarget() {
            return target;
        }

        /**
         * 要显示的粒子的颜色。
         *
         * @return 粒子颜色。
         *
         * 原文：
         * The color of the particles to be displayed.
         *
         * @return particle color
         */
        @NotNull
        public Color getColor() {
            return color;
        }

        /**
         * 要显示的轨迹的持续时间。
         *
         * @return 轨迹持续时间。
         *
         * 原文：
         * The duration of the trail to be displayed.
         *
         * @return trail duration
         */
        public int getDuration() {
            return duration;
        }
    }

    /**
     * 可以应用于法术效果粒子的选项 - 颜色和强度。
     */
    @ApiStatus.Experimental
    public static class Spell {

        private final Color color;
        private final float power;

        public Spell(@NotNull Color color, float power) {
            this.color = color;
            this.power = power;
        }

        /**
         * 要显示的粒子的颜色。
         *
         * @return 粒子颜色。
         *
         * 原文：
         * The color of the particles to be displayed.
         *
         * @return particle color
         */
        @NotNull
        public Color getColor() {
            return color;
        }

        /**
         * 要显示的效果的强度。
         *
         * @return 强度。
         *
         * 原文：
         * The power of the effect to be displayed.
         *
         * @return power
         */
        public float getPower() {
            return power;
        }
    }
}