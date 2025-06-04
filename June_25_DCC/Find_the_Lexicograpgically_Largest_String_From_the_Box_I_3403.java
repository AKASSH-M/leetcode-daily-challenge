package June_25_DCC;

public class Find_the_Lexicograpgically_Largest_String_From_the_Box_I_3403 {
    static class Solution {
        public String answerString(String word, int num) {
            if(num == 1) return word;
            int[] res = {0,-1};
            int l = word.length() -1;
            int r = l;
            for(;l>-1;l--){
                if(r-l+1 > word.length() - num + 1) r--;
                if(big(word,l,r+1,res[0],res[1]+1)){
                    res[0] = l;res[1] = r;
                }
            }
            return word.substring(res[0],res[1]+1);
        }
        private boolean big(String a,int a1,int a2,int b1,int b2){
            for(int i = 0 ; i + a1 < a2 && i + b1 < b2;i++){
                char ac = a.charAt(i+a1) , b = a.charAt(i+b1);
                if(ac -'a'> b-'a') return true;
                if(ac -'a'< b-'a') return false;
            }
            return a2 - a1 > b2 - b1 ;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.answerString("xy",1);
    }
}
