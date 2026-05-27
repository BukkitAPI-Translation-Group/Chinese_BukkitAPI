package org.bukkit.entity;

import org.bukkit.entity.model.PlayerModelPart;
import org.bukkit.inventory.MainHand;
import org.bukkit.profile.PlayerProfile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一个假人模型。
 */
public interface Mannequin extends LivingEntity {

    /**
     * 获取假人的主手。
     * <p>原文：Gets the mannequin's main hand.
     *
     * @return the mannequin's main hand
     */
    @NotNull
    MainHand getMainHand();

    /**
     * 设置假人的主手。
     * <p>原文：Gets the mannequin's main hand.
     *
     * @param hand the mannequin's main hand
     */
    void setMainHand(@NotNull MainHand hand);

    /**
     * 获取假人模型的某一部分是否显示。
     * <p>原文：Gets whether a part of the mannequin model is shown.
     *
     * @param part model part
     * @return if it is shown
     */
    boolean isModelPartShown(@NotNull PlayerModelPart part);

    /**
     * 设置假人模型的某一部分是否显示。
     * <p>原文：Sets whether a part of the mannequin model is shown.
     *
     * @param part model part
     * @param shown whether it is shown
     */
    void setModelPartShown(@NotNull PlayerModelPart part, boolean shown);

    /**
     * 获取用于给假人添加纹理的玩家配置文件。
     * <p>原文：Gets the profile of the player used to texture the mannequin.
     *
     * @return the profile of the owning player
     */
    @Nullable
    PlayerProfile getPlayerProfile();

    /**
     * 设置用于给假人添加纹理的玩家配置文件。
     * <p>原文：Sets the profile of the player used to texture the mannequin.
     * <p>
     * The profile must already contain a skin texture for it to be displayed.
     *
     * @param profile the profile of the player texture.
     * @throws IllegalArgumentException if the profile does not contain the
     * necessary information
     */
    void setPlayerProfile(@Nullable PlayerProfile profile);

    /**
     * 设置假人姿势。
     * <p>原文：Set the mannequin pose.
     *
     * @param pose new pose
     * @throws IllegalArgumentException if the pose is not valid for a mannequin
     */
    void setPose(@NotNull Pose pose);

    /**
     * 获取此假人是否可以被移动/推动。
     * <p>原文：Gets whether this mannequin can be moved/pushed.
     *
     * @return whether immovable
     */
    boolean isImmovable();

    /**
     * 设置此假人是否可以被移动/推动。
     * <p>原文：Sets whether this mannequin can be moved/pushed.
     *
     * @param immovable new state
     */
    void setImmovable(boolean immovable);

    /**
     * 获取显示为假人名称一部分的描述。
     * <p>原文：Gets the description which shows as part of the mannequin's name.
     *
     * @return description the description text
     */
    @Nullable
    String getDescripion();

    /**
     * 设置显示为假人名称一部分的描述。
     * <p>原文：Sets the description which shows as part of the mannequin's name.
     *
     * @param description the description to show or null for default
     */
    void setDescription(@Nullable String description);

    /**
     * 获取假人描述是否隐藏。
     * <p>原文：Gets whether the mannequin description is hidden.
     *
     * @return hide description status
     */
    boolean isHideDescription();

    /**
     * 设置假人描述是否隐藏。
     * <p>原文：Sets whether the mannequin description is hidden.
     *
     * @param hide whether to hide description
     */
    void setHideDescription(boolean hide);
}
