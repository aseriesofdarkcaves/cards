package com.asodc.cards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SuitTests {
    @Test
    public void getRandomSuit() {
        final Suit suit = Suit.random();
        Assertions.assertNotNull(suit, "Suit cannot be null");
    }
}
