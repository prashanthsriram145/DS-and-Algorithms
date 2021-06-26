package com.stack;

public class PalindromeChecker {

    public boolean isPalindrome(String input) {
        int start = 0, end = input.length() - 1;
        char[] inputArray = input.toCharArray();
        while (start <= end && inputArray[start] == inputArray[end]) {
            start++;
            end--;
        }

        if (start > end) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        PalindromeChecker palindromeChecker = new PalindromeChecker();
        boolean isPalindrome = palindromeChecker.isPalindrome("racecar");
        System.out.println("Palindrome : " + isPalindrome);
    }
}
