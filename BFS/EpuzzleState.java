/*
 * State in an 8-puzzle search
 * 
 */
import java.util.*;
public class EpuzzleState extends SearchState {
    
    private int[][] state;


    /**
    * constructor
    * @param state //?
    */
    public EpuzzleState(int[][] s) {
        state = s;
    }

    /**
     * accessor for the current state
     * @return currState
     */
    public int[][] get_currState() {
        return state;
    }
    public boolean goalPredicate(Search searcher) {
        EpuzzleSearch esearcher = (EpuzzleSearch) searcher;
        int[][] tar = esearcher.getTarget(); // get target 
        return state == tar; 
    }
    /**
     * getSuccessors
     * 
     */
    private int[][] swapIndexes(int i2) { // (0;8)
        int i1 = 0;
        while(state[i1 / 3][i1 % 3] != 0){
            i1++;
        }
        if (i1 / 3 == i2 / 3) {
            if(Math.abs(i1 % 3 - i2 % 3) != 1) {
                System.out.println("wrong!");
                return null;                
            }
        }
        if (i1 % 3 == i2 % 3) {
            if(Math.abs(i1 / 3 - i2 / 3) != 1) {
                System.out.println("wrong!");     
                return null;           
            }
        }
        int[][] swappedState = state;
        swappedState[i1 / 3][i1 % 3] = swappedState[i2 / 3][i2 % 3];
        swappedState[i2 / 3][i2 % 3] = 0;
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
            elist.add(new EpuzzleState(swapIndexes))
        }
        //else if the 0 is in edge position a or b or c or d:



        //cast the puzzle states
        for(EpuzzleState es : elist) 
            slist.add((SearchState) es);
        return slist;

        /**
         * toString
         */
    }

    public boolean sameState(SearchState n2){

        //TODO
        return false;
    }
    public String toString() {
            return "8-puzzle State: ";
        
    }
}
