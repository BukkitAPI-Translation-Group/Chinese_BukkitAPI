package org.bukkit.inventory.meta.components.consumable.effects;

/**
 * Represent a random teleport when an item is consumed.
 */
public interface ConsumableTeleportRandomly extends ConsumableEffect {

    /**
     * Gets the diameter that the consumer is teleported within.
     *
     * @return the diameter
     */
    float getDiameter();

    /**
     * Sets the diameter that the consumer is teleported within.
     *
     * @param diameter new diameter
     */
    void setDiameter(float diameter);

    /**
     * Gets whether directional particles will be displayed.
     *
     * @return whether to display particles
     */
    boolean isDirectionalParticles();

    /**
     * Sets whether directional particles will be displayed.
     *
     * @param directionalParticles whether to display particles
     */
    void setDirectionalParticles(boolean directionalParticles);
}
