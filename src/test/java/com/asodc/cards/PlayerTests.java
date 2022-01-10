package com.asodc.cards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PlayerTests {
    public final String EMPTY_HAND_MESSAGE = "Player should have an empty hand";
    public final String MATCHING_CARDS_MESSAGE = "The dealt cards must match the player's hand";

    @Test
    public void getName() {
        final String playerName = "TestName";
        Player player = new Player(playerName);
        Assertions.assertEquals(player.getName(), playerName, "Player name was not set correctly");
    }

    @Test
    public void setName() {
        Player player = new Player("InitialName");
        final String newName = "NewName";
        player.setName(newName);
        Assertions.assertEquals(player.getName(), newName, "Player name was not updated correctly");
    }

    @Test
    public void getHand() {
        Player player = new Player("TestName");
        Assertions.assertEquals(player.getHand().size(), 0, EMPTY_HAND_MESSAGE);

        Deck deck = new Deck();
        final List<Card> cards = deck.deal(10);

        // test via addCardsToHand()
        player.addCardsToHand(cards);
        Assertions.assertEquals(player.getHand(), cards, MATCHING_CARDS_MESSAGE);

        player = new Player("TestName");
        Assertions.assertEquals(player.getHand().size(), 0, EMPTY_HAND_MESSAGE);

        // test via setHand()
        player.setHand(cards);
        Assertions.assertEquals(player.getHand(), cards, MATCHING_CARDS_MESSAGE);
    }

    @Test
    public void setHand() {
        Player player = new Player("TestName");
        Assertions.assertEquals(player.getHand().size(), 0, EMPTY_HAND_MESSAGE);

        Deck deck = new Deck();
        final List<Card> cards = deck.deal(10);

        player.setHand(cards);
        Assertions.assertEquals(player.getHand(), cards, MATCHING_CARDS_MESSAGE);
    }

    @Test
    public void addCardsToHand() {
        Player player = new Player("TestName");
        Assertions.assertEquals(player.getHand().size(), 0, EMPTY_HAND_MESSAGE);

        Deck deck = new Deck();
        final List<Card> cards = deck.deal(10);

        player.addCardsToHand(cards);
        Assertions.assertEquals(player.getHand(), cards, MATCHING_CARDS_MESSAGE);
    }
}
