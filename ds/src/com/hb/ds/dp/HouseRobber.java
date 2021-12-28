package com.hb.ds.dp;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    Map<Integer, Integer> mem = new HashMap<>();

    // Top down
    public int rob1(int[] houses) {
        return auxRob(houses, houses.length-1);
    }

    private int auxRob(int[] houses, int index) {

        if (index == 0) {
            return houses[index];
        }
        if (index == 1) {
            return Math.max(houses[0], houses[1]);
        }
        if (!mem.containsKey(index)) {
            mem.put(index, Math.max(auxRob(houses, index - 1), auxRob(houses, index - 2) + houses[index]));
        }
        return mem.get(index);
    }

    // Bottom Up
    public int rob(int[] houses) {
        if (houses.length == 1) {
            return houses[0];
        }
        int mem[] = new int[houses.length];
        mem[0] = houses[0];
        mem[1] = Math.max(houses[0], houses[1]);
        for (int i = 2; i < houses.length; i++) {
            mem[i] = Math.max(mem[i - 1], mem[i - 2] + houses[i]);
        }
        return mem[houses.length - 1];
    }

}
