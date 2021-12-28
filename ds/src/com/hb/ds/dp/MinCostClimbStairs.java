package com.hb.ds.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinCostClimbStairs {

    Map<Integer,Integer> mem=new HashMap<>();

    public static void main(String[] args) {
        int[] cost = {10,15,20};
        MinCostClimbStairs ms = new MinCostClimbStairs();
        int result = ms.minCostClimbingStairs(cost);
        System.out.printf("Result= " + result);
    }

    /**
     * BottomUp approach
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] mem = new int[cost.length+1];
        for (int i = 2; i < mem.length; i++) {
            int oneStep=mem[i-1]+cost[i-1];
            int twoStep=mem[i-2]+cost[i-2];
            mem[i]=Math.min(oneStep,twoStep);
        }
        System.out.println(Arrays.toString(mem));
        return mem[mem.length - 1];
    }

    /**
     * Top-down approach
     */
    public int minCostClimbingStairs1(int[] cost) {
        return minCost(cost.length,cost);
    }

    public int minCost(int i,int[] costs){
        if(i<=1){
            return i;
        }
        if(mem.containsKey(i)){
            return mem.get(i);
        }
        int downOne=costs[i-1]+minCost(i-1,costs);
        int downTwo=costs[i-2]+minCost(i-2,costs);
        mem.put(i,Math.min(downOne,downTwo));
        return mem.get(i);
    }
}
