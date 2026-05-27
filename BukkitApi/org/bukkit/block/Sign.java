package org.bukkit.block;

import org.bukkit.DyeColor;
import org.bukkit.block.sign.Side;
import org.bukkit.block.sign.SignSide;
import org.bukkit.entity.Player;
import org.bukkit.material.Colorable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
    @Deprecated(since = "1.20")
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
    @Deprecated(since = "1.20")
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
    @Deprecated(since = "1.20")
    public void setLine(int index, @NotNull String line) throws IndexOutOfBoundsException;

    /**
     * 检测此告示是否可被玩家编辑.
     * <p>
     * 原文:Marks whether this sign can be edited by players.
     *
     * @return 告示牌目前是否可被编辑
     * @deprecated 请使用 {@link #isWaxed()}
     */
    @Deprecated(since = "1.20.1")
    public boolean isEditable();

    /**
     * 设置此告示是否可被玩家编辑.
     * <p>
     * 原文:Marks whether this sign can be edited by players.
     *
     * @param editable 告示牌目前是否可被编辑
     * @deprecated 请使用 {@link #isWaxed()}
     */
    @Deprecated(since = "1.20.1")
    public void setEditable(boolean editable);

    /**
     * 获取此告示牌是否已被涂蜡. 如果告示牌已被涂蜡, 则玩家无法编辑.
     * <p>
     * 原文:Gets whether or not this sign has been waxed. If a sign has been waxed, it
     * cannot be edited by a player.
     *
     * @return 此告示牌是否已被涂蜡
     */
    public boolean isWaxed();

    /**
     * 设置此告示牌是否已被涂蜡. 如果告示牌已被涂蜡, 则玩家无法编辑.
     * <p>
     * 原文:Sets whether or not this sign has been waxed. If a sign has been waxed, it
     * cannot be edited by a player.
     *
     * @param waxed 此告示牌是否已被涂蜡
     */
    public void setWaxed(boolean waxed);

    /**
     * 获取此告示牌是否有发光文本. 仅影响 {@link Side#FRONT}.
     * <p>
     * 原文:Gets whether this sign has glowing text. Only affects the {@link Side#FRONT}.
     *
     * @return 此告示牌是否有发光文本
     * @deprecated 告示牌现在可以有多个可写面. 请使用 {@link #getSide(Side)} 和 {@link SignSide#isGlowingText()}.
     */
    @Deprecated(since = "1.20")
    public boolean isGlowingText();

    /**
     * 设置此告示牌是否有发光文本. 仅影响 {@link Side#FRONT}.
     * <p>
     * 原文:Sets whether this sign has glowing text. Only affects the {@link Side#FRONT}.
     *
     * @param glowing 此告示牌是否有发光文本
     * @deprecated 告示牌现在可以有多个可写面. 请使用 {@link #getSide(Side)} 和 {@link SignSide#setGlowingText(boolean)}.
     */
    @Deprecated(since = "1.20")
    public void setGlowingText(boolean glowing);

    /**
     * {@inheritDoc}
     *
     * @deprecated 告示牌现在可以有多个可写面. 请使用 {@link #getSide(Side)} 和 {@link SignSide#getColor()}.
     */
    @NotNull
    @Override
    @Deprecated(since = "1.20")
    public DyeColor getColor();

    /**
     * {@inheritDoc}
     *
     * @deprecated 告示牌现在可以有多个可写面. 请使用 {@link #getSide(Side)} 和 {@link SignSide#setColor(org.bukkit.DyeColor)}.
     */
    @Override
    @Deprecated(since = "1.20")
    public void setColor(@NotNull DyeColor color);

    /**
     * 返回告示牌的指定面.
     * <p>
     * 原文:Return the side of the sign.
     *
     * @param side 告示牌的面
     * @return 告示牌的选定面
     */
    @NotNull
    public SignSide getSide(@NotNull Side side);

    /**
     * 获取给定玩家当前所站的告示牌面.
     * <p>
     * 原文:Gets the side of this sign the given player is currently standing on.
     *
     * @param player 玩家
     * @return 玩家所站的告示牌面
     */
    @NotNull
    public SignSide getTargetSide(@NotNull Player player);

    /**
     * 获取当前被允许编辑此告示牌的玩家. <br>
     * 如果此值不为 null, 则其他玩家的编辑将被拒绝.
     * <p>
     * 原文:Gets the player that is currently allowed to edit this sign. <br>
     * Edits from other players will be rejected if this value is not null.
     *
     * @return 被允许编辑此告示牌的玩家, 或 null
     */
    @Nullable
    public Player getAllowedEditor();
}
