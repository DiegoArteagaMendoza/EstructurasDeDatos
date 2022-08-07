class Solution {
    class Camino {
     int src;
     int nbr;

     Camino(int src, int nbr) {
        this.src = src;
        this.nbr = nbr;
     }
  }
   public boolean validPath(int n, int[][] edges, int source, int destination) {
       boolean[] visited=new boolean[n];
       ArrayList<Camino>[] graph = new ArrayList[n];
       for (int i = 0; i < n; i++) {
           graph[i]=new ArrayList<>();
       }
       for(int[] Camino:edges){
           graph[Camino[0]].add(new Camino(Camino[0],Camino[1]));
           graph[Camino[1]].add(new Camino(Camino[1],Camino[0]));
       }
       return hasPath(graph,source,destination,visited);
   }
   private boolean hasPath(ArrayList<Camino>[] graph, int source, int destination,boolean[] visited){
       if(source==destination) return true;
       visited[source]=true;
       for(Camino Camino:graph[source])
           if(!visited[Camino.nbr]){
               boolean hashNbrPath=hasPath(graph,Camino.nbr,destination,visited);
               if(hashNbrPath) return true;
           }    
       return false;
   }
}