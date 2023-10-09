package str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  分割字符串 ，只允许用char[] 处理实现
 *
 * @author songjunbao
 * @date 2023-08-22
 */
public class SplitStr {
    public static void main(String[] args) {
        String src = "abcefefcsefscedef";
        String sub = "ef";
        split(src, sub);
        String[] efs = src.split(sub);
        System.out.println("官方实现：" + Arrays.toString(efs));

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader parent = systemClassLoader.getParent();


    }


    public static List<String> split(String src, String sub){
        char[] srcChars = src.toCharArray();
        char[] subChars = sub.toCharArray();
        int wid = subChars.length;
        if (src.length() < wid)
            throw new IllegalArgumentException("非法参数");

        //先找匹配的索引
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i<= srcChars.length -wid; i++){
            boolean eq = true;
            for (int j = 0; j < wid; j++){
                char srcChar = srcChars[i+j];
                char subChar = subChars[j];
                if (srcChar != subChar){
                    eq = false;
                    break;
                }
            }

            if (eq){
                index.add(i);
            }
        }
        System.out.println("匹配索引：" + index);
        List<String> result = splitByIndex(srcChars, index, wid);
        System.out.println("自己实现：" + result);
        return result;
    }


    public static List<String> splitByIndex(char[] srcChars, List<Integer> idx, int wid){
        int start = 0;
        List<String> result = new ArrayList<>();
        for (int i = 0; i <idx.size() ; i++) {
            int matchIdx = idx.get(i);
            String substr = new String(Arrays.copyOfRange(srcChars, start, matchIdx));
            result.add(substr);
            start =  matchIdx + wid;

            //防止末尾匹配
            if (i == idx.size() -1 && matchIdx != srcChars.length - wid){
                String last = new String(Arrays.copyOfRange(srcChars, matchIdx + wid, srcChars.length));
                result.add(last);
            }
        }
        return result;
    }



}
