package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
	
	private ChessMatch chessMatch;

	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	
	@Override
	public boolean [][] possibleMoves(){
		boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0,0);
		
		if(getColor() == Color.WHITE) { 
			// movimento normal (andar 1 casa para frente)
			p.setValues(position.getRow()-1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			// movimento inicial (andar 2 casas para frente)
			p.setValues(position.getRow()-2, position.getColumn());
			Position p2 = new Position(p.getRow() -1, p.getColumn()); // verificar se a casa para o movimento inicial de 2 casas est� vazia
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)&& getMoveCount() == 0 && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//verificar se h� pe�a nas diagonais, para poder capturar
			
			p.setValues(position.getRow()-1, position.getColumn()-1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(position.getRow()-1, position.getColumn()+1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// #specialmove en Passant white
			if(position.getRow() == 3) { // enPassant s� pode ocorrer na linha de duas casas para frente do pe�o (condi��o � ter andado duas casas no primeiro movimento)
				//testar se h� algum pe�o na casa ao lado para fazer o movimento
				Position left = new Position(position.getRow(), position.getColumn()-1);
				//testar as condi��es para o enPassant
				if(getBoard().positionExists(left)&& isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					// movimento na diagonal
					mat[left.getRow()-1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn()+1);
				if(getBoard().positionExists(right)&& isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					// movimento na diagonal
					mat[right.getRow()-1][right.getColumn()] = true;
				}
			}
			
			
		} else {
			if(getColor() == Color.BLACK) { 
				// movimento normal (andar 1 casa para frente)
				p.setValues(position.getRow()+1, position.getColumn());
				if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				// movimento inicial (andar 2 casas para frente)
				p.setValues(position.getRow()+2, position.getColumn());
				Position p2 = new Position(p.getRow() -1, p.getColumn()); // verificar se a casa para o movimento inicial de 2 casas est� vazia
				if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)&& getMoveCount() == 0 && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//verificar se h� pe�a nas diagonais, para poder capturar
				
				p.setValues(position.getRow()+1, position.getColumn()-1);
				if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				p.setValues(position.getRow()+1, position.getColumn()+1);
				if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				// #specialmove en Passant black
				if(position.getRow() == 4) { // enPassant s� pode ocorrer na linha de duas casas para frente do pe�o (condi��o � ter andado duas casas no primeiro movimento)
					//testar se h� algum pe�o na casa ao lado para fazer o movimento
					Position left = new Position(position.getRow(), position.getColumn()-1);
					//testar as condi��es para o enPassant
					if(getBoard().positionExists(left)&& isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
						// movimento na diagonal
						mat[left.getRow()+1][left.getColumn()] = true;
					}
					Position right = new Position(position.getRow(), position.getColumn()+1);
					if(getBoard().positionExists(right)&& isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
						// movimento na diagonal
						mat[right.getRow()+1][right.getColumn()] = true;
					}
				}
				
			}
		}
					
		return mat;
	}
	@Override
	public String toString() {
		return "P";
	}
	
	
	

}
