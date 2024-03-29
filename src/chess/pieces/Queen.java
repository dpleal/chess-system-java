package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {
	
	
	public Queen(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "Q";
	}

	@Override
	public boolean[][] possibleMoves() {
		
		
		boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		
		
		// MOVIMENTOS DE TORRE
		// check above (s� na vertical)
		p.setValues(position.getRow() - 1, position.getColumn());
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { // enquanto a posi��o for v�lida e n�o tiver uma pe�a
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow()-1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// check left (s� na horizontal)
		p.setValues(position.getRow() , position.getColumn()- 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { // enquanto a posi��o for v�lida e n�o tiver uma pe�a
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn()-1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// check right (s� na horizontal)
		p.setValues(position.getRow() , position.getColumn()+ 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { // enquanto a posi��o for v�lida e n�o tiver uma pe�a
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn()+1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// check below (s� na vertical)
		p.setValues(position.getRow() + 1, position.getColumn());
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { // enquanto a posi��o for v�lida e n�o tiver uma pe�a
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow()+1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// MOVIMENTOS DE BISPO
		
		// check up left diagonal (NW)
		p.setValues(position.getRow() - 1, position.getColumn()-1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { // enquanto a posi��o for v�lida e n�o tiver uma pe�a
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow()-1);
			p.setColumn(p.getColumn()-1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// check up right diagonal (NE)
		p.setValues(position.getRow()-1 , position.getColumn()+ 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { // enquanto a posi��o for v�lida e n�o tiver uma pe�a
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow()-1, p.getColumn()+1);
			/*p.setRow(p.getRow()-1);
			p.setColumn(p.getColumn()+1); */
			
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// check down right (NE)
		p.setValues(position.getRow()+1 , position.getColumn()+ 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { // enquanto a posi��o for v�lida e n�o tiver uma pe�a
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow()+1);
			p.setColumn(p.getColumn()+1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// check down left (NW)
		p.setValues(position.getRow() + 1, position.getColumn()-1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { // enquanto a posi��o for v�lida e n�o tiver uma pe�a
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow()+1);
			p.setColumn(p.getColumn()-1);
			
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		return mat;

	}
}
