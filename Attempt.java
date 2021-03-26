import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Attempt object for the bulls and cows game
 * 
 * @author Itay Schechner
 */
public class Attempt {

    public static final int MIN_VALUE = 1000;
    public static final int MAX_VALUE = 9999;

    private int[] value;
    private BullsAndCows bullsAndCows;

    public Attempt() {
        value = new int[] { 1, 0, 2, 3 };
    }

    public Attempt(int[] value) {
        this.value = value;
        validateValue();
    }

    public Attempt(int value) {
        this.value = buildValueArray(value);
        validateValue();
    }

    public int[] getValue() {
        return this.value;
    }

    private static int[] buildValueArray(int value) {

        if (value < MIN_VALUE || value > MAX_VALUE)
            throw new AttemptInvalidException("value must be a valid integer");

        List<Integer> digits = new ArrayList<>();
        while (value > 0) {
            digits.add(value % 10);
            value /= 10;
        }
        Collections.reverse(digits);
        return digits.stream().mapToInt(i -> i).toArray();
    }

    // validation of attempt
    private void validateValue() {

        if (!isAttemptValid(value))
            throw new AttemptInvalidException();
    }

    public static boolean isAttemptValid(int[] value) {

        // check if value's length is 4
        if (value.length != BullsAndCows.MAX_VALUE)
            return false;

        // check if first digit is not 0
        if (value[0] == 0)
            return false;

        // check if all values are unique
        Set<Integer> valueAsSet = Arrays.stream(value).boxed().collect(Collectors.toSet());
        if (valueAsSet.size() != value.length)
            return false;

        return true;
    }

    public static boolean isAttemptValid(int value) {
        try {
            return isAttemptValid(buildValueArray(value));
        } catch (Exception e) {
            return false;
        }
    }

    public static class AttemptInvalidException extends RuntimeException {

        /**
         *
         */
        private static final long serialVersionUID = -6124054568957209950L;

        public AttemptInvalidException() {
            super();
        }

        public AttemptInvalidException(String reason) {
            super(reason);
        }

    }

    // bulls and cows

    public BullsAndCows bullsAndCows(Attempt other) {
        int cows = 0, bulls = 0;
        for (int i = 0; i < value.length; i++) {
            if (value[i] == other.value[i])
                bulls++;
            else {
                for (int j = 0; j < value.length; j++) {
                    if (value[i] == other.value[j])
                        cows++;
                }
            }
        }
        return new BullsAndCows(bulls, cows);
    }

    public BullsAndCows getBullsAndCows() {
        return bullsAndCows;
    }

    public void setBullsAndCows(BullsAndCows bullsAndCows) {
        this.bullsAndCows = bullsAndCows;
    }

    @Override
    public String toString() {
        String result = "";
        for (int digit : value)
            result += digit;
        return result;
    }

}
