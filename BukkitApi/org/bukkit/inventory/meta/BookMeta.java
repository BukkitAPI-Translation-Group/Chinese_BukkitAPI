package org.bukkit.inventory.meta;

import java.util.List;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表{@link Material#WRITTEN_BOOK 成书}，有标题，作者，页面.
 */
public interface BookMeta extends WritableBookMeta {

    /**
     * 代表成书的代次 (或副本级别).
     */
    enum Generation {
        /**
         * 写进书与笔的书(原著). 可被复制. (默认值)
         */
        ORIGINAL,
        /**
         * 原著的副本. 可被复制.
         */
        COPY_OF_ORIGINAL,
        /**
         * 副本的副本. 不可复制.
         */
        COPY_OF_COPY,
        /**
         * 未被使用; 无法被玩家取得. 不可复制.
         */
        TATTERED;
    }

    /**
     * 检测书是否存在标题.
     * <p>
     * 原文：Checks for the existence of a title in the book.
     *
     * @return 这本书是否有标题
     */
    boolean hasTitle();

    /**
     * 获取这本书的标题.
     * <p>
     * 插件应该在调用这个方法之前检测hasTitle()是否返回true.
     * <p>
     * 原文：Gets the title of the book.
     * <p>
     * Plugins should check that hasTitle() returns true before calling this
     * method.
     *
     * @return 这本书的标题
     */
    @Nullable
    String getTitle();

    /**
     * 设置这本书的标题.
     * <p>
     * 仅限32个字符.如果设置为null将移除标题.
     * <p>
     * 原文：Sets the title of the book.
     * <p>
     * Limited to 32 characters. Removes title when given null.
     *
     * @param title 要设置的标题
     * @return 如果成功设置标题则为true
     */
    boolean setTitle(@Nullable String title);

    /**
     * 检测这本书是否存在作者.
     * <p>
     * 原文：Checks for the existence of an author in the book.
     *
     * @return 这本书是否有作者
     */
    boolean hasAuthor();

    /**
     * 获取这本书的作者.
     * <p>
     * 插件应该在调用这个方法之前检测hasAuthor()是否返回true.
     * <p>
     * 原文：Gets the author of the book.
     * <p>
     * Plugins should check that hasAuthor() returns true before calling this
     * method.
     *
     * @return 这本书的作者
     */
    @Nullable
    String getAuthor();

    /**
     * 设置这本书的作者.如果设置为null将移除作者.
     * <p>
     * 原文：Sets the author of the book. Removes author when given null.
     *
     * @param author 这本书的作者
     */
    void setAuthor(@Nullable String author);

    /**
     * 检测本书是否存在代次级别.
     * <p>
     * 原文:
     * Checks for the existence of generation level in the book.
     *
     * @return 本书是否存在代次级别
     */
    boolean hasGeneration();

    /**
     * 获取本书的代次.
     * 插件应该在调用这个方法之前检测 hasGeneration() 是否返回 <code>true</code>.
     * <p>
     * 原文:
     * Gets the generation of the book.
     * <p>
     * Plugins should check that hasGeneration() returns true before calling
     * this method.
     *
     * @return 本书的代次
     */
    @Nullable
    Generation getGeneration();

    /**
     * 设置本书的代次. 当参数为 null 时移除代次.
     * <p>
     * 原文:
     * Sets the generation of the book. Removes generation when given null.
     *
     * @param generation 要设置的代次
     */
    void setGeneration(@Nullable Generation generation);

    @Override
    @NotNull
    BookMeta clone();

    // Spigot start
    public class Spigot {

        /**
         * 获取书本指定书页的内容. 指定页码必须存在.
         * <p>
         * 原文:Gets the specified page in the book. The given page must exist.
         *
         * @param page 页码
         * @return 指定书页的内容
         */
        @NotNull
        public BaseComponent[] getPage(int page) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        /**
         * 设置书本指定书页的内容. 页码必须是相邻的.
         * <p>
         * 数据最长可达256个字符, 修饰性的字符不会被统计在内.
         * <p>
         * 原文:Sets the specified page in the book. Pages of the book must be
         * contiguous.
         * <p>
         * The data can be up to 256 characters in length, additional characters
         * are truncated.
         *
         * @param page 页码
         * @param data 为此页码设置的内容数据
         */
        public void setPage(int page, @Nullable BaseComponent... data) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        /**
         * 获取书本全部书页的内容.
         * <p>
         * 原文:Gets all the pages in the book.
         *
         * @return 书本全部书页的内容
         */
        @NotNull
        public List<BaseComponent[]> getPages() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        /**
         * 清除书本所有书页, 并设置书本使用提供的书页内容.
         * 最多50页, 每页最长256个字符.
         * <p>
         * 原文:Clears the existing book pages, and sets the book to use the provided
         * pages. Maximum 50 pages with 256 characters per page.
         *
         * @param pages 书页列表
         */
        public void setPages(@NotNull List<BaseComponent[]> pages) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        /**
         * 清除书本所有书页, 并设置书本使用提供的书页内容.
         * 最多50页, 每页最长256个字符.
         * <p>
         * 原文:Clears the existing book pages, and sets the book to use the provided
         * pages. Maximum 50 pages with 256 characters per page.
         *
         * @param pages 聊天消息组件数组, 数组中的每一个元素将作为单独的书页
         */
        public void setPages(@NotNull BaseComponent[]... pages) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        /**
         * 在书本末尾追加新的书页.
         * 书本最多容纳50页, 每页最长256个字符.
         * <p>
         * 原文:Adds new pages to the end of the book. Up to a maximum of 50 pages
         * with 256 characters per page.
         *
         * @param pages 聊天消息组件数组, 数组中的每一个元素将作为单独的书页
         */
        public void addPage(@NotNull BaseComponent[]... pages) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @NotNull
    Spigot spigot();
    // Spigot end
}