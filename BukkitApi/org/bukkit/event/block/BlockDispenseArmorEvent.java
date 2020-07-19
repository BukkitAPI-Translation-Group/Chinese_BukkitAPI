package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

/**
 * 当一个可装备物品从某个方块发射出来并装备到附近的实体上时触发本事件.
 * <p>
 * 如果本事件被取消, 那么装备将不会装备到目标实体上.
 */
public class BlockDispenseArmorEvent extends BlockDispenseEvent {

    private final LivingEntity target;

    public BlockDispenseArmorEvent(@NotNull Block block, @NotNull ItemStack dispensed, @NotNull LivingEntity target) {
        super(block, dispensed, new Vector(0, 0, 0));
        this.target = target;
    }

    /**
     * 获取盔甲装备给的目标生物.
     * <p>
     * 原文:Get the living entity on which the armor was dispensed.
     *
     * @return 目标实体
     */
    @NotNull
    public LivingEntity getTargetEntity() {
        return target;
    }
}
