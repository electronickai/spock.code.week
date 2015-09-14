package spock.code.week

import spock.lang.Specification
import spock.lang.Unroll

class FizzBuzzSpec extends Specification {


    public static final String FIZZ = "Fizz"

    @Unroll
    def "If number #param is given than #expected is returned"() {

        when:
        def calculator = new FizzBuzz()

        then:
        expected == calculator.calculate(param)

        where:
        param || expected
        1     || "1"
        2     || "2"
        3     || FIZZ
        4     || "4"
        5     || "Buzz"
        6     || FIZZ
        7     || "7"
        8     || "8"
    }

}
