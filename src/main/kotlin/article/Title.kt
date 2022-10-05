package article

interface Title {
    val value: String

    /**
     * Factory メソッド
     */
    companion object {
        private const val maximum: Int = 32

        /**
         * バリデーションあり
         *
         * @param title
         * @return
         */
        fun new(title: String): Title {
            if (title.isEmpty() || title.length > maximum) {
                throw IllegalArgumentException("$title は不正な値です。title は 1 文字以上 $maximum 文字以下にしてください")
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
