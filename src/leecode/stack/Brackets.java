package leecode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Brackets {


    public static void main(String[] args) {
        String s = "{{}";
        System.out.println(isValid(s));
    }

    /**
     * 空字符串，返回true
     * 将括号对应放入map
     * 循环遍历，如果为左括号，则放入栈中，又括号，则与栈中的最后一个值匹配
     * 不能匹配，返回false
     * 循环完成后，如果栈未清空，结果为false
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if(s.isEmpty()){
            return true;
        }
        Stack<String> stack = new Stack<>();
        Map<String,String> map = new HashMap<>();
        map.put("(",")");
        map.put("{","}");
        map.put("[","]");
        for(String temp : s.split("")){
            if(map.containsKey(temp)){//左边括号
                stack.push(temp);
            }else{
                if(stack.empty() || !map.get(stack.pop()).equals(temp)){
                    return false;
                }
            }
        }
        if(!stack.empty()){
            return false;
        }
        return true;
    }
}
