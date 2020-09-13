package algorithms.medium;

/**
 * 79. 单词搜索
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M079_word_search {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{new char[]{'C','A','A'},new char[]{'A','A','A'},new char[]{'B','C','D'}};
        String word = "AAB";
        System.out.println(solution.exist(board, word));
    }

    static class Solution {
        public boolean exist(char[][] board, String word) {
            char[] wordChars = word.toCharArray();
            boolean[][] accessedFlag = new boolean[board.length][board[0].length];

            for (int indexY = 0; indexY < board.length; indexY++) {
                for (int indexX = 0; indexX < board[0].length; indexX++) {
                    //双层for循环，将二维数组每个节点当做第一个节点进行匹配
                    boolean matched = charMatched(board, accessedFlag, wordChars, 0, indexY, indexX);
                    if (matched) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean charMatched(char[][] board, boolean[][] flagArray,
                                    char[] charsToMatch, int charsIndex,
                                    int indexY, int indexX) {
            if (charsIndex >= charsToMatch.length) {
                //越界，表示之前的都匹配成了
                return true;
            }

            if (indexY < 0 || indexY >= board.length/**纵坐标越界*/
                    || indexX < 0 || indexX >= board[0].length/**横坐标越界*/
                    || flagArray[indexY][indexX]/****/) {
                return false;
            }

            //当前节点是否匹配
            boolean matched = board[indexY][indexX] == charsToMatch[charsIndex];
            if (!matched) {
                return false;
            }

            flagArray[indexY][indexX] = true;
            matched = charMatched(board, flagArray, charsToMatch, charsIndex + 1, indexY + 1, indexX);
            if (matched) {
                return true;
            }

            matched = charMatched(board, flagArray, charsToMatch, charsIndex + 1, indexY, indexX + 1);
            if (matched) {
                return true;
            }

            matched = charMatched(board, flagArray, charsToMatch, charsIndex + 1, indexY - 1, indexX);
            if (matched) {
                return true;
            }

            matched = charMatched(board, flagArray, charsToMatch, charsIndex + 1, indexY, indexX - 1);
            if (matched) {
                return true;
            }

            //回溯，将当前节点置为false表示未占用
            flagArray[indexY][indexX] = false;

            return false;
        }
    }
}
