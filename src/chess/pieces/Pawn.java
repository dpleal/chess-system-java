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
			Position p2 = new Position(p.getRow() -1, p.getColumn()); // verificar se a casa para o movimento inicial de 2 casas está vazia
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)&& getMoveCount() == 0 && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//verificar se há peça nas diagonais, para poder capturar
			
			p.setValues(position.getRow()-1, position.getColumn()-1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(position.getRow()-1, position.getColumn()+1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
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
				Position p2 = new Position(p.getRow() -1, p.getColumn()); // verificar se a casa para o movimento inicial de 2 casas está vazia
				if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)&& getMoveCount() == 0 && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//verificar se há peça nas diagonais, para poder capturar
				
				p.setValues(position.getRow()+1, position.getColumn()-1);
				if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				p.setValues(position.getRow()+1, position.getColumn()+1);
				if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
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
