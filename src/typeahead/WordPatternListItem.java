/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package typeahead;

/**
 *
 * @author Tejashree
 */
public class WordPatternListItem
 {
        String word;
        double count = 0;

        public WordPatternListItem(String word) {
            this.word = word;
            count++;
        }
}
