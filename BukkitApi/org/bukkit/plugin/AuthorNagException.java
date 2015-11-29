package org.bukkit.plugin;

@SuppressWarnings("serial")
public class AuthorNagException extends RuntimeException {
    private final String message;

    /**
     * 基于所给异常来构建一个新的AuthorNagException类型错误.
     * <p>
     * 原文:Constructs a new AuthorNagException based on the given Exception
     *
     * @param message 该错误原因的简要信息
     */
    public AuthorNagException(final String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}