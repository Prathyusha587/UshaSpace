import java.util.*;
public class ReverseRecursion {
    static public void main(String []A) {
   
     String sr = "bunny";
     System.out.print(recur_String(sr));

    }

    //recursive function to reverse a string
    static String recur_String(String input) {
      int len = input.length();
      char[] str = input.toCharArray();
      if(len == 1) return input;
      else {
       swap(str, 0, len-1);
        return new String(str);     
    }
      
    }   
    
    static void swap(char[] s, int left, int right){ 
      if (left >= right) return;
      char tmp = s[left];
      s[left++] = s[right];
      s[right--] = tmp;
      swap(s, left, right);
}
    }

