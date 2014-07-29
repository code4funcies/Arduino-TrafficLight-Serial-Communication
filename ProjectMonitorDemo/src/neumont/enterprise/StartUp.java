package neumont.enterprise;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



public class StartUp {

public StartUp(){
		SerialTest st = new SerialTest();
		createFrame(st);
	}

	public static void main(String[] args) throws Exception {
		StartUp startUp = new StartUp();	
	}
	
	
	
	
	public void createFrame( final SerialTest st){
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame jFrame = new MainFrame("Project Monitor", st);
				jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jFrame.setSize(700,500);
				jFrame.setVisible(true);
				jFrame.repaint();
			
			}
		});
		
		
	}

}
