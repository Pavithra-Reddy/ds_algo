package leetcode_aug;

public class ValidSudoku {

	public static void main(String[] args) {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'}
		,{'6','.','.','1','9','5','.','.','.'}
		,{'.','9','8','.','.','.','.','6','.'}
		,{'8','.','.','.','6','.','.','.','3'}
		,{'4','.','.','8','.','3','.','.','1'}
		,{'7','.','.','.','2','.','.','.','6'}
		,{'.','6','.','.','.','.','2','8','.'}
		,{'.','.','.','4','1','9','.','.','5'}
		,{'.','.','.','.','8','.','.','7','9'}};
		System.out.println(isValidSudoku(board));

	}
	
	public static boolean isValidSudoku(char[][] board) {
        boolean[] found = new boolean[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    if (found[num-1]) {
                        return false;
                    }
                    found[num-1] = true;
                }
                
            }
            found = new boolean[9];
        }
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.'){
                    int num = board[j][i] - '0';
                    if (found[num-1]) {
                        return false;
                    }
                    found[num-1] = true;
                }
                
            }
            found = new boolean[9];
        }
        
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                for (int si = 0; si < 3; si++) {
                    for (int sj = 0; sj < 3; sj++) {
                        if (board[i+si][j+sj] != '.'){
                            int num = board[i+si][j+sj] - '0';
                            if (found[num-1]) {
                                return false;
                            }
                            found[num-1] = true;
                        }
                    }
                }
                found = new boolean[9];
            }
        }
        return true;
    }

}
