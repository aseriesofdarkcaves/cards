package com.asodc.cards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class DeckTests {
    public static final int FULL_DECK_SIZE = 52;
    public static final String FULL_DECK_MESSAGE = "Expected 52 cards in the deck";
    public static final String INCORRECT_DEAL_MESSAGE = "An incorrect number of cards have been dealt";

    @Test
    public void deckConstruction() {
        // Using a Set allows us to check the Deck has 52 unique Cards
        Set<Card> cardSet = new HashSet<>(new Deck().getCards());
        Assertions.assertEquals(FULL_DECK_SIZE, cardSet.size(), FULL_DECK_MESSAGE);

        // TODO: test for has been shuffled
    }

    @Test
    public void shuffle() {
        // TODO: test that the Deck has been shuffled
        //  in reality you could shuffle and not have changed anything
        //  but the Collections.shuffle() algorithm may always swap some other element into place
        //  check if this is the case
    }

    @Test
    public void dealSingleCard() {
        Deck deck = new Deck();
        List<Card> hand = deck.deal();
        Assertions.assertEquals(1, hand.size(), INCORRECT_DEAL_MESSAGE);

        Assertions.assertEquals(FULL_DECK_SIZE - 1, deck.size(), INCORRECT_DEAL_MESSAGE);
    }

    @Test
    public void dealMultipleCards() {
        Deck deck = new Deck();
        Random random = new Random();
        int cardsToDeal = random.nextInt(FULL_DECK_SIZE + 1);
        List<Card> hand = deck.deal(cardsToDeal);
        Assertions.assertEquals(cardsToDeal, hand.size(), INCORRECT_DEAL_MESSAGE);

        Assertions.assertEquals(FULL_DECK_SIZE - cardsToDeal, deck.size(), INCORRECT_DEAL_MESSAGE);
    }

    @Test
    public void dealZeroOrLessCards() {
        for (int i = 0; i >= -1; i--) {
            dealCardsAndCaptureException(i);
        }
    }

    private void dealCardsAndCaptureException(int numbersOfCards) {
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            Deck deck = new Deck();
            deck.deal(numbersOfCards);
        });
        Assertions.assertInstanceOf(IllegalArgumentException.class, exception, "Incorrect or no Exception was thrown");
    }

    @Test
    public void cardsConsistency() {
        Deck deck = new Deck();
        // this tests both getCards() and size() methods as they are tightly linked
        Assertions.assertEquals(FULL_DECK_SIZE, deck.getCards().size(), FULL_DECK_MESSAGE);

        Random random = new Random();
        int cardsToDeal = random.nextInt(FULL_DECK_SIZE + 1);
        deck.deal(cardsToDeal);
        // this tests both getCards() and size() methods as they are tightly linked
        Assertions.assertEquals(FULL_DECK_SIZE - cardsToDeal, deck.getCards().size(), INCORRECT_DEAL_MESSAGE);
    }
}
