package com.github.spence.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class _844BackspaceCompareTest {

    @Test
    public void backspaceCompare() {

        String S = "a##c";
        String T = "#a#c";

        System.out.println(new _844BackspaceCompare().backspaceCompare(S,T));

    }
}