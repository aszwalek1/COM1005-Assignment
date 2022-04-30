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
    public int[][] getState() {
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

        /**
         * toString
         */
    }

    public boolean sameState(SearchState n2) {

        EpuzzleState e2 = (EpuzzleState) n2;

        return state == e2.getState();
    }
    public String toString() {
            return "8-puzzle State: \n" 
            + state[0].toString() + "\n" 
            + state[1].toString() + "\n"
            + state[2].toString() + "\n"
            ;
        
    }
}
