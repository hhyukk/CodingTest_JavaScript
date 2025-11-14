import java.util.*;

import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int limit=nums.length/2;
        
        return (int) Arrays.stream(nums)
            .distinct()
            .limit(limit)
            .count();
    }
}