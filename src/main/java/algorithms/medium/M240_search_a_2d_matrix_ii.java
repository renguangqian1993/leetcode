package algorithms.medium;

/**
 * 编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target=5，返回true。
 * <p>
 * 给定target=20，返回false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M240_search_a_2d_matrix_ii {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return binarySearch(matrix, target,
                0, matrix[0].length - 1,
                0, matrix.length - 1);
    }
    private boolean binarySearch(int[][] matrix, int target, int fromW, int toW, int fromH, int toH) {
        if (fromW > toW || fromH > toH) {
            return false;
        }

        if (fromW == toW && fromH == toH) {
            return matrix[fromH][fromW] == target;
        } else if (matrix[toH][toW] < target) {
            return false;
        } else if (matrix[fromH][fromW] > target) {
            return false;
        }

        int midW = (fromW + toW) / 2;
        int midH = (fromH + toH) / 2;
        if (matrix[midH][midW] == target) {
            return true;
        } else if (matrix[midH][midW] > target) {
            //1,2,3
            return binarySearch(matrix, target, fromW, midW, fromH, midH)
                    || binarySearch(matrix, target, midW + 1, toW, fromH, midH)
                    || binarySearch(matrix, target, fromW, midW, midH + 1, toH);
        } else {
            //2,3,4
            return binarySearch(matrix, target, midW + 1, toW, fromH, midH)
                    || binarySearch(matrix, target, fromW, midW, midH + 1, toH)
                    || binarySearch(matrix, target, midW + 1, toW, midH + 1, toH);
        }
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int left = 0;
        int down = matrix.length - 1;
        while (left < matrix[0].length && down >= 0) {
            if (matrix[down][left] == target) {
                return true;
            } else if (matrix[down][left] > target) {
                down--;
            } else {
                left++;
            }
        }

        return false;
    }

    public boolean isPalindrome(String s) {
        if (null == s) return true;

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--))) {
                return false;
            }
        }
        return true;
    }
}
