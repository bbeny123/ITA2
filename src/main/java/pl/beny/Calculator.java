package pl.beny;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Calculator {

    static int add(String numbersString) throws NumberFormatException {
        int result = 0;
        if (!numbersString.isEmpty()) {
            List<Integer> numbers = new ArrayList<>();

            String delimiters = getDelimiter(numbersString);
            if (delimiters != null) {
                numbersString = numbersString.substring(4);
            } else {
                delimiters = ",|\n";
            }

            Arrays.asList(numbersString.split(delimiters)).forEach(number -> numbers.add(Integer.parseInt(number)));
            List<Integer> negatives = numbers.stream().filter(number -> number < 0).collect(Collectors.toList());

            if (negatives.size() != 0) {
                throw new NumberFormatException("negatives not allowed: " + negatives.stream().map(Object::toString).collect(Collectors.joining(", ")));
            }

            for (Integer number : numbers) {
                result += number;
            }
        }
        return result;
    }

    private static String getDelimiter(String s) {
        Pattern pattern = Pattern.compile("//.\n");
        Matcher matcher = pattern.matcher(s);
        return matcher.find() ? matcher.group(0).substring(2, 3) : null;
    }

}
