package com.jakerobb.sepuzzling.usstates;

public class UsStatesProblem {
    public static void main(String[] args) {
        long start = System.nanoTime();
        StateList longest = findLongest(StateList.empty());
        long end = System.nanoTime();
        System.out.printf("Computed longest in %s seconds: %s%n", (end - start) / 1000000000.0, longest);
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
