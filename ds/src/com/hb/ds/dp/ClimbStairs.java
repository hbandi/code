package com.hb.ds.dp;


import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
    Map<Integer, Integer> mem = new HashMap<>();

    //Top down
    public int climbStairs1(int n) {
        return auxDp1(n);
    }

    private int auxDp1(int i) {
        if (i <= 2) {
            mem.put(i, i);
        }
        if (!mem.containsKey(i)) {
            mem.put(i, auxDp1(i - 1) + auxDp1(i - 2));
        }
        return mem.get(i);
    }

    //Bottom Up
    public int climbStairs(int n) {
        int[] mem = new int[n + 1];
        return auxDp(n, mem);
    }

    private int auxDp(int n, int[] mem) {
        //Base Cases
        mem[0] = 0;
        mem[1] = 1;
        mem[2] = 2;
        /**
         * Fill the remaining cases using base cases
         */
        for (int i = 3; i <= n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        return mem[n];
    }

}
