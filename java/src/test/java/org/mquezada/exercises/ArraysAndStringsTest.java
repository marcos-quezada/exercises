package org.mquezada.exercises;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
       
public class ArraysAndStringsTest {
  private ArraysAndStrings arraysAndStrings;
  
  @Before public void init(){
    arraysAndStrings = new ArraysAndStrings();
  }

  @Test public void testReplaceSpaces(){
    String test = "http://myweb/this is a really nice web site?params";
    String expectedResult = "http://myweb/this%20is%20a%20really%20nice%20web%20site?params";
    char[] testCharArray = (char[])arraysAndStrings.resizeArray(test.toCharArray(), test.length() * 2);

    arraysAndStrings.replaceSpaces(testCharArray, test.length());
    assertEquals( expectedResult, new String(testCharArray).trim());  
  }

  @Test public void testPermutation(){
    assertTrue(arraysAndStrings.permutation("dog", "god"));
    assertFalse(arraysAndStrings.permutation("anagrama", "gradaama"));
  }
  
  @Test public void testHasOnlyUniqueChars(){
    assertFalse(arraysAndStrings.isUniqueChars("asdnlnjsdncsdjh"));
    assertTrue(arraysAndStrings.isUniqueChars("qwertzuioplkjhgfdsayxcvbnm"));
  }
  
  @Test public void testCompressString(){
    String expectedResult = "a2b1c5a3";
    assertEquals(expectedResult, arraysAndStrings.compressString("aabcccccaaa"));
  }
  
  @Test public void testRotate(){
    int matrix[][] = {
      {3,3,3,3,3},
      {6,6,6,6,6},
      {0,0,0,0,0},
      {9,9,9,9,9},
      {1,1,1,1,1}
    };
    
    int expectedMatrix[][] = {
      {1,9,0,6,3},
      {1,9,0,6,3},
      {1,9,0,6,3},
      {1,9,0,6,3},
      {1,9,0,6,3}
    };
    
    arraysAndStrings.rotate(matrix, 5);
    assertEquals(expectedMatrix, matrix);
  }
  
  
  @Test public void testSetZeros(){
    int matrix[][] = {
      {3,3,3,3,3},
      {6,6,6,6,6},
      {0,2,0,2,0},
      {9,9,9,9,9},
      {1,1,1,1,1}
    };
    
    int expectedMatrix[][] = {
      {0,3,0,3,0},
      {0,6,0,6,0},
      {0,0,0,0,0},
      {0,9,0,9,0},
      {0,1,0,1,0}
    };
    
    arraysAndStrings.setZeros(matrix);
    assertEquals(expectedMatrix, matrix);
  }
  
  @Test public void testIsRotation(){
    String ogString = "waterbottle";
    String okRotation = "erbottlewat";
    String noRotation = "botterwatel";
    String noSameLength = "glassofwater";
    
    assertTrue(arraysAndStrings.isRotation(ogString, okRotation));
    assertFalse(arraysAndStrings.isRotation(ogString, noRotation));
    assertFalse(arraysAndStrings.isRotation(ogString, noSameLength)); 
  }
  
}
