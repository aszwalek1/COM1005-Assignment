/*
 * State in am 8-puzzle search
 * 
 */
import java.util.*;
public class EpuzzleState extends SearchState {
    private int currentState;

    public EpuzzleState(int currState) {
        currentState = currState;
    }
    public int get_currState() {
        return currState;
    }
    public boolean goalPredicate(Search searcher) {
        EpuzzleSearch esearcher = (EpuzzleSearch) searcher;
        int tar = esearcher.getTarget();
        return currentState == tar;
    }
    public ArrayList<SearchState> getSuccessors(Search searcher) {
        EpuzzleSearch esearcher = (EpuzzleSearch) searcher;
        
        ArrayList<EpuzzleState> elist = new ArrayList<EpuzzleState>();
        ArrayList<SearchState> slist = new ArrayList<SearchState>();

        //how the whole game works:

        for(EpuzzleState es : elist) 
            slist.add((SearchState) es);
        return slist;

        public String toString() {
            return "8-puzzle State: ";
        }
    }
}
