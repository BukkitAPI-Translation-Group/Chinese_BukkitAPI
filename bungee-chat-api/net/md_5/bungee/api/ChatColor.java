package net.md_5.bungee.api;

import com.google.common.base.Preconditions;
import java.awt.Color;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;
import lombok.Getter;

/**
 * 聊天消息所有支持的颜色.
 */
public final class ChatColor
{

    /**
     * 所有聊天颜色代码的特殊字符前辍.如果你需要动态转换您自定义格式的颜色代码，请使用这个.
     */
    public static final char COLOR_CHAR = '\u00A7';
    public static final String ALL_CODES = "0123456789AaBbCcDdEeFfKkLlMmNnOoRrXx";
    /**
     * 用于移除所有颜色代码的正则表达式
     */
    public static final Pattern STRIP_COLOR_PATTERN = Pattern.compile( "(?i)" + String.valueOf( COLOR_CHAR ) + "[0-9A-FK-ORX]" );
    /**
     * 以颜色代码为键的所有活跃的颜色实例.
     */
    private static final Map<Character, ChatColor> BY_CHAR = new HashMap<Character, ChatColor>();
    /**
     * 以颜色名称为键的所有颜色实例.
     */
    private static final Map<String, ChatColor> BY_NAME = new HashMap<String, ChatColor>();
    /**
     * <span style="color:#000000">黑色: <span style="background:#000000"> 黑色 </span></span>
     */
    public static final ChatColor BLACK = new ChatColor( '0', "black", new Color( 0x000000 ) );
    /**
     * <span style="color:#0000be">深蓝: <span style="background:#0000be"> 深蓝 </span></span>
     */
    public static final ChatColor DARK_BLUE = new ChatColor( '1', "dark_blue", new Color( 0x0000AA ) );
    /**
     * <span style="color:#00bf00">深绿: <span style="background:#00bf00"> 深绿 </span></span>
     */
    public static final ChatColor DARK_GREEN = new ChatColor( '2', "dark_green", new Color( 0x00AA00 ) );
    /**
     * <span style="color:#00bebe">深蓝: <span style="background:#00bebe"> 深蓝 </span></span>
     */
    public static final ChatColor DARK_AQUA = new ChatColor( '3', "dark_aqua", new Color( 0x00AAAA ) );
    /**
     * <span style="color:#be0000">深红: <span style="background:#be0000"> 深红 </span></span>
     */
    public static final ChatColor DARK_RED = new ChatColor( '4', "dark_red", new Color( 0xAA0000 ) );
    /**
     * <span style="color:#be00be">深紫: <span style="background:#be00be"> 深紫 </span></span>
     */
    public static final ChatColor DARK_PURPLE = new ChatColor( '5', "dark_purple", new Color( 0xAA00AA ) );
    /**
     * <span style="color:#d8a333">橙色: <span style="background:#d8a333"> 橙色 </span></span>
     */
    public static final ChatColor GOLD = new ChatColor( '6', "gold", new Color( 0xFFAA00 ) );
    /**
     * <span style="color:#bebebe">灰色: <span style="background:#bebebe"> 灰色 </span></span>
     */
    public static final ChatColor GRAY = new ChatColor( '7', "gray", new Color( 0xAAAAAA ) );
    /**
     * <span style="color:#3f3f3f">深灰: <span style="background:#3f3f3f"> 深灰 </span></span>
     */
    public static final ChatColor DARK_GRAY = new ChatColor( '8', "dark_gray", new Color( 0x555555 ) );
    /**
     * <span style="color:#3f40fd">蓝色: <span style="background:#3f40fd"> 蓝色 </span></span>
     */
    public static final ChatColor BLUE = new ChatColor( '9', "blue", new Color( 0x5555FF ) );
    /**
     * <span style="color:#3ffe3f">绿色: <span style="background:#3ffe3f"> 绿色 </span></span>
     */
    public static final ChatColor GREEN = new ChatColor( 'a', "green", new Color( 0x55FF55 ) );
    /**
     * <span style="color:#3dffff">淡蓝: <span style="background:#3dffff"> 淡蓝 </span></span>
     */
    public static final ChatColor AQUA = new ChatColor( 'b', "aqua", new Color( 0x55FFFF ) );
    /**
     * <span style="color:#fd3f3f">红色: <span style="background:#fd3f3f"> 红色 </span></span>
     */
    public static final ChatColor RED = new ChatColor( 'c', "red", new Color( 0xFF5555 ) );
    /**
     * <span style="color:#fe3ffe">紫色: <span style="background:#fe3ffe"> 紫色 </span></span>
     */
    public static final ChatColor LIGHT_PURPLE = new ChatColor( 'd', "light_purple", new Color( 0xFF55FF ) );
    /**
     * <span style="color:#fefe3e">黄色: <span style="background:#fefe3e"> 黄色 </span></span>
     */
    public static final ChatColor YELLOW = new ChatColor( 'e', "yellow", new Color( 0xFFFF55 ) );
    /**
     * <span style="color:#000000">白色: <span style="background:#ffffff;color:#ffffff"> 白色 </span></span>
     */
    public static final ChatColor WHITE = new ChatColor( 'f', "white", new Color( 0xFFFFFF ) );
    /**
     * 随机字符(聊天不可用)
     */
    public static final ChatColor MAGIC = new ChatColor( 'k', "obfuscated" );
    /**
     * 粗体: <b> 粗体 </b>
     */
    public static final ChatColor BOLD = new ChatColor( 'l', "bold" );
    /**
     * 删除线: <span style="text-decoration:line-through"> 删除线 </span>
     */
    public static final ChatColor STRIKETHROUGH = new ChatColor( 'm', "strikethrough" );
    /**
     * 下划线: <u> 下划线 </u>
     */
    public static final ChatColor UNDERLINE = new ChatColor( 'n', "underline" );
    /**
     * 斜体: <i> 斜体 </i>
     */
    public static final ChatColor ITALIC = new ChatColor( 'o', "italic" );
    /**
     * 重置字体颜色以及效果
     */
    public static final ChatColor RESET = new ChatColor( 'r', "reset" );
    /**
     * Count used for populating legacy ordinal.
     */
    private static int count = 0;
    /**
     * 带{@link #COLOR_CHAR}前缀的颜色代码.
     */
    private final String toString;
    @Getter
    private final String name;
    private final int ordinal;
    /**
     * 此ChatColor的RGB颜色. null表示无颜色(formatting)
     */
    @Getter
    private final Color color;

    private ChatColor(char code, String name)
    {
        this( code, name, null );
    }

    private ChatColor(char code, String name, Color color)
    {
        this.name = name;
        this.toString = new String( new char[]
        {
            COLOR_CHAR, code
        } );
        this.ordinal = count++;
        this.color = color;

        BY_CHAR.put( code, this );
        BY_NAME.put( name.toUpperCase( Locale.ROOT ), this );
    }

    private ChatColor(String name, String toString, int rgb)
    {
        this.name = name;
        this.toString = toString;
        this.ordinal = -1;
        this.color = new Color( rgb );
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode( this.toString );
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null || getClass() != obj.getClass() )
        {
            return false;
        }
        final ChatColor other = (ChatColor) obj;

        return Objects.equals( this.toString, other.toString );
    }

    @Override
    public String toString()
    {
        return toString;
    }

    /**
     * 去除给定消息的所有颜色代码.
     * <p>
     * 原文:Strips the given message of all color codes
     *
     * @param input 要去除颜色的字符串
     * @return 没有颜色代码的字符串副本
     */
    public static String stripColor(final String input)
    {
        if ( input == null )
        {
            return null;
        }

        return STRIP_COLOR_PATTERN.matcher( input ).replaceAll( "" );
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
    public static String translateAlternateColorCodes(char altColorChar, String textToTranslate)
    {
        char[] b = textToTranslate.toCharArray();
        for ( int i = 0; i < b.length - 1; i++ )
        {
            if ( b[i] == altColorChar && ALL_CODES.indexOf( b[i + 1] ) > -1 )
            {
                b[i] = ChatColor.COLOR_CHAR;
                b[i + 1] = Character.toLowerCase( b[i + 1] );
            }
        }
        return new String( b );
    }

    /**
     * 获取指定的颜色代码代表的颜色或格式.
     * <p>
     * 原文:Get the colour represented by the specified code.
     *
     * @param code 要检测的代码
     * @return 与给定代码相关联的{@link org.bukkit.ChatColor}，如果不存在则为null
     */
    public static ChatColor getByChar(char code)
    {
        return BY_CHAR.get( code );
    }

    public static ChatColor of(Color color)
    {
        return of( "#" + String.format( "%08x", color.getRGB() ).substring( 2 ) );
    }

    public static ChatColor of(String string)
    {
        Preconditions.checkArgument( string != null, "string cannot be null" );
        if ( string.startsWith( "#" ) && string.length() == 7 )
        {
            int rgb;
            try
            {
                rgb = Integer.parseInt( string.substring( 1 ), 16 );
            } catch ( NumberFormatException ex )
            {
                throw new IllegalArgumentException( "Illegal hex string " + string );
            }

            StringBuilder magic = new StringBuilder( COLOR_CHAR + "x" );
            for ( char c : string.substring( 1 ).toCharArray() )
            {
                magic.append( COLOR_CHAR ).append( c );
            }

            return new ChatColor( string, magic.toString(), rgb );
        }

        ChatColor defined = BY_NAME.get( string.toUpperCase( Locale.ROOT ) );
        if ( defined != null )
        {
            return defined;
        }

        throw new IllegalArgumentException( "Could not parse ChatColor " + string );
    }

    /**
     * 另请参见 {@link Enum#valueOf(java.lang.Class, java.lang.String)}.
     *
     * @param name 颜色名
     * @return ChatColor
     * @deprecated holdover from when this class was an enum
     */
    @Deprecated
    public static ChatColor valueOf(String name)
    {
        Preconditions.checkNotNull( name, "Name is null" );

        ChatColor defined = BY_NAME.get( name );
        Preconditions.checkArgument( defined != null, "No enum constant " + ChatColor.class.getName() + "." + name );

        return defined;
    }

    /**
    * 获取包含所有已定义的颜色和格式的数组.
     * <p>
     * 原文:Get an array of all defined colors and formats.
     *
     * @return 所有颜色和格式的数组的副本
     * @deprecated holdover from when this class was an enum
     */
    @Deprecated
    public static ChatColor[] values()
    {
        return BY_CHAR.values().toArray( new ChatColor[ 0 ] );
    }

    /**
     * 另请参见 {@link Enum#name()}.
     *
     * @return 常量名
     * @deprecated holdover from when this class was an enum
     */
    @Deprecated
    public String name()
    {
        return getName().toUpperCase( Locale.ROOT );
    }

    /**
     * 另请参见 {@link Enum#ordinal()}.
     *
     * @return 颜色代码序数
     * @deprecated holdover from when this class was an enum
     */
    @Deprecated
    public int ordinal()
    {
        Preconditions.checkArgument( ordinal >= 0, "Cannot get ordinal of hex color" );
        return ordinal;
    }
}
