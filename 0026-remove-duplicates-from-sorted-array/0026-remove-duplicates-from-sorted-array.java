class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        
        int insertIndex = 1;

        
        for (int i = 1; i < nums.length; i++) {
            
            if (nums[i] != nums[i - 1]) {
                
                nums[insertIndex] = nums[i];
                
                
                insertIndex++;
            }
        }

        
        return insertIndex;
    }
}