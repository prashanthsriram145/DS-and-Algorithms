package com.personal.dsalgo;

public class CheckIfArrayIsSorted {

    public boolean isSorted(int [] elements, int size) {
        if (size == 1) {
            return true;
        }
        return (elements[size - 1] < elements[size - 2]) ? false : isSorted(elements, size - 1);
    }

    public static void main(String[] args) {
        CheckIfArrayIsSorted checkIfArrayIsSorted = new CheckIfArrayIsSorted();
        int [] elements = {1,2,1,3,4,5};
        boolean isSorted = checkIfArrayIsSorted.isSorted(elements, elements.length);
        System.out.println("Is array sorted ? " + isSorted);
    }
}
