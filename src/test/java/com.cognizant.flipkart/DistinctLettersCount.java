package com.cognizant.flipkart;

import java.util.HashSet;
import java.util.Set;

public class DistinctLettersCount {
    public static int countDistinctLetters(String P, String Q) {
        Set<Character> distinctLetters = new HashSet<>();

        for (int i = 0; i < P.length(); i++) {
            distinctLetters.add(P.charAt(i));
            distinctLetters.add(Q.charAt(i));
        }

        int count = 0;
        for (Character letter : distinctLetters) {
            if (P.contains(letter.toString()) && Q.contains(letter.toString())) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String P = "axxz";
        String Q = "yzwy    ";
        int result = countDistinctLetters(P, Q);
        System.out.println(result);
    }
}