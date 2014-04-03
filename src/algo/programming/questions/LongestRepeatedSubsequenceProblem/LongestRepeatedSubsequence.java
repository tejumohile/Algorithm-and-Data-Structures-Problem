/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo.programming.questions.LongestRepeatedSubsequenceProblem;

/**
 *
 * @author Tejashree
 */
public class LongestRepeatedSubsequence {

    public static void main(String str1[]) {
        String str = new java.util.Scanner(System.in).nextLine();
        int countFinal = 0;
        String outputString = "";
        for (int i = 0; i < str.length(); i++) {
            for (int k = i+1; k <= (str.length() / 2) && (i + k < str.length()) ; k++) {
                System.out.println("i = " + i + " k = " + k );
                String sample = str.substring(i, k+1);
                System.out.println("sample = " + sample);
                String targetString  = str.substring(k+1, str.length());
                System.out.println("targetString " + targetString);
                int count = countRepetition(sample, targetString );
                System.out.println("count = " + count);
                if (count == 0) {
                    break;
                } else if (outputString.length() < sample.length()
                        || (outputString.length() == sample.length()
                        && count > countFinal)) {
                    outputString = sample;
                    countFinal = count;
                }
            }
        }
        if(outputString == "")
            outputString = "NONE";
        System.out.println("Count: " + countFinal + " Repeating String is :" + outputString);

    }
    
    
    public static int countRepetition(String sampleString, String targetString) {
        if (sampleString.length() == 0 || targetString.length() == 0) {
            return 0;
        }
        int count = 0;
        if (sampleString.length() <= targetString.length()) {
            for (int i = 0; i < targetString.length(); i++) {
                if (sampleString.charAt(0) == targetString.charAt(i)) {
                    int targetPointer = i, samplePointer = 0;
                    System.out.println("targetPointer in the start = " + targetPointer);
                    
                    while (samplePointer < sampleString.length() 
                            && sampleString.charAt(samplePointer) == targetString.charAt(targetPointer)) {
                        targetPointer++;
                        samplePointer++;
                    }
                    System.out.println("samplePointer = " + samplePointer);
                    System.out.println("sampleString.length() " + sampleString.length());
                    if (samplePointer == sampleString.length()) {
                        count++;
                        i = i + samplePointer;
                        System.out.println("targetString.length()-targetPointer = " + (targetString.length()-targetPointer));
                        if((targetString.length()-targetPointer)< sampleString.length() )
                            break;
                    }
                }
            }
        }
        return count;
    }

}
