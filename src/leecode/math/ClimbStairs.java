package leecode.math;

import java.util.HashMap;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs2(5));
    }


    /**
     * 递归写法
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        return climbStairs(n,map);
    }
    public static int climbStairs(int n,HashMap<Integer,Integer> map) {
        if(n <= 2) return n;
        if(!map.containsKey(n)){
            map.put(n,climbStairs(n-1,map) + climbStairs(n-2,map));
        }

        return map.get(n);
    }


    /**
     * 递推公式 f(n) = f(n-1) + f(n-2)
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        if(n <= 2) return n;

        int[] nums = new int[3];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 2;

        for(int i=2; i<n; i++){
            nums[0] = nums[1];
            nums[1] = nums[2];
            nums[2] = nums[0] + nums[1];
        }
        return nums[2];
    }




}
