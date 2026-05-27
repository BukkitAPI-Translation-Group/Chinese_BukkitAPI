package org.bukkit.entity;

import org.bukkit.block.BlockFace;
import org.bukkit.material.Colorable;
import org.jetbrains.annotations.NotNull;

public interface Shulker extends Golem, Colorable, Enemy {

    /**
     * 获取潜影贝的窥视状态，范围在0.0到1.0之间。
     * <p>
     * 原文：Gets the peek state of the shulker between 0.0 and 1.0.
     *
     * @return 潜影贝的窥视状态，范围在0.0到1.0之间
     */
    public float getPeek();

    /**
     * 设置潜影贝的窥视状态，应在0.0到1.0之间。
     * <p>
     * 原文：Sets the peek state of the shulker, should be in between 0.0 and 1.0.
     *
     * @param value 潜影贝的窥视状态，应在0.0到1.0之间
     * @throws IllegalArgumentException 如果值超出0.0到1.0的有效范围则抛出
     */
    public void setPeek(float value);

    /**
     * 获取潜影贝附着的面。
     * <p>
     * 原文：Gets the face to which the shulker is attached.
     *
     * @return 潜影贝附着的面
     */
    @NotNull
    public BlockFace getAttachedFace();

    /**
     * 设置潜影贝附着的面。
     * <p>
     * 原文：Sets the face to which the shulker is attached.
     *
     * @param face 潜影贝要附着的面
     */
    public void setAttachedFace(@NotNull BlockFace face);
}
