/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algo.programming.questions;

/**
 *
 * @author Tejashree
 */
public class StringMatcher {
    
    //The method will return the string of length n in s1 that
    //matches the string in s2.
    public static String hasMatchedString(String s1, String s2, int n){
        int j = 0; int y;
        for(int i =0 ; i < s1.length()-n; i++)
        {
               String sampleString = getString(s1,i,i+n);               
               int count = 0;
               int k = 0;
               y = j;
               while( count < n )
               {
                   if(sampleString.charAt(k) == s2.charAt(y))
                   {                       
                       count++;
                       k++;
                       y++;
                   }
                   else if (sampleString.charAt(0) == s2.charAt(y))
                   {
                       //The current number matches the first number
                       //in the sample string.
                       count = 1;
                       k = 1;
                       y++;
                   }
                   else 
                   {
                       count = 0;
                       k = 0;
                       y++;
                   }
                   
                   if( y >= s2.length()) 
                   {                       
                       y = 0;
                       break;
                   }
               }
               
               if ( count == n)
               {   
                   return sampleString;
               }
               else
               {
                   j++;
               }
        }
        
        return null;
    
    }

    private static String getString(String s1, int i, int i0) {
        String str = "";
        for(int m = i ; m<i0;m++){
            str = str + s1.charAt(m);
        }
        return str;
    }
    
    
    public static void main(String sa[]){
        String one = "mabcdefmpfgghjughsdfdf";
        String two = "acdeababfcdbcdefgyygjsdugsgd";
        System.out.println(hasMatchedString(one, two, 4));
    }
}
