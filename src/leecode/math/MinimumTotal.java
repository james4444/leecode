package leecode.math;

import java.util.ArrayList;
import java.util.List;

public class MinimumTotal {


    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();
        getList(triangle,-1);
        getList(triangle,2,3);
        getList(triangle,1,-1,-3);

        System.out.println(minimumTotal(triangle));

    }

    public static void getList( List<List<Integer>> triangle,int...nums){
        List<Integer> list = new ArrayList<>();
        for(int num:nums){
            list.add(num);
        }

        triangle.add(list);
    }


    public static int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] minlen = new int[row+1];
        for (int level = row-1;level>=0;level--){
            for (int i = 0;i<=level;i++){   //第i行有i+1个数字
                minlen[i] = Math.min(minlen[i], minlen[i+1]) + triangle.get(level).get(i);
            }
        }
        return minlen[0];

    }
    private static int helper(int level, int c, List<List<Integer>> triangle,int[][] memo){
        if (memo[level][c]!=0)
            return memo[level][c];
        if (level==triangle.size()-1){
            return memo[level][c] = triangle.get(level).get(c);
        }
        int left = helper(level+1, c, triangle,memo);
        int right = helper(level+1, c+1, triangle,memo);
        return memo[level][c] = Math.min(left, right) + triangle.get(level).get(c);


    }


}
