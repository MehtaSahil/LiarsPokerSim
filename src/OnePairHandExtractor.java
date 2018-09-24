import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class OnePairHandExtractor implements HandExtractor {
    Map<CardValue, Integer> valueCounts;

    public OnePairHandExtractor(Map<CardValue, Integer> valueCounts) {
        this.valueCounts = valueCounts;
    }

    // Return the number of unique values for which there exist pairs.
    // e.g. {2, 2, 2, 3, 3, 4, 5} => 2 values for which there exist pairs
    public int extract() {
        // Count all values that have at least two occurrences (one pair).
        int num_paired_values = 0;
        for (CardValue val : valueCounts.keySet()) {
            if (valueCounts.get(val) >= 2) {
                num_paired_values++;
            }
        }

        return num_paired_values;
    }

    public String toString() {
        return "OnePairHandExtractor";
    }

}