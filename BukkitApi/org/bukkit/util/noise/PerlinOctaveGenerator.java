package org.bukkit.util.noise;
import java.util.Random;
import org.bukkit.World;
/**
 * 使用无偏倍频创建一个柏林噪声.
 * <p>
 * 原文:Creates perlin noise through unbiased octaves
 */
public class PerlinOctaveGenerator extends OctaveGenerator {
    /**
     * 使用给定的World创建一个PerlinOctaveGenerator.
     * <p>
     * 原文:Creates a perlin octave generator for the given world
     *
     * @param world 创建这个Generator的World实例
     * @param octaves 倍频值
     */
    public PerlinOctaveGenerator(World world, int octaves) {
        this(new Random(world.getSeed()), octaves);
    }
    /**
     * 使用给定的种子创建一个PerlinOctaveGenerator.
     * <p>
     * 原文:Creates a perlin octave generator for the given world
     * <p>
     * 译注:根据上一个类的翻译 这里given world疑似打错应该是given seed
     *
     * @param seed 创建这个Generator的long型种子
     * @param octaves 倍频值
     */
    public PerlinOctaveGenerator(long seed, int octaves) {
        this(new Random(seed), octaves);
    }
    /**
     * 使用给定的{@link Random}创建一个PerlinOctaveGenerator.
     * <p>
     * 原文:Creates a perlin octave generator for the given {@link Random}
     *
     * @param rand 创建这个Generator的Random
     * @param octaves 倍频值
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
