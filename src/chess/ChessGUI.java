package chess;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/***********************************************************************
 * Constructor of the ChessGui class. Instantiates the frame and the panel.
 **********************************************************************/

public class ChessGUI {

	public static void main(final String[] args) {
		JFrame frame = new JFrame("Chess Game");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ChessActions panel = new ChessActions();
		panel.setBorder(new LineBorder(Color.BLACK));
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(1280, 720);
	}
} 
