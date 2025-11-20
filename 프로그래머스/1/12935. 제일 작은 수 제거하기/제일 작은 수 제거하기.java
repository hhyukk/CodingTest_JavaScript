import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length==1) return new int[]{-1};
        
        int min=arr[0];
        
        for(int n:arr){
            if(min>n){
                min=n;
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int n: arr){
            if(n!=min){
                list.add(n);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}