class Solution {
    public void setZeroes(int[][] matrix) {
        
       
        
        int row[] = new int[matrix.length];
        int column[] = new int[matrix[0].length];
        
        for(int i = 0; i<matrix.length; i++){
            
            for(int j=0;j<matrix[0].length;j++){
                
                if(matrix[i][j]==0){
                    
                    row[i] =-1;
                    column[j] = -1;
                    
                }
             } 
         }
        
        for(int i = 0; i<matrix.length; i++){
            
             if(row[i]==-1){
                 
                 for(int j=0;j<matrix[0].length;j++){
                     
                     matrix[i][j]=0;
                     
                 }
                 
             }
         }
        
        for(int i = 0; i<matrix[0].length; i++){
            
             if(column[i]==-1){
                 
                 for(int j=0;j<matrix.length;j++){
                     
                     matrix[j][i]=0;
                     
                 }
                 
             }
         }
        
        
        
    }
}

    //create two dummy arrays one for row and one for column
     //iterate the matrix and set -1 in the dummys to fix rows n columnst that should be with 0
