package spock.code.week;

public class FizzBuzz {

    private NumberSelector selector;
    private Whizz whizz;

    public String play(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("number must be greater than 0");
        }
        if (number % 15 == 0) {
            return "FizzBuzz";
        }
        if (number % 3 == 0) {
            return "Fizz";
        }
        if (number % 5 == 0) {
            return "Buzz";
        }
        if (number % 7 == 0 && whizz != null) {
            return whizz.sayWhizz();
        }
        return String.valueOf(number);
    }

    public String playAdvanced() {
        return play(selector.presetNumber());
    }
}
