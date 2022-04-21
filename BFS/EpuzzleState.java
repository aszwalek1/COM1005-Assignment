/*
 * State in an 8-puzzle search
 * 
 */
import java.util.*;
public class EpuzzleState extends SearchState {
    
    private int currentState;
    /**
    * constructor
    * @param currState //?
    */
    public EpuzzleState(int currState) {
        currentState = currState;
    }

    /**
     * accessor for the current state
     * @return currState
     */
    public int get_currState() {
        return currState;
    }
    public boolean goalPredicate(Search searcher) {
        EpuzzleSearch esearcher = (EpuzzleSearch) searcher;
        int tar = esearcher.getTarget(); // get target amount
        return currentState == tar; //change this
    }
    /**
     * getSuccessors
     * 
     */
    public ArrayList<SearchState> getSuccessors(Search searcher) {
        EpuzzleSearch esearcher = (EpuzzleSearch) searcher;
        /*

        */
        ArrayList<EpuzzleState> elist = new ArrayList<EpuzzleState>();
        ArrayList<SearchState> slist = new ArrayList<SearchState>();

        //how the whole game works:




        //cast the puzzle states
        for(EpuzzleState es : elist) 
            slist.add((SearchState) es);
        return slist;

        /**
         * toString
         */
        public String toString() {
            return "8-puzzle State: ";
        }
    }
}
