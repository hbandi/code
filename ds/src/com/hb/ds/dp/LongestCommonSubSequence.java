package com.hb.ds.dp;

import java.util.Arrays;

public class LongestCommonSubSequence {

    int[][] mem;
    static String subSequence = new String();

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        LongestCommonSubSequence ls = new LongestCommonSubSequence();
        int result = 0;
        if (text1.length() > text2.length()) {
            result = ls.longestCommonSubsequence1(text1, text2);
        } else {
            result = ls.longestCommonSubsequence1(text2, text1);
        }
        System.out.println("Result= " + result);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text2, 0, 0);

    }

    public int lcs(String text1, String text2, int index1, int index2) {

        if (index1 == text1.length() || index2 == text2.length()) {
            return 0;
        }
        if (text1.charAt(index1) == text2.charAt(index2)) {
            return 1 + lcs(text1, text2, index1 + 1, index2 + 1);
        } else {
            return Math.max(lcs(text1, text2, index1 + 1, index2), lcs(text1, text2, index1, index2 + 1));
        }
    }

    public int longestCommonSubsequence1(String text1, String text2) {
        mem = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i <= text1.length(); i++) {
            mem[i][0] = 0;
        }
        for (int i = 0; i <= text2.length(); i++) {
            mem[0][i] = 0;
        }

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                lcs1(text1, text2, i, j);
            }
        }
        for (int i = 0; i < mem.length; i++) {
            System.out.println(Arrays.toString(mem[i]));
        }
        return mem[text1.length()][text2.length()];
    }

    public void lcs1(String text1, String text2, int i, int j) {
        if (text1.charAt(i-1) == text2.charAt(j-1)) {
            mem[i][j] = 1 + mem[i - 1][j - 1];
        } else {
            mem[i][j] = Math.max(mem[i - 1][j], mem[i][j - 1]);
        }
    }

}
