class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        List<Integer> row, previous=null;
        
        for(int i=0; i< numRows ; i++){
            
            row = new ArrayList<Integer>();
            
            for(int j=0;j<=i;j++){
                
                if(j==0 || j==i){
                    row.add(1);
                }
                else row.add(previous.get(j-1)+ previous.get(j));
                
                
            }
            
            list.add(row);
            previous = row;
        }
        
        return list;
        
        
        
    }
}

/*Things to note :
    1. The way of creating List of List Integers. List<List<Integer>> list = new ArrayList<List<Integer>>();
    2. Find the common output pattern , in this case its, first and last element of each row is 1, so if j==0 or j==i set it 1.
    3. If a output is dependent on the previous output, then use something to store that. here previous list & and update it.

for pascals triangle there is formula to calculate the index of rowth and columnth place : its row-1 C column-1 ; nCr = n!/r!(n-r)!

*/
