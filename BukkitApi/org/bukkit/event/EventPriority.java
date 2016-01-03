package org.bukkit.event;

/**
 * 代表一个事件的优先级。
 * 译注：经过测试,正确的优先级排序如下(由高到低)：
 * <ol>
 * <li>LOWEST</li>
 * <li>LOW</li>
 * <li>NORMAL</li>
 * <li>HIGH</li>
 * <li>HIGHEST</li>
 * <li>MONITOR</li>
 * </ol>
 * 不要被下面的翻译和本身的意思给骗了.
 * @see EventHandler
 */
public enum EventPriority {

    /**
     * 事件中调用的重要性非常低,并且应该首先运行,允许其他插件以进一步自定义结果
     */
    LOWEST(0),
    /**
     * 事件中调用的重要性比较低
     */
    LOW(1),
    /**
     * 事件中调用的重要性一般
     * 
     */
    NORMAL(2),
    /**
     * 事件中调用的重要性比较高
     */
    HIGH(3),
    /**
     * 事件将变得非常重要，在这个事件发生什么都必须由这个事件决定
     */
    HIGHEST(4),
    /**
     * 没有修改的事件的优先级应该比这个低
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