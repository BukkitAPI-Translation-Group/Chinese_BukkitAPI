package org.bukkit.event;

public class EventException extends Exception {
    private static final long serialVersionUID = 3532808232324183999L;
    private final Throwable cause;

    /**
     * 在给定的异常的基础上构建个新的EventException
     *
     * @param throwable 此异常被触发
     */
    public EventException(Throwable throwable) {
        cause = throwable;
    }

    /**
     * 构建个新的EventException
     */
    public EventException() {
        cause = null;
    }

    /**
     * 在给定的信息的基础上构建个新的EventException
     *
     * @param cause 因为什么触发此异常
     * @param message 信息
     */
    public EventException(Throwable cause, String message) {
        super(message);
        this.cause = cause;
    }

    /**
     * 在给定的信息的基础上构建个新的EventException
     *
     * @param message 信息
     */
    public EventException(String message) {
        super(message);
        cause = null;
    }

    /**
     * 如果适用，就会返回触发这个异常的异常
     *
     * @return 内部异常, 找不到返回null
     */
    @Override
    public Throwable getCause() {
        return cause;
    }
}
