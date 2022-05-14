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

    // goalPredicate

    public boolean goalPredicate(Search searcher) {
        EpuzzleSearch esearcher = (EpuzzleSearch) searcher;
        int[][] tar = esearcher.getTarget();  
        return Arrays.deepEquals(state,tar); 
    }
    

    // getSuccessors
    
    public ArrayList<SearchState> getSuccessors(Search searcher) {

        ArrayList<EpuzzleState> elist = new ArrayList<EpuzzleState>();
        ArrayList<SearchState> slist = new ArrayList<SearchState>();

        int rowPointer = 0;
        for(int[] x : state) {
            for(int y = 0; y < x.length; y++) {
                int[][] stateCopy = new int[state.length][3];

                //clones the state into a new array so it can be manipulated
                for(int i = 0; i < state.length; i++) {
                  stateCopy[i] = state[i].clone();
                }
                
                // check that 0 not in the bottom row and swaps 0 with the number below
                if (rowPointer != 0) {
                  if (state[rowPointer - 1][y] == 0) {
                    //standard code to swap 2 elements in an array
                    int placeholder = stateCopy[rowPointer][y];
                    stateCopy[rowPointer][y] = stateCopy[rowPointer - 1][y];
                    stateCopy[rowPointer - 1][y] = placeholder;
                    elist.add(new EpuzzleState(stateCopy));
                  }
                }

                // check that 0 is not in the top row and swaps 0 with the number above
                if (rowPointer != 2) {
                  if (state[rowPointer + 1][y] == 0) {
                    //standard code to swap 2 elements in an array
                    int placeholder = stateCopy[rowPointer][y];
                    stateCopy[rowPointer][y] = stateCopy[rowPointer + 1][y];
                    stateCopy[rowPointer + 1][y] = placeholder;
                    elist.add(new EpuzzleState(stateCopy));
                  }
                }

                // check that 0 is not in the right column and swaps 0 with the number to the right
                if (y != 2) {
                    if (x[y + 1] == 0) {
                      //standard code to swap 2 elements in an array
                      int placeholder = stateCopy[rowPointer][y];
                      stateCopy[rowPointer][y] = stateCopy[rowPointer][y + 1];
                      stateCopy[rowPointer][y + 1] = placeholder;
                      elist.add(new EpuzzleState(stateCopy));
          
                    }
                  }

                  // check that 0 is not in the left column and swaps 0 with the number to the left
                  if (y != 0) {
                    if (x[y - 1] == 0) {
                      //standard code to swap 2 elements in an array
                      int placeholder = stateCopy[rowPointer][y];
                      stateCopy[rowPointer][y] = stateCopy[rowPointer][y - 1];
                      stateCopy[rowPointer][y - 1] = placeholder;
                      elist.add(new EpuzzleState(stateCopy));
          
                    }
                  }
                }
                //increment the row pointer
                rowPointer++;
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
