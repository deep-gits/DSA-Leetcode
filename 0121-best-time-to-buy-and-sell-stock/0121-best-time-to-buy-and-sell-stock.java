class Solution {
    public int maxProfit(int[] prices) {
        int minp=Integer.MAX_VALUE;
        int maxp=0;
        for(int p :prices){
            if(p<minp){
                minp=p;
            }else if(p-minp >maxp){
                maxp=p-minp;
            }
        }
        return maxp;
    }
}