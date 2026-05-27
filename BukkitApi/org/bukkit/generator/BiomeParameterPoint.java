package org.bukkit.generator;

/**
 * 表示可能传递给世界生成器的生物群系噪声参数.
 */
public interface BiomeParameterPoint {

    /**
     * 获取噪声生成器建议的此点生物群系的温度.
     * <p>
     * 原文：
     * Gets the temperature of the biome at this point that is suggested by the
     * NoiseGenerator.
     *
     * @return 此点生物群系的温度
     */
    double getTemperature();

    /**
     * 获取可能的最高温度.
     * <p>
     * 原文：
     * Gets the maximum temperature that is possible.
     *
     * @return 最高温度
     */
    double getMaxTemperature();

    /**
     * 获取可能的最低温度.
     * <p>
     * 原文：
     * Gets the minimum temperature that is possible.
     *
     * @return 最低温度
     */
    double getMinTemperature();

    /**
     * 获取噪声生成器建议的此点生物群系的湿度.
     * <p>
     * 原文：
     * Gets the humidity of the biome at this point that is suggested by the
     * NoiseGenerator.
     *
     * @return 此点生物群系的湿度
     */
    double getHumidity();

    /**
     * 获取可能的最高湿度.
     * <p>
     * 原文：
     * Gets the maximum humidity that is possible.
     *
     * @return 最高湿度
     */
    double getMaxHumidity();

    /**
     * 获取可能的最低湿度.
     * <p>
     * 原文：
     * Gets the minimum humidity that is possible.
     *
     * @return 最低湿度
     */
    double getMinHumidity();

    /**
     * 获取噪声生成器建议的此点生物群系的大陆性.
     * <p>
     * 原文：
     * Gets the continentalness of the biome at this point that is suggested by
     * the NoiseGenerator.
     *
     * @return 此点生物群系的大陆性
     */
    double getContinentalness();

    /**
     * 获取可能的最高大陆性.
     * <p>
     * 原文：
     * Gets the maximum continentalness that is possible.
     *
     * @return 最高大陆性
     */
    double getMaxContinentalness();

    /**
     * 获取可能的最低大陆性.
     * <p>
     * 原文：
     * Gets the minimum continentalness that is possible.
     *
     * @return 最低大陆性
     */
    double getMinContinentalness();

    /**
     * 获取噪声生成器建议的此点生物群系的侵蚀度.
     * <p>
     * 原文：
     * Gets the erosion of the biome at this point that is suggested by the
     * NoiseGenerator.
     *
     * @return 此点生物群系的侵蚀度
     */
    double getErosion();

    /**
     * 获取可能的最高侵蚀度.
     * <p>
     * 原文：
     * Gets the maximum erosion that is possible.
     *
     * @return 最高侵蚀度
     */
    double getMaxErosion();

    /**
     * 获取可能的最低侵蚀度.
     * <p>
     * 原文：
     * Gets the minimum erosion that is possible.
     *
     * @return 最低侵蚀度
     */
    double getMinErosion();

    /**
     * 获取噪声生成器建议的此点生物群系的深度.
     * <p>
     * 原文：
     * Gets the depth of the biome at this point that is suggested by the
     * NoiseGenerator.
     *
     * @return 此点生物群系的深度
     */
    double getDepth();

    /**
     * 获取可能的最高深度.
     * <p>
     * 原文：
     * Gets the maximum depth that is possible.
     *
     * @return 最高深度
     */
    double getMaxDepth();

    /**
     * 获取可能的最低深度.
     * <p>
     * 原文：
     * Gets the minimum depth that is possible.
     *
     * @return 最低深度
     */
    double getMinDepth();

    /**
     * 获取噪声生成器建议的此点生物群系的奇异度.
     * <p>
     * 原文：
     * Gets the weirdness of the biome at this point that is suggested by the
     * NoiseGenerator.
     *
     * @return 此点生物群系的奇异度
     */
    double getWeirdness();

    /**
     * 获取可能的最高奇异度.
     * <p>
     * 原文：
     * Gets the maximum weirdness that is possible.
     *
     * @return 最高奇异度
     */
    double getMaxWeirdness();

    /**
     * 获取可能的最低奇异度.
     * <p>
     * 原文：
     * Gets the minimum weirdness that is possible.
     *
     * @return 最低奇异度
     */
    double getMinWeirdness();
}
