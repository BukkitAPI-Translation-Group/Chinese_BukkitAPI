package org.bukkit.entity;

import org.bukkit.Location;
import org.jetbrains.annotations.Nullable;

/**
 * 表示已点燃的TNT。
 */
public interface TNTPrimed extends Explosive {

    /**
     * 设置TNT点燃后爆炸的刻数。
     *
     * @param fuseTicks 引信刻数
     * <p>
     * 原文：Set the number of ticks until the TNT blows up after being primed.
     *
     * @param fuseTicks The fuse ticks
     */
    public void setFuseTicks(int fuseTicks);

    /**
     * 获取此TNTPrimed实体爆炸的剩余刻数。
     *
     * @return 此TNTPrimed爆炸的剩余刻数
     * <p>
     * 原文：Retrieve the number of ticks until the explosion of this TNTPrimed
     * entity
     *
     * @return the number of ticks until this TNTPrimed explodes
     */
    public int getFuseTicks();

    /**
     * 获取此已点燃TNT的来源。来源是指创建此已点燃TNT的实体。（例如：玩家使用打火石点燃TNT。）请注意，如果没有合适的来源，这可能为null。（例如由{@link org.bukkit.World#spawn(Location, Class)}方法创建。）
     * <p>
     * 如果此已点燃TNT所在的区块被卸载后重新加载，来源将变为null。来源实体可能无效，例如它已经死亡或被卸载。调用者应检查{@link Entity#isValid()}。
     *
     * @return 此已点燃TNT的来源
     * <p>
     * 原文：Gets the source of this primed TNT. The source is the entity
     * responsible for the creation of this primed TNT. (I.E. player ignites
     * TNT with flint and steel.) Take note that this can be null if there is
     * no suitable source. (created by the {@link
     * org.bukkit.World#spawn(Location, Class)} method, for example.)
     * <p>
     * The source will become null if the chunk this primed TNT is in is
     * unloaded then reloaded. The source entity may be invalid if for example
     * it has since died or been unloaded. Callers should check
     * {@link Entity#isValid()}.
     *
     * @return the source of this primed TNT
     */
    @Nullable
    public Entity getSource();

    /**
     * 设置此已点燃TNT的来源。
     *
     * 来源是指创建此已点燃TNT的实体。
     * <p>
     * 必须是{@link org.bukkit.entity.LivingEntity}的实例，否则将被设置为null。参数类型为{@link org.bukkit.entity.Entity}，以与{@link org.bukkit.entity.TNTPrimed#getSource()}方法保持一致。
     *
     * @param source 此已点燃TNT的来源
     * <p>
     * 原文：Sets the source of this primed TNT.
     *
     * The source is the entity responsible for the creation of this primed TNT.
     * <p>
     * Must be instance of {@link org.bukkit.entity.LivingEntity} otherwise will
     * be set to null. The parameter is typed {@link
     * org.bukkit.entity.Entity} to be consistent with {@link
     * org.bukkit.entity.TNTPrimed#getSource()} method.
     *
     * @param source the source of this primed TNT
     */
    public void setSource(@Nullable Entity source);
}
