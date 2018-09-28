import java.util.Map;

class OnePairHandExtractor implements HandExtractor {
    Map<CardValue, Integer> valueCounts;

    public OnePairHandExtractor(Map<CardValue, Integer> valueCounts) {
        this.valueCounts = valueCounts;
    }

    // Return the number of unique values for which there exist pairs.
    // e.g. {2, 2, 2, 3, 3, 4, 5} => 2 values for which there exist pairs
    public boolean extract() {
        // Count all values that have at least two occurrences (one pair).
        for (CardValue val : valueCounts.keySet()) {
            if (valueCounts.get(val) >= 2) {
                return true;
            }
        }

        return false;
    }

    public String toString() {
        return "OnePairHandExtractor";
    }

}