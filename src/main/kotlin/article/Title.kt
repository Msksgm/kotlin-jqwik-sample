package article

interface Title {
    val value: String

    /**
     * Factory メソッド
     */
    companion object {
        /**
         * バリデーションあり
         *
         * @param title
         * @return
         */
        fun new(title: String): Title {
            if (title.isEmpty() || title.length > 32) {
                throw IllegalArgumentException("$title は不正な値です。title は 1 文字以上 32 文字以下にしてください")
            }

            return TitleImpl(title)
        }

        /**
         * バリデーションなし
         *
         * @param title
         * @return
         */
        fun reconstruct(title: String): Title = TitleImpl(title)
    }

    /**
     * 実装
     */
    private data class TitleImpl(override val value: String) : Title
}
