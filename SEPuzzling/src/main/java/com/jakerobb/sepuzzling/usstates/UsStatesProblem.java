package com.jakerobb.sepuzzling.usstates;

public class UsStatesProblem {
    public static void main(String[] args) {
        long start = System.nanoTime();
        StateList longest = findLongest(StateList.empty());
        long end = System.nanoTime();
        System.out.printf("Discovered %d valid chains in %f seconds.  Longest: %s%n", StateList.getNodeCount(), (end - start) / 1000000000.0, longest);
    }

    private static StateList findLongest(StateList list) {
        StateList longest = list;
        for (State state : State.values()) {
            if (list.canAdd(state)) {
                StateList newResult = findLongest(list.with(state));
                if (newResult.isLongerThan(longest)) {
                    longest = newResult;
                }
            }
        }
        return longest;
    }
}
