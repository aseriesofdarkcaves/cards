package com.asodc.cards.game.poker;

import com.asodc.cards.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TexasHoldemTests {
    @Test
    public void dealHoleCards() {
        List<Player> players = new ArrayList<>();
        Player player1 = new Player("Dave");
        Player player2 = new Player("Kevin");
        Player player3 = new Player("Mark");
        players.add(player1);
        players.add(player2);
        players.add(player3);

        TexasHoldEm game = new TexasHoldEm(players);
        game.dealHoleCards();

        for (Player player : players) {
            Assertions.assertEquals(player.getHand().size(), 2, "Player must have exactly 2 cards in the hole");
        }
    }

    @Test
    public void burnCard() {
        // TODO
    }
}
