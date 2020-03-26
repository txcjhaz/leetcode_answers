package answer.easy;

/**
 * 999. 车的可用捕获量
 */
public class AvailableCapturesForRook {
    public int numRookCaptures(char[][] board) {
        int[] row = new int[8];
        int[] col = new int[8];

        int x = 0, y = 0;
        boolean found = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'p') {
                    row[i]++;
                    col[j]++;
                } else if (board[i][j] == 'B') {
                    row[i] = 0;
                    col[j] = 0;
                } else if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    found = true;
                    break;
                }
            }
            if (found)
                break;
        }

        int res = ((row[x] > 0) ? 1 : 0) + ((col[y] > 0) ? 1 : 0);
        for(int i = y; i < 8; i++){
            if(board[x][i] == 'p'){
                res++;
                break;
            }
            else if(board[x][i] == 'B')
                break;
        }
        for(int i = x; i < 8; i++){
            if(board[i][y] == 'p'){
                res++;
                break;
            }
            else if(board[i][y] == 'B')
                break;
        }

        return res;
    }
}
