package one_question_a_day.april;

public class C4_20文件的最长绝对路径 {
    /*可以*/
    public int lengthLongestPath(String input) {
        int n = input.length();
        int pos = 0;
        int ans = 0;
        int[] level = new int[n + 1];

        while (pos < n) {
            /* 检测当前文件的深度 */
            int depth = 1;
            while (pos < n && input.charAt(pos) == '\t') {
                pos++;
                depth++;
            }
            /* 统计当前文件名的长度 */
            int len = 0;
            boolean isFile = false;
            while (pos < n && input.charAt(pos) != '\n') {
                if (input.charAt(pos) == '.') {
                    isFile = true;
                }
                len++;
                pos++;
            }
            /* 跳过换行符 */
            pos++;

            if (depth > 1) {
                len += level[depth - 1] + 1;
            }
            if (isFile) {
                ans = Math.max(ans, len);
            } else {
                level[depth] = len;
            }
        }
        return ans;
    }
    /*给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
    例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）*/
    public boolean exist(char[][] board, String word) {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (dfs(board,word,x,y,0)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int x, int y, int starti) {
        if (x < 0 || y < 0 || x >=board.length || y >= board[0].length || board[x][y] != word.charAt(starti)) return false;
        if (starti == word.length()-1 ) return true;
        board[x][y] = '\0';
        boolean res = dfs(board,word,x+1,y,starti+1) ||dfs(board,word,x-1,y,starti+1) ||dfs(board,word,x,y+1,starti+1) ||dfs(board,word,x,y-1,starti+1) ;
        board[x][y] = word.charAt(starti);
        return res;
    }
}
