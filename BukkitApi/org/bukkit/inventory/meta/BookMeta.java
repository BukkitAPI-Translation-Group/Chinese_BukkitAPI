package org.bukkit.inventory.meta;

import java.util.List;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表书({@link Material#WRITABLE_BOOK}或者{@link Material#WRITTEN_BOOK 成书})，可以有标题，作者，页面.
 */
public interface BookMeta extends ItemMeta {

    /**
     * Represents the generation (or level of copying) of a written book
     */
    enum Generation {
        /**
         * Book written into a book-and-quill. Can be copied. (Default value)
         */
        ORIGINAL,
        /**
         * Book that was copied from an original. Can be copied.
         */
        COPY_OF_ORIGINAL,
        /**
         * Book that was copied from a copy of an original. Can't be copied.
         */
        COPY_OF_COPY,
        /**
         * Unused; unobtainable by players. Can't be copied.
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
     * Checks for the existence of generation level in the book.
     *
     * @return true if the book has a generation level
     */
    boolean hasGeneration();

    /**
     * Gets the generation of the book.
     * <p>
     * Plugins should check that hasGeneration() returns true before calling
     * this method.
     *
     * @return the generation of the book
     */
    @Nullable
    Generation getGeneration();

    /**
     * Sets the generation of the book. Removes generation when given null.
     *
     * @param generation the generation to set
     */
    void setGeneration(@Nullable Generation generation);

    /**
     * 检测这本书是否存在页面.
     * <p>
     * 原文：Checks for the existence of pages in the book.
     *
     * @return 如果这本书有页面返回true
     */
    boolean hasPages();

    /**
     * 获取这本书指定页面的内容.给定的页面必须存在.
     * <p>
     * 页码在1-书本总页数范围内.
     * <p>
     * 原文：Gets the specified page in the book. The given page must exist.
     * <p>
     * Pages are 1-indexed.
     *
     * @param page 指定页码
     * @return 这个页码的内容
     */
    @NotNull
    String getPage(int page);

    /**
     * 设置这本书指定页面的内容.书页必须是连续的.
     * <p>
     * 数据的长度最大为256个字符，超出部分将被截断.
     * <p>
     * 页码在1-书本总页数范围内.
     * <p>
     * 原文：Sets the specified page in the book. Pages of the book must be
     * contiguous.
     * <p>
     * The data can be up to 256 characters in length, additional characters
     * are truncated.
     * <p>
     * Pages are 1-indexed.
     *
     * @param page 要设置的页码,在[1, getPageCount()]区间内
     * @param data 那个书页的内容
     */
    void setPage(int page, @NotNull String data);

    /**
     * 获取这本书的全部页面.
     * <p>
     * 原文：Gets all the pages in the book.
     *
     * @return 这本书的全部页面的内容
     */
    @NotNull
    List<String> getPages();

    /**
     * 清除存在的书页，并设置书提供的书页.最多100页，每页最多256个字符.
     * <p>
     * 原文：Clears the existing book pages, and sets the book to use the provided
     * pages. Maximum 100 pages with 256 characters per page.
     *
     * @param pages 要设置的书页的内容的列表
     */
    void setPages(@NotNull List<String> pages);

    /**
     * 清除存在的书页，并设置书提供的书页.最多50页，每页最多256个字符.
     * <p>
     * 原文：Clears the existing book pages, and sets the book to use the provided
     * pages. Maximum 50 pages with 256 characters per page.
     *
     * @param pages 每页的内容的列表
     */
    void setPages(@NotNull String... pages);

    /**
     * 在这本书的最后添加页面.最多50页，每页最多256个字符.
     * <p>
     * 原文：Adds new pages to the end of the book. Up to a maximum of 50 pages with
     * 256 characters per page.
     *
     * @param pages 每页的内容的列表
     */
    void addPage(@NotNull String... pages);

    /**
     * 获取这本书有多少页.
     * <p>
     * 原文：Gets the number of pages in the book.
     *
     * @return 这本书的页数
     */
    int getPageCount();

    @Override
    @NotNull
    BookMeta clone();

    // Spigot start
    public class Spigot {

        /**
         * Gets the specified page in the book. The given page must exist.
         *
         * @param page the page number to get
         * @return the page from the book
         */
        @NotNull
        public BaseComponent[] getPage(int page) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        /**
         * Sets the specified page in the book. Pages of the book must be
         * contiguous.
         * <p>
         * The data can be up to 256 characters in length, additional characters
         * are truncated.
         *
         * @param page the page number to set
         * @param data the data to set for that page
         */
        public void setPage(int page, @Nullable BaseComponent... data) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        /**
         * Gets all the pages in the book.
         *
         * @return list of all the pages in the book
         */
        @NotNull
        public List<BaseComponent[]> getPages() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        /**
         * Clears the existing book pages, and sets the book to use the provided
         * pages. Maximum 50 pages with 256 characters per page.
         *
         * @param pages A list of pages to set the book to use
         */
        public void setPages(@NotNull List<BaseComponent[]> pages) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        /**
         * Clears the existing book pages, and sets the book to use the provided
         * pages. Maximum 50 pages with 256 characters per page.
         *
         * @param pages A list of component arrays, each being a page
         */
        public void setPages(@NotNull BaseComponent[]... pages) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        /**
         * Adds new pages to the end of the book. Up to a maximum of 50 pages
         * with 256 characters per page.
         *
         * @param pages A list of component arrays, each being a page
         */
        public void addPage(@NotNull BaseComponent[]... pages) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @NotNull
    Spigot spigot();
    // Spigot end
}