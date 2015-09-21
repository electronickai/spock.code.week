package spock.code.week

import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title
import spock.lang.Unroll

@Title("Specification to calculate with strings")
@Narrative("""This test cases are created during a code kata
and are created incrementally.""")
@Subject(StringCalculator)
class StringCalculatorSpec extends Specification {

    @Subject
    private calculator = new StringCalculator()


    def "An empty String will return 0"() {

        when: "empty string is inserted"
        def result = this.calculator.add()

        then: "the result has to be a zero"
        result == 0

    }

    @Unroll
    def "If #input is added, #sum is returned"() {

        expect: "numbers are added as string"
        this.calculator.add(input) == sum

        where: "the sum is returned"

        input                    | sum
        "1,2"                    | 3
        "1,2,3"                  | 6
        "1\n2,3"                 | 6
        "//trenner\n1,2trenner3" | 6

    }

    @Unroll
    def "if delimiter '#input' is given, than the regex '#regex' is determined"() {

        expect: "the input is inserted"
        calculator.determineRegex(input) == regex

        where: "the input is regex"

        input | regex
        "//trenner\n"           | StringCalculator.REGEX + "|" + "trenner"
        "//666\nANY_OTHER_TEXT" | StringCalculator.REGEX + "|" + "666"

    }

    def "if negative number is inserted, than an exception is thrown"() {

        when: "negative number is added"
        calculator.add("-4")

        then: "an exception is thrown"
        IllegalArgumentException e = thrown()
        e.getMessage() == "negatives not allowed"

    }
}