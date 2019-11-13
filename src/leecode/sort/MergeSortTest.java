package leecode.sort;

/**
 * 归并算法
 */
public class MergeSortTest {
    /**
     * 归并排序
     * @param nums
     * @return
     */
    public static void sort(int[] nums, int start, int end) {

        if(start < end){
            int mid = (start + end )/2;

            sort(nums,start,mid);
            sort(nums,mid+1,end);

            merge(nums,start,mid,end);

        }
    }

    /**
     * 合并
     * @param nums
     * @param start
     * @param mid
     * @param end
     */
    private static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int p1 = start;
        int p2 = mid + 1;
        int k = 0;

        while (p1<=mid && p2<=end){
            if(nums[p1] <= nums[p2]){
                temp[k++] = nums[p1++];
            }else {
                temp[k++] = nums[p2++];
            }
        }

        while (p1 <= mid ) temp[k++] = nums[p1++];
        while (p2 <= end) temp[k++] = nums[p2++];

        for(int i = start; i <= end; i++){
            nums[i] = temp[i - start];
        }
    }
}
