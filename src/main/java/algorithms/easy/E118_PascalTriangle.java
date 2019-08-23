package algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 5
 * Output:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E118_PascalTriangle {

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.88%的用户
     * 内存消耗 :34.5 MB, 在所有 Java 提交中击败了25.70%的用户
     * 傻瓜式遍历-_-
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();

        for (int index = 0; index < numRows; index++) {
            int size = index + 1;
            List<Integer> listOfOneRow = new ArrayList<>();
            for (int indexOfOneRow = 0; indexOfOneRow < size; indexOfOneRow++) {
                if (indexOfOneRow == 0 || indexOfOneRow == size - 1) {
                    listOfOneRow.add(1);
                } else {
                    List<Integer> listOfLastRow = resultList.get(index - 1);
                    listOfOneRow.add(listOfLastRow.get(indexOfOneRow) + listOfLastRow.get(indexOfOneRow - 1));
                }
            }

            resultList.add(listOfOneRow);
        }

        return resultList;
    }
}
