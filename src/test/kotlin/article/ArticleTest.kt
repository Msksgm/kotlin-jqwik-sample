package article

import net.jqwik.api.ForAll
import net.jqwik.api.From
import net.jqwik.api.Property

class ArticleTest {
    @Property
    fun `正常系 PBT`(
        @Suppress("unused") @ForAll @From(supplier = TitleTest.TitleInvalidRange::class) title: String,
        @Suppress("unused") @ForAll @From(supplier = BodyTest.BodyValidRange::class) body: String,
    ) {
        // テストを記述する
    }
}
