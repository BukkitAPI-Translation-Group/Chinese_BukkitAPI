package org.bukkit.util;

import java.util.Collection;
import org.apache.commons.lang.Validate;

public class StringUtil {

    /**
     * 复制所有源集合中的元素到给定的集合中，这个集合必须是可迭代的。
     * <p>
     * 原文：Copies all elements from the iterable collection of originals to the
     * collection provided.
     *
     * @param <T> 字符串的集合
     * @param token 寻找的串
     * @param originals 用来检索的可遍历字符串集合
     * @param collection 用来储存检索到的对象的集合
     * @return 用来存放检索到的元素拷贝的集合
     * @throws UnsupportedOperationException 如果这个集合是不可变的，
     * 并且源中包含一个以特定检索字符串开头的元素，则抛出。
     * @throws IllegalArgumentException 当任何一个参数是null时抛出。
     * @throws IllegalArgumentException 当任何一个源具有null元素时抛出。
     *     <b>注意：这个集合可能会在这个异常抛出之前被修改</b>
     */
    public static <T extends Collection<? super String>> T copyPartialMatches(final String token, final Iterable<String> originals, final T collection) throws UnsupportedOperationException, IllegalArgumentException {
        Validate.notNull(token, "Search token cannot be null");
        Validate.notNull(collection, "Collection cannot be null");
        Validate.notNull(originals, "Originals cannot be null");

        for (String string : originals) {
            if (startsWithIgnoreCase(string, token)) {
                collection.add(string);
            }
        }

        return collection;
    }

    /**
     * 这个方法使用一个区块检查不分大小写的相等。
     * 这意味着这个函数像toLowerCase()一样，数组不需要拷贝即可判断。
     * <p>
     * This method uses a region to check case-insensitive equality. This
     * means the internal array does not need to be copied like a
     * toLowerCase() call would.
     *
     * @param string 检查的字符串
     * @param prefix 用来比较的字符串前缀
     * @return 若提供的字符串忽略大小写符合前缀则返回true
     * @throws NullPointerException 若前缀为null则抛出
     * @throws IllegalArgumentException 若提供的字符串为null则抛出
     */
    public static boolean startsWithIgnoreCase(final String string, final String prefix) throws IllegalArgumentException, NullPointerException {
        Validate.notNull(string, "Cannot check a null string for a match");
        if (string.length() < prefix.length()) {
            return false;
        }
        return string.regionMatches(true, 0, prefix, 0, prefix.length());
    }
}
