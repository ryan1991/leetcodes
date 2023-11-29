package algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * @author songjunbao
 * @date 2023-11-28
 */
public class MinWindow {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));

    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> oriMap = getOriMap(t);
        Map<Character, Integer> cntMap = new HashMap<>();

        int l = 0, r = -1;
        int winLen = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen-1){
            r++;
            Character curR = s.charAt(r);
            if (r< sLen && oriMap.containsKey(curR)){
                cntMap.put(curR, cntMap.getOrDefault(curR, 0) + 1);
            }
            while (check(oriMap, cntMap) && l <= r){
                int curWinLen = r - l + 1;
                if (curWinLen < winLen){
                    winLen = curWinLen;
                    ansL = l;
                    ansR = l + winLen;
                }
                if (oriMap.containsKey(s.charAt(l))){
                    cntMap.put(s.charAt(l), cntMap.getOrDefault(s.charAt(l), 0) -1);
                }

                l++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    private static Map<Character, Integer> getOriMap(String t){
        Map<Character, Integer> oriMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            oriMap.put(c, oriMap.getOrDefault(c, 0) + 1);
        }
        return oriMap;
    }


    private static boolean check(Map<Character, Integer> oriMap, Map<Character, Integer> cntMap){
        Iterator<Map.Entry<Character, Integer>> iterator = oriMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Character, Integer> next = iterator.next();
            Character key = next.getKey();
            Integer value = next.getValue();
            if (cntMap.getOrDefault(key, 0) < value){
                return false;
            }
        }
        return true;
    }


}
