package spock.code.week

import spock.lang.Specification

class StringCalculatorSpec extends Specification {

    def calculator = new StringCalculator();

    def "For an empty string 0 is returned"() {
        expect:
        calculator.add("") == 0
    }

    def "calling add returns the sum of each number"() {
        expect:
        calculator.add(input) == result

        where:
        input       | result
            "1"     |   1
          "1,2"     |   3
    }
    
    def "calculator can add an 'unlimited' number of values"() {
        expect:
        calculator.add("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15") == 120
    }

    def "new line and comma are valid separators of the numbers"() {
        expect:
        calculator.add("1\n2,3") == 6
    }

    def "support any character as separator "() {
        expect:
        calculator.add("//;\n1;2") == 3
    }
}