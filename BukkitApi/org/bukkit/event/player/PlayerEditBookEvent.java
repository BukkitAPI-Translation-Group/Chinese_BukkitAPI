package org.bukkit.event.player;

import com.google.common.base.Preconditions;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.meta.BookMeta;
import org.jetbrains.annotations.NotNull;

/**
 * 当玩家编辑或签名书与笔时触发。如果事件中断取消，书与笔的元数据不会改变。
 */
public class PlayerEditBookEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    private final BookMeta previousBookMeta;
    private final int slot;
    private BookMeta newBookMeta;
    private boolean isSigning;
    private boolean cancel;

    public PlayerEditBookEvent(@NotNull Player who, int slot, @NotNull BookMeta previousBookMeta, @NotNull BookMeta newBookMeta, boolean isSigning) {
        super(who);

        Preconditions.checkArgument(slot >= -1 && slot <= 8, "Slot must be in range (-1)-8 inclusive");
        Preconditions.checkArgument(previousBookMeta != null, "Previous book meta must not be null");
        Preconditions.checkArgument(newBookMeta != null, "New book meta must not be null");

        Bukkit.getItemFactory().equals(previousBookMeta, newBookMeta);

        this.previousBookMeta = previousBookMeta;
        this.newBookMeta = newBookMeta;
        this.slot = slot;
        this.isSigning = isSigning;
        this.cancel = false;
    }

    /**
     * 获取当前书本元数据。
     * <p>
     * 注意：获取书本的元数据副本。你无法使用该对象来修改书本元数据。
     * <p>
     * 原文:Gets the book meta currently on the book.
     * <p>
     * Note: this is a copy of the book meta. You cannot use this object to
     * change the existing book meta.
     *
     * @return 当前书本的元数据
     */
    @NotNull
    public BookMeta getPreviousBookMeta() {
        return previousBookMeta.clone();
    }

    /**
     * 获取玩家试图新增的书本元数据。 
     * <p>
     * 注意：获取的元数据为副本。使用 {@link #setNewBookMeta(BookMeta)}修改实际想要更新的书本元数据
     * <p>
     * 原文:Gets the book meta that the player is attempting to add to the book.
     * <p>
     * Note: this is a copy of the proposed new book meta. Use {@link
     * #setNewBookMeta(BookMeta)} to change what will actually be added to the
     *
     * @return 玩家试图新增的书本元数据
     */
    @NotNull
    public BookMeta getNewBookMeta() {
        return newBookMeta.clone();
    }

    /**
     * 获取触发事件时，书本在物品栏所在的格子序号.
     * <p>
     * 对应为玩家快捷操作栏，取值范围 0-8, 或-1代表副手.
     * <p>
     * 原文:Gets the inventory slot number for the book item that triggered this
     * event.
     * <p>
     * This is a slot number on the player's hotbar in the range 0-8, or -1 for
     * off hand.
     *
     * @return 事件中书本在玩家物品栏所占用的格子序号
     * @deprecated 书可能被副手签名
     */
    @Deprecated(since = "1.13.1")
    public int getSlot() {
        return slot;
    }

    /**
     * 设置新增的书本元数据。
     * <p>
     * 原文:Sets the book meta that will actually be added to the book.
     *
     * @param newBookMeta 构造书本元数据
     * @throws IllegalArgumentException 当构造的书本元数据不为空值时抛出异常
     */
    public void setNewBookMeta(@NotNull BookMeta newBookMeta) throws IllegalArgumentException {
        Preconditions.checkArgument(newBookMeta != null, "New book meta must not be null");
        Bukkit.getItemFactory().equals(newBookMeta, null);
        this.newBookMeta = newBookMeta.clone();
    }

    /**
     * 检测书本是否正在被签名。如果正在签名，书与笔将转变为成书。
     * <p>
     * 原文:Gets whether or not the book is being signed. If a book is signed the
     * Material changes from BOOK_AND_QUILL to WRITTEN_BOOK.
     *
     * @return 当书本正在被签名时，返回true。
     */
    public boolean isSigning() {
        return isSigning;
    }

    /**
     * 设置书本是否正在被签名。如果正在签名，书与笔将转变为成书。
     * <p>
     * 原文:Sets whether or not the book is being signed. If a book is signed the 
     * Material changes from BOOK_AND_QUILL to WRITTEN_BOOK.
     *
     * @param signing 书本是否正在被签名
     */
    public void setSigning(boolean signing) {
        isSigning = signing;
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

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }
}
