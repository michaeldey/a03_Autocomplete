package a03_AutoComplete;

import java.util.Comparator;

public class Autocomplete {

	private Term[] terms;	//holds the array of Term
	
    // Initialize the data structure from the given array of terms.
    public Autocomplete(Term[] terms){
    	if (terms != null)
    	{
    		this.terms = terms;
    	}
    	else
    	{
    		//Corner cases.  The constructor and each method should throw a java.lang.NullPointerException its argument is null.
    		throw new java.lang.NullPointerException("Given Term array cannot be null");
    	}
    }


    // Return all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix){
    	Term myPrefix = new Term(prefix, 0.0);				//create a new Term to compare with weight is 0.0 because it won't be used
    	Comparator d = Term.byPrefixOrder(prefix.length());  //create a byPrefixOrder Comparator that uses prefix.length
    	Term[] tempTerm = new Term[terms.length];			//create an array to hold all of the qualifying terms temporarily
    	
    	int pointer = 0;								//pointer and counter for tempArray
    	for (Term m : terms){
    		if (d.compare(m, myPrefix) == 0)
    		{
    			tempTerm[pointer++]=m; 					//add object to tempTerm and increment pointer
    		}
    	}
        Term[] returnTerm = new Term[pointer];	//create a new array with size of pointer and fill it
        for (int i = 0; i < pointer; i++){
        	returnTerm[i] = tempTerm[i];
        }
    	
        return returnTerm;
    }

    // Return the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix){
        return -1;
    }
}
