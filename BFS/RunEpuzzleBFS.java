/*
 * run an 8-puzzle
 */

public class RunEpuzzleBFS {

    public static void main(String[] arg) {
        //add sth in the brackets
        EpuzzleSearch searcher = new EpuzzleSearch();
        SearchState initState = (SearchState) new EpuzzleState();

        // String resa = searcher.runSearch(initState, "Astar");
        //System.out.println(resa);
        String resb = searcher.runSearch(initState, "breadthFirst");
        System.out.println(resb);
        

    }
}
