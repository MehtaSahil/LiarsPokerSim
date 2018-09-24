import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class OnePairHandExtractor implements HandExtractor {

    // Return the number of unique values for which there exist pairs
    public int extract(Set<Card> dealt) {
        Map<CardValue, Integer> counts = new HashMap<>();

        for (Card c : dealt) {
            CardValue val = c.getValue();

            // Create key, value pair if it does not exist
            if (!counts.containsKey(val)) {
                counts.put(val, 0);
            }

            // Increment value
            counts.put(val, counts.get(val) + 1);
        }

        // TODO: Decide if we want to distinguish between pairs of the same value
        // Count all values that have at least two occurrences (one pair).
        // Maximum of one pair counted per value
        int num_paired_values = 0;
        for (CardValue val : counts.keySet()) {
            if (counts.get(val) >= 2) {
                num_paired_values++;
            }
        }

        return num_paired_values;
    }

}