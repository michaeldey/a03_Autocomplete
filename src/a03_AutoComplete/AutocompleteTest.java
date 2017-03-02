package a03_AutoComplete;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AutocompleteTest {
	 Term m0 = new Term("ab", 1.0);
     Term m1 = new Term("ba", 1.0);
     Term m2 = new Term("bb", 1.0);
     Term m3 = new Term("bb", 1.0);
     Term m4 = new Term("bc", 4.0);
     Term m5 = new Term("bd", 3.0);
     Term m6 = new Term("be", 1.0);
     Term m7 = new Term("be", 1.0);
     Term m8 = new Term("be", 1.0);
     Term m9 = new Term("ca", 1.0);
     
     Term[] tArray = new Term[]{m9,m8,m7,m6,m5,m4,m3,m2,m1,m0}; //load them in reverse order

     
	@Rule public ExpectedException thrown = ExpectedException.none();
	
	//test Null Term Array sent to Autocomplete
	@Test
	public void testNullAutocomplete() {
		thrown.expect(NullPointerException.class);
    	thrown.expectMessage("Given Term array cannot be null");
		new Autocomplete(null);		
	}

	
	@Test
	public void testAllMatches() {
		Term[] newTerm = new Autocomplete(tArray).allMatches("b");
		assertTrue(newTerm[0]==m4);				//test sorted array[0] == m4
		assertTrue(newTerm[1]==m5);				//test sorted array[1] == m5
		assertFalse(newTerm[0]!=m4);			//test sorted array[0] == m4 is not giving true for everything 
		assertFalse(newTerm[1]!=m5);			//test sorted array[1] == m5 is not giving true for everything 
		
	}

	@Test
	public void testNumberOfMatches() {
		assertTrue(new Autocomplete(tArray).numberOfMatches("b")==8);
		assertFalse(new Autocomplete(tArray).numberOfMatches("b")!=8);
	}

}
