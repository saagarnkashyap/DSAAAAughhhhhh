class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int n = seats.length;
        int max1 = 0, max2 = 0;
        for(int i=0; i<n; i++){
            max1 = Math.max(max1, seats[i]);
            max2 = Math.max(max2, students[i]);
        }
        int count1[] = new int[max1+1];
        int count2[] = new int[max2+1];
        for(int i=0; i<n; i++){
            count1[seats[i]]++;
            count2[students[i]]++;
        }
        int a = 0;
        for(int i=0; i<count1.length; i++){
            while(count1[i] > 0){
                seats[a] = i;
                a++;
                count1[i]--;
            }
        }
        a = 0;
        for(int i=0; i<count2.length; i++){
            while(count2[i] > 0){
                students[a] = i;
                a++;
                count2[i]--;
            }
        }
        a = 0;
        int count = 0;
        while(a < n){
            count += Math.abs(seats[a] - students[a]);
            a++;
        }
        return count;
    }
}