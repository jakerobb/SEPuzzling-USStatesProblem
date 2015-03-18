package com.jakerobb.sepuzzling.usstates;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

import java.util.Collection;

public class StateList {
    private static int nodeCount = 0;

    public static int getNodeCount() {
        return nodeCount;
    }

    private final ImmutableList<State> states;

    private StateList() {
        states = ImmutableList.of();
    }

    private StateList(Iterable<State> states) {
        nodeCount++;
        this.states = ImmutableList.copyOf(states);
    }

    public static StateList empty() {
        return new StateList();
    }

    public boolean canAdd(State state) {
        return !states.contains(state) && (states.isEmpty() || !Iterables.getLast(states).hasCoincidentLetters(state));
    }

    public StateList with(State state) {
        if (canAdd(state)) {
            return new StateList(ImmutableList.<State>builder().addAll(states).add(state).build());
        } else {
            throw new IllegalStateException(String.format("Can't add %s to %s", state, states));
        }
    }

    public Collection<State> getStates() {
        return states;
    }

    public boolean isLongerThan(StateList otherList) {
        return states.size() > otherList.getStates().size();
    }

    @Override
    public String toString() {
        return "StateList{" +
               "numOfStates=" + states.size() + ',' +
               "sumOfLengths=" + states.stream().map(State::getName).mapToInt(String::length).sum() + ',' +
               "sumOfLengthsWithoutSpaces=" + states.stream().map(State::getNameWithoutSpaces).mapToInt(String::length).sum() + ',' +
               "states=" + states +
               '}';
    }
}
