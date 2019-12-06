package leecode.dp;

/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProduct {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,-2,4};
        System.out.println(maxProduct2(nums));
    }


    /**
     * 暴力破解法
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int result = nums[0];
        for(int i=0; i<nums.length; i++){
            int max = nums[i];
            int temp = nums[i];
            for(int j=i+1; j<nums.length; j++){
                temp = temp * nums[j];
                if(temp > max){
                    max = temp;
                }
            }

            if(max > result){
                result = max;
            }
        }

        return result;
    }

    /**
     * 动态规划
     * dp 方程
     * if a[i-1]>0
     * max = max(dp[i-1])*a[i]
     * else
     * max = min(dp[i-1])*a[i]
     * @param nums
     * @return
     */
    public static int maxProduct2(int[] nums) {
        int max = nums[0];
        int curMax = 1;
        int curMin = 1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }

            curMax = Math.max(curMax*nums[i],nums[i]);
            curMin = Math.min(curMin*nums[i],nums[i]);

            max = Math.max(max,curMax);

        }

        return max;
    }

}
