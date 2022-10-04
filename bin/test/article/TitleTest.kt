package article

import net.jqwik.api.Arbitraries
import net.jqwik.api.Arbitrary
import net.jqwik.api.ArbitrarySupplier
import net.jqwik.api.ForAll
import net.jqwik.api.From
import net.jqwik.api.Property
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

class TitleTest {
    class TitleValidRange : ArbitrarySupplier<String> {
        override fun get(): Arbitrary<String> = Arbitraries.strings().ofMinLength(1).ofMaxLength(32)
    }

    @Property
    fun `正常系 PBT with Arbitraries`(@ForAll @From(supplier = TitleValidRange::class) validString: String) {
        /**
         * given:
         */

        /**
         * when:
         */
        val actual = Title.new(validString)
        val expected = Title.reconstruct(validString)

        /**
         * then:
         */
        assertThat(actual).isEqualTo(expected)
    }

    class TitleInvalidRange : ArbitrarySupplier<String> {
        override fun get(): Arbitrary<String> = Arbitraries.strings().filter{ it.isEmpty() || it.length > 32}
    }

    @Property
    fun `異常系 PBT with Arbitraries`(@ForAll @From(supplier = TitleInvalidRange::class) invalidString: String) {
        /**
         * given
         */

        /**
         * when
         */
        val e: java.lang.IllegalArgumentException = assertThrows {
            Title.new(invalidString)
        }
        val actual = e.message
        val expected = "$invalidString は不正な値です。title は 1 文字以上 32 文字以下にしてください"

        /**
         * then
         */
        assertThat(actual).isEqualTo(expected)
    }
}
