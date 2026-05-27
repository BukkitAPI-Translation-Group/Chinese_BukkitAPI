package org.bukkit.metadata;

/**
 * 当{@link LazyMetadataValue}尝试将元数据值转换为不适当的数据类型时, 会抛出此异常.
 */
@SuppressWarnings("serial")
public class MetadataConversionException extends RuntimeException {
    MetadataConversionException(String message) {
        super(message);
    }
}
