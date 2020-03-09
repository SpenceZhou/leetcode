package com.github.spence.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author spence
 */
public class _140WordBreak2 {

    private Map<String, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.isEmpty() || wordDict == null || wordDict.isEmpty()) {
            return result;
        }
        List<String> containWordDict = new ArrayList<String>();
        for (String dict : wordDict) {
            if (s.contains(dict)) {
                containWordDict.add(dict);
            }
        }
        if (containWordDict.isEmpty()) {
            return result;
        }
        return breakWord("", s, containWordDict);
    }

    private List<String> breakWord(String wordSequence,
                                   String s,
                                   List<String> wordDict) {
        List<String> list = new ArrayList<String>();
        if (map.containsKey(s)) {
            list = map.get(s);
        } else {
            List<String> startWords = new ArrayList<String>();
            for (String dict : wordDict) {
                if (s.startsWith(dict)) {
                    startWords.add(dict);
                }
            }
            if (startWords.isEmpty()) {
                //不满足情况
                return new ArrayList<String>();
            }
            for (String startWord : startWords) {
                String subS = s.substring(startWord.length());
                if (subS.isEmpty()) {
                    list.add(startWord);
                } else {
                    List<String> subBreakWord = breakWord(startWord, subS, wordDict);
                    if (subBreakWord != null && !subBreakWord.isEmpty()) {
                        list.addAll(subBreakWord);
                    }
                }
            }
            map.put(s, list);
        }
        List<String> result = new ArrayList<String>();
        for (String word : list) {
            if (wordSequence.isEmpty()) {
                result.add(word);
            } else {
                result.add(wordSequence + " " + word);
            }
        }
        return result;
    }
}
