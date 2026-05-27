package org.bukkit.configuration.serialization;

import com.google.common.base.Preconditions;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.spawner.SpawnRule;
import org.bukkit.configuration.Configuration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.util.BlockVector;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 用于在 {@link Configuration} 中存储和检索类的工具类.
 */
public class ConfigurationSerialization {
    public static final String SERIALIZED_TYPE_KEY = "==";
    private final Class<? extends ConfigurationSerializable> clazz;
    private static Map<String, Class<? extends ConfigurationSerializable>> aliases = new HashMap<String, Class<? extends ConfigurationSerializable>>();

    static {
        registerClass(Vector.class);
        registerClass(BlockVector.class);
        registerClass(ItemStack.class);
        registerClass(Color.class);
        registerClass(PotionEffect.class);
        registerClass(FireworkEffect.class);
        registerClass(Pattern.class);
        registerClass(Location.class);
        registerClass(AttributeModifier.class);
        registerClass(BoundingBox.class);
        registerClass(SpawnRule.class);
    }

    protected ConfigurationSerialization(@NotNull Class<? extends ConfigurationSerializable> clazz) {
        this.clazz = clazz;
    }

    @Nullable
    protected Method getMethod(@NotNull String name, boolean isStatic) {
        try {
            Method method = clazz.getDeclaredMethod(name, Map.class);

            if (!ConfigurationSerializable.class.isAssignableFrom(method.getReturnType())) {
                return null;
            }
            if (Modifier.isStatic(method.getModifiers()) != isStatic) {
                return null;
            }

            return method;
        } catch (NoSuchMethodException ex) {
            return null;
        } catch (SecurityException ex) {
            return null;
        }
    }

    @Nullable
    protected Constructor<? extends ConfigurationSerializable> getConstructor() {
        try {
            return clazz.getConstructor(Map.class);
        } catch (NoSuchMethodException ex) {
            return null;
        } catch (SecurityException ex) {
            return null;
        }
    }

    @Nullable
    protected ConfigurationSerializable deserializeViaMethod(@NotNull Method method, @NotNull Map<String, ?> args) {
        try {
            ConfigurationSerializable result = (ConfigurationSerializable) method.invoke(null, args);

            if (result == null) {
                Logger.getLogger(ConfigurationSerialization.class.getName()).log(Level.SEVERE, "Could not call method '" + method.toString() + "' of " + clazz + " for deserialization: method returned null");
            } else {
                return result;
            }
        } catch (Throwable ex) {
            Logger.getLogger(ConfigurationSerialization.class.getName()).log(
                    Level.SEVERE,
                    "Could not call method '" + method.toString() + "' of " + clazz + " for deserialization",
                    ex instanceof InvocationTargetException ? ex.getCause() : ex);
        }

        return null;
    }

    @Nullable
    protected ConfigurationSerializable deserializeViaCtor(@NotNull Constructor<? extends ConfigurationSerializable> ctor, @NotNull Map<String, ?> args) {
        try {
            return ctor.newInstance(args);
        } catch (Throwable ex) {
            Logger.getLogger(ConfigurationSerialization.class.getName()).log(
                    Level.SEVERE,
                    "Could not call constructor '" + ctor.toString() + "' of " + clazz + " for deserialization",
                    ex instanceof InvocationTargetException ? ex.getCause() : ex);
        }

        return null;
    }

    @Nullable
    public ConfigurationSerializable deserialize(@NotNull Map<String, ?> args) {
        Preconditions.checkArgument(args != null, "Args must not be null");

        ConfigurationSerializable result = null;
        Method method = null;

        if (result == null) {
            method = getMethod("deserialize", true);

            if (method != null) {
                result = deserializeViaMethod(method, args);
            }
        }

        if (result == null) {
            method = getMethod("valueOf", true);

            if (method != null) {
                result = deserializeViaMethod(method, args);
            }
        }

        if (result == null) {
            Constructor<? extends ConfigurationSerializable> constructor = getConstructor();

            if (constructor != null) {
                result = deserializeViaCtor(constructor, args);
            }
        }

        return result;
    }

    /**
     * 尝试将给定的参数反序列化为给定类的新实例.
     * <p>
     * 该类必须实现 {@link ConfigurationSerializable}, 包括 ConfigurationSerializable javadoc 中指定的额外方法.
     * <p>
     * 如果无法创建新实例 (例如类未完全实现接口), 则返回 null.
     * <p>
     * 原文：
     * Attempts to deserialize the given arguments into a new instance of the
     * given class.
     * <p>
     * The class must implement {@link ConfigurationSerializable}, including
     * the extra methods as specified in the javadoc of
     * ConfigurationSerializable.
     * <p>
     * If a new instance could not be made, an example being the class not
     * fully implementing the interface, null will be returned.
     *
     * @param args 反序列化的参数.
     * @param clazz 要反序列化为的类.
     * @return 指定类的新实例.
     */
    @Nullable
    public static ConfigurationSerializable deserializeObject(@NotNull Map<String, ?> args, @NotNull Class<? extends ConfigurationSerializable> clazz) {
        return new ConfigurationSerialization(clazz).deserialize(args);
    }

    /**
     * 尝试将给定的参数反序列化为给定类的新实例.
     * <p>
     * 该类必须实现 {@link ConfigurationSerializable}, 包括 ConfigurationSerializable javadoc 中指定的额外方法.
     * <p>
     * 如果无法创建新实例 (例如类未完全实现接口), 则返回 null.
     * <p>
     * 原文：
     * Attempts to deserialize the given arguments into a new instance of the
     * given class.
     * <p>
     * The class must implement {@link ConfigurationSerializable}, including
     * the extra methods as specified in the javadoc of
     * ConfigurationSerializable.
     * <p>
     * If a new instance could not be made, an example being the class not
     * fully implementing the interface, null will be returned.
     *
     * @param args 反序列化的参数.
     * @return 指定类的新实例.
     */
    @Nullable
    public static ConfigurationSerializable deserializeObject(@NotNull Map<String, ?> args) {
        Class<? extends ConfigurationSerializable> clazz = null;

        if (args.containsKey(SERIALIZED_TYPE_KEY)) {
            try {
                String alias = (String) args.get(SERIALIZED_TYPE_KEY);

                if (alias == null) {
                    throw new IllegalArgumentException("Cannot have null alias");
                }
                clazz = getClassByAlias(alias);
                if (clazz == null) {
                    throw new IllegalArgumentException("Specified class does not exist ('" + alias + "')");
                }
            } catch (ClassCastException ex) {
                ex.fillInStackTrace();
                throw ex;
            }
        } else {
            throw new IllegalArgumentException("Args doesn't contain type key ('" + SERIALIZED_TYPE_KEY + "')");
        }

        return new ConfigurationSerialization(clazz).deserialize(args);
    }

    /**
     * 按别名注册给定的 {@link ConfigurationSerializable} 类.
     * <p>
     * 原文：
     * Registers the given {@link ConfigurationSerializable} class by its alias
     *
     * @param clazz 要注册的类.
     */
    public static void registerClass(@NotNull Class<? extends ConfigurationSerializable> clazz) {
        DelegateDeserialization delegate = clazz.getAnnotation(DelegateDeserialization.class);

        if (delegate == null) {
            registerClass(clazz, getAlias(clazz));
            registerClass(clazz, clazz.getName());
        }
    }

    /**
     * 将给定别名注册到指定的 {@link ConfigurationSerializable} 类.
     * <p>
     * 原文：
     * Registers the given alias to the specified {@link
     * ConfigurationSerializable} class
     *
     * @param clazz 要注册的类.
     * @param alias 要注册的别名.
     * @see SerializableAs
     */
    public static void registerClass(@NotNull Class<? extends ConfigurationSerializable> clazz, @NotNull String alias) {
        aliases.put(alias, clazz);
    }

    /**
     * 注销指定的 {@link ConfigurationSerializable} 别名.
     * <p>
     * 原文：
     * Unregisters the specified alias to a {@link ConfigurationSerializable}
     *
     * @param alias 要注销的别名.
     */
    public static void unregisterClass(@NotNull String alias) {
        aliases.remove(alias);
    }

    /**
     * 注销指定 {@link ConfigurationSerializable} 类的所有别名.
     * <p>
     * 原文：
     * Unregisters any aliases for the specified {@link
     * ConfigurationSerializable} class
     *
     * @param clazz 要注销的类.
     */
    public static void unregisterClass(@NotNull Class<? extends ConfigurationSerializable> clazz) {
        while (aliases.values().remove(clazz)) {
            ;
        }
    }

    /**
     * 尝试通过别名获取已注册的 {@link ConfigurationSerializable} 类.
     * <p>
     * 原文：
     * Attempts to get a registered {@link ConfigurationSerializable} class by
     * its alias
     *
     * @param alias 可序列化对象的别名.
     * @return 已注册的类, 如果未找到则返回 null.
     */
    @Nullable
    public static Class<? extends ConfigurationSerializable> getClassByAlias(@NotNull String alias) {
        return aliases.get(alias);
    }

    /**
     * 获取给定 {@link ConfigurationSerializable} 类的正确别名.
     * <p>
     * 原文：
     * Gets the correct alias for the given {@link ConfigurationSerializable}
     * class
     *
     * @param clazz 要获取别名的类.
     * @return 该类使用的别名.
     */
    @NotNull
    public static String getAlias(@NotNull Class<? extends ConfigurationSerializable> clazz) {
        DelegateDeserialization delegate = clazz.getAnnotation(DelegateDeserialization.class);

        if (delegate != null) {
            if ((delegate.value() == null) || (delegate.value() == clazz)) {
                delegate = null;
            } else {
                return getAlias(delegate.value());
            }
        }

        if (delegate == null) {
            SerializableAs alias = clazz.getAnnotation(SerializableAs.class);

            if ((alias != null) && (alias.value() != null)) {
                return alias.value();
            }
        }

        return clazz.getName();
    }
}
