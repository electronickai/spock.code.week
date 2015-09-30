package spock.code.week

import spock.lang.*

@Title("Fizz Buzz Kata")
@Narrative("""
A Specification for the Fizz Buzz Kata
that can be found """)
class FizzBuzzSpec extends Specification {

    public static final String FIZZ = "Fizz"
    public static final String BUZZ = "Buzz"
    public static final String FIZZ_BUZZ = "FizzBuzz"

    @Shared
    def fizzBuzz = new FizzBuzz()

    @Unroll
    @See("Basic Kata")
    def "If number #param is given than #expected is returned"() {
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

    @See("Extension to check for exceptions")
    def "Fizz Buzz throws an exception when called with numbers smaller than 1"() {
        when: "The play method is called with 0"
        fizzBuzz.play(0)
        then: "An IllegalArgumentException is thrown"
        IllegalArgumentException e = thrown()
        e.message == "number must be greater than 0"
    }

}
