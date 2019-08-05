package org.bukkit.entity;

/**
 * 代表一个有年龄和繁殖能力的实体.
 */
public interface Ageable extends Creature {
    /**
     * 获取这只动物的年龄.
     * <p>
     * 原文:
     * Gets the age of this animal.
     *
     * @return 年龄
     */
    public int getAge();

    /**
     * 设置这只动物的年龄.
     * <p>
     * 原文:
     * Sets the age of this animal.
     *
     * @param age 新的年龄
     */
    public void setAge(int age);

    /**
     * 锁定这只动物的年龄,设置这个将防止动物从长成以准备进行交配.
     * <p>
     * 原文:
     * Lock the age of the animal, setting this will prevent the animal from
     * maturing or getting ready for mating.
     *
     * @param lock 是否锁定
     */
    public void setAgeLock(boolean lock);

    /**
     * 获取这个动物的年龄是否被锁定.
     * <p>
     * 原文:
     * Gets the current agelock.
     *
     * @return 这个动物的年龄是否被锁定
     */
    public boolean getAgeLock();

    /**
     * 设置这只动物为年幼状态.
     * <p>
     * 原文:
     * Sets the age of the animal to a baby
     */
    public void setBaby();

    /**
     * 设置这只动物为成年状态.
     * <p>
     * 原文:
     * Sets the age of the animal to an adult
     */
    public void setAdult();

    /**
     * 获取这个动物是否成年.
     * <p>
     * 原文:
     * Returns true if the animal is an adult.
     *
     * @return 如果动物成年，则返回true
     */
    public boolean isAdult();

    /**
     * 返回动物是否具有繁殖能力.
     * <p>
     * 原文:
     * Return the ability to breed of the animal.
     *
     * @return 动物是否具有繁殖能力
     */
    public boolean canBreed();

    /**
     * 设置动物是否具有繁殖能力,如果动物是年幼的设置此将立即长大.
     * <p>
     * 原文:
     * Set breedability of the animal, if the animal is a baby and set to
     * breed it will instantly grow up.
     *
     * @param breed 动物是否具有繁殖能力
     */
    public void setBreed(boolean breed);
}