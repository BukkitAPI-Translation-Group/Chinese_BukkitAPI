package org.bukkit.util;

import static org.bukkit.util.NumberConversions.*;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

/**
 * 这个类执行射线追踪并迭代一条直线上的所有单个方块. 
 * <p>
 * 原文:This class performs ray tracing and iterates along blocks on a line
 */
public class BlockIterator implements Iterator<Block> {
    private final World world;
    private final int maxDistance;
    private static final int gridSize = 1 << 24;
    private boolean end = false;
    private Block[] blockQueue = new Block[3];
    private int currentBlock = 0;
    private int currentDistance = 0;
    private int maxDistanceInt;
    private int secondError;
    private int thirdError;
    private int secondStep;
    private int thirdStep;
    private BlockFace mainFace;
    private BlockFace secondFace;
    private BlockFace thirdFace;
    /**
     * BlockIterator的构造函数.
     * <p>
     * 本方法认为所有方块的体积均为1x1x1.
     * <p>
     * 原文:Constructs the BlockIterator.
     * <p>
     * This considers all blocks as 1x1x1 in size.
     *
     * @param world 使用此追踪的世界
     * @param start 追踪的初位置向量
     * @param direction 追踪的方向向量
     * @param yOffset 垂直偏移量，追踪从初向量开始垂直偏移这个值的范围
     * @param maxDistance 这是在方块中追踪的最大距离,
     * 设置此值在140以上可能导致未加载区块(unloaded chunks)的问题,值0表示无限制
     *
     */
    public BlockIterator(@NotNull World world, @NotNull Vector start, @NotNull Vector direction, double yOffset, int maxDistance) {
        Preconditions.checkArgument(world != null, "world must not be null");
        Preconditions.checkArgument(start != null, "start must not be null");
        Preconditions.checkArgument(direction != null, "direction must not be null");
        Preconditions.checkArgument(!direction.isZero(), "direction must have at least one non-zero component");

        this.world = world;
        this.maxDistance = maxDistance;
        Vector startClone = start.clone();
        startClone.setY(startClone.getY() + yOffset);
        currentDistance = 0;
        double mainDirection = 0;
        double secondDirection = 0;
        double thirdDirection = 0;
        double mainPosition = 0;
        double secondPosition = 0;
        double thirdPosition = 0;
        Block startBlock = this.world.getBlockAt(floor(startClone.getX()), floor(startClone.getY()), floor(startClone.getZ()));
        if (getXLength(direction) > mainDirection) {
            mainFace = getXFace(direction);
            mainDirection = getXLength(direction);
            mainPosition = getXPosition(direction, startClone, startBlock);
            secondFace = getYFace(direction);
            secondDirection = getYLength(direction);
            secondPosition = getYPosition(direction, startClone, startBlock);
            thirdFace = getZFace(direction);
            thirdDirection = getZLength(direction);
            thirdPosition = getZPosition(direction, startClone, startBlock);
        }
        if (getYLength(direction) > mainDirection) {
            mainFace = getYFace(direction);
            mainDirection = getYLength(direction);
            mainPosition = getYPosition(direction, startClone, startBlock);
            secondFace = getZFace(direction);
            secondDirection = getZLength(direction);
            secondPosition = getZPosition(direction, startClone, startBlock);
            thirdFace = getXFace(direction);
            thirdDirection = getXLength(direction);
            thirdPosition = getXPosition(direction, startClone, startBlock);
        }
        if (getZLength(direction) > mainDirection) {
            mainFace = getZFace(direction);
            mainDirection = getZLength(direction);
            mainPosition = getZPosition(direction, startClone, startBlock);
            secondFace = getXFace(direction);
            secondDirection = getXLength(direction);
            secondPosition = getXPosition(direction, startClone, startBlock);
            thirdFace = getYFace(direction);
            thirdDirection = getYLength(direction);
            thirdPosition = getYPosition(direction, startClone, startBlock);
        }
        // trace line backwards to find intercept with plane perpendicular to the main axis
        double d = mainPosition / mainDirection; // how far to hit face behind
        double secondd = secondPosition - secondDirection * d;
        double thirdd = thirdPosition - thirdDirection * d;
        // Guarantee that the ray will pass though the start block.
        // It is possible that it would miss due to rounding
        // This should only move the ray by 1 grid position
        secondError = floor(secondd * gridSize);
        secondStep = round(secondDirection / mainDirection * gridSize);
        thirdError = floor(thirdd * gridSize);
        thirdStep = round(thirdDirection / mainDirection * gridSize);
        if (secondError + secondStep <= 0) {
            secondError = -secondStep + 1;
        }
        if (thirdError + thirdStep <= 0) {
            thirdError = -thirdStep + 1;
        }
        Block lastBlock;
        lastBlock = startBlock.getRelative(mainFace.getOppositeFace());
        if (secondError < 0) {
            secondError += gridSize;
            lastBlock = lastBlock.getRelative(secondFace.getOppositeFace());
        }
        if (thirdError < 0) {
            thirdError += gridSize;
            lastBlock = lastBlock.getRelative(thirdFace.getOppositeFace());
        }
        // This means that when the variables are positive, it means that the coord=1 boundary has been crossed
        secondError -= gridSize;
        thirdError -= gridSize;
        blockQueue[0] = lastBlock;
        currentBlock = -1;
        scan();
        boolean startBlockFound = false;
        for (int cnt = currentBlock; cnt >= 0; cnt--) {
            if (blockEquals(blockQueue[cnt], startBlock)) {
                currentBlock = cnt;
                startBlockFound = true;
                break;
            }
        }
        if (!startBlockFound) {
            throw new IllegalStateException("Start block missed in BlockIterator");
        }
        // Calculate the number of planes passed to give max distance
        maxDistanceInt = round(maxDistance / (Math.sqrt(mainDirection * mainDirection + secondDirection * secondDirection + thirdDirection * thirdDirection) / mainDirection));
    }
    private boolean blockEquals(@NotNull Block a, @NotNull Block b) {
        return a.getX() == b.getX() && a.getY() == b.getY() && a.getZ() == b.getZ();
    }

    private BlockFace getXFace(@NotNull Vector direction) {
        return ((direction.getX() > 0) ? BlockFace.EAST : BlockFace.WEST);
    }

    private BlockFace getYFace(@NotNull Vector direction) {
        return ((direction.getY() > 0) ? BlockFace.UP : BlockFace.DOWN);
    }

    private BlockFace getZFace(@NotNull Vector direction) {
        return ((direction.getZ() > 0) ? BlockFace.SOUTH : BlockFace.NORTH);
    }

    private double getXLength(@NotNull Vector direction) {
        return Math.abs(direction.getX());
    }

    private double getYLength(@NotNull Vector direction) {
        return Math.abs(direction.getY());
    }

    private double getZLength(@NotNull Vector direction) {
        return Math.abs(direction.getZ());
    }

    private double getPosition(double direction, double position, int blockPosition) {
        return direction > 0 ? (position - blockPosition) : (blockPosition + 1 - position);
    }

    private double getXPosition(@NotNull Vector direction, @NotNull Vector position, @NotNull Block block) {
        return getPosition(direction.getX(), position.getX(), block.getX());
    }

    private double getYPosition(@NotNull Vector direction, @NotNull Vector position, @NotNull Block block) {
        return getPosition(direction.getY(), position.getY(), block.getY());
    }

    private double getZPosition(@NotNull Vector direction, @NotNull Vector position, @NotNull Block block) {
        return getPosition(direction.getZ(), position.getZ(), block.getZ());
    }
    /**
     * BlockIterator的构造函数.
     * <p>
     * 本方法认为所有方块的体积均为1x1x1.
     * <p>
     * 原文:Constructs the BlockIterator.
     * <p>
     * This considers all blocks as 1x1x1 in size.
     *
     * @param loc 射线追踪的起始位置
     * @param yOffset 垂直偏移量,追踪从初向量开始垂直偏移这个值的范围
     * @param maxDistance 这是在方块中追踪的最大距离,
     * 设置此值在140以上可能导致未加载区块(unloaded chunks)的问题,值0表示无限制
     */
    public BlockIterator(@NotNull Location loc, double yOffset, int maxDistance) {
        this(loc.getWorld(), loc.toVector(), loc.getDirection(), yOffset, maxDistance);
    }
    /**
     * BlockIterator的构造函数.
     * <p>
     * 本方法认为所有方块的体积均为1x1x1.
     * <p>
     * 原文:Constructs the BlockIterator.
     * <p>
     * This considers all blocks as 1x1x1 in size.
     *
     * @param loc 射线追踪的开始位置
     * @param yOffset 垂直偏移量,追踪从初向量开始垂直偏移这个值的范围
     */
    public BlockIterator(@NotNull Location loc, double yOffset) {
        this(loc.getWorld(), loc.toVector(), loc.getDirection(), yOffset, 0);
    }
    /**
     * BlockIterator的构造函数.
     * <p>
     * 本方法认为所有方块的体积均为1x1x1.
     * <p>
     * 原文:Constructs the BlockIterator.
     * <p>
     * This considers all blocks as 1x1x1 in size.
     *
     * @param loc 射线追踪的开始位置
     */
    public BlockIterator(@NotNull Location loc) {
        this(loc, 0D);
    }
    /**
     * BlockIterator的构造函数.
     * <p>
     * 本方法认为所有方块的体积均为1x1x1.
     * <p>
     * 原文:Constructs the BlockIterator.
     * <p>
     * This considers all blocks as 1x1x1 in size.
     *
     * @param entity 被用来设置追踪的实体
     * @param maxDistance 这是在方块中追踪的最大距离,
     * 设置此值在140以上可能导致未加载区块(unloaded chunks)的问题,值0表示无限制
     */
    public BlockIterator(@NotNull LivingEntity entity, int maxDistance) {
        this(entity.getLocation(), entity.getEyeHeight(), maxDistance);
    }
    /**
     * 创建BlockIterator.
     * <p>
     * 原文:Constructs the BlockIterator.
     *
     * @param entity 被用来设置追踪的实体信息
     */
    public BlockIterator(@NotNull LivingEntity entity) {
        this(entity, 0);
    }
    /**
     * 如果迭代器还有更多的元素则返回true.
     * <p>
     * 原文:Returns true if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        scan();
        return currentBlock != -1;
    }
    /**
     * 返回追踪的下一个方块.
     * <p>
     * 原文:Returns the next Block in the trace
     *
     * @return 追踪的下一个方块
     */
    @Override
    @NotNull
    public Block next() throws NoSuchElementException {
        scan();
        if (currentBlock <= -1) {
            throw new NoSuchElementException();
        } else {
            return blockQueue[currentBlock--];
        }
    }
    @Override
    public void remove() {
        throw new UnsupportedOperationException("[BlockIterator] doesn't support block removal");
    }
    private void scan() {
        if (currentBlock >= 0) {
            return;
        }
        if (maxDistance != 0 && currentDistance > maxDistanceInt) {
            end = true;
            return;
        }
        if (end) {
            return;
        }
        currentDistance++;
        secondError += secondStep;
        thirdError += thirdStep;
        if (secondError > 0 && thirdError > 0) {
            blockQueue[2] = blockQueue[0].getRelative(mainFace);
            if (((long) secondStep) * ((long) thirdError) < ((long) thirdStep) * ((long) secondError)) {
                blockQueue[1] = blockQueue[2].getRelative(secondFace);
                blockQueue[0] = blockQueue[1].getRelative(thirdFace);
            } else {
                blockQueue[1] = blockQueue[2].getRelative(thirdFace);
                blockQueue[0] = blockQueue[1].getRelative(secondFace);
            }
            thirdError -= gridSize;
            secondError -= gridSize;
            currentBlock = 2;
            return;
        } else if (secondError > 0) {
            blockQueue[1] = blockQueue[0].getRelative(mainFace);
            blockQueue[0] = blockQueue[1].getRelative(secondFace);
            secondError -= gridSize;
            currentBlock = 1;
            return;
        } else if (thirdError > 0) {
            blockQueue[1] = blockQueue[0].getRelative(mainFace);
            blockQueue[0] = blockQueue[1].getRelative(thirdFace);
            thirdError -= gridSize;
            currentBlock = 1;
            return;
        } else {
            blockQueue[0] = blockQueue[0].getRelative(mainFace);
            currentBlock = 0;
            return;
        }
    }
}
