package org.bukkit.util.io;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
/**
 * 这个类旨在被用于连接到{@link ConfigurationSerializable}的API。
 * 它把对象转化为一个内部的实现，为了之后反序列化使用{@link BukkitObjectInputStream}。
 * <p>
 * 原文：This class is designed to be used in conjunction with the {@link
 * ConfigurationSerializable} API. It translates objects to an internal
 * implementation for later deserialization using {@link
 * BukkitObjectInputStream}.
 * <p>
 * 直接继承实现这个类的语法可能在未来版本被取消。
 * <p>
 * 原文：Behavior of implementations extending this class is not guaranteed across
 * future versions.
 */
public class BukkitObjectOutputStream extends ObjectOutputStream {
    /**
     * 构造函数提供镜像连接父类的功能。
     * <p>
     * 原文：Constructor provided to mirror super functionality.
     *
     * @throws IOException 如果一个I/O连接在写出数据流的头数据时发生错误则抛出
     * @see ObjectOutputStream#ObjectOutputStream()
     */
    protected BukkitObjectOutputStream() throws IOException, SecurityException {
        super();
        super.enableReplaceObject(true);
    }
    /**
     * 输出流作为参数的构造函数
     * <p>
     * 原文：Object output stream decoration constructor.
     *
     * @param out OutputStream对象
     * @throws IOException 如果一个I/O连接在写出输出流的头数据时发生错误则抛出
     * @see ObjectOutputStream#ObjectOutputStream(OutputStream)
     */
    public BukkitObjectOutputStream(OutputStream out) throws IOException {
        super(out);
        super.enableReplaceObject(true);
    }
    @Override
    protected Object replaceObject(Object obj) throws IOException {
        if (!(obj instanceof Serializable) && (obj instanceof ConfigurationSerializable)) {
            obj = Wrapper.newWrapper((ConfigurationSerializable) obj);
        }
        return super.replaceObject(obj);
    }
}