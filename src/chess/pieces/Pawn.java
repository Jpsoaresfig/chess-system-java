package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);

	}

	@Override
	public boolean[][] possibleMoves() {
	    boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
	    Position p = new Position(0, 0);

	    if (getColor() == Color.WHITE) {
	        // Movimento simples para frente
	        p.setValues(position.getRow() - 1, position.getColum());
	        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
	            mat[p.getRow()][p.getColum()] = true;
	        }

	        // Movimento duplo no primeiro lance
	        p.setValues(position.getRow() - 2, position.getColum());
	        Position p2 = new Position(position.getRow() - 1, position.getColum());
	        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) &&
	            getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) &&
	            getMoveCount() == 0) {
	            mat[p.getRow()][p.getColum()] = true;
	        }

	        // Captura diagonal esquerda
	        p.setValues(position.getRow() - 1, position.getColum() - 1);
	        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
	            mat[p.getRow()][p.getColum()] = true;
	        }

	        // Captura diagonal direita
	        p.setValues(position.getRow() - 1, position.getColum() + 1);
	        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
	            mat[p.getRow()][p.getColum()] = true;
	        }
	    } else { // Movimento do peão preto
	        // Movimento simples para frente
	        p.setValues(position.getRow() + 1, position.getColum());
	        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
	            mat[p.getRow()][p.getColum()] = true;
	        }

	        // Movimento duplo no primeiro lance
	        p.setValues(position.getRow() + 2, position.getColum());
	        Position p2 = new Position(position.getRow() + 1, position.getColum());
	        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) &&
	            getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) &&
	            getMoveCount() == 0) {
	            mat[p.getRow()][p.getColum()] = true;
	        }

	        // Captura diagonal esquerda
	        p.setValues(position.getRow() + 1, position.getColum() - 1);
	        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
	            mat[p.getRow()][p.getColum()] = true;
	        }

	        // Captura diagonal direita
	        p.setValues(position.getRow() + 1, position.getColum() + 1);
	        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
	            mat[p.getRow()][p.getColum()] = true;
	        }
	    }

	    return mat;
	}
	@Override
	public String toString() {
		return"P";
		
	}

}
