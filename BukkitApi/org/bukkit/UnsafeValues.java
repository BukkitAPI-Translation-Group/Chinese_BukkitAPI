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
     * 将指定字符串表示的进度加载到服务器中。
     * 进度格式由 Minecraft 控制，没有指定的布局。
     * <br>
     * 目前是一个 JSON 对象，如 <a href="https://minecraft.wiki/w/Advancements">Minecraft wiki</a> 所述。
     * <br>
     * 加载的进度将被存储并在服务器重启和重载后持续存在。
     * <br>
     * 调用者应准备好捕获 {@link Exception}。
     *
     * @param key 进度的唯一键
     * @param advancement 进度的表示形式
     * @return 加载的进度，如果发生错误则返回 null
     * <p>
     * 原文：Load an advancement represented by the specified string into the server.
     * The advancement format is governed by Minecraft and has no specified
     * layout.
     * <br>
     * It is currently a JSON object, as described by the <a href="https://minecraft.wiki/w/Advancements">Minecraft wiki</a>.
     * <br>
     * Loaded advancements will be stored and persisted across server restarts
     * and reloads.
     * <br>
     * Callers should be prepared for {@link Exception} to be thrown.
     */
    Advancement loadAdvancement(NamespacedKey key, String advancement);

    /**
     * 删除由 {@link #loadAdvancement(org.bukkit.NamespacedKey, java.lang.String)} 加载并保存的进度。
     * <br>
     * 此方法只会从持久存储中删除进度。应该伴随调用 {@link Server#reloadData()} 以便从运行实例中完全删除它。
     *
     * @param key 进度的唯一键
     * @return 如果找到并删除了匹配此键的文件则返回 true
     * <p>
     * 原文：Delete an advancement which was loaded and saved by
     * {@link #loadAdvancement(org.bukkit.NamespacedKey, java.lang.String)}.
     * <br>
     * This method will only remove advancement from persistent storage. It
     * should be accompanied by a call to {@link Server#reloadData()} in order
     * to fully remove it from the running instance.
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
     * 不要使用，方法将被移除，插件将无法运行。
     *
     * @param key 药水类型的键
     * @return 内部药水数据
     * <p>
     * 原文：Do not use, method will get removed, and the plugin won't run
     */
    @ApiStatus.Internal
    @Deprecated(since = "1.20.2", forRemoval = true)
    PotionType.InternalPotionData getInternalPotionData(NamespacedKey key);

    @ApiStatus.Internal
    @Nullable
    DamageEffect getDamageEffect(@NotNull String key);

    /**
     * 创建一个新的 {@link DamageSource.Builder}。
     *
     * @param damageType 要使用的 {@link DamageType}
     * @return 一个 {@link DamageSource.Builder}
     * <p>
     * 原文：Create a new {@link DamageSource.Builder}.
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