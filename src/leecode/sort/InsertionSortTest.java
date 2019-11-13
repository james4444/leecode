package leecode.sort;

public class InsertionSortTest {
    /**
     * 插入排序
     * @param nums
     * @return
     */
    public static int[] sort(int[] nums){
        if(nums == null || nums.length <=1) return nums;

        for(int i=1; i<nums.length; i++){
            int j = i-1;
            int val = nums[i];

            for(; j>=0; j--){
                if(val < nums[j]){
                    nums[j+1] = nums[j];
                }else{
                    break;
                }
            }

            nums[j+1] = val;
        }

        return nums;
    }
}
