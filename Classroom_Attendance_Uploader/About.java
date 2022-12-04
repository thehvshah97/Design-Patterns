import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class shows the Dialog Box which has the information about the team mates
 * 
 * @author Harshit Viren Shah
 * 
 */
public class About extends JFrame{
	/**
	 * Constructor for class About which would create a JFrame
	 */
	About(){
		JPanel panel = new JPanel();
		JLabel label = new JLabel("<html>Harshit Viren Shah: hshah78@asu.edu<br/>Brent Li: btli1@asu.edu<br/>Ishrar Zaman: izaman1@asu.edu<br/>Jnani Sunkavalli:jsunkava@asu.edu<br/>Nicole Diana Fernandes:nferna18@asu.edu<br/>Raj Amrit Singh:rsing168@asu.edu</html>");
        panel.add(label);
        add(panel);
	}

}
