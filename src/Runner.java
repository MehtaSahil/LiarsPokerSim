import java.util.Set;

class Runner {

    public static void main(String[] args) {
        Deck d = new Deck();

        Set<Card> dealt = d.dealNCards(10);

        HandCollector hc = new HandCollector(dealt);
        System.out.println(dealt);
        hc.collect();

        d.prepareForNext(dealt);
    }
}