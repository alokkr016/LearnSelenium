package com.cognizant.flipkart;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        if(isPossible(arr)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
    private static boolean isPossible(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int product = 1;
            for (int j = 0; j < arr.length; j++) {
                if (j == i) continue;
                product *= arr[j];
            }
            if (product == arr[i]) return true;
        }
        return false;
    }

}
