class Solution {
    
    public int subsetXORSum(int[] nums) {
        
        int result = 0;
        
        // OR operation on all array elements
        for(int num: nums){
            result |= num;
        }
        
        //shift the result to the left by the number of elements in the array
        return result << (nums.length-1);
    }

}