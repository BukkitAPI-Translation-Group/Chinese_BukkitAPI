package org.bukkit.entity;

import org.jetbrains.annotations.NotNull;

/**
 * 代表会施法的灾厄村民 (目前只有唤魔者和幻术师).
 */
public interface Spellcaster extends Illager {

    /**
     * 代表实体当前使用的咒语.
     */
    public enum Spell {

        /**
         * 未施法状态.
         */
        NONE,
        /**
         * 召唤恼鬼.
         */
        SUMMON_VEX,
        /**
         * 召唤尖牙进行攻击.
         */
        FANGS,
        /**
         * 发出"呜噜噜"的叫声.
         */
        WOLOLO,
        /**
         * 使实体隐身的咒语.
         */
        DISAPPEAR,
        /**
         * 使目标生物失明的咒语.
         */
        BLINDNESS;
    }

    /**
     * 获取实体当前使用的{@link Spell 咒语}.
     * <p>
     * 原文:Gets the {@link Spell} the entity is currently using.
     *
     * @return 实体当前使用的{@link Spell 咒语}
     */
    @NotNull
    Spell getSpell();

    /**
     * 设置实体将要使用的{@link Spell 咒语}.
     * <p>
     * 原文:Sets the {@link Spell} the entity is currently using.
     *
     * @param spell 实体将要使用的{@link Spell 咒语}
     */
    void setSpell(@NotNull Spell spell);
}
