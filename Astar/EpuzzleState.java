/*
 * State in an 8-puzzle search
 * 
 */
import java.util.*;
public class EpuzzleState extends SearchState {
    
    // current state
    private int[][] state;
    String method = "manhattan";

    // constructor
    public EpuzzleState(int[][] s, int rc) {
        state = s;
        estRemCost = rc;
        localCost = 1;
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
    public static int manhattan(int[][] s, int[][] t) {
      int d = 0;
      int si = 0;
      int sj = 0;

      for(int n = 1; n <= 8; ++n) {
         int i;
         int j;
         for(i = 0; i <= 2; ++i) {
            for(j = 0; j <= 2; ++j) {
               if (s[i][j] == n) {
                  si = i;
                  sj = j;
               }
            }
         }

         for(i = 0; i <= 2; ++i) {
            for(j = 0; j <= 2; ++j) {
               if (t[i][j] == n) {
                  d = d + Math.abs(i - si) + Math.abs(j - sj);
               }
            }
         }
      }
      return d;
   }

    public static int hamming(int[][] stateCopy) {
      int[][] tar = {{1,2,3}, {4,5,6}, {7,8,0}}; 
      int value = 0;

      for(int i = 0; i < 3; i++) {
        for(int k = 0; k < 3; k++) {
          if(stateCopy[i][k] != tar[i][k] && stateCopy[i][k] != 0) {
            value++;
          }
        }
      }
      return value;
    }


    public ArrayList<SearchState> getSuccessors(Search searcher) {

        ArrayList<EpuzzleState> elist = new ArrayList<EpuzzleState>();
        ArrayList<SearchState> slist = new ArrayList<SearchState>();
        EpuzzleSearch esearcher = (EpuzzleSearch) searcher;
      

        int pos = 0;
        for(int[] x : state) {
            for(int y =  0; y < x.length; y++) {
                int[][] stateCopy = new int[state.length][3];

                for(int z = 0; z < state.length; z++) {
                  stateCopy[z] = state[z].clone();
                }
                
                // checks if the position is at the extreme right
                if (y != 2) {
                  if (x[y + 1] == 0) {
                    int placeholder = stateCopy[pos][y];
                    stateCopy[pos][y] = stateCopy[pos][y + 1];
                    stateCopy[pos][y + 1] = placeholder;
                    if(method == "manhattan") {
                      elist.add(new EpuzzleState(stateCopy, manhattan(stateCopy, esearcher.getTarget())));
                    }
                    else {
                      elist.add(new EpuzzleState(stateCopy, hamming(stateCopy)));

                    }
                  }
                }

                // checks if the position is at the extreme left
                if (y != 0) {
                  if (x[y - 1] == 0) {
                    int placeholder = stateCopy[pos][y];
                    stateCopy[pos][y] = stateCopy[pos][y - 1];
                    stateCopy[pos][y - 1] = placeholder;
                    if(method == "manhattan") {
                      elist.add(new EpuzzleState(stateCopy, manhattan(stateCopy, esearcher.getTarget())));
                    }
                    else {
                      elist.add(new EpuzzleState(stateCopy, hamming(stateCopy)));

                    }          
                  }
                }
      
                // checks if the position is at the extreme top
                if (pos != 0) {
                  if (state[pos - 1][y] == 0) {
                    int placeholder = stateCopy[pos][y];
                    stateCopy[pos][y] = stateCopy[pos - 1][y];
                    stateCopy[pos - 1][y] = placeholder;
                    if(method == "manhattan") {
                      elist.add(new EpuzzleState(stateCopy, manhattan(stateCopy, esearcher.getTarget())));
                    }
                    else {
                      elist.add(new EpuzzleState(stateCopy, hamming(stateCopy)));

                    }
                  }
                }

                // checks if the positon is at the extreme bottom
                if (pos != 2) {
                  if (state[pos + 1][y] == 0) {
                    int placeholder = stateCopy[pos][y];
                    stateCopy[pos][y] = stateCopy[pos + 1][y];
                    stateCopy[pos + 1][y] = placeholder;
                    if(method == "manhattan") {
                      elist.add(new EpuzzleState(stateCopy, manhattan(stateCopy, esearcher.getTarget())));
                    }
                    else {
                      elist.add(new EpuzzleState(stateCopy, hamming(stateCopy)));

                    }                    
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
