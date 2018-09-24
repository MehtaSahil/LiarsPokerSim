import java.util.Map;
import java.util.Set;

class Runner {

    public static void main(String[] args) {
        Deck d = new Deck();

        int num_trials = 10000;

        for (int i = 1; i <= 52; i++) {

            double probability = 0;

            // Deal i cards num_trials times and count the number of times a hand shows up
            // Then calculate the probability
            for (int trial = 0; trial < num_trials; trial++) {
                Set<Card> dealt = d.dealNCards(i);

                HandCollector hc = new HandCollector(dealt);
                Map<HandExtractorMap, Integer> collectorMap = hc.collect();

                if (collectorMap.get(HandExtractorMap.OnePairHandExtractor) > 0) {
                    probability += 1;
                }

                // Return the cards and shuffle for next deal
                d.prepareForNext(dealt);
            }

            probability /= num_trials;
            System.out.println(i + ", " + probability);
        }
    }
}