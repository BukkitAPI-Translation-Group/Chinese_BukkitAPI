package org.bukkit.entity;

/**
 * 代表炽足兽。
 */
public interface Strider extends Steerable, Vehicle {

    /**
     * 检查此炽足兽是否因离开温暖方块而发抖。
     * <p>
     * 原文：Check whether or not this strider is out of warm blocks and shivering.
     *
     * @return 如果发抖则为true，否则为false
     */
    public boolean isShivering();

    /**
     * 设置此炽足兽是否发抖。
     * <p>
     * 注意发抖状态在服务器上会频繁更新，因此此方法可能无法长时间影响实体以产生明显差异。
     * <p>
     * 原文：Set whether or not this strider is shivering.
     * <p>
     * Note that the shivering state is updated frequently on the server,
     * therefore this method may not affect the entity for long enough to have a
     * noticeable difference.
     *
     * @param shivering 新的发抖状态
     */
    public void setShivering(boolean shivering);
}
