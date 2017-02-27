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
    	int[] tempArray = new int[terms.length];			//create an array to hold all of the addresses of qualifying terms
    	
    	int tempArrayPointer = 0;								//pointer and counter for tempArray
    	int mIndex = 0;
    	for (Term m : terms){
    		if (d.compare(m, myPrefix) == 0) //if m == myPrefix
    		{
    			tempArray[tempArrayPointer++]=mIndex; 	//add the address of the qualifying Term into tempArray & increment count
    		}
    		mIndex++;
    	}
        Term[] returnTerm = new Term[tempArrayPointer];	//create a new array with size of tempArrayPointer
        
        //fill returnTerm with qualifying terms
        for (int i = 0; i < tempArrayPointer; i++){
        	returnTerm[i] = terms[tempArray[i]]; 		//add to returnTerm[i] the value of terms at address tempArray[i]
        }
    	
        return returnTerm;
    }

    // Return the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix){
        return -1;
    }
}
