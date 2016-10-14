/**
 * Class provides the game logic.
 */
package shakki.game;


import shakki.piece.King;
import shakki.piece.Pawn;
import shakki.piece.Piece;
import shakki.player.HumanPlayer;
import shakki.player.Player;



public class Chess {

    private boolean continues;
    private ChessBoard board;
    private Player player;
    private boolean check;
    private boolean enPassantPossible;
    private boolean castlingPossible;

    /**
     * Constructor sets the board, the players and the initial values of some game situations.
     */
    public Chess() {
        this.continues = true;
        this.board = new ChessBoard();
        this.player = new HumanPlayer();
        this.enPassantPossible = false;
        this.castlingPossible = false;
        this.check = false;
    }
    
    /**
     * Controls the proceeding of the game.
     */
    public void play() {
        
    }
    
    /**
     * If possible, moves the piece and changes the turn.
     * Also checks some game situations.
     * 
     * @param from The initial position
     * @param to The destination
     */
    public void move(Square from, Square to) {
        Piece moving = board.getPiece(from);
        Piece captured = board.getPiece(to);
        
        if (moving.legalMove(from, to, board) && (moving.getColor() != captured.getColor()) && !player.movingOwnPiece(moving)) {
            if (captured.getClass() == King.class) {
                this.continues = false;
            }
            /* 
            if (captured.getClass() == Pawn.class && to.getRow() == 7) {
                TODO 
            }
            */
            board.setPiece(moving, to);
            board.setPiece(null, from);
            player.changeTurn();
        }
    }
    
    /**
     * Checks if it is check.
     * @return true if the king is in check and false otherwise
     */
    public boolean check() {
        return this.check;
    }
    
    /**
     * Method checks if it is checkmate.
     * @return true if the game is over and false if the game continues
     */
    public boolean checkmate() {
        return !this.continues;
    }
    
}
