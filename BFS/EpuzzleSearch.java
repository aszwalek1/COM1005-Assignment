/* 
 * search for 8-puzzle
 */
public class EpuzzleSearch extends Search {

    private int[][] target;

    /**
     * constructor
     * @param tar
     * 
     */

    public EpuzzleSearch() {
        target = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
    }

    /**
    * accessor for target
    */
    public int[][] getTarget() {
        return target;
    }
    
}
