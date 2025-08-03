class Solution {
    static class Triple{
        int id;
        int rate;

        Triple(int id, int rate){
            this.id = id;
            this.rate = rate;
        }
    }

    

    
    public List<Integer> filterRestaurants(int[][] rest, int vegan, int maxP, int maxD) {

        ArrayList<Triple> arr = new ArrayList<>();

        int n = rest.length;

        if(vegan==1){
            for(int i=0; i<n; i++){
                if(rest[i][2]==1 && rest[i][3]<=maxP && rest[i][4]<=maxD){
                    arr.add(new Triple(rest[i][0],rest[i][1]));
                }
            }
        }else{
            for(int i=0; i<n; i++){
                if(rest[i][3]<=maxP && rest[i][4]<=maxD){
                    arr.add(new Triple(rest[i][0],rest[i][1]));
                }
            }
        }

        Collections.sort(arr,(a,b)->b.rate==a.rate ? b.id-a.id : b.rate-a.rate);

        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<arr.size(); i++){
            ans.add(arr.get(i).id);
        }

        return ans;
    }
}