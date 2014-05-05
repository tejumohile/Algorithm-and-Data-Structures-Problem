/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facebookhacker.beautifulstrings;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 *
 * @author Tejashree
 */
public class BeautifulStrings {
    public static void main(String args[])
    {
        
        try {
         File file = new File("beautifulStringsInput.txt");
         BufferedReader in = new BufferedReader(new FileReader(file));
         String line;
         while ((line = in.readLine()) != null) {
            getScore(line.trim().toLowerCase());
         }

         } catch (Exception e) {
         e.printStackTrace();

         }
    }

    private static void getScore(String line) {
        HashMap<String, Integer> scoreTable = new HashMap<String, Integer>();
        for(int i = 0 ; i < line.length(); i++)
        {
            if(line.charAt(i)>= 97 && line.charAt(i) <= 122)
            {
                String key = String.valueOf(line.charAt(i));
                if(scoreTable.containsKey(key))
                {
                    int count = scoreTable.get(key) + 1;
                    scoreTable.put(key, count);               
                }
                else
                {
                    scoreTable.put(key, 1);
                }
                
            }
        }
        Object[] str = scoreTable.keySet().toArray();
        int [] scores = new int[str.length];
        
        for(int i = 0 ; i < str.length; i++)
        {
            scores[i] = scoreTable.remove((String)str[i]);
        }
        
        Arrays.sort(scores);
        int finalscore = 0;
        int multiplier = 26;
        for(int i = scores.length-1 ; i >= 0; i--)
        {
            finalscore +=  multiplier * scores[i];
            multiplier--;
        }
        if(finalscore!= 0)
            System.out.println(finalscore);
    }
}
