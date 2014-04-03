/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo.programming.questions.LongestRepeatedSubsequenceProblem;

import java.util.*;

/**
 *
 * @author Tejashree
 */
public class SuffixTree {

    String str;

    SuffixTree() {
        this.str = str;

    }

    public Node createSuffixTree(Node root) {
        String suffix = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            suffix = String.valueOf(str.charAt(i)) + suffix;
            boolean isPresent = false;

            for (int knodes = 0; knodes < root.children.size(); knodes++) {
                if ((((Node) root.children.get(knodes)).str).equals(suffix)) {

                } else {
                    System.out.println("suffix added " + suffix);
                    root.children.add(new Node(suffix));

                }
            }
            if (root.children.size() == 0) {
                root.children.add(new Node(suffix));
            }

        }

        return root;
    }

    

}
