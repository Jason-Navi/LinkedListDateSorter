
/**
 * Respresents a list of sorted date note object and extends DateList
 * List of sorted dates in the order they were read from the file.
 */
public class SortedDateList extends DateList
{
    //first node in the linked list which is a dummy node
    private DateNode first;

    //last node in the linked list
    private DateNode last;

    //number of data items in the linked list
    private int length;

    /**No arg constructor for DateList first and last are set to default DateNode (null) and length is set to 0*/
    public SortedDateList(){
        //super();
        first = new DateNode(null);
        last = first;
        length = 0;
    }

    /**Inserts a new node to the list by sorting it*/
    public void add(Date212 d){
        //Create a new DateNode using the Date212 object given in the parameter 
        DateNode n = new DateNode(d);

        //Create a new DateNode and increment it one from the first Node so you are not looking at the dummy node
        DateNode p = first.next;

        //Create a temp DateNode initially equal to null to hold the previous position of var "p"'s Node
        DateNode temp = first;

        /*While you still have an object inside the linked list and the date inside the objects are sorted keep
        looping. In each iteration make temp equal to p and then increment p by one. This way you will have 
        the previous and current node to access when you are inserting the Node into the correct order*/
        while(p != null && p.data.toString().compareTo(n.data.toString()) > 0){
            temp = p;
            p = p.next; 
        }
        //the pointer of the Node you are trying to insert will point to Node p to keep everything sorted
        n.next = p;

        //the previous node's pointer will point to the Node you are inserting. Note you are inserting the Node in between the Node before p and p itself.
        temp.next = n;

        //increment the length by one since you just added a node to the list
        length++;
    }

    /**Adds a Node to the beginning of a SortedDateList to allow for the add method to sort properly*/
    public void initialize(Date212 d){
        //Create a new DateNode using the Date212 object given in the parameter 
        DateNode n = new DateNode(d);
        //make the pointer of the last Node point to the new DateNode just created
        last.next = n;
        //Make the "last" var which is the last Node now equal to the new DateNode just created
        last = n;
        //increment the length by one since you just added a new Node to the list
        length++;
    }

    /**return all the dates inside the linked list*/
    public String getList(){
        //create a String "allDates" that will concatenate all the dates
        String allDates = "";

        //Create a new DateNode and increment it one from the first Node so you are not looking at the dummy node
        DateNode p = first.next;

        //Loop through the var "p" which represents a DateNode until you have gone through all Node's in the List
        while (p != null){
            //Add the data inside node "p" which represents the date to allDates and increment to the next Node
            allDates += p.data;
            p = p.next;
        }

        //return the String with all the dates inside
        return allDates;
    } 
}
