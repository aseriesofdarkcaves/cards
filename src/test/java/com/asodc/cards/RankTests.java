package com.asodc.cards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RankTests {
    @Test
    public void getRandomRank() {
        Rank rank = Rank.random();
        Assertions.assertNotNull(rank, "Rank cannot be null");
    }
}
