package org.bukkit.util.noise;
import java.util.Random;
import org.bukkit.World;
/**
 * 使用倍频创建单纯形噪声.
 * <p>
 * 原文:Creates simplex noise through unbiased octaves
 */
public class SimplexOctaveGenerator extends OctaveGenerator {
    private double wScale = 1;
    /**
     * 使用给定的World创建一个SimplexOctaveGenerator.
     * <p>
     * 原文:Creates a simplex octave generator for the given world
     *
     * @param world 创建这个Generator的World实例
     * @param octaves 创建的倍频值
     */
    public SimplexOctaveGenerator(World world, int octaves) {
        this(new Random(world.getSeed()), octaves);
    }
    /**
     * 使用给定的种子创建一个SimplexOctaveGenerator.
     * <p>
     * 原文:Creates a simplex octave generator for the given world
     * <p>
     * 译注:根据参数的翻译 这里given world疑似打错应该是given seed.
     *
     * @param seed 创建这个Generator的long型种子
     * @param octaves 创建的倍频值
     */
    public SimplexOctaveGenerator(long seed, int octaves) {
        this(new Random(seed), octaves);
    }
    /**
     * 使用给定的{@link Random}创建一个SimplexOctaveGenerator.
     * <p>
     * 原文:Creates a simplex octave generator for the given {@link Random}
     *
     * @param rand 创建这个Generator的Random
     * @param octaves 创建的倍频值
     */
    public SimplexOctaveGenerator(Random rand, int octaves) {
        super(createOctaves(rand, octaves));
    }
    @Override
    public void setScale(double scale) {
        super.setScale(scale);
        setWScale(scale);
    }
    /**
     * 获取每个W坐标通过的区间大小.
     * <p>
     * 原文:Gets the scale used for each W-coordinates passed
     *
     * @return W区间大小
     */
    public double getWScale() {
        return wScale;
    }
    /**
     * 设置每个W坐标通过的区间大小.
     * <p>
     * 原文:Sets the scale used for each W-coordinates passed
     *
     * @param scale 新W区间大小
     */
    public void setWScale(double scale) {
        wScale = scale;
    }
    /**
     * 使用特殊的数个音阶和参数产生一个三维坐标的噪音.
     * <p>
     * 原文:Generates noise for the 3D coordinates using the specified number of
     * octaves and parameters
     * <p>
     * 译注:根据参数的翻译 这里3D疑似打错应该是4D.
     *
     * @param x X坐标
     * @param y Y坐标
     * @param z Z坐标
     * @param w W坐标
     * @param frequency 每一个音阶改变多少频率
     * @param amplitude 每一个音阶改变多少振幅
     * @return 噪音结果
     */
    public double noise(double x, double y, double z, double w, double frequency, double amplitude) {
        return noise(x, y, z, w, frequency, amplitude, false);
    }
    /**
     * 使用特殊的数个音阶和参数产生一个三维坐标的噪音.
     * <p>
     * 原文:Generates noise for the 3D coordinates using the specified number of
     * octaves and parameters
     * <p>
     * 译注:根据参数的翻译 这里3D疑似打错应该是4D.
     *
     * @param x X坐标
     * @param y Y坐标
     * @param z Z坐标
     * @param w W坐标
     * @param frequency 每一个音阶改变多少频率
     * @param amplitude 每一个音阶改变多少振幅
     * @param normalized 如果为true,规范这个值为[-1, 1]
     * @return 噪音结果
     */
    public double noise(double x, double y, double z, double w, double frequency, double amplitude, boolean normalized) {
        double result = 0;
        double amp = 1;
        double freq = 1;
        double max = 0;
        x *= xScale;
        y *= yScale;
        z *= zScale;
        w *= wScale;
        for (NoiseGenerator octave : octaves) {
            result += ((SimplexNoiseGenerator) octave).noise(x * freq, y * freq, z * freq, w * freq) * amp;
            max += amp;
            freq *= frequency;
            amp *= amplitude;
        }
        if (normalized) {
            result /= max;
        }
        return result;
    }
    private static NoiseGenerator[] createOctaves(Random rand, int octaves) {
        NoiseGenerator[] result = new NoiseGenerator[octaves];
        for (int i = 0; i < octaves; i++) {
            result[i] = new SimplexNoiseGenerator(rand);
        }
        return result;
    }
}
