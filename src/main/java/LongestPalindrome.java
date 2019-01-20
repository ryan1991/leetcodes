import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jdk.nashorn.internal.objects.NativeString.substring;

/**
 * @Author ryan.song
 * @Date 2019/1/20
 **/
public class LongestPalindrome {
    public static void main(String[] args) {

//        longestPalindrome("ababac");



        String s = "dafhdashfdjaskhfdajkhfdajkhfdasjkfhakjfhakfajfhdajkhffafakjhf";
//        System.out.println(s.substring(1, 3));
        System.out.println(activeSplit(s));

        String max = longestPalindrome(s);
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


}
