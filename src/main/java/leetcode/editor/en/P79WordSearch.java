//Given an m x n grid of characters board and a string word, return true if 
//word exists in the grid. 
//
// The word can be constructed from letters of sequentially adjacent cells, 
//where adjacent cells are horizontally or vertically neighboring. The same letter 
//cell may not be used more than once. 
//
// 
// Example 1: 
// 
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCCED"
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "SEE"
//Output: true
// 
//
// Example 3: 
// 
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCB"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board and word consists of only lowercase and uppercase English letters. 
// 
//
// 
// Follow up: Could you use search pruning to make your solution faster with a 
//larger board? 
//
// Related Topics Array Backtracking Matrix 👍 14725 👎 606

package leetcode.editor.en;

class P79WordSearch {
    public static void main(String[] args) {
        // Solution solution = new P79 Solution();
        Solution sol = new P79WordSearch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean result = false;

        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            outer:
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == word.charAt(0))
                        backtracking(i, j, board, visited, word, new StringBuilder());
                    if (result) break outer;
                }
            }
            return result;
        }

        private void backtracking(int x, int y, char[][] board, boolean[][] visited, String word, StringBuilder curr) {
            int m = board.length;
            int n = board[0].length;
            if (x < 0 || x >= m) return;
            if (y < 0 || y >= n) return;
            if (visited[x][y]) return;
            if (curr.length() >= word.length()) return;
            if (board[x][y] != word.charAt(curr.length())) return;

            curr.append(board[x][y]);
            visited[x][y] = true;

            if (curr.toString().equals(word)) {
                result = true;
                return;
            }

            backtracking(x - 1, y, board, visited, word, curr);
            backtracking(x + 1, y, board, visited, word, curr);
            backtracking(x, y - 1, board, visited, word, curr);
            backtracking(x, y + 1, board, visited, word, curr);

            curr.deleteCharAt(curr.length() - 1);
            visited[x][y] = false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}