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
     * @return the model texture
     */
    @Nullable
    public NamespacedKey getTexturePatch();

    /**
     * 设置修补到此配置文件上的配置文件纹理的路径。
     * <p>
     * 原文：Gets the path to the profile texture patched onto this profile.
     *
     * @param texture the model texture
     */
    public void setTexturePatch(@Nullable NamespacedKey texture);

    /**
     * 获取修补到此配置文件上的配置文件披风纹理的路径。
     * <p>
     * 原文：Gets the path to the profile cape texture patched onto this profile.
     *
     * @return the cape texture
     */
    @Nullable
    public NamespacedKey getCapeTexturePatch();

    /**
     * 设置修补到此配置文件上的配置文件披风纹理的路径。
     * <p>
     * 原文：Gets the path to the profile cape texture patched onto this profile.
     *
     * @param cape the cape texture
     */
    public void setCapeTexturePatch(@Nullable NamespacedKey cape);

    /**
     * 获取修补到此配置文件上的配置文件鞘翅纹理的路径。
     * <p>
     * 原文：Gets the path to the profile elytra texture patched onto this profile.
     *
     * @return the elyra texture
     */
    @Nullable
    public NamespacedKey getElytraTexturePatch();

    /**
     * 设置修补到此配置文件上的配置文件鞘翅纹理的路径。
     * <p>
     * 原文：Gets the path to the profile elytra texture patched onto this profile.
     *
     * @param elytra the elyra texture
     */
    public void setElytraTexturePatch(@Nullable NamespacedKey elytra);

    /**
     * 获取修补到此配置文件上的模型类型。
     * <p>
     * 原文：Gets the type of model patched onto this profile.
     *
     * @return model type
     */
    @Nullable
    public PlayerTextures.SkinModel getModelPatch();

    /**
     * 设置修补到此配置文件上的模型类型。
     * <p>
     * 原文：Gets the type of model patched onto this profile.
     *
     * @param model model type
     */
    public void setModelPatch(@Nullable PlayerTextures.SkinModel model);

    /**
     * 检查补丁是否没有修补的组件。
     * <p>
     * 原文：Checks if the patch has no patched components.
     *
     * @return <code>true</code> if the patch has no patched components
     */
    boolean isEmpty();
}
