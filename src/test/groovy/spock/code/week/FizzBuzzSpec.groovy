package spock.code.week

import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title
import spock.lang.Unroll

@Title("Fizz Buzz Kata")
@Narrative("""
A Specification for the Fizz Buzz Kata
that can be found """)
class FizzBuzzSpec extends Specification {

    public static final String FIZZ = "Fizz"
    public static final String BUZZ = "Buzz"
    public static final String FIZZ_BUZZ = "FizzBuzz"

    @Unroll
    def "If number #param is given than #expected is returned"() {
        given:
        def fizzBuzz = new FizzBuzz()

        expect:
        expected == fizzBuzz.play(param)

        where:
        param || expected
        1     || "1"
        2     || "2"
        3     || FIZZ
        4     || "4"
        5     || BUZZ
        6     || FIZZ
        7     || "7"
        8     || "8"
        9     || FIZZ
        10    || BUZZ
        15    || FIZZ_BUZZ
        20    || BUZZ
    }

}
