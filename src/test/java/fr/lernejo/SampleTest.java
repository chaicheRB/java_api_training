package fr.lernejo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SampleTest {

    private final Sample sample = new Sample();

    @ParameterizedTest
    @CsvSource({
        "ADD, 2, 2, 4",
        "ADD, 0, 7, 7",
        "ADD, -6, 23, 17",
        "MULT, 2, 2, 4",
        "MULT, 3, 4, 12",
    })
    void addition_of_2_and_2_should_be_4(Sample.Operation operation,
                                         int a,
                                         int b,
                                         int expectedResult) {
        int result = sample.op(operation, a, b);

        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void fact_of_4() {
        int result = sample.fact(4);

        Assertions.assertThat(result).isEqualTo(24);
    }

    @Test
    void fact_of_negative_number_throws() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> sample.fact(-3))
            .withMessage("N should be positive");
    }
}
