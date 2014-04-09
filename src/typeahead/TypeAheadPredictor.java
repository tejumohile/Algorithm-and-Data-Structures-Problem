/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package typeahead;

/**
 *
 * @author Tejashree
 * This file will be my learning class.
 * 
 * 
 * 
 */

import java.util.*;

public class TypeAheadPredictor {
    
    
    HashMap<String, ArrayList<WordPatternListItem>> patternHashMap =
                                                            new HashMap<>();
       
    public void getPatternsByNGram(List<String> words, int NGram)
    {
        for(int firstPointer=0; firstPointer < words.size()-1 ; firstPointer++)
        {
            
            ArrayList<WordPatternListItem> list = addWordsIntoPatternHashMap(words.get(firstPointer));
            for(int secondPointer=firstPointer+1; 
                    secondPointer < firstPointer+NGram && secondPointer < words.size();
                    secondPointer++)
            {  
            	addPatternsInPatternHashMap(list, words.get(secondPointer));
                
            }
        }
    }
    
        
    public ArrayList<WordPatternListItem> addWordsIntoPatternHashMap(String string) {
		// TODO Auto-generated method stub
    	if(patternHashMap.containsKey(string))
    		return patternHashMap.get(string);
    	else
    	{
    		ArrayList<WordPatternListItem> list = new ArrayList<>();
    		patternHashMap.put(string, list);
    		return list;
    	}		
	}


	public void addPatternsInPatternHashMap(ArrayList<WordPatternListItem> list, 
                                            String word)
    {
		
        boolean found = false;
        for(WordPatternListItem item : list)
        {
        	if( item.word.equals(word) )
            {
            	found = true;                
                item.count++;
                break;
            }
        }
        if(!found)
        {
            list.add(new WordPatternListItem(word));
        }
    }
    
    public ArrayList<WordPatternListItem> getPatternList(String word)
    {    	
    	return patternHashMap.get(word);
    } 
    
    public ArrayList<WordPatternListItem> sortList(ArrayList<WordPatternListItem> list)
    {
    	Comparator<WordPatternListItem> comp = new WordPatternCountComparator();
    	PriorityQueue<WordPatternListItem> pq = new PriorityQueue<>(list.size(), comp);      	
    	for(WordPatternListItem item : list)
    	{
    		pq.add(item);
    	}
    	int size = list.size();
    	list = new ArrayList<>();
    	for(int i =0 ; i < size ; i++)
    	{
    		list.add(pq.poll());
    	}
    	return list;
    	
    }
        
    private class WordPatternCountComparator implements Comparator<WordPatternListItem>
    {

		@Override
		public int compare(WordPatternListItem o1, WordPatternListItem o2) {
			// Ordering in descending order.
			if(o1.count<o2.count)
				return 1;
			else if(o1.count == o2.count)
			{
				//arrange it from length of the word
				if(o1.word.length() < o2.word.length())
					return 1;
				else
					return -1;
			}
			else 
				return -1;
			
			
		}
    	
    }
    
    public ArrayList<WordPatternListItem> getProbabilities(ArrayList<WordPatternListItem> sortedList)
    {
    	int count = 0;
    	for(WordPatternListItem item: sortedList)
    	{
    		count += item.count;    		
    	}
    	for(WordPatternListItem item: sortedList)
    	{
    		item.count = (Math.round((item.count / (double)count) * 1000 ) ) / 1000.00;
    	}
    	return sortedList;
    }

    
}
