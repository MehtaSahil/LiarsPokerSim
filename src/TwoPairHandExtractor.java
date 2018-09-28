import java.util.Map;

/**
 * Created by sahil on 9/28/18.
 */


public class TwoPairHandExtractor implements HandExtractor {
    private Map<CardValue, Integer> valueCounts;

    public TwoPairHandExtractor(Map<CardValue, Integer> valueCounts) {
        this.valueCounts = valueCounts;
    }

    public boolean extract() {
        int pair_count = 0;

        for (CardValue val : valueCounts.keySet()) {
            if (valueCounts.get(val) >= 2) {
                pair_count++;
            }
        }

        return pair_count >= 2;
    }

    public String toString() {
        return "TwoPairHandExtractor";
    }

}
