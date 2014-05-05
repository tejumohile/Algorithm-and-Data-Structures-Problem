package facebookhacker.studiousstudent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tejashree
 * Description
 * You’ve been given a list of words to study and memorize. 
 * Being a diligent student of language and the arts, you’ve 
 * decided to not study them at all and instead make up pointless 
 * games based on them. One game you’ve come up with is to see how 
 * you can concatenate the words to generate the lexicographically 
 * lowest possible string.
 * 
 * Input
 * As input for playing this game you will receive a text file containing
 * an integer N, the number of word sets you need to play your game against.
 * This will be followed by N word sets, each starting with an integer M,
 * the number of words in the set, followed by M words. All tokens in the 
 * input will be separated by some whitespace and, aside from N and M, 
 * will consist entirely of lowercase letters.
 * 
 * Output
 * Your submission should contain the lexicographically shortest 
 * strings for each corresponding word set, one per line and in order.
 * 
 * Constraints
 * 1 <= N <= 100
 * 1 <= M <= 9
 * 1 <= all word lengths <= 10
 * 
 */
import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[])
    {
        
        try {
         File file = new File("studiousStudentInput.txt");
         BufferedReader in = new BufferedReader(new FileReader(file));
         StudiousStudent student = new StudiousStudent();
         int lines = Integer.parseInt(in.readLine().trim());
         for(int i = 0 ; i<lines ; i++) {
             student.getLexicoShortestString(in.readLine().trim());
         }

         } catch (Exception e) {
         e.printStackTrace();

         }
    }
    
}
