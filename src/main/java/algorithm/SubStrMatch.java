package algorithm;

/**
 * 28. 找出字符串中第一个匹配项的下标
 *
 *  扩展用KMP算法实现 TODO
 * @author songjunbao
 * @date 2023-11-26
 */
public class SubStrMatch {

    public static void main(String[] args) {
       String  haystack = "sadbutsad", needle = "sad";
//        String  haystack = "a", needle = "a";

        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        int wid = needle.length();
        int len = haystack.length();
        if(len < wid)
            return - 1;


        for(int i = 0; i<= len - wid; i ++){
            String sub = haystack.substring(i, i + wid);
            System.out.println("sub:" + sub);
            if (sub.equals(needle))
                return i;
        }

        return -1;
    }

}
