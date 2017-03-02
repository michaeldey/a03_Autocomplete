package a03_AutoComplete;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BinarySearchDeluxeTest {
	
	//set up so we can test
	
	//create an array of Terms (tArray)
    Term m0 = new Term("ab", 1.0);
    Term m1 = new Term("ba", 1.0);
    Term m2 = new Term("bb", 1.0);
    Term m3 = new Term("bb", 1.0);
    Term m4 = new Term("bc", 1.0);
    Term m5 = new Term("bd", 1.0);
    Term m6 = new Term("be", 1.0);
    Term m7 = new Term("be", 1.0);
    Term m8 = new Term("be", 1.0);
    Term m9 = new Term("ca", 1.0);    
    Term[] tArray = new Term[]{m0,m1,m2,m3,m4,m5,m6,m7,m8,m9};
    Term x1 = new Term("dog", 0.0);
    Term x2 = new Term("bf", 0.0);
    Term x3 = new Term("aa", 0.0);
    
    @Rule public ExpectedException thrown = ExpectedException.none();
   
    //test throwing a null value as the array
    @Test
    public void testNullArray() {
    	thrown.expect(NullPointerException.class);
    	thrown.expectMessage("Array can not be Null.");
    	BinarySearchDeluxe.firstIndexOf(null, m0, Term.byReverseWeightOrder());
    }
    
    //test throwing a null value as a key
    @Test
    public void testNullKey() {
    	thrown.expect(NullPointerException.class);
    	thrown.expectMessage("Key can not be Null.");
    	BinarySearchDeluxe.firstIndexOf(tArray, null, Term.byReverseWeightOrder());
    }
    
    //test throwing a null value as a comparator
    @Test
    public void testNullComparator() {
    	thrown.expect(NullPointerException.class);
    	thrown.expectMessage("Comparator can not be Null.");
    	BinarySearchDeluxe.firstIndexOf(tArray, m0, null);
    }
    
	@Test
	public void testFirstIndexOf() {		
		//test using 2 prefixes
		//tArray[7] = "be", first index of "be" is in tArray[6]
		assertTrue(BinarySearchDeluxe.firstIndexOf(tArray, tArray[7], Term.byPrefixOrder(2)) == 6);		//test it returns 6		
		assertFalse(BinarySearchDeluxe.firstIndexOf(tArray, tArray[7], Term.byPrefixOrder(2))!=6);	//test that any other value hasn't been returned
		
		//tArray[2] = "bb", first index of "bb" is in tArray[2]
		assertTrue(BinarySearchDeluxe.firstIndexOf(tArray, tArray[2], Term.byPrefixOrder(2))==2);		//test it returns 2		
		assertFalse(BinarySearchDeluxe.firstIndexOf(tArray, tArray[2], Term.byPrefixOrder(2))!=2);	//test that any other value hasn't been returned
		
		//test using 1 prefix
		//tArray[8] = "b", first index of "b" is in tArray[1]
		assertTrue(BinarySearchDeluxe.firstIndexOf(tArray, tArray[8], Term.byPrefixOrder(1)) == 1);		//test it returns 1		
		assertFalse(BinarySearchDeluxe.firstIndexOf(tArray, tArray[8], Term.byPrefixOrder(1))!=1);	//test that any other value hasn't been returned
		
		//tArray[9] = "c", first index of "c" is in tArray[9]
		assertTrue(BinarySearchDeluxe.firstIndexOf(tArray, tArray[9], Term.byPrefixOrder(1))==9);		//test it returns 2		
		assertFalse(BinarySearchDeluxe.firstIndexOf(tArray, tArray[9], Term.byPrefixOrder(1))!=9);	//test that any other value hasn't been returned
		
		//test item NOT in the array
		assertTrue(BinarySearchDeluxe.firstIndexOf(tArray, x1, Term.byPrefixOrder(2))<0);	// would appear AFTER array
		assertTrue(BinarySearchDeluxe.firstIndexOf(tArray, x2, Term.byPrefixOrder(2))<0);	// would appear within array
		assertTrue(BinarySearchDeluxe.firstIndexOf(tArray, x3, Term.byPrefixOrder(2))<0);	// would appear BEFORE array
	}

	@Test
	public void testLastIndexOf() {
		//test using 2 prefixes
		//tArray[7] = "be", last index of "be" is in tArray[8]
		assertTrue(BinarySearchDeluxe.lastIndexOf(tArray, tArray[7], Term.byPrefixOrder(2)) == 8);		//test it returns 8		
		assertFalse(BinarySearchDeluxe.lastIndexOf(tArray, tArray[7], Term.byPrefixOrder(2))!=8);	//test that any other value hasn't been returned
		
		//tArray[3] = "bb", last index of "bb" is in tArray[3]
		assertTrue(BinarySearchDeluxe.lastIndexOf(tArray, tArray[2], Term.byPrefixOrder(2))==3);		//test it returns 3		
		assertFalse(BinarySearchDeluxe.lastIndexOf(tArray, tArray[2], Term.byPrefixOrder(2))!=3);	//test that any other value hasn't been returned
		
		//test using 1 prefix
		//tArray[1] = "b", last index of "b" is in tArray[8]
		assertTrue(BinarySearchDeluxe.lastIndexOf(tArray, tArray[1], Term.byPrefixOrder(1)) == 8);		//test it returns 8		
		assertFalse(BinarySearchDeluxe.lastIndexOf(tArray, tArray[1], Term.byPrefixOrder(1))!=8);	//test that any other value hasn't been returned
		
		//tArray[9] = "c", last index of "c" is in tArray[9]
		assertTrue(BinarySearchDeluxe.lastIndexOf(tArray, tArray[9], Term.byPrefixOrder(1))==9);		//test it returns 9		
		assertFalse(BinarySearchDeluxe.lastIndexOf(tArray, tArray[9], Term.byPrefixOrder(1))!=9);	//test that any other value hasn't been returned
		
		//test item NOT in the array
		assertTrue(BinarySearchDeluxe.lastIndexOf(tArray, x1, Term.byPrefixOrder(2))<0);		//would appear AFTER array
		assertTrue(BinarySearchDeluxe.lastIndexOf(tArray, x2, Term.byPrefixOrder(2))<0);		//would appear inside array
		assertTrue(BinarySearchDeluxe.lastIndexOf(tArray, x3, Term.byPrefixOrder(2))<0);		//would appear BEFORE array
	}

}
