package chess;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Constructor of the ChessGUI class.
 * Instantiates the frame and the panel.
 * 
 * @author Tyler Solnikowski, Kanoa Ellis,  Kayla Davis
 * @version October 19th, 2017
 */

public class ChessGUI {
   /**
    * Main method to run the Chess GUI
    * @param args 
    */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Chess Game");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ChessActions panel = new ChessActions();
		panel.setBorder(new LineBorder(Color.BLACK));
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(1280,720);
	}
}
