package org.bukkit.block;

import org.bukkit.DyeColor;
import org.bukkit.block.sign.Side;
import org.bukkit.block.sign.SignSide;
import org.bukkit.material.Colorable;
import org.jetbrains.annotations.NotNull;

/**
 * 代表告示牌或者墙上告示牌.
 */
public interface Sign extends TileState, Colorable {

    /**
     * 获取这个告示牌前面板上的文本.
     * <p>
     * 原文:
     * Gets all the lines of text currently on the {@link Side#FRONT} of this sign.
     *
     * @return 每行文本字符串数组
     * @deprecated 告示牌现在多面可写. 请使用 {@link Sign#getSide(Side)} 和 {@link SignSide#getLines()}.
     */
    @Deprecated
    @NotNull
    public String[] getLines();

    /**
     * 获取指定行的文本.
     * <p>
     * 例如, getLine(0)将返回告示牌前面板第一行的文本.
     * <p>
     * 原文:
     * Gets the line of text at the specified index.
     * <p>
     * For example, getLine(0) will return the first line of text on the {@link Side#FRONT}.
     *
     * @param index 要获取的文本的行数,从0开始
     * @return 这个行的文本
     * @throws IndexOutOfBoundsException 当此行不存在(尚未设置)时抛出
     * @deprecated 告示牌现在多面可写. 请使用 {@link Sign#getSide(Side)} 和 {@link SignSide#getLines()}.
     */
    @Deprecated
    @NotNull
    public String getLine(int index) throws IndexOutOfBoundsException;

    /**
     * 设置指定索引行的文本.
     * <p>
     * 例如,setLine(0, "行1") 将设置告示牌第一行的文本为"行1".
     * <p>
     * 请注意:从0开始数行.
     * <p>
     * 原文:
     * Sets the line of text at the specified index.
     * <p>
     * For example, setLine(0, "Line One") will set the first line of text to
     * "Line One".
     *
     * @param index 要设置的文本的行数,从0开始
     * @param line 新的指定的文本索引
     * @throws IndexOutOfBoundsException 如果索引超出了0-3的范围
     * @deprecated 告示牌现在多面可写. 请使用 {@link Sign#getSide(Side)} 和 {@link SignSide#getLines()}.
     */
    @Deprecated
    public void setLine(int index, @NotNull String line) throws IndexOutOfBoundsException;

    /**
     * 检测此告示是否可被玩家编辑.
     * <br>
     * 这是一个特殊的, 不持久存储的值.
     * 该值应仅在 BlockPlaceEvent 事件持续期间被放置的告示牌被操作时设置.
     * 在此事件外的行为是未定义的.
     * <p>
     * 原文:Marks whether this sign can be edited by players.
     * <br>
     * This is a special value, which is not persisted. It should only be set if
     * a placed sign is manipulated during the BlockPlaceEvent. Behaviour
     * outside of this event is undefined.
     *
     * @return 告示牌目前是否可被编辑
     */
    public boolean isEditable();

    /**
     * 设置此告示是否可被玩家编辑.
     * <br>
     * 这是一个特殊的, 不持久存储的值.
     * 该值应仅在 BlockPlaceEvent 事件持续期间被放置的告示牌被操作时设置.
     * 在此事件外的行为是未定义的.
     * <p>
     * 原文:Marks whether this sign can be edited by players.
     * <br>
     * This is a special value, which is not persisted. It should only be set if
     * a placed sign is manipulated during the BlockPlaceEvent. Behaviour
     * outside of this event is undefined.
     *
     * @param editable 告示牌目前是否可被编辑
     */
    public void setEditable(boolean editable);

    /**
     * Gets whether this sign has glowing text. Only affects the {@link Side#FRONT}.
     *
     * @return if this sign has glowing text
     * @deprecated A sign may have multiple writable sides now. Use {@link #getSide(Side)} and {@link SignSide#isGlowingText()}.
     */
    @Deprecated
    public boolean isGlowingText();

    /**
     * Sets whether this sign has glowing text. Only affects the {@link Side#FRONT}.
     *
     * @param glowing if this sign has glowing text
     * @deprecated A sign may have multiple writable sides now. Use {@link #getSide(Side)} and {@link SignSide#setGlowingText(boolean)}.
     */
    @Deprecated
    public void setGlowingText(boolean glowing);

    /**
     * {@inheritDoc}
     *
     * @deprecated A sign may have multiple writable sides now. Use {@link #getSide(Side)} and {@link SignSide#getColor()}.
     */
    @NotNull
    @Override
    @Deprecated
    public DyeColor getColor();

    /**
     * {@inheritDoc}
     *
     * @deprecated A sign may have multiple writable sides now. Use {@link #getSide(Side)} and {@link SignSide#setColor(org.bukkit.DyeColor)}.
     */
    @Override
    @Deprecated
    public void setColor(@NotNull DyeColor color);

    /**
     * Return the side of the sign.
     *
     * @param side the side of the sign
     * @return the selected side of the sign
     */
    @NotNull
    public SignSide getSide(@NotNull Side side);
}
