package article

import net.jqwik.api.Arbitraries
import net.jqwik.api.Arbitrary
import net.jqwik.api.ArbitrarySupplier
import net.jqwik.api.ForAll
import net.jqwik.api.From
import net.jqwik.api.Property
import net.jqwik.api.constraints.StringLength
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BodyTest {
    @Test
    fun `正常系 not PBT`() {
        /**
         * given:
         */

        /**
         * when:
         * 1 以上 1024 文字以下であるが、エッジケースではない
         */
        val actual = Body.new("dummy-body")
        val expected = Body.reconstruct("dummy-body")

        /**
         * then:
         */
        assertThat(actual).isEqualTo(expected)
    }

    @Property(tries = 1000)
    fun `正常系 PBT`(@ForAll @StringLength(min = 1, max = 1024) validString: String) {
        /**
         * given:
         */

        /**
         * when:
         */
        val actual = Body.new(validString)
        val expected = Body.reconstruct(validString)

        /**
         * then:
         */
        assertThat(actual).isEqualTo(expected)
    }

    @Property
    fun `異常系 PBT`(@ForAll @StringLength(min = 1025, max = 0) invalidString: String) {
        /**
         * given:
         */

        /**
         * when:
         */
        val e: IllegalArgumentException = assertThrows {
            Body.new(invalidString)
        }
        val actual = e.message
        val expected = "$invalidString は不正な値です。body は 1 以上 1024 文字以下にしてください。"

        /**
         * then:
         */
        assertThat(actual).isEqualTo(expected)
    }

    class BodyValidRange : ArbitrarySupplier<String> {
        override fun get(): Arbitrary<String> = Arbitraries.strings().ofMinLength(1).ofMaxLength(1024)
    }

    @Property
    fun `正常系 PBT with Arbitraries`(
        @ForAll @From(supplier = BodyValidRange::class) validString: String
    ) {
        /**
         * given:
         */

        /**
         * when:
         */
        val actual = Body.new(validString)
        val expected = Body.reconstruct(validString)

        /**
         * then:
         */
        assertThat(actual).isEqualTo(expected)
    }
}
