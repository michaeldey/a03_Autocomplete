package a03_AutoComplete;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Autocomplete {

	final private Term[] terms;	//holds the array of Term
	
    // Initialize the data structure from the given array of terms.
    public Autocomplete(Term[] terms){
    	if (terms != null)
    	{
    		this.terms = terms;
    		Arrays.sort(terms); 	//sort the array
    	}
    	else
    	{
    		//Corner cases.  The constructor and each method should throw a java.lang.NullPointerException its argument is null.
    		throw new java.lang.NullPointerException("Given Term array cannot be null");
    	}
    }


    // Return all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix){
    	Term myPrefix = prefixToTerm(prefix);				//create a new Term to compare with weight is 0.0 because it won't be used
    	int min = findMin(myPrefix);
    	int max = findMax(myPrefix);
    	int arraySize = min-max+1;
    	
    	if(min<0||max<0) return new Term[0];//prefix string was not found
    	Term[] returnArray = Arrays.copyOfRange(terms, min, max); 	//return a copy of the array between min and max
    	Arrays.sort(returnArray, Term.byReverseWeightOrder());
    	return returnArray;
    }

    // Return the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix){
    	Term myTerm = prefixToTerm(prefix);
        int min = findMin(myTerm);
        int max = findMax(myTerm);
        if (min <0 || max < 0) return 0; //comparitor may return number larger than -1 so we return 0
        return max-min+1;
    }
    
    private int findMin(Term myTerm){
    	return BinarySearchDeluxe.firstIndexOf(terms, myTerm, Term.byPrefixOrder(myTerm.query.length()));
    }
    
    private int findMax(Term myTerm){
    	return BinarySearchDeluxe.lastIndexOf(terms, myTerm, Term.byPrefixOrder(myTerm.query.length()));
    }
    
    private Term prefixToTerm(String prefix){
    	return new Term(prefix, 0.0);    	
    }
}
