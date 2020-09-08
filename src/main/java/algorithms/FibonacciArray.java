package algorithms;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * f(n)=f(n-1)+f(n-2),n>2,f(0)=0;f(1)=f(2)=1，
 * 请编写一个非递归函数实现，要求时间复杂度和空间复杂度最低
 */
public class FibonacciArray {

    public static void main(String[] args) {
//        System.out.println(ffff(0));
//        System.out.println(ffff(1));
//        System.out.println(ffff(2));
//        System.out.println(ffff(3));
//        System.out.println(ffff(4));
//        System.out.println(ffff(5));
//        System.out.println(ffff(6));

        List<String> list = readFileAsList("C:\\Users\\renguangqian\\IdeaProjects\\leetcode\\src\\main\\resources\\configurationFile.xml");

        for (String str : list) {
            System.out.println(str);
        }
    }

    private static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int prepre = 0;
        int pre = 1;
        int current = 0;
        for (int index = 2; index <= n; index++) {
            current = pre + prepre;

            prepre = pre;
            pre = current;
        }

        return current;
    }

    private static List<String> readFileAsList(String filePath) {
        if (null == filePath || "".equals(filePath)) {
            return Collections.emptyList();
        }
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        List<String> list = new ArrayList<>(100);
        try {
            File file = new File(filePath);
            if (!file.exists() || !file.isFile()) {
                return Collections.emptyList();
            }
            inputStreamReader = new FileReader(file);
            bufferedReader = new BufferedReader(inputStreamReader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != bufferedReader) {
                    bufferedReader.close();
                    bufferedReader = null;
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                    inputStreamReader = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list;
    }

}
