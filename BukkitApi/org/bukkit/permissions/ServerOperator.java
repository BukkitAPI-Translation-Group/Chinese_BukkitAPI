package org.bukkit.permissions;

import org.bukkit.entity.Player;

/**
 * 代表一个对象,可能为一个OP,例如一个{@link Player}.
 * <p>
 * 原文:Represents an object that may become a server operator, such as a {@link
 * Player}
 */
public interface ServerOperator {

    /**
     * 检查该对象是否为OP.
     * <p>
     * 原文:Checks if this object is a server operator
     *
     * @return 如果为OP则返回true, 否则返回false
     */
    public boolean isOp();

    /**
     * 设置此对象的op状态.
     * <p>
     * 原文:Sets the operator status of this object
     *
     * @param value 新op的值(布尔值)
     */
    public void setOp(boolean value);
}