/* 
 * search for 8-puzzle
 */
public class EpuzzleSearch extends Search {

    private int order; //?
    private int target;

    /**
     * constructor
     * @param ord //?
     * @param tar
     * 
     */
    public EpuzzleSearch(){}

    public EpuzzleSearch(int tar, int ord) {
        order = ord;
        target = tar;
    }

    /**
    * accessor for order
    */
    public int getOrder() {
        return order;
    }
    
    /**
    * accessor for target
    */
    public int getTarget() {
        return target;
    }
    
}
