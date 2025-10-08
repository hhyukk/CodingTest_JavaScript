import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int n = nums.length / 2;
        HashSet<Integer> hashset = new HashSet<>();
        
        for(int i=0; i<nums.length; i++){
            if(!hashset.contains(nums[i])) hashset.add(nums[i]);
        }
        
        return hashset.size()>n?n:hashset.size();
    }
}