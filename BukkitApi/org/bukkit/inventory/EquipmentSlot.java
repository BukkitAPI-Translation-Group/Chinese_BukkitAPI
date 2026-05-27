package org.bukkit.inventory;

import java.util.function.Supplier;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

public enum EquipmentSlot {

    HAND(() -> EquipmentSlotGroup.MAINHAND),
    OFF_HAND(() -> EquipmentSlotGroup.OFFHAND),
    FEET(() -> EquipmentSlotGroup.FEET),
    LEGS(() -> EquipmentSlotGroup.LEGS),
    CHEST(() -> EquipmentSlotGroup.CHEST),
    HEAD(() -> EquipmentSlotGroup.HEAD),
    /**
     * 仅适用于某些实体, 如马和狼.
     */
    BODY(() -> EquipmentSlotGroup.ARMOR),
    /**
     * 仅适用于某些实体, 如马和猪.
     */
    SADDLE(() -> EquipmentSlotGroup.ARMOR);

    private final Supplier<EquipmentSlotGroup> group; // Supplier because of class loading order, since EquipmentSlot and EquipmentSlotGroup reference each other on class init

    private EquipmentSlot(/*@NotNull*/ Supplier<EquipmentSlotGroup> group) {
        this.group = group;
    }

    /**
     * 获取此槽位对应的 {@link EquipmentSlotGroup}.
     * <p>
     * 原文：Gets the {@link EquipmentSlotGroup} corresponding to this slot.
     *
     * @return 对应的 {@link EquipmentSlotGroup}
     */
    @NotNull
    @ApiStatus.Internal
    public EquipmentSlotGroup getGroup() {
        return group.get();
    }
}