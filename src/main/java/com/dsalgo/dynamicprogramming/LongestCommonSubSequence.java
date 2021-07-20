package com.dsalgo.dynamicprogramming;

public class LongestCommonSubSequence {
    public static void main(String[] args) {
        LongestCommonSubSequence longestCommonSubSequence = new LongestCommonSubSequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        System.out.println(longestCommonSubSequence.find(x, y, x.length, y.length));
    }

    private int find(char[] x, char[] y, int m, int n) {
        int k[][] = new int[m+1][n+1];
        for(int i=0; i<=m; i++) {
            for(int j=0; j<=n; j++){
                if(i==0 || j==0) {
                    k[i][j] = 0;
                } else if(x[i-1] == y[j-1]) {
                    k[i][j] = k[i-1][j-1] + 1;
                } else {
                    k[i][j] = Math.max(k[i-1][j], k[i][j-1]);
                }
            }
        }
        return k[m][n];
    }
}
