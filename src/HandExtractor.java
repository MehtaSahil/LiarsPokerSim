import java.util.Set;

/*
HandExtractor defines an interface for all HandExtractors
There will exist one HandExtractor for each type of hand
(e.g. OnePairHandExtractor) that will handle the logic for extracting that
particular type of hand from a set of cards

The results of running all HandExtractors on the set of dealt cards will
yield information useful for calculating probabilities

Given a set of dealt cards, determine how may
*/
interface HandExtractor {

    //return the number of hands of this type present in the dealt cards
    public int extract(Set<Card> dealt);

}