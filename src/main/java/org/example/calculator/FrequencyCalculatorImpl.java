package org.example.calculator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyCalculatorImpl implements FrequencyCalculator {
    @Override
    public Map<Character, Integer> calculateFrequency(List<Character> characters) {

        return characters.stream()
                .collect(Collectors.groupingBy(
                        character -> character,
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
                ));


    }

}
