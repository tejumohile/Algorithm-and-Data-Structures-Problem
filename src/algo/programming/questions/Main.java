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
import java.io.*;

public class Main {

    public static void main(String[] args) {
          try {
         File file = new File(args[0]);
         BufferedReader in = new BufferedReader(new FileReader(file));
         String line;
         while ((line = in.readLine()) != null) {
         changeCase(line.trim());
         }

         } catch (Exception e) {
         e.printStackTrace();

         }
         
        
    }

    public static void changeCase(String line) {
        char arr[] = line.toCharArray();
        for(int i = 0 ; i < line.length(); i++){
            char ch = line.charAt(i);
            if(ch >= 65 && ch <=90)
            {
                ch = (char)(97 + (int)ch - 65);
                arr[i] = ch;
            }
            else if(ch >= 97 && ch <=122)
            {
                ch = (char)(65 + (int)ch - 97);
                arr[i] = ch;
            }
        }
        for(int i = 0 ; i < arr.length; i++){
            System.out.print(arr[i]);
        
        }
    }
    
    
}
