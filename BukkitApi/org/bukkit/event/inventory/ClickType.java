package org.bukkit.event.inventory;

/**
 * 客户端是怎样触发这个动作的(非动作的结果)
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
     * 在物品栏界面的灰色区域单机鼠标左键
     */
    WINDOW_BORDER_LEFT,
    /**
     * 在物品栏界面的灰色区域单机鼠标右键
     */
    WINDOW_BORDER_RIGHT,
    /**
     * 鼠标中键(或滚轮按键)
     */
    MIDDLE,
    /**
     * 数字键1-9，对应快捷栏的物品槽
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
     * 创造模式物品栏的任何动作
     */
    CREATIVE,
    /**
     * 无法被Bukkit解析的物品栏操作类型
     * <p>
     * 这个按键类型仅出现在Minecraft的版本过渡期，且不应该被依赖
     * <p>
     * 任何对 ClickType.UNKNOWN 的调用都是在最努力的基础上的
     */
    UNKNOWN,
    ;

    /**
     * 判断这个按键类型是否为键盘按键.
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
     * 判断这个按键类型是否只能在创造模式被执行.
     * <p>
     * 原文：Gets whether this ClickType represents an action that can only be
     * performed by a Player in creative mode.
     *
     * @return 如果这个按键类型要求玩家处在创造模式则返回true，否则返回false
     */
    public boolean isCreativeAction() {
        // Why use middle click?
        return (this == ClickType.MIDDLE) || (this == ClickType.CREATIVE);
    }

    /**
     * 判断这个按键类型是否使用了右键.
     * <p>
     * 原文：Gets whether this ClickType represents a right click.
     *
     * @return 如果这个按键类型使用了右键则返回true，否则返回false
     */
    public boolean isRightClick() {
        return (this == ClickType.RIGHT) || (this == ClickType.SHIFT_RIGHT);
    }

    /**
     * 判断这个按键类型是否使用了左键.
     * <p>
     * 原文：Gets whether this ClickType represents a left click.
     *
     * @return 如果这个按键类型使用了左键则返回true，否则返回false
     */
    public boolean isLeftClick() {
        return (this == ClickType.LEFT) || (this == ClickType.SHIFT_LEFT) || (this == ClickType.DOUBLE_CLICK) || (this == ClickType.CREATIVE);
    }

    /**
     * 判断这个按键类型是否使用了Shift键.
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
