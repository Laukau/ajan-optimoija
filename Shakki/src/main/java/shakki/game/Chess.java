/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.game;


import shakki.piece.Piece;
import shakki.player.HumanPlayer;
import shakki.player.Player;


/**
 *
 * @author Laura
 */
public class Chess {

    private boolean continues;
    private ChessBoard board;
    private HumanPlayer player;

    public Chess() {
        this.continues = true;
        this.board = new ChessBoard();
        this.player = new HumanPlayer();

    }

    public void play() {

    }
    
    //Moves piece if possible
    public void move(Position from, Position to) {
        Piece moving = board.getPiece(from);
        Piece captured = board.getPiece(to);
        
        if(moving.legalMove(from, to, board) && (moving.getColor() != captured.getColor()) && player.movingOwnPiece(moving)) {
            board.setPiece(moving, to);
            player.changeTurn();
        }
    }
    
    //Tells if the game is over
    public boolean checkmate() {
        return !this.continues;
    }
}
