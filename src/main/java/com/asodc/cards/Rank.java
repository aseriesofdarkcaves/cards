package com.asodc.cards;

import java.util.Random;

public enum Rank {
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE;

    // TODO: figure out how JOKER should work

    private static final Random RANDOM = new Random();

    static Rank random() {
        return values()[RANDOM.nextInt(values().length)];
    }
}
