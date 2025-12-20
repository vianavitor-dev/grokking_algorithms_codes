package com.vianavitor.algorithms.recursion;

import java.util.List;

public class Box {
    private final boolean key;
    private final List<Box> boxesInside;
    private final String name;

    public Box(boolean key, List<Box> boxesInside, String name) {
        this.key = key;
        this.boxesInside = boxesInside;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean hasKey() {
        return key;
    }

    public boolean hasAnyBoxInside() {
        return boxesInside != null;
    }

    public List<Box> getAllBoxesInside() {
        return boxesInside;
    }
}
