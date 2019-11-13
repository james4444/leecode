package leecode.sort;

public class QuikSortTest {
    /**
     * 快速排序
     */
    public static void sort(int[] nums, int start, int end) {
        if (start < end) {
            int key = nums[start];//初始化保存基元
            int i = start, j;//初始化i,j
            for (j = start + 1; j <= end; j++) {
                if (nums[j] < key) {
                    //如果此处元素小于基元，则把此元素和i+1处元素交换，并将i加1，如大于或等于基元则继续循环
                    int temp = nums[j];
                    nums[j] = nums[i + 1];
                    nums[i + 1] = temp;
                    i++;
                }
            }
            nums[start] = nums[i];//交换i处元素和基元
            nums[i] = key;
            sort(nums, start, i - 1);//递归调用
            sort(nums, i + 1, end);
        }
    }
}

