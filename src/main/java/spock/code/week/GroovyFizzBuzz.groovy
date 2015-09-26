package spock.code.week

class GroovyFizzBuzz {

    def rules = [3:"Fizz", 5:"Buzz", 15:"FizzBuzz"]

    public String play(int round) {
        def result = ""
        rules.each {divisor, replacement ->
            if (hasToBeReplaced(round, divisor)) {
                result = replacement;
            }
        }
        result ?: round.toString()
    }

    private static boolean hasToBeReplaced(int round, int divisor) {
        round % divisor == 0;
    }
}