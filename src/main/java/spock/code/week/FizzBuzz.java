package spock.code.week;

import java.util.LinkedHashMap;

public class FizzBuzz {

    private LinkedHashMap<Integer, String> rules = new LinkedHashMap<>();

    public FizzBuzz() {
        rules.put(15, "FizzBuzz");
        rules.put(5, "Buzz");
        rules.put(3, "Fizz");
    }

    public String play(int round) {
        String replacement = replace(round);
        return (replacement != null) ? replacement : Integer.toString(round);
    }

    public String replace(int round) {
        for (Integer divisor : rules.keySet()) {
            if (canBeDividedBy(round, divisor)) {
                return rules.get(divisor);
            }
        }
        return null;
    }

    private boolean canBeDividedBy(int round, int divisor) {
        return round % divisor == 0;
    }
}