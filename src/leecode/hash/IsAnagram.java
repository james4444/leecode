package leecode.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsAnagram {


    /**
     * 用优先队列进行排序，时间复杂度为N*logN
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
        boolean flag = true;
        PriorityQueue<Character> squeue = new PriorityQueue<>();
        PriorityQueue<Character> tqueue = new PriorityQueue<>();
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();

        for(int i=0; i<schars.length; i++){
            squeue.offer(schars[i]);
            tqueue.offer(tchars[i]);
        }

        while (!squeue.isEmpty()){
            char sChar =  squeue.poll();
            char tChar = tqueue.poll();
            if(sChar != tChar){
                return false;
            }
        }
        return flag;
    }

    /**
     * 利用数组的排序来做
     * @param args
     */


    public static void main(String[] args) {
        String s = "arc";
        String t = "cars";

        System.out.println(isAnagram3(s,t));
    }

    private static boolean isAnagram3(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        char[] scharArr = s.toCharArray();
        char[] tcharArr = t.toCharArray();

        for(int i=0 ; i<scharArr.length;i++){
            if(!map.containsKey(scharArr[i])){
                map.put(scharArr[i],1);
            }else{
                map.put(scharArr[i],map.get(scharArr[i])+1);
            }

            if(!map.containsKey(tcharArr[i])){
                map.put(tcharArr[i],-1);
            }else{
                map.put(tcharArr[i],map.get(tcharArr[i])-1);
            }

        }

        Set<Character> set = map.keySet();

        for(char schar : set){
            int count = map.get(schar);
            if(count != 0) {
                return  false;
            }
        }

        return  true;
    }


    /**
     * 利用数组排序
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagram2(String s, String t) {
        char[] scharArr = s.toCharArray();
        char[] tcharArr = t.toCharArray();
        Arrays.sort(scharArr);
        Arrays.sort(tcharArr);

        return  scharArr.equals(tcharArr);
    }
}
