/**
 * @Author ryan.song
 * @Date 2019/2/25
 **/
public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] strs = {"flower","flaw","flow"};

        System.out.println(longestCommonPrefix(strs));



    }





    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++){
            int j = 0;
            for (; j<strs[i].length()&&j<ans.length();j++ ){
                if (strs[i].charAt(j) != ans.charAt(j)){
                    break;
                }
            }
            ans = ans.substring(0, j);
            if (ans.equals("")){
                return "";
            }

        }
        return ans;

    }
}
