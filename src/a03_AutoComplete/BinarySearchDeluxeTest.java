package a03_AutoComplete;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

public class BinarySearchDeluxeTest {
	
	//set up so we can test
	
	//create an array of Terms (tArray)
    Term m0 = new Term("aa", 1.0);
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
		assertTrue(BinarySearchDeluxe.firstIndexOf(tArray, tArray[8], Term.byPrefixOrder(1)) == 1);		//test it returns 6		
		assertFalse(BinarySearchDeluxe.firstIndexOf(tArray, tArray[8], Term.byPrefixOrder(1))!=1);	//test that any other value hasn't been returned
		
		//tArray[9] = "c", first index of "c" is in tArray[9]
		assertTrue(BinarySearchDeluxe.firstIndexOf(tArray, tArray[9], Term.byPrefixOrder(1))==9);		//test it returns 2		
		assertFalse(BinarySearchDeluxe.firstIndexOf(tArray, tArray[9], Term.byPrefixOrder(1))!=9);	//test that any other value hasn't been returned
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
	}

}
