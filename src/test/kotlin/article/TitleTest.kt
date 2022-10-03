package article

import net.jqwik.api.Arbitraries
import net.jqwik.api.Arbitrary
import net.jqwik.api.ArbitrarySupplier
import net.jqwik.api.ForAll
import net.jqwik.api.From
import net.jqwik.api.Property
import org.assertj.core.api.Assertions.assertThat

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
}
