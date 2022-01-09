package com.asodc.cards;

import java.util.Objects;

public class Card {
    private final Rank rank;
    private final Suit suit;

    /**
     * Create a card with a certain Rank and Suit.
     *
     * @param rank the Rank of the Card
     * @param suit the Suit of the Card
     */
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Get the Rank of the Card.
     *
     * @return the Rank of the card
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Get the Suit of the Card.
     *
     * @return the Suit of the Card
     */
    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return getRank() + " of " + getSuit();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Card) {
            Card otherCard = (Card) obj;
            Rank otherRank = otherCard.getRank();
            Suit otherSuit = otherCard.getSuit();

            return (this.getRank() == otherRank) && (this.getSuit() == otherSuit);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}
