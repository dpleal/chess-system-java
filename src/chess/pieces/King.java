package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
	
	private ChessMatch chessMatch;
	
	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
		
	}
	
	@Override
	public String toString() {
		return "K";
	}
	
	
	// Testar jogada roque (rei anda duas casas e torre fica ao lado do rei qdo s� estiverem eles e o jogo n�o estiver em xeque)
	// testando se a torre est� apta � jogada do Roque (castling)
	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p!= null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0; 
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p== null || p.getColor() != getColor(); // consegue mover se a casa de destino estiver vazia OU se tiver um advers�rio
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		
		// above
		p.setValues(position.getRow()-1, position.getColumn());
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//below

		p.setValues(position.getRow()+1, position.getColumn());
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//left

		p.setValues(position.getRow(), position.getColumn()-1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//right

		p.setValues(position.getRow(), position.getColumn()+1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//nw (noroeste - acima e esquerda)

		p.setValues(position.getRow()-1, position.getColumn()-1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//ne (nordeste - acima e direita)

		p.setValues(position.getRow()-1, position.getColumn()+1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//sw (sudoeste - abaixo e esquerda)

		p.setValues(position.getRow()+1, position.getColumn()-1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//se (sudeste - abaixo e direita)

		p.setValues(position.getRow()+1, position.getColumn()+1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//#specialmove castling
		if(getMoveCount() == 0 && !chessMatch.getCheck()) {
			//specialmove castling kingside rook (roque pequeno, pois o rei est� do lado da torre, torre anda 2 movimentos para trocar)
			Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
			if(testRookCastling(posT1)) { // testar se as demais casas da linha est�o vazias
				Position p1 = new Position(position.getRow(), position.getColumn() + 1);
				Position p2 = new Position(position.getRow(), position.getColumn() + 2);
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null ) {
					mat[position.getRow()][position.getColumn()+2] = true;
				}
			}
			//specialmove castling queenside rook (roque grande, pois o rei est� do lado contr�rio ao da torre, torre anda 3 movimentos para trocar)
			Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
			if(testRookCastling(posT2)) { // testar se as demais casas da linha est�o vazias
				Position p1 = new Position(position.getRow(), position.getColumn() - 1);
				Position p2 = new Position(position.getRow(), position.getColumn() - 2);
				Position p3 = new Position(position.getRow(), position.getColumn() - 3);
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null ) {
					mat[position.getRow()][position.getColumn()-2] = true;
				}
			}
		}
		
		
		
		
		return mat;
		
		
	}
	

}
