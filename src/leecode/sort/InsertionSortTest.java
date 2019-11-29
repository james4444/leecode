package leecode.sort;

public class InsertionSortTest {
    /**
     * 插入排序
     * @param nums
     * @return
     */
    public static int[] sort(int[] nums){
        for(int i=1;i<nums.length;i++){
            int j = i-1;
            int num = nums[i];
            for(;j>=0;j--){
                if(nums[j]>nums[i]){
                    int temp = nums[j];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
            nums[j+1] = num;
        }
        return nums;
    }
}
