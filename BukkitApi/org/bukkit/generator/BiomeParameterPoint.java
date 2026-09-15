package org.bukkit.generator;

/**
 * Represents the biome noise parameters which may be passed to a world
 * generator.
 */
public interface BiomeParameterPoint {

    /**
     * Gets the temperature of the biome at this point that is suggested by the
     * NoiseGenerator.
     *
     * @return The temperature of the biome at this point
     */
    double getTemperature();

    /**
     * Gets the maximum temperature that is possible.
     *
     * @return The maximum temperature
     * @deprecated no longer supported
     */
    @Deprecated(since = "26.3")
    double getMaxTemperature();

    /**
     * Gets the minimum temperature that is possible.
     *
     * @return The minimum temperature
     * @deprecated no longer supported
     */
    @Deprecated(since = "26.3")
    double getMinTemperature();

    /**
     * Gets the humidity of the biome at this point that is suggested by the
     * NoiseGenerator.
     *
     * @return The humidity of the biome at this point
     */
    double getHumidity();

    /**
     * Gets the maximum humidity that is possible.
     *
     * @return The maximum humidity
     * @deprecated no longer supported
     */
    @Deprecated(since = "26.3")
    double getMaxHumidity();

    /**
     * Gets the minimum humidity that is possible.
     *
     * @return The minimum humidity
     * @deprecated no longer supported
     */
    @Deprecated(since = "26.3")
    double getMinHumidity();

    /**
     * Gets the continentalness of the biome at this point that is suggested by
     * the NoiseGenerator.
     *
     * @return The continentalness of the biome at this point
     */
    double getContinentalness();

    /**
     * Gets the maximum continentalness that is possible.
     *
     * @return The maximum continentalness
     * @deprecated no longer supported
     */
    @Deprecated(since = "26.3")
    double getMaxContinentalness();

    /**
     * Gets the minimum continentalness that is possible.
     *
     * @return The minimum continentalness
     * @deprecated no longer supported
     */
    @Deprecated(since = "26.3")
    double getMinContinentalness();

    /**
     * Gets the erosion of the biome at this point that is suggested by the
     * NoiseGenerator.
     *
     * @return The erosion of the biome at this point
     */
    double getErosion();

    /**
     * Gets the maximum erosion that is possible.
     *
     * @return The maximum erosion
     * @deprecated no longer supported
     */
    @Deprecated(since = "26.3")
    double getMaxErosion();

    /**
     * Gets the minimum erosion that is possible.
     *
     * @return The minimum erosion
     * @deprecated no longer supported
     */
    @Deprecated(since = "26.3")
    double getMinErosion();

    /**
     * Gets the depth of the biome at this point that is suggested by the
     * NoiseGenerator.
     *
     * @return The depth of the biome at this point
     */
    double getDepth();

    /**
     * Gets the maximum depth that is possible.
     *
     * @return The maximum depth
     * @deprecated no longer supported
     */
    @Deprecated(since = "26.3")
    double getMaxDepth();

    /**
     * Gets the minimum depth that is possible.
     *
     * @return The minimum depth
     * @deprecated no longer supported
     */
    @Deprecated(since = "26.3")
    double getMinDepth();

    /**
     * Gets the weirdness of the biome at this point that is suggested by the
     * NoiseGenerator.
     *
     * @return The weirdness of the biome at this point
     */
    double getWeirdness();

    /**
     * Gets the maximum weirdness that is possible.
     *
     * @return The maximum weirdness
     * @deprecated no longer supported
     */
    @Deprecated(since = "26.3")
    double getMaxWeirdness();

    /**
     * Gets the minimum weirdness that is possible.
     *
     * @return The minimum weirdness
     * @deprecated no longer supported
     */
    @Deprecated(since = "26.3")
    double getMinWeirdness();
}
