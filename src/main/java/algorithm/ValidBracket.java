package algorithm;


import java.util.HashMap;
import java.util.Stack;

/**
 * 有效括号
 */
public class ValidBracket {


    public static void main(String[] args) {
        System.out.println(isValid("["));


    }

    /**
     * '('，')'，'{'，'}'，'['，']'
     */
    public static boolean isValid(String s){
        HashMap<Character, Character> charMap = new HashMap<>();
        charMap.put(')', '(');
        charMap.put('}', '{');
        charMap.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){

            if (charMap.containsKey(c)){

                char top =stack.empty() ?'#': stack.pop();
                if (top!=charMap.get(c)){
                    return false;
                }

            } else {
              stack.push(c);
            }

        }
        return stack.isEmpty();

    }


}
