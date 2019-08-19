package algorithm;


import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubstring {

    public static void main(String[] args) {
        String s = "abcba";
        System.out.println(lengthOfLongestSubstring(s));


    }


    public static long lengthOfLongestSubstring(String s) {

        int n =s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j= 0;
        while(i< n && j<n){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j-i);
            }else {
                set.remove(s.charAt(i++));
            }


        }

        return ans;

    }




}
