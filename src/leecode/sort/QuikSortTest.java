package leecode.sort;

public class QuikSortTest {
    /**
     * 快速排序
     */
    public static void sort(int[] nums, int start, int end) {
        if(null == nums || nums.length <= 1) return;

        if(start >= end) return;

        int key = nums[start];

        int i= start;

        for(int j=start+1 ;j<=end; j++){
            if(nums[j] < key){//交换i
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }

        nums[i] = key;
        sort(nums,start,i-1);
        sort(nums,i+1, end);
    }
}

