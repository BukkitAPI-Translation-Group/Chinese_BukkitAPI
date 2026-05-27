package org.bukkit.entity;

import com.google.common.base.Preconditions;
import org.bukkit.Color;
import org.bukkit.util.Transformation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;

/**
 * 展示实体, 仅具有视觉功能.
 */
public interface Display extends Entity {

    /**
     * 获取应用于此展示实体的变换.
     * <p>
     * 原文：Gets the transformation applied to this display.
     *
     * @return 变换
     */
    @NotNull
    public Transformation getTransformation();

    /**
     * 设置应用于此展示实体的变换
     * <p>
     * 原文：Sets the transformation applied to this display
     *
     * @param transformation 新变换
     */
    public void setTransformation(@NotNull Transformation transformation);

    /**
     * 设置应用于此展示实体的原始变换矩阵
     * <p>
     * 原文：Sets the raw transformation matrix applied to this display
     *
     * @param transformationMatrix 变换矩阵
     */
    public void setTransformationMatrix(@NotNull Matrix4f transformationMatrix);

    /**
     * 获取此展示实体的插值持续时间.
     * <p>
     * 原文：Gets the interpolation duration of this display.
     *
     * @return 插值持续时间
     */
    public int getInterpolationDuration();

    /**
     * 设置此展示实体的插值持续时间.
     * <p>
     * 原文：Sets the interpolation duration of this display.
     *
     * @param duration 新持续时间
     */
    public void setInterpolationDuration(int duration);

    /**
     * 获取此展示实体的传送持续时间.
     * <ul>
     *     <li>0 表示更新立即应用.</li>
     *     <li>1 表示展示实体将在一个 tick 内从当前位置移动到更新后的位置.</li>
     *     <li>更高的值会将移动分散到多个 tick.</li>
     * </ul>
     * <p>
     * 原文：Gets the teleport duration of this display.
     * <ul>
     *     <li>0 means that updates are applied immediately.</li>
     *     <li>1 means that the display entity will move from current position to the updated one over one tick.</li>
     *     <li>Higher values spread the movement over multiple ticks.</li>
     * </ul>
     *
     * @return 传送持续时间
     */
    public int getTeleportDuration();

    /**
     * 设置此展示实体的传送持续时间.
     * <p>
     * 原文：Sets the teleport duration of this display.
     *
     * @param duration 新持续时间
     * @throws IllegalArgumentException 如果持续时间不在 0 到 59 之间
     * @see #getTeleportDuration()
     */
    public void setTeleportDuration(int duration);

    /**
     * 获取此展示实体的视距/范围.
     * <p>
     * 原文：Gets the view distance/range of this display.
     *
     * @return 视距
     */
    public float getViewRange();

    /**
     * 设置此展示实体的视距/范围.
     * <p>
     * 原文：Sets the view distance/range of this display.
     *
     * @param range 新范围
     */
    public void setViewRange(float range);

    /**
     * 获取此展示实体的阴影半径.
     * <p>
     * 原文：Gets the shadow radius of this display.
     *
     * @return 半径
     */
    public float getShadowRadius();

    /**
     * 设置此展示实体的阴影半径.
     * <p>
     * 原文：Sets the shadow radius of this display.
     *
     * @param radius 新半径
     */
    public void setShadowRadius(float radius);

    /**
     * 获取此展示实体的阴影强度.
     * <p>
     * 原文：Gets the shadow strength of this display.
     *
     * @return 阴影强度
     */
    public float getShadowStrength();

    /**
     * 设置此展示实体的阴影强度.
     * <p>
     * 原文：Sets the shadow strength of this display.
     *
     * @param strength 新强度
     */
    public void setShadowStrength(float strength);

    /**
     * 获取此展示实体的宽度.
     * <p>
     * 原文：Gets the width of this display.
     *
     * @return 宽度
     */
    public float getDisplayWidth();

    /**
     * 设置此展示实体的宽度.
     * <p>
     * 原文：Sets the width of this display.
     *
     * @param width 新宽度
     */
    public void setDisplayWidth(float width);

    /**
     * 获取此展示实体的高度.
     * <p>
     * 原文：Gets the height of this display.
     *
     * @return 高度
     */
    public float getDisplayHeight();

    /**
     * 设置此展示实体的高度.
     * <p>
     * 原文：Sets the height if this display.
     *
     * @param height 新高度
     */
    public void setDisplayHeight(float height);

    /**
     * 获取客户端插值开始前的 tick 数.
     * <p>
     * 原文：Gets the amount of ticks before client-side interpolation will commence.
     *
     * @return 插值延迟 tick 数
     */
    public int getInterpolationDelay();

    /**
     * 设置客户端插值开始前的 tick 数.
     * <p>
     * 原文：Sets the amount of ticks before client-side interpolation will commence.
     *
     * @param ticks 插值延迟 tick 数
     */
    public void setInterpolationDelay(int ticks);

    /**
     * 获取此实体的广告牌设置.
     *
     * 广告牌设置控制实体自动旋转以面向玩家.
     * <p>
     * 原文：Gets the billboard setting of this entity.
     *
     * The billboard setting controls the automatic rotation of the entity to
     * face the player.
     *
     * @return 广告牌设置
     */
    @NotNull
    public Billboard getBillboard();

    /**
     * 设置此实体的广告牌设置.
     *
     * 广告牌设置控制实体自动旋转以面向玩家.
     * <p>
     * 原文：Sets the billboard setting of this entity.
     *
     * The billboard setting controls the automatic rotation of the entity to
     * face the player.
     *
     * @param billboard 新设置
     */
    public void setBillboard(@NotNull Billboard billboard);

    /**
     * 获取此展示实体的计分板队伍覆盖发光颜色.
     * <p>
     * 原文：Gets the scoreboard team overridden glow color of this display.
     *
     * @return 发光颜色
     */
    @Nullable
    public Color getGlowColorOverride();

    /**
     * 设置此展示实体的计分板队伍覆盖发光颜色.
     * <p>
     * 原文：Sets the scoreboard team overridden glow color of this display.
     *
     * @param color 新颜色
     */
    public void setGlowColorOverride(@Nullable Color color);

    /**
     * 获取实体的亮度覆盖.
     * <p>
     * 原文：Gets the brightness override of the entity.
     *
     * @return 亮度覆盖 (如果已设置)
     */
    @Nullable
    public Brightness getBrightness();

    /**
     * 设置实体的亮度覆盖.
     * <p>
     * 原文：Sets the brightness override of the entity.
     *
     * @param brightness 新亮度覆盖
     */
    public void setBrightness(@Nullable Brightness brightness);

    /**
     * 描述实体可以围绕其旋转的轴/点.
     */
    public enum Billboard {

        /**
         * 不旋转 (默认).
         */
        FIXED,
        /**
         * 可以围绕垂直轴旋转.
         */
        VERTICAL,
        /**
         * 可以围绕水平轴旋转.
         */
        HORIZONTAL,
        /**
         * 可以围绕中心点旋转.
         */
        CENTER;
    }

    /**
     * 表示实体的亮度渲染参数.
     */
    public static class Brightness {

        private final int blockLight;
        private final int skyLight;

        public Brightness(int blockLight, int skyLight) {
            Preconditions.checkArgument(0 <= blockLight && blockLight <= 15, "Block brightness out of range: %s", blockLight);
            Preconditions.checkArgument(0 <= skyLight && skyLight <= 15, "Sky brightness out of range: %s", skyLight);

            this.blockLight = blockLight;
            this.skyLight = skyLight;
        }

        /**
         * 获取此亮度的方块光照分量.
         * <p>
         * 原文：Gets the block lighting component of this brightness.
         *
         * @return 方块光照, 0-15 之间
         */
        public int getBlockLight() {
            return this.blockLight;
        }

        /**
         * 获取此亮度的天空光照分量.
         * <p>
         * 原文：Gets the sky lighting component of this brightness.
         *
         * @return 天空光照, 0-15 之间
         */
        public int getSkyLight() {
            return this.skyLight;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 47 * hash + this.blockLight;
            hash = 47 * hash + this.skyLight;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Brightness other = (Brightness) obj;
            if (this.blockLight != other.blockLight) {
                return false;
            }
            return this.skyLight == other.skyLight;
        }

        @Override
        public String toString() {
            return "Brightness{" + "blockLight=" + this.blockLight + ", skyLight=" + this.skyLight + '}';
        }
    }
}
