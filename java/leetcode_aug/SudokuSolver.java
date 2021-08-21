package leetcode_aug;

public class SudokuSolver {

	public static void main(String[] args) {
		char[][] board = {
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' }
				};

		if(solve(board)) {
			int rL = board.length;
			int cL = board[0].length;
			for (int i = 0; i < rL; i++) {
				for (int j = 0; j < cL; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		}
		
		
	}

	private static boolean solve(char[][] board) {
		int rL = board.length;
		int cL = board[0].length;

		for (int i = 0; i < rL; i++) {
			for (int j = 0; j < cL; j++) {
				if (board[i][j] == '.') {
					for (char ch = '1'; ch <= '9'; ch++) {
						if (isValid(board, i, j, ch)) {
							board[i][j] = ch;
							if (solve(board)) {
								return true;
							} else {
								board[i][j] = '.';
							}
						}
					}
					return false;
				}
			}
		}

		return true;
	}

	private static boolean isValid(char[][] board, int r, int c, char num) {
		for (int i = 0; i < 9; i++) {
			if (board[i][c] != '.' && board[i][c] == num) {
				return false;
			}
			if (board[r][i] != '.' && board[r][i] == num) {
				return false;
			}
			if (board[3*(r/3) + i/3][3*(c/3) + i%3] != '.'
					&& board[3*(r/3) + i/3][3*(c/3) + i%3] == num) {
				return false;
			}
		}
		return true;
	}
}
