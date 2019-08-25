package pl.sdacademy.prog.typygen2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class numberUtils {
    public static Double findMedian(final Collection<Integer> values) {
        if (values.isEmpty()) {
            throw new RuntimeException("Cannot calculate median from no values");
        }
        final boolean incorrectValueExists = values.stream()
                .anyMatch(x -> x > 1000);
        if (incorrectValueExists) {
            throw new RuntimeException(" At least one incorrect value detected");
        }
        //new ArrayList<>().sort();
        final List<Integer> sortedValues = values.stream()
                .sorted()
                .collect(Collectors.toList());

        if (sortedValues.size() % 2 == 1) {
            return (double) sortedValues.get(sortedValues.size() / 2);
        }
        final int secondIndex = sortedValues.size() / 2;
        final int firstIndex = secondIndex - 1;
        return (sortedValues.get(firstIndex) + sortedValues.get(secondIndex)) / 2.0;
    }
}
