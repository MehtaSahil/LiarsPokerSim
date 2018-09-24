import java.util.*;


class Deck {
    Stack<Card> cards;

    public Deck() {
        cards = new Stack<>();

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

        // For every suit, create all cards
        for (Suit suit : suits) {
            for (CardValue value : cardValues) {
                cards.push(new Card(suit, value));
            }
        }
    }

    public String toString() {
        return cards.toString();
    }

    // Pops n cards from the internal stack of cards as if dealing
    public Set<Card> dealNCards(int n) {
        Set<Card> dealt = new HashSet<>();

        for (int i = 0; i < n; i++) {
            dealt.add(cards.pop());
        }

        return dealt;
    }

    // Pushes the dealt cards back onto the internal stack of cards as if
    // reclaiming after a round
    public void reclaimDealtCards(Set<Card> dealt) {
        for (Card c : dealt) {
            cards.push(c);
        }
    }

    // Returns the deck to a neutral, random state so that the next round can
    // be played. This allows us to use the same Deck object between rounds
    // instead of creating a new object for each round
    public void prepareForNext(Set<Card> dealt) {
        reclaimDealtCards(dealt);

        shuffle();
    }
}