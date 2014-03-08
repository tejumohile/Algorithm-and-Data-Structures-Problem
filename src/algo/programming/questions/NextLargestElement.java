/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo.programming.questions;

/**
 *
 * @author Tejashree
 * Given an Array, replace each element with its Next Largest Element. 
   Ex: 
   i/p: {2,12,8,6,5,1,2,10,3,2} 
   o/p:{12,12,10,10,10,2,10,10,3,2}
 */
public class NextLargestElement {

    public static int[] getNextLargestElement(int A[]) {
        int nextMax = A[0];
        int nextMaxPos = 0;
        for (int i = 0; i < A.length; i++) {
            if (nextMaxPos < i) {
                nextMax = A[i];
                nextMaxPos = i;
            }
            for (int j = i + 1; j < A.length; j++) {
                if (i + 1 < A.length - 1) {
                    if (A[i] < A[j]) {
                        nextMax = A[j];
                        nextMaxPos = j;
                        break;
                    }
                }
            }
            A[i] = nextMax;
        }
        return A;
    }

    
    public static void main(String ar[]) {

        int a[] = {2,12,8,6,5,1,2,10,3,2};
        getNextLargestElement(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }
    }
}
