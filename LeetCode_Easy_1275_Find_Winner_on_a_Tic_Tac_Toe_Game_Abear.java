class Solution {

    public String tictactoe(int[][] moves) {
        //Declare a Double Character array to represent the grid of the Tic Tac Toe Board. Array is default initialized to null. 
        //     0       1       2   
        // 0 [x]  [null]  [null] 
        // 1 [null]  [x]  [null] 
        // 2 [o]  [o]  [x] 
        char[][] board = new char[3][3];
        
        //Create a counter variable (increment each move) to validate whether we have performed all moves (draw) or if we have moves left (pending).      After all moves, if (movesCounter != moves.length) return "Pending"
        int movesCounter = 0;

        //Use a boolean toggle to identify who's turn it is (Player A- 'X'   or Player B- 'O')
        boolean isPlayerATurn = true;
        //Utilize the Character (Wrapper Object) or char (primitive) objects to calculate if there is a winner.
        int playerA_AsciWinValue = 264;             //Player A uses Character 'X' (char 'X'). This has a Unicode value of 88. 3 * 88 = 264.
        int playerB_AsciWinValue = 237;            //Player B uses Character 'O' (char 'O'). This has a Unicode value of 79. 79*3 = 237. 

        //Lets start by filling in the board with all the moves. Loop through and assign, updating the boolean turn toggle as we go.
        for(int i = 0; i < moves.length; i++){
            int row = moves[i][0];
            int column = moves[i][1];
            if(isPlayerATurn){
                    board[row][column] = 'X';
                    isPlayerATurn = false;
                    movesCounter++;
            }
            else{
                    board[row][column] = 'O';
                    isPlayerATurn = true;
                    movesCounter++;
            }
            //Check Player A Diagonal via asci value summation
            if(board[0][0] + board[1][1] + board[2][2] == playerA_AsciWinValue || board[0][2] + board[1][1] + board[2][0] == playerA_AsciWinValue)
                return "A";
            //check Player B Diagonal via asci value summation
            if(board[0][0] + board[1][1] + board[2][2] == playerB_AsciWinValue || board[0][2] + board[1][1] + board[2][0] == playerB_AsciWinValue)
                return "B";
                
            //Check Rows and Columns (Lets do something different. Instead of comparing asci values, merely chain the checks on each character to eachother. 
            // If char 1 == char 2 ... and char 2 == 3.. and char 1 != null (null for chars is represented by '\0') ... then see what the character is to determine who the winner is. If its X, then we know Player A won. 
           // Ternary operator usage is the following : (return board[k][0] == 'X" ? "A" : "B").    They are VERY clean, use them when you can, and get used to reading them fast. 
           // Ternary operator: (condition) ? (value if true) : (value if false);
           //            (board[k][0] == 'X' ?   'A'          :   'B'; 
           // Ternary operator: Shorthand for if-else. Evaluates the condition and returns the first value if true, otherwise the second value.

            for(int k = 0; k < 3; k++){
                if(board[k][0] == board[k][1] && board[k][1] == board[k][2] && board[k][0] != '\0'){
                    return board[k][0] == 'X' ? "A" : "B";
                }
                if (board[0][k] == board[1][k] && board[1][k] == board[2][k] && board[0][k] != '\0') {
                    return board[0][k] == 'X' ? "A" : "B";
            }
        }
    }
            // System.out.println("Moves Counter : " + movesCounter + "     moves.length: " + moves.length);
        return movesCounter < 9 ? "Pending" : "Draw";

}
}
