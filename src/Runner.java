import java.util.Map;
import java.util.Set;

class Runner {

    public static void main(String[] args) {
        Deck d = new Deck();

        Set<Card> dealt = d.dealNCards(10);

        HandCollector hc = new HandCollector(dealt);

        Map<HandExtractorMap, Integer> collectorMap = hc.collect();
        System.out.println(collectorMap);
        System.out.println(collectorMap.get(HandExtractorMap.OnePairHandExtractor));

        d.prepareForNext(dealt);
    }
}