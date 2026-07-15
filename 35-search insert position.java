class Solution {
    public int searchInsert(int[] nums, int target) {
    int left = 0;
    int Right = nums.length-1;
    while(left<=Right){
        int mid = left + (Right - left)/2;
        if(nums[mid] == target){
            return mid;}
            else if(nums[mid]<target){
                left = mid+1;
            }else{
                Right = mid-1;
            }
        }
    return left;   
    }
}
