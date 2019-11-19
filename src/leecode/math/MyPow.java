package leecode.math;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class MyPow {
    public static void main(String[] args) {
        System.out.println(myPow(2,-2));
    }

    public static double myPow(double x, int n) {
        if(n == 0) return 1;

        if(n >0 ){
            return calMyPow(x,n);
        }

        if(n < 0 ){
            return 1/calMyPow(x,-n);
        }

        return x;
    }

    /**
     * 利用分治思想
     * @param x
     * @param n
     * @return
     */
    public static double calMyPow(double x,int n){
        if(n == 0) return 1;

        double half = calMyPow(x,n/2);
        if(n%2 == 0){
            return half*half;
        }else {
            return x*half*half;
        }

    }
}
