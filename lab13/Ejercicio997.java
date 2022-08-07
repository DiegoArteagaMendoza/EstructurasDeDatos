class Solution {
    public int findJudge(int n, int[][] trust) {
        int[]ai = new int[n+1];
        int[]bi = new int[n+1];
        
        for(int i=0;i<trust.length;i++){
            int a = trust[i][0];
            int b= trust[i][1];
            
            ai[a]++;
            bi[b]++;
        }
        
        for(int i=1;i<n+1;i++){
            if(bi[i] == n-1 && ai[i] == 0){
                return i;
            }
        }
        
        return -1;
    }
}