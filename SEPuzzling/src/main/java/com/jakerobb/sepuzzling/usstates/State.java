package com.jakerobb.sepuzzling.usstates;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.Set;

public enum State {
    ALABAMA("ALABAMA"),
    ALASKA("ALASKA"),
    ARIZONA("ARIZONA"),
    ARKANSAS("ARKANSAS"),
    CALIFORNIA("CALIFORNIA"),
    COLORADO("COLORADO"),
    CONNECTICUT("CONNECTICUT"),
    DELAWARE("DELAWARE"),
    FLORIDA("FLORIDA"),
    GEORGIA("GEORGIA"),
    HAWAII("HAWAII"),
    IDAHO("IDAHO"),
    ILLINOIS("ILLINOIS"),
    INDIANA("INDIANA"),
    IOWA("IOWA"),
    KANSAS("KANSAS"),
    KENTUCKY("KENTUCKY"),
    LOUISIANA("LOUISIANA"),
    MAINE("MAINE"),
    MARYLAND("MARYLAND"),
    MASSACHUSETTS("MASSACHUSETTS"),
    MICHIGAN("MICHIGAN"),
    MINNESOTA("MINNESOTA"),
    MISSISSIPPI("MISSISSIPPI"),
    MISSOURI("MISSOURI"),
    MONTANA("MONTANA"),
    NEBRASKA("NEBRASKA"),
    NEVADA("NEVADA"),
    NEW_HAMPSHIRE("NEW HAMPSHIRE"),
    NEW_JERSEY("NEW JERSEY"),
    NEW_MEXICO("NEW MEXICO"),
    NEW_YORK("NEW YORK"),
    NORTH_CAROLINA("NORTH CAROLINA"),
    NORTH_DAKOTA("NORTH DAKOTA"),
    OHIO("OHIO"),
    OKLAHOMA("OKLAHOMA"),
    OREGON("OREGON"),
    PENNSYLVANIA("PENNSYLVANIA"),
    RHODE_ISLAND("RHODE ISLAND"),
    SOUTH_CAROLINA("SOUTH CAROLINA"),
    SOUTH_DAKOTA("SOUTH DAKOTA"),
    TENNESSEE("TENNESSEE"),
    TEXAS("TEXAS"),
    UTAH("UTAH"),
    VERMONT("VERMONT"),
    VIRGINIA("VIRGINIA"),
    WASHINGTON("WASHINGTON"),
    WEST_VIRGINIA("WEST VIRGINIA"),
    WISCONSIN("WISCONSIN"),
    WYOMING("WYOMING");

    private final String name;
    private final String nameWithoutSpaces;
    private final ImmutableSet<Character> chars;

    State(String name) {
        this.name = name;
        nameWithoutSpaces = name.replaceAll(" ", "");
        ImmutableSet.Builder<Character> charsBuilder = ImmutableSet.builder();
        for (char c : name.toCharArray()) {
            charsBuilder.add(Character.toUpperCase(c));
        }
        chars = charsBuilder.build();
    }

    public boolean hasCoincidentLetters(State otherState) {
        return !Sets.intersection(chars, otherState.getChars()).isEmpty();
    }

    public String getName() {
        return name;
    }

    public String getNameWithoutSpaces() {
        return nameWithoutSpaces;
    }

    private Set<Character> getChars() {
        return chars;
    }
}
