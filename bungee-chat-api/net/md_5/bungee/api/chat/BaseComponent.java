package net.md_5.bungee.api.chat;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder.FormatRetention;

@Setter
@ToString(exclude = "parent")
@EqualsAndHashCode(exclude = "parent")
public abstract class BaseComponent
{

    @Setter(AccessLevel.NONE)
    BaseComponent parent;

    /**
     * 该组件及其子组件的颜色(除非子组件定义了自己的颜色覆盖母组件的颜色).
     */
    private ChatColor color;
    /**
     * 该组件及其子组件的字体(除非子组件定义了自己的字体覆盖母组件的字体).
     */
    private String font;
    /**
     * 该组件及其子组件是否加粗(子组件可定义它们各自的颜色及其格式来覆盖母组件的设定, 下同).
     */
    private Boolean bold;
    /**
     * 该组件及其子组件是否为斜体(可覆盖).
     */
    private Boolean italic;
    /**
     * 该组件及其子组件是否添加下划线(可覆盖).
     */
    private Boolean underlined;
    /**
     * 该组件及其子组件是否添加删除线(可覆盖).
     */
    private Boolean strikethrough;
    /**
     * 该组件及其子组件是否为随机字符(可覆盖).
     */
    private Boolean obfuscated;
    /**
     * 当按住shift键点击此组件(包含子组件)时, 向聊天消息输入框插入的文本.
     */
    @Getter
    private String insertion;

    /**
     * 继承该组件的格式和事件的附加组件.
     */
    @Getter
    private List<BaseComponent> extra;

    /**
     * 当此组件(含子组件)被点击时执行的动作.
     */
    @Getter
    private ClickEvent clickEvent;
    /**
     * 当鼠标光标悬浮在此组件(含子组件)时执行的动作.
     */
    @Getter
    private HoverEvent hoverEvent;

    /**
     * 默认构造器.
     *
     * @deprecated 仅供内部使用, 将被移除
     */
    @Deprecated
    public BaseComponent()
    {
    }

    BaseComponent(BaseComponent old)
    {
        copyFormatting( old, FormatRetention.ALL, true );

        if ( old.getExtra() != null )
        {
            for ( BaseComponent extra : old.getExtra() )
            {
                addExtra( extra.duplicate() );
            }
        }
    }

    /**
     * 复制指定 BaseComponent 的事件和格式. 已设置的格式将被替换.
     * <p>
     * 原文:Copies the events and formatting of a BaseComponent. Already set
     * formatting will be replaced.
     *
     * @param component 要复制的组件
     */
    public void copyFormatting(BaseComponent component)
    {
        copyFormatting( component, FormatRetention.ALL, true );
    }

    /**
     * 复制指定 BaseComponent 的事件和格式.
     * <p>
     * 原文:Copies the events and formatting of a BaseComponent.
     *
     * @param component 要复制的组件
     * @param replace 已设置的格式是否被新的组件替换
     */
    public void copyFormatting(BaseComponent component, boolean replace)
    {
        copyFormatting( component, FormatRetention.ALL, replace );
    }

    /**
     * 复制某个 BaseComponent 中的指定格式.
     * <p>
     * 原文:Copies the specified formatting of a BaseComponent.
     *
     * @param component 要复制的组件
     * @param retention 要复制的格式
     * @param replace 已设置的格式是否被新的组件替换
     */
    public void copyFormatting(BaseComponent component, FormatRetention retention, boolean replace)
    {
        if ( retention == FormatRetention.EVENTS || retention == FormatRetention.ALL )
        {
            if ( replace || clickEvent == null )
            {
                setClickEvent( component.getClickEvent() );
            }
            if ( replace || hoverEvent == null )
            {
                setHoverEvent( component.getHoverEvent() );
            }
        }
        if ( retention == FormatRetention.FORMATTING || retention == FormatRetention.ALL )
        {
            if ( replace || color == null )
            {
                setColor( component.getColorRaw() );
            }
            if ( replace || font == null )
            {
                setFont( component.getFontRaw() );
            }
            if ( replace || bold == null )
            {
                setBold( component.isBoldRaw() );
            }
            if ( replace || italic == null )
            {
                setItalic( component.isItalicRaw() );
            }
            if ( replace || underlined == null )
            {
                setUnderlined( component.isUnderlinedRaw() );
            }
            if ( replace || strikethrough == null )
            {
                setStrikethrough( component.isStrikethroughRaw() );
            }
            if ( replace || obfuscated == null )
            {
                setObfuscated( component.isObfuscatedRaw() );
            }
            if ( replace || insertion == null )
            {
                setInsertion( component.getInsertion() );
            }
        }
    }

    /**
     * 仅保留指定的格式.
     * <p>
     * 原文:Retains only the specified formatting.
     *
     * @param retention 要保留的格式
     */
    public void retain(FormatRetention retention)
    {
        if ( retention == FormatRetention.FORMATTING || retention == FormatRetention.NONE )
        {
            setClickEvent( null );
            setHoverEvent( null );
        }
        if ( retention == FormatRetention.EVENTS || retention == FormatRetention.NONE )
        {
            setColor( null );
            setBold( null );
            setItalic( null );
            setUnderlined( null );
            setStrikethrough( null );
            setObfuscated( null );
            setInsertion( null );
        }
    }

    /**
     * 克隆本组件并返回克隆副本.
     * <p>
     * 原文:Clones the BaseComponent and returns the clone.
     *
     * @return 该组件的副本
     */
    public abstract BaseComponent duplicate();

    /**
     * 克隆本组件并返回克隆副本, 不保留原副本的格式.
     * <p>
     * 原文:Clones the BaseComponent without formatting and returns the clone.
     *
     * @return 该组件的副本
     * @deprecated 不鼓励使用本 API, 建议使用传统克隆副本 
     */
    @Deprecated
    public BaseComponent duplicateWithoutFormatting()
    {
        BaseComponent component = duplicate();
        component.retain( FormatRetention.NONE );
        return component;
    }

    /**
     * 将聊天组件转化为颜色代码文本.
     * <p>
     * 原文:Converts the components to a string that uses the old formatting codes
     * ({@link net.md_5.bungee.api.ChatColor#COLOR_CHAR}
     *
     * @param components 要转化的组件
     * @return 旧版颜色代码文本
     */
    public static String toLegacyText(BaseComponent... components)
    {
        StringBuilder builder = new StringBuilder();
        for ( BaseComponent msg : components )
        {
            builder.append( msg.toLegacyText() );
        }
        return builder.toString();
    }

    /**
     * 将聊天组件转化为字符串, 丢弃所有格式.
     * <p>
     * 原文:Converts the components into a string without any formatting
     *
     * @param components 要转化的组件
     * @return 纯文本
     */
    public static String toPlainText(BaseComponent... components)
    {
        StringBuilder builder = new StringBuilder();
        for ( BaseComponent msg : components )
        {
            builder.append( msg.toPlainText() );
        }
        return builder.toString();
    }

    /**
     * Returns the color of this component. This uses the parent's color if this
     * component doesn't have one. {@link net.md_5.bungee.api.ChatColor#WHITE}
     * is returned if no color is found.
     *
     * @return the color of this component
     */
    public ChatColor getColor()
    {
        if ( color == null )
        {
            if ( parent == null )
            {
                return ChatColor.WHITE;
            }
            return parent.getColor();
        }
        return color;
    }

    /**
     * Returns the color of this component without checking the parents color.
     * May return null
     *
     * @return the color of this component
     */
    public ChatColor getColorRaw()
    {
        return color;
    }

    /**
     * Returns the font of this component. This uses the parent's font if this
     * component doesn't have one.
     *
     * @return the font of this component, or null if default font
     */
    public String getFont()
    {
        if ( font == null )
        {
            if ( parent == null )
            {
                return null;
            }
            return parent.getFont();
        }
        return font;
    }

    /**
     * Returns the font of this component without checking the parents font. May
     * return null
     *
     * @return the font of this component
     */
    public String getFontRaw()
    {
        return font;
    }

    /**
     * Returns whether this component is bold. This uses the parent's setting if
     * this component hasn't been set. false is returned if none of the parent
     * chain has been set.
     *
     * @return whether the component is bold
     */
    public boolean isBold()
    {
        if ( bold == null )
        {
            return parent != null && parent.isBold();
        }
        return bold;
    }

    /**
     * Returns whether this component is bold without checking the parents
     * setting. May return null
     *
     * @return whether the component is bold
     */
    public Boolean isBoldRaw()
    {
        return bold;
    }

    /**
     * Returns whether this component is italic. This uses the parent's setting
     * if this component hasn't been set. false is returned if none of the
     * parent chain has been set.
     *
     * @return whether the component is italic
     */
    public boolean isItalic()
    {
        if ( italic == null )
        {
            return parent != null && parent.isItalic();
        }
        return italic;
    }

    /**
     * Returns whether this component is italic without checking the parents
     * setting. May return null
     *
     * @return whether the component is italic
     */
    public Boolean isItalicRaw()
    {
        return italic;
    }

    /**
     * Returns whether this component is underlined. This uses the parent's
     * setting if this component hasn't been set. false is returned if none of
     * the parent chain has been set.
     *
     * @return whether the component is underlined
     */
    public boolean isUnderlined()
    {
        if ( underlined == null )
        {
            return parent != null && parent.isUnderlined();
        }
        return underlined;
    }

    /**
     * Returns whether this component is underlined without checking the parents
     * setting. May return null
     *
     * @return whether the component is underlined
     */
    public Boolean isUnderlinedRaw()
    {
        return underlined;
    }

    /**
     * Returns whether this component is strikethrough. This uses the parent's
     * setting if this component hasn't been set. false is returned if none of
     * the parent chain has been set.
     *
     * @return whether the component is strikethrough
     */
    public boolean isStrikethrough()
    {
        if ( strikethrough == null )
        {
            return parent != null && parent.isStrikethrough();
        }
        return strikethrough;
    }

    /**
     * Returns whether this component is strikethrough without checking the
     * parents setting. May return null
     *
     * @return whether the component is strikethrough
     */
    public Boolean isStrikethroughRaw()
    {
        return strikethrough;
    }

    /**
     * Returns whether this component is obfuscated. This uses the parent's
     * setting if this component hasn't been set. false is returned if none of
     * the parent chain has been set.
     *
     * @return whether the component is obfuscated
     */
    public boolean isObfuscated()
    {
        if ( obfuscated == null )
        {
            return parent != null && parent.isObfuscated();
        }
        return obfuscated;
    }

    /**
     * Returns whether this component is obfuscated without checking the parents
     * setting. May return null
     *
     * @return whether the component is obfuscated
     */
    public Boolean isObfuscatedRaw()
    {
        return obfuscated;
    }

    public void setExtra(List<BaseComponent> components)
    {
        for ( BaseComponent component : components )
        {
            component.parent = this;
        }
        extra = components;
    }

    /**
     * Appends a text element to the component. The text will inherit this
     * component's formatting
     *
     * @param text the text to append
     */
    public void addExtra(String text)
    {
        addExtra( new TextComponent( text ) );
    }

    /**
     * Appends a component to the component. The text will inherit this
     * component's formatting
     *
     * @param component the component to append
     */
    public void addExtra(BaseComponent component)
    {
        if ( extra == null )
        {
            extra = new ArrayList<BaseComponent>();
        }
        component.parent = this;
        extra.add( component );
    }

    /**
     * Returns whether the component has any formatting or events applied to it
     *
     * @return Whether any formatting or events are applied
     */
    public boolean hasFormatting()
    {
        return color != null || font != null || bold != null
                || italic != null || underlined != null
                || strikethrough != null || obfuscated != null
                || insertion != null || hoverEvent != null || clickEvent != null;
    }

    /**
     * Converts the component into a string without any formatting
     *
     * @return the string as plain text
     */
    public String toPlainText()
    {
        StringBuilder builder = new StringBuilder();
        toPlainText( builder );
        return builder.toString();
    }

    void toPlainText(StringBuilder builder)
    {
        if ( extra != null )
        {
            for ( BaseComponent e : extra )
            {
                e.toPlainText( builder );
            }
        }
    }

    /**
     * Converts the component to a string that uses the old formatting codes
     * ({@link net.md_5.bungee.api.ChatColor#COLOR_CHAR}
     *
     * @return the string in the old format
     */
    public String toLegacyText()
    {
        StringBuilder builder = new StringBuilder();
        toLegacyText( builder );
        return builder.toString();
    }

    void toLegacyText(StringBuilder builder)
    {
        if ( extra != null )
        {
            for ( BaseComponent e : extra )
            {
                e.toLegacyText( builder );
            }
        }
    }

    void addFormat(StringBuilder builder)
    {
        builder.append( getColor() );
        if ( isBold() )
        {
            builder.append( ChatColor.BOLD );
        }
        if ( isItalic() )
        {
            builder.append( ChatColor.ITALIC );
        }
        if ( isUnderlined() )
        {
            builder.append( ChatColor.UNDERLINE );
        }
        if ( isStrikethrough() )
        {
            builder.append( ChatColor.STRIKETHROUGH );
        }
        if ( isObfuscated() )
        {
            builder.append( ChatColor.MAGIC );
        }
    }
}
