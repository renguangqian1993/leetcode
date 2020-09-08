package algorithms;

public class SortTest {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,7,9,8,6,4,2};
//        maopao(nums);
        kuaisu(nums);
        printArray(nums);
    }

    private static void printArray(int[] nums) {
        System.out.println("===============");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("===============");
    }

    private static void xuanze(int[] nums) {
        for (int index1 = 0; index1 < nums.length; index1++) {
            int minIndex = index1;
            for (int index2 = index1; index2 < nums.length; index2++) {
                if (nums[index2] < nums[minIndex]) {
                    minIndex = index2;
                }
            }

            int tmp = nums[index1];
            nums[index1] = nums[minIndex];
            nums[minIndex] = tmp;
        }
    }

    private static void maopao(int[] nums) {
        for (int cycle = 0; cycle < nums.length; cycle++) {
            for (int index = 0; index < nums.length - 1 - cycle; index++) {
                if (nums[index] > nums[index+1]) {
                    int tmp = nums[index];
                    nums[index] = nums[index+1];
                    nums[index+1] = tmp;
                }
            }
        }
    }

    private static void kuaisu(int[] nums) {
        quickSortRecursion(nums, 0, nums.length-1);
    }

    public static void quickSortRecursion(int[] data, int low, int high) {
        if (low < high) {

            int middle = partition(data, low, high);
            quickSortRecursion(data, low, middle - 1);
            quickSortRecursion(data, middle + 1, high);
        }
    }

    public static int partition(int[] data, int low, int high) {
        if (low >= high) {
            return low;
        }

        int middle = high;
        while (low < high) {
            while (low < high && data[low] <= data[middle]) {
                low++;
            }
            while (low < high && data[high] >= data[middle]) {
                high--;
            }

            if (low == high) {
                swap(data, low, middle);
                middle = low;
                break;
            } else if (low < high) {
                swap(data, low, high);
            } else {
                middle = low;
                break;
            }
        }
        return middle; // 返回中轴的位置
    }

    private static void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}
