package gapp.ulg.test;

import gapp.ulg.game.board.*;
import gapp.ulg.Utilities.UsefulMethods;
import gapp.ulg.games.Scacchi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;

/**
 * Created by Edoardo on 08/08/2016.
 */
public class ScacchiTest {
    public static void main(String[] args){

        // testPawnMove2Steps();
        //testMoveScacchi();
        // /testValidMovesScacchi();
        testValidMovesBishop();
    }

    public static void testValidMovesBishop(){
        Scacchi match = new Scacchi(-1, "Sara", "Edoardo");
        match.move(new Move<>(new Action(Board.Dir.UP, 2, new Pos(4, 1))));
        List<Move<PieceModel<PieceModel.Species>>> validMoves = new ArrayList<>(match.validMoves());
        validMoves.remove(new Move<PieceModel<PieceModel.Species>>(Move.Kind.RESIGN));
        Move<PieceModel<PieceModel.Species>> moveChoosen = validMoves.get(new Random().nextInt(validMoves.size()));
        match.move(moveChoosen);
        match.printBoard();
        match.printAllValidMoves();
        match.move(new Move<>(new Action(Board.Dir.UP_L, 5, new Pos(5, 0))));
        match.printBoard();
    }

    public static void testCalcPos( BiFunction<Pos, Board.Dir, Pos> adjacentFunction){
        Pos startPos = new Pos(1, 0);
        System.out.println(UsefulMethods.calcPos(startPos, adjacentFunction, Board.Dir.UP, 2));
    }

    public static void testPawnMove2Steps(){
        Scacchi match = new Scacchi(-1, "Sara", "Edoardo");
        match.move(new Move<>(new Action(Board.Dir.UP, 2, new Pos(4, 1))));
        match.printBoard();
    }

    public static void testValidMovesScacchi(){
        Scacchi match = new Scacchi(-1, "Sara", "Edoardo");
        match.printBoard();
        match.printAllValidMoves();

        // Esito: 1° TURNO GIUSTO
    }

    public static void testMoveScacchi(){
        Scacchi match = new Scacchi(-1, "Sara", "Edoardo");
        match.printBoard();
        List<Move<PieceModel<PieceModel.Species>>> validMoves = new ArrayList<>(match.validMoves());
        validMoves.remove(new Move<PieceModel<PieceModel.Species>>(Move.Kind.RESIGN));
        Move<PieceModel<PieceModel.Species>> moveChoosen = validMoves.get(new Random().nextInt(validMoves.size()));
        System.out.println("MOSSA SCELTA: " + moveChoosen);
        match.move(moveChoosen);
        match.printBoard();
        match.printAllValidMoves();
    }

    public static void testScacchiTree(){
        Scacchi match = new Scacchi(-1, "Sara", "Edoardo");

    }
}
