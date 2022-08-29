package backtracking;

public class C04解数独 {
    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    private boolean backtracking(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] !=  '.') continue;

                for (char k = '1'; k <= '9'; k++) {
//                    装填
                    if (isOK(board,i,j,k)) {
                        board[i][j] = k;
                        if (backtracking(board)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;  // 说明遍历完了里面的所有的数字，依旧没有得到return true
            }

        }
        return true;  // 说明每个点都得到了答案 所以返回true
    }

    /**
     * 判断是否符合要求
     * @param board
     * @param x
     * @param y
     * @param k
     * @return
     */
    private boolean isOK(char[][] board, int x, int y, char k) {
//        判断列
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == k) return false;
        }
//        判断行
        for (int i = 0; i < board[0].length; i++) {
            if (board[x][i] == k) return false;
        }
//        判断小方格
        for (int i = x - x%3; i < x - x%3 +3 ; i++) {
            for (int j = y - y % 3; j < y - y % 3 + 3; j++) {
                if (board[i][j] == k) return false;
            }
        }
        return true;
    }
}
