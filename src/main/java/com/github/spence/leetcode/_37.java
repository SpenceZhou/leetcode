package com.github.spence.leetcode;

import java.util.*;

public class _37 {

    static class Solution {
        public void solveSudoku(char[][] board) {
            try {
                Map<String, List<Character>> allAvailable = getAllAvailable(board);
                traceBack(board, allAvailable);
            } catch (Exception e) {
            }
        }

        private boolean traceBack(char[][] board, Map<String, List<Character>> allAvailable) {
            if (allAvailable.isEmpty()) {
                return true;
            }
            List<String> list = new ArrayList<String>(allAvailable.keySet());
            Collections.sort(list);
            String key = list.get(0);
            String[] arr = key.split(",");
            int i = Integer.parseInt(arr[1]);
            int j = Integer.parseInt(arr[2]);
            List<Character> characters = allAvailable.get(key);
            for (Character character : characters) {
                board[i][j] = character;
                try {
                    Map<String, List<Character>> newAllAvailable = getAllAvailable(board);
                    boolean flag = traceBack(board, newAllAvailable);
                    if (flag) {
                        return true;
                    }
                } catch (Exception e) {
//                        e.printStackTrace();
                }
                // 恢复修改
                board[i][j] = '.';
            }
            return false;
        }

        /**
         * key 的形式为  count,i,j
         *
         * @param board
         * @return
         */
        public Map<String, List<Character>> getAllAvailable(char[][] board) throws Exception {
            Map<String, List<Character>> map = new TreeMap<>(String::compareTo);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char c = board[i][j];
                    if (c == '.') {
                        List<Character> list = available(i, j, board);
                        String key = list.size() + "," + i + "," + j;
                        map.put(key, list);
                    }
                }
            }
            return map;
        }

        private List<Character> available(int i, int j, char[][] board) throws Exception {
            Set<Character> existsSet = new HashSet<>();
            if ('.' != board[i][j]) {
                existsSet.add(board[i][j]);
            } else {
                // row
                List<Character> rowList = new ArrayList<>();
                for (int y = 0; y < 9; y++) {
                    char row = board[i][y];
                    if ('.' != row && y != j) {
                        if (rowList.contains(row)) {
                            throw new Exception();
                        }
                        rowList.add(row);
                    }
                }
                existsSet.addAll(rowList);
                // col
                List<Character> colList = new ArrayList<>();
                for (int x = 0; x < 9; x++) {
                    char col = board[x][j];
                    if ('.' != col && x != i) {
                        if (colList.contains(col)) {
                            throw new Exception();
                        }
                        colList.add(col);
                    }
                }
                existsSet.addAll(colList);
                // sub board
                List<Character> subBoardList = new ArrayList<>();
                int iSize = i / 3;
                int jSize = j / 3;
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        char c = board[x + iSize * 3][y + jSize * 3];
                        if ('.' != c && x != i && y != j) {
                            if (subBoardList.contains(c)) {
                                throw new Exception();
                            }
                            subBoardList.add(c);
                        }
                    }
                }
                existsSet.addAll(subBoardList);
            }
            List<Character> result = new ArrayList<>();
            for (int x = 1; x < 10; x++) {
                char c = (x + "").charAt(0);
                if (!existsSet.contains(c)) {
                    result.add(c);
                }
            }
            if (result.isEmpty()) {
                throw new Exception();
            }

            return result;
        }
    }


    public static void main(String[] args) {
//        char[][] board = {
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        };

        char[][] board = {{'.', '.', '9', '7', '4', '8', '.', '.', '.'}, {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '2', '.', '1', '.', '9', '.', '.', '.'}, {'.', '.', '7', '.', '.', '.', '2', '4', '.'}, {'.', '6', '4', '.', '1', '.', '5', '9', '.'}, {'.', '9', '8', '.', '.', '.', '3', '.', '.'}, {'.', '.', '.', '8', '.', '3', '.', '2', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '6'}, {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};

        new _37.Solution().solveSudoku(board);

    }


}
