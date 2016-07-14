package com.github.moreaunicolas.katas.roman;

import java.util.*;

import static java.util.Comparator.reverseOrder;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toMap;

public class RomanNumeral {

    public static int MIN_VALUE = 0;
    public static int MAX_VALUE = 3999;

    public static RomanNumeral valueOf(int arabic) {
        if (arabic < MIN_VALUE) throw new IllegalArgumentException("arabic value should be >= " + MIN_VALUE);
        if (arabic > MAX_VALUE) throw new IllegalArgumentException("arabic value should be <= " + MAX_VALUE);
        return new RomanNumeral(arabic);
    }

    public static RomanNumeral parse(String representation) {
        int arabic = fromRomanRepresentation(representation);
        String canonicalRepresentation = toRomanRepresentation(arabic);
        if (!canonicalRepresentation.equals(representation)) {
            throw invalidRomanNumeral(representation);
        }
        return valueOf(arabic);
    }

    public int intValue() {
        return value;
    }

    @Override
    public String toString() {
        return toRomanRepresentation(value);
    }

    private final int value;

    private RomanNumeral(int value) {
        this.value = value;
    }

    private static final SortedMap<Integer, String> ARABIC_TO_ROMAN_DESCENDING =
            new TreeMap<Integer, String>(reverseOrder()) {{
                put(1000, "M");
                put(900, "CM");
                put(500, "D");
                put(400, "CD");
                put(100, "C");
                put(90, "XC");
                put(50, "L");
                put(40, "XL");
                put(10, "X");
                put(9, "IX");
                put(5, "V");
                put(4, "IV");
                put(1, "I");
            }};

    private static final Map<String, Integer> ROMAN_TO_ARABIC_UNORDERED =
            ARABIC_TO_ROMAN_DESCENDING.entrySet().stream()
                .collect(toMap(Map.Entry::getValue, Map.Entry::getKey));

    private static String toRomanRepresentation(int value) {
        String representation = "";
        for (Integer divisor : ARABIC_TO_ROMAN_DESCENDING.keySet()){
            int occurrences = value / divisor;
            representation += repeatDigit(ARABIC_TO_ROMAN_DESCENDING.get(divisor), occurrences);
            value %= divisor;
        }
        return representation;
    }

    private static String repeatDigit(String what, int count) {
        return String.join("", Collections.nCopies(count, what));
    }

    private static int fromRomanRepresentation(String representation) {
        requireNonNull(representation);
        int result = 0;
        while (!representation.isEmpty()) {
            String romanDigit = nextRomanDigitOrThrow(representation);
            result += ROMAN_TO_ARABIC_UNORDERED.get(romanDigit);
            representation = representation.substring(romanDigit.length());
        }
        return result;
    }

    private static String nextRomanDigitOrThrow(String representation) {
        return ARABIC_TO_ROMAN_DESCENDING.values().stream()
                .filter(representation::startsWith)
                .findFirst()
                .orElseThrow(() -> invalidRomanNumeral(representation));
    }

    private static IllegalArgumentException invalidRomanNumeral(String representation) {
        return new IllegalArgumentException(representation + " is not a valid Roman numeral");
    }
}
