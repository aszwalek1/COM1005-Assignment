/*
 * run an 8-puzzle
 */

public class RunEpuzzleBFS {

    public static void main(String[] arg) {

        EpuzzleSearch searcher = new EpuzzleSearch();
        
        SearchState p1 = (SearchState) new EpuzzleState(new int[][]{{1,0,3},{4,2,6},{7,5,8}});
        //SearchState p2 = (SearchState) new EpuzzleState(new int[][]{{4,1,3},{7,2,5},{0,8,6}});
        //SearchState p3 = (SearchState) new EpuzzleState(new int[][]{{2,3,6},{1,5,8},{4,7,0}});

        String test1 = searcher.runSearch(p1, "breadthFirst");
        //String test2 = searcher.runSearch(p3, "breadthFirst");
        //String test3 = searcher.runSearch(p4, "breadthFirst");
        
        // ---- Uncomment to test ----
        
        System.out.println(test1);
        //System.out.println(test2);
        //System.out.println(test3);

    }
}
