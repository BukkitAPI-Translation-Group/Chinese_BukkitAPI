package org.bukkit;

/**
 * 表示爆炸的结果。
 */
public enum ExplosionResult {

    /**
     * 表示未发生任何变化的爆炸。
     *
     * 当 {@link org.bukkit.GameRule#MOB_GRIEFING} 被禁用时会出现此情况。
     */
    KEEP,
    /**
     * 表示所有被破坏的方块都会掉落物品的爆炸。
     *
     * 当 {@link org.bukkit.GameRule#TNT_EXPLOSION_DROP_DECAY} 或
     * {@link org.bukkit.GameRule#BLOCK_EXPLOSION_DROP_DECAY} 被禁用时会出现此情况。
     */
    DESTROY,
    /**
     * 表示爆炸仅导致部分方块掉落的爆炸。
     */
    DESTROY_WITH_DECAY,
    /**
     * 表示已发生方块变化/更新的爆炸。
     *
     * 例如，使用风弹时会导致附近的按钮、拉杆和钟被激活。
     */
    TRIGGER_BLOCK
}
