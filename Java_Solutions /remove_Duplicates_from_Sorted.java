class DuplSolution {
    public int removeDuplicates(int[] nums) {
      int insert = 1;

        for (int i = 1; i < nums.length; i++){
            // Skip to next index if duplicate exists
            if(nums[i] != nums[i-1]){
                /* Storing the unique element at 'insert' index and increment 
                it by 1 */
                nums[insert] = nums[i];
                insert++;
            }   
        }
        return insert;
      }  
    }