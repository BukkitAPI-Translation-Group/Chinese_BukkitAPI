package org.bukkit.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表唤魔者.
 */
public interface Evoker extends Spellcaster {

    /**
     * 代表唤魔者当前使用的咒语.
     * <p>
     * 原文:Represents the current spell the Evoker is using.
     *
     * @deprecated 将来 Minecraft 会有更多的可施法的生物
     */
    @Deprecated
    public enum Spell {

        /**
         * 未施法状态.
         */
        NONE,
        /**
         * 召唤恼鬼.
         */
        SUMMON,
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
     * 获取唤魔者当前使用的{@link Spell 咒语}.
     * <p>
     * 原文:Gets the {@link Spell} the Evoker is currently using.
     *
     * @return 唤魔者当前使用的咒语
     * @deprecated 将来 Minecraft 会有更多的可施法的生物
     */
    @Deprecated
    @NotNull
    Spell getCurrentSpell();

    /**
     * 设置唤魔者将要使用的{@link Spell 咒语}.
     * <p>
     * 原文:Sets the {@link Spell} the Evoker is currently using.
     *
     * @param spell 唤魔者应使用的咒语
     * @deprecated 将来 Minecraft 会有更多的可施法的生物
     */
    @Deprecated
    void setCurrentSpell(@Nullable Spell spell);
}
