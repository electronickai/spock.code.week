package spock.code.week

import geb.spock.GebReportingSpec
import spock.lang.Stepwise

@Stepwise
class CalculatorFunctionalSpec extends GebReportingSpec {

    def "there is a welcome on the main page"() {
        when: "we go to the main page"
        go()
        then: "A welcome is stated"
        $("h1").text() == "Herzlich Willkommen zum Spock Workshop"
    }

    def "Calculation can be done on the calculator page"() {
        when: "we go to the calculator page"
        go "calculator"
        then:"the string calculator is displayed"
        $("#Content legend").text() == "Your String Calculator"
    }

    def "A sum of an entered string can be calculated"() {
        when: "A calculation string is entered"
        $("#numbers").value("1,2,3,4,5")
        and: "The button is clicked"
        $("#calculate").click()
        then: "The sum on the numbers is shown"
        $("#adderResult").value() == "15"
    }

    def "The history page shows the entry just calculated"() {
        when: "The history tab is opened"
        go "calculatorHistory"
        then: "We are on the history page"
        $("#list-calculatorHistory h1").text() == "CalculatorHistory List"
        then: "The entry is contained in the list"
        $("#list-calculatorHistory tbody a").text() == "1,2,3,4,5"
    }
}
