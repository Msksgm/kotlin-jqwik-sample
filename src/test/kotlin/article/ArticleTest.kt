package article

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ArticleTest {
    @Test
    fun `正常系`() {
        /**
         * given:
         */

        /**
         * when:
         */
        val actual = Article(1, "dummy-title", "dummy-body")
        val expected = Article(1, "dummy-title", "dummy-body")

        /**
         * then:
         */
        assertThat(actual).isEqualTo(expected)
    }
}