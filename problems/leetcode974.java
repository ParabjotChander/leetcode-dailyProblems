import java.util.HashMap;

class Solution {
    
  public int subarraysDivByK(int[] nums, int k) {
      
      if(nums.length == 1){
          return nums[0] % k == 0 ? 1 : 0;
      }
      
      HashMap<Integer,Integer> remainderFreq = new HashMap<>();
      remainderFreq.put(0,1);
      
      int count = 0;
      int sum = 0;
      
      for(int i = 0; i < nums.length; i++){

          sum += nums[i];

          // we do + k % k to deal with negative numbers 
          int remainder = (sum % k + k) % k;

          if(remainderFreq.containsKey(remainder)){
              count += remainderFreq.get(remainder);
          }
      
          remainderFreq.put(remainder, remainderFreq.getOrDefault(remainder,0)+1);
      }
      
      return count;
  }

}