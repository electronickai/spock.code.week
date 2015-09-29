package spock.code.week

import spock.lang.*

@Title("String Calculator Kata")
@Narrative("""List of all requirements that are stated in the TDD Kata
based on http://osherove.com/tdd-kata-1/""")
class StringCalculatorSpec extends Specification {

    def calculator = new StringCalculator();

    @See("Part of Task 1")
    def "For an empty string 0 is returned"() {
        expect:
        calculator.add("") == 0
    }

    @Unroll
    @See("Other part of Task 1")
    def "Calling add with the input of #input returns #result"() {
        expect:
        calculator.add(input) == result

        where:
        input       | result
            "1"     |   1
          "1,2"     |   3
    }

    @See("Task 2")
    def "Calculator can add an 'unlimited' number of values"() {
        expect:
        calculator.add("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15") == 120
    }

    @See("Task 3")
    def "New line and comma are valid separators of the numbers"() {
        expect:
        calculator.add("1\n2,3") == 6
    }

    @See("Task 4")
    def "Support any character as separator "() {
        expect:
        calculator.add("//;\n1;2") == 3
    }

    @See("Task 5")
    def "Using a negative number throws an exception"() {
        when: "calculator shall add a negative number"
        calculator.add("1,-1,5,-5")
        then: "an exception is thrown"
        IllegalArgumentException e = thrown()
        e.message == "negatives not allowed: -1 -5"
    }

    @See("Task 6")
    def "Numbers greater than 1000 are ignored"() {
        expect:
        calculator.add("2,1001") == 2
    }
}