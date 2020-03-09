package com.github.spence.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class _140WordBreak2Test {

    @Test
    public void wordBreak() {

        String s = "aaaaaaaaaaaaaaaaaaaaaaaa";

        List<String> wordDict = Arrays.asList(new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"});
        List<String> result = new _140WordBreak2().wordBreak(s ,wordDict);

//        System.out.println(result);
        System.out.println(result.size());
    }
}