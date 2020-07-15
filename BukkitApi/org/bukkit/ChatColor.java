package org.bukkit;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.lang.Validate;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 聊天框支持的所有颜色
 */
public enum ChatColor {
    /**
     * <span style="color:#000000">黑色: <span style="background:#000000"> 黑色 </span></span>
     */
    BLACK('0', 0x00) {
        @NotNull
        @Override
        public net.md_5.bungee.api.ChatColor asBungee() {
            return net.md_5.bungee.api.ChatColor.BLACK;
        }
    },
    /**
     * <span style="color:#0000be">深蓝: <span style="background:#0000be"> 深蓝 </span></span>
     */
    DARK_BLUE('1', 0x1) {
        @NotNull
        @Override
        public net.md_5.bungee.api.ChatColor asBungee() {
            return net.md_5.bungee.api.ChatColor.DARK_BLUE;
        }
    },
    /**
     * <span style="color:#00bf00">深绿: <span style="background:#00bf00"> 深绿 </span></span>
     */
    DARK_GREEN('2', 0x2) {
        @NotNull
        @Override
        public net.md_5.bungee.api.ChatColor asBungee() {
            return net.md_5.bungee.api.ChatColor.DARK_GREEN;
        }
    },
    /**
     * <span style="color:#00bebe">深蓝: <span style="background:#00bebe"> 深蓝 </span></span>
     */
    DARK_AQUA('3', 0x3) {
        @NotNull
        @Override
        public net.md_5.bungee.api.ChatColor asBungee() {
            return net.md_5.bungee.api.ChatColor.DARK_AQUA;
        }
    },
    /**
     * <span style="color:#be0000">深红: <span style="background:#be0000"> 深红 </span></span>
     */
    DARK_RED('4', 0x4) {
        @NotNull
        @Override
        public net.md_5.bungee.api.ChatColor asBungee() {
            return net.md_5.bungee.api.ChatColor.DARK_RED;
        }
    },
    /**
     * <span style="color:#be00be">深紫: <span style="background:#be00be"> 深紫 </span></span>
     */
    DARK_PURPLE('5', 0x5) {
        @NotNull
        @Override
        public net.md_5.bungee.api.ChatColor asBungee() {
            return net.md_5.bungee.api.ChatColor.DARK_PURPLE;
        }
    },
    /**
     * <span style="color:#d8a333">橙色: <span style="background:#d8a333"> 橙色 </span></span>
     */
    GOLD('6', 0x6) {
        @NotNull
        @Override
        public net.md_5.bungee.api.ChatColor asBungee() {
            return net.md_5.bungee.api.ChatColor.GOLD;
        }
    },
    /**
     * <span style="color:#bebebe">灰色: <span style="background:#bebebe"> 灰色 </span></span>
     */
    GRAY('7', 0x7) {
        @NotNull
        @Override
        public net.md_5.bungee.api.ChatColor asBungee() {
            return net.md_5.bungee.api.ChatColor.GRAY;
        }
    },
    /**
     * <span style="color:#3f3f3f">深灰: <span style="background:#3f3f3f"> 深灰 </span></span>
     */
    DARK_GRAY('8', 0x8) {
        @NotNull
        @Override
        public net.md_5.bungee.api.ChatColor asBungee() {
            return net.md_5.bungee.api.ChatColor.DARK_GRAY;
        }
    },
    /**
     * <span style="color:#3f40fd">蓝色: <span style="background:#3f40fd"> 蓝色 </span></span>
     */
    BLUE('9', 0x9) {
        @NotNull
        @Override
        public net.md_5.bungee.api.ChatColor asBungee() {
            return net.md_5.bungee.api.ChatColor.BLUE;
        }
    },
    /**
     * <span style="color:#3ffe3f">绿色: <span style="background:#3ffe3f"> 绿色 </span></span>
     */
    GREEN('a', 0xA) {
        @NotNull
        @Override
        public net.md_5.bungee.api.ChatColor asBungee() {
            return net.md_5.bungee.api.ChatColor.GREEN;
        }
    },
    /**
     * <span style="color:#3dffff">淡蓝: <span style="background:#3dffff"> 淡蓝 </span></span>
     */
    AQUA('b', 0xB) {
        @NotNull
        @Override
        public net.md_5.bungee.api.ChatColor asBungee() {
            return net.md_5.bungee.api.ChatColor.AQUA;
        }
    },
    /**
     * <span style="color:#fd3f3f">红色: <span style="background:#fd3f3f"> 红色 </span></span>
     */
    RED('c', 0xC) {
        @NotNull
        @Override
        public net.md_5.bungee.api.ChatColor asBungee() {
            return net.md_5.bungee.api.ChatColor.RED;
        }
    },
    /**
     * <span style="color:#fe3ffe">紫色: <span style="background:#fe3ffe"> 紫色 </span></span>
     */
    LIGHT_PURPLE('d', 0xD) {
        @NotNull
        @Override
        public net.md_5.bungee.api.ChatColor asBungee() {
            return net.md_5.bungee.api.ChatColor.LIGHT_PURPLE;
        }
    },
    /**
     * <span style="color:#fefe3e">黄色: <span style="background:#fefe3e"> 黄色 </span></span>
     */
    YELLOW('e', 0xE) {
        @NotNull
        @Override
        public net.md_5.bungee.api.ChatColor asBungee() {
            return net.md_5.bungee.api.ChatColor.YELLOW;
        }
    },
    /**
     * <span style="color:#000000">白色: <span style="background:#ffffff;color:#ffffff"> 白色 </span></span>
     */
    WHITE('f', 0xF) {
        @NotNull
        @Override
        public net.md_5.bungee.api.ChatColor asBungee() {
            return net.md_5.bungee.api.ChatColor.WHITE;
        }
    },
    /**
     * 随机字符(聊天不可用)
     */
    MAGIC('k', 0x10, true) {
        @NotNull
        @Override
        public net.md_5.bungee.api.ChatColor asBungee() {
            return net.md_5.bungee.api.ChatColor.MAGIC;
        }
    },
    /**
     * 粗体: <b> 粗体 </b>
     */
    BOLD('l', 0x11, true) {
        @NotNull
        @Override
        public net.md_5.bungee.api.ChatColor asBungee() {
            return net.md_5.bungee.api.ChatColor.BOLD;
        }
    },
    /**
     * 删除线: <span style="text-decoration:line-through"> 删除线 </span>
     */
    STRIKETHROUGH('m', 0x12, true) {
        @NotNull
        @Override
        public net.md_5.bungee.api.ChatColor asBungee() {
            return net.md_5.bungee.api.ChatColor.STRIKETHROUGH;
        }
    },
    /**
     * 下划线: <u> 下划线 </u>
     */
    UNDERLINE('n', 0x13, true) {
        @NotNull
        @Override
        public net.md_5.bungee.api.ChatColor asBungee() {
            return net.md_5.bungee.api.ChatColor.UNDERLINE;
        }
    },
    /**
     * 斜体: <i> 斜体 </i>
     */
    ITALIC('o', 0x14, true) {
        @NotNull
        @Override
        public net.md_5.bungee.api.ChatColor asBungee() {
            return net.md_5.bungee.api.ChatColor.ITALIC;
        }
    },
    /**
     * 重置字体颜色以及效果
     */
    RESET('r', 0x15) {
        @NotNull
        @Override
        public net.md_5.bungee.api.ChatColor asBungee() {
            return net.md_5.bungee.api.ChatColor.RESET;
        }
    };

    /**
     * 所有聊天颜色代码的特殊字符前辍.如果你需要动态转换您自定义格式的颜色代码，请使用这个.
     */
    public static final char COLOR_CHAR = '\u00A7';
    private static final Pattern STRIP_COLOR_PATTERN = Pattern.compile("(?i)" + String.valueOf(COLOR_CHAR) + "[0-9A-FK-ORX]");

    private final int intCode;
    private final char code;
    private final boolean isFormat;
    private final String toString;
    private static final Map<Integer, ChatColor> BY_ID = Maps.newHashMap();
    private static final Map<Character, ChatColor> BY_CHAR = Maps.newHashMap();

    private ChatColor(char code, int intCode) {
        this(code, intCode, false);
    }

    private ChatColor(char code, int intCode, boolean isFormat) {
        this.code = code;
        this.intCode = intCode;
        this.isFormat = isFormat;
        this.toString = new String(new char[] {COLOR_CHAR, code});
    }

    @NotNull
    public net.md_5.bungee.api.ChatColor asBungee() {
        return net.md_5.bungee.api.ChatColor.RESET;
    };

    /**
     * 获取与此颜色或格式关联的单个字符. 
     * <p>
     * 原文:Gets the char value associated with this color
     *
     * @return 与此颜色或者格式关联的单个字符.
     */
    public char getChar() {
        return code;
    }

    @NotNull
    @Override
    public String toString() {
        return toString;
    }

    /**
     * 检测这个代码是否为格式代码，而不是颜色代码.
     * <p>
     * 原文:Checks if this code is a format code as opposed to a color code.
     * 
     * @return 这个ChatColor对象是不是格式代码
     */
    public boolean isFormat() {
        return isFormat;
    }

    /**
     * 检测这个代码是否为颜色代码，而不是格式代码.
     * <p>
     * 原文:Checks if this code is a color code as opposed to a format code.
     * 
     * @return 这个ChatColor对象是不是颜色代码
     */
    public boolean isColor() {
        return !isFormat && this != RESET;
    }

    /**
     * 获取指定的颜色代码代表的颜色或格式.
     * <p>
     * 原文:Gets the color represented by the specified color code
     *
     * @param code 要检测的代码
     * @return 与给定代码相关联的{@link org.bukkit.ChatColor}，如果不存在则为null
     */
    @Nullable
    public static ChatColor getByChar(char code) {
        return BY_CHAR.get(code);
    }

    /**
     * 获取指定的颜色代码代表的颜色或格式.
     * <p>
     * 原文:Gets the color represented by the specified color code
     *
     * @param code 要检测的代码
     * @return 与给定代码相关联的{@link org.bukkit.ChatColor}，如果不存在则为null
     */
    @Nullable
    public static ChatColor getByChar(@NotNull String code) {
        Validate.notNull(code, "Code cannot be null");
        Validate.isTrue(code.length() > 0, "Code must have at least one char");

        return BY_CHAR.get(code.charAt(0));
    }

    /**
     * 去除给定消息的所有颜色代码.
     * <p>
     * 原文:Strips the given message of all color codes
     *
     * @param input 要去除颜色的字符串
     * @return 没有颜色代码的字符串副本
     */
    @Contract("!null -> !null; null -> null")
    @Nullable
    public static String stripColor(@Nullable final String input) {
        if (input == null) {
            return null;
        }

        return STRIP_COLOR_PATTERN.matcher(input).replaceAll("");
    }

    /**
     * 转换交替的颜色代码字符到内部的ChatColor.COLOR_CHAR颜色代码字符.如果它后面紧跟着的是0-9, A-F, a-f, K-O, k-o, R 或 r，其它的颜色代码只会被替换.
     * <p>
     * 译注:这个方法是用来把其他的颜色代码替换成Minecraft本身的.比如我们在Minecraft服务器聊天时，为了输入方便，就使用"{@literal &}"来替换"§"，服务器要处理这种消息时就要用到本方法.
     * <p>
     * 范例:<code>System.out.println(translateAlternateColorCodes('{@literal &}', "{@literal &}cred{@literal &}agreen{@literal &}9blue"));</code>这段代码会把"{@literal &}cred{@literal &}agreen{@literal &}9blue"替换成"§cred§agreen§9blue"，"§"是ChatColor.COLOR_CHAR的默认值.
     * <p>
     * 原文:Translates a string using an alternate color code character into a
     * string that uses the internal ChatColor.COLOR_CODE color code
     * character. The alternate color code character will only be replaced if
     * it is immediately followed by 0-9, A-F, a-f, K-O, k-o, R or r.
     *
     * @param altColorChar 要替换的其他颜色代码.比如:{@literal &}
     * @param textToTranslate 包含了其他颜色代码的字符
     * @return 包含了ChatColor.COLOR_CHAR颜色代码字符的文本
     */
    @NotNull
    public static String translateAlternateColorCodes(char altColorChar, @NotNull String textToTranslate) {
        Validate.notNull(textToTranslate, "Cannot translate null text");

        char[] b = textToTranslate.toCharArray();
        for (int i = 0; i < b.length - 1; i++) {
            if (b[i] == altColorChar && "0123456789AaBbCcDdEeFfKkLlMmNnOoRrXx".indexOf(b[i + 1]) > -1) {
                b[i] = ChatColor.COLOR_CHAR;
                b[i + 1] = Character.toLowerCase(b[i + 1]);
            }
        }
        return new String(b);
    }

    /**
     * 获取字符串中最后一个颜色代码.也就是字符串结尾的颜色.
     * <p>
     * 原文:Gets the ChatColors used at the end of the given input string.
     *
     * @param input 要检索颜色的字符串
     * @return 传递到下一行的任何剩余的聊天颜色(不懂...总之是给定字符串最后出现的颜色代码)
     */
    @NotNull
    public static String getLastColors(@NotNull String input) {
        Validate.notNull(input, "Cannot get last colors from null text");

        String result = "";
        int length = input.length();

        // Search backwards from the end as it is faster
        for (int index = length - 1; index > -1; index--) {
            char section = input.charAt(index);
            if (section == COLOR_CHAR && index < length - 1) {
                char c = input.charAt(index + 1);
                ChatColor color = getByChar(c);

                if (color != null) {
                    result = color.toString() + result;

                    // Once we find a color or reset we can stop searching
                    if (color.isColor() || color.equals(RESET)) {
                        break;
                    }
                }
            }
        }

        return result;
    }

    static {
        for (ChatColor color : values()) {
            BY_ID.put(color.intCode, color);
            BY_CHAR.put(color.code, color);
        }
    }
}
