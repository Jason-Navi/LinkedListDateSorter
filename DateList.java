import java.util.*;
import javax.swing.*;
import java.awt.*;
/**
 * Represents a list of DateNodes. Has a default constructor that initializes default values for the first DateNode, last DateNode and the length of the List 
 * Has an append method that adds a DateNode to the end of the List of DateNodes 
 * Has an insert method thats adds a DateNode into the list so that it sorts the list of nodes correctly
 */
public abstract class DateList
{
    //first node in the linked list which is a dummy node
    private DateNode first;

    //last node in the linked list
    private DateNode last;

    //number of data items in the linked list
    private int length;

    /**No arg constructor for DateList first and last are set to default DateNode (null) and length is set to 0*/
    public DateList(){
        first = new DateNode(null);
        last = first;
        length = 0;
    }
}
