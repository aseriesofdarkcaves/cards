package com.asodc.cards;

import java.util.Random;

public enum Suit {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES;

    // TODO: figure out how JOKER should work

    private static final Random RANDOM = new Random();

    static Suit random() {
        return values()[RANDOM.nextInt(values().length)];
    }
}
