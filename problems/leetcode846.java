import java.util.Arrays;
import java.util.HashMap;

class leetcode846{
    
  public boolean isNStraightHand(int[] hand, int groupSize) {
      
      if(hand.length % groupSize != 0){
          return false;
      }
  
      Arrays.sort(hand);
  
      HashMap<Integer,Integer> freq = new HashMap<>();

      for(int i = 0; i < hand.length; i++){
          freq.put(hand[i], freq.getOrDefault(hand[i],0)+1);
      }
  
      for(int i = 0; i < hand.length; i++){

          if(freq.get(hand[i]) == 0){
              continue;
          }
          else{

              int size = 1;
              int current = hand[i];
              int currentCount = freq.get(current);
              freq.put(current, currentCount-1);
          
              while(size < groupSize){
                  
                  if( freq.containsKey(current+1) == true && freq.get(current+1) > 0 ){
                      
                      int count = freq.get(current+1);

                      current += 1;
                      
                      freq.put(current, count-1);

                      size++;
                  }
                  else{
                      return false;
                  }
                  
                  
              }
          
          }
      
      }
  
      return true;
  }

}