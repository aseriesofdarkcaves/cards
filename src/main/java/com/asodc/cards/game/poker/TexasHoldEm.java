package com.asodc.cards.game.poker;

import com.asodc.cards.Card;
import com.asodc.cards.game.CardGame;
import com.asodc.cards.Deck;
import com.asodc.cards.Player;

import java.util.ArrayList;
import java.util.List;

public class TexasHoldEm implements CardGame {
    private final List<Player> players;
    private final Deck deck;
    private final List<Card> communityCards;

    public TexasHoldEm(List<Player> players) {
        this.players = players;
        this.deck = new Deck();
        this.communityCards = new ArrayList<>();
    }

    @Override
    public void start() {
        // Each player gets a hand of 2 cards in their HOLE/POCKET
        dealHoleCards();

        // PREFLOP is the first round where players can either FOLD, BET, CHECK or RAISE without any community cards having been dealt

        // before the FLOP, a card is BURNED
        burnCard();

        // FLOP is the second round
        flop();
        printCommunityCards();

        // before the TURN, a card is BURNED
        burnCard();

        // TURN is the third round
        turn();
        printCommunityCards();

        // before the RIVER, a card is BURNED
        burnCard();

        // RIVER is the fourth and final round
        river();
        printCommunityCards();

        // when all bets have been settled, the HOLE cards are shown
        printPlayerHands();

        // the player hands are evaluated
        evaluatePlayerHands();
    }

    /**
     * Takes the top Card from the Deck and discards it from play.
     */
    void burnCard() {
        deck.deal();
    }

    /**
     * Deals two Cards to each Player.
     * There are two rounds of dealing, with one Card being dealt per Player per dealing-round.
     */
    void dealHoleCards() {
        //players.forEach(player -> player.setHand(deck.deal(2)));
        // outer loop runs twice to ensure Players get a maximum two Cards
        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                player.addCardsToHand(deck.deal());
            }
        }
    }

    /**
     * The FLOP is the second round where 3 COMMUNITY CARDS are shown.
     * Players can either FOLD, BET, CHECK or RAISE, depending on the situation.
     */
    void flop() {
        communityCards.addAll(deck.deal(3));
    }

    /**
     * The TURN is the third round and causes another COMMUNITY CARD to be shown.
     * Players can either FOLD, BET, CHECK or RAISE, depending on the situation.
     */
    void turn() {
        communityCards.addAll(deck.deal());
    }

    /**
     * The RIVER is the fourth and final round and causes the last COMMUNITY CARD to be shown.
     * The players can either FOLD, BET, CHECK or RAISE, depending on the situation.
     */
    void river() {
        communityCards.addAll(deck.deal());
    }

    /**
     * Evaluates the Player hands to determine the winner(s) of the game.
     */
    void evaluatePlayerHands() {
        // TODO: evaluate player hands
    }

    private void printCommunityCards() {
        System.out.println(this);
    }

    private void printPlayerHands() {
        for (Player player : players) {
            System.out.println(player.getName() + ":");
            for (Card card : player.getHand()) {
                System.out.println(card);
            }
            System.out.println();
        }
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
