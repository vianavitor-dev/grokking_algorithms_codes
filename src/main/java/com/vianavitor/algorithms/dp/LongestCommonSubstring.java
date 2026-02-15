package com.vianavitor.algorithms.dp;

import java.lang.Math;

/*
    This class are going to implement the longest comum substring as described into the book
*/
public class LongestCommonSubstring {
    public static int execute(String s1, String s2) {
        int max = 0; // the result

        int n1 = s1.length();
        int n2 = s2.length();

        int[][] table = new int[n1][n2]; // the table that is going to register the longest substrings

        for (int x = 0; x < n1; x++) {
            for (int y = 0; y < n2; y++) {
                int xx = 0; 
                int yy = 0;

                if (s1.charAt(x) == s2.charAt(y)) {

                    if (x-1 >= 0 && y-1 >= 0) {
                        xx = x-1;
                        yy = y-1;
                    }

                    table[x][y] = table[xx][yy] +1;
                    max = Math.max(max, table[x][y]);
                }

                System.out.print("| %d ".formatted(table[x][y]));
            }
            System.out.println("|\n");
        }

        return max;
    }
}
