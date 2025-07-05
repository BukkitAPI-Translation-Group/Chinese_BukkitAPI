package org.bukkit.block;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表有锁的方块 (通常是容器类方块).
 * 当锁激活时, 开锁时需要物品名与钥匙相符的物品.
 */
public interface Lockable {

    /**
     * 检测容器是否有一个有效的(非空的)钥匙.
     * <p>
     * 原文:Checks if the container has a valid (non empty) key.
     *
     * @return 是否有有效的钥匙
     */
    boolean isLocked();

    /**
     * 获取访问此容器所需的钥匙.
     * <p>
     * 原文:Gets the key needed to access the container.
     *
     * @return 所需的钥匙 (或者称为密钥、钥匙的物品名)
     * @deprecated 锁不一定只是字符串
     */
    @NotNull
    @Deprecated(since = "1.21.2")
    String getLock();

    /**
     * 设置访问此容器所需的钥匙. 设为 null 或空字符串以移除钥匙.
     * <p>
     * 原文:Sets the key required to access this container. Set to null (or empty
     * string) to remove key.
     *
     * @param key 所需的钥匙
     * @deprecated 锁不一定只是字符串
     */
    @Deprecated(since = "1.21.2")
    void setLock(@Nullable String key);

    /**
     * Sets the key required to access this container. All explicit
     * modifications to the set key will be required to match on the opening
     * key. Set to null to remove key.
     *
     * @param key the key required to access the container.
     */
    @ApiStatus.Experimental
    void setLockItem(@Nullable ItemStack key);
}
