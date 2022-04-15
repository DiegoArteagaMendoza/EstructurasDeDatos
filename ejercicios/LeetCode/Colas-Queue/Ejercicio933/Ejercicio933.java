public class Ejercicio933 {
    class RecentCounter {
        LinkedList<Integer> llamados;
        public RecentCounter() {
            this.llamados = new LinkedList<Integer>();
        }
        
        public int ping(int t) {
            this.llamados.addLast(t);
            
            while(this.llamados.getFirst() < t - 3000) {
                this.llamados.removeFirst();
            }
            return this.llamados.size();
        }
    }
    
    /**
     * Your RecentCounter object will be instantiated and called as such:
     * RecentCounter obj = new RecentCounter();
     * int param_1 = obj.ping(t);
     */
}
