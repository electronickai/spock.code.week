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
        input | result
        "1"   | 1
        "1,2" | 3
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

    @See("Task 7")
    def "The calculator string is retrieved by the Stack, the result is calculated as well"() {
        given: "A stub of the stack"
        Stack stack = Stub(Stack)
        stack.retrieveNextElement() >> "1,2,3,4"
        and: "the calculator with the stubbed stack"
        calculator.setStack(stack)
        expect: "The sum of the numbers of the string in the stack"
        calculator.calculateNumberStringFromStack() == 10
    }

    @See("Task 8")
    def "The easteregg method is called in case 1234 is contained in the string"() {
        given: "A mock of the easter egg"
        EasterEgg easterEgg = Mock(EasterEgg)
        and: "A calculator with the easter egg"
        calculator.setEasterEgg(easterEgg)
        when: "The calculator is started with 6666"
        calculator.add("1,4,6666")
        then: "The easterEgg method is called"
        0 * easterEgg.callEasterEgg()
        when: "The calculator is started with 1234"
        calculator.add("1,4,1234")
        then: "The easterEgg method is called"
        1 * easterEgg.callEasterEgg()
    }
}