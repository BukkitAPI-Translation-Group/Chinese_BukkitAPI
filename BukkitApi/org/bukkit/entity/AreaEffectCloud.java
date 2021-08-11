package org.bukkit.entity;

import java.util.List;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一片即将对处于其中的生物施加药水效果的区域效果云 (即喷溅药水使用后形成的雾).
 * <p>
 * 参考：
 * <a href='http://minecraft-zh.gamepedia.com/%E5%8C%BA%E5%9D%97%E6%A0%BC%E5%BC%8F#AreaEffectCloud'>区块格式#AreaEffectCloud</a> 
 * <a href='http://minecraft-zh.gamepedia.com/%E6%BB%9E%E7%95%99%E8%8D%AF%E6%B0%B4'>滞留药水</a>
 */
public interface AreaEffectCloud extends Entity {

    /**
     * 获取这片云存在的时间 (单位为tick).
     * <p>
     * 原文:
     * Gets the duration which this cloud will exist for (in ticks).
     *
     * @return 持续时间
     */
    int getDuration();

    /**
     * 设置这片云存在的时间 (单位为tick).
     * <p>
     * 原文:
     * Sets the duration which this cloud will exist for (in ticks).
     *
     * @param duration 持续时间
     */
    void setDuration(int duration);

    /**
     * 获取实体受到效果前的延迟的时间.
     * <p>
     * 原文:
     * Gets the time which an entity has to be exposed to the cloud before the
     * effect is applied.
     *
     * @return 延迟时间
     */
    int getWaitTime();

    /**
     * 设置实体受到效果前的延迟时间.
     * <p>
     * 原文:
     * Sets the time which an entity has to be exposed to the cloud before the
     * effect is applied.
     *
     * @param waitTime 延迟时间
     */
    void setWaitTime(int waitTime);

    /**
     * 获取实体受到效果后的免疫时间.
     * <p>
     * 原文: 
     * Gets the time that an entity will be immune from subsequent exposure.
     *
     * @return 免疫时间
     */
    int getReapplicationDelay();

    /**
     * 设置实体受到效果后的免疫时间.
     * <p>
     * 原文:
     * Sets the time that an entity will be immune from subsequent exposure.
     *
     * @param delay 免疫时间
     */
    void setReapplicationDelay(int delay);

    /**
     * 获取这片云对一个实体产生效果后持续时间应减少多少.
     * <p>
     * 原文:
     * Gets the amount that the duration of this cloud will decrease by when it
     * applies an effect to an entity.
     *
     * @return 持续时间的变化量
     */
    int getDurationOnUse();

    /**
     * 设置这片云对一个实体产生效果后持续时间应减少多少.
     * <p>
     * 原文:
     * Sets the amount that the duration of this cloud will decrease by when it
     * applies an effect to an entity.
     *
     * @param duration 持续时间的变化量
     */
    void setDurationOnUse(int duration);

    /**
     * 获取这片云的初始半径.
     * <p>
     * 原文:
     * Gets the initial radius of the cloud.
     *
     * @return 半径
     */
    float getRadius();

    /**
     * 设置这片云的初始半径.
     * <p>
     * 原文:
     * Sets the initial radius of the cloud.
     *
     * @param radius 半径
     */
    void setRadius(float radius);

    /**
     * 获取这片云对一个实体产生效果后半径应该减少多少.
     * <p>
     * 原文:
     * Gets the amount that the radius of this cloud will decrease by when it
     * applies an effect to an entity.
     *
     * @return 半径的变化量
     */
    float getRadiusOnUse();

    /**
     * 设置这片云对一个实体产生效果后半径应该减少多少.
     * <p>
     * 原文:
     * Sets the amount that the radius of this cloud will decrease by when it
     * applies an effect to an entity.
     *
     * @param radius 半径的变化量
     */
    void setRadiusOnUse(float radius);

    /**
     * 获取每tick这片云的半径应缩小多少.
     * <p>
     * 原文:
     * Gets the amount that the radius of this cloud will decrease by each tick.
     *
     * @return 每 tick 这片云的半径减少量
     */
    float getRadiusPerTick();

    /**
     * 设置每一tick这片云的半径应缩小多少.
     * <p>
     * 原文(疑似有误, get应为set):
     * Gets the amount that the radius of this cloud will decrease by each tick.
     *
     * @param radius 每 tick 这片云的半径减少量
     */
    void setRadiusPerTick(float radius);

    /**
     * 获取组成这片云的粒子.
     * <p>
     * 原文:
     * Gets the particle which this cloud will be composed of
     *
     * @return 粒子类型
     */
    @NotNull
    Particle getParticle();

    /**
     * 设置组成这片云的粒子.
     * <p>
     * 原文:
     * Sets the particle which this cloud will be composed of
     *
     * @param particle 新的粒子类型
     */
    void setParticle(@NotNull Particle particle);

    /**
     * 设置组成这片云的粒子.
     * <p>
     * 原文:
     * Sets the particle which this cloud will be composed of
     *
     * @param <T> 粒子效果数据的类型 (参阅 {@link Particle#getDataType()}
     * @param particle 新的粒子类型
     * @param data 为此粒子效果使用的数据, 可为null, 数据类型取决于 {@link Particle#getDataType()}
     */
    <T> void setParticle(@NotNull Particle particle, @Nullable T data);

    /**
     * 设置基本药水数据.
     * <p>
     * 原文:
     * Sets the underlying potion data
     *
     * @param data 用于设置基本药水状态的 {@link PotionData}
     */
    void setBasePotionData(@NotNull PotionData data);

    /**
     * 返回基本药水的药水数据.
     * <p>
     * 原文: 
     * Returns the potion data about the base potion
     *
     * @return 一个 PotionData 对象.
     */
    @NotNull
    PotionData getBasePotionData();

    /**
     * 检查自定义药水效果是否有效.
     * <p>
     * 原文:
     * Checks for the presence of custom potion effects.
     *
     * @return 如果自定义药水效果有效则返回true
     */
    boolean hasCustomEffects();

    /**
     * 获取这片云的全部自定义药水效果.
     * 插件应该在调用这个方法之前检查 hasCustomEffects() 是否返回 true.
     * <p>
     * 原文: 
     * Gets an immutable list containing all custom potion effects applied to
     * this cloud.
     * Plugins should check that hasCustomEffects() returns true before calling
     * this method.
     *
     * @return 自定义药水效果的不可变集合
     */
    @NotNull
    List<PotionEffect> getCustomEffects();

    /**
     * 向这片云添加一个自定义药水效果. 
     * <p>
     * 原文:
     * Adds a custom potion effect to this cloud.
     *
     * @param effect 添加的药水效果
     * @param overwrite 是否覆盖当前存在的相同类型效果
     * @return 如果这次调用成功添加效果则返回true
     */
    boolean addCustomEffect(@NotNull PotionEffect effect, boolean overwrite);

    /**
     * 从这片云移除一个自定义药水效果.
     * <p>
     * 原文:  
     * Removes a custom potion effect from this cloud.
     *
     * @param type 移除的药水效果类型
     * @return 如果这次调用成功移除效果则返回true
     */
    boolean removeCustomEffect(@NotNull PotionEffectType type);

    /**
     * 检查这片云中是否存在一种特定的自定义药水效果类型.
     * <p>
     * 原文: 
     * Checks for a specific custom potion effect type on this cloud.
     *
     * @param type 检查的药水效果类型
     * @return 存在这种效果则返回true
     */
    boolean hasCustomEffect(@Nullable PotionEffectType type);

    /**
     * 从这片云移除所有自定义药水效果.
     * <p>
     * 原文: 
     * Removes all custom potion effects from this cloud.
     */
    void clearCustomEffects();

    /**
     * 获取这片云的颜色, 即粒子的颜色.
     * <p>
     * 原文: 
     * Gets the color of this cloud. Will be applied as a tint to its particles.
     *
     * @return 云的颜色
     */
    @NotNull
    Color getColor();

    /**
     * 设置这片云的颜色, 即粒子的颜色. 
     * <p>
     * 原文: 
     * Sets the color of this cloud. Will be applied as a tint to its particles.
     *
     * @param color 云的颜色
     */
    void setColor(@NotNull Color color);

    /**
     * 检索这片云的初始来源.
     * <p>
     * 原文:
     * Retrieve the original source of this cloud.
     * 
     * @return 投掷药水的 {@link ProjectileSource}
     */
    @Nullable
    public ProjectileSource getSource();

    /**
     * 设置这片云的初始来源.
     * <p>
     * 原文:
     * Set the original source of this cloud.
     *
     * @param source 投掷药水的{@link ProjectileSource}
     */
    public void setSource(@Nullable ProjectileSource source);
}
