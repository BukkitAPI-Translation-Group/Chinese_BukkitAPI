package org.bukkit.profile;

import org.bukkit.NamespacedKey;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.Nullable;

public interface PlayerSkinPatch extends ConfigurationSerializable {

    /**
     * 获取修补到此配置文件上的配置文件纹理的路径。
     * <p>
     * 原文：Gets the path to the profile texture patched onto this profile.
     *
     * @return 模型纹理.
     */
    @Nullable
    public NamespacedKey getTexturePatch();

    /**
     * 设置修补到此配置文件上的配置文件纹理的路径。
     * <p>
     * 原文：Gets the path to the profile texture patched onto this profile.
     *
     * @param texture 模型纹理.
     */
    public void setTexturePatch(@Nullable NamespacedKey texture);

    /**
     * 获取修补到此配置文件上的配置文件披风纹理的路径。
     * <p>
     * 原文：Gets the path to the profile cape texture patched onto this profile.
     *
     * @return 披风纹理.
     */
    @Nullable
    public NamespacedKey getCapeTexturePatch();

    /**
     * 设置修补到此配置文件上的配置文件披风纹理的路径。
     * <p>
     * 原文：Gets the path to the profile cape texture patched onto this profile.
     *
     * @param cape 披风纹理.
     */
    public void setCapeTexturePatch(@Nullable NamespacedKey cape);

    /**
     * 获取修补到此配置文件上的配置文件鞘翅纹理的路径。
     * <p>
     * 原文：Gets the path to the profile elytra texture patched onto this profile.
     *
     * @return 鞘翅纹理.
     */
    @Nullable
    public NamespacedKey getElytraTexturePatch();

    /**
     * 设置修补到此配置文件上的配置文件鞘翅纹理的路径。
     * <p>
     * 原文：Gets the path to the profile elytra texture patched onto this profile.
     *
     * @param elytra 鞘翅纹理.
     */
    public void setElytraTexturePatch(@Nullable NamespacedKey elytra);

    /**
     * 获取修补到此配置文件上的模型类型。
     * <p>
     * 原文：Gets the type of model patched onto this profile.
     *
     * @return 模型类型.
     */
    @Nullable
    public PlayerTextures.SkinModel getModelPatch();

    /**
     * 设置修补到此配置文件上的模型类型。
     * <p>
     * 原文：Gets the type of model patched onto this profile.
     *
     * @param model 模型类型.
     */
    public void setModelPatch(@Nullable PlayerTextures.SkinModel model);

    /**
     * 检查补丁是否没有修补的组件。
     * <p>
     * 原文：Checks if the patch has no patched components.
     *
     * @return 如果补丁没有修补的组件则返回 <code>true</code>.
     */
    boolean isEmpty();
}
