package com.jakerobb.sepuzzling.usstates;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StateListTest {
    @Test
    public void testAddingStates() throws Exception {
        StateList states = StateList.empty();
        states = states.with(State.TEXAS);
        states = states.with(State.WYOMING);
        states = states.with(State.UTAH);
        states = states.with(State.NEW_YORK);
        assertEquals(states.getStates(), ImmutableList.of(State.TEXAS, State.WYOMING, State.UTAH, State.NEW_YORK));
    }
}
