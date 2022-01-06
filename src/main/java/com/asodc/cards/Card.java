package com.asodc.cards;

public class Card {
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return getRank()+ " of " + getSuit();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Card) {
            Card otherCard = ((Card) obj);
            Rank otherRank = otherCard.getRank();
            Suit otherSuit = otherCard.getSuit();

            return (this.getRank() == otherRank) && (this.getSuit() == otherSuit);
        }
        return false;
    }

    @Override
    public int hashCode() {
        // TODO: implement hashCode
        return 1;
    }
}
