package org.bukkit.util.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.ConfigurationSerialization;

/**
 * 这个类旨在用于与 {@link ConfigurationSerializable} API 一起使用.
 * 它将对象转换回被 {@link BukkitObjectInputStream} 序列化之前的原始表示.
 * <p>
 * 直接继承实现这个类的语法可能在未来版本被取消.
 * <p>
 * 原文:This class is designed to be used in conjunction with the {@link
 * ConfigurationSerializable} API. It translates objects back to their
 * original implementation after being serialized by {@link
 * BukkitObjectInputStream}.
 * Behavior of implementations extending this class is not guaranteed across
 * future versions.
 */
public class BukkitObjectInputStream extends ObjectInputStream {
    /**
     * 构造函数提供镜像连接父类的功能.
     * <p>
     * 原文:Constructor provided to mirror super functionality.
     *
     * @throws IOException 如果从输入流读取头数据时发生错误
     * @see ObjectInputStream#ObjectInputStream()
     */
    protected BukkitObjectInputStream() throws IOException, SecurityException {
        super();
        super.enableResolveObject(true);
    }
    /**
     * 输入流作为参数的构造函数.
     * <p>
     * 原文:Object input stream decoration constructor.
     *
     * @param in InputStream对象
     * @throws IOException 如果从输入流读取头数据时发生错误
     * @see ObjectInputStream#ObjectInputStream(InputStream)
     */
    public BukkitObjectInputStream(InputStream in) throws IOException {
        super(in);
        super.enableResolveObject(true);
    }
    @Override
    protected Object resolveObject(Object obj) throws IOException {
        if (obj instanceof Wrapper) {
            try {
                (obj = ConfigurationSerialization.deserializeObject(((Wrapper<?>) obj).map)).getClass(); // NPE
            } catch (Throwable ex) {
                throw newIOException("Failed to deserialize object", ex);
            }
        }
        return super.resolveObject(obj);
    }
    private static IOException newIOException(String string, Throwable cause) {
        IOException exception = new IOException(string);
        exception.initCause(cause);
        return exception;
    }
}
