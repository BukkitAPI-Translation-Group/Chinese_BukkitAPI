package org.bukkit.util.noise;
import java.util.Random;
import org.bukkit.World;
/**
 * 使用中音阶创建一个柏林噪声。
 * <p>
 * 译注：柏林噪声(perlin noise)，详情百度。
 * <p>
 * 原文：Creates perlin noise through unbiased octaves
 */
public class PerlinOctaveGenerator extends OctaveGenerator {
    /**
     * 为给定的世界创建一个柏林音阶发生器。
     * <p>
     * 译注：柏林噪声(perlin noise)，详情百度。
     * <p>
     * 原文：Creates a perlin octave generator for the given world
     *
     * @param world 创建这个发生器的世界
     * @param octaves 创建的音阶数
     */
    public PerlinOctaveGenerator(World world, int octaves) {
        this(new Random(world.getSeed()), octaves);
    }
    /**
     * 为给定的世界创建一个柏林音阶发生器。
     * <p>
     * 译注：柏林噪声(perlin noise)，详情百度。
     * <p>
     * 原文：Creates a perlin octave generator for the given world
     * <p>
     * 译注2:根据上一个类的翻译 这里given world疑似打错应该是given seed
     * <p>
     * 译注3:算了不影响理解
     *
     * @param seed 创建这个发生器的种子
     * @param octaves 创建的音阶数
     */
    public PerlinOctaveGenerator(long seed, int octaves) {
        this(new Random(seed), octaves);
    }
    /**
     * 为给定的{@link Random}创建一个柏林音阶发生器。
     * <p>
     * 原文：Creates a perlin octave generator for the given {@link Random}
     *
     * @param rand 创建这个发生器的Random对象
     * @param octaves 创建的音阶数
     */
    public PerlinOctaveGenerator(Random rand, int octaves) {
        super(createOctaves(rand, octaves));
    }
    private static NoiseGenerator[] createOctaves(Random rand, int octaves) {
        NoiseGenerator[] result = new NoiseGenerator[octaves];
        for (int i = 0; i < octaves; i++) {
            result[i] = new PerlinNoiseGenerator(rand);
        }
        return result;
    }
}