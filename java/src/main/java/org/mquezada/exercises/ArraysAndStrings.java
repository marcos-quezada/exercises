package org.mquezada.exercises;

import java.lang.reflect.Array;
       
public class ArraysAndStrings {
  public boolean isUniqueChars(String str){
    int checker = 0;
    for(int i =0; i < str.length(); i++){
      int val = str.charAt(i) - 'a';
      if((checker & (1 << val)) > 0){
        return false;
      }
      checker |=  (1  << val);
    }
    return true;
  }
  
  public boolean permutation(String s, String t){
    if( s.length() != t.length() ){
      return false;
    }
    
    int [] letters = new int[256]; //Assumption
    
    char [] sArray = s.toCharArray();
    for( char c : sArray ){ // count the number of each char in s.
      letters[c]++;
    }
    
    for(int i = 0; i < t.length(); i++){
      int c = (int) t.charAt(i);
      if( --letters[c] < 0 ){
        return false;
      }
    }
    
    return true;
  }
  
  public void replaceSpaces(char[] str, int length){
    int spaceCount = 0, newLength, i;
    for( i = 0; i < length; i++ ){
      if( str[i] == ' ' ){
        spaceCount++;
      }
    }
    
    newLength = length + spaceCount * 2;
    str[newLength] = '\0';
    
    for( i = length - 1; i >= 0; i-- ){
      if( str[i] == ' ' ){
        str[newLength - 1] = '0';
        str[newLength - 2] = '2';
        str[newLength - 3] = '%';
        newLength = newLength - 3;
      }else{
        str[newLength - 1] = str[i];
        newLength = newLength -1;
      }
    }
  }
  
  public Object resizeArray (Object oldArray, int newSize) {
   int oldSize = Array.getLength(oldArray);
   Class elementType = oldArray.getClass().getComponentType();
   Object newArray = Array.newInstance(elementType, newSize);
   int preserveLength = Math.min(oldSize, newSize);
   
   if (preserveLength > 0)
      System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
   
   return newArray; 
  }
  
  public String compressString(String str){
    //Check if compression would create a longer string.
    int size = countCompression(str);
    if(size >= str.length()){
      return str;
    }
    
    char[] array = new char[size];
    int index = 0;
    char last = str.charAt(0);
    int count = 1;
    for(int i = 1; i < str.length(); i++){
      if(str.charAt(i) == last) //Found repeated character
        count++;
      else{
        //Update the repeated character count
        index = setChar(array, last, index, count);
        last = str.charAt(i);
        count = 1;
      }
    }
    
    //Update string with the last set of repeated characters.
    index = setChar(array, last, index, count);
    return String.valueOf(array);
  }
  
  private int countCompression(String str){
    if(str == null || str.isEmpty())
      return 0;
    char last = str.charAt(0);
    int size = 0;
    int count = 1;
    for(int i = 1; i < str.length(); i++){
      if(str.charAt(i) == last)
        count++;
      else{
        last = str.charAt(i);
        size += 1 + String.valueOf(count).length();
        count = 1;
      }      
    }
    
    size += 1 + String.valueOf(count).length();
    return size;  
  }
  
  private int setChar(char[] array, char c, int index, int count){
    array[index] = c;
    index++;
    
    //Convert the count to a string, then to an array of chars.
    char[] cnt = String.valueOf(count).toCharArray();
    
    //Copy the characters from biggest digit to smallest.
    for(char x: cnt){
      array[index] = x;
      index++;
    }
    return index;
  }
  
  public void rotate(int [][] matrix, int n){
    for(int layer = 0; layer < n/2; ++layer){
      int first = layer;
      int last = n - 1 - layer;
      for(int i = first; i < last; ++i){
        int offset = i -first;
        //save top
        int top = matrix[first][i];
        
        //left -> top
        matrix[first][i] = matrix[last-offset][first];
        
        //bottom -> left
        matrix[last-offset][first] = matrix[last][last-offset];
        
        //right -> bottom
        matrix[last][last-offset] = matrix[i][last];
        
        //top -> right
        matrix[i][last] = top;
      }
    }
  }
  
  
  public void setZeros(int[][] matrix){
    boolean[] row = new boolean [matrix.length];
    boolean[] column = new boolean[matrix[0].length];
    
    //Store the row and column index with value 0.
    for(int i = 0; i < matrix.length; i++)
      for (int j = 0; j < matrix[0].length; j++)
        if(matrix[i][j] == 0){
          row[i] = true;
          column[j] = true;
        }
    
    //Set arr[i][j] to 0 if either row i or column j has a 0.
    for(int i = 0; i < matrix.length; i++)
      for(int j = 0; j < matrix[0].length; j++)
        if(row[i] || column[j])
          matrix[i][j] = 0;          
  }
  
  public boolean isRotation(String s1, String s2){
    int len = s1.length();
    //Check that s1 and s2 are equal length and not empty.
    if(len == s2.length() && len > 0){
      //Concatenate s1 and s2 within new buffer
      String s1s1 = s1 + s1;
      return s1s1.contains(s2);
    }
    return false;
  }
  
}
