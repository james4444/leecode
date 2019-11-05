package leecode.array;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class twoSumTest1 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,7,11,15};
        int target = 9;
        int[] result = twoSum2(nums,target);
        System.out.println(result[0] + "  " + result[1]);
    }

    /**
     * 1 循环数组
     * 2 将余数作为key，下标作为val 存入map
     * 3 如果循环的数字和key相等
     * 4 返回map中的val和当前正在循环的下标
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum2(int[] nums, int target) {
        int[] result = null;

        HashMap<Integer,Integer> map = new HashMap();

        for (int i=0; i<nums.length; i++){

            if(null == map.get(nums[i])){
                int num = target - nums[i];
                map.put(num,i);
            }else {
                return new int[]{map.get(nums[i]),i};
            }

        }

        return result;
    }

    /**
     * 遍历数组，两层循环遍历时间复杂度为O(N²)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        int[] result = null;

        for (int i=0; i<nums.length; i++){
            for (int j=nums.length -1;j>i;j--){
                if(nums[i] + nums[j] == target){
                    result = new int[]{i,j};
                }
            }
        }
        return result;
    }




}

