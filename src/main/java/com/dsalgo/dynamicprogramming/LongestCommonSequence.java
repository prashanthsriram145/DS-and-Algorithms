package com.dsalgo.dynamicprogramming;

public class LongestCommonSequence {
    public static void main(String[] args) {
        LongestCommonSequence longestCommonSequence = new LongestCommonSequence();
        String s1 = "AGGTAB";
        String s2 = "GXTTAB";
        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        System.out.println(longestCommonSequence.find(x, y, x.length, y.length));
    }

    private String find(char[] x, char[] y, int m, int n) {
        String k[][] = new String[m+1][n+1];

        for(int i=0;i<=m;i++) {
            for(int j=0;j<=n;j++) {
                if(i==0 || j==0) {
                    k[i][j] = "";
                } else if(x[i-1] == y[j-1]) {
                    k[i][j] = k[i-1][j-1] + x[i-1];
                } else {
                    k[i][j] = "";
                }
            }
        }
        return k[m][n];
    }
}
