package org.bukkit.util.noise;
/**
 * 所有噪音产生器的基类。
 * <p>
 * 原文：Base class for all noise generators
 */
public abstract class NoiseGenerator {
    protected final int perm[] = new int[512];
    protected double offsetX;
    protected double offsetY;
    protected double offsetZ;
    /**
     * 更快速的向下取整算法，比(int)Math.floor(x)快。
     * <p>
     * 原文：Speedy floor, faster than (int)Math.floor(x)
     *
     * @param x 要向下取整的值
     * @return 向下取整的结果
     */
    public static int floor(double x) {
        return x >= 0 ? (int) x : (int) x - 1;
    }
    protected static double fade(double x) {
        return x * x * x * (x * (x * 6 - 15) + 10);
    }
    protected static double lerp(double x, double y, double z) {
        return y + x * (z - y);
    }
    protected static double grad(int hash, double x, double y, double z) {
        hash &= 15;
        double u = hash < 8 ? x : y;
        double v = hash < 4 ? y : hash == 12 || hash == 14 ? x : z;
        return ((hash & 1) == 0 ? u : -u) + ((hash & 2) == 0 ? v : -v);
    }
    /**
     * 计算并返回给定坐标在一维空间中的一维噪音。
     * <p>
     * 原文：Computes and returns the 1D noise for the given coordinate in 1D space
     *
     * @param x X坐标
     * @return 给定位置的噪音, 取值范围 -1 到 1
     */
    public double noise(double x) {
        return noise(x, 0, 0);
    }
    /**
     * 计算并返回给定坐标在二维空间中的二维噪音。
     * <p>
     * 原文：Computes and returns the 2D noise for the given coordinates in 2D space
     *
     * @param x X坐标
     * @param y Y坐标
     * @return 给定位置的噪音, 取值范围 -1 到 1
     */
    public double noise(double x, double y) {
        return noise(x, y, 0);
    }
    /**
     * 计算并返回给定坐标在三维空间中的三维噪音。
     * <p>
     * 原文：Computes and returns the 3D noise for the given coordinates in 3D space
     *
     * @param x X坐标
     * @param y Y坐标
     * @param z Z坐标
     * @return 给定位置的噪音, 取值范围 -1 到 1
     */
    public abstract double noise(double x, double y, double z);
    /**
     * 使用特殊的数个倍频和参数产生一个一维坐标的噪音。
     * <p>
     * 原文：Generates noise for the 1D coordinates using the specified number of
     * octaves and parameters
     *
     * @param x X坐标
     * @param octaves 使用的倍频值
     * @param frequency 每一个倍频改变多少频率
     * @param amplitude 每一个倍频改变多少振幅
     * @return 噪音结果
     */
    public double noise(double x, int octaves, double frequency, double amplitude) {
        return noise(x, 0, 0, octaves, frequency, amplitude);
    }
    /**
     * 使用特殊的数个倍频和参数产生一个一维坐标的噪音。
     * <p>
     * 原文：Generates noise for the 1D coordinates using the specified number of
     * octaves and parameters
     *
     * @param x X坐标
     * @param octaves 使用的倍频值
     * @param frequency 每一个倍频改变多少频率
     * @param amplitude 每一个倍频改变多少振幅
     * @param normalized 如果为true，规范这个值为[-1, 1]
     * @return 噪音结果
     */
    public double noise(double x, int octaves, double frequency, double amplitude, boolean normalized) {
        return noise(x, 0, 0, octaves, frequency, amplitude, normalized);
    }
    /**
     * 使用特殊的数个倍频和参数产生一个二维坐标的噪音。
     * <p>
     * 原文：Generates noise for the 2D coordinates using the specified number of
     * octaves and parameters
     *
     * @param x X坐标
     * @param y Y坐标
     * @param octaves 使用的倍频值
     * @param frequency 每一个倍频改变多少频率
     * @param amplitude 每一个倍频改变多少振幅
     * @return 噪音结果
     */
    public double noise(double x, double y, int octaves, double frequency, double amplitude) {
        return noise(x, y, 0, octaves, frequency, amplitude);
    }
    /**
     * 使用特殊的数个倍频和参数产生一个二维坐标的噪音。
     * <p>
     * 原文：Generates noise for the 2D coordinates using the specified number of
     * octaves and parameters
     *
     * @param x X坐标
     * @param y Y坐标
     * @param octaves 使用的倍频值
     * @param frequency 每一个倍频改变多少频率
     * @param amplitude 每一个倍频改变多少振幅
     * @param normalized 如果为true，规范这个值为[-1, 1]
     * @return 噪音结果
     */
    public double noise(double x, double y, int octaves, double frequency, double amplitude, boolean normalized) {
        return noise(x, y, 0, octaves, frequency, amplitude, normalized);
    }
    /**
     * 使用特殊的数个倍频和参数产生一个三维坐标的噪音。
     * <p>
     * 原文：Generates noise for the 3D coordinates using the specified number of
     * octaves and parameters
     *
     * @param x X坐标
     * @param y Y坐标
     * @param z Z坐标
     * @param octaves 使用的倍频值
     * @param frequency 每一个倍频改变多少频率
     * @param amplitude 每一个倍频改变多少振幅
     * @return 噪音结果
     */
    public double noise(double x, double y, double z, int octaves, double frequency, double amplitude) {
        return noise(x, y, z, octaves, frequency, amplitude, false);
    }
    /**
     * 使用特殊的数个倍频和参数产生一个三维坐标的噪音。
     * <p>
     * 原文：Generates noise for the 3D coordinates using the specified number of
     * octaves and parameters
     *
     * @param x X坐标
     * @param y Y坐标
     * @param z Z坐标
     * @param octaves 使用的倍频值
     * @param frequency 每一个倍频改变多少频率
     * @param amplitude 每一个倍频改变多少振幅
     * @param normalized 如果为true，规范这个值为[-1, 1]
     * @return 噪音结果
     */
    public double noise(double x, double y, double z, int octaves, double frequency, double amplitude, boolean normalized) {
        double result = 0;
        double amp = 1;
        double freq = 1;
        double max = 0;
        for (int i = 0; i < octaves; i++) {
            result += noise(x * freq, y * freq, z * freq) * amp;
            max += amp;
            freq *= frequency;
            amp *= amplitude;
        }
        if (normalized) {
            result /= max;
        }
        return result;
    }
}