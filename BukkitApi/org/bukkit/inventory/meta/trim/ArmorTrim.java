package org.bukkit.inventory.meta.trim;

import com.google.common.base.Preconditions;
import java.util.Objects;
import org.bukkit.inventory.meta.ArmorMeta;
import org.jetbrains.annotations.NotNull;

/**
 * 代表可应用于物品的装甲装饰。
 * <p>
 * 原文: Represents an armor trim that may be applied to an item.
 *
 * @see ArmorMeta#setTrim(ArmorTrim)
 */
public class ArmorTrim {

    private final TrimMaterial material;
    private final TrimPattern pattern;

    /**
     * 根据指定的 {@link TrimMaterial} 和 {@link TrimPattern} 创建一个新的 {@link ArmorTrim}。
     * <p>
     * 原文: Create a new {@link ArmorTrim} given a {@link TrimMaterial} and {@link TrimPattern}.
     *
     * @param material 材质
     * @param pattern 图案
     */
    public ArmorTrim(@NotNull TrimMaterial material, @NotNull TrimPattern pattern) {
        Preconditions.checkArgument(material != null, "material must not be null");
        Preconditions.checkArgument(pattern != null, "pattern must not be null");

        this.material = material;
        this.pattern = pattern;
    }

    /**
     * 获取此盔甲纹饰的 {@link TrimMaterial}。
     * <p>
     * 原文: Get the {@link TrimMaterial} for this armor trim.
     *
     * @return 材质
     */
    @NotNull
    public TrimMaterial getMaterial() {
        return material;
    }

    /**
     * 获取此盔甲纹饰的 {@link TrimPattern}。
     * <p>
     * 原文: Get the {@link TrimPattern} for this armor trim.
     *
     * @return 图案
     */
    @NotNull
    public TrimPattern getPattern() {
        return pattern;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(material);
        hash = 31 * hash + Objects.hashCode(pattern);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof ArmorTrim)) {
            return false;
        }

        ArmorTrim other = (ArmorTrim) obj;
        return material == other.material && pattern == other.pattern;
    }
}
