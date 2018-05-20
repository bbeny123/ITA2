package pl.beny;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Calculator {

    static int add(String numbersString) throws NumberFormatException {
        if (!numbersString.isEmpty()) {
            String delimiters = "[,\n]";

            Matcher matcher = Pattern.compile("//.\n").matcher(numbersString);
            if (matcher.find()) {
                delimiters = matcher.group(0).substring(2, 3);
                numbersString = numbersString.substring(4);
            }

            List<Integer> numbers = Arrays.stream(numbersString.split(delimiters)).map(Integer::valueOf).collect(Collectors.toList());

            List<Integer> negatives = numbers.stream().filter(number -> number < 0).collect(Collectors.toList());
            if (negatives.size() != 0) {
                throw new NumberFormatException("negatives not allowed: " + negatives.stream().map(Object::toString).collect(Collectors.joining(", ")));
            }

            return numbers.stream().mapToInt(i -> i).sum();
        }
        return 0;
    }

}
