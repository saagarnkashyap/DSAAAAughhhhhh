class Solution {
   public static String reorderSpaces(String text) {
        String[] countWord = text.split(" ");
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < countWord.length; i++) {
            countWord[i] = countWord[i].trim();
            if (!countWord[i].isEmpty()) {
                arrayList.add(countWord[i]);
            }
        }
        int countSpace = 0;
        int extraSpace=0;
        String out = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                countSpace++;
            }
        }
        if(arrayList.size()==1 ){
            out= arrayList.get(0);
            for (int j = 0; j < countSpace; j++) {
                    out += " ";
            }
            return out;          
        }
            
            extraSpace=(countSpace%(arrayList.size()-1));
        
        countSpace = countSpace / (arrayList.size() - 1);
        for (int i = 0; i < arrayList.size(); i++) {
            out += arrayList.get(i);
            if(i!=arrayList.size()-1){
                for (int j = 0; j < countSpace; j++) {
                    out += " ";
                }
            }   
        }     
           for(int i=0;i<extraSpace;i++){ 
                out+=" ";
           }
            
        return out;
    }
}