class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 0;
        int i = 0;
        
        while (i < points.length) {
            int launch = points[i][1];  
           
            while (i + 1 < points.length && launch >= points[i + 1][0]) {
                i++;
            }
            count++;  
            i++;
        }
        
        return count;
    }
}