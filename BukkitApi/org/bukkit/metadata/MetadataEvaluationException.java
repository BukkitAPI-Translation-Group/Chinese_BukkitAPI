package org.bukkit.metadata;

/**
 * 当{@link LazyMetadataValue}由于异常而无法求值时, 会抛出此异常.
 * 原始异常将作为此异常的原因被包含.
 */
@SuppressWarnings("serial")
public class MetadataEvaluationException extends RuntimeException {
    MetadataEvaluationException(Throwable cause) {
        super(cause);
    }
}
