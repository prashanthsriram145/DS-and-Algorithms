package com.dsalgo.divideconquer;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("geeks@123", "geeks1123forgeeks", "geeks123z", "geeks1234");
        System.out.println(findLongestSubSequence(words, 0, words.size()-1));
    }

    private static String findLongestSubSequence(List<String> words, int low, int high) {
        if (low == high) {
            return words.get(low);
        }
        int mid =  (low + high)/2;
        String word1 = findLongestSubSequence(words, low, mid);
        String word2 = findLongestSubSequence(words, mid+1, high);
        Stack<Character> stack = new Stack();
        findCommonSequence(word1.toCharArray(), word2.toCharArray(), word1.length(), word2.length(), stack);
        String commonString = "";
        while(!stack.isEmpty()) {
            commonString = commonString + stack.pop();
        }
        return commonString;

    }

    private static void findCommonSequence(char[] word1, char[] word2, int len1, int len2, Stack<Character> stack) {
        if(len1 == 0 || len2 == 0) {
            return;
        }
        if(word1[len1-1] == word2[len2-1]) {
            stack.push(word1[len1-1]);
            findCommonSequence(word1, word2, len1-1, len2-1, stack);
        } else {
            findCommonSequence(word1, word2, len1-1, len2, stack);
            findCommonSequence(word1, word2, len1, len2-1, stack);
        }

    }
}
