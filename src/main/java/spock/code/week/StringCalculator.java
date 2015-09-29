package spock.code.week;

public class StringCalculator {

    private static final int MIN_THRESHOLD = 0;
    private static final int MAX_THRESHOLD = 1000;

    private static final String COMMA_OR_NEW_LINE = ",|\n";
    private static final String SEPARATOR_PREFIX = "//";

    private static final String ILLEGAL_ARGUMENT_MESSAGE = "negatives not allowed:";

    private static final int LOTTERY_NUMBER = 1234;
    private static final String HOST = "Merkel";

    Stack stack;
    EasterEgg easterEgg;

    public void setStack(Stack stack) {
        this.stack = stack;
    }

    public void setEasterEgg(EasterEgg easterEgg) {
        this.easterEgg = easterEgg;
    }

    public int add (String numbers) {
        if(numbers.isEmpty()) {
            return 0;
        }
        String[] numberParts = extractSingleNumbers(numbers);
        checkForInvalidNumbers(numberParts);
        return calculateResult(numberParts);
    }

    public int calculateNumberStringFromStack() {
        String numbers = stack.retrieveNextElement();
        return add(numbers);
    }

    private String[] extractSingleNumbers(String command) {
        String[] numberParts;
        if (usesCustomSeparator(command)) {
            numberParts = retrieveNumbersWithCustomSeparator(command);
        }
        else {
            numberParts = command.split(COMMA_OR_NEW_LINE);
        }
        return numberParts;
    }

    private boolean usesCustomSeparator(String command) {
        return command.startsWith(SEPARATOR_PREFIX);
    }

    private String[] retrieveNumbersWithCustomSeparator(String command) {
        String separator = command.substring(2,3);
        command = removeDelimiter(command);
        return command.split(separator);
    }

    private String removeDelimiter(String command) {
        return command.substring(4);
    }

    private void checkForInvalidNumbers(String[] numberParts) {
        String invalidNumbers = "";

        for (String number : numberParts) {
            int numberToAdd = Integer.parseInt(number);
            if (numberToAdd < MIN_THRESHOLD) {
                invalidNumbers = invalidNumbers + " " + number;
            }
        }
        if (!invalidNumbers.isEmpty()) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE + invalidNumbers);
        }
    }

    private int calculateResult(String[] numberParts) {
        int result = 0;

        for(String number : numberParts) {
            int numberToAdd = Integer.parseInt(number);
            if (numberToAdd == LOTTERY_NUMBER) {
                easterEgg.callEasterEgg();
            }
            if (numberToAdd > MAX_THRESHOLD) {
                continue;
            }
            result += numberToAdd;
        }
        return result;
    }
}
