package org.bukkit.block.spawner;

import com.google.common.base.Preconditions;
import java.util.LinkedHashMap;
import java.util.Map;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;
import org.jetbrains.annotations.NotNull;

/**
 * 表示一个生成规则，控制从怪物生成器生成的实体在什么条件下可以生成。
 * 
 * 原文:Represents a spawn rule that controls what conditions an entity from a
 * monster spawner can spawn.
 */
@SerializableAs("SpawnRule")
public class SpawnRule implements Cloneable, ConfigurationSerializable {

    private int minBlockLight;
    private int maxBlockLight;
    private int minSkyLight;
    private int maxSkyLight;

    /**
     * 构造一个新的SpawnRule。
     * 
     * 原文:Constructs a new SpawnRule.
     *
     * @param minBlockLight 生成成功所需的最小（包含）方块光照等级。
     * 原文:The minimum (inclusive) block light required for
     * spawning to succeed.
     * @param maxBlockLight 生成成功所需的最大（包含）方块光照等级。
     * 原文:The maximum (inclusive) block light required for
     * spawning to succeed.
     * @param minSkyLight 生成成功所需的最小（包含）天空光照等级。
     * 原文:The minimum (inclusive) sky light required for
     * spawning to succeed.
     * @param maxSkyLight 生成成功所需的最大（包含）天空光照等级。
     * 原文:The maximum (inclusive) sky light required for
     * spawning to succeed.
     */
    public SpawnRule(int minBlockLight, int maxBlockLight, int minSkyLight, int maxSkyLight) {
        Preconditions.checkArgument(minBlockLight <= maxBlockLight, "minBlockLight must be <= maxBlockLight (%s <= %s)", minBlockLight, maxBlockLight);
        Preconditions.checkArgument(minSkyLight <= maxSkyLight, "minSkyLight must be <= maxSkyLight (%s <= %s)", minSkyLight, maxSkyLight);
        Preconditions.checkArgument(minBlockLight >= 0, "minBlockLight must be >= 0 (given %s)", minBlockLight);
        Preconditions.checkArgument(maxBlockLight >= 0, "maxBlockLight must be >= 0 (given %s)", maxBlockLight);
        Preconditions.checkArgument(minSkyLight >= 0, "minSkyLight must be >= 0 (given %s)", minSkyLight);
        Preconditions.checkArgument(maxSkyLight >= 0, "maxSkyLight must be >= 0 (given %s)", maxSkyLight);

        this.minBlockLight = minBlockLight;
        this.maxBlockLight = maxBlockLight;
        this.minSkyLight = minSkyLight;
        this.maxSkyLight = maxSkyLight;
    }

    /**
     * 获取生成成功所需的最小（包含）方块光照等级。
     * 
     * 原文:Gets the minimum (inclusive) block light required for spawning to
     * succeed.
     *
     * @return 最小方块光照等级
     * 原文:minimum block light
     */
    public int getMinBlockLight() {
        return minBlockLight;
    }

    /**
     * 设置生成成功所需的最小（包含）方块光照等级。
     * 
     * 原文:Sets the minimum (inclusive) block light required for spawning to
     * succeed.
     *
     * @param minBlockLight 最小方块光照等级
     * 原文:minimum block light
     */
    public void setMinBlockLight(int minBlockLight) {
        Preconditions.checkArgument(minBlockLight >= 0, "minBlockLight must be >= 0 (given %s)", minBlockLight);
        Preconditions.checkArgument(minBlockLight <= maxBlockLight, "minBlockLight must be <= maxBlockLight (%s <= %s)", minBlockLight, maxBlockLight);

        this.minBlockLight = minBlockLight;
    }

    /**
     * 获取生成成功所需的最大（包含）方块光照等级。
     * 
     * 原文:Gets the maximum (inclusive) block light required for spawning to
     * succeed.
     *
     * @return 最大方块光照等级
     * 原文:maximum block light
     */
    public int getMaxBlockLight() {
        return maxBlockLight;
    }

    /**
     * 设置生成成功所需的最大（包含）方块光照等级。
     * 
     * 原文:Sets the maximum (inclusive) block light required for spawning to
     * succeed.
     *
     * @param maxBlockLight 最大方块光照等级
     * 原文:maximum block light
     */
    public void setMaxBlockLight(int maxBlockLight) {
        Preconditions.checkArgument(maxBlockLight >= 0, "maxBlockLight must be >= 0 (given %s)", maxBlockLight);

        this.maxBlockLight = maxBlockLight;
    }

    /**
     * 获取生成成功所需的最小（包含）天空光照等级。
     * 
     * 原文:Gets the minimum (inclusive) sky light required for spawning to succeed.
     *
     * @return 最小天空光照等级
     * 原文:minimum sky light
     */
    public int getMinSkyLight() {
        return minSkyLight;
    }

    /**
     * 设置生成成功所需的最小（包含）天空光照等级。
     * 
     * 原文:Sets the minimum (inclusive) sky light required for spawning to succeed.
     *
     * @param minSkyLight 最小天空光照等级
     * 原文:minimum sky light
     */
    public void setMinSkyLight(int minSkyLight) {
        Preconditions.checkArgument(minSkyLight >= 0, "minSkyLight must be >= 0 (given %s)", minSkyLight);
        Preconditions.checkArgument(minSkyLight <= maxSkyLight, "minSkyLight must be <= maxSkyLight (%s <= %s)", minSkyLight, maxSkyLight);

        this.minSkyLight = minSkyLight;
    }

    /**
     * 获取生成成功所需的最大（包含）天空光照等级。
     * 
     * 原文:Gets the maximum (inclusive) sky light required for spawning to succeed.
     *
     * @return 最大天空光照等级
     * 原文:maximum sky light
     */
    public int getMaxSkyLight() {
        return maxSkyLight;
    }

    /**
     * 设置生成成功所需的最大（包含）天空光照等级。
     * 
     * 原文:Sets the maximum (inclusive) sky light required for spawning to succeed.
     *
     * @param maxSkyLight 最大天空光照等级
     * 原文:maximum sky light
     */
    public void setMaxSkyLight(int maxSkyLight) {
        Preconditions.checkArgument(maxSkyLight >= 0, "maxSkyLight must be >= 0 (given %s)", maxSkyLight);

        this.maxSkyLight = maxSkyLight;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SpawnRule)) {
            return false;
        }

        SpawnRule other = (SpawnRule) obj;
        return minBlockLight == other.minBlockLight && maxBlockLight == other.maxBlockLight && minSkyLight == other.minSkyLight && maxSkyLight == other.maxSkyLight;
    }

    @Override
    public int hashCode() {
        int hash = minBlockLight;

        hash = (hash << 4) + maxBlockLight;
        hash = (hash << 4) + minSkyLight;
        hash = (hash << 4) + maxSkyLight;

        return hash;
    }

    @NotNull
    @Override
    public SpawnRule clone() {
        try {
            return (SpawnRule) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }

    @Override
    @NotNull
    public Map<String, Object> serialize() {
        Map<String, Object> result = new LinkedHashMap<>();
        Map<String, Object> block = new LinkedHashMap<>();
        Map<String, Object> sky = new LinkedHashMap<>();

        block.put("min", getMinBlockLight());
        block.put("max", getMaxBlockLight());
        sky.put("min", getMinSkyLight());
        sky.put("max", getMaxSkyLight());

        result.put("block-light", block);
        result.put("sky-light", sky);

        return result;
    }

    @NotNull
    public static SpawnRule deserialize(@NotNull Map<String, Object> args) {
        int minBlock = 0;
        int maxBlock = 0;
        int minSky = 0;
        int maxSky = 0;

        Object block = args.get("block-light");
        Object sky = args.get("sky-light");

        if (block instanceof Map<?, ?>) {
            Map<?, ?> blockMap = (Map<?, ?>) block;

            if (blockMap.containsKey("min")) {
                minBlock = (int) blockMap.get("min");
            }

            if (blockMap.containsKey("max")) {
                maxBlock = (int) blockMap.get("max");
            }
        }

        if (sky instanceof Map<?, ?>) {
            Map<?, ?> skyMap = (Map<?, ?>) sky;

            if (skyMap.containsKey("min")) {
                minSky = (int) skyMap.get("min");
            }

            if (skyMap.containsKey("max")) {
                maxSky = (int) skyMap.get("max");
            }
        }

        return new SpawnRule(minBlock, maxBlock, minSky, maxSky);
    }
}
