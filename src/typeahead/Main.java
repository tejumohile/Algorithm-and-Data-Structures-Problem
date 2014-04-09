/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeahead;

/**
 *
 * @author Tejashree
 *
 * Question: Your task is to build a type-ahead feature for an upcoming product.
 * When the user enters a word or set of words, we want to be able to "predict"
 * what they're going to type next with some level of accuracy. We've chosen to
 * implement this using the N-Gram algorithm defined here. Your program should
 * return a tuple of predictions sorted high to low based on the prediction
 * score (upto a maximum of three decimal places, or pad with zeroes upto three
 * decimal places i.e. 0.2 should be shown as 0.200), (if predictions share the
 * same score, they are sorted alphabetically.) Words should be split by
 * whitespace with all non-alphanumeric characters stripped off the beginning
 * and end. Prediction scores are calculated like this: Occurrences of a word
 * after an N-gram / total number of words after an N-gram e.g. for an N-gram of
 * length 2: ONE TWO ONE TWO THREE TWO THRE "TWO" has the following predictions:
 * THREE:0.666,ONE:0.333 "THREE" occurred 2 times after a "TWO" and "ONE"
 * occurred 1 time after a "TWO", for a total of 3 occurrences after a "TWO".
 *
 * Your program will run against the following text, ignoring all punctuation
 * this is my learning file on which my prediction probabilities will be
 * generated.
 *
 *
 * Approach : 1. Read the learning file once. 2. Based on the N-gram length I
 * will have two pointers. 3. The first pointer will always point to the word
 * for which I am calculating the next word probabilities. 4. The second pointer
 * will start from the word next to the first pointer and will traverse up to
 * N-gram length - 1 places. 5. As I traverse through the text I will be storing
 * the patterns in a HashMap. 6. At the end I will take all the entries related
 * to a word x in the HashMap and calculate the probabilities and sort them to
 * get the highest predicted word that user will enter after the word x.
 */
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        List<String> words = new ArrayList<String>();
        try {
            // This is the learning file
            File file = new File("typeaheadLearner.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;

            while ((line = in.readLine()) != null) {
                words = createListFromFile(line.toLowerCase(), words);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        TypeAheadPredictor typeaheadP = new TypeAheadPredictor();
        typeaheadP.getPatternsByNGram(words, 2);
        
        ArrayList<WordPatternListItem> list = typeaheadP.getPatternList("the");
        list = typeaheadP.getProbabilities(typeaheadP.sortList(list));
        int iterator = 0;
        for(WordPatternListItem item : list)
        {
        	String output = item.word+","+item.count;
        	if(String.valueOf(item.count).length()<5)
        		output += "0";
        	System.out.print(output);
        	if(iterator < list.size()-1)
        		System.out.print(";");
        	iterator++;
        }

    }

  
    public static List<String> createListFromFile(String line, List<String> words) {
        //remove all non-alpha numeric characters from the line.
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch != 32 && !(ch >= 65 && ch <= 90) && !(ch >= 97 && ch <= 122)) {
                line = line.replace(String.valueOf(ch), "");

            }
        }        
        String word[] = line.split(" ");
        for (int i = 0; i < word.length; i++) {
            words.add(word[i]);
        }
        return words;
    }
}
