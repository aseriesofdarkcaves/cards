package com.asodc.cards.poker;

import com.asodc.cards.Deck;
import com.asodc.cards.Hand;
import com.asodc.cards.Player;

import java.util.List;

public class TexasHoldEmPokerGame {
    private List<Player> players;
    private Deck deck;
    private Hand communityCards;

    // TODO: track PREFLOP, FLOP, TURN, RIVER using State Pattern?

    public TexasHoldEmPokerGame(List<Player> players) {
        this.players = players;
        this.deck = new Deck();
        this.communityCards = new Hand();
    }
}
