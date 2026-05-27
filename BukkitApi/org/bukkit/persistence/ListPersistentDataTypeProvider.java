package org.bukkit.persistence;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/**
 * 列表持久数据类型的提供者，表示 {@link PersistentDataType} 暴露的已知原始类型。
 */
public final class ListPersistentDataTypeProvider {

    private static final ListPersistentDataType<Byte, Byte> BYTE = new ListPersistentDataTypeImpl<>(PersistentDataType.BYTE);
    private static final ListPersistentDataType<Short, Short> SHORT = new ListPersistentDataTypeImpl<>(PersistentDataType.SHORT);
    private static final ListPersistentDataType<Integer, Integer> INTEGER = new ListPersistentDataTypeImpl<>(PersistentDataType.INTEGER);
    private static final ListPersistentDataType<Long, Long> LONG = new ListPersistentDataTypeImpl<>(PersistentDataType.LONG);
    private static final ListPersistentDataType<Float, Float> FLOAT = new ListPersistentDataTypeImpl<>(PersistentDataType.FLOAT);
    private static final ListPersistentDataType<Double, Double> DOUBLE = new ListPersistentDataTypeImpl<>(PersistentDataType.DOUBLE);
    private static final ListPersistentDataType<Byte, Boolean> BOOLEAN = new ListPersistentDataTypeImpl<>(PersistentDataType.BOOLEAN);
    private static final ListPersistentDataType<String, String> STRING = new ListPersistentDataTypeImpl<>(PersistentDataType.STRING);
    private static final ListPersistentDataType<byte[], byte[]> BYTE_ARRAY = new ListPersistentDataTypeImpl<>(PersistentDataType.BYTE_ARRAY);
    private static final ListPersistentDataType<int[], int[]> INTEGER_ARRAY = new ListPersistentDataTypeImpl<>(PersistentDataType.INTEGER_ARRAY);
    private static final ListPersistentDataType<long[], long[]> LONG_ARRAY = new ListPersistentDataTypeImpl<>(PersistentDataType.LONG_ARRAY);
    private static final ListPersistentDataType<PersistentDataContainer, PersistentDataContainer> DATA_CONTAINER = new ListPersistentDataTypeImpl<>(
            PersistentDataType.TAG_CONTAINER
    );

    ListPersistentDataTypeProvider() {
    }

    /**
     * 提供一个共享的 {@link ListPersistentDataType}，能够存储字节列表。
     * <p>
     * 原文：
     * Provides a shared {@link ListPersistentDataType} that is capable of
     * storing lists of bytes.
     *
     * @return 持久数据类型。
     */
    @NotNull
    public ListPersistentDataType<Byte, Byte> bytes() {
        return BYTE;
    }

    /**
     * 提供一个共享的 {@link ListPersistentDataType}，能够存储短整型列表。
     * <p>
     * 原文：
     * Provides a shared {@link ListPersistentDataType} that is capable of
     * storing lists of shorts.
     *
     * @return 持久数据类型。
     */
    @NotNull
    public ListPersistentDataType<Short, Short> shorts() {
        return SHORT;
    }

    /**
     * 提供一个共享的 {@link ListPersistentDataType}，能够存储整数列表。
     * <p>
     * 原文：
     * Provides a shared {@link ListPersistentDataType} that is capable of
     * storing lists of integers.
     *
     * @return 持久数据类型。
     */
    @NotNull
    public ListPersistentDataType<Integer, Integer> integers() {
        return INTEGER;
    }

    /**
     * 提供一个共享的 {@link ListPersistentDataType}，能够存储长整型列表。
     * <p>
     * 原文：
     * Provides a shared {@link ListPersistentDataType} that is capable of
     * storing lists of longs.
     *
     * @return 持久数据类型。
     */
    @NotNull
    public ListPersistentDataType<Long, Long> longs() {
        return LONG;
    }

    /**
     * 提供一个共享的 {@link ListPersistentDataType}，能够存储浮点数列表。
     * <p>
     * 原文：
     * Provides a shared {@link ListPersistentDataType} that is capable of
     * storing lists of floats.
     *
     * @return 持久数据类型。
     */
    @NotNull
    public ListPersistentDataType<Float, Float> floats() {
        return FLOAT;
    }

    /**
     * 提供一个共享的 {@link ListPersistentDataType}，能够存储双精度浮点数列表。
     * <p>
     * 原文：
     * Provides a shared {@link ListPersistentDataType} that is capable of
     * storing lists of doubles.
     *
     * @return 持久数据类型。
     */
    @NotNull
    public ListPersistentDataType<Double, Double> doubles() {
        return DOUBLE;
    }

    /**
     * 提供一个共享的 {@link ListPersistentDataType}，能够存储布尔值列表。
     * <p>
     * 原文：
     * Provides a shared {@link ListPersistentDataType} that is capable of
     * storing lists of booleans.
     *
     * @return 持久数据类型。
     */
    @NotNull
    public ListPersistentDataType<Byte, Boolean> booleans() {
        return BOOLEAN;
    }

    /**
     * 提供一个共享的 {@link ListPersistentDataType}，能够存储字符串列表。
     * <p>
     * 原文：
     * Provides a shared {@link ListPersistentDataType} that is capable of
     * storing lists of strings.
     *
     * @return 持久数据类型。
     */
    @NotNull
    public ListPersistentDataType<String, String> strings() {
        return STRING;
    }

    /**
     * 提供一个共享的 {@link ListPersistentDataType}，能够存储字节数组列表。
     * <p>
     * 原文：
     * Provides a shared {@link ListPersistentDataType} that is capable of
     * storing lists of byte arrays.
     *
     * @return 持久数据类型。
     */
    @NotNull
    public ListPersistentDataType<byte[], byte[]> byteArrays() {
        return BYTE_ARRAY;
    }

    /**
     * 提供一个共享的 {@link ListPersistentDataType}，能够存储整数数组列表。
     * <p>
     * 原文：
     * Provides a shared {@link ListPersistentDataType} that is capable of
     * storing lists of int arrays.
     *
     * @return 持久数据类型。
     */
    @NotNull
    public ListPersistentDataType<int[], int[]> integerArrays() {
        return INTEGER_ARRAY;
    }

    /**
     * 提供一个共享的 {@link ListPersistentDataType}，能够存储长整型数组列表。
     * <p>
     * 原文：
     * Provides a shared {@link ListPersistentDataType} that is capable of
     * storing lists of long arrays.
     *
     * @return 持久数据类型。
     */
    @NotNull
    public ListPersistentDataType<long[], long[]> longArrays() {
        return LONG_ARRAY;
    }

    /**
     * 提供一个共享的 {@link ListPersistentDataType}，能够存储持久数据容器。
     * <p>
     * 原文：
     * Provides a shared {@link ListPersistentDataType} that is capable of
     * persistent data containers..
     *
     * @return 持久数据类型。
     */
    @NotNull
    public ListPersistentDataType<PersistentDataContainer, PersistentDataContainer> dataContainers() {
        return DATA_CONTAINER;
    }

    /**
     * 给定任何用于其元素的持久数据类型，构造一个新的列表持久数据类型。
     * <p>
     * 原文：
     * Constructs a new list persistent data type given any persistent data type
     * for its elements.
     *
     * @param elementType 能够写入/读取列表元素的持久数据类型。
     * @param <P> 存储在列表中的原始类型的通用类型。
     * @param <C> 持久数据类型产生的复杂值的通用类型。
     * @return 创建的列表持久数据类型。
     */
    @NotNull
    public <P, C> ListPersistentDataType<P, C> listTypeFrom(@NotNull final PersistentDataType<P, C> elementType) {
        return new ListPersistentDataTypeImpl<>(elementType);
    }

    /**
     * {@link ListPersistentDataType} 的私有实现，使用 {@link Collections2} 进行原始列表的转换。
     *
     * @param <P> 存储在列表中的原始类型的通用类型。
     * @param <C> 持久数据类型产生的复杂值的通用类型。
     */
    private static final class ListPersistentDataTypeImpl<P, C> implements ListPersistentDataType<P, C> {

        @NotNull
        private final PersistentDataType<P, C> innerType;

        private ListPersistentDataTypeImpl(@NotNull final PersistentDataType<P, C> innerType) {
            this.innerType = innerType;
        }

        @NotNull
        @Override
        @SuppressWarnings("unchecked")
        public Class<List<P>> getPrimitiveType() {
            return (Class<List<P>>) (Object) List.class;
        }

        @NotNull
        @Override
        @SuppressWarnings("unchecked")
        public Class<List<C>> getComplexType() {
            return (Class<List<C>>) (Object) List.class;
        }

        @NotNull
        @Override
        public List<P> toPrimitive(@NotNull final List<C> complex, @NotNull final PersistentDataAdapterContext context) {
            return Lists.transform(complex, s -> innerType.toPrimitive(s, context));
        }

        @NotNull
        @Override
        public List<C> fromPrimitive(@NotNull final List<P> primitive, @NotNull final PersistentDataAdapterContext context) {
            return Lists.transform(primitive, s -> innerType.fromPrimitive(s, context));
        }

        @NotNull
        @Override
        public PersistentDataType<P, C> elementType() {
            return this.innerType;
        }
    }
}
