import java.util.ArrayList;

class Solution {
    
  public int heightChecker(int[] heights) {
      
      int count = 0;
      
      int[] frequency = new int[101];

      ArrayList<Integer> sorted = new ArrayList<>();
  
      for( int i = 0; i < heights.length; i++ ){

          int current = frequency[ heights[i] ];
          current++;
          frequency[ heights[i] ] = current;
      
      }
      
      int counter = 0;
      
      for(int i = 0; i < frequency.length; i++ ){

          if(frequency[i] == 0){
              continue;
          }
          else{

              int co = frequency[i];
          
              while( counter < co ){
                  sorted.add(i);
                  counter++;
              }
          
              counter = 0;
          
          }
      
      }
      
      for( int i = 0; i < heights.length; i++ ){

          if( heights[i] != sorted.get(i)  ){
              count++;
          }
      
      }
  
      return count;
  }

}