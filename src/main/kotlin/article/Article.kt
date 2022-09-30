package article

class Article(val id: Int, val title: String, val body: String) {
    override fun equals(other: Any?): Boolean {
        val otherArticle = other as? Article ?: return false
        return otherArticle.id == id && otherArticle.title == title && otherArticle.body == body
    }

    override fun hashCode(): Int = id + title.hashCode()
}
