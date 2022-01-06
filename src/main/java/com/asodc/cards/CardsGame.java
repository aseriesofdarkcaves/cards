package com.asodc.cards;

public class CardsGame {
    public static void main(String[] args) {
        Card card = new Card(Rank.random(), Suit.random());
        System.out.println(card);
    }
}
