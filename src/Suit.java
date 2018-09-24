enum Suit {
    SPADES(1),
    HEARTS(2),
    DIAMONDS(3),
    CLUBS(4);

    private int value;

    private Suit(int value) {
        this.value = value;
    }

    public int getRank() {
        return value;
    }
}