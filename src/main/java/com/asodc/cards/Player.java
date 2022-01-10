package com.asodc.cards;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    /**
     * Create a Player with an empty hand.
     *
     * @param name the Player's name
     */
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    /**
     * @return the Player's name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the Player name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the Player's hand
     */
    public List<Card> getHand() {
        return hand;
    }

    /**
     * Set the Player's hand, overwriting the existing hand.
     *
     * @param hand the hand to set
     */
    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    /**
     * Add cards to the Player's hand.
     *
     * @param cards the Cards to add to the Player's current hand
     */
    public void addCardsToHand(List<Card> cards) {
        this.hand.addAll(cards);
    }
}
