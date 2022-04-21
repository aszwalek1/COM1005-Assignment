/*
 * run an 8-puzzle
 */

public class RunEpuzzleBFS {

    public static void main(String[] arg) {
        //add sth in the brackets:
        EpuzzleSearch searcher = new EpuzzleSearch();
        SearchState initState = (SearchState) new EpuzzleState();

        //String resd = searcher.runSearch(initState, "depthFirst");
        //System.out.println(resd);
        String resb = searcher.runSearch(initState, "breadthFirst");
        System.out.println(resb);
        //Add the code for the tests :
        // 1,0,3,4,2,6,7,5,8
        // 4,1,3,7,2,5,0,8,6
        // 2,3,6,1,5,8,4,7,0

    }
}
