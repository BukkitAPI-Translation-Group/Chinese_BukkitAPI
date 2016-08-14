package org.bukkit;

/**
 * TravelAgent用于实体试图使用下界或末地传送门时处理相关的生成和搜索。
 * <p>
 * 被应用于{@link org.bukkit.event.entity.EntityPortalEvent}和{@link org.bukkit.event.player.PlayerPortalEvent}中以帮助开发者复制和修改原版行为。
 * 原文：
 * The Travel Agent handles the creation and the research of Nether and End
 * portals when Entities try to use one.
 * <p>
 * It is used in {@link org.bukkit.event.entity.EntityPortalEvent} and in
 * {@link org.bukkit.event.player.PlayerPortalEvent} to help developers
 * reproduce and/or modify Vanilla behaviour.
 */
public interface TravelAgent {

    /**
     * 设置搜索有效传送门的方块半径。
     * <p>
     * 原文：
     * Set the Block radius to search in for available portals.
     *
     * @param radius 以指定方位为圆心搜索传送门的半径
     * @return TravelAgent对象
     */
    public TravelAgent setSearchRadius(int radius);

    /**
     * 获取寻找有效传送门的搜索半径数值。
     * <p>
     * 原文：
     * Gets the search radius value for finding an available portal.
     *
     * @return 当前设置的搜索半径
     */
    public int getSearchRadius();

    /**
     * 设置以指定方位为圆心生成传送门的最大半径。
     * <p>
     * 原文：
     * Sets the maximum radius from the given location to create a portal.
     *
     * @param radius 以指定方位为圆心生成传送门的半径
     * @return TravelAgent对象
     */
    public TravelAgent setCreationRadius(int radius);

    /**
     * 获取以指定方位为圆心生成传送门的最大半径。
     * <p>
     * 原文：
     * Gets the maximum radius from the given location to create a portal.
     *
     * @return 当前设置的生成半径
     */
    public int getCreationRadius();

    /**
     * 返回TravelAgent是否尝试生成目的传送门。
     * <p>
     * 原文：
     * Returns whether the TravelAgent will attempt to create a destination
     * portal or not.
     *
     * @return TravelAgent是否尝试生成目的传送门
     */
    public boolean getCanCreatePortal();

    /**
     * 设置TravelAgent是否尝试生成目的传送门。
     * <p>
     * 原文：
     * Sets whether the TravelAgent should attempt to create a destination
     * portal or not.
     *
     * @param create TravelAgent是否尝试生成目的传送门
     */
    public void setCanCreatePortal(boolean create);

    /**
     * 尝试寻找指定方位附近的传送门，如果找不到则会尝试生成一个。
     * <p>
     * 原文：
     * Attempt to find a portal near the given location, if a portal is not
     * found it will attempt to create one.
     *
     * @param location 搜索传送门的原点
     * @return 寻找到的传送门的方位，如果失败则会返回传递给这个方法的方位。
     * @see #createPortal(Location)
     */
    public Location findOrCreate(Location location);

    /**
     * 尝试寻找指定方位附近的传送门。
     * <p>
     * 原文：
     * Attempt to find a portal near the given location.
     *
     * @param location 搜索传送门的原点
     * @return 最近的传送门的方位
     */
    public Location findPortal(Location location);

    /**
     * 尝试在指定方位附近生成一个传送门。
     * <p>
     * 如果传送到下界将会尝试生成一个下界传送门。
     * <p>
     * 如果传送到末地将会（重新）生成黑曜石平台并清除上方的方块。
     * <p>
     * 原文：
     * Attempt to create a portal near the given location.
     * <p>
     * In the case of a Nether portal teleportation, this will attempt to
     * create a Nether portal.
     * <p>
     * In the case of an Ender portal teleportation, this will (re-)create the
     * obsidian platform and clean blocks above it.
     *
     * @param location 生成传送门的原点
     * @return 成功生成传送门则返回true
     */
    public boolean createPortal(Location location);
}