package distinctsubstring;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import org.junit.Assert;


public class DistinctSubstring {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string : ");
        String input = sc.nextLine();
        int n;
        if((n=findMaxLength(input))==-1)
            System.out.println("Invalid Input");
        else 
            System.out.println(n);
    }
    public static int findMaxLength(String input)
    {
       if(input.contains(" "))
           return -1;
       int i,j=0;
       int maxlen=0;
       int len =0;
       Set<Character> s = new HashSet<Character>();
       for(i=0;i<input.length();)
       {
            if(s.isEmpty()|| !(s.contains(input.charAt(i))))
                {
                     s.add(input.charAt(i));
                     i++;
                     len = i-j;
                }
            else
                {
                  s.remove(input.charAt(j));
                  j++;
                }
            if(len>maxlen)
                maxlen = len;
       }
       return maxlen;
    }
    @Test
    public static void testCode()
    {
        Assert.assertequals(0,findMaxLength(""));
        Assert.assertequals(3,findMaxLength("abc"));
        Assert.assertequals(3,findMaxLength("abcabacbb"));
        Assert.assertequals(2,findMaxLength("Bbbbb"));
        Assert.assertequals(3,findMaxLength("#*#@"));
        Assert.assertequals(3,findMaxLength("pwwkew"));
    }
}
