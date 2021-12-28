package com.hb.ds.dp;

import java.util.HashMap;
import java.util.Map;

public class TribonacciNumber {

    Map<Integer, Integer> mem = new HashMap<>();

    public static void main(String[] args) {
        TribonacciNumber tn = new TribonacciNumber();
        int result = tn.tribonacci(0);
        System.out.println("result= " + result);
    }

    /**
     * BottomUp approach
     */
    public int tribonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        int[] mem = new int[n + 1];
        mem[0] = 0;
        mem[1] = mem[2] = 1;
        for (int i = 3; i <= n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2] + mem[i - 3];
        }
        return mem[n];
    }

    /**
     * Top-Down approach
     */
    public int tribonacci1(int n) {
        return auxTribonacci(n);
    }

    private int auxTribonacci(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1 || i == 2) {
            return 1;
        }
        if (mem.containsKey(i)) {
            return mem.get(i);
        }
        mem.put(i, auxTribonacci(i - 1) + auxTribonacci(i - 2) + auxTribonacci(i - 3));
        return mem.get(i);
    }
}
