package spock.code.week;

public class StringCalculator {

    public static final String REGEX = ",|\n";
    public static final String DELIMITER_START = "//";
    public static final String DELIMITER_END = "\n";

    public int add(String input) {

        if (input == null || input.equals("")) {
            return 0;
        }


        String regex = determineRegex(input);

        String[] numbers = removeDelimiterFrom(input).split(regex);

        int sum = 0;

        for (String number : numbers) {
            try {
                Integer integer = Integer.valueOf(number);
                if (integer.intValue() < 0) {
                    throw new IllegalArgumentException("negatives not allowed");
                }
                sum += integer;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(String.format("%s is not a number", number), e);
            }
        }

        return sum;
    }

    private String removeDelimiterFrom(String input) {
        if (input.startsWith(DELIMITER_START)) {
            return input.replace(DELIMITER_START + determineDelimiter(input) + DELIMITER_END, "");
        }
        return input;
    }

    private String determineRegex(String input) {

        if (input.startsWith(DELIMITER_START)) {
            String delimiter = determineDelimiter(input);
            return addToRegex(delimiter);
        }

        return REGEX;
    }

    private String determineDelimiter(String input) {
        int delimiterEndPos = calculateDelimiterEnd(input);
        return input.substring(0, delimiterEndPos).replace(DELIMITER_START, "");
    }

    private int calculateDelimiterEnd(String input) {
        return input.indexOf(DELIMITER_END);
    }

    private String addToRegex(String delimiter) {
        return REGEX + "|" + delimiter;
    }
}
