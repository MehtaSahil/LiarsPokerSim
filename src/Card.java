class Card {
    private Suit suit;
    private CardValue value;

    public Card(Suit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    Suit getSuit() {
        return suit;
    }

    CardValue getValue() {
        return value;
    }

    public String toString() {
        return value + " of " + suit;
    }

}