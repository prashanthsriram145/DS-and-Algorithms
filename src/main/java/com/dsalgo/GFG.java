package com.dsalgo;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

class Solution
{
    //Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d, int n)
    {
        // add your code here
        int newArr[] = Arrays.copyOf(arr, n);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=0; i<n; i++) {
            if(i < d) {
                deque.add(arr[i]);
            } else {
                arr[i-d] = newArr[i];
            }
        }
        Iterator iter = deque.iterator();
        while(iter.hasNext()) {
            arr[n-d] = (Integer)iter.next();
            n++;
        }
    }

    static int majorityElement(int a[], int size)
    {
        // your code here
        int threshold = size/2;
        Map<Integer, Integer> map = new HashMap();
        for (int i=0;i<size;i++) {
            if (map.get(a[i]) == null) {
                map.put(a[i], 1);
            } else {
                int count = map.get(a[i]);
                map.put(a[i], count+1);
            }
        }
        for (int key: map.keySet()) {
            if(map.get(key) > threshold) {
                return key;
            }
        }
        return 0;
    }

    static ArrayList<Integer> increment(ArrayList<Integer> arr , int N) {
        // code here

        Stack<Integer> st = new Stack<>();
        int x = arr.get(N-1);
        x = x + 1;
        int carry = x/10;
        st.push(x % 10);

        for(int i=N-2;i>=0;i--) {
            x = arr.get(i);
            x = x + carry;
            carry = x/10;
            st.push(x % 10);
        }
        if (carry == 1) {
            st.push(carry);
        }
        arr.clear();
        while (!st.isEmpty()) {
            arr.add(st.pop());
        }
        return arr;
    }

    static int find_height(int tree[], int n, int k)
    {
        if (n == 1) {
            return tree[0] - 9;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for(int i=0;i<n;i++) {
            priorityQueue.add(tree[i]);
        }
        int min = priorityQueue.peek();
        int max = min;
        Iterator<Integer> iterator = priorityQueue.iterator();
        while(iterator.hasNext())
        {
            int val = iterator.next();
            if (val > max) {
                max = val;
            }
        }
        int total = 0;
        for(int i=min;i<=max;i++) {
            for (int j=0;j<n;j++) {
                int diff = tree[j] - i;
                if(diff < 0) {
                    diff = 0;
                }
                total = total + diff;
            }
            if (total == k) {
                return i;
            }
            total = 0;
        }
        return -1;
    }

    static int wood_collected(int tree[], int n, int h)
    {
        int ret=0;

        // counting the amount of wood that gets collected
        // if we cut trees at height h
        for( int i=0; i<n; i++ )
            if( tree[i] > h )
                ret += tree[i] - h;

        return ret;
    }

    static int find_height_1(int tree[], int n, int k)
    {
        // l is lower limit of binary search
        // h is upper limit
        int l=0, h=0;
        for(int i=0; i<n; i++)
            if ( tree[i] > h )
                h = tree[i];

        while(l<=h)
        {
            int mid = (l+h)/2;
            int val = wood_collected(tree,n,mid);

            if(val==k) return mid;

            if(val>k) l = mid+1;
                // if wood collected is too much, we increase lower limit
            else h = mid-1;
            // if wood collected is too less, we decrease uppwer limit
        }
        return -1;
    }

    class pair  {
        long first, second;
        public pair(long first, long second)
        {
            this.first = first;
            this.second = second;
        }
    }

    public Pair indexes(long[] v, long x)
    {
        // Your code goes here
        int lower = lowerBound(v, 0, v.length-1, x);
        int upper = upperBound(v, 0, v.length-1, x);

        if(lower == v.length || v[lower] != x) return new Pair(-1,-1);

        return new Pair(lower, upper);

    }

    private static int upperBound(long[] v, int i, int i1, long x) {

        int pos = -1;
        while(i <= i1) {
            int m = (i+i1)/2;
            if(x >= v[m]) {
                pos = m;
                i = m+1;
            } else {
                i1 = m-1;
            }
        }
        return pos;
    }

    private static int lowerBound(long[] v, int i, int i1, long x) {

        int pos = v.length;
        while (i <= i1) {
            int m = (i + i1)/2;
            if(x <= v[m]) {
                pos = m;
                i1 = m-1;
            } else {
                i = m+1;
            }
        }
        return pos;
    }

    public static void convertToWave(int arr[], int n){

        // Your code here
        Stack<Integer> st = new Stack<>();
        int[] newArr = new int[n];
        int count = 0;
        for(int i=0;i<n;i++) {
            if(st.size() == 2) {
                while(!st.isEmpty()) {
                    newArr[count] = st.pop();
                    count++;
                }
            }
            st.push(arr[i]);
        }
        while(!st.isEmpty()) {
            newArr[count] = st.pop();
            count++;
        }
        //arr = new int[n];
        for (int i=0;i<n;i++) {
            arr[i] = newArr[i];
        }
        //return  newList.toArray(arrNew);
    }

    static String reverseWords(String S) {
        // code here
        String [] strs = S.split("\\.");
        Stack<String> st = new Stack<>();
        for(int i=0;i<strs.length-1;i++) {
            st.push(strs[i]);
            st.push(".");
        }
        st.push(strs[strs.length - 1]);
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.toString();
    }

    static String longestCommonPrefix(String arr[], int n){
        // code here
        int counter = 0;

        int smallest = arr[0].length();
        for(int i=1;i<n;i++) {
            int len = arr[i].length();
            if (len < smallest) {
                smallest = len;
            }
        }
        List<Character> newArr = new ArrayList<>();
        boolean broken = false;
        while(counter < smallest) {
            char c = arr[0].charAt(counter);
            for(int i=1;i<n;i++) {
                if(arr[i].charAt(counter) != c) {
                    broken = true;
                    break;
                }
            }
            if(!broken) {
                newArr.add(c);
            }
            counter++;
        }

        StringBuilder sb = new StringBuilder();
        if (newArr.size() == 0) {
            sb.append("-1");
        } else {
            for(int i=0;i<newArr.size();i++) {
                sb.append(newArr.get(i));
            }
        }
        return sb.toString();
    }

    public static int romanToDecimal(String str) {
        // code here
        char [] chars = str.toCharArray();
        int [] vals = new int[str.length()];
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int runningSum = 0;
        for(int i=0;i<chars.length;i++) {
            vals[i] = map.get(chars[i]);
        }
        if(vals.length == 1) {
            return vals[0];
        }
        int i = 0;
        for(i=0;i<vals.length-1;i++) {
            if(vals[i] >= vals[i+1]) {
                runningSum = runningSum + vals[i];
            } else {
                runningSum = runningSum + vals[i+1] - vals[i];
                i++;
            }
        }
        if (i < vals.length-1) {
            runningSum = runningSum + vals[vals.length-1];
        }

        return runningSum;
    }

    static boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        // code here
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            int rem = x - arr[i];
            if(map.get(rem) != null) {
                return true;
            }
            map.put(arr[i], i);
        }
        return false;
    }

    public static int[] topK(int[] nums, int k) {
        // Code here
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
                if(o1.getValue() == o2.getValue()) {
                    if(o1.getKey() > o2.getKey()) return -1;
                    else return 1;
                } else {
                    if(o1.getValue() < o2.getValue()) return 1;
                    else return -1;
                }
            }
        });
        int [] ans = new int[k];
        for(int i=0;i<k;i++) {
            ans[i] = list.get(i).getKey();
        }
        return ans;
    }

        public static int reverseBits(int n)
        {
            int rev = 0;
            while(n > 0) {
                rev = rev << 1;

                if((n & 1) == 1) {
                    rev = rev ^ 1;
                }

                n = n >> 1;
            }
            return rev;
        }

    public static void main(String[] args) {
        System.out.println(reverseBits(11));
    }
}