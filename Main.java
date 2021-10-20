package cen4010.pa2.Untitled;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			
			public void run() {
				new TicTacGUI();
			}
		});
       
	}

}
