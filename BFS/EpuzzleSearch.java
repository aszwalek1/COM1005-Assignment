/* 
 * search for 8-puzzle
 */
public class EpuzzleSearch extends Search {

    private int target;

    public String getGoal() {
        return goal;
    }
    public EpuzzleSearch(int tar) {
        target = tar;
    }
    /**
    * accessor for target
    */
    public int getTarget() {
        return target;
    }
}
