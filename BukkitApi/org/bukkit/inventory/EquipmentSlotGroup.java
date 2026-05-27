package org.bukkit.inventory;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Predicate;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一组 {@link EquipmentSlot}.
 */
@ApiStatus.Experimental
public final class EquipmentSlotGroup implements Predicate<EquipmentSlot> {

    private static final Map<String, EquipmentSlotGroup> BY_NAME = new HashMap<>();
    //
    public static final EquipmentSlotGroup ANY = get("any", (test) -> true, EquipmentSlot.HAND);
    public static final EquipmentSlotGroup MAINHAND = get("mainhand", EquipmentSlot.HAND);
    public static final EquipmentSlotGroup OFFHAND = get("offhand", EquipmentSlot.OFF_HAND);
    public static final EquipmentSlotGroup HAND = get("hand", (test) -> test == EquipmentSlot.HAND || test == EquipmentSlot.OFF_HAND, EquipmentSlot.HAND);
    public static final EquipmentSlotGroup FEET = get("feet", EquipmentSlot.FEET);
    public static final EquipmentSlotGroup LEGS = get("legs", EquipmentSlot.LEGS);
    public static final EquipmentSlotGroup CHEST = get("chest", EquipmentSlot.CHEST);
    public static final EquipmentSlotGroup HEAD = get("head", EquipmentSlot.HEAD);
    public static final EquipmentSlotGroup ARMOR = get("armor", (test) -> test == EquipmentSlot.FEET || test == EquipmentSlot.LEGS || test == EquipmentSlot.CHEST || test == EquipmentSlot.HEAD, EquipmentSlot.CHEST);
    public static final EquipmentSlotGroup SADDLE = get("saddle", EquipmentSlot.SADDLE);
    //
    private final String key;
    private final Predicate<EquipmentSlot> predicate;
    private final EquipmentSlot example;

    private EquipmentSlotGroup(@NotNull String key, @NotNull Predicate<EquipmentSlot> predicate, @NotNull EquipmentSlot example) {
        this.key = key;
        this.predicate = predicate;
        this.example = example;

        BY_NAME.put(key, this);
    }

    @Override
    public boolean test(@NotNull EquipmentSlot test) {
        return this.predicate.test(test);
    }

    @Override
    public String toString() {
        return this.key;
    }

    /**
     * 获取一个 {@link EquipmentSlot} 作为此组中槽位的示例.
     * <p>
     * 原文：Gets an {@link EquipmentSlot} which is an example of a slot in this
     * group.
     *
     * @return 示例槽位
     * @deprecated 仅用于内部兼容性
     */
    @NotNull
    @Deprecated(since = "1.20.5")
    @ApiStatus.Internal
    public EquipmentSlot getExample() {
        return example;
    }

    /**
     * 获取与给定字符串对应的 {@link EquipmentSlotGroup}.
     * <p>
     * 原文：Gets the {@link EquipmentSlotGroup} corresponding to the given string.
     *
     * @param name 组名
     * @return 关联的组, 或 null
     */
    @Nullable
    @ApiStatus.Internal
    public static EquipmentSlotGroup getByName(@NotNull String name) {
        Preconditions.checkArgument(name != null, "Name cannot be null");

        return BY_NAME.get(name.toLowerCase(Locale.ROOT));
    }

    private static EquipmentSlotGroup get(@NotNull String key, @NotNull EquipmentSlot slot) {
        return get(key, (test) -> test == slot, slot);
    }

    private static EquipmentSlotGroup get(@NotNull String key, @NotNull Predicate<EquipmentSlot> predicate, @NotNull EquipmentSlot example) {
        return new EquipmentSlotGroup(key, predicate, example);
    }
}