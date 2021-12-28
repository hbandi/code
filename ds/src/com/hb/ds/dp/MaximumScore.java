package com.hb.ds.dp;

public class MaximumScore {
    int mem[][] = null;

    public static void main(String[] args) {
        MaximumScore ms = new MaximumScore();
        int[] nums = {-5, -3, -3, -2, 7, 1};
        int[] multipliers = {-10, -5, 3, 4, 6};
        int result = ms.maxScore(nums, multipliers);
        System.out.println("Result= " + result);
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        mem = new int[multipliers.length][multipliers.length];
        return auxMaxScore(nums, multipliers, 0, nums.length - 1, 0);
    }

    public int auxMaxScore(int nums[], int[] multipliers, int start, int end, int index) {
        if (index == multipliers.length) {
            return 0;
        }
        if (mem[index][start] != 0) {
            return mem[index][start];
        }
        int multiplier = multipliers[index];
        int leftPick = nums[start] * multiplier + auxMaxScore(nums, multipliers, start + 1, end, index + 1);
        int rightPick = nums[end] * multiplier + auxMaxScore(nums, multipliers, start, end - 1, index + 1);
        mem[index][start] = Math.max(leftPick, rightPick);
        return mem[index][start];

    }

    /**
     * Bottom Up Approach
     */
    public int maxScore(int[] nums, int[] multipliers){
        int n = nums.length;
        int m = multipliers.length;
        int[][] dp = new int[m + 1][m + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int left = i; left >= 0; left--) {
                int mult = multipliers[i];
                int right = n - 1 - (i - left);
                dp[i][left] = Math.max(mult * nums[left] + dp[i + 1][left + 1],
                        mult * nums[right] + dp[i + 1][left]);
            }
        }

        return dp[0][0];
    }
}
