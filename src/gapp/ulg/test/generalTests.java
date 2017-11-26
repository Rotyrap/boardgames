package gapp.ulg.test;

import gapp.ulg.game.board.Action;
import gapp.ulg.game.board.Move;
import gapp.ulg.game.board.PieceModel;
import gapp.ulg.game.board.Pos;
import gapp.ulg.game.board.*;
import gapp.ulg.Utilities.Node;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import gapp.ulg.game.board.PieceModel.Species;
import gapp.ulg.game.util.BoardOct;
import gapp.ulg.game.util.MyChooser;
import gapp.ulg.game.util.PlayerGUI;

import static gapp.ulg.game.board.Action.Kind.ADD;
import static gapp.ulg.game.board.Action.Kind.SWAP;


/**
 * Created by Edoardo on 16/07/2016.
 */
public class generalTests {
    public static void main(String[] args){
        //test1();
        //test2();
        //testSubString();
        //testgenTree();
        //testLucaStronzo();
        //testList();
        //testOptional();
        //toArray();
        provaAlbero();
        //testListToMapWithLambda();
        //testList2();
    }

    public static void testSubString(){
        String prova = "Lucaèstronzo";
        System.out.println("Da 0 a 2: " + prova.substring(0, 2));
        System.out.println("Da 2 a 5: " + prova.substring(2, 5));
        System.out.println("Da 6 a 8: " + prova.substring(6, 8));
    }

    public static void testListToMapWithLambda(){
        ArrayList<String> alphabet = new ArrayList<>(Arrays.asList("ciao", "come", "va", "tutto", "ok", "?"));
        Map<Integer, String> map = IntStream.range(0, alphabet.size())
                .boxed()
                .collect(Collectors.toMap(Function.identity(), alphabet::get));

        System.out.println(map.get(0) + " | " + map.get(3));
    }

    public static void testList2(){
        ArrayList<String> trys = new ArrayList<>();
        trys.set(2, "ciao");
        System.out.println("ciao");
    }

    public static void toArray(){
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList("ciao", "come", "va", "tutto", "ok", "?"));

        String[] stringArray = stringList.stream().toArray(String[]::new);
        System.out.println(stringArray.length);
        for (String s : stringArray) {
            System.out.print(s + ", ");
        }
    }

    public static void testOptional(){
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList("ciao", "come", "va", "tutto", "ok", "?"));
        Optional<String> stringOptional = stringList.stream().filter(string -> string.equals("ciaoo")).findFirst();
        if(!stringOptional.isPresent()) System.out.println("La stringa non è presente");
        else System.out.println(stringOptional.get());
    }

    public static void testList(){
        System.out.println("Subtest 1: ");
        List<Integer> father = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> child = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> result = child.subList(father.size(), child.size());
        System.out.println(result);
        System.out.println("--------------------------------------------------");

        System.out.println("Subtest 2: ");
        List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> secondList = new ArrayList<>();
        intList.forEach(intero -> secondList.add(intero*2));
        System.out.println(secondList);


        ArrayList arrlst = new ArrayList();

        // populate the list
        arrlst.add("A");
        arrlst.add("B");
        arrlst.add("C");
        arrlst.add("D");
        arrlst.add("E");

        System.out.println("The initial list is :"+arrlst);

        ArrayList newrr = (ArrayList) arrlst.clone();
        // reverse the list

        int num=newrr.size()-1;
        ArrayList trys = new ArrayList();
        IntStream.rangeClosed(0, num).mapToObj(i->newrr.get(num-i)).forEach(trys::add);

        Collections.reverse(newrr);

        System.out.println("The Reverse List is :"+newrr);
        System.out.println(trys);
    }

    public static void testgenTree() {
        /*ArrayList<ArrayList<Action<P>>> allActionList = new ArrayList<>();
        validMoves.forEach((move) -> {
            allActionList.add((ArrayList<Action<P>>) move.actions);
        });*/

        Action<PieceModel<Species>> Action1 = new Action<>(new Pos(1,0), new Pos(1,1));
        Action<PieceModel<Species>> Action2 = new Action<>(new Pos(2,0), new Pos(2,1));
        Action<PieceModel<Species>> Action3 = new Action<>(new Pos(3,0), new Pos(3,1));
        Action<PieceModel<Species>> Action4 = new Action<>(new Pos(4,0), new Pos(4,1));
        Action<PieceModel<Species>> Action5 = new Action<>(new Pos(5,0), new Pos(5,1));
        Action<PieceModel<Species>> Action6 = new Action<>(new Pos(6,0), new Pos(6,1));

        ArrayList<Action<PieceModel<Species>>> m1 = new ArrayList<>(Arrays.asList(Action1, Action2, Action3, Action5));
        ArrayList<Action<PieceModel<Species>>> m2 = new ArrayList<>(Arrays.asList(Action4, Action2, Action3, Action1));
        ArrayList<Action<PieceModel<Species>>> m3 = new ArrayList<>(Arrays.asList(Action1, Action2, Action5, Action6));

        Node root = Node.genTree(new ArrayList<>(Arrays.asList(m1, m2, m3)));

        Node firstChildNode = (Node) root.getChildNodes().get(1);


        root.printTree();


    }

    public static void test1(){
        List<String> first = new ArrayList<>(Arrays.asList("Edoardo", "Sara"));
        List<String> second = new ArrayList<>(Arrays.asList("Edoardo", "Sara"));
        System.out.println(first.equals(second));
    }


    public static void test2(){
        List<String> list1 = new ArrayList<>(Arrays.asList("ciao", "come", "va"));
        List<String>  list2 = new ArrayList<>();
        List<String>  list3 = new ArrayList<>(Arrays.asList("ciao", "come", "va", "tutto"));
        List<List<String>> allList = new ArrayList<>();
        allList.addAll(Arrays.asList(list1, list2, list3));

        int min = Integer.MAX_VALUE;
        int listIndex = 0;
        for(List<String> list : allList){
            if(min > list.size()){
                min = list.size();
                listIndex = allList.indexOf(list);
            }
        }


        int index = 0;
        boolean same = true;
        while(index<min && same == true) {

            String element = allList.get(listIndex).get(index);
            for(List<String> list : allList){
                if(!list.get(index).equals(element)){
                    same = false;
                    break;
                }
                element = allList.get(listIndex).get(index);
            }
            if(same == true) ++index;
        }
        System.out.println("OUTPUT:" + allList.get(listIndex).subList(0, index));

        System.out.println("OUTPUT 2: " + biggestSubList(allList));
    }

    public static List<String> biggestSubList(List<List<String>> allList){

        int min = Integer.MAX_VALUE;
        for (List<String> currentList : allList) {
            min = Math.min(min, currentList.size());
        }
        int index = 0;

        List<String> result = new ArrayList<>();

        while(index<min) {
            Set<String> setForIndex = new HashSet<>();
            for(List<String> list : allList){
                setForIndex.add(list.get(index));
            }
            if(setForIndex.size() > 1) return result;
            index++;
            result.add(setForIndex.iterator().next());
        }
        return result;
    }

    public static void testLucaStronzo(){
        PieceModel<Species> blackdisc = new PieceModel<>(Species.DISC, "nero");
        Action<PieceModel<Species>> add = new Action<>(new Pos(0, 0), blackdisc);
        Action<PieceModel<Species>> swap = new Action<PieceModel<Species>>(blackdisc, new Pos(0,0), new Pos(3, 0));

        Move<PieceModel<Species>> move1 = new Move<>(Arrays.asList(add, swap, swap, add));
        Move<PieceModel<Species>> move2 = new Move<>(Arrays.asList(swap, add, swap, add));
        List<Move<PieceModel<Species>>> movesList = new ArrayList<>(Arrays.asList(move1, move2, move1, move2));

        boolean allADDorAllSwap = movesList.stream().allMatch(move -> move.actions.get(0).kind == ADD) || movesList.stream().allMatch(move -> move.actions.get(0).kind == SWAP);

        System.out.println(allADDorAllSwap);

    }
    
    public static void provaAlbero() {
        Pos p1 = new Pos(1,1);
        Pos p2 = new Pos(2,2);
        Pos p3 = new Pos(3,3);
        Pos p4 = new Pos(4,4);
        Pos p5 = new Pos(5, 5);
        Action<PieceModel<Species>> jump1 = new Action<>(p1, p2);
        Action<PieceModel<Species>> jump2 = new Action<>(p2, p3);
        Action<PieceModel<Species>> swap1 = new Action<>(new PieceModel<Species>(Species.KING, "bianco"), p3);
        Action<PieceModel<Species>> jump3 = new Action<PieceModel<Species>>(p3, p4);
        Action<PieceModel<Species>> jump4 = new Action<PieceModel<Species>>(p4, p1);
        Action<PieceModel<Species>> move2 = new Action<PieceModel<Species>>(Board.Dir.UP_R, 1, p2);    
        Action<PieceModel<Species>> move3 = new Action<PieceModel<Species>>(Board.Dir.UP_R, 1, p3);
        Action<PieceModel<Species>> swap4 = new Action<PieceModel<Species>>(new PieceModel<Species>(Species.KING, "bianco"), p4);
        Action<PieceModel<Species>> remove4 = new Action<>(p4);
        Action<PieceModel<Species>> remove5 = new Action<>(p5);
        Action<PieceModel<Species>> swap42 = new Action<>(new PieceModel<Species>(Species.QUEEN, "bianco"), p4);
        
        
        List<Move<PieceModel<Species>>> validMoves = new ArrayList<>();
        
        validMoves.add(new Move<>(jump1, jump2, swap1));
        validMoves.add(new Move<>(jump1, jump2, jump3, jump4));
        validMoves.add(new Move<>(jump1, move2, move3));
        validMoves.add(new Move<>(jump1, move2, move3, swap4)); 
        validMoves.add(new Move<>(jump1, move2, move3, swap4, remove4));
        validMoves.add(new Move<>(jump1, move2, move3, swap4, remove5));
        validMoves.add(new Move<>(jump1, move2, move3, swap42));

        ArrayList<Action> a = new ArrayList<>();
        for (int i = 0; i < 1000; i++) a.add(move2);
        validMoves.add(new Move<>(a.toArray(new Action[a.size()])));
        a.add(jump4);
        for (int i = 0; i < 5; i++) a.add(jump3);
        a.add(jump4);
        validMoves.add(new Move<>(a.toArray(new Action[a.size()])));


        GameRuler<PieceModel<Species>> gR = new GameRuler<PieceModel<Species>>() {
            @Override
            public String name() {
                return "Porco Dio";
            }

            @Override
            public <T> T getParam(String name, Class<T> c) {
                return null;
            }

            @Override
            public List<String> players() {
                return new ArrayList<>(Arrays.asList("Bestemmiatore 1", "Bestemmiatore 2"));
            }

            @Override
            public String color(String name) {
                return "Rosa maiale come il dio maiale";
            }

            @Override
            public Board<PieceModel<Species>> getBoard() {
                return new BoardOct<PieceModel<Species>>(10, 10);
            }

            @Override
            public int turn() {
                return 1;
            }

            @Override
            public boolean move(Move<PieceModel<Species>> m) {
                return false;
            }

            @Override
            public boolean unMove() {
                return false;
            }

            @Override
            public boolean isPlaying(int i) {
                return false;
            }

            @Override
            public int result() {
                return -1;
            }

            @Override
            public Set<Move<PieceModel<Species>>> validMoves() {
                HashSet<Move<PieceModel<Species>>> hS = new HashSet<>(validMoves);
                //hS.forEach(m -> System.out.println(m));
                //System.out.println(hS.size());
                return hS;
            }

            @Override
            public GameRuler<PieceModel<Species>> copy() {
                return null;
            }
        };

        long start = System.currentTimeMillis();
        MyChooser myChooser = new MyChooser(gR);
        //for(int i = 0; i < 100000; i++) {
            //myChooser = new MyChooser(gR);
        //}
        for (int i = 0; i < 10000; i++) {
            myChooser.select(p2);
            myChooser.moveSelection(Board.Dir.UP_R, 1);
            myChooser.select(p4);
            myChooser.jumpSelection(p1);
            myChooser.back();
            myChooser.back();
            //myChooser.jumpSelection(p1);
            //myChooser.back();
            //myChooser.back();
            
            //myChooser.select(p3);
            //myChooser.jumpSelection(p4);
            //myChooser.back();
        }
        myChooser.currentNode.printTree();
        System.out.println("Tempo di esecuzione: " + (System.currentTimeMillis() - start));
    }
}
