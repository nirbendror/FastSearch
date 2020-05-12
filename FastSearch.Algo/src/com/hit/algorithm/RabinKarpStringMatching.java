package com.hit.algorithm;

import java.util.ArrayList;
import java.math.BigInteger;
import java.util.Random;

public class RabinKarpStringMatching implements IAlgoStringMatching {
    public RabinKarpStringMatching() {
    }

    public ArrayList<Integer> search(String txt, String pat) {
        int d = 256;
        pat = pat.toLowerCase();
        txt = txt.toLowerCase();
        int M = pat.length();
        int N = txt.length();
        int i, j;
        long p = 0;
        long t = 0;
        long h = 1;
        ArrayList<Integer> indexArray = new ArrayList();
        long q = this.getPrime(M);

        for (i = 0; i < M-1; i++) {
            h = (h * d) % q;
        }

        for (i = 0; i < M; i++) {
            p = (d*p + pat.charAt(i))%q;
            t = (d*t + txt.charAt(i))%q;
        }

        for (i = 0; i <= N - M; i++) {
            if ( p == t ) {
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i+j) != pat.charAt(j))
                        break;
                }

                if (j == M) {
                    indexArray.add(i);
                }
            }
            if ( i < N-M ) {
                t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+M))%q;
                if (t < 0) {
                    t = (t + q);
                }
            }
        }
        return indexArray;
    }
    private long getPrime(int num) {
        BigInteger q = BigInteger.probablePrime(this.getNumOfBit(num+1), new Random());
        return q.longValue();
    }

    private int getNumOfBit(int number) {
        return 32 - Integer.numberOfLeadingZeros(number);
    }
}