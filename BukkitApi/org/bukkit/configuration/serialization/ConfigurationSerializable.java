package org.bukkit.configuration.serialization;

import java.util.Map;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一个可序列化的对象。
 * <p>
 * 除了本接口定义的方法外，这些对象还必须实现以下之一：
 * <ul>
 * <li>一个名为 "deserialize" 的静态方法，接受单个 {@link Map}&lt;
 * {@link String}, {@link Object}&gt; 并返回该类的实例。</li>
 * <li>一个名为 "valueOf" 的静态方法，接受单个 {@link Map}&lt;{@link
 * String}, {@link Object}&gt; 并返回该类的实例。</li>
 * <li>一个接受单个 {@link Map}&lt;{@link String},
 * {@link Object}&gt; 的构造函数。</li>
 * </ul>
 * 除了实现此接口外，你还必须通过
 * {@link ConfigurationSerialization#registerClass(Class)} 注册该类。
 *
 * @see DelegateDeserialization
 * @see SerializableAs
 */
public interface ConfigurationSerializable {

    /**
     * 创建此类的 Map 表示。
     * <p>
     * 此类必须提供一个方法来恢复此类，具体定义见
     * {@link ConfigurationSerializable} 接口的 javadoc。
     *
     * <p>原文：Creates a Map representation of this class.
     * <p>This class must provide a method to restore this class, as defined in
     * the {@link ConfigurationSerializable} interface javadocs.
     *
     * @return 包含此类当前状态的 Map
     */
    @NotNull
    public Map<String, Object> serialize();
}
