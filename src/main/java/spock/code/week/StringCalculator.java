package spock.code.week;

public class StringCalculator {

    private static final String COMMA_OR_NEW_LINE = ",|\n";
    private static final String SEPARATOR_PREFIX = "//";

    public int add (String numbers) {
        if(numbers.isEmpty()) {
            return 0;
        }
        String[] numberParts = extractSingleNumbers(numbers);
        return calculateResult(numberParts);
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

    private int calculateResult(String[] numberParts) {
        int result = 0;
        for(String numberPart : numberParts) {
            result += Integer.parseInt(numberPart);
        }
        return result;
    }
}
