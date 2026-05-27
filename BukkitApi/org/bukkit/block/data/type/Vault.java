package org.bukkit.block.data.type;

import org.bukkit.block.data.Directional;
import org.jetbrains.annotations.NotNull;

/**
 * 'vault_state' 表示宝库方块当前的运行阶段.
 * <br>
 * 'ominous' 表示方块是否具有不祥效果.
 */
public interface Vault extends Directional {

    /**
     * 获取 'vault_state' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'vault_state' property.
     *
     * @return 'vault_state' 的值
     */
    @NotNull
    State getVaultState();

    /**
     * 获取 'vault_state' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'vault_state' property.
     *
     * @return 'vault_state' 的值
     * @deprecated 参见 {@link #getVaultState()}
     */
    @Deprecated(since = "1.21.3", forRemoval = true)
    @NotNull
    State getTrialSpawnerState();

    /**
     * 设置 'vault_state' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'vault_state' property.
     *
     * @param state 新的 'vault_state' 值
     */
    void setVaultState(@NotNull State state);

    /**
     * 设置 'vault_state' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'vault_state' property.
     *
     * @param state 新的 'vault_state' 值
     * @deprecated 参见 {@link #setVaultState(State)}
     */
    @Deprecated(since = "1.21.3", forRemoval = true)
    void setTrialSpawnerState(@NotNull State state);

    /**
     * 获取 'ominous' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'ominous' property.
     *
     * @return 'ominous' 的值
     */
    boolean isOminous();

    /**
     * 设置 'ominous' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'ominous' property.
     *
     * @param ominous 新的 'ominous' 值
     */
    void setOminous(boolean ominous);

    public enum State {

        INACTIVE,
        ACTIVE,
        UNLOCKING,
        EJECTING
    }
}
