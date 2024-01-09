package leetcode.editor.en;

class P289GameOfLife {
    public static void main(String[] args) {
        // Solution solution = new P289 Solution();
        Solution sol = new P289GameOfLife().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void gameOfLife(int[][] board) {
            if (board == null || board.length == 0) return;
            int m = board.length, n = board[0].length;

            for (int i = 0; i < m; i++) { // row
                for (int j = 0; j < n; j++) { // col
                    int lives = liveNeighbors(board, m, n, i, j);

                    // In the beginning, every 2nd bit is 0;
                    // So we only need to care about when will the 2nd bit become 1.
                    if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                        board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
                    }
                    if (board[i][j] == 0 && lives == 3) {
                        board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] >>= 1;  // Get the 2nd state.
                }
            }
        }

        /**
         * get number of lives arround (i, j)
         *
         * @param board
         * @param m:    row
         * @param n:    col
         * @param i:    current row
         * @param j:    current col
         * @return
         */
        public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
            int lives = 0;
            for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
                for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                    lives += board[x][y] & 1;
                }
            }
            lives -= board[i][j] & 1; // remove itself
            return lives;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}