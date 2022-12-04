import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Harshit Viren Shah
 * @author Brent Li
 */
public class Main extends JFrame {
	static Main window;
	/**
	 * Constructor for class Main which would initialize the JFrame
	 */
	Main(){
		JMenuBar menuBar=new JMenuBar();  
		JMenu fileMenu=new JMenu("File");   
		JMenuItem about = new JMenuItem("About");
        JMenuItem subMenu1=new JMenuItem("Load a Roster");
        JMenuItem subMenu2=new JMenuItem("Add Attendance");  
        JMenuItem subMenu3=new JMenuItem("Save");  
        JMenuItem subMenu4=new JMenuItem("Plot Data");
        Classroom classroom = new Classroom();
        JScrollPane scroll = new JScrollPane(classroom);
        fileMenu.add(subMenu1);
        fileMenu.add(subMenu2);
        fileMenu.add(subMenu3);
        fileMenu.add(subMenu4);
		Controller controller = new Controller(classroom);
        subMenu1.addActionListener(controller);
        subMenu2.addActionListener(controller);
        subMenu3.addActionListener(controller);
        subMenu4.addActionListener(controller);
        about.addActionListener(controller);
        
        menuBar.add(fileMenu);
        menuBar.add(about);
        add(menuBar, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}
	
	/**
	 * The Main method which is called when the project is started
	 */
	public static void main(String Args[]) {
		window = new Main();
		window.setSize(600, 550);
		window.setTitle("CSE 563: Final Project");
	}
}
