package org.bukkit.block;

import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

/**
 * 当方块或实体与正在推拉的活塞交互时, 它们作何反应.
 */
public enum PistonMoveReaction {

    /**
     * 表示方块可以推拉.
     */
    MOVE(0),
    /**
     * 当被活塞推动时, 方块变得脆弱并被破坏.
     */
    BREAK(1),
    /**
     * 表明此方块不能被推或拉.
     */
    BLOCK(2),
    /**
     * 表明实体将忽略任何与活塞的交互.
     * <br>
     * 方块一类应使用 {@link PistonMoveReaction#BLOCK}.
     */
    IGNORE(3),
    /**
     * 表明方块只可被活塞推动, 不能被拉动.
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
    @Nullable
    public static PistonMoveReaction getById(int id) {
        return byId.get(id);
    }
}