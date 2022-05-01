/*
 * run an 8-puzzle
 */

public class RunEpuzzleBFS {

    public static void main(String[] arg) {
        

        // generator given seed
        int seed = 5743;
        EpuzzGen gen = new EpuzzGen(seed);
        // generate puzzle providing difficulty
        int d = 6;
        int[][] puzz = gen.puzzGen(d);

        EpuzzleSearch searcher = new EpuzzleSearch();
        SearchState p1 = (SearchState) new EpuzzleState(puzz);
        SearchState p2 = (SearchState) new EpuzzleState(new int[][]{{1,0,3},{4,2,6},{7,5,8}});
        SearchState p3 = (SearchState) new EpuzzleState(new int[][]{{4,1,3},{7,2,5},{0,8,6}});
        SearchState p4 = (SearchState) new EpuzzleState(new int[][]{{2,3,6},{1,5,8},{4,7,0}});

        String resb1 = searcher.runSearch(p1, "breadthFirst");
        String resb2 = searcher.runSearch(p2, "breadthFirst");
        String resb3 = searcher.runSearch(p3, "breadthFirst");
        String resb4 = searcher.runSearch(p4, "breadthFirst");
        

        System.out.println(resb1);

        
        // ---- Uncomment to test ----
        
        // System.out.println(resb2);
        // System.out.println(resb3);
        // System.out.println(resb4);


    }
}
