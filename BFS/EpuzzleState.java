/*
 * State in an 8-puzzle search
 * 
 */
import java.util.*;
public class EpuzzleState extends SearchState {
    
    private int[][] state;


    /**
    * constructor
    * @param state 
    */
    public EpuzzleState(int[][] s) {
        state = s;
    }

    /**
     * accessor for the current state
     * @return state
     */
    public int[][] getState() {
        return state;
    }
    public boolean goalPredicate(Search searcher) {
        EpuzzleSearch esearcher = (EpuzzleSearch) searcher;
        int[][] tar = esearcher.getTarget();  
        return state == tar; 
    }
    /**
     * getSuccessors
     * 
     */
    private int[][] swapIndexes(int i2) { // (0;8)
        int i1 = 0;
        while(state[i1 / 3][i1 % 3] != 0) {
            i1++;
        }
        
        int[][] swappedState = new int[3][3]; 
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                swappedState[i][j] = state[i][j];
            }
        }
        swappedState[i1 / 3][i1 % 3] = swappedState[i2 / 3][i2 % 3];
        swappedState[i2 / 3][i2 % 3] = 0;
        System.out.println("SwappedState: \n" 
        + swappedState[0][0] + " " + swappedState[0][1] + " " + swappedState[0][2] + "\n" 
            + swappedState[1][0] + " " + swappedState[1][1] + " " + swappedState[1][2] + "\n"
            + swappedState[2][0] + " " + swappedState[2][1] + " " + swappedState[2][2] + "\n"
        );
        return swappedState;
    } 

    public ArrayList<SearchState> getSuccessors(Search searcher) {
        EpuzzleSearch esearcher = (EpuzzleSearch) searcher;

        ArrayList<EpuzzleState> elist = new ArrayList<EpuzzleState>();
        ArrayList<SearchState> slist = new ArrayList<SearchState>();

        //how the whole game works:

        //if the 0 in state is in corner position a or b or c or d:
            //add successors for swapping 0 out of the corner
        if (state[0][0] == 0) {
            elist.add(new EpuzzleState(swapIndexes(1)));
            elist.add(new EpuzzleState(swapIndexes(3)));
        }
        else if (state[0][1] == 0) {
            elist.add(new EpuzzleState(swapIndexes(0)));
            elist.add(new EpuzzleState(swapIndexes(2)));
            elist.add(new EpuzzleState(swapIndexes(4)));
        }
        else if (state[0][2] == 0) {
            elist.add(new EpuzzleState(swapIndexes(1)));
            elist.add(new EpuzzleState(swapIndexes(5)));
        }
        else if (state[1][0] == 0) {
            elist.add(new EpuzzleState(swapIndexes(0)));
            elist.add(new EpuzzleState(swapIndexes(4)));
            elist.add(new EpuzzleState(swapIndexes(6)));
        }
        else if (state[1][1] == 0) {
            elist.add(new EpuzzleState(swapIndexes(1)));
            elist.add(new EpuzzleState(swapIndexes(3)));
            elist.add(new EpuzzleState(swapIndexes(5)));
            elist.add(new EpuzzleState(swapIndexes(7)));
        }
        else if (state[1][2] == 0) {
            elist.add(new EpuzzleState(swapIndexes(2)));
            elist.add(new EpuzzleState(swapIndexes(4)));
            elist.add(new EpuzzleState(swapIndexes(8)));
        }
        else if (state[2][0] == 0) {
            elist.add(new EpuzzleState(swapIndexes(3)));
            elist.add(new EpuzzleState(swapIndexes(7)));
        }
        else if (state[2][1] == 0) {
            elist.add(new EpuzzleState(swapIndexes(4)));
            elist.add(new EpuzzleState(swapIndexes(6)));
            elist.add(new EpuzzleState(swapIndexes(8)));

        }
        else if (state[2][2] == 0) {
            elist.add(new EpuzzleState(swapIndexes(5)));
            elist.add(new EpuzzleState(swapIndexes(7)));
        }


        //cast the puzzle states
        for(EpuzzleState es : elist) 
            slist.add((SearchState) es);
        return slist;

        
    }

    public boolean sameState(SearchState n2) {

        EpuzzleState e2 = (EpuzzleState) n2;

        return Arrays.equals(state[0], e2.getState()[0]) &&
        Arrays.equals(state[1], e2.getState()[1]) &&
        Arrays.equals(state[2], e2.getState()[2]) ;
    }
    public String toString() {
            return "\n"
            + state[0][0] + " " + state[0][1] + " " + state[0][2] + "\n" 
            + state[1][0] + " " + state[1][1] + " " + state[1][2] + "\n"
            + state[2][0] + " " + state[2][1] + " " + state[2][2] + "\n"
            ;
    }
}
