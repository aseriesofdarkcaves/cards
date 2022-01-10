package com.asodc.cards;

import com.asodc.cards.game.CardGame;
import com.asodc.cards.game.poker.TexasHoldEm;

import java.util.ArrayList;
import java.util.List;

public class CardsMain {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        Player player1 = new Player("Dave");
        Player player2 = new Player("Kevin");
        Player player3 = new Player("Mark");
        players.add(player1);
        players.add(player2);
        players.add(player3);

        CardGame game = new TexasHoldEm(players);
        game.start();
    }
}
