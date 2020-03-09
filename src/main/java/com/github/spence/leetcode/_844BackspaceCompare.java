package com.github.spence.leetcode;

/**
 * @author spence
 */
public class _844BackspaceCompare {

    public boolean backspaceCompare(String S, String T) {
        return formatStr(S).equals(formatStr(T));
    }

    private String formatStr(String s) {
        int index = s.indexOf("#");
        if (index == 0) {
            String subS = s.substring(1);
            return formatStr(subS);
        } else if (index > 0) {
            String subS = s.substring(0, index - 1) + s.substring(index + 1);
            return formatStr(subS);
        } else {
            return s;
        }
    }
}
