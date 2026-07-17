// how to declare hashset
// how to declare multiple rows hashset
// how to treverse 2 d array
// how to fill the hashsets created ones in the reference arrays.
// how to find rows and cols
// Most imp How to find the box

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> rows[] = new HashSet[9];
        HashSet<Character> cols[] = new HashSet[9];
        HashSet<Character> boxes[] = new HashSet[9];
        int boxIndex=0;
        char currChar='.';

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                currChar= board[i][j];

                if(currChar=='.'){
                    continue;
                }
                else{
                    
                    if(rows[i].contains(currChar)){
                        return false;
                    }else{
                        rows[i].add(currChar);
                    }
                    if(cols[j].contains(currChar)){
                        return false;
                    }else{
                        cols[j].add(currChar);
                    }
                    boxIndex = (i / 3) * 3 + (j / 3);
                    if(boxes[boxIndex].contains(currChar)){
                        return false;
                    }else{
                        boxes[boxIndex].add(currChar);
                    }
                }
            }
        }
        return true;
        //9 rows
        //9 cols
        // 9 boxes
        //divide by 3 i and j, and then fit in 3*3 matrix
        //00 1st box, 01 2nd box, 02 3rd box 
        
        
    }
}

// more fast solution
// class Solution {
//     public boolean isValidSudoku(char[][] board) {
//         boolean[][] rows = new boolean[9][9];
//         boolean[][] cols = new boolean[9][9];
//         boolean[][] boxes = new boolean[9][9];

//         for (int i = 0; i < 9; i++) {
//             for (int j = 0; j < 9; j++) {
//                 if (board[i][j] != '.') {
//                     int num = board[i][j] - '1';
//                     int boxIndex = (i / 3) * 3 + (j / 3);

//                     if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
//                         return false;
//                     }

//                     rows[i][num] = cols[j][num] = boxes[boxIndex][num] = true;
//                 }
//             }
//         }
//         return true;
//     }
// }

/* 
36. Valid Sudoku

Apple

JPMorgan Chase

Infosys

Flipkart

Zomato

Swiggy

Adobe

Oracle
⚡32
Solved
Medium
Topics
premium lock icon
Companies
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 

Example 1:


Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.
*/