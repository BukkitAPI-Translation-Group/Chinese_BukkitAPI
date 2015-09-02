package org.bukkit.entity;

/**
 * 代表骷髅.
 */
public interface Skeleton extends Monster {

    /**
     * 获取骷髅当前的种类.
     * <p>
     * 原文:Gets the current type of this skeleton.
     *
     * @return 当前的种类
     */
    public SkeletonType getSkeletonType();

    /**
     * 设置骷髅的新种类.
     * <p>
     * 原文:Sets the new type of this skeleton.
     *
     * @param type 新的种类
     */
    public void setSkeletonType(SkeletonType type);

    /*
     * 代表各种不同的骷髅种类.
     */
    public enum SkeletonType {
        NORMAL(0),
        WITHER(1);

        private static final SkeletonType[] types = new SkeletonType[SkeletonType.values().length];
        private final int id;

        static {
            for (SkeletonType type : values()) {
                types[type.getId()] = type;
            }
        }

        private SkeletonType(int id) {
            this.id = id;
        }

        /**
         * 获取骷髅种类ID.
         * <p>
         * 原文:Gets the ID of this skeleton type.
         *
         * @return 骷髅种类ID
         * @deprecated 魔法值
         */
        @Deprecated
        public int getId() {
            return id;
        }

        /**
         * 用ID获取骷髅种类.
         * <p>
         * 原文:Gets a skeleton type by its ID.
         *
         * @param id 用来获取骷髅种类的ID
         * @return 骷髅的种类，如果为null则没有找到
         * @deprecated 魔法值
         */
        @Deprecated
        public static SkeletonType getType(int id) {
            return (id >= types.length) ? null : types[id];
        }
    }
}
