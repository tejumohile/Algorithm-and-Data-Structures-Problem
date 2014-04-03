/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algo.programming.questions;

/**
 * Question : abbbbbbbbcc
 * Answer : bbbbbbbb
 * 
 * Question : aabbccdd
 * Answer : aa
 * @author Tejashree
 */
public class LongestConsecutiveRepetitionOfCharacter {
    public static void getLongestChar(String message){
        char maxChar = message.charAt(0);
        int maxCount = 0;
        int count = 0;
        char currentChar = message.charAt(0);
        for(int i = 0 ; i < message.length(); i++ ){
            System.out.println("message.charAt(i) " + message.charAt(i));
            if(currentChar == message.charAt(i)){
                System.out.println(count);
                count = count + 1;
            }
            else {
                if(maxCount < count){
                    
                    maxCount = count;
                    maxChar = currentChar;
                    System.out.println("Now maxCount is " + maxCount + " maxChar" + maxChar);
                }
                
                currentChar = message.charAt(i);
                count = 0;
            
            }
            
        
        }
    
        for(int j = 0 ; j < maxCount ; j++){
            System.out.print(maxChar);
        }
    }
    
    
    public static void main(String r[]){
        getLongestChar("abbbbbbbbcccccccccccc");
    }
}
