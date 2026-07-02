class Solution {
    public int maxProfit(int[] prices) {
     int mp=0;
     int minbuy=prices[0];
     for(int sell:prices){
        mp=Math.max(mp,sell-minbuy);
        minbuy=Math.min(minbuy,sell);
     }
     return mp;
     
    }
}
