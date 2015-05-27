package org.bukkit.event;

/**
 * 代表一个事件的优先级。
 */
public enum EventPriority {

    /**
     * 事件中调用的重要性非常低 并且应该首先运行, 允许其他插件
     * 以进一步自定义结果。
     */
    LOWEST(0),
    /**
     * 事件中调用的重要性比较低
     */
    LOW(1),
    /**
     * 事件中调用的重要性一般（is neither important nor unimportant）, 
     * 
     */
    NORMAL(2),
    /**
     * 事件中调用的重要性比较高
     */
    HIGH(3),
    /**
     * 事件将变得非常重要，在这个事件发生什么都必须由这个事件
     * 决定。
     */
    HIGHEST(4),
    /**
     * 事件只用于监听事件的结果
     * <p>
     * 没有修改的事件的优先级应该比这个低才对嘛
     * 原：No modifications to the event should be made under this priority	 
     */
    MONITOR(5);

    private final int slot;

    private EventPriority(int slot) {
        this.slot = slot;
    }

    public int getSlot() {
        return slot;
    }
}
