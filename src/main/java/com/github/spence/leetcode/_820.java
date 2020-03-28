package com.github.spence.leetcode;

import java.util.Arrays;

public class _820 {

    static class Solution {
        public int minimumLengthEncoding(String[] words) {
            Arrays.sort(words,((s1, s2) -> {
                return Integer.compare(s2.length(),s1.length());
            }));
            String result = "";
            for (String word : words) {
                if (!result.contains(word+"#")) {
                    result+=word+"#";
                }
            }
            return result.length();
        }
    }


    public static void main(String[] args) {
        String[] words = new String[]{"time", "me", "bell"};
        System.out.println(new Solution().minimumLengthEncoding(words));
    }
}
