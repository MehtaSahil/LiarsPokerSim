import java.util.Map;
import java.util.Set;

class Runner {

    public static void main(String[] args) {
        Deck d = new Deck();

        Set<Card> dealt = d.dealNCards(50);

        HandCollector hc = new HandCollector(dealt);
//        System.out.println(dealt);

        Map<HandExtractor, Integer> collectorMap = hc.collect();
        System.out.println(collectorMap);

        d.prepareForNext(dealt);
    }
}