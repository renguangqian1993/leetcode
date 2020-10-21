package algorithms.easy;

/**
 * @Author renguangqian
 * @Date 2020/10/21 13:03
 **/
public class E925_long_pressed_name {
    public static void main(String[] args) {
        new Solution().isLongPressedName("vtkgn","vttkgnn");
    }
    private static class Solution {
        public boolean isLongPressedName(String name, String typed) {
            int index1 = 0;
            int index2 = 0;

            while (index1 < name.length() || index2 < typed.length()) {
                if (index1 >= name.length() || index2 >= typed.length()) {
                    return false;
                }
                char c1 = name.charAt(index1);
                char c2 = typed.charAt(index2);
                if (c1 != c2) {
                    return false;
                }

                int repeatCount1 = 0;
                while (index1 < name.length()) {
                    if (name.charAt(index1++) == c1) {
                        repeatCount1++;
                    } else {
                        index1--;
                        break;
                    }
                }
                int repeatCount2 = 0;
                while (index2 < typed.length()) {
                    if (typed.charAt(index2++) == c2) {
                        repeatCount2++;
                    } else {
                        index2--;
                        break;
                    }
                }

                if (repeatCount1 > repeatCount2) {
                    return false;
                }
            }

            return true;
        }
    }
}
