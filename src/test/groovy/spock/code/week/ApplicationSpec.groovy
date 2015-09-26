package spock.code.week

import spock.lang.Specification
import spock.lang.Unroll

class ApplicationSpec extends Specification {

    @Unroll
    def "In the #round of FizzBuzz, the correct answer is #result"() {
        given: "a fizz buzz game"
        def fizzBuzz = new GroovyFizzBuzz()
        expect: "the correct answer of the round #round is #result"
        fizzBuzz.play(round) == result

        where:
        round << (1..21).collect()
        result << ["1","2", "Fizz", "4","Buzz", "Fizz", "7","8", "Fizz", "Buzz", \
                   "11","Fizz", "13", "14","FizzBuzz", "16", "17","Fizz", "19", "Buzz", \
                   "Fizz"]
    }

}