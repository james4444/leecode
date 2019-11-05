package leecode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        System.out.println(singleNumber3(nums));
    }

    /**
     * 循环遍历，去掉重复的，留下不重复的
     * 时间复杂度为O(N²),循环nums,循环判断重复
     * 空间复杂度为O(N)
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                set.remove(num);
            }else{
                set.add(num);
            }
        }
        for (int num : set){
            result = num;
        }
        return  result;
    }

    /**
     * 利用hashmap,key为数字，value为次数
     * 取count==1的kye
     */
    public static int singleNumber2(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int result = -1;
        for(Integer num : nums){
            if(map.get(num) == null){
                map.put(num,1);
            }else{
                int count = map.get(num)+1;
                map.put(num,count);
            }
        }

        for(Integer num : map.keySet()){
            int count = map.get(num);
            if(count == 1){
                return num;
            }
        }

        return result;
    }

    /**
     * 异或运算
     * @param nums
     * @return
     */
    public static int singleNumber3(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }
}
