import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        Set<String> set = new HashSet<>();
        for(String s:phoneBook){
            set.add(s);
        }
        for(String s : set){
            for(int i=1; i<s.length(); i++){
                String n=s.substring(0,i);
                if(set.contains(n)) return false;
            }
        }
        return true;
    }
}