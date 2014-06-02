import javax.swing.JFrame;

public class KeyboardMM {
	public static void main(String args[])
	{
		keyboardSM application = new keyboardSM();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(900,500);
        application.setLocation(150,100);
		application.setResizable(false);
	    application.setVisible(true);
	}

}
