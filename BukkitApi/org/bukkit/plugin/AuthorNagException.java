package org.bukkit.plugin;

@SuppressWarnings("serial")
public class AuthorNagException extends RuntimeException {
    private final String message;

    /**
     * 构建一个新的 AuthorNagException 类型错误 基于所给异常.
     * <p>
     * 原文:Constructs a new AuthorNagException based on the given Exception
     *
     * @param message 对该错误的简要说明
     */
    public AuthorNagException(final String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
