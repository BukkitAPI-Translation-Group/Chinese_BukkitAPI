package org.bukkit.attribute;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.apache.commons.lang.Validate;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.util.NumberConversions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 一个属性修饰符的具体实现.
 */
public class AttributeModifier implements ConfigurationSerializable {

    private final UUID uuid;
    private final String name;
    private final double amount;
    private final Operation operation;
    private final EquipmentSlot slot;

    public AttributeModifier(@NotNull String name, double amount, @NotNull Operation operation) {
        this(UUID.randomUUID(), name, amount, operation);
    }

    public AttributeModifier(@NotNull UUID uuid, @NotNull String name, double amount, @NotNull Operation operation) {
        this(uuid, name, amount, operation, null);
    }

    public AttributeModifier(@NotNull UUID uuid, @NotNull String name, double amount, @NotNull Operation operation, @Nullable EquipmentSlot slot) {
        Validate.notNull(uuid, "UUID cannot be null");
        Validate.notEmpty(name, "Name cannot be empty");
        Validate.notNull(operation, "Operation cannot be null");
        this.uuid = uuid;
        this.name = name;
        this.amount = amount;
        this.operation = operation;
        this.slot = slot;
    }

    /**
     * 获取该修饰符的 UUID.
     * <p>
     * 原文:
     * Get the unique ID for this modifier.
     *
     * @return UUID
     */
    @NotNull
    public UUID getUniqueId() {
        return uuid;
    }

    /**
     * 获取该修饰符的名称.
     * <p>
     * 原文:
     * Get the name of this modifier.
     *
     * @return 名称
     */
    @NotNull
    public String getName() {
        return name;
    }

    /**
     * 获取该修饰符在根据其 {@link Operation} 运算模式进行计算时的修饰值.
     * <p>
     * 原文:
     * Get the amount by which this modifier will apply its {@link Operation}.
     *
     * @return 修饰值
     */
    public double getAmount() {
        return amount;
    }

    /**
     * 获取该修饰符的运算模式.
     * <p>
     * 原文:
     * Get the operation this modifier will apply.
     *
     * @return 运算模式
     */
    @NotNull
    public Operation getOperation() {
        return operation;
    }

    /**
     * 获取该修饰符生效的 {@link EquipmentSlot},
     * <p>
     * 若该修饰符可以在任意槽位生效, 返回 null.
     * <p>
     * 原文:
     * Get the {@link EquipmentSlot} this AttributeModifier is active on,
     * or null if this modifier is applicable for any slot.
     *
     * @return 目标槽位
     */
    @Nullable
    public EquipmentSlot getSlot() {
        return slot;
    }

    @NotNull
    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("uuid", uuid.toString());
        data.put("name", name);
        data.put("operation", operation.ordinal());
        data.put("amount", amount);
        if (slot != null) {
            data.put("slot", slot.name());
        }
        return data;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof AttributeModifier)) {
            return false;
        }
        AttributeModifier mod = (AttributeModifier) other;
        boolean slots = (this.slot != null ? (this.slot == mod.slot) : mod.slot == null);
        return this.uuid.equals(mod.uuid) && this.name.equals(mod.name) && this.amount == mod.amount && this.operation == mod.operation && slots;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.uuid);
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.amount) ^ (Double.doubleToLongBits(this.amount) >>> 32));
        hash = 17 * hash + Objects.hashCode(this.operation);
        hash = 17 * hash + Objects.hashCode(this.slot);
        return hash;
    }

    @Override
    public String toString() {
        return "AttributeModifier{"
                + "uuid=" + this.uuid.toString()
                + ", name=" + this.name
                + ", operation=" + this.operation.name()
                + ", amount=" + this.amount
                + ", slot=" + (this.slot != null ? this.slot.name() : "")
                + "}";
    }

    @NotNull
    public static AttributeModifier deserialize(@NotNull Map<String, Object> args) {
        if (args.containsKey("slot")) {
            return new AttributeModifier(UUID.fromString((String) args.get("uuid")), (String) args.get("name"), NumberConversions.toDouble(args.get("amount")), Operation.values()[NumberConversions.toInt(args.get("operation"))], EquipmentSlot.valueOf((args.get("slot").toString().toUpperCase())));
        }
        return new AttributeModifier(UUID.fromString((String) args.get("uuid")), (String) args.get("name"), NumberConversions.toDouble(args.get("amount")), Operation.values()[NumberConversions.toInt(args.get("operation"))]);
    }

    /**
     * 可用的运算模式枚举.
     */
    public enum Operation {

        /**
         * 在基值上直接相加 (或相减) 该值
         */
        ADD_NUMBER,
        /**
         * 在基值上增加该值的标量
         * <p>
         * 原文: Adds this scalar of amount to the base value
         * <p>
         * 译注: 即 <a href="https://minecraft-zh.gamepedia.com/%E5%B1%9E%E6%80%A7#%E8%BF%90%E7%AE%97%E6%A8%A1%E5%BC%8F" target="_blank">Minecraft Wiki - 属性#运算模式</a> 中的 "倍率增量".
         * 该运算模式与下一个运算模式 "最终倍乘" 的区别在于, 若拥有多个该运算模式的修饰符, 会将修饰值都加起来进行一次运算, 而拥有多少个 "最终倍乘" 修饰符就会进行多少次相乘运算 (导致属性值变得很大).
         */
        ADD_SCALAR,
        /**
         * 将该值 +1 后乘以基值
         * Multiply amount by this value, after adding 1 to it
         */
        MULTIPLY_SCALAR_1;
    }
}
