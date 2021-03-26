public class BullsAndCows {

    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 4;

    private int bulls;
    private int cows;

    public BullsAndCows() {
    }

    public BullsAndCows(int bulls, int cows) {
        if (isValid(bulls, cows)) {
            this.bulls = bulls;
            this.cows = cows;
        }
    }

    public int getBulls() {
        return this.bulls;
    }

    public int getCows() {
        return this.cows;
    }

    public static boolean isValid(int bulls, int cows) {
        return bulls >= MIN_VALUE && bulls <= MAX_VALUE && cows >= MIN_VALUE && cows <= MAX_VALUE;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BullsAndCows)) {
            return false;
        }
        BullsAndCows bullsAndCows = (BullsAndCows) o;
        return bulls == bullsAndCows.bulls && cows == bullsAndCows.cows;
    }

    @Override
    public String toString() {
        return "{" + " bulls='" + getBulls() + "'" + ", cows='" + getCows() + "'" + "}";
    }

}
