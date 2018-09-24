import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Deck {
    List<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();

        initialize();
        shuffle();
    }

    public List<Card> getCards() {
        return cards;
    }

    private void shuffle() {
        Collections.shuffle(cards);
    }

    // Create 52 card deck
    private void initialize() {
        Suit[] suits = Suit.values();
        CardValue[] cardValues = CardValue.values();

        for (Suit s : suits) {
            for (CardValue v : cardValues) {
                cards.add(new Card(s, v));
            }
        }
    }

    public String toString() {
        return cards.toString();
    }
}