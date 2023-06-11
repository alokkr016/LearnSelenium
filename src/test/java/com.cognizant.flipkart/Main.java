package com.cognizant.flipkart;

import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        while(t-- > 0) {
            String A = br.readLine();
            String B = br.readLine();

            if(A == null || B == null){
                break;
            }

            int i = 0, j = 0;
            StringBuffer sb = new StringBuffer();

            while(i < A.length() && j < B.length()) {
                if (A.charAt(i) < B.charAt(j)) {
                    sb.append(A.charAt(i++));
                } else if (A.charAt(i) > B.charAt(j)) {
                    sb.append(B.charAt(j++));
                } else {
                    int x = i, y = j;
                    char a = A.charAt(i);
                    for(; x < A.length() && y < B.length(); x++, y++) {
                        if (A.charAt(x) != B.charAt(y)) {
                            break;
                        } else if (A.charAt(x) > a) {
                            sb.append(A.substring(i, x)).append(B.substring(j, y));
                            i = x; j = y;
                            a = A.charAt(x);
                        }
                    }

                    if (x == A.length()) {
                        sb.append(B.charAt(j));
                        j++;
                    } else if (y == B.length()) {
                        sb.append(A.charAt(i));
                        i++;
                    } else {
                        if (A.charAt(x) < B.charAt(y)) {
                            sb.append(A.charAt(i));
                            i++;
                        } else {
                            sb.append(B.charAt(j));
                            j++;
                        }
                    }
                }
            }

            sb.append(A.substring(i)).append(B.substring(j));

            System.out.println(sb);
        }

        br.close();
    }
}

