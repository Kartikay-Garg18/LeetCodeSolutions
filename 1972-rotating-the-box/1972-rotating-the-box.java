class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        for(int i=0; i<m; i++){
            int place = n-1;
            int j=n-1;
            while(j>=0){
                while(j>=0 && box[i][j]!='#'){
                    if(box[i][j] == '*'){
                        place = j-1;
                    }
                    j--;
                }
                if(j>=0){
                    box[i][place] = '#';
                    if(place!=j) box[i][j] = '.';
                    place--;
                    j--;
                }
            }
        }
        char[][] ans = new char[n][m];
        for(int i=0; i<n; i++){
            for(int j=m-1; j>=0; j--){
                ans[i][m-1-j] = box[j][i];
            }
        }
        return ans;
    }
}