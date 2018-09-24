import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class HandCollector {
    private Map<HandExtractorMap, HandExtractor> extractors;
    private Map<CardValue, Integer> valueCounts;
    private Map<Suit, Integer> suitCounts;

    public HandCollector(Set<Card> dealt) {
        extractors = new HashMap<>();
        valueCounts = new HashMap<>();
        suitCounts = new HashMap<>();

        initializeCounts(dealt);
        initializeExtractors();
    }

    // Precompute these maps and then pass them to extractors
    private void initializeCounts(Set<Card> dealt) {
        for (Card c : dealt) {
            CardValue val = c.getValue();
            Suit suit = c.getSuit();

            // Create key, value pairs if they do not exist
            if (!valueCounts.containsKey(val)) {
                valueCounts.put(val, 0);
            }

            if (!suitCounts.containsKey(suit)) {
                suitCounts.put(suit, 0);
            }


            // Increment values
            valueCounts.put(val, valueCounts.get(val) + 1);
            suitCounts.put(suit, suitCounts.get(suit) + 1);
        }
    }

    private void initializeExtractors() {
        extractors.put(HandExtractorMap.OnePairHandExtractor, new OnePairHandExtractor(valueCounts));
    }

    public Map<HandExtractorMap, Integer> collect() {
        Map<HandExtractorMap, Integer> extractorValues = new HashMap<>();

        for (HandExtractorMap he : extractors.keySet()) {
            extractorValues.put(he, extractors.get(he).extract());
        }

        return extractorValues;
    }
}