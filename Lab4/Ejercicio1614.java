public class Ejercicio1614 {
    class Solution {
        public int maxDepth(String s) {
            int left = 0, max = 0;
            for(char c: s.toCharArray()) {
                if ( c == '(') {
                    left++;
                } else {
                    if (c == ')') {
                        left--;
                    }
                }
                max = Math.max(max, left);
            }
            return max;
        }
    }
}
