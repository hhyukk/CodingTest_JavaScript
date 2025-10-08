import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> kinds = new HashSet<>();
        for (int n : nums) kinds.add(n);

        int pick = nums.length / 2;       
        return Math.min(kinds.size(), pick);
    }
}
