package com.asodc.cards;

import com.asodc.cards.poker.TexasHoldEmPokerGame;

import java.util.ArrayList;
import java.util.List;

public class CardsMain {
    public static void main(String[] args) {
        List<Player> playerList = new ArrayList<>();
        Player player1 = new Player("Dave");
        Player player2 = new Player("Kevin");
        Player player3 = new Player("Mark");
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);

        TexasHoldEmPokerGame texasHoldEmPokerGame = new TexasHoldEmPokerGame(playerList);
        texasHoldEmPokerGame.start();
    }
}
