package org.bukkit.persistence;

import org.jetbrains.annotations.NotNull;

/**
 * 此类表示一个具有泛型内容类型的枚举。它定义了自定义标签可以具有的类型。
 * <p>
 * 此接口可用于创建您自己的具有不同复杂类型的自定义 {@link PersistentDataType}。这对于 UUIDTagType 等可能很有用：
 * <pre>
 * {@code
 * public class UUIDTagType implements PersistentDataType<byte[], UUID> {
 *
 *         @Override
 *         public Class<byte[]> getPrimitiveType() {
 *             return byte[].class;
 *         }
 *
 *         @Override
 *         public Class<UUID> getComplexType() {
 *             return UUID.class;
 *         }
 *
 *         @Override
 *         public byte[] toPrimitive(UUID complex, PersistentDataAdapterContext context) {
 *             ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
 *             bb.putLong(complex.getMostSignificantBits());
 *             bb.putLong(complex.getLeastSignificantBits());
 *             return bb.array();
 *         }
 *
 *         @Override
 *         public UUID fromPrimitive(byte[] primitive, PersistentDataAdapterContext context) {
 *             ByteBuffer bb = ByteBuffer.wrap(primitive);
 *             long firstLong = bb.getLong();
 *             long secondLong = bb.getLong();
 *             return new UUID(firstLong, secondLong);
 *         }
 *     }
 *}</pre>
 *
 * 任何插件拥有的此接口的实现都需要定义此接口中找到的现有原始类型之一。特别是 {@link #BOOLEAN} 不是原始类型，而是便捷类型。
 *
 * @param <P> 存储在给定标签中的主要对象类型
 * @param <C> 应用此标签类型时检索到的对象类型
 */
public interface PersistentDataType<P, C> {

    /*
        The primitive one value types.
     */
    PersistentDataType<Byte, Byte> BYTE = new PrimitivePersistentDataType<>(Byte.class);
    PersistentDataType<Short, Short> SHORT = new PrimitivePersistentDataType<>(Short.class);
    PersistentDataType<Integer, Integer> INTEGER = new PrimitivePersistentDataType<>(Integer.class);
    PersistentDataType<Long, Long> LONG = new PrimitivePersistentDataType<>(Long.class);
    PersistentDataType<Float, Float> FLOAT = new PrimitivePersistentDataType<>(Float.class);
    PersistentDataType<Double, Double> DOUBLE = new PrimitivePersistentDataType<>(Double.class);

    /*
        Boolean.
     */
    /**
     * 一个便捷实现，用于在 Byte 和 Boolean 之间转换，因为布尔值没有原生实现。<br>
     * 任何不等于 0 的字节值都被视为 true。
     */
    PersistentDataType<Byte, Boolean> BOOLEAN = new BooleanPersistentDataType();

    /*
        String.
     */
    PersistentDataType<String, String> STRING = new PrimitivePersistentDataType<>(String.class);

    /*
        Primitive Arrays.
     */
    PersistentDataType<byte[], byte[]> BYTE_ARRAY = new PrimitivePersistentDataType<>(byte[].class);
    PersistentDataType<int[], int[]> INTEGER_ARRAY = new PrimitivePersistentDataType<>(int[].class);
    PersistentDataType<long[], long[]> LONG_ARRAY = new PrimitivePersistentDataType<>(long[].class);

    /*
        Complex Arrays.
     */
    /**
     * @deprecated 使用 {@link #LIST} 的 {@link ListPersistentDataTypeProvider#dataContainers()} 代替，因为 {@link ListPersistentDataType} 提供对原始类型的完整支持，例如 {@link PersistentDataContainer}。
     */
    @Deprecated(since = "1.20.4")
    PersistentDataType<PersistentDataContainer[], PersistentDataContainer[]> TAG_CONTAINER_ARRAY = new PrimitivePersistentDataType<>(PersistentDataContainer[].class);

    /*
        Nested PersistentDataContainer.
     */
    PersistentDataType<PersistentDataContainer, PersistentDataContainer> TAG_CONTAINER = new PrimitivePersistentDataType<>(PersistentDataContainer.class);

    /**
     * 一个数据类型提供者类型，其本身不能用作 {@link PersistentDataType}。
     *
     * {@link ListPersistentDataTypeProvider} 暴露了共享的持久数据类型，用于存储其他数据类型的列表。
     * <p>
     * 它在 {@link PersistentDataType} 接口中的存在不允许 {@link java.util.List} 作为原始类型与普通的 {@link PersistentDataType} 结合使用。{@link java.util.List} 只有在通过 {@link ListPersistentDataType} 使用时才是有效的原始类型。
     *
     * @see ListPersistentDataTypeProvider
     */
    ListPersistentDataTypeProvider LIST = new ListPersistentDataTypeProvider();

    /**
     * 返回此标签的原始数据类型。
     * <p>
     * 原文：
     * Returns the primitive data type of this tag.
     *
     * @return 类
     */
    @NotNull
    Class<P> getPrimitiveType();

    /**
     * 返回原始值所代表的复杂对象类型。
     * <p>
     * 原文：
     * Returns the complex object type the primitive value resembles.
     *
     * @return 类类型
     */
    @NotNull
    Class<C> getComplexType();

    /**
     * 返回与此方法传递的复杂对象相似的原始数据。
     * <p>
     * 原文：
     * Returns the primitive data that resembles the complex object passed to
     * this method.
     *
     * @param complex 复杂对象实例
     * @param context 此操作运行的上下文
     * @return 原始值
     */
    @NotNull
    P toPrimitive(@NotNull C complex, @NotNull PersistentDataAdapterContext context);

    /**
     * 基于传递的原始值创建复杂对象。
     * <p>
     * 原文：
     * Creates a complex object based of the passed primitive value
     *
     * @param primitive 原始值
     * @param context 此操作运行的上下文
     * @return 复杂对象实例
     */
    @NotNull
    C fromPrimitive(@NotNull P primitive, @NotNull PersistentDataAdapterContext context);

    /**
     * 一个默认实现，仅用于将检索或插入的值传递到下一层。
     * <p>
     * 此实现不添加任何逻辑，而是用于为原始类型提供默认实现。
     *
     * @param <P> 原始对象的泛型类型
     */
    class PrimitivePersistentDataType<P> implements PersistentDataType<P, P> {

        private final Class<P> primitiveType;

        PrimitivePersistentDataType(@NotNull Class<P> primitiveType) {
            this.primitiveType = primitiveType;
        }

        @NotNull
        @Override
        public Class<P> getPrimitiveType() {
            return primitiveType;
        }

        @NotNull
        @Override
        public Class<P> getComplexType() {
            return primitiveType;
        }

        @NotNull
        @Override
        public P toPrimitive(@NotNull P complex, @NotNull PersistentDataAdapterContext context) {
            return complex;
        }

        @NotNull
        @Override
        public P fromPrimitive(@NotNull P primitive, @NotNull PersistentDataAdapterContext context) {
            return primitive;
        }
    }

    /**
     * 一个便捷实现，用于在 Byte 和 Boolean 之间转换，因为布尔值没有原生实现。<br>
     * 任何不等于 0 的字节值都被视为 true。
     */
    class BooleanPersistentDataType implements PersistentDataType<Byte, Boolean> {

        @NotNull
        @Override
        public Class<Byte> getPrimitiveType() {
            return Byte.class;
        }

        @NotNull
        @Override
        public Class<Boolean> getComplexType() {
            return Boolean.class;
        }

        @NotNull
        @Override
        public Byte toPrimitive(@NotNull Boolean complex, @NotNull PersistentDataAdapterContext context) {
            return (byte) (complex ? 1 : 0);
        }

        @NotNull
        @Override
        public Boolean fromPrimitive(@NotNull Byte primitive, @NotNull PersistentDataAdapterContext context) {
            return primitive != 0;
        }
    }
}