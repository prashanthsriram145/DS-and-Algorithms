package com.dsalgo;

public class BinaryOfNumber {
    public static void main(String[] args) {
        BinaryOfNumber binaryOfNumber = new BinaryOfNumber();
        binaryOfNumber.toBin(9);

    }

    private void toBin(int n) {
        if(n > 1) {
            toBin(n/2);
        }
        System.out.print(n%2);
    }
}
