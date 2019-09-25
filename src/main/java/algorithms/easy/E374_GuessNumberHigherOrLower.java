package algorithms.easy;

/**
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * <p>
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * <p>
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 * <p>
 * Example :
 * <p>
 * Input: n = 10, pick = 6
 * Output: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E374_GuessNumberHigherOrLower {
    /*
    The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num);
      */

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.guessNumber(10));
    }

    private static class Solution extends GuessGame {
        public int guessNumber(int n) {
            int indexL = 1;
            int indexR = n;

            while (indexL <= indexR) {
                n = indexL + (indexR - indexL) / 2;

                int flag = guess(n);

                if (flag > 0) {
                    indexL = n + 1;
                } else if (flag < 0) {
                    indexR = n - 1;
                } else {
                    return n;
                }
            }

            return -1;
        }
    }

    private static class GuessGame {
        int key = 6;

        public int guess(int n) {
            if (n < key) {
                return -1;
            } else if (n > key) {
                return 1;
            }
            return 0;
        }
    }
}
