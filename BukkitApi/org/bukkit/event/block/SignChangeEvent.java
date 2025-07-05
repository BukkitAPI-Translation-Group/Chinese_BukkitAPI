package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.block.sign.Side;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 在玩家设置牌子上的内容子时触发.
 * <p>
 * 若取消本事件,牌子将不会被更改.
 */
public class SignChangeEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private final Player player;
    private final String[] lines;
    private final Side side;

    @Deprecated(since = "1.19.4")
    public SignChangeEvent(@NotNull final Block theBlock, @NotNull final Player thePlayer, @NotNull final String[] theLines) {
        this(theBlock, thePlayer, theLines, Side.FRONT);
    }

    public SignChangeEvent(@NotNull final Block theBlock, @NotNull final Player thePlayer, @NotNull final String[] theLines, @NotNull Side side) {
        super(theBlock);
        this.player = thePlayer;
        this.lines = theLines;
        this.side = side;
    }

    /**
     * 获得设置这个牌子上的字的玩家.
     * <p>
     * 原文：Gets the player changing the sign involved in this event.
     *
     * @return 玩家
     */
    @NotNull
    public Player getPlayer() {
        return player;
    }

    /**
     * 获得牌子被写上的全部内容.
     * <p>
     * 原文：Gets all of the lines of text from the sign involved in this event.
     *
     * @return 牌子被设置成的内容(长度为4的数组)
     */
    @NotNull
    public String[] getLines() {
        return lines;
    }

    /**
     * 获得牌子被写上的内容的某行.
     * <p>
     * 原文：Gets a single line of text from the sign involved in this event.
     *
     * @param index 要获取的内容的行数,取值0~3
     * @return 你获取的那行
     * @throws IndexOutOfBoundsException 如果行数 {@literal > 3} 或者 {@literal < 0}
     */
    @Nullable
    public String getLine(int index) throws IndexOutOfBoundsException {
        return lines[index];
    }

    /**
     * 修改牌子被写上的字的某行.
     * <p>
     * 原文：Sets a single line for the sign involved in this event
     *
     * @param index 要设定的内容的行数
     * @param line 要设定的内容
     * @throws IndexOutOfBoundsException 如果行数 {@literal > 3} 或者 {@literal < 0}
     */
    public void setLine(int index, @Nullable String line) throws IndexOutOfBoundsException {
        lines[index] = line;
    }

    /**
     * Returns which side is changed.
     *
     * @return the affected side of the sign
     */
    @NotNull
    public Side getSide() {
        return side;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}