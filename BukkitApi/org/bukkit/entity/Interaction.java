package org.bukkit.entity;

import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一种仅用于记录交互的实体。
 */
public interface Interaction extends Entity {

    /**
     * 获取此交互实体的宽度。
     * <p>原文：Gets the width of this interaction entity.
     *
     * @return width
     */
    public float getInteractionWidth();

    /**
     * 设置此交互实体的宽度。
     * <p>原文：Sets the width of this interaction entity.
     *
     * @param width new width
     */
    public void setInteractionWidth(float width);

    /**
     * 获取此交互实体的高度。
     * <p>原文：Gets the height of this interaction entity.
     *
     * @return height
     */
    public float getInteractionHeight();

    /**
     * 设置此交互实体的高度。
     * <p>原文：Sets the height of this interaction entity.
     *
     * @param height new height
     */
    public void setInteractionHeight(float height);

    /**
     * 获取此交互实体被交互时是否触发响应。
     * <p>原文：Gets if this interaction entity should trigger a response when interacted
     * with.
     *
     * @return response setting
     */
    public boolean isResponsive();

    /**
     * 设置此交互实体被交互时是否触发响应。
     * <p>原文：Sets if this interaction entity should trigger a response when interacted
     * with.
     *
     * @param response new setting
     */
    public void setResponsive(boolean response);

    /**
     * 获取此交互实体的最后一次攻击。
     * <p>原文：Gets the last attack on this interaction entity.
     *
     * @return last attack data, if present
     */
    @Nullable
    public PreviousInteraction getLastAttack();

    /**
     * 获取此实体的最后一次交互。
     * <p>原文：Gets the last interaction on this entity.
     *
     * @return last interaction data, if present
     */
    @Nullable
    public PreviousInteraction getLastInteraction();

    /**
     * 代表与此实体的一次先前交互。
     */
    public interface PreviousInteraction {

        /**
         * 获取先前交互的玩家。
         * <p>原文：Get the previous interacting player.
         *
         * @return interacting player
         */
        @NotNull
        public OfflinePlayer getPlayer();

        /**
         * 获取此交互发生的Unix时间戳。
         * <p>原文：Gets the Unix timestamp at when this interaction occurred.
         *
         * @return interaction timestamp
         */
        public long getTimestamp();
    }
}
