package com.github.spence.leetcode;

public class _72 {
    static class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();

            int[][] dpStatesArr = new int[m + 1][n + 1];
            for (int i = 0; i < m + 1; i++) {
                dpStatesArr[i][0] = i;
            }
            for (int j = 0; j < n + 1; j++) {
                dpStatesArr[0][j] = j;
            }
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    int i_1 = dpStatesArr[i - 1][j] + 1;
                    int j_1 = dpStatesArr[i][j - 1] + 1;
                    int all_1 = dpStatesArr[i - 1][j - 1] + (word1.charAt(i - 1) != word2.charAt(j - 1) ? 1 : 0);
                    dpStatesArr[i][j] = Math.min(all_1, Math.min(i_1, j_1));
                }
            }
            return dpStatesArr[m][n];
        }
    }

    public static void main(String[] args) {
        System.out.println(new _72.Solution().minDistance("sea", "eat"));
    }
}
