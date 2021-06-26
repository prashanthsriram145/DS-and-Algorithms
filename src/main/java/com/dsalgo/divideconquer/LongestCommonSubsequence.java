package com.dsalgo.divideconquer;

import java.util.Arrays;
import java.util.List;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("geeks", "geeksforgeeks", "geekz", "geek");
        System.out.println(findLongestSubSequence(words, 0, words.size()-1));
    }

    private static String findLongestSubSequence(List<String> words, int low, int high) {
        if (low == high) {
            return words.get(low);
        }
        int mid =  (low + high)/2;
        String word1 = findLongestSubSequence(words, low, mid);
        String word2 = findLongestSubSequence(words, mid+1, high);

        String common = findCommonSequence(word1, word2);
        return common;

    }

    private static String findCommonSequence(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int i=0, j=0;
        String result = "";
        while(i < len1 && j < len2) {
            if(word1.charAt(i) != word2.charAt(j)) {
                break;
            }
            result = result + word1.charAt(i);
            i++; j++;
        }
        return result;
    }
}
