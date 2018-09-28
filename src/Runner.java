import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Runner {

    public static void main(String[] args) {
        Deck d = new Deck();

        Map<HandExtractorMap, Double> probabilities = new HashMap<>();
        probabilities.put(HandExtractorMap.OnePairHandExtractor, 0.0);
        probabilities.put(HandExtractorMap.TwoPairHandExtractor, 0.0);

        int num_trials = 10000;
        for (int i = 1; i <= 52; i++) {

            // Deal i cards num_trials times and count the number of times a hand shows up
            // Then calculate the probability
            for (int trial = 0; trial < num_trials; trial++) {
                Set<Card> dealt = d.dealNCards(i);

                HandCollector hc = new HandCollector(dealt);
                Map<HandExtractorMap, Boolean> collectorMap = hc.collect();

                if (collectorMap.get(HandExtractorMap.OnePairHandExtractor)) {
                    probabilities.put(
                        HandExtractorMap.OnePairHandExtractor,
                        probabilities.get(HandExtractorMap.OnePairHandExtractor) + 1
                    );
                }

                if (collectorMap.get(HandExtractorMap.TwoPairHandExtractor)) {
                    probabilities.put(
                            HandExtractorMap.TwoPairHandExtractor,
                            probabilities.get(HandExtractorMap.TwoPairHandExtractor) + 1
                    );
                }

                // Return the cards and shuffle for next deal
                d.prepareForNext(dealt);
            }

            probabilities.put(
                HandExtractorMap.OnePairHandExtractor,
                probabilities.get(HandExtractorMap.OnePairHandExtractor) / num_trials
            );

            probabilities.put(
                    HandExtractorMap.TwoPairHandExtractor,
                    probabilities.get(HandExtractorMap.TwoPairHandExtractor) / num_trials
            );

            System.out.print(i + " : " + probabilities.get(HandExtractorMap.OnePairHandExtractor) + " : ");
            System.out.println(probabilities.get(HandExtractorMap.TwoPairHandExtractor));
        }
    }
}