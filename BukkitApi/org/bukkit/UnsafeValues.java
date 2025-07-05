package org.bukkit;

import com.google.common.collect.Multimap;
import org.bukkit.advancement.Advancement;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.Biome;
import org.bukkit.block.data.BlockData;
import org.bukkit.damage.DamageEffect;
import org.bukkit.damage.DamageSource;
import org.bukkit.damage.DamageType;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.CreativeCategory;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 这个接口提供可能在特定运行时间内或含有任意意义的数值的转换（即不安全的参数）.
 * <p>
 * 这些值的存在形式和行为不能保证在未来的版本可用。可能会非法命名，抛出异常，有误导参数或其他错误.
 */
@Deprecated(since = "1.7.2")
public interface UnsafeValues {

    Material toLegacy(Material material);

    Material fromLegacy(Material material);

    Material fromLegacy(MaterialData material);

    Material fromLegacy(MaterialData material, boolean itemPriority);

    BlockData fromLegacy(Material material, byte data);

    Material getMaterial(String material, int version);

    int getDataVersion();

    ItemStack modifyItemStack(ItemStack stack, String arguments);

    void checkSupported(PluginDescriptionFile pdf) throws InvalidPluginException;

    byte[] processClass(PluginDescriptionFile pdf, String path, byte[] clazz);

    /**
     * Load an advancement represented by the specified string into the server.
     * The advancement format is governed by Minecraft and has no specified
     * layout.
     * <br>
     * It is currently a JSON object, as described by the <a href="https://minecraft.wiki/w/Advancements">Minecraft wiki</a>.
     * <br>
     * Loaded advancements will be stored and persisted across server restarts
     * and reloads.
     * <br>
     * Callers should be prepared for {@link Exception} to be thrown.
     *
     * @param key the unique advancement key
     * @param advancement representation of the advancement
     * @return the loaded advancement or null if an error occurred
     */
    Advancement loadAdvancement(NamespacedKey key, String advancement);

    /**
     * Delete an advancement which was loaded and saved by
     * {@link #loadAdvancement(org.bukkit.NamespacedKey, java.lang.String)}.
     * <br>
     * This method will only remove advancement from persistent storage. It
     * should be accompanied by a call to {@link Server#reloadData()} in order
     * to fully remove it from the running instance.
     *
     * @param key the unique advancement key
     * @return true if a file matching this key was found and deleted
     */
    boolean removeAdvancement(NamespacedKey key);

    @Deprecated(since = "1.21", forRemoval = true)
    Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(Material material, EquipmentSlot slot);

    @Deprecated(since = "1.21", forRemoval = true)
    CreativeCategory getCreativeCategory(Material material);

    @Deprecated(since = "1.21", forRemoval = true)
    String getBlockTranslationKey(Material material);

    @Deprecated(since = "1.21", forRemoval = true)
    String getItemTranslationKey(Material material);

    String getTranslationKey(EntityType entityType);

    String getTranslationKey(ItemStack itemStack);

    @Deprecated(since = "1.21.3", forRemoval = true)
    String getTranslationKey(Attribute attribute);

    @Nullable
    FeatureFlag getFeatureFlag(@NotNull NamespacedKey key);

    /**
     * Do not use, method will get removed, and the plugin won't run
     *
     * @param key of the potion type
     * @return an internal potion data
     */
    @ApiStatus.Internal
    @Deprecated(since = "1.20.2", forRemoval = true)
    PotionType.InternalPotionData getInternalPotionData(NamespacedKey key);

    @ApiStatus.Internal
    @Nullable
    DamageEffect getDamageEffect(@NotNull String key);

    /**
     * Create a new {@link DamageSource.Builder}.
     *
     * @param damageType the {@link DamageType} to use
     * @return a {@link DamageSource.Builder}
     */
    @ApiStatus.Internal
    @NotNull
    DamageSource.Builder createDamageSourceBuilder(@NotNull DamageType damageType);

    @ApiStatus.Internal
    String get(Class<?> aClass, String value);

    @ApiStatus.Internal
    <B extends Keyed> B get(Registry<B> registry, NamespacedKey key);

    @ApiStatus.Internal
    Biome getCustomBiome();

    @ApiStatus.Internal
    Villager.ReputationType createReputationType(String key);

    @ApiStatus.Internal
    Villager.ReputationEvent createReputationEvent(String key);
}