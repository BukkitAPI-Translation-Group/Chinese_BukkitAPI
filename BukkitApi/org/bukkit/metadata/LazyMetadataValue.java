package org.bukkit.metadata;

import com.google.common.base.Preconditions;
import java.lang.ref.SoftReference;
import java.util.concurrent.Callable;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * LazyMetadataValue类实现了一种在另一个插件请求之前不会计算的元数据类型.
 * <p>
 * 通过使元数据值变为惰性, 提供插件在绝对必要之前不会进行计算.
 * 此外, LazyMetadataValue对象在内部缓存其值, 除非被{@link CacheStrategy}覆盖或在个体或插件级别被无效化.
 * 一旦被无效化, LazyMetadataValue将在被请求时重新计算其值.
 */
public class LazyMetadataValue extends MetadataValueAdapter {
    private Callable<Object> lazyValue;
    private CacheStrategy cacheStrategy;
    private SoftReference<Object> internalValue;
    private static final Object ACTUALLY_NULL = new Object();

    /**
     * 使用默认的CACHE_AFTER_FIRST_EVAL缓存策略初始化LazyMetadataValue对象.
     * <p>
     * 原文：
     * Initialized a LazyMetadataValue object with the default
     * CACHE_AFTER_FIRST_EVAL cache strategy.
     *
     * @param owningPlugin 创建此元数据值的{@link Plugin}.
     * @param lazyValue 分配给此元数据值的惰性值.
     */
    public LazyMetadataValue(@NotNull Plugin owningPlugin, @NotNull Callable<Object> lazyValue) {
        this(owningPlugin, CacheStrategy.CACHE_AFTER_FIRST_EVAL, lazyValue);
    }

    /**
     * 使用特定缓存策略初始化LazyMetadataValue对象.
     * <p>
     * 原文：
     * Initializes a LazyMetadataValue object with a specific cache strategy.
     *
     * @param owningPlugin 创建此元数据值的{@link Plugin}.
     * @param cacheStrategy 确定此元数据值的缓存规则.
     * @param lazyValue 分配给此元数据值的惰性值.
     */
    public LazyMetadataValue(@NotNull Plugin owningPlugin, @NotNull CacheStrategy cacheStrategy, @NotNull Callable<Object> lazyValue) {
        super(owningPlugin);
        Preconditions.checkArgument(cacheStrategy != null, "cacheStrategy cannot be null");
        Preconditions.checkArgument(lazyValue != null, "lazyValue cannot be null");
        this.internalValue = new SoftReference<Object>(null);
        this.lazyValue = lazyValue;
        this.cacheStrategy = cacheStrategy;
    }

    /**
     * 受保护的特殊构造函数, 由FixedMetadataValue用于绕过标准设置.
     * <p>
     * 原文：
     * Protected special constructor used by FixedMetadataValue to bypass
     * standard setup.
     *
     * @param owningPlugin 拥有插件
     */
    protected LazyMetadataValue(@NotNull Plugin owningPlugin) {
        super(owningPlugin);
    }

    @Override
    @Nullable
    public Object value() {
        eval();
        Object value = internalValue.get();
        if (value == ACTUALLY_NULL) {
            return null;
        }
        return value;
    }

    /**
     * 惰性求值此元数据项的值.
     * <p>
     * 原文：
     * Lazily evaluates the value of this metadata item.
     *
     * @throws MetadataEvaluationException 如果计算元数据值失败.
     */
    private synchronized void eval() throws MetadataEvaluationException {
        if (cacheStrategy == CacheStrategy.NEVER_CACHE || internalValue.get() == null) {
            try {
                Object value = lazyValue.call();
                if (value == null) {
                    value = ACTUALLY_NULL;
                }
                internalValue = new SoftReference<Object>(value);
            } catch (Exception e) {
                throw new MetadataEvaluationException(e);
            }
        }
    }

    @Override
    public synchronized void invalidate() {
        if (cacheStrategy != CacheStrategy.CACHE_ETERNALLY) {
            internalValue.clear();
        }
    }

    /**
     * 描述元数据的可能缓存策略.
     */
    public enum CacheStrategy {
        /**
         * 元数据值被求值后, 在手动无效化之前不会重新求值.
         */
        CACHE_AFTER_FIRST_EVAL,

        /**
         * 每次请求时重新求值元数据项.
         */
        NEVER_CACHE,

        /**
         * 元数据值被求值后, 即使手动无效化也不会重新求值.
         */
        CACHE_ETERNALLY
    }
}
