package org.bukkit.entity;

/**
 * 代表史莱姆.
 */
public interface Slime extends LivingEntity {

    /**
     * @return 史莱姆的大小
     */
    public int getSize();

    /**
     * @param sz 史莱姆新的大小.
     */
    public void setSize(int sz);

    /**
     * 设置史莱姆的攻击目标({@link LivingEntity}). 设为Null表示清除攻击目标(非敌对状态).
     * <p>
     * 原文:Set the {@link LivingEntity} target for this slime. Set to null to clear
     * the target.
     *
     * @param target 攻击目标
     */
    public void setTarget(LivingEntity target);

    /**
     * 获取史莱姆的攻击目标({@link LivingEntity}).
     * <p>
     * 原文:Get the {@link LivingEntity} this slime is currently targeting.
     *
     * @return 目标对象. Null表示不存在任何目标
     */
    public LivingEntity getTarget();
}