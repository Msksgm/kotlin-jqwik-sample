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
                TODO()
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
