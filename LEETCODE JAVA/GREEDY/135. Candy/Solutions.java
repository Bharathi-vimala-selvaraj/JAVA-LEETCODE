class Solution {
    public int candy(int[] ratings) {
      int l[]=new int[ratings.length];
      int r[]=new int[ratings.length];
      int n=ratings.length;
      int lc=1;
      int rc=1;
      int s=0;
      l[0]=1;
      r[n-1]=1;
      for(int i=1;i<n;i++){
       if(ratings[i]>ratings[i-1])
        lc++;
       else lc=1; 
       l[i]=lc;
      }  
      for(int i=n-2;i>=0;i--){
       if(ratings[i]>ratings[i+1])
        rc++;
       else
       rc=1;
       r[i]=rc;
      }
 for(int i=0;i<n;i++){
     s+=Math.max(l[i],r[i]);
      }return s;  
    }
}
