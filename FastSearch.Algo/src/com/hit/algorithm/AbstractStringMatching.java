package com.hit.algorithm;

import java.util.ArrayList;

public abstract class AbstractStringMatching {

    private IAlgoStringMatching stringMatchingType;

    public AbstractStringMatching(IAlgoStringMatching algoType) {

        this.stringMatchingType = algoType;
    }

    public ArrayList<Integer> search(String text, String pat) {
        return stringMatchingType.search(text, pat);
    }

    public void setAlgoType(IAlgoStringMatching algoType) {
        this.stringMatchingType = algoType;
    }
}
