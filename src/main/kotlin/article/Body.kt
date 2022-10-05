package article

interface Body {
    val value: String

    /**
     * Factory メソッド
     */
    companion object {
        private const val maximum = 1024

        /**
         * バリデーションあり
         *
         * @param body
         * @return
         */
        fun new(body: String): Body {
            if (body.isEmpty() || body.length > maximum) {
                throw IllegalArgumentException("$body は不正な値です。body は 1 以上 $maximum 文字以下にしてください。")
            }

            return BodyImpl(body)
        }

        /**
         * バリデーションなし
         * DB から生成時 or new メソッドのテストにつかう
         *
         * @param body
         * @return
         */
        fun reconstruct(body: String): Body = BodyImpl(body)
    }

    /**
     * 実装
     */
    private data class BodyImpl(override val value: String) : Body
}
