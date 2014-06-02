import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.JOptionPane;
import javax.swing.text.PlainView;
import javax.swing.Icon;
import javax.swing.ImageIcon;



public class keyboardSM extends JFrame implements KeyListener ,ActionListener {
	
	private static final Font font = new Font("monospaced", Font.BOLD,20);
	private static final Font fontMenu = new Font("Times New Roman" , Font.BOLD,15);
	private JMenu menuFile,menuHelp;
	private JMenuItem menuItemExit,menuItemAbout;
	private JMenuBar menuBar;
	private ImageIcon icons;
	private JTextArea text;
	public boolean numberboolean = true;
	private Color colorred = Color.RED;
	private Color colorblack = Color.BLACK;

	
	
	String firstRow[] = {"ES","`","1","2","3","4","5","6","7","8","9","0","-","=","BS"};//BackSpace
	String secondRow[] = {"Tb","Q","W","E","R","T","Y","U","I","O","P","[","]","\\","DT"};
	String thirdRow[] = {"CL","A","S","D","F","G","H","J","K","L",":","'","ER"};
	String fourthRow[] = {"ST","Z","X","C","V","B","N","M",",",".","?","^" };
	String fifthRow[]={"CT","SP","<","\\/",">" };
	

	
	String noShift="`1234567890-=qwertyuiop[]\\asdfghjkl;'zxcvbnm,./";
	String specialChars ="~-+[]\\;',.?";
	
	
	JButton first[];
	JButton second[];
	JButton third[];
	JButton fourth[];
	JButton fifth[];
	

	
	
	
	
	
	public keyboardSM()
	{
		super("Type Tutor By SOMRAT");
		super.setFont(font);
	    icons = new ImageIcon("somrat.gif"); 
		
		
	
		menuFile =new JMenu("File");
		menuFile.setForeground(Color.WHITE);
		menuFile.setFont(fontMenu);
		menuHelp = new JMenu("Help");
		menuHelp.setFont(fontMenu);
		menuHelp.setForeground(Color.WHITE);
		menuItemExit = new JMenuItem("Exit");
		menuItemExit.setForeground(Color.white);
		menuItemExit.setBackground(Color.black);
		menuItemExit.setFont(fontMenu);
		//menuFile.setMnemonic(KeyEvent.VK_F);
		//menuHelp.setMnemonic(KeyEvent.VK_H);
		menuFile.add(menuItemExit);
		//menuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		menuItemAbout = new JMenuItem("About");
		menuItemAbout.setForeground(Color.white);
		menuItemAbout.setBackground(Color.black);
		menuItemAbout.setFont(fontMenu);
		menuHelp.add(menuItemAbout);
		
		
		menuBar = new JMenuBar();
		menuBar.add(menuFile);
		menuBar.add(menuHelp);
		menuBar.setBackground(Color.DARK_GRAY);
		setJMenuBar(menuBar);
		
		
	
		
		
		
      
		ActionListener numberListener = new NumberListener();
		menuItemExit.addActionListener(this);
	    addWindowListener(new WindowAdapter() {
	    	
	    	public void windowClosed(WindowEvent e)
	    	{
	    		System.exit(0);
	    		
	    	}
		});
	    
	    menuItemAbout.addActionListener(this);
	    
	    text = new JTextArea();
	    text.setPreferredSize(new Dimension(700,200));
	    text.setFont(font);
	    text.addKeyListener(this);
	    
	    JLabel info = new JLabel("<html>Type some text using your keyboard.The keys you press will be highlighted and text will be displayed.<br>" +
	    		"                         Note : Clicking the buttons with your mouse will not perform any action. <br><br> </html>");
	    info.setFont(font);
	    
	    
	    setLayout(new BorderLayout());
	    JPanel jpNorth = new JPanel();
	    JPanel jpCenter = new JPanel();
	    JPanel jsouth = new JPanel();
	    JPanel jeast = new JPanel();
	    JPanel jwest = new JPanel();
	    
	    
	    add(jpNorth,BorderLayout.NORTH);
	    add(jeast , BorderLayout.EAST);
	    add(jpCenter,BorderLayout.CENTER);
	    add(jwest , BorderLayout.WEST);
	    add(jsouth , BorderLayout.SOUTH);
	    
	    
	    
	    jpNorth.setLayout(new BorderLayout());
	    jpNorth.add(text,BorderLayout.NORTH);
	    
	    jpCenter.setLayout(new BorderLayout());
	    jpCenter.setLayout(new GridLayout(5,1,5,0));
	    jpCenter.setBackground(Color.DARK_GRAY);
	   
	    
	    
	    
	    first = new JButton[firstRow.length];
	    JPanel p = new JPanel(new GridLayout(1,firstRow.length));
	    for(int i=0 ; i<firstRow.length; i++)
	    {
	    	JButton b = new JButton(firstRow[i]);
	    	b.setPreferredSize(new Dimension(100,50));
	    	first[i] = b;
	    	b.setFont(font);
			b.setBackground(Color.BLACK);
			b.setForeground(Color.WHITE);
			//b.addActionListener(keylistener);
			jpCenter.setBackground(Color.DARK_GRAY);
	    	p.add(first[i]);
	    }
	    jpCenter.add(p);
	    
	    second = new JButton[secondRow.length];
	  
	    p = new JPanel(new GridLayout(1,secondRow.length));
	    for(int i=0 ; i<secondRow.length; i++)
	    {
	    	
	    	JButton b = new JButton(secondRow[i]);
	    	b.setPreferredSize(new Dimension(80,50));
	    	b.setFont(font);
			b.setBackground(Color.BLACK);
			b.setForeground(Color.WHITE);
			b.addKeyListener(this);
			jpCenter.setBackground(Color.DARK_GRAY);
	    	second[i] = b;
	    	p.add(second[i]);
	    }
	    jpCenter.add(p);
	    
	    third = new JButton[thirdRow.length];
	    p = new JPanel(new GridLayout(1,thirdRow.length));
	    for(int i=0 ; i<thirdRow.length; i++)
	    {
	    	JButton b = new JButton(thirdRow[i]);
	    	b.setPreferredSize(new Dimension(80,50));
	    	third[i] = b;
	    	b.setFont(font);
			b.setBackground(Color.BLACK);
			b.setForeground(Color.WHITE);
			//b.addActionListener(keylistener);
			jpCenter.setBackground(Color.DARK_GRAY);
	    	p.add(third[i]);
	    }
	    jpCenter.add(p);
	    
	    
	    fourth = new JButton[fourthRow.length];
	    p = new JPanel(new GridLayout(1,fourthRow.length));
	    for(int i = 0; i < fourthRow.length; ++i)
	    {
	    	
	        JButton b = new JButton(fourthRow[i]);
	        fourth[i] = b;
	        b.setFont(font);
		    b.setBackground(Color.BLACK);
			b.setForeground(Color.WHITE);
			jpCenter.setBackground(Color.DARK_GRAY);
	        p.add(fourth[i]);
	        if(i==fourthRow.length-2)
	            p.add(new JPanel());

	    }
	    p.add(new JPanel());
	    jpCenter.add(p);
	    
	    fifth = new JButton[fifthRow.length];
	    p = new JPanel(new GridLayout(1,fifthRow.length));
	    
	    	 for(int i = 0; i < fifthRow.length; ++i)
	    	    {
	    	        if(i==1) //space bar panel
	    	        {
	    	        	
	    	            JButton b = new JButton(fifthRow[i]);
	    	          //  b.setPreferredSize(new Dimension(400,10));
	    	           // b.setBounds(10, 10, 600, 100);
	    	            fifth[i]=b;
	    	            b.setFont(font);
	    				b.setBackground(Color.BLACK);
	    				b.setForeground(Color.WHITE);
	    				//b.addActionListener(keylistener);
	    				jpCenter.setBackground(Color.DARK_GRAY);
	    	            //add empty panels for layout 
	    	           // b = new JButton("             Space               ");
	    	           p.add(new JPanel());p.add(new JPanel());p.add(new JPanel());
	    	        }
	    	        else
	    	        {
	    	            JButton b=new JButton(fifthRow[i]);
	    	            fifth[i] = b;
	    	            b.setFont(font);
	    				b.setBackground(Color.BLACK);
	    				//b.addActionListener(keylistener);
	    				b.setPreferredSize(new Dimension(400,10));
	    				b.setForeground(Color.WHITE);
	    				jpCenter.setBackground(Color.DARK_GRAY);
	    	        }
	    	        if(i==0) //first black panel
	    	        {
	    	             //place a black panel at first
	    	             
	    	        	 //p.add(new JPanel());p.add(new JPanel());p.add(new JPanel());p.add(new JPanel());
	    	        }
	    	        if(i==2)
	    	        {
	    	        	p.add(new JPanel());p.add(new JPanel());p.add(new JPanel());p.add(new JPanel());p.add(new JPanel());
	    	        }
	    	        
	    	       

	    	        p.add(fifth[i]);

	    	    }
	    jpCenter.add(p);
	    
	    
	    
  KeyListener keyListener = new KeyListener() {
			
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
				} 
			
			
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				} 
			
		};
	 
		
	}

	
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char key = e.getKeyChar(); // gets the key being pressed
		 int keyvalue = e.getKeyCode();
		 key = (char)keyvalue;

		switch(key) {
		case 27:
		first[0].setBackground(colorred);
		break;
		case 192:
		first[1].setBackground(colorred);
		break;
		case '1':
		first[2].setBackground(colorred);
		break;
		case '2':
		first[3].setBackground(colorred);
		break;
		case '3':
		first[4].setBackground(colorred);
		break;
		case '4':
		first[5].setBackground(Color.red);
		break;
        case '5':
		first[6].setBackground(colorred);
		break;
		case '6':
		first[7].setBackground(colorred);
		break;
		case '7':
		first[8].setBackground(colorred);
		break;
		case '8':
		first[9].setBackground(colorred);
		break;
		case '9':
		first[10].setBackground(colorred);
		break;
     	case '0':
	    first[11].setBackground(colorred);
		break;
		case '-':
		first[12].setBackground(colorred);
		break;
		case '=' :
		first[13].setBackground(colorred);
		break;
		case '\b' :
		first[14].setBackground(colorred);
		break;
		case '\t':
		second[0].setBackground(colorred);
		break;
		case 'q':
		case 'Q':
		second[1].setBackground(colorred);
		break;
		case 'w':
		case 'W':
		second[2].setBackground(colorred);
		break;
		case 'e':
		case 'E':
		second[3].setBackground(colorred);
		break;
		case 'r':
		case 'R':
		second[4].setBackground(Color.red);
		break;
		case 't':
		case 'T':
		second[5].setBackground(colorred);
		break;
		case 'y':
		case 'Y':
		second[6].setBackground(colorred);
		break;
		case 'u':
		case 'U':
		second[7].setBackground(colorred);
		break;
		case 'i':
		case 'I':
		second[8].setBackground(colorred);
		break;
		case 'o':
		case 'O':
		second[9].setBackground(colorred);
		break;
		case 'p':
		case 'P':
		second[10].setBackground(colorred);
		break;
		case '[':
		second[11].setBackground(colorred);
		break;
		case ']' :
		second[12].setBackground(colorred);
		break;
		case '\\' :
		second[13].setBackground(colorred);
		break;
		case 127:
		second[14].setBackground(colorred);
		break;
		case 20:
		third[0].setBackground(colorred);
		break;
		case 'a':
		case 'A':
		third[1].setBackground(colorred);
		break;
		case 's':
		case 'S':
		third[2].setBackground(colorred);
		break;
		case 'd':
		case 'D':
		third[3].setBackground(colorred);
		break;
		case 'f':
		case 'F':
		third[4].setBackground(Color.red);
		break;
		case 'g':
		case 'G':
		third[5].setBackground(colorred);
		break;
		case 'h':
		case 'H':
		third[6].setBackground(colorred);
		break;
		case 'j':
		case 'J':
		third[7].setBackground(colorred);
		break;
		case 'k':
		case 'K':
		third[8].setBackground(colorred);
		break;
		case 'l':
		case 'L':
		third[9].setBackground(colorred);
		break;
		case ';':
		third[10].setBackground(colorred);
		break;
		case 222:
		third[11].setBackground(colorred);
		break;
		case '\n':
		third[12].setBackground(colorred);
		break;
		case 16:
		fourth[0].setBackground(colorred);
		break;
		case 'z':
		case 'Z':
		fourth[1].setBackground(colorred);
		break;
		case 'x':
		case 'X':
		fourth[2].setBackground(colorred);
		break;
		case 'c':
		case 'C':
		fourth[3].setBackground(colorred);
		break;
		case 'v':
		case 'V':
		fourth[4].setBackground(Color.red);
		break;
		case 'b':
		case 'B':
		fourth[5].setBackground(colorred);
		break;
		case 'n':
		case 'N':
		fourth[6].setBackground(colorred);
		break;
		case 'm':
		case 'M':
		fourth[7].setBackground(colorred);
		break;
		case ',':
		fourth[8].setBackground(colorred);
		break;
		case '.':
		fourth[9].setBackground(colorred);
		break;
		case '/':
		fourth[10].setBackground(colorred);
		break;
		case 38:
		fourth[11].setBackground(colorred);
		break;
		case 17:
		fifth[0].setBackground(colorred);
		break;
		case ' ':
		fifth[1].setBackground(colorred);
		break;
		case 37:
		fifth[2].setBackground(colorred);
		break;
		case 40:
		fifth[3].setBackground(colorred);
		break;
		case 39:
		fifth[4].setBackground(colorred);
		break;
		
		
		} 
	
	}

    



	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		char key = e.getKeyChar(); // gets the key being pressed
		int keyvalue = e.getKeyCode();
		key = (char)keyvalue;

		switch(key) {
		case 27:
		first[0].setBackground(colorblack);
		break;
		case 192:
		first[1].setBackground(colorblack);
		break;
		case '1':
		first[2].setBackground(colorblack);
		break;
		case '2':
		first[3].setBackground(colorblack);
		break;
		case '3':
		first[4].setBackground(colorblack);
		break;
		case '4':
		first[5].setBackground(colorblack);
		break;
	    case '5':
		first[6].setBackground(colorblack);
		break;
		case '6':
		first[7].setBackground(colorblack);
		break;
		case '7':
		first[8].setBackground(colorblack);
		break;
		case '8':
		first[9].setBackground(colorblack);
		break;
		case '9':
		first[10].setBackground(colorblack);
		break;
	    case '0':
		first[11].setBackground(colorblack);
		break;
		case '-':
		first[12].setBackground(colorblack);
		break;
		case '=' :
		first[13].setBackground(colorblack);
		break;
		case '\b' :
		first[14].setBackground(colorblack);
		break;
		case '\t':
		second[0].setBackground(colorblack);
		break;
		case 'Q':
		case 'q':
		second[1].setBackground(colorblack);
		break;
		case 'w':
		case 'W':
		second[2].setBackground(colorblack);
		break;
		case 'e':
		case 'E':
		second[3].setBackground(colorblack);
		break;
		case 'r':
		case 'R':
		second[4].setBackground(colorblack);
		break;
		case 't':
		case 'T':
		second[5].setBackground(colorblack);
		break;
		case 'y':
		case 'Y':
		second[6].setBackground(colorblack);
		break;
		case 'u':
		case 'U':
		second[7].setBackground(colorblack);
		break;
		case 'i':
		case 'I':
		second[8].setBackground(colorblack);
		break;
		case 'o':
		case 'O':
		second[9].setBackground(colorblack);
		break;
		case 'p':
		case 'P':
		second[10].setBackground(colorblack);
		break;
		case '[':
		second[11].setBackground(colorblack);
		break;
		case ']' :
		second[12].setBackground(colorblack);
		break;
		case '\\' :
		second[13].setBackground(colorblack);
		break;
		case 127:
		second[14].setBackground(colorblack);
		break;
		case 20:
		third[0].setBackground(colorblack);
		break;
		case 'a':
		case 'A':
		third[1].setBackground(colorblack);
		break;
		case 's':
		case 'S':
		third[2].setBackground(colorblack);
		break;
		case 'd':
		case 'D':
		third[3].setBackground(colorblack);
		break;
		case 'f':
		case 'F':
		third[4].setBackground(colorblack);
		break;
		case 'g':
		case 'G':
		third[5].setBackground(colorblack);
		break;
		case 'h':
		case 'H':
		third[6].setBackground(colorblack);
		break;
		case 'j':
		case 'J':
		third[7].setBackground(colorblack);
		break;
		case 'k':
		case 'K':
		third[8].setBackground(colorblack);
		break;
		case 'l':
		case 'L':
		third[9].setBackground(colorblack);
		break;
		case ';':
		third[10].setBackground(colorblack);
		break;
		case 222:
		third[11].setBackground(colorblack);
		break;
		case '\n':
		third[12].setBackground(colorblack);
		break;
		case 16:
		fourth[0].setBackground(colorblack);
		break;
		case 'z':
		case 'Z':
		fourth[1].setBackground(colorblack);
		break;
		case 'x':
		case 'X':
		fourth[2].setBackground(colorblack);
		break;
		case 'c':
		case 'C':
		fourth[3].setBackground(colorblack);
		break;
		case 'v':
		case 'V':
		fourth[4].setBackground(colorblack);
		break;
		case 'b':
		case 'B':
		fourth[5].setBackground(colorblack);
		break;
		case 'n':
		case 'N':
		fourth[6].setBackground(colorblack);
		break;
		case 'm':
		case 'M':
		fourth[7].setBackground(colorblack);
		break;
		case ',':
		fourth[8].setBackground(colorblack);
		break;
		case '.':
		fourth[9].setBackground(colorblack);
		break;
		case '/':
		fourth[10].setBackground(colorblack);
		break;
		case 38:
		fourth[11].setBackground(colorblack);
		break;
		case 17:
		fifth[0].setBackground(colorblack);
		break;
		case ' ':
		fifth[1].setBackground(colorblack);
		break;
		case 37:
		fifth[2].setBackground(colorblack);
		break;
		case 40:
		fifth[3].setBackground(colorblack);
		break;
		case 39:
		fifth[4].setBackground(colorblack);
		break;
		
		} 
	}





	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	

	
	
	
	public class NumberListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			String digit = event.getActionCommand();
			if(numberboolean)
			{
			   text.setText(digit);
			   numberboolean = false;
			}
			else
			{
				text.setText(text.getText() + digit);
			}
			   

		}

	}
	
	
	

	
	
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
		if(event.getSource() == menuItemExit)
			System.exit(0);
		else if(event.getSource()==menuItemAbout)
		{
			JOptionPane.showMessageDialog(null, "<html>Type some text using your keyboard.<br>The keys you press will be highlighted and text will be displayed.<br>" +
	    		"                         Note : Clicking the buttons with your mouse will not perform any action. <br><br> </html>" + "\nThis Type Tutor Desktop Based Application is one of my JAVA GUI project. \n" +
					"Version 1.0 (Buid 7600) \n" + 
					"copyright 2014 G.M.Nazmul Hossain.\n All right reserved.\n" +
					" \n\n\n" + 
					"This product is license under the NSTU-CSTE to \n"+
					"https://www.somrat.info", 
					"About Keyboard", JOptionPane.PLAIN_MESSAGE, icons);
			
		}
		
		
	
	}
	
}
