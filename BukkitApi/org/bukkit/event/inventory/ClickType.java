package org.bukkit.event.inventory;

/**
 * 点击类型
 * <p>
 * 译注:定义了客户端点击物品栏的方式，位置等
 */
public enum ClickType {

    /**
     * 鼠标左键(或主键)
     */
    LEFT,
    /**
     * Shift+鼠标左键
     */
    SHIFT_LEFT,
    /**
     * 鼠标右键
     */
    RIGHT,
    /**
     * Shift+鼠标右键
     */
    SHIFT_RIGHT,
    /**
     * 在物品栏界面的<b>“灰色区域”</b>单击鼠标左键
     * <p>
     * 译注:“灰色区域”指Minecraft窗口范围内<b>超出物品栏范围</b>的部分
     */
    WINDOW_BORDER_LEFT,
    /**
     * 在物品栏界面的<s>灰色区域</s>单击鼠标右键
     * <p>
     * 译注:<s>灰色区域</s>指Minecraft窗口范围内<s>超出物品栏范围</s>的部分
     */
    WINDOW_BORDER_RIGHT,
    /**
     * 鼠标中键(或鼠标滚轮按键)
     */
    MIDDLE,
    /**
     * 数字键1-9，对应快捷栏的物品槽
     * <p>
     * 译注: 该数字键指主键盘的数字键, 而非小键盘的数字键
     */
    NUMBER_KEY,
    /**
     * 双击鼠标左键
     */
    DOUBLE_CLICK,
    /**
     * 丢弃物品键(默认为Q)
     */
    DROP,
    /**
     * Ctrl+丢弃物品键(默认为Q)
     */
    CONTROL_DROP,
    /**
     * 创造模式物品栏的任何点击操作
     */
    CREATIVE,
    /**
     * 无法被Bukkit解析的物品栏点击类型. 
     * <p>
     * 这个按键类型仅出现在Minecraft的版本过渡期, 且不应该被依赖. <br>
     * 任何对 ClickType.UNKNOWN 的调用都是在最努力的基础上的.
     * <p>
     * 译注:一般只在支持最新快照版本的插件中才可能需要使用
     */
    UNKNOWN,
    ;

    /**
     * 判断这个按键类型是否为键盘按键. 
     * <p>
     * 译注: 键盘按键包括:
     * <ul>
     * <li>{@link #NUMBER_KEY 数字键}</li>
     * <li>{@link #DROP 丢弃物品键}</li>
     * <li>{@link #CONTROL_DROP Ctrl+丢弃物品键}</li>
     * </ul>
     * <p>
     * 原文：Gets whether this ClickType represents the pressing of a key on a
     * keyboard.
     * 
     * @return 如果这个按键类型为键盘按键则返回true，否则返回false
     */
    public boolean isKeyboardClick() {
        return (this == ClickType.NUMBER_KEY) || (this == ClickType.DROP) || (this == ClickType.CONTROL_DROP);
    }

    /**
     * 判断这个按键类型所定义的操作是否只能在创造模式被执行. 
     * <p>
     * 译注: 只有创造模式有效的按键类型包括:
     * <ul>
     * <li>{@link #MIDDLE 鼠标中键}</li>
     * <li>{@link #CREATIVE 创造模式物品栏的任何点击操作}</li>
     * </ul>
     * <p>
     * 原文：Gets whether this ClickType represents an action that can only be
     * performed by a Player in creative mode.
     * 
     * @return 如果这个按键类型要求玩家处在创造模式则返回true，否则返回false
     */
    public boolean isCreativeAction() {
        // Why use middle click?
        // <s>译注</s>译回答: 创造模式可以用鼠标中键可以将玩家所对的方块对应的物品复制到快捷栏.
        return (this == ClickType.MIDDLE) || (this == ClickType.CREATIVE);
    }

    /**
     * 判断这个按键类型是否使用了鼠标右键. 
     * <p>
     * 译注: 使用了鼠标右键的按键类型包括:
     * <ul>
     * <li>{@link #RIGHT 鼠标右键}</li>
     * <li>{@link #SHIFT_RIGHT Shift+鼠标右键}</li>
     * </ul>
     * <p>
     * 原文：Gets whether this ClickType represents a right click.
     * 
     * @return 如果这个按键类型使用了鼠标右键则返回true，否则返回false
     */
    public boolean isRightClick() {
        return (this == ClickType.RIGHT) || (this == ClickType.SHIFT_RIGHT);
    }

    /**
     * 判断这个按键类型是否使用了鼠标左键.
     * <p>
     * 译注: 使用了鼠标左键的按键类型包括:
     * <ul>
     * <li>{@link #LEFT 鼠标左键}</li>
     * <li>{@link #SHIFT_LEFT Shift+鼠标左键}</li>
     * <li>{@link #DOUBLE_CLICK 双击鼠标左键}</li>
     * <li>{@link #CREATIVE 创造模式物品栏的任何点击操作}</li>
     * </ul>
     * <p>
     * 原文：Gets whether this ClickType represents a left click.
     * 
     * @return 如果这个按键类型使用了鼠标左键则返回true，否则返回false
     */
    public boolean isLeftClick() {
        return (this == ClickType.LEFT) || (this == ClickType.SHIFT_LEFT) || (this == ClickType.DOUBLE_CLICK) || (this == ClickType.CREATIVE);
    }

    /**
     * 判断这个按键类型是否使用了Shift键.
     * <p>
     * 译注: 使用了Shift键的按键类型包括:
     * <ul>
     * <li>{@link #SHIFT_LEFT Shift+鼠标左键}</li>
     * <li>{@link #SHIFT_RIGHT Shift+鼠标右键}</li>
     * <li><b>{@link #CONTROL_DROP Ctrl+丢弃物品键}(<i>暂不知为何要将此按键类型判断为使用了Shift键</i>)</b></li>
     * </ul>>
     * <p>
     * 原文：Gets whether this ClickType indicates that the shift key was pressed
     * down when the click was made.
     *
     * @return 如果这个按键类型使用了Shift键则返回true，否则返回false
     */
    public boolean isShiftClick() {
        return (this == ClickType.SHIFT_LEFT) || (this == ClickType.SHIFT_RIGHT) || (this == ClickType.CONTROL_DROP);
    }
}
