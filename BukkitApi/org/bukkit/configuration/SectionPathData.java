package org.bukkit.configuration;

import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class SectionPathData {

    private Object data;
    private List<String> comments;
    private List<String> inlineComments;

    public SectionPathData(@Nullable Object data) {
        this.data = data;
        comments = Collections.emptyList();
        inlineComments = Collections.emptyList();
    }

    @Nullable
    public Object getData() {
        return data;
    }

    public void setData(@Nullable final Object data) {
        this.data = data;
    }

    /**
     * 如果不存在注释, 将返回一个空列表. 列表中的 null 条目代表一个空行, 空字符串代表一个空的注释行.
     * <p>
     * 原文：
     * If no comments exist, an empty list will be returned. A null entry in the
     * list represents an empty line and an empty String represents an empty
     * comment line.
     *
     * @return 一个不可修改的注释列表, 每个条目代表一行.
     */
    @NotNull
    public List<String> getComments() {
        return comments;
    }

    /**
     * 表示 {@link ConfigurationSection} 条目上的注释.
     * <p>
     * 列表中的 null 条目代表一个空行, 空字符串条目代表一个空的注释行. 无论新注释是什么, 所有已有的注释都将被替换.
     * <p>
     * 原文：
     * Represents the comments on a {@link ConfigurationSection} entry.
     *
     * A null entry in the List is an empty line and an empty String entry is an
     * empty comment line. Any existing comments will be replaced, regardless of
     * what the new comments are.
     *
     * @param comments 要设置的新注释, 每个条目代表一行.
     */
    public void setComments(@Nullable final List<String> comments) {
        this.comments = (comments == null) ? Collections.emptyList() : Collections.unmodifiableList(comments);
    }

    /**
     * 如果不存在注释, 将返回一个空列表. 列表中的 null 条目代表一个空行, 空字符串代表一个空的注释行.
     * <p>
     * 原文：
     * If no comments exist, an empty list will be returned. A null entry in the
     * list represents an empty line and an empty String represents an empty
     * comment line.
     *
     * @return 一个不可修改的注释列表, 每个条目代表一行.
     */
    @NotNull
    public List<String> getInlineComments() {
        return inlineComments;
    }

    /**
     * 表示 {@link ConfigurationSection} 条目上的行内注释.
     * <p>
     * 列表中的 null 条目代表一个空行, 空字符串条目代表一个空的注释行. 无论新注释是什么, 所有已有的注释都将被替换.
     * <p>
     * 原文：
     * Represents the comments on a {@link ConfigurationSection} entry.
     *
     * A null entry in the List is an empty line and an empty String entry is an
     * empty comment line. Any existing comments will be replaced, regardless of
     * what the new comments are.
     *
     * @param inlineComments 要设置的新注释, 每个条目代表一行.
     */
    public void setInlineComments(@Nullable final List<String> inlineComments) {
        this.inlineComments = (inlineComments == null) ? Collections.emptyList() : Collections.unmodifiableList(inlineComments);
    }
}
