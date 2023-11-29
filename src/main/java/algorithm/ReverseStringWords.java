package algorithm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * 151. 反转字符串中的单词
 *
 * @author songjunbao
 * @date 2023-11-26
 */
public class ReverseStringWords {

    public static void main(String[] args) {
        String s = "the sky   is blue";
        System.out.println(reverseWords(s));
        System.out.println(reverseWords2(s));
        System.out.println(reverseWords3(s));
    }



    public static String reverseWords(String s) {
        int left = 0, right = s.length() -1;
        //去掉首部空格
        while (left <= right && s.charAt(left) == ' '){
            left ++;
        }

        //去掉尾部空格
        while (left <= right && s.charAt(right) == ' '){
            right--;
        }

        Deque<String> deque = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        while (left <= right){
            char c = s.charAt(left);
            if ((word.length() != 0) && c == ' '){
                deque.addFirst(word.toString());
                word.setLength(0);
            }else if(c != ' '){
                word.append(c);
            }
            left ++;
        }

        //最后一个字符串
        deque.addFirst(word.toString());
        return String.join(" ", deque);
    }


    public static String reverseWords2(String s) {
        // 字符串按空格分割区别：s.split("\\s+")和 s.split(" ")
        // 当s中出现连续空格时，后者分割后会出现空串
        String[] strs = s.trim().split("\\s+");
        System.out.println("strs:" + Arrays.toString(strs));
        StringBuilder res = new StringBuilder();
        for (int i = strs.length -1 ; i >= 0; i--) {
            if (strs[i].equals(""))
                continue;

            res.append(strs[i]).append(" ");
        }
        
        return  res.toString().trim();
    }

    public static String reverseWords3(String s) {
        String[] strs = s.trim().split("\\s+");
        List<String> wordList = Arrays.asList(strs);
        Collections.reverse(wordList);
        return  String.join(" ", wordList);
    }
}
