class Solution {
    public int lastRemaining(int n) {
    List<Integer> l=new ArrayList<>();
    int head = 1, step = 1, left = 1;
    while(n>1){
        if(left==1||n%2==1){
            head+=step;
        }
        n=n/2;
        step*=2;
        left=1-left;
    } return head;
 }