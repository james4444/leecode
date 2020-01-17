package leecode.array;

public class ReplaceElements {
    public static void main(String[] args) {
        int[] arr = new int[]{17,18,5,4,6,1};

        System.out.println(replaceElements(arr));
    }


    public static int[] replaceElements(int[] arr) {
        if(null == arr || arr.length == 0) return arr;
        int bignum = arr[arr.length-1];
        arr[arr.length-1] = -1;

        if(arr.length == 1) return arr;

        for(int i = arr.length - 2 ; i >= 0; --i){

            if(arr[i] > bignum){
                int temp = bignum;
                bignum = arr[i];
                arr[i] = temp;
            } else {
                arr[i] = bignum;
            }
        }

        return arr;
    }
}
