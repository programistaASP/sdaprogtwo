package pl.sdacademy.prog.typygen2;


import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertThrows;


class numberUtilsTest {
    @Test
    void shouldFindMedianWhenEvenNumbersInInput() {
        final Collection<Integer> values = Arrays.asList(1, 2, 3, 4);
        final Double expectedMedian = 2.5;

        final Double actualMedian = numberUtils.findMedian(values);
        assertThat(actualMedian).isEqualTo(expectedMedian);

    }

    @Test
    void shouldThrowExceptionWhenInputCollectionIsEmpty() {
        final Collection<Integer> values = Collections.emptyList();

        final RuntimeException exception = assertThrows(RuntimeException.class,
                () -> numberUtils.findMedian(values));
        assertThat(exception.getMessage())
                .isEqualTo("Cannot calculate median from no values");
    }
    @Test
    void ahouldThrowsExceptionWhenIncorrectValue() {
        final Collection<Integer> values = Collections.singleton(1001);

        final RuntimeException exception = assertThrows(RuntimeException.class,
                () ->numberUtils.findMedian(values));

        assertThat(exception.getMessage())
                .isEqualTo("At least one incorrect value detected");
    }
    @Test
    void shouldThrowsExceptionWhenIncorrectValueV2() {
        final Collection<Integer> values = Collections.singleton(1001);

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> numberUtils.findMedian(values))
                .withMessage("At least one incorrect value detected");
    }
}