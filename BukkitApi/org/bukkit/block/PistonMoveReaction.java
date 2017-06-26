package org.bukkit.block;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents how a block or entity will react when interacting with a piston
 * when it is extending or retracting.
 */
public enum PistonMoveReaction {

    /**
     * 表示方块可以推拉.
     */
    MOVE(0),
    /**
     * 如果此方块被退而破坏,则表明方块是脆弱的.
     */
    BREAK(1),
    /**
     * 表明此方块不能被推或拉.
     */
    BLOCK(2),
    /**
     * Indicates that the entity will ignore any interaction(s) with
     * pistons.
     * <br>
     * Blocks should use {@link PistonMoveReaction#BLOCK}.
     */
    IGNORE(3),
    /**
     * Indicates that the block can only be pushed by pistons, not pulled.
     */
    PUSH_ONLY(4);

    private int id;
    private static Map<Integer, PistonMoveReaction> byId = new HashMap<Integer, PistonMoveReaction>();
    static {
        for (PistonMoveReaction reaction : PistonMoveReaction.values()) {
            byId.put(reaction.id, reaction);
        }
    }

    private PistonMoveReaction(int id) {
        this.id = id;
    }

    /**
     * @return 此移动的反应ID
     * @deprecated 不安全的参数
     */
    @Deprecated
    public int getId() {
        return this.id;
    }

    /**
     * @param id ID
     * @return 这个移动反应的ID
     * @deprecated 不安全的参数
     */
    @Deprecated
    public static PistonMoveReaction getById(int id) {
        return byId.get(id);
    }
}