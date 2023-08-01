// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Create 3 hashmaps for rows, cols and squares.
 * 2. Iterate through the board and check if the value is present in the hashmaps. If present return false.
 * 3. If not present add the value to the hashmaps.
 * 4. Return true if no value is repeated.
 */

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Character>> cols = new HashMap<>();
        HashMap<Integer, HashSet<Character>> squares = new HashMap<>();
        for(int i=0; i<9; i++){
            rows.put(i, new HashSet<Character>());
            cols.put(i, new HashSet<Character>());
            for(int j=0; j<9; j++){
                int idx = (i/3)*3 + j/3;
                squares.put(idx, new HashSet<Character>());
            }
        }

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.')
                    continue;

                char ch = board[i][j];
                int idx = (i/3)*3 + j/3;
                if((rows.get(i) != null && rows.get(i).contains(ch)) || (cols.get(i) != null && cols.get(j).contains(ch)) || (squares.get(idx) != null && squares.get(idx).contains(ch))){
                    return false;
                }

                rows.get(i).add(ch);
                cols.get(j).add(ch);
                squares.get(idx).add(ch);
            }
        }

        return true;
    }
}
