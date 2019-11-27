package leecode.sort;

public class SelectionSortTest {
    /**
     * 选择排序，每次找出未排序最小的，做交换
     */
    public static int[] sort(int[] nums){
        for(int i=0 ; i<nums.length; i++){
            int minvalue = nums[i];
            int index = 0;
            boolean flag = false;
            for(int j=i+1; j<nums.length; j++){
                if(nums[j] < minvalue){
                    flag = true;
                    minvalue = nums[j];
                    index = j;
                }
            }

            if(flag){
                int temp = nums[i];
                nums[i] = minvalue;
                nums[index] = temp;
            }

        }

        return nums;

    }
}
