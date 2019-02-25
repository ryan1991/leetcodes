import java.util.HashMap;
import java.util.Map;

/**
 * @Author ryan.song
 * @Date 2019/2/25
 **/
public class RomanToInt {

    public static void main(String[] args) {
        String roman = "CMLII";
        System.out.println(roman.indexOf("A"));
        System.out.println(romanToIntBetter(roman));

    }


    public static int romanToInt(String roman){

//        int values[]= {1000, 900, 500,  400,  100,  90, 50,  40, 10,  9,   5,  4,   1};
//        String reps[]={"M", "CM", "D",  "CD", "C", "XC","L","XL","X","IX","V","IV","I"};

        Map<Character, Integer> dict = buildDict();
        Map<String, Integer> specialDict = buildSpecialDict();
        int sum = 0;
        for (String s : specialDict.keySet()){
            if (roman.indexOf(s) != -1){
                sum += specialDict.get(s);
                roman = roman.replaceAll(s, "");
            }
        }

        for (int i= 0 ; i < roman.toCharArray().length; i ++) {
            Character c = roman.charAt(i);
            if (dict.containsKey(c)) {
                sum += dict.get(c);
            }
        }
        return sum;
    }

    private static Map<Character, Integer> buildDict(){
        Map<Character, Integer> dict = new HashMap<>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);
        return dict;
    }

    private static Map<String, Integer> buildSpecialDict(){
        Map<String, Integer> dict = new HashMap<>();
        dict.put("IV", 4);
        dict.put("IX", 9);
        dict.put("XL", 40);
        dict.put("XC", 90);
        dict.put("CD", 400);
        dict.put("CM", 900);
        return dict;
    }


    /**
     * 加上再减去
     * @param s
     * @return
     */
    public static int romanToIntBetter(String s) {

        int n = s.length();
        int romanInt = 0;
        for(int i=0;i<n;i++) {
            switch(s.charAt(i)) {
                case 'I' : romanInt = romanInt + 1;break;
                case 'V' : romanInt = romanInt + 5;break;
                case 'X' : romanInt = romanInt + 10;break;
                case 'L' : romanInt = romanInt + 50;break;
                case 'C' : romanInt = romanInt + 100;break;
                case 'D' : romanInt = romanInt + 500;break;
                case 'M' : romanInt = romanInt + 1000;break;
                default: System.out.println("default");break;
            }

            if(i!=0) {
                if(((s.charAt(i)=='V')||(s.charAt(i)=='X'))&&(s.charAt(i-1)=='I'))
                    romanInt = romanInt-1*2;
                if(((s.charAt(i)=='L')||(s.charAt(i)=='C'))&&(s.charAt(i-1)=='X'))
                    romanInt = romanInt-10*2;
                if(((s.charAt(i)=='D')||(s.charAt(i)=='M'))&&(s.charAt(i-1)=='C'))
                    romanInt = romanInt-100*2;
            }
        }
        return romanInt;


    }
}
