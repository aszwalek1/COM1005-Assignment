import java.util.EnumSet;

public class RunEpuzzleAstar {
    public static void main(String[] arg) {


        // generator given seed
        int seed = 625;
        EpuzzGen gen = new EpuzzGen(seed);
        // generate puzzle providing difficulty
        int d = 6;
        int[][] puzz = gen.puzzGen(d);
        EpuzzleSearch searcher = new EpuzzleSearch();

        SearchState p1 = (SearchState) new EpuzzleState(puzz, EpuzzleState.hamming(puzz));

        //SearchState p1 = (SearchState) new EpuzzleState(puzz, EpuzzleState.manhattan(puzz, searcher.getTarget()));
        
        String test1 = searcher.runSearch(p1, "Astar");
        System.out.println(test1);

    }
}
