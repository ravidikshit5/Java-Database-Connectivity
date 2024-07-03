import java.util.Arrays;
import java.util.Locale;

public class Anagram {
    public static void main(String args[]){
        String str1 = "ivar";
        String str2 = "Ravi";
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        if(str1.length()==str2.length()){
            char[] charArray1 = str1.toCharArray();
            char[] charArray2 = str2.toCharArray();
            Arrays.sort(charArray1);
            System.out.println(charArray1);
            Arrays.sort(charArray2);
            System.out.println(charArray2);
            boolean result = Arrays.equals(charArray1,charArray2);
            if(result){
                System.out.println(str1+" "+str2+" Both are anagram");
            }else{
                System.out.println("These are not anagram");
            }
        }
    }
}
