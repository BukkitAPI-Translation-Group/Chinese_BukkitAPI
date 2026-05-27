package org.bukkit.map;

import java.util.HashMap;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 表示可在地图上绘制的位图字体。
 */
public class MapFont {

    private final HashMap<Character, CharacterSprite> chars = new HashMap<Character, CharacterSprite>();
    private int height = 0;
    protected boolean malleable = true;

    /**
     * 为给定字符设置精灵图。
     * <p>
     * 原文：
     * Set the sprite for a given character.
     *
     * @param ch 要设置精灵图的字符。
     * @param sprite 要设置的CharacterSprite。
     * @throws IllegalStateException 如果此字体是静态的。
     */
    public void setChar(char ch, @NotNull CharacterSprite sprite) {
        if (!malleable) {
            throw new IllegalStateException("this font is not malleable");
        }

        chars.put(ch, sprite);
        if (sprite.getHeight() > height) {
            height = sprite.getHeight();
        }
    }

    /**
     * 获取给定字符的精灵图。
     * <p>
     * 原文：
     * Get the sprite for a given character.
     *
     * @param ch 要获取精灵图的字符。
     * @return 与该字符关联的CharacterSprite，如果没有则返回null。
     */
    @Nullable
    public CharacterSprite getChar(char ch) {
        return chars.get(ch);
    }

    /**
     * 获取使用此字体渲染给定文本时的宽度。
     * <p>
     * 原文：
     * Get the width of the given text as it would be rendered using this
     * font.
     *
     * @param text 文本。
     * @return 宽度（像素）。
     */
    public int getWidth(@NotNull String text) {
        if (!isValid(text)) {
            throw new IllegalArgumentException("text contains invalid characters");
        }

        if (text.length() == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < text.length(); ++i) {
            char ch = text.charAt(i);
            if (ch == ChatColor.COLOR_CHAR) {
                int j = text.indexOf(';', i);
                if (j >= 0) {
                    i = j;
                    continue;
                }
                throw new IllegalArgumentException("Text contains unterminated color string");
            }
            result += chars.get(ch).getWidth();
        }
        result += text.length() - 1; // Account for 1px spacing between characters

        return result;
    }

    /**
     * 获取此字体的高度。
     * <p>
     * 原文：
     * Get the height of this font.
     *
     * @return 字体的高度。
     */
    public int getHeight() {
        return height;
    }

    /**
     * 检查给定文本是否有效。
     * <p>
     * 原文：
     * Check whether the given text is valid.
     *
     * @param text 文本。
     * @return 如果字符串仅包含已定义字符则返回true，否则返回false。
     */
    public boolean isValid(@NotNull String text) {
        for (int i = 0; i < text.length(); ++i) {
            char ch = text.charAt(i);
            if (ch == ChatColor.COLOR_CHAR || ch == '\n') continue;
            if (chars.get(ch) == null) return false;
        }
        return true;
    }

    /**
     * 表示MapFont中单个字符的图形。
     */
    public static class CharacterSprite {

        private final int width;
        private final int height;
        private final boolean[] data;

        public CharacterSprite(int width, int height, @NotNull boolean[] data) {
            this.width = width;
            this.height = height;
            this.data = data;

            if (data.length != width * height) {
                throw new IllegalArgumentException("size of data does not match dimensions");
            }
        }

        /**
         * 获取字符像素的值。
         * <p>
         * 原文：
         * Get the value of a pixel of the character.
         *
         * @param row 行，范围为[0,8)。
         * @param col 列，范围为[0,8)。
         * @return 如果像素是实心的则返回true，如果是透明的则返回false。
         */
        public boolean get(int row, int col) {
            if (row < 0 || col < 0 || row >= height || col >= width) return false;
            return data[row * width + col];
        }

        /**
         * 获取字符精灵图的宽度。
         * <p>
         * 原文：
         * Get the width of the character sprite.
         *
         * @return 字符的宽度。
         */
        public int getWidth() {
            return width;
        }

        /**
         * 获取字符精灵图的高度。
         * <p>
         * 原文：
         * Get the height of the character sprite.
         *
         * @return 字符的高度。
         */
        public int getHeight() {
            return height;
        }

    }

}
