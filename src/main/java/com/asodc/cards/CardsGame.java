package com.asodc.cards;

import java.util.List;

public class CardsGame {
    public static void main(String[] args) {
        Deck deck = new Deck();
        List<Card> hand = deck.deal(26);
        System.out.println(hand);
        System.out.println(deck);
    }
}
