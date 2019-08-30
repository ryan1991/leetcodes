package algorithm;


/**
 * leetcodes  387  哈希表
 */
public class FirstUniqueChar {


    public static void main(String[] args) {

        System.out.println(  firstUniqChar("leetcode") );



    }


    /**
     *  字符串中的第一个唯一字符
     * @param s 只包含小写字母
     * @return
     */
    public static int firstUniqChar(String s) {
        int[] freq = new int[26];

        for (int i= 0 ; i < s.length(); i++){
//            char c = s.charAt(i);
//            int index = c - 'a';
//            freq[index] = freq[index] + 1;

            freq[s.charAt(i) - 'a'] ++;
        }


        for (int i= 0 ; i < s.length(); i++){

            if (freq[s.charAt(i) - 'a'] == 1)
                return i;

        }

        return  -1;


    }

}
