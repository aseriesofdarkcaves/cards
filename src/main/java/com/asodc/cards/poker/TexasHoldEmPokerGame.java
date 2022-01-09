package com.asodc.cards.poker;

import com.asodc.cards.Card;
import com.asodc.cards.CardGame;
import com.asodc.cards.Deck;
import com.asodc.cards.Player;

import java.util.ArrayList;
import java.util.List;

public class TexasHoldEmPokerGame implements CardGame {
    private List<Player> players;
    private Deck deck;
    private List<Card> communityCards;

    public TexasHoldEmPokerGame(List<Player> players) {
        this.players = players;
        this.deck = new Deck();
        this.communityCards = new ArrayList<>();
    }

    @Override
    public void start() {
        // Each player gets a hand of 2 cards in their HOLE/POCKET
        for (Player player : players) {
            player.setHand(deck.deal(2));
        }

        // PREFLOP is the round where players can make bets without any community cards having been dealt

        // before the FLOP, a card is BURNED
        deck.deal();

        // the FLOP is where 3 COMMUNITY CARDS are shown, players can make bets
        communityCards.addAll(deck.deal(3));
        printCommunityCards();

        // before the TURN, a card is BURNED
        deck.deal();

        // the TURN causes another COMMUNITY CARD to be shown, the players can make bets
        communityCards.addAll(deck.deal());
        printCommunityCards();

        // before the RIVER, a card is BURNED
        deck.deal();

        // the RIVER causes another COMMUNITY CARD to be shown, the players can make bets
        communityCards.addAll(deck.deal());
        printCommunityCards();

        // when all bets have been settled, the hands are shown and the hands can be evaluated
        for (Player player : players) {
            System.out.println(player.getName() + ":");
            for (Card card : player.getHand()) {
                System.out.println(card);
            }
            System.out.println();
        }
    }

    private void printCommunityCards() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("COMMUNITY CARDS:\r\n");

        for (Card card : communityCards) {
            sb.append(card.toString())
                    .append("\r\n");
        }
        return sb.toString();
    }
}
