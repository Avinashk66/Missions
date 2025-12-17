import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        boolean pa=true;
        int left=0,right=str.length()-1;
        while(left<right)
        {
            if(str.charAt(left)!=str.charAt(right))
            {
                pa=false;
            }
            left++;
            right--;
        }
        if(pa)
        {
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
