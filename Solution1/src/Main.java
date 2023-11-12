import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// Here's the main method where the program execution begins
		
		GUI displays = new GUI();
		displays.index();
		displays.setTitle("GeoByte Inc. Delivery Management System");
		displays.setSize(1350,770);
		displays.setLocationRelativeTo(null);
		displays.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displays.setResizable(true);
		displays.setVisible(true);
		
	}

}
