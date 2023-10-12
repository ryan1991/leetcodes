import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jdk.nashorn.internal.objects.NativeString.substring;

/**
 * 最长回文字符串
 * @Author ryan.song
 * @Date 2019/1/20
 **/
public class LongestPalindrome {
    public static void main(String[] args) {

//        longestPalindrome("ababac");



        String s = "dafhdashfdjaskhfdajkhfdajkhfdasjkfhakjfhakfajfhdajkhffafakjhf";
//        System.out.println(s.substring(1, 3));
        System.out.println(activeSplit(s));

        String max = longestPalindrome2(s);
        System.out.println(max);

    }

    public static String longestPalindrome(String s) {
        if (s.length() > 1000){
            throw new IllegalArgumentException("s 长度为1000以内");
        }

        List<String> splits = activeSplit(s);
        String  maxLen = "";

        for (String split: splits) {
            StringBuilder sb = new StringBuilder(split);
            if (split.equals(sb.reverse().toString())){
                if (split.length() > maxLen.length()){
                    maxLen = split;
                }
            }

        }

        return maxLen;
    }


    public static List<String> activeSplit(String s){
        List<String> allSplits = new ArrayList<>();
        for (int i = 0; i <=s.length() ; i++) {
            for (int j = i+1; j <= s.length() ; j++) {
               String temp =  s.substring(i, j);
                allSplits.add(temp);

            }
        }
        return allSplits;
    }


    /**
     * 中心扩散法
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if (s.length() > 1000){
            throw new IllegalArgumentException("s 长度为1000以内");
        }

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            //奇数
            String s1 = expand(i, i, s);
            //偶数
            String s2 = expand(i, i+ 1, s);
            res = max(res, s1 , s2);
        }

        return res;
    }


    private static String expand(int left, int right, String s) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }

        return s.substring(left + 1, right);
    }


    private static String max(String res, String s1, String s2) {
        String max =res;
        if (max.length() < s1.length()){
            max = s1;
        }

        if (max.length() < s2.length()){
            max = s2;
        }
        return max;
    }



}
