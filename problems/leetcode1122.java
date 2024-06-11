import java.util.ArrayList;
import java.util.Collections; 

class leetcode1122 {
    
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
      
      int[] result = new int[ arr1.length ];
  
      ArrayList<Integer> sol = new ArrayList<>();
      ArrayList<Integer> leftover = new ArrayList<>();
      
      int[] freq = new int[1001];
      
      for(int j = 0; j < arr1.length; j++){

         freq[ arr1[j] ] += 1;
     
      }
      
      
      for(int i = 0; i < arr2.length; i++ ){

          int iter = freq[ arr2[i] ];    
      
          for(int j = 0; j < iter; j++){
              sol.add( arr2[i] );
          }
      
      }
      
      for(int i = 0; i < sol.size(); i++){

          result[i] = sol.get(i);
      
      }
      
      for(int i = 0; i < arr1.length; i++){

          if( sol.contains( arr1[i] ) == false ){
              leftover.add( arr1[i] );
          }
      
      }
      
      Collections.sort(leftover);
      
      int counter = sol.size();
      
      for(int i = 0; i < leftover.size(); i++){

          result[counter] = leftover.get(i);
          counter++;
      
      }
      
      
      return result;
  }

}
