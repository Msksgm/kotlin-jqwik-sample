package article

class Article private constructor(val id: Int, val title: Title, val body: Body) {
    companion object {
        /**
         * 新しい記事を作成する
         */
        fun create(id: Int, title: Title, body: Body): Article {
            return Article(
                id = id, title = title, body = body
            )
        }

        /**
         * 記事を再構成する
         * - DB からバリデーションなしで作成するときに利用する
         */
        fun reconstruct(id: Int, title: Title, body: Body): Article {
            return Article(
                id = id, title = title, body = body
            )
        }
    }

    override fun equals(other: Any?): Boolean {
        val otherArticle = other as? Article ?: return false
        return otherArticle.id == id && otherArticle.title == title && otherArticle.body == body
    }

    override fun hashCode(): Int = id + title.hashCode()
}
