class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length+queue2.length;
        long sum1=0;
        long sum2=0;
        int[] arr = new int[n];
        
        for(int i=0; i<queue1.length; i++){
            arr[i] = queue1[i];
            sum1 += queue1[i];
        }
        for(int i=0; i<queue2.length; i++){
            arr[i+queue1.length]=queue2[i];
            sum2+=queue2[i];
        }
        
        long total = sum1+sum2;
        long target = total/2;
        
        int left=0;
        int right=queue1.length;
        int cnt=0;
        
        while(left<n && right<n){
             if(sum1 == target) return cnt;
            if(sum1<target){
                sum1+=arr[right];
                right++;
            }else{
                sum1-=arr[left];
                left++;
            }
            cnt++;
        }
        return -1;
    }
}