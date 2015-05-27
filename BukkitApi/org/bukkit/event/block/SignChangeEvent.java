package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 在玩家更改牌子的时候调用
 * <p>
 * 若取消本事件，牌子将不会被更改
 */
public class SignChangeEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private final Player player;
    private final String[] lines;

    public SignChangeEvent(final Block theBlock, final Player thePlayer, final String[] theLines) {
        super(theBlock);
        this.player = thePlayer;
        this.lines = theLines;
    }

    /**
     * 获取更改这个牌子的玩家
     *
     * @return 更改这个牌子的玩家
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * 获取被更改的牌子的所有内容
     *
     * @return 被更改的牌子的所有内容（数组）
     */
    public String[] getLines() {
        return lines;
    }

    /**
     * 获取
     *
     * @param index 要获取的内容的行数
     * @return 你获取的那行
     * @throws IndexOutOfBoundsException 如果行数 {@literal > 3
     *     or < 0}
     */
    public String getLine(int index) throws IndexOutOfBoundsException {
        return lines[index];
    }

    /**
     * 设置被更改的牌子指定一行的内容
     *
     * @param index 要设定的内容的行数
     * @param line 要设定的内容
     * @throws IndexOutOfBoundsException 如果行数 {@literal > 3
     *     or < 0}
     */
    public void setLine(int index, String line) throws IndexOutOfBoundsException {
        lines[index] = line;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
