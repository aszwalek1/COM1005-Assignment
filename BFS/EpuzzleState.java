/*
 * State in an 8-puzzle search
 * 
 */
import java.util.*;
public class EpuzzleState extends SearchState {
    
    // current state
    private int[][] state;


    // constructor
    public EpuzzleState(int[][] s) {
        state = s;
    }

    // accessor for the current state
     
    public int[][] getState() {
        return state;
    }
    public boolean goalPredicate(Search searcher) {
        EpuzzleSearch esearcher = (EpuzzleSearch) searcher;
        int[][] tar = esearcher.getTarget();  
        return Arrays.deepEquals(state,tar); 
    }
    

    // getSuccessors
    
    public ArrayList<SearchState> getSuccessors(Search searcher) {

        ArrayList<EpuzzleState> elist = new ArrayList<EpuzzleState>();
        ArrayList<SearchState> slist = new ArrayList<SearchState>();

        int pos = 0;
        for(int[] x : state) {
            for(int y =  0; y < x.length; y++) {
                int[][] stateCopy = new int[state.length][3];

                for(int z = 0; z < state.length; z++) {
                    stateCopy[z] = state[z].clone();
                }
                
                // checks if position (j) is at extreme right

                if (y != 2) {
                    if (x[y + 1] == 0) {
                      int placeholder = stateCopy[pos][y];
                      stateCopy[pos][y] = stateCopy[pos][y + 1];
                      stateCopy[pos][y + 1] = placeholder;
                      elist.add(new EpuzzleState(stateCopy));
          
                    }
                  }
                  // checks if position (j) is at extreme left
                  if (y != 0) {
                    if (x[y - 1] == 0) {
                      int placeholder = stateCopy[pos][y];
                      stateCopy[pos][y] = stateCopy[pos][y - 1];
                      stateCopy[pos][y - 1] = placeholder;
                      elist.add(new EpuzzleState(stateCopy));
          
                    }
          
                  }
          
                  // checks if positon (j) is at the extreme bottom
                  if (pos != 2) {
                    if (state[pos + 1][y] == 0) {
                      int placeholder = stateCopy[pos][y];
                      stateCopy[pos][y] = stateCopy[pos + 1][y];
                      stateCopy[pos + 1][y] = placeholder;
                      elist.add(new EpuzzleState(stateCopy));
                    }
                  }
          
                  // checks if position (j) is at the extreme top
                  if (pos != 0) {
                    if (state[pos - 1][y] == 0) {
                      int placeholder = stateCopy[pos][y];
                      stateCopy[pos][y] = stateCopy[pos - 1][y];
                      stateCopy[pos - 1][y] = placeholder;
                      elist.add(new EpuzzleState(stateCopy));
                    }
                  }
          
                }
                pos++;
            }
            
        //cast the puzzle states
        for(EpuzzleState es : elist) 
            slist.add((SearchState) es);
        return slist;
    }

    public boolean sameState(SearchState n2) {

        EpuzzleState e2 = (EpuzzleState) n2;

        return Arrays.deepEquals(state, e2.state);
    }
    public String toString() {
        String s = "\n";

        for(int i = 0; i < state.length; i++) {
            for(int k = 0; k < state[i].length; k++) {
                s += state[i][k] + " ";
            }
            s += "\n";
        }
        return s;
    
    }
}
