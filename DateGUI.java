import java.util.*;
import javax.swing.*;
import java.awt.*;
/**
 * Initializes and declares a GUI to create a split grid layout. 
 * The left side representing the unsorted dates and the right side representing the sorted dates in dd/mm/yyyy order.
 */
public class DateGUI extends JFrame
{
    //declare a JFrame, a containter, and two TextAreas to put inside the container
    JFrame myFrame;
    Container cPane; 
    TextArea leftCol, rightCol;

    /**Initialize GUI to default values*/
    public DateGUI(){
        //initialize the JFrame
        myFrame = new JFrame();
        //Create and set up a window to default values.
        myFrame.setTitle("");
        myFrame.setSize(400, 400);
        createFileMenu();
        myFrame.setLocation(0, 0);
        leftCol = new TextArea();
        rightCol = new TextArea();
        myFrame.setVisible(true);
    }

    /**declares GUI to specific values in order to create the split screen view. Prints out the sorted and unsorted dates each in their own specific columns.*/
    public void initialize(UnsortedDateList unordered, SortedDateList ordered){
        /*declare and initialize the unorderd and ordered list of String dates 
        call the getList() method on both DateList objects to obtain all the dates*/
        String notOrdered = unordered.getList();
        String isOrdered = ordered.getList();

        /*Initialize the JFrame object. Create a title, make the frame size, the location size, the exit button.
        Create a grid in the JFrame to split it in half. One for the sorted dates one for the unsorted dates*/
        myFrame.setTitle("Unordered dates and ordered dates in a text file");
        myFrame.setSize(400, 400);
        myFrame.setLocation(200, 200);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLayout(new GridLayout(1, 2));

        /*retrive the container of the frame and store it in the variable cPane
        add the two my text areas to the container.
        TextArea a will be on the left side with the unsorted dates 
        TextArea b will be on the right side with the sorted dates*/
        cPane = myFrame.getContentPane();
        cPane.add(leftCol);
        cPane.add(rightCol);

        //Create a makeshift title for the unsorted list and sorted list by appending it to the TextArea variables
        leftCol.append("Unsorted List: " + "\n" + "\n");
        rightCol.append("Sorted List: " + "\n" + "\n");

        /*prints out the unordered dates while there is still a date left in the unordered string*/
        while(notOrdered.length() >= 8){
            //the first 8 indexes of the string represent the 1st date read by the file.
            String x = notOrdered.substring(0, 8);

            //use string manipulation to get the date into dd/mm/yyyy order and append it to the left side of the textArea and move to the next line
            x = x.substring(4, 6) + "/" + x.substring(6) + "/" + x.substring(0, 4);
            leftCol.append(x + "\n");

            //chop off the first 8 characters of the "notOrdered" string (0, 8) you just displayed by calling the substring method 
            notOrdered = notOrdered.substring(8);
        }

        /*prints out the ordered dates while there is still a date left in the isOrdered string*/
        while(isOrdered.length() >= 8){
            //the dates were sorted so that the newest date is in the front so the last 8 indexes of the string represent the oldest date we are starting with and so on
            String x = isOrdered.substring(isOrdered.length() - 8);

            //use string manipulation to get the date into dd/mm/yyyy order and append it to the right side of the textArea and move to the next line
            x = x.substring(4, 6) + "/" + x.substring(6) + "/" + x.substring(0, 4);
            rightCol.append(x + "\n");

            //chop off the last 8 characters of the isOrdered String (8, isOrdered.length()) using the substring method so now the next oldest date will be the last 8 characters again
            isOrdered = isOrdered.substring(0, isOrdered.length() - 8);
        }

        //pack the frame so it looks nice and set the visibility to true so the user can see it
        myFrame.pack();
        myFrame.setVisible(true);
    }

    /** Creates a file menu */
    public void createFileMenu() {
        //declares a JMenuItem object to add the "open" and "quit" functions to the JMenuBar object
        JMenuItem item;

        //initialize JMenuBar object to add menubar dropdown with "open" and "quit"
        JMenuBar menuBar = new JMenuBar();

        //Creates a JMenu object which creates a file tab that you click on to select a file from your directory or quit
        JMenu fileMenu = new JMenu("File");

        //creates a FileMenuHandler object which instantiates the FileMenuHandler class and creates a jframe
        FileMenuHandler fmh = new FileMenuHandler(this);

        //creates the open file function
        item = new JMenuItem("Open");

        //adds the item which has the "open" function to the jframe event fmh so when you click on it you can open up a file
        item.addActionListener(fmh);

        //adds the item containing the open function inside the file tab so when you click on it, it pops up
        fileMenu.add(item);

        //add a horizontal separator line
        fileMenu.addSeparator(); 

        //Creates the quit function
        item = new JMenuItem("Quit"); 

        //adds the item which has the "quit" function to the jframe event fmh so when you click on it, it says you quit 
        item.addActionListener(fmh);

        //adds the item containing the quit function inside the file tab so when you click on it, it pops up
        fileMenu.add(item);

        //adds the JMenuBar object containing the "open" and "quit" functions to the JFrame 
        myFrame.setJMenuBar(menuBar);

        //adds the fileMenu containing the "file" tab which has the "open" and "quit" functions to the menubar on the top left
        menuBar.add(fileMenu);
    } 
}
