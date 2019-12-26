package leecode.array;

/**
 * 支持动态扩容的数组
 */
public class DyArray {
    int length;

    int count;

    int[] objArry ;

    public DyArray(int length){
        this.length = length;
        objArry = new int[length];
    }

    /**
     * 实现从小到大排序
     * @param n
     */
    public void add(int n){
        if(count >= length){
            length = length * 2;
            int[] tempArray = new int[length];
            for(int i = 0; i < count; i++){
                tempArray[i] = objArry[i];
            }
            objArry = tempArray;
        }

        int i = count-1;
        for(; i>=0; i--){
            if(objArry[i]<=n){
                break;
            }
            objArry[i+1] = objArry[i];
        }
        objArry[++i] = n;
        count ++;
    }

    /**
     * 根据索引删除数据
     * @param index
     */
    public void deleteByIndex(int index){
        if(index < 0 || index > count){
            throw new ArrayIndexOutOfBoundsException();
        }

        for(int i=index; i<count-1; i++){
            objArry[i] = objArry[i+1];
        }
        count--;
    }

    public static void main(String[] args) {
        DyArray dyArray = new DyArray(2);
        dyArray.add(1);
        dyArray.add(2);
        dyArray.add(4);
        dyArray.add(3);

        dyArray.deleteByIndex(5);

        for(int i=0; i<dyArray.count; i++){
            System.out.println(dyArray.objArry[i]);
        }
    }
}
