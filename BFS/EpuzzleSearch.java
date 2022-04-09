/* 
 * search for 8-puzzle
 */
public class EpuzzleSearch extends Search {
    //private Carta map;
    private String goal;
    //there was a getMap()

    public String getGoal() {
        return goal;
    }
    public EpuzzleSearch(String g) {
        //map = m;
        goal = g;
    }
}
