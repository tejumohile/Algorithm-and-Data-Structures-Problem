/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookhacker.studiousstudent;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Tejashree
 */
public class StudiousStudent {

    void getLexicoShortestString(String inputline) {
        String[] input = processInput(inputline);
        LexicalComparator lc = new LexicalComparator();
        PriorityQueue<String> treeMap = new PriorityQueue<String>(
                Integer.parseInt(input[0]), lc);
        for (int i = 1; i < Integer.parseInt(input[0]) + 1; i++) {
            treeMap.add(input[i]);
        }
        for (int i = 0; i < Integer.parseInt(input[0]); i++) {
            System.out.print(treeMap.poll());
        }
        System.out.println();
    }

    String[] processInput(String input) {
        return input.split(" ");
    }

    private class LexicalComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            int pointerLength = 0;
            int pointer = 0;
            if (o1.length() > o2.length()) {
                pointerLength = o2.length();
            } else {
                pointerLength = o1.length();
            }
            for (pointer = 0; pointer < pointerLength; pointer++) {
                if (o1.charAt(pointer) > o2.charAt(pointer)) {
                    return 1;
                } else if (o1.charAt(pointer) < o2.charAt(pointer)) {
                    return -1;
                }
            }
            if (pointer == pointerLength) {
                if (o1.length() < o2.length()) {
                    return 1;
                } else if(o1.length() > o2.length()){
                    return -1;
                }
                else {
                    return 0;
                }
                    
            }
            return 0;
        }
    }

}
