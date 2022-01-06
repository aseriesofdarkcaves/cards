package com.asodc.cards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardTests {
    public static final String EQUALS_MESSAGE = "Cards must be equal";
    public static final String NON_EQUALS_MESSAGE = "Cards must not be equal";
    public static final String NON_NULL_MESSAGE = "Card cannot be null";

    @Test
    public void equalsExplicit() {
        Card card1 = new Card(Rank.ACE, Suit.SPADES);
        Card card2 = new Card(Rank.ACE, Suit.SPADES);

        Assertions.assertNotNull(card1, NON_NULL_MESSAGE);
        Assertions.assertNotNull(card2, NON_NULL_MESSAGE);

        Assertions.assertEquals(card1, card2, EQUALS_MESSAGE);
    }

    @Test
    public void notEqualsExplicit() {
        Card card1 = new Card(Rank.ACE, Suit.SPADES);
        Card card2 = new Card(Rank.ACE, Suit.HEARTS);

        Assertions.assertNotNull(card1, NON_NULL_MESSAGE);
        Assertions.assertNotNull(card2, NON_NULL_MESSAGE);

        Assertions.assertNotEquals(card1, card2, NON_EQUALS_MESSAGE);
    }

    @Test
    public void equalsWithRandom() {
        Rank rank = Rank.random();
        Suit suit = Suit.random();

        Card card1 = new Card(rank, suit);
        Card card2 = new Card(rank, suit);

        Assertions.assertNotNull(card1);
        Assertions.assertNotNull(card2);

        Assertions.assertEquals(card1, card2, EQUALS_MESSAGE);
    }

    @Test
    public void equalsSameObject() {
        Card card = new Card(Rank.random(), Suit.random());

        Assertions.assertEquals(card, card, EQUALS_MESSAGE);
    }
}
