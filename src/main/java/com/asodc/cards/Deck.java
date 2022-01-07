package com.asodc.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    /**
     * Construct a standard Deck containing 52 distinct Cards in a random order.
     */
    public Deck() {
        initialiseCards();
        shuffle();
    }

    private void initialiseCards() {
        cards = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    /**
     * Shuffle the Deck.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Deal a single Card from the top of the Deck, reducing the Cards in the Deck by one.
     *
     * @return a List containing the dealt card
     */
    public List<Card> deal() {
        return deal(1);
    }

    /**
     * Deal one or more cards from the top of the Deck, reducing the Cards in the Deck by the number of Cards dealt.
     *
     * @param numberOfCards the number of cards to deal
     * @return a List containing the dealt card(s)
     */
    public List<Card> deal(int numberOfCards) {
        if (numberOfCards <= 0)
            throw new IllegalArgumentException("Invalid number of cards to deal");

        if (numberOfCards > cards.size())
            throw new IllegalArgumentException("Can't deal more cards than there are cards in the deck");

        List<Card> cardsToReturn = new ArrayList<>();

        for (int i = 0; i < numberOfCards; i++) {
            cardsToReturn.add(cards.remove(0));
        }
        return cardsToReturn;
    }

    /**
     * Get a copy of the List of Cards remaining in the Deck.
     *
     * @return the Cards remaining in the Deck
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * The amount of Cards remaining in the Deck.
     *
     * @return the amount of Cards remaining in the deck
     */
    public int size() {
        return cards.size();
    }

    @Override
    public String toString() {
        if (cards.size() == 0)
            return "No cards remaining";

        StringBuilder sb = new StringBuilder();

        for (Card card : cards) {
            sb.append(cards.indexOf(card))
                    .append(": ")
                    .append(card.toString())
                    .append("\r\n");
        }
        return sb.toString();
    }

    // TODO: equals() & hashCode()
}
