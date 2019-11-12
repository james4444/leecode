package leecode.sort;

public class SortTest {

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,3,2,1};
        nums = sort2(nums);
        for(int num:nums){
            System.out.println(num);
        }
    }

    /**
     * 选择排血，每次找出未排序最小的，做交换
     */
    public static int[] sort3(int[] nums){
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
    /**
     * 插入排序
     * @param nums
     * @return
     */
    public static int[] sort2(int[] nums){
        for(int i=1; i<nums.length; i++){
            int value = nums[i];

            int j = i -1;
            for(; j>=0; j--){
                if(value < nums[j]){
                    nums[j+1] = nums[j];
                }else{
                    break;
                }
            }
            nums[j+1] = value;
        }
        return nums;
    }
    /**
     * 冒泡排序，每次交换两个相邻节点，如果一次循环没有交换，说明顺序正确，退出即可
     *
     * @param nums
     * @return
     */
    public static int[] sort1(int[] nums){
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
