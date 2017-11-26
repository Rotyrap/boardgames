package gapp.ulg.test;

import gapp.ulg.game.board.*;
import gapp.ulg.games.MyCamelot;

import java.util.ArrayList;

/**
 * Created by Edoardo on 30/08/2016.
 */
public class CameloTest {
    public static void main(String[] args){
        testMove1();
    }

    public static void testMove1(){
        MyCamelot match = new MyCamelot(-1, "Edoardo", "LucaPezzolo");
        match.printBoard();
        match.move(new Move<>(new Action(Board.Dir.UP, 1, new Pos(4, 6))));
        match.move(new Move<>(new Action(Board.Dir.DOWN, 1, new Pos(4, 9))));
        ArrayList<Move<PieceModel<PieceModel.Species>>> validMoves = new ArrayList<>(match.validMoves());
        validMoves.remove(new Move<PieceModel<PieceModel.Species>>(Move.Kind.RESIGN));

        System.out.println("----------------> VALIDMOVES <---------------");
        int i = 1;
        for(Move m : match.validMoves()){
            System.out.println(i + ") " + m);
            i++;
        }
        System.out.println("----------------> FINE VALIDMOVES <---------------");
        validMoves.forEach(move -> {
            if(move.actions.get(0).pos.get(0).equals(new Pos(4, 7))) System.out.println("Mossa in posizione 4, 7 trovata: " + move);
        });

        //match.move(new Move<>(new Action(new Pos(4, 7), new Pos(4, 9), new Pos(4, 8))));
        match.printBoard();
    }
}
