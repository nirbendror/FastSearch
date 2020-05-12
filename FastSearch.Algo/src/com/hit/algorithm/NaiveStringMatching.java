package com.hit.algorithm;

import java.util.ArrayList;

public class NaiveStringMatching implements IAlgoStringMatching {

    @Override
    public ArrayList<Integer> search(String txt, String pat) {
        txt=txt.toLowerCase();
        pat=pat.toLowerCase();
        ArrayList<Integer> indexArray = new ArrayList<Integer>();
        int M = pat.length();
        int N = txt.length();

        for (int i = 0; i <= N - M; i++) {

            int j;

            for (j = 0; j < M; j++)
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;

            if (j == M)
                indexArray.add(i);
        }
        return indexArray;
    }
}
