package leecode.sort;

public class SortTest {

    /**
     * 排序的多种方式
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,3,2,1};


        //冒泡排序
//        BubbleSortTest.sort(nums);

        //插入排序
//        InsertionSortTest.sort(nums);

        //选择排序
//        SelectionSortTest.sort(nums);

        //归并排序
//        MergeSortTest.sort(nums,0,nums.length-1);

        //快速排序
            QuikSortTest.sort(nums,0,nums.length-1);
        for(int num:nums){
            System.out.println(num);
        }
    }




}
