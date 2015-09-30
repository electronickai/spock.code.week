package spock.code.week

import spock.lang.Specification
import spock.lang.Unroll

class FizzBuzzSpec extends Specification {


    public static final String FIZZ = "Fizz"
    public static final String BUZZ = "Buzz"
    public static final String FIZZ_BUZZ = "FizzBuzz"

    @Unroll
    def "If number #param is given than #expected is returned"() {

        when:
        def fizzBuzz = new FizzBuzz()

        then:
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
