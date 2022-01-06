package com.asodc.cards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardTests {
    public static final String EQUALS_MESSAGE = "Cards must be equal";
    public static final String NON_EQUALS_MESSAGE = "Cards must not be equal";
    public static final String NON_NULL_MESSAGE = "Card cannot be null";

    @Test
    public void equalsReflexive() {
        Card x = new Card(Rank.ACE, Suit.SPADES);

        Assertions.assertNotNull(x, NON_NULL_MESSAGE);

        Assertions.assertEquals(x, x, "Equals must be reflexive");
    }

    @Test
    public void equalsSymmetric() {
        Card x = new Card(Rank.ACE, Suit.SPADES);
        Card y = new Card(Rank.ACE, Suit.SPADES);

        Assertions.assertNotNull(x, NON_NULL_MESSAGE);
        Assertions.assertNotNull(y, NON_NULL_MESSAGE);

        Assertions.assertEquals(x.equals(y), y.equals(x), "Equals must be symmetric");
    }

    @Test
    public void equalsTransitive() {
        Card a = new Card(Rank.ACE, Suit.SPADES);
        Card b = new Card(Rank.ACE, Suit.SPADES);
        Card c = new Card(Rank.ACE, Suit.SPADES);

        Assertions.assertNotNull(a, NON_NULL_MESSAGE);
        Assertions.assertNotNull(b, NON_NULL_MESSAGE);
        Assertions.assertNotNull(c, NON_NULL_MESSAGE);

        final boolean first = a.equals(b);
        final boolean second = b.equals(c);
        final boolean third = a.equals(c);

        Assertions.assertTrue(first && second && third, "Equals must be transitive");
    }

    @Test
    public void equalsSimple() {
        Card x = new Card(Rank.ACE, Suit.SPADES);
        Card y = new Card(Rank.ACE, Suit.SPADES);

        Assertions.assertNotNull(x, NON_NULL_MESSAGE);
        Assertions.assertNotNull(y, NON_NULL_MESSAGE);

        Assertions.assertEquals(x, y, EQUALS_MESSAGE);
    }

    @Test
    public void notEqualsSimple() {
        Card x = new Card(Rank.ACE, Suit.SPADES);
        Card y = new Card(Rank.ACE, Suit.HEARTS);

        Assertions.assertNotNull(x, NON_NULL_MESSAGE);
        Assertions.assertNotNull(y, NON_NULL_MESSAGE);

        Assertions.assertNotEquals(x, y, NON_EQUALS_MESSAGE);
    }

    @Test
    public void hashCodeInternalConsistency() {
        Card x = new Card(Rank.ACE, Suit.SPADES);

        final int initialHashcode = x.hashCode();

        x = new Card(Rank.KING, Suit.DIAMONDS);

        final int newHashcode = x.hashCode();

        Assertions.assertNotEquals(initialHashcode, newHashcode, "Hashcode must change when property changes");
    }

    @Test
    public void hashCodeEqualsConsistency() {
        Card x = new Card(Rank.ACE, Suit.SPADES);
        Card y = new Card(Rank.ACE, Suit.SPADES);

        Assertions.assertNotNull(x, NON_NULL_MESSAGE);
        Assertions.assertNotNull(y, NON_NULL_MESSAGE);

        Assertions.assertEquals(x, y, EQUALS_MESSAGE);

        Assertions.assertEquals(x.hashCode(), y.hashCode(), "Equal objects must return the same hashcode");
    }
}
