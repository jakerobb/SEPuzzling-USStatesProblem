package com.jakerobb.sepuzzling.usstates;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StateTest {
    @Test
    public void testAllStatesPresent() throws Exception {
        assertEquals(50, State.values().length);
    }

    @Test
    public void testCoincidentLettersCheck() throws Exception {
        assertTrue(State.ALABAMA.hasCoincidentLetters(State.ALASKA)); // the A
        assertTrue(State.ALABAMA.hasCoincidentLetters(State.MASSACHUSETTS)); // the A
        assertTrue(State.MASSACHUSETTS.hasCoincidentLetters(State.SOUTH_CAROLINA)); // the S
        assertTrue(State.SOUTH_DAKOTA.hasCoincidentLetters(State.NEW_JERSEY)); // the space
        assertFalse(State.TEXAS.hasCoincidentLetters(State.WYOMING));
        assertFalse(State.WYOMING.hasCoincidentLetters(State.UTAH));
        assertFalse(State.UTAH.hasCoincidentLetters(State.NEW_YORK));
    }
}
