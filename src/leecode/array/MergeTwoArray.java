package leecode.array;

public class MergeTwoArray {

    public static void main(String[] args) {
        int[] a = new int[]{1,3,4,5,8};
        int[] b = new int[]{2,5,6,7,9};

        int[] result = merger(a,b);
        ArrayUtils.printArray(result);

    }

    /**
     * 合并两个有序数组，类似于归并排序
     * @param a
     * @param b
     */
    public static int[] merger(int[] a,int [] b){

        int alength = a.length;
        int blength = b.length;

        int i = 0;
        int j = 0;
        int k = 0;

        //数组长度为两个之和
        int[] result = new int[alength + blength];

        while (i < alength && j < blength){
            if(a[i] >= b[j]){
                result[k++] = b[j++];
            }else{
                result[k++] = a[i++];
            }
        }

        if(j < blength) result[k++] = b[j++];
        if(i < alength) result[k++] = a[i++];

        return result;


    }
}
