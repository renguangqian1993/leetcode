package algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * <p>
 * Note that the row index starts from 0.
 * <p>
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output: [1,3,3,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E119_PascalTriangle_II {

    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了59.91%的用户
     * 内存消耗 :34.5 MB, 在所有 Java 提交中击败了21.84%的用户
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> resultList = null;

        List<Integer> listOfLastRow = null;
        for (int index = 0; index <= rowIndex; index++) {
            int size = index + 1;

            resultList = new ArrayList<>();
            for (int indexOfOneRow = 0; indexOfOneRow < size; indexOfOneRow++) {
                if (indexOfOneRow == 0 || indexOfOneRow == size - 1) {
                    resultList.add(1);
                } else {
                    resultList.add(listOfLastRow.get(indexOfOneRow - 1) + listOfLastRow.get(indexOfOneRow));
                }
            }

            listOfLastRow = resultList;
        }


        return resultList;
    }
}
