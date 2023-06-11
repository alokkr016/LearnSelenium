package com.cognizant.flipkart;

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public static int countUnique(String str){
        Set<Character> set = new HashSet<>();
        for(char ch : str.toCharArray()){
            set.add(ch);
        }
        return set.size();
    }
    public static int solution(String P, String Q) {

        int min = Integer.MAX_VALUE;


        Set<String> list = generatePermutations(P,Q);
        System.out.println(list);
        int current = Integer.MAX_VALUE;
        for(String str : list){
            current = countUnique(str);
            if(current< min){
                min = current;
            }
        }
        return min;
    }


    public static Set<String> generatePermutations(String string1, String string2) {
        Set<String> permutations = new HashSet<>();
        int n = string1.length();
        int m = string2.length();

        if (n != m) {
            System.out.println("The two strings must be of the same length.");
            return permutations;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String permutation = string1.substring(0, i) + string2.charAt(j) + string1.substring(i + 1);
                permutations.add(permutation);
            }
        }

        return permutations;
    }

    public static void main(String[] args) {

        System.out.println(solution("bacad","abada"));
    }
}