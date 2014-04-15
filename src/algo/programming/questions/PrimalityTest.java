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
import java.util.*;
public class PrimalityTest {
    
    public static boolean primalityTest(int n)
    {
        if ( n < 2 )
        {
            return false;
        }
        if ( n == 2 || n == 3)
        {
            return true;
        }
        int maxDivisor = (int)Math.sqrt(n);
        int divisor = 2;
        while(divisor <= maxDivisor)
        {
            if( n % divisor == 0)
                return false;
            divisor ++;
        }
        
        return true;
    }
    
    
    public static void main(String a[])
    {
        for(int i = 0; i <=100; i++)
        {
            if(primalityTest(i))
                System.out.println(i);
        }
    }
}
