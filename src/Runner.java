import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Runner {

    public static void main(String[] args) {
        Deck d = new Deck();

        Map<HandExtractorMap, Double> probabilities = new HashMap<>();

        // Initialize all probabilities to zero
        for (HandExtractorMap mapping : HandExtractorMap.values()) {
            probabilities.put(mapping, 0.0);
        }

        // Main simulation loop
        int num_trials = 10000;
        for (int i = 1; i <= 52; i++) {

            // Deal i cards num_trials times and count the number of times a hand shows up
            // Then calculate the probability
            for (int trial = 0; trial < num_trials; trial++) {
                Set<Card> dealt = d.dealNCards(i);

                HandCollector hc = new HandCollector(dealt);
                Map<HandExtractorMap, Boolean> collectorMap = hc.collect();

                // Count the different hands
                for (HandExtractorMap mapping : HandExtractorMap.values()) {
                    if (collectorMap.get(mapping)) {
                        probabilities.put(
                            mapping,
                            probabilities.get(mapping) + 1
                        );
                    }
                }

                // Return the cards and shuffle for next deal
                d.prepareForNext(dealt);
            }

            // Calculate probabilities
            for (HandExtractorMap mapping : HandExtractorMap.values()) {
                probabilities.put(
                    mapping,
                    probabilities.get(mapping) / num_trials
                );
            }

            // Output probabilities
            System.out.print(i + " : ");
            for (HandExtractorMap mapping : HandExtractorMap.values()) {
                System.out.print(probabilities.get(mapping) + " : ");
            }
            System.out.println();
        }
    }
}