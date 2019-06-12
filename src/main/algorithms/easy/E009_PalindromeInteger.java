package src.main.algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 * Input: 121
 * Output: true
 *
 * Example 2:
 * Input: -121
 * Output: false
 *
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 * Input: 10
 * Output: false
 *
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 *
 * Coud you solve it without converting the integer to a string?
 */
public class E009_PalindromeInteger {

    /**
     * Runtime: 8 ms, faster than 59.10% of Java online submissions for Palindrome Number.
     * Memory Usage: 35.7 MB, less than 52.39% of Java online submissions for Palindrome Number.
     * 使用List存放每一位数字，然后比较
     */
    public boolean isPalindrome(int x) {
        boolean result = true;

        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }

        List<Integer> list = new ArrayList();

        while (x >= 10) {
            list.add(x % 10);
            x = x / 10;
        }
        list.add(x);

        for (int index = 0; index <= (list.size() - 1) / 2; index++) {
            if (list.get(index) != list.get(list.size() - 1 - index)) {
                result = false;
                break;
            }
        }

        return result;
    }

    /**
     * Runtime: 7 ms, faster than 71.51% of Java online submissions for Palindrome Number.
     * Memory Usage: 36 MB, less than 51.40% of Java online submissions for Palindrome Number.
     * 直接将数字逆序，然后进行比较。
     * 下一步思考：是否可以逆转一半就去比较，而不是全部逆转
     */
    public boolean isPalindrome2(int x) {
        boolean result = true;

        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }

        int revertedVal = 0;
        int inputVal = x;
        while (inputVal != 0) {
            revertedVal = revertedVal * 10 + inputVal % 10;
            inputVal = inputVal / 10;
        }
        result = 0 == Integer.compare(x, revertedVal);

        return result;
    }
    
    /**
     * Runtime: 6 ms, faster than 100.00% of Java online submissions for Palindrome Number.
     * Memory Usage: 36.2 MB, less than 50.25% of Java online submissions for Palindrome Number.
     * 时间复杂度：O(log10(n))，对于每次迭代，我们会将输入除以10，因此时间复杂度为 O(log10(n))
     * 空间复杂度：O(1)。
     */
    public boolean isPalindrome3(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        } else if (x % 10 == 0) {
            return false;
        }
    
        int revertedVal = 0;
        while (x > revertedVal) {
            revertedVal = revertedVal * 10 + x % 10;
            x = x / 10;
        }
        return (x == revertedVal) || (x == (revertedVal / 10));
    }
    
    public static void main(String[] args) {
        new E009_PalindromeInteger().isPalindrome3(10);
    }

}
