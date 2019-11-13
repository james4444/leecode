package leecode.sort;

public class BubbleSortTest {
    /**
     * 冒泡排序，每次交换两个相邻节点，如果一次循环没有交换，说明顺序正确，退出即可
     *
     * @param nums
     * @return
     */
    public static int[] sort(int[] nums){
        int length = nums.length;
        if(length <= 1){
            return nums;
        }
        for(int i=0 ; i<length; i++){
            //提前退出冒牌排序的标志
            boolean flag = false;

            for(int j=0 ; j<length - i -1; j++){
                if(nums[j] > nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j +1];
                    nums[j + 1] = tmp;
                    flag = true;
                }
            }

            if(!flag) break;
        }
        return nums;
    }
}
