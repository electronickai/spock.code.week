package spock.code.week

import spock.lang.*

@Title("Fizz Buzz Kata")
@Narrative("""
A Specification for the Fizz Buzz Kata
within the scope of the code week workshop """)
class FizzBuzzSpec extends Specification {

    public static final String FIZZ = "Fizz"
    public static final String BUZZ = "Buzz"
    public static final String FIZZ_BUZZ = "FizzBuzz"
    public static final String WHIZZ = "Whizz"

    @Subject
    FizzBuzz fizzBuzz = new FizzBuzz()

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

    @Unroll
    @See("An example using a stub")
    def "In advanced mode the number is specified (#stubResult results to #fizzBuzzResult)"() {
        given: "A stub of the number selector"
        NumberSelector selector = Stub(NumberSelector)
        selector.presetNumber() >> stubResult
        and: "A FizzBuzz with the stubbed selector"
        fizzBuzz.selector = selector
        expect: "The correct result"
        fizzBuzz.playAdvanced() == fizzBuzzResult
        where:
        stubResult || fizzBuzzResult
        3          || FIZZ
        5          || BUZZ
        15         || FIZZ_BUZZ
        19         || "19"
    }

    @See("An example using a mock")
    def "For a number that can be devided by 7, the sayWhizz method is called"() {
        given: "A Mock of a Whizz"
        Whizz whizz = Mock(Whizz)
        and: "A FizzBuzz with the Whizz"
        fizzBuzz.whizz = whizz

        when: "The number that can't be divided by 7"
        def result = fizzBuzz.play(6)
        then: "The mock isn't called"
        0 * whizz.sayWhizz()
        result == FIZZ

        when: "The number that can be divided by 7"
        result = fizzBuzz.play(7)
        then: "The mock is called"
        1 * whizz.sayWhizz() >> WHIZZ
        result == WHIZZ
    }
}
